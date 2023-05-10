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
import com.github.mikephil.charting.charts.PieChart;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPlannerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView backButtonPlanner;

  @NonNull
  public final TextView essentialsAmt;

  @NonNull
  public final CardView essentialsCard;

  @NonNull
  public final TextView essentialsPercentage;

  @NonNull
  public final CardView essentialsText;

  @NonNull
  public final TextView foodAmt;

  @NonNull
  public final CardView foodCard;

  @NonNull
  public final TextView foodPercentage;

  @NonNull
  public final CardView foodText;

  @NonNull
  public final TextView giftAmt;

  @NonNull
  public final CardView giftCard;

  @NonNull
  public final TextView giftPercentage;

  @NonNull
  public final CardView giftText;

  @NonNull
  public final TextView houseAmt;

  @NonNull
  public final TextView housePercentage;

  @NonNull
  public final CardView housingCard;

  @NonNull
  public final CardView housingText;

  @NonNull
  public final TextView luxuryAmt;

  @NonNull
  public final CardView luxuryCard;

  @NonNull
  public final TextView luxuryPercentage;

  @NonNull
  public final CardView luxuryText;

  @NonNull
  public final TextView medicalAmt;

  @NonNull
  public final CardView medicineCard;

  @NonNull
  public final TextView medicinePercentage;

  @NonNull
  public final CardView medicineText;

  @NonNull
  public final TextView miscAmt;

  @NonNull
  public final CardView miscCard;

  @NonNull
  public final TextView miscPercentage;

  @NonNull
  public final CardView miscText;

  @NonNull
  public final CardView pie1;

  @NonNull
  public final PieChart pieChart1;

  @NonNull
  public final TextView statsText;

  @NonNull
  public final TextView transitionPercentage;

  @NonNull
  public final TextView transportAmt;

  @NonNull
  public final CardView transportCard;

  @NonNull
  public final CardView transportText;

  private ActivityPlannerBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView backButtonPlanner, @NonNull TextView essentialsAmt,
      @NonNull CardView essentialsCard, @NonNull TextView essentialsPercentage,
      @NonNull CardView essentialsText, @NonNull TextView foodAmt, @NonNull CardView foodCard,
      @NonNull TextView foodPercentage, @NonNull CardView foodText, @NonNull TextView giftAmt,
      @NonNull CardView giftCard, @NonNull TextView giftPercentage, @NonNull CardView giftText,
      @NonNull TextView houseAmt, @NonNull TextView housePercentage, @NonNull CardView housingCard,
      @NonNull CardView housingText, @NonNull TextView luxuryAmt, @NonNull CardView luxuryCard,
      @NonNull TextView luxuryPercentage, @NonNull CardView luxuryText,
      @NonNull TextView medicalAmt, @NonNull CardView medicineCard,
      @NonNull TextView medicinePercentage, @NonNull CardView medicineText,
      @NonNull TextView miscAmt, @NonNull CardView miscCard, @NonNull TextView miscPercentage,
      @NonNull CardView miscText, @NonNull CardView pie1, @NonNull PieChart pieChart1,
      @NonNull TextView statsText, @NonNull TextView transitionPercentage,
      @NonNull TextView transportAmt, @NonNull CardView transportCard,
      @NonNull CardView transportText) {
    this.rootView = rootView;
    this.backButtonPlanner = backButtonPlanner;
    this.essentialsAmt = essentialsAmt;
    this.essentialsCard = essentialsCard;
    this.essentialsPercentage = essentialsPercentage;
    this.essentialsText = essentialsText;
    this.foodAmt = foodAmt;
    this.foodCard = foodCard;
    this.foodPercentage = foodPercentage;
    this.foodText = foodText;
    this.giftAmt = giftAmt;
    this.giftCard = giftCard;
    this.giftPercentage = giftPercentage;
    this.giftText = giftText;
    this.houseAmt = houseAmt;
    this.housePercentage = housePercentage;
    this.housingCard = housingCard;
    this.housingText = housingText;
    this.luxuryAmt = luxuryAmt;
    this.luxuryCard = luxuryCard;
    this.luxuryPercentage = luxuryPercentage;
    this.luxuryText = luxuryText;
    this.medicalAmt = medicalAmt;
    this.medicineCard = medicineCard;
    this.medicinePercentage = medicinePercentage;
    this.medicineText = medicineText;
    this.miscAmt = miscAmt;
    this.miscCard = miscCard;
    this.miscPercentage = miscPercentage;
    this.miscText = miscText;
    this.pie1 = pie1;
    this.pieChart1 = pieChart1;
    this.statsText = statsText;
    this.transitionPercentage = transitionPercentage;
    this.transportAmt = transportAmt;
    this.transportCard = transportCard;
    this.transportText = transportText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPlannerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPlannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_planner, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPlannerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back_button_planner;
      ImageView backButtonPlanner = ViewBindings.findChildViewById(rootView, id);
      if (backButtonPlanner == null) {
        break missingId;
      }

      id = R.id.essentials_amt;
      TextView essentialsAmt = ViewBindings.findChildViewById(rootView, id);
      if (essentialsAmt == null) {
        break missingId;
      }

      id = R.id.essentials_card;
      CardView essentialsCard = ViewBindings.findChildViewById(rootView, id);
      if (essentialsCard == null) {
        break missingId;
      }

      id = R.id.essentials_percentage;
      TextView essentialsPercentage = ViewBindings.findChildViewById(rootView, id);
      if (essentialsPercentage == null) {
        break missingId;
      }

      id = R.id.essentials_text;
      CardView essentialsText = ViewBindings.findChildViewById(rootView, id);
      if (essentialsText == null) {
        break missingId;
      }

      id = R.id.food_amt;
      TextView foodAmt = ViewBindings.findChildViewById(rootView, id);
      if (foodAmt == null) {
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

      id = R.id.food_text;
      CardView foodText = ViewBindings.findChildViewById(rootView, id);
      if (foodText == null) {
        break missingId;
      }

      id = R.id.gift_amt;
      TextView giftAmt = ViewBindings.findChildViewById(rootView, id);
      if (giftAmt == null) {
        break missingId;
      }

      id = R.id.gift_card;
      CardView giftCard = ViewBindings.findChildViewById(rootView, id);
      if (giftCard == null) {
        break missingId;
      }

      id = R.id.gift_percentage;
      TextView giftPercentage = ViewBindings.findChildViewById(rootView, id);
      if (giftPercentage == null) {
        break missingId;
      }

      id = R.id.gift_text;
      CardView giftText = ViewBindings.findChildViewById(rootView, id);
      if (giftText == null) {
        break missingId;
      }

      id = R.id.house_amt;
      TextView houseAmt = ViewBindings.findChildViewById(rootView, id);
      if (houseAmt == null) {
        break missingId;
      }

      id = R.id.house_percentage;
      TextView housePercentage = ViewBindings.findChildViewById(rootView, id);
      if (housePercentage == null) {
        break missingId;
      }

      id = R.id.housing_card;
      CardView housingCard = ViewBindings.findChildViewById(rootView, id);
      if (housingCard == null) {
        break missingId;
      }

      id = R.id.housing_text;
      CardView housingText = ViewBindings.findChildViewById(rootView, id);
      if (housingText == null) {
        break missingId;
      }

      id = R.id.luxury_amt;
      TextView luxuryAmt = ViewBindings.findChildViewById(rootView, id);
      if (luxuryAmt == null) {
        break missingId;
      }

      id = R.id.luxury_card;
      CardView luxuryCard = ViewBindings.findChildViewById(rootView, id);
      if (luxuryCard == null) {
        break missingId;
      }

      id = R.id.luxury_percentage;
      TextView luxuryPercentage = ViewBindings.findChildViewById(rootView, id);
      if (luxuryPercentage == null) {
        break missingId;
      }

      id = R.id.luxury_text;
      CardView luxuryText = ViewBindings.findChildViewById(rootView, id);
      if (luxuryText == null) {
        break missingId;
      }

      id = R.id.medical_amt;
      TextView medicalAmt = ViewBindings.findChildViewById(rootView, id);
      if (medicalAmt == null) {
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

      id = R.id.medicine_text;
      CardView medicineText = ViewBindings.findChildViewById(rootView, id);
      if (medicineText == null) {
        break missingId;
      }

      id = R.id.misc_amt;
      TextView miscAmt = ViewBindings.findChildViewById(rootView, id);
      if (miscAmt == null) {
        break missingId;
      }

      id = R.id.misc_card;
      CardView miscCard = ViewBindings.findChildViewById(rootView, id);
      if (miscCard == null) {
        break missingId;
      }

      id = R.id.misc_percentage;
      TextView miscPercentage = ViewBindings.findChildViewById(rootView, id);
      if (miscPercentage == null) {
        break missingId;
      }

      id = R.id.misc_text;
      CardView miscText = ViewBindings.findChildViewById(rootView, id);
      if (miscText == null) {
        break missingId;
      }

      id = R.id.pie_1;
      CardView pie1 = ViewBindings.findChildViewById(rootView, id);
      if (pie1 == null) {
        break missingId;
      }

      id = R.id.pie_chart_1;
      PieChart pieChart1 = ViewBindings.findChildViewById(rootView, id);
      if (pieChart1 == null) {
        break missingId;
      }

      id = R.id.stats_text;
      TextView statsText = ViewBindings.findChildViewById(rootView, id);
      if (statsText == null) {
        break missingId;
      }

      id = R.id.transition_percentage;
      TextView transitionPercentage = ViewBindings.findChildViewById(rootView, id);
      if (transitionPercentage == null) {
        break missingId;
      }

      id = R.id.transport_amt;
      TextView transportAmt = ViewBindings.findChildViewById(rootView, id);
      if (transportAmt == null) {
        break missingId;
      }

      id = R.id.transport_card;
      CardView transportCard = ViewBindings.findChildViewById(rootView, id);
      if (transportCard == null) {
        break missingId;
      }

      id = R.id.transport_text;
      CardView transportText = ViewBindings.findChildViewById(rootView, id);
      if (transportText == null) {
        break missingId;
      }

      return new ActivityPlannerBinding((ConstraintLayout) rootView, backButtonPlanner,
          essentialsAmt, essentialsCard, essentialsPercentage, essentialsText, foodAmt, foodCard,
          foodPercentage, foodText, giftAmt, giftCard, giftPercentage, giftText, houseAmt,
          housePercentage, housingCard, housingText, luxuryAmt, luxuryCard, luxuryPercentage,
          luxuryText, medicalAmt, medicineCard, medicinePercentage, medicineText, miscAmt, miscCard,
          miscPercentage, miscText, pie1, pieChart1, statsText, transitionPercentage, transportAmt,
          transportCard, transportText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}