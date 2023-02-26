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
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.plutusecurus.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWalletBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final TextView balance;

  @NonNull
  public final CardView balanceCard;

  @NonNull
  public final RecyclerView historyRecyclerView;

  @NonNull
  public final TextView historyTxt;

  @NonNull
  public final TextView pay;

  @NonNull
  public final CardView payButton;

  @NonNull
  public final TextView profileNameUsername;

  @NonNull
  public final CardView profilePicCard;

  @NonNull
  public final ImageView profilePicture;

  @NonNull
  public final ImageView qrButton;

  @NonNull
  public final TextView useridOfUser;

  private FragmentWalletBinding(@NonNull NestedScrollView rootView, @NonNull TextView balance,
      @NonNull CardView balanceCard, @NonNull RecyclerView historyRecyclerView,
      @NonNull TextView historyTxt, @NonNull TextView pay, @NonNull CardView payButton,
      @NonNull TextView profileNameUsername, @NonNull CardView profilePicCard,
      @NonNull ImageView profilePicture, @NonNull ImageView qrButton,
      @NonNull TextView useridOfUser) {
    this.rootView = rootView;
    this.balance = balance;
    this.balanceCard = balanceCard;
    this.historyRecyclerView = historyRecyclerView;
    this.historyTxt = historyTxt;
    this.pay = pay;
    this.payButton = payButton;
    this.profileNameUsername = profileNameUsername;
    this.profilePicCard = profilePicCard;
    this.profilePicture = profilePicture;
    this.qrButton = qrButton;
    this.useridOfUser = useridOfUser;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_wallet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWalletBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.balance;
      TextView balance = ViewBindings.findChildViewById(rootView, id);
      if (balance == null) {
        break missingId;
      }

      id = R.id.balance_card;
      CardView balanceCard = ViewBindings.findChildViewById(rootView, id);
      if (balanceCard == null) {
        break missingId;
      }

      id = R.id.historyRecyclerView;
      RecyclerView historyRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (historyRecyclerView == null) {
        break missingId;
      }

      id = R.id.history_txt;
      TextView historyTxt = ViewBindings.findChildViewById(rootView, id);
      if (historyTxt == null) {
        break missingId;
      }

      id = R.id.pay;
      TextView pay = ViewBindings.findChildViewById(rootView, id);
      if (pay == null) {
        break missingId;
      }

      id = R.id.pay_button;
      CardView payButton = ViewBindings.findChildViewById(rootView, id);
      if (payButton == null) {
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

      id = R.id.profile_picture;
      ImageView profilePicture = ViewBindings.findChildViewById(rootView, id);
      if (profilePicture == null) {
        break missingId;
      }

      id = R.id.qr_button;
      ImageView qrButton = ViewBindings.findChildViewById(rootView, id);
      if (qrButton == null) {
        break missingId;
      }

      id = R.id.userid_of_user;
      TextView useridOfUser = ViewBindings.findChildViewById(rootView, id);
      if (useridOfUser == null) {
        break missingId;
      }

      return new FragmentWalletBinding((NestedScrollView) rootView, balance, balanceCard,
          historyRecyclerView, historyTxt, pay, payButton, profileNameUsername, profilePicCard,
          profilePicture, qrButton, useridOfUser);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
