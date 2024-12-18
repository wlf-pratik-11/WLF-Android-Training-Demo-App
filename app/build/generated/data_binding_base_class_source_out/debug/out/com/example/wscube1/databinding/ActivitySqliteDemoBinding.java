// Generated by view binder compiler. Do not edit!
package com.example.wscube1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

public final class ActivitySqliteDemoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final FloatingActionButton addContact;

  @NonNull
  public final RecyclerView contactListView;

  private ActivitySqliteDemoBinding(@NonNull LinearLayout rootView,
      @NonNull FloatingActionButton addContact, @NonNull RecyclerView contactListView) {
    this.rootView = rootView;
    this.addContact = addContact;
    this.contactListView = contactListView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySqliteDemoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySqliteDemoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sqlite_demo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySqliteDemoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addContact;
      FloatingActionButton addContact = ViewBindings.findChildViewById(rootView, id);
      if (addContact == null) {
        break missingId;
      }

      id = R.id.contactListView;
      RecyclerView contactListView = ViewBindings.findChildViewById(rootView, id);
      if (contactListView == null) {
        break missingId;
      }

      return new ActivitySqliteDemoBinding((LinearLayout) rootView, addContact, contactListView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
