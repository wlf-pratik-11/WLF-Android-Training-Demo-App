// Generated by view binder compiler. Do not edit!
package com.example.wscube1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.wscube1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView idIVcourse;

  @NonNull
  public final TextView idTVCourse;

  private CardItemBinding(@NonNull CardView rootView, @NonNull ImageView idIVcourse,
      @NonNull TextView idTVCourse) {
    this.rootView = rootView;
    this.idIVcourse = idIVcourse;
    this.idTVCourse = idTVCourse;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.idIVcourse;
      ImageView idIVcourse = ViewBindings.findChildViewById(rootView, id);
      if (idIVcourse == null) {
        break missingId;
      }

      id = R.id.idTVCourse;
      TextView idTVCourse = ViewBindings.findChildViewById(rootView, id);
      if (idTVCourse == null) {
        break missingId;
      }

      return new CardItemBinding((CardView) rootView, idIVcourse, idTVCourse);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
