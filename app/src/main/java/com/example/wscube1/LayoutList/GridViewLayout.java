package com.example.wscube1.LayoutList;

import android.os.Bundle;

import com.example.wscube1.common.CommonFunctions;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.GridView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wscube1.databinding.ActivityGridViewLayoutBinding;

import com.example.wscube1.R;

import java.util.ArrayList;

public class GridViewLayout extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGridViewLayoutBinding binding;

    GridView coursesGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGridViewLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),"GridView Layout Demo",true);

        coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.download));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.download));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.download));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.download));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.download));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.download));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.download));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);

    }

}