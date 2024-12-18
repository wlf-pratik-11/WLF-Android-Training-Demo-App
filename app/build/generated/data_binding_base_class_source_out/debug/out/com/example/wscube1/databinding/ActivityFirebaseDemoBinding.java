// Generated by view binder compiler. Do not edit!
package com.example.wscube1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.wscube1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFirebaseDemoBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton addCourceFloatingButton;

  @NonNull
  public final RelativeLayout firebaseDemoMainLayout;

  @NonNull
  public final ProgressBar mainProgressBar;

  @NonNull
  public final RecyclerView rcvForCource;

  private ActivityFirebaseDemoBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton addCourceFloatingButton,
      @NonNull RelativeLayout firebaseDemoMainLayout, @NonNull ProgressBar mainProgressBar,
      @NonNull RecyclerView rcvForCource) {
    this.rootView = rootView;
    this.addCourceFloatingButton = addCourceFloatingButton;
    this.firebaseDemoMainLayout = firebaseDemoMainLayout;
    this.mainProgressBar = mainProgressBar;
    this.rcvForCource = rcvForCource;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFirebaseDemoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFirebaseDemoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_firebase_demo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFirebaseDemoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addCourceFloatingButton;
      FloatingActionButton addCourceFloatingButton = ViewBindings.findChildViewById(rootView, id);
      if (addCourceFloatingButton == null) {
        break missingId;
      }

      RelativeLayout firebaseDemoMainLayout = (RelativeLayout) rootView;

      id = R.id.mainProgressBar;
      ProgressBar mainProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (mainProgressBar == null) {
        break missingId;
      }

      id = R.id.rcvForCource;
      RecyclerView rcvForCource = ViewBindings.findChildViewById(rootView, id);
      if (rcvForCource == null) {
        break missingId;
      }

      return new ActivityFirebaseDemoBinding((RelativeLayout) rootView, addCourceFloatingButton,
          firebaseDemoMainLayout, mainProgressBar, rcvForCource);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
