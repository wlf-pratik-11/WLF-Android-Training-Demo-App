package com.example.wscube1.GoogleMap;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wscube1.databinding.ActivityGoogleMapBinding;
import com.example.wscube1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GoogleMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ActivityGoogleMapBinding binding;

    TextView addressTV;
    ImageView static_marker;
    SearchView searchView;
    FloatingActionButton getCurruntPosition;

    private int REQUEST_LOCATION = 99;

    private LocationManager locationManager;
    private GoogleMap mMap;

    String cityName = "";
    String stateName = "";
    String countryName = "";
    String postalCode = "";

    Double lat = 0.0;
    Double lon = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoogleMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addressTV = findViewById(R.id.addressTV);
        getCurruntPosition = findViewById(R.id.getCurruntPosition);
        static_marker = findViewById(R.id.static_marker);
        searchView = findViewById(R.id.searchView);

        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Google Map Demo", true);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Check and request location permissions
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(GoogleMapActivity.this, new String[]{ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                static_marker.setVisibility(View.GONE);
                String searchingLocation = searchView.getQuery().toString();
                List<Address> addressList = null;

                if(searchingLocation !=null){
                    Geocoder geocoder = new Geocoder(GoogleMapActivity.this);
                    try {
                        addressList = geocoder.getFromLocationName(searchingLocation,1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title(searchingLocation));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15f));
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Static marker logic (ImageView is already in XML layout)
        ImageView staticMarker = findViewById(R.id.static_marker);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Check location permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // Get the last known location
        Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (lastLocation != null) {
            lat = lastLocation.getLatitude();
            lon = lastLocation.getLongitude();
            LatLng initialLatLng = new LatLng(lat, lon);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLatLng, 15f));
        }

        getCurruntPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                static_marker.setVisibility(View.GONE);
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_FINE);   //default
                criteria.setCostAllowed(false);
                // get the best provider depending on the criteria
                String provider = locationManager.getBestProvider(criteria, false);

                if ((ActivityCompat.checkSelfPermission(GoogleMapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(GoogleMapActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Location currentlocation = locationManager.getLastKnownLocation(provider);
                lat = currentlocation.getLatitude();
                lon = currentlocation.getLongitude();
                LatLng initialLatLng = new LatLng(lat, lon);
                mMap.addMarker(new MarkerOptions().position(initialLatLng));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLatLng, 15f));

            }
        });


        // Add a listener to get the camera's center position
        mMap.setOnCameraIdleListener(() -> {
            LatLng centerLatLng = mMap.getCameraPosition().target;

            // Get address using Geocoder
            Geocoder geocoder = new Geocoder(GoogleMapActivity.this, Locale.getDefault());
            try {
                List<Address> addresses = geocoder.getFromLocation(centerLatLng.latitude, centerLatLng.longitude, 1);
                if (!addresses.isEmpty()) {
                    Address address = addresses.get(0);
                    cityName = address.getLocality();
                    stateName = address.getAdminArea();
                    countryName = address.getCountryName();
                    postalCode = address.getPostalCode();

                    addressTV.setText("City: " + cityName + ", State: " + stateName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
