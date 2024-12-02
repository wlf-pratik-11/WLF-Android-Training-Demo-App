package com.example.wscube1.LoadImageNetworkAndGallaryDemo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.canhub.cropper.CropImage;
import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.wscube1.databinding.ActivityLoadImageNetworkAndGallaryBinding;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class LoadImageNetworkAndGallaryActivity extends AppCompatActivity {
    private final static String TAG = "LoadImageNetworkAndGallaryActivity";
    private AppBarConfiguration appBarConfiguration;
    private ActivityLoadImageNetworkAndGallaryBinding binding;

    private final int CAMERA_REQ_CODE = 100, GALLERY_REQ_CODE = 200;
    private static final String myURL = "https://cdn.pixabay.com/photo/2023/04/21/15/04/eagle-7942058_1280.jpg";
    ImageView img1, imageView;
    Button getImage;
    Uri sourceUri, destinationUri;
    Uri uri;

    ActivityResultLauncher<String> cropImage;

    private static final int CAMERA_PERMISSION_CODE = 101;
    private static final int STORAGE_PERMISSION_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoadImageNetworkAndGallaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageView = findViewById(R.id.imageView);
        getImage = findViewById(R.id.getImage);

        //region Network Image Load
        img1 = findViewById(R.id.img1);
        Glide.with(this).load(myURL).into(img1);
        //endregion

        //region Load Image from Gallery and Camera
        getImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBottomSheet();
            }
        });
        //endregion

        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Load Image Demo", true);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        UCrop.Options options = new UCrop.Options();
        options.setFreeStyleCropEnabled(true);
        options.setCropGridColumnCount(2);
        options.setCropGridRowCount(2);

        if (resultCode != RESULT_OK || data == null) {
            return;
        }

        try {
            Uri sourceUri = null;

            if (requestCode == CAMERA_REQ_CODE) {
                // Handle camera image
                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                if (bmp != null) {
                    sourceUri = Uri.parse(MediaStore.Images.Media.insertImage(
                            getContentResolver(), bmp, "CapturedImage", null));
                }
            } else if (requestCode == GALLERY_REQ_CODE) {
                // Handle gallery image
                sourceUri = data.getData();
            }

            if (sourceUri != null) {
                // Set up destination Uri
                File destinationFile = new File(getCacheDir(), "cropped_image.jpg");
                Uri destinationUri = Uri.fromFile(destinationFile);

                // Start UCrop for cropping
                UCrop.of(sourceUri, destinationUri)
                        .withAspectRatio(9, 16)
                        .withMaxResultSize(
                                getWindowManager().getDefaultDisplay().getWidth(),
                                getWindowManager().getDefaultDisplay().getHeight()).withOptions(options)
                        .start(this);
            } else if (requestCode == UCrop.REQUEST_CROP) {
                // Handle cropped image
                Uri resultUri = UCrop.getOutput(data);
                if (resultUri != null) {
                    Bitmap croppedBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), resultUri);
                    imageView.setImageBitmap(croppedBitmap); // Display cropped image
                }
            } else if (requestCode == UCrop.RESULT_ERROR) {
                // Handle UCrop error
                Throwable cropError = UCrop.getError(data);
            }
        } catch (Exception e) {
            // Handle general exception
        }
    }

    //endregion

    //region Bottom Sheet
    void openBottomSheet() {
        BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
        sheetDialog.setContentView(R.layout.bottom_sheet_lauout);
        Button camera = sheetDialog.findViewById(R.id.camera);
        Button gallery = sheetDialog.findViewById(R.id.gallery);

        if (camera != null) {
            camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkAndRequestPermissions(android.Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)) {
                        Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(iCamera, CAMERA_REQ_CODE);
                    }
                    sheetDialog.dismiss();
                }
            });
        }

        if (gallery != null) {
            gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkAndRequestPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE)) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, GALLERY_REQ_CODE);
                    }
                    sheetDialog.dismiss();
                }
            });
        }
        sheetDialog.show();
    }
    //endregion

    //region Permission Handling
    private boolean checkAndRequestPermissions(String permission, int requestCode) {
        Log.d(TAG, "Cheack Permission" + checkSelfPermission(permission));

        if (checkSelfPermission(permission) == PackageManager.PERMISSION_DENIED) {
            // Request permission
            try {
                requestPermissions(new String[]{Manifest.permission.READ_MEDIA_IMAGES,Manifest.permission.READ_MEDIA_VIDEO}, requestCode);
            } catch (Exception e) {
                Log.d(TAG, "Check Permission Exeption");
            }
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera, CAMERA_REQ_CODE);
            } else {
                Snackbar.make(findViewById(android.R.id.content), "Camera permission is required", Snackbar.LENGTH_SHORT).show();
            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            Log.d(TAG, "Grant Permissions" + grantResults[0]);
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALLERY_REQ_CODE);
            } else {
                Snackbar.make(findViewById(android.R.id.content), "Storage permission is required", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    //endregion

}
