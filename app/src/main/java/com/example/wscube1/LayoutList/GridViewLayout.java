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
        CommonFunctions.appBarAndStatusBarThemeChange(this,this,getWindow(),getString(R.string.gridview_layout_demo),true);

        coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_java), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_dsa), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_cpp), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_python), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_javascript), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_java), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_dsa), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_python), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_javascript), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_java), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_dsa), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_javascript), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_python), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_java), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_dsa), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_javascript), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_java), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_python), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_dsa), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_java), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_javascript), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_python), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_dsa), R.drawable.download));
        courseModelArrayList.add(new CourseModel(getString(R.string.course_name_java), R.drawable.download));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);

    }

}