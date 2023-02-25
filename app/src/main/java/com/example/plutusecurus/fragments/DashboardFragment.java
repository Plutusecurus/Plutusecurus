package com.example.plutusecurus.fragments;

import static android.R.color.transparent;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.plutusecurus.R;
import com.example.plutusecurus.activities.PlannerActivity;

public class DashboardFragment extends Fragment {

    ImageView pie_chart_button;
    ImageView plus,minus;
    TextView expenditure, earnings,total;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dashboard,container,false);

        /*--------------------DECLARATIONS------------------------------------------*/
        pie_chart_button=view.findViewById(R.id.main_page_pie);
        plus=view.findViewById(R.id.add_button);
        minus=view.findViewById(R.id.minus_button);
        expenditure=view.findViewById(R.id.cash_val);
        earnings =view.findViewById(R.id.credit_val);
        total=view.findViewById(R.id.total_val);
        /*______________________________TEXT CONFIG___________________________*/
        final int[] selected = {0};
        expenditure.setText("2500");
        earnings.setText("3000");
        total.setText("500");
        float expenditure_int, earnings_int,total_int;

        /*_______________________________BUTTONS CONFIGS_________________________________________*/



        pie_chart_button.setOnClickListener(view12 -> {
            Intent intent=new Intent(getActivity(), PlannerActivity.class);
            startActivity(intent);
        });
        plus.setOnClickListener(view13 -> showAddDialog());

        minus.setOnClickListener(view1 -> showMinusDialog());
        return view;
    }
    private void showAddDialog(){

        Dialog add_dialog=new Dialog(getActivity());
        add_dialog.setContentView(R.layout.add_dialog_layout);
        add_dialog.getWindow().setBackgroundDrawableResource(transparent);
        TextView ok_button=add_dialog.findViewById(R.id.ok_button);
        TextView cancel_button=add_dialog.findViewById(R.id.cancel_button);
        CardView standardIncome=add_dialog.findViewById(R.id.standard_income);
        CardView deposits=add_dialog.findViewById(R.id.deposits);
        EditText addVal=add_dialog.findViewById(R.id.money_added);


        final int[] flag_1 = {0};
        final int[] flag_2 = {0};

        standardIncome.setOnClickListener(view -> {
            if(flag_1[0] ==0) {
                standardIncome.getBackground().setTint(Color.parseColor("#CAFACA"));
                deposits.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                flag_1[0] =1;
                flag_2[0]=0;
            }else{
                standardIncome.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                flag_1[0] =0;
            }
        });

        deposits.setOnClickListener(view -> {
            if(flag_2[0] ==0) {
                deposits.getBackground().setTint(Color.parseColor("#CAFACA"));
                flag_2[0] =1;
                standardIncome.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                flag_1[0] =0;
            }else{
                deposits.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                flag_2[0] =0;
            }
        });

        ok_button.setOnClickListener(view -> {
            //add data to file
            add_dialog.dismiss();
        });
        cancel_button.setOnClickListener(view -> add_dialog.dismiss());
        add_dialog.show();

    }

    private void showMinusDialog(){
        Dialog minus_dialog=new Dialog(getActivity());
        minus_dialog.setContentView(R.layout.minus_dialog_layout);
        minus_dialog.getWindow().setBackgroundDrawableResource(transparent);

        EditText minusVal=minus_dialog.findViewById(R.id.money_spend);
        TextView ok_button=minus_dialog.findViewById(R.id.ok_button);
        TextView cancel_button=minus_dialog.findViewById(R.id.cancel_button);
        CardView houseButton=minus_dialog.findViewById(R.id.house_button);
        CardView foodButton=minus_dialog.findViewById(R.id.food_button);
        CardView medicineButton=minus_dialog.findViewById(R.id.medicine_button);
        CardView transportButton=minus_dialog.findViewById(R.id.transport_button);
        CardView essentialsButton=minus_dialog.findViewById(R.id.essentials_button);
        CardView entertainmentButton=minus_dialog.findViewById(R.id.entertainment_button);
        CardView giftButton=minus_dialog.findViewById(R.id.gift_button);
        CardView miscellaneousButton=minus_dialog.findViewById(R.id.miscellaneous_button);

        ImageView house=minus_dialog.findViewById(R.id.house);
        ImageView food=minus_dialog.findViewById(R.id.food);
        ImageView medicine=minus_dialog.findViewById(R.id.medicine);
        ImageView transport=minus_dialog.findViewById(R.id.transport);
        ImageView essentials=minus_dialog.findViewById(R.id.essentials);
        ImageView entertainment=minus_dialog.findViewById(R.id.entertainment);
        ImageView gift=minus_dialog.findViewById(R.id.gift);
        ImageView miscellaneous=minus_dialog.findViewById(R.id.miscellaneous);

        final int[] flag = {0,0,0,0,0,0,0,0};

        ok_button.setOnClickListener(view -> {
            //add data to file
            minus_dialog.dismiss();
        });
        houseButton.setOnClickListener(view -> {
            foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            food.setColorFilter(getResources().getColor(R.color.lpink));
            medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            medicine.setColorFilter(getResources().getColor(R.color.lpink));
            transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            transport.setColorFilter(getResources().getColor(R.color.lpink));
            essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            essentials.setColorFilter(getResources().getColor(R.color.lpink));
            entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            entertainment.setColorFilter(getResources().getColor(R.color.lpink));
            giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            gift.setColorFilter(getResources().getColor(R.color.lpink));
            miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[0]==0){
                houseButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                house.setColorFilter(getResources().getColor(R.color.white));
                for (int i=0;i<8;i++) flag[i]=0;
                flag[0]=1;
            }else{
                houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                house.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        foodButton.setOnClickListener(view -> {
            houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            house.setColorFilter(getResources().getColor(R.color.lpink));
            medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            medicine.setColorFilter(getResources().getColor(R.color.lpink));
            transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            transport.setColorFilter(getResources().getColor(R.color.lpink));
            essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            essentials.setColorFilter(getResources().getColor(R.color.lpink));
            entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            entertainment.setColorFilter(getResources().getColor(R.color.lpink));
            giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            gift.setColorFilter(getResources().getColor(R.color.lpink));
            miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[1]==0){
                foodButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                food.setColorFilter(getResources().getColor(R.color.white));

                for (int i=0;i<8;i++) flag[i]=0;
                flag[1]=1;
            }else{
                foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                food.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        medicineButton.setOnClickListener(view -> {
            houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            house.setColorFilter(getResources().getColor(R.color.lpink));
            foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            food.setColorFilter(getResources().getColor(R.color.lpink));
            transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            transport.setColorFilter(getResources().getColor(R.color.lpink));
            essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            essentials.setColorFilter(getResources().getColor(R.color.lpink));
            entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            entertainment.setColorFilter(getResources().getColor(R.color.lpink));
            giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            gift.setColorFilter(getResources().getColor(R.color.lpink));
            miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[2]==0){
                medicineButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                medicine.setColorFilter(getResources().getColor(R.color.white));

                for (int i=0;i<8;i++) flag[i]=0;
                flag[2]=1;
            }else{
                medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                medicine.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        transportButton.setOnClickListener(view -> {
            houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            house.setColorFilter(getResources().getColor(R.color.lpink));
            foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            food.setColorFilter(getResources().getColor(R.color.lpink));
            medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            medicine.setColorFilter(getResources().getColor(R.color.lpink));
            essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            essentials.setColorFilter(getResources().getColor(R.color.lpink));
            entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            entertainment.setColorFilter(getResources().getColor(R.color.lpink));
            giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            gift.setColorFilter(getResources().getColor(R.color.lpink));
            miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[3]==0){
                transportButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                transport.setColorFilter(getResources().getColor(R.color.white));

                for (int i=0;i<8;i++) flag[i]=0;
                flag[3]=1;
            }else{
                transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                transport.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        essentialsButton.setOnClickListener(view -> {
            houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            house.setColorFilter(getResources().getColor(R.color.lpink));
            foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            food.setColorFilter(getResources().getColor(R.color.lpink));
            medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            medicine.setColorFilter(getResources().getColor(R.color.lpink));
            transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            transport.setColorFilter(getResources().getColor(R.color.lpink));
            entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            entertainment.setColorFilter(getResources().getColor(R.color.lpink));
            giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            gift.setColorFilter(getResources().getColor(R.color.lpink));
            miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[4]==0){
                essentialsButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                essentials.setColorFilter(getResources().getColor(R.color.white));

                for (int i=0;i<8;i++) flag[i]=0;
                flag[4]=1;
            }else{
                essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                essentials.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        entertainmentButton.setOnClickListener(view -> {
            houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            house.setColorFilter(getResources().getColor(R.color.lpink));
            foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            food.setColorFilter(getResources().getColor(R.color.lpink));
            medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            medicine.setColorFilter(getResources().getColor(R.color.lpink));
            transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            transport.setColorFilter(getResources().getColor(R.color.lpink));
            essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            essentials.setColorFilter(getResources().getColor(R.color.lpink));
            giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            gift.setColorFilter(getResources().getColor(R.color.lpink));
            miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[5]==0){
                entertainmentButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                entertainment.setColorFilter(getResources().getColor(R.color.white));

                for (int i=0;i<8;i++) flag[i]=0;
                flag[5]=1;
            }else{
                entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                entertainment.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        giftButton.setOnClickListener(view -> {
            houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            house.setColorFilter(getResources().getColor(R.color.lpink));
            foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            food.setColorFilter(getResources().getColor(R.color.lpink));
            medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            medicine.setColorFilter(getResources().getColor(R.color.lpink));
            transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            transport.setColorFilter(getResources().getColor(R.color.lpink));
            essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            essentials.setColorFilter(getResources().getColor(R.color.lpink));
            entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            entertainment.setColorFilter(getResources().getColor(R.color.lpink));
            miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[6]==0){
                giftButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                gift.setColorFilter(getResources().getColor(R.color.white));
                for (int i=0;i<8;i++) flag[i]=0;
                flag[6]=1;
            }else{
                giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                gift.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        miscellaneousButton.setOnClickListener(view -> {
            houseButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            house.setColorFilter(getResources().getColor(R.color.lpink));
            foodButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            food.setColorFilter(getResources().getColor(R.color.lpink));
            medicineButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            medicine.setColorFilter(getResources().getColor(R.color.lpink));
            transportButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            transport.setColorFilter(getResources().getColor(R.color.lpink));
            essentialsButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            essentials.setColorFilter(getResources().getColor(R.color.lpink));
            entertainmentButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            entertainment.setColorFilter(getResources().getColor(R.color.lpink));
            giftButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
            gift.setColorFilter(getResources().getColor(R.color.lpink));
            if(flag[7]==0){
                miscellaneousButton.getBackground().setTint(Color.parseColor("#F4B9B9"));
                miscellaneous.setColorFilter(getResources().getColor(R.color.white));
                for (int i=0;i<8;i++) flag[i]=0;
                flag[7]=1;
            }else{
                miscellaneousButton.getBackground().setTint(Color.parseColor("#FFFFFFFF"));
                miscellaneous.setColorFilter(getResources().getColor(R.color.lpink));
                for (int i=0;i<8;i++) flag[i]=0;
            }
        });
        cancel_button.setOnClickListener(view -> minus_dialog.dismiss());
        minus_dialog.show();
    }
}
