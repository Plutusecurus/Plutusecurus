// Generated by view binder compiler. Do not edit!
package com.example.plutusecurus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.plutusecurus.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView addImage;

  @NonNull
  public final ImageView backButton;

  @NonNull
  public final CardView changePass;

  @NonNull
  public final CardView logout;

  @NonNull
  public final TextView logoutBtn;

  @NonNull
  public final ImageView myQr;

  @NonNull
  public final TextView profileNameUsername;

  @NonNull
  public final CardView profilePicCard;

  @NonNull
  public final ImageView profilePicOfProfile;

  @NonNull
  public final TextView useridOfProfile;

  private ActivityProfileBinding(@NonNull ConstraintLayout rootView, @NonNull CardView addImage,
      @NonNull ImageView backButton, @NonNull CardView changePass, @NonNull CardView logout,
      @NonNull TextView logoutBtn, @NonNull ImageView myQr, @NonNull TextView profileNameUsername,
      @NonNull CardView profilePicCard, @NonNull ImageView profilePicOfProfile,
      @NonNull TextView useridOfProfile) {
    this.rootView = rootView;
    this.addImage = addImage;
    this.backButton = backButton;
    this.changePass = changePass;
    this.logout = logout;
    this.logoutBtn = logoutBtn;
    this.myQr = myQr;
    this.profileNameUsername = profileNameUsername;
    this.profilePicCard = profilePicCard;
    this.profilePicOfProfile = profilePicOfProfile;
    this.useridOfProfile = useridOfProfile;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_image;
      CardView addImage = ViewBindings.findChildViewById(rootView, id);
      if (addImage == null) {
        break missingId;
      }

      id = R.id.back_button;
      ImageView backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.change_pass;
      CardView changePass = ViewBindings.findChildViewById(rootView, id);
      if (changePass == null) {
        break missingId;
      }

      id = R.id.logout;
      CardView logout = ViewBindings.findChildViewById(rootView, id);
      if (logout == null) {
        break missingId;
      }

      id = R.id.logout_btn;
      TextView logoutBtn = ViewBindings.findChildViewById(rootView, id);
      if (logoutBtn == null) {
        break missingId;
      }

      id = R.id.my_qr;
      ImageView myQr = ViewBindings.findChildViewById(rootView, id);
      if (myQr == null) {
        break missingId;
      }

      id = R.id.profile_name_username;
      TextView profileNameUsername = ViewBindings.findChildViewById(rootView, id);
      if (profileNameUsername == null) {
        break missingId;
      }

      id = R.id.profile_pic_card;
      CardView profilePicCard = ViewBindings.findChildViewById(rootView, id);
      if (profilePicCard == null) {
        break missingId;
      }

      id = R.id.profile_pic_of_profile;
      ImageView profilePicOfProfile = ViewBindings.findChildViewById(rootView, id);
      if (profilePicOfProfile == null) {
        break missingId;
      }

      id = R.id.userid_of_profile;
      TextView useridOfProfile = ViewBindings.findChildViewById(rootView, id);
      if (useridOfProfile == null) {
        break missingId;
      }

      return new ActivityProfileBinding((ConstraintLayout) rootView, addImage, backButton,
          changePass, logout, logoutBtn, myQr, profileNameUsername, profilePicCard,
          profilePicOfProfile, useridOfProfile);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}