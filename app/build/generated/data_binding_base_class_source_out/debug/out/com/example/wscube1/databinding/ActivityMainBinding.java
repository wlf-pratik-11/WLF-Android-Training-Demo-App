// Generated by view binder compiler. Do not edit!
package com.example.wscube1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.wscube1.R;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final TextView mainEmail;

  @NonNull
  public final TextView mainName;

  @NonNull
  public final NavigationView navView;

  @NonNull
  public final NavigationView navViewMenuItems;

  private ActivityMainBinding(@NonNull CoordinatorLayout rootView,
      @NonNull DrawerLayout drawerLayout, @NonNull TextView mainEmail, @NonNull TextView mainName,
      @NonNull NavigationView navView, @NonNull NavigationView navViewMenuItems) {
    this.rootView = rootView;
    this.drawerLayout = drawerLayout;
    this.mainEmail = mainEmail;
    this.mainName = mainName;
    this.navView = navView;
    this.navViewMenuItems = navViewMenuItems;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.drawerLayout;
      DrawerLayout drawerLayout = ViewBindings.findChildViewById(rootView, id);
      if (drawerLayout == null) {
        break missingId;
      }

      id = R.id.mainEmail;
      TextView mainEmail = ViewBindings.findChildViewById(rootView, id);
      if (mainEmail == null) {
        break missingId;
      }

      id = R.id.mainName;
      TextView mainName = ViewBindings.findChildViewById(rootView, id);
      if (mainName == null) {
        break missingId;
      }

      id = R.id.navView;
      NavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      id = R.id.navViewMenuItems;
      NavigationView navViewMenuItems = ViewBindings.findChildViewById(rootView, id);
      if (navViewMenuItems == null) {
        break missingId;
      }

      return new ActivityMainBinding((CoordinatorLayout) rootView, drawerLayout, mainEmail,
          mainName, navView, navViewMenuItems);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}