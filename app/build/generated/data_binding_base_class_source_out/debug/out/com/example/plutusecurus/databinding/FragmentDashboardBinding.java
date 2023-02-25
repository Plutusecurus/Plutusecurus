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

public final class FragmentDashboardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView addButton;

  @NonNull
  public final CardView cash;

  @NonNull
  public final TextView cashVal;

  @NonNull
  public final CardView credit;

  @NonNull
  public final TextView creditVal;

  @NonNull
  public final CardView foodCard;

  @NonNull
  public final TextView foodPercentage;

  @NonNull
  public final CardView houseCard;

  @NonNull
  public final TextView housePercentage;

  @NonNull
  public final ImageView mainPagePie;

  @NonNull
  public final CardView medicineCard;

  @NonNull
  public final TextView medicinePercentage;

  @NonNull
  public final ImageView minusButton;

  @NonNull
  public final CardView total;

  @NonNull
  public final TextView totalVal;

  private FragmentDashboardBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView addButton,
      @NonNull CardView cash, @NonNull TextView cashVal, @NonNull CardView credit,
      @NonNull TextView creditVal, @NonNull CardView foodCard, @NonNull TextView foodPercentage,
      @NonNull CardView houseCard, @NonNull TextView housePercentage,
      @NonNull ImageView mainPagePie, @NonNull CardView medicineCard,
      @NonNull TextView medicinePercentage, @NonNull ImageView minusButton, @NonNull CardView total,
      @NonNull TextView totalVal) {
    this.rootView = rootView;
    this.addButton = addButton;
    this.cash = cash;
    this.cashVal = cashVal;
    this.credit = credit;
    this.creditVal = creditVal;
    this.foodCard = foodCard;
    this.foodPercentage = foodPercentage;
    this.houseCard = houseCard;
    this.housePercentage = housePercentage;
    this.mainPagePie = mainPagePie;
    this.medicineCard = medicineCard;
    this.medicinePercentage = medicinePercentage;
    this.minusButton = minusButton;
    this.total = total;
    this.totalVal = totalVal;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_button;
      ImageView addButton = ViewBindings.findChildViewById(rootView, id);
      if (addButton == null) {
        break missingId;
      }

      id = R.id.cash;
      CardView cash = ViewBindings.findChildViewById(rootView, id);
      if (cash == null) {
        break missingId;
      }

      id = R.id.cash_val;
      TextView cashVal = ViewBindings.findChildViewById(rootView, id);
      if (cashVal == null) {
        break missingId;
      }

      id = R.id.credit;
      CardView credit = ViewBindings.findChildViewById(rootView, id);
      if (credit == null) {
        break missingId;
      }

      id = R.id.credit_val;
      TextView creditVal = ViewBindings.findChildViewById(rootView, id);
      if (creditVal == null) {
        break missingId;
      }

      id = R.id.food_card;
      CardView foodCard = ViewBindings.findChildViewById(rootView, id);
      if (foodCard == null) {
        break missingId;
      }

      id = R.id.food_percentage;
      TextView foodPercentage = ViewBindings.findChildViewById(rootView, id);
      if (foodPercentage == null) {
        break missingId;
      }

      id = R.id.house_card;
      CardView houseCard = ViewBindings.findChildViewById(rootView, id);
      if (houseCard == null) {
        break missingId;
      }

      id = R.id.house_percentage;
      TextView housePercentage = ViewBindings.findChildViewById(rootView, id);
      if (housePercentage == null) {
        break missingId;
      }

      id = R.id.main_page_pie;
      ImageView mainPagePie = ViewBindings.findChildViewById(rootView, id);
      if (mainPagePie == null) {
        break missingId;
      }

      id = R.id.medicine_card;
      CardView medicineCard = ViewBindings.findChildViewById(rootView, id);
      if (medicineCard == null) {
        break missingId;
      }

      id = R.id.medicine_percentage;
      TextView medicinePercentage = ViewBindings.findChildViewById(rootView, id);
      if (medicinePercentage == null) {
        break missingId;
      }

      id = R.id.minus_button;
      ImageView minusButton = ViewBindings.findChildViewById(rootView, id);
      if (minusButton == null) {
        break missingId;
      }

      id = R.id.total;
      CardView total = ViewBindings.findChildViewById(rootView, id);
      if (total == null) {
        break missingId;
      }

      id = R.id.total_val;
      TextView totalVal = ViewBindings.findChildViewById(rootView, id);
      if (totalVal == null) {
        break missingId;
      }

      return new FragmentDashboardBinding((ConstraintLayout) rootView, addButton, cash, cashVal,
          credit, creditVal, foodCard, foodPercentage, houseCard, housePercentage, mainPagePie,
          medicineCard, medicinePercentage, minusButton, total, totalVal);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
