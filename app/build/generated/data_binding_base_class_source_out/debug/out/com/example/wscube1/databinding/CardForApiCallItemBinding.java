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

public final class CardForApiCallItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cardForApiCAllWithShimmer;

  @NonNull
  public final TextView userBirthDate;

  @NonNull
  public final TextView userCity;

  @NonNull
  public final TextView userEmail;

  @NonNull
  public final ImageView userImg;

  @NonNull
  public final TextView userName;

  @NonNull
  public final TextView userNumber;

  private CardForApiCallItemBinding(@NonNull CardView rootView,
      @NonNull CardView cardForApiCAllWithShimmer, @NonNull TextView userBirthDate,
      @NonNull TextView userCity, @NonNull TextView userEmail, @NonNull ImageView userImg,
      @NonNull TextView userName, @NonNull TextView userNumber) {
    this.rootView = rootView;
    this.cardForApiCAllWithShimmer = cardForApiCAllWithShimmer;
    this.userBirthDate = userBirthDate;
    this.userCity = userCity;
    this.userEmail = userEmail;
    this.userImg = userImg;
    this.userName = userName;
    this.userNumber = userNumber;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardForApiCallItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardForApiCallItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_for_api_call_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardForApiCallItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cardForApiCAllWithShimmer = (CardView) rootView;

      id = R.id.userBirthDate;
      TextView userBirthDate = ViewBindings.findChildViewById(rootView, id);
      if (userBirthDate == null) {
        break missingId;
      }

      id = R.id.userCity;
      TextView userCity = ViewBindings.findChildViewById(rootView, id);
      if (userCity == null) {
        break missingId;
      }

      id = R.id.userEmail;
      TextView userEmail = ViewBindings.findChildViewById(rootView, id);
      if (userEmail == null) {
        break missingId;
      }

      id = R.id.userImg;
      ImageView userImg = ViewBindings.findChildViewById(rootView, id);
      if (userImg == null) {
        break missingId;
      }

      id = R.id.userName;
      TextView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      id = R.id.userNumber;
      TextView userNumber = ViewBindings.findChildViewById(rootView, id);
      if (userNumber == null) {
        break missingId;
      }

      return new CardForApiCallItemBinding((CardView) rootView, cardForApiCAllWithShimmer,
          userBirthDate, userCity, userEmail, userImg, userName, userNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
