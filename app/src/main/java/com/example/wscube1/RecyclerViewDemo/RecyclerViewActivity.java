package com.example.wscube1.RecyclerViewDemo;

import android.os.Bundle;

import com.example.wscube1.R;
import com.example.wscube1.common.CommonFunctions;
import com.example.wscube1.common.ContactModel;
import com.example.wscube1.common.RecyclerViewAdapter;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wscube1.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.Map;

public class RecyclerViewActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRecyclerViewBinding binding;

    RecyclerView recyclerViewLayout;
    ArrayList<ContactModel> getDummyData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerViewLayout = binding.recyclerViewLayout;

        //ToolBar
        CommonFunctions.appBarAndStatusBarThemeChange(this, this, getWindow(), "Recycler View Demo", true);

        recyclerViewLayout.setLayoutManager(new LinearLayoutManager(this));

//        ContactModel jsonExample = new ContactModel(Map.of("name","Leta Derycot","img","http://dummyimage.com/188x120.png/ff4444/ffffff","contact","984-784-7094"));

        //region DATA
        ContactModel[] myDummyList = new ContactModel[]{
//                new ContactModel(jsonExample.toJson()),
               new ContactModel( "Leta Derycot","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "984-784-7094"),
               new ContactModel( "Leighton McAleese","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "288-422-6577"),
               new ContactModel( "Wylma Ollcott","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "921-970-7669"),
               new ContactModel( "Horace Decort","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "758-470-5637"),
               new ContactModel( "Giuditta Dakhov","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "681-997-2934"),
               new ContactModel( "Bessie Glaister","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "735-820-5398"),
               new ContactModel( "Janina Nuttey","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "597-546-4441"),
               new ContactModel( "Roselin Gilbody","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "420-627-6818"),
               new ContactModel( "Merell Fayre","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "548-689-6051"),
               new ContactModel( "Kirby Estick","https://png.pngtree.com/png-vector/20231015/ourmid/pngtree-3d-character-illustrator-standing-pose-png-image_10161392.png", "858-131-8481"),
        };

        //endregion


        new ContactModel(Map.of("name","Leta Derycot","img","http://dummyimage.com/188x120.png/ff4444/ffffff","contact","984-784-7094"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, myDummyList);

        recyclerViewLayout.setAdapter(adapter);


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_recycler_view);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}