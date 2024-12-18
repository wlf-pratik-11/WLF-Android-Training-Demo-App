// Generated by view binder compiler. Do not edit!
package com.example.wscube1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.wscube1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDateAndTimeDemoBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final TextView dateTimeLongValue;

  @NonNull
  public final TextView format1;

  @NonNull
  public final TextView format2;

  @NonNull
  public final TextView format3;

  @NonNull
  public final TextView format4;

  @NonNull
  public final TextView format5;

  @NonNull
  public final TextView format6;

  @NonNull
  public final TextView format7;

  @NonNull
  public final TextView textView;

  private ActivityDateAndTimeDemoBinding(@NonNull CoordinatorLayout rootView,
      @NonNull TextView dateTimeLongValue, @NonNull TextView format1, @NonNull TextView format2,
      @NonNull TextView format3, @NonNull TextView format4, @NonNull TextView format5,
      @NonNull TextView format6, @NonNull TextView format7, @NonNull TextView textView) {
    this.rootView = rootView;
    this.dateTimeLongValue = dateTimeLongValue;
    this.format1 = format1;
    this.format2 = format2;
    this.format3 = format3;
    this.format4 = format4;
    this.format5 = format5;
    this.format6 = format6;
    this.format7 = format7;
    this.textView = textView;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDateAndTimeDemoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDateAndTimeDemoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_date_and_time_demo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDateAndTimeDemoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dateTimeLongValue;
      TextView dateTimeLongValue = ViewBindings.findChildViewById(rootView, id);
      if (dateTimeLongValue == null) {
        break missingId;
      }

      id = R.id.format1;
      TextView format1 = ViewBindings.findChildViewById(rootView, id);
      if (format1 == null) {
        break missingId;
      }

      id = R.id.format2;
      TextView format2 = ViewBindings.findChildViewById(rootView, id);
      if (format2 == null) {
        break missingId;
      }

      id = R.id.format3;
      TextView format3 = ViewBindings.findChildViewById(rootView, id);
      if (format3 == null) {
        break missingId;
      }

      id = R.id.format4;
      TextView format4 = ViewBindings.findChildViewById(rootView, id);
      if (format4 == null) {
        break missingId;
      }

      id = R.id.format5;
      TextView format5 = ViewBindings.findChildViewById(rootView, id);
      if (format5 == null) {
        break missingId;
      }

      id = R.id.format6;
      TextView format6 = ViewBindings.findChildViewById(rootView, id);
      if (format6 == null) {
        break missingId;
      }

      id = R.id.format7;
      TextView format7 = ViewBindings.findChildViewById(rootView, id);
      if (format7 == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityDateAndTimeDemoBinding((CoordinatorLayout) rootView, dateTimeLongValue,
          format1, format2, format3, format4, format5, format6, format7, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
