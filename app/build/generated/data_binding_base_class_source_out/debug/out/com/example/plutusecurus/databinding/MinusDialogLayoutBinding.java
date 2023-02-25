// Generated by view binder compiler. Do not edit!
package com.example.plutusecurus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.plutusecurus.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MinusDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final CardView amountCard;

  @NonNull
  public final TextView cancelButton;

  @NonNull
  public final ImageView entertainment;

  @NonNull
  public final CardView entertainmentButton;

  @NonNull
  public final TextView entertainmentText;

  @NonNull
  public final ImageView essentials;

  @NonNull
  public final CardView essentialsButton;

  @NonNull
  public final TextView essentialsText;

  @NonNull
  public final ImageView food;

  @NonNull
  public final CardView foodButton;

  @NonNull
  public final TextView foodText;

  @NonNull
  public final ImageView gift;

  @NonNull
  public final CardView giftButton;

  @NonNull
  public final TextView giftText;

  @NonNull
  public final ImageView house;

  @NonNull
  public final CardView houseButton;

  @NonNull
  public final TextView housingText;

  @NonNull
  public final ImageView medicine;

  @NonNull
  public final CardView medicineButton;

  @NonNull
  public final TextView medicineText;

  @NonNull
  public final ImageView miscellaneous;

  @NonNull
  public final CardView miscellaneousButton;

  @NonNull
  public final TextView miscellaneousText;

  @NonNull
  public final EditText moneySpend;

  @NonNull
  public final TextView okButton;

  @NonNull
  public final TextView selectCategoryText;

  @NonNull
  public final ImageView transport;

  @NonNull
  public final CardView transportButton;

  @NonNull
  public final TextView transportText;

  private MinusDialogLayoutBinding(@NonNull RelativeLayout rootView, @NonNull CardView amountCard,
      @NonNull TextView cancelButton, @NonNull ImageView entertainment,
      @NonNull CardView entertainmentButton, @NonNull TextView entertainmentText,
      @NonNull ImageView essentials, @NonNull CardView essentialsButton,
      @NonNull TextView essentialsText, @NonNull ImageView food, @NonNull CardView foodButton,
      @NonNull TextView foodText, @NonNull ImageView gift, @NonNull CardView giftButton,
      @NonNull TextView giftText, @NonNull ImageView house, @NonNull CardView houseButton,
      @NonNull TextView housingText, @NonNull ImageView medicine, @NonNull CardView medicineButton,
      @NonNull TextView medicineText, @NonNull ImageView miscellaneous,
      @NonNull CardView miscellaneousButton, @NonNull TextView miscellaneousText,
      @NonNull EditText moneySpend, @NonNull TextView okButton,
      @NonNull TextView selectCategoryText, @NonNull ImageView transport,
      @NonNull CardView transportButton, @NonNull TextView transportText) {
    this.rootView = rootView;
    this.amountCard = amountCard;
    this.cancelButton = cancelButton;
    this.entertainment = entertainment;
    this.entertainmentButton = entertainmentButton;
    this.entertainmentText = entertainmentText;
    this.essentials = essentials;
    this.essentialsButton = essentialsButton;
    this.essentialsText = essentialsText;
    this.food = food;
    this.foodButton = foodButton;
    this.foodText = foodText;
    this.gift = gift;
    this.giftButton = giftButton;
    this.giftText = giftText;
    this.house = house;
    this.houseButton = houseButton;
    this.housingText = housingText;
    this.medicine = medicine;
    this.medicineButton = medicineButton;
    this.medicineText = medicineText;
    this.miscellaneous = miscellaneous;
    this.miscellaneousButton = miscellaneousButton;
    this.miscellaneousText = miscellaneousText;
    this.moneySpend = moneySpend;
    this.okButton = okButton;
    this.selectCategoryText = selectCategoryText;
    this.transport = transport;
    this.transportButton = transportButton;
    this.transportText = transportText;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MinusDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MinusDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.minus_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MinusDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.amount_card;
      CardView amountCard = ViewBindings.findChildViewById(rootView, id);
      if (amountCard == null) {
        break missingId;
      }

      id = R.id.cancel_button;
      TextView cancelButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelButton == null) {
        break missingId;
      }

      id = R.id.entertainment;
      ImageView entertainment = ViewBindings.findChildViewById(rootView, id);
      if (entertainment == null) {
        break missingId;
      }

      id = R.id.entertainment_button;
      CardView entertainmentButton = ViewBindings.findChildViewById(rootView, id);
      if (entertainmentButton == null) {
        break missingId;
      }

      id = R.id.entertainment_text;
      TextView entertainmentText = ViewBindings.findChildViewById(rootView, id);
      if (entertainmentText == null) {
        break missingId;
      }

      id = R.id.essentials;
      ImageView essentials = ViewBindings.findChildViewById(rootView, id);
      if (essentials == null) {
        break missingId;
      }

      id = R.id.essentials_button;
      CardView essentialsButton = ViewBindings.findChildViewById(rootView, id);
      if (essentialsButton == null) {
        break missingId;
      }

      id = R.id.essentials_text;
      TextView essentialsText = ViewBindings.findChildViewById(rootView, id);
      if (essentialsText == null) {
        break missingId;
      }

      id = R.id.food;
      ImageView food = ViewBindings.findChildViewById(rootView, id);
      if (food == null) {
        break missingId;
      }

      id = R.id.food_button;
      CardView foodButton = ViewBindings.findChildViewById(rootView, id);
      if (foodButton == null) {
        break missingId;
      }

      id = R.id.food_text;
      TextView foodText = ViewBindings.findChildViewById(rootView, id);
      if (foodText == null) {
        break missingId;
      }

      id = R.id.gift;
      ImageView gift = ViewBindings.findChildViewById(rootView, id);
      if (gift == null) {
        break missingId;
      }

      id = R.id.gift_button;
      CardView giftButton = ViewBindings.findChildViewById(rootView, id);
      if (giftButton == null) {
        break missingId;
      }

      id = R.id.gift_text;
      TextView giftText = ViewBindings.findChildViewById(rootView, id);
      if (giftText == null) {
        break missingId;
      }

      id = R.id.house;
      ImageView house = ViewBindings.findChildViewById(rootView, id);
      if (house == null) {
        break missingId;
      }

      id = R.id.house_button;
      CardView houseButton = ViewBindings.findChildViewById(rootView, id);
      if (houseButton == null) {
        break missingId;
      }

      id = R.id.housing_text;
      TextView housingText = ViewBindings.findChildViewById(rootView, id);
      if (housingText == null) {
        break missingId;
      }

      id = R.id.medicine;
      ImageView medicine = ViewBindings.findChildViewById(rootView, id);
      if (medicine == null) {
        break missingId;
      }

      id = R.id.medicine_button;
      CardView medicineButton = ViewBindings.findChildViewById(rootView, id);
      if (medicineButton == null) {
        break missingId;
      }

      id = R.id.medicine_text;
      TextView medicineText = ViewBindings.findChildViewById(rootView, id);
      if (medicineText == null) {
        break missingId;
      }

      id = R.id.miscellaneous;
      ImageView miscellaneous = ViewBindings.findChildViewById(rootView, id);
      if (miscellaneous == null) {
        break missingId;
      }

      id = R.id.miscellaneous_button;
      CardView miscellaneousButton = ViewBindings.findChildViewById(rootView, id);
      if (miscellaneousButton == null) {
        break missingId;
      }

      id = R.id.miscellaneous_text;
      TextView miscellaneousText = ViewBindings.findChildViewById(rootView, id);
      if (miscellaneousText == null) {
        break missingId;
      }

      id = R.id.money_spend;
      EditText moneySpend = ViewBindings.findChildViewById(rootView, id);
      if (moneySpend == null) {
        break missingId;
      }

      id = R.id.ok_button;
      TextView okButton = ViewBindings.findChildViewById(rootView, id);
      if (okButton == null) {
        break missingId;
      }

      id = R.id.select_category_text;
      TextView selectCategoryText = ViewBindings.findChildViewById(rootView, id);
      if (selectCategoryText == null) {
        break missingId;
      }

      id = R.id.transport;
      ImageView transport = ViewBindings.findChildViewById(rootView, id);
      if (transport == null) {
        break missingId;
      }

      id = R.id.transport_button;
      CardView transportButton = ViewBindings.findChildViewById(rootView, id);
      if (transportButton == null) {
        break missingId;
      }

      id = R.id.transport_text;
      TextView transportText = ViewBindings.findChildViewById(rootView, id);
      if (transportText == null) {
        break missingId;
      }

      return new MinusDialogLayoutBinding((RelativeLayout) rootView, amountCard, cancelButton,
          entertainment, entertainmentButton, entertainmentText, essentials, essentialsButton,
          essentialsText, food, foodButton, foodText, gift, giftButton, giftText, house,
          houseButton, housingText, medicine, medicineButton, medicineText, miscellaneous,
          miscellaneousButton, miscellaneousText, moneySpend, okButton, selectCategoryText,
          transport, transportButton, transportText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
