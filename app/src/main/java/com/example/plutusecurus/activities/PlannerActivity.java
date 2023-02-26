package com.example.plutusecurus.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.plutusecurus.R;
import com.example.plutusecurus.data.ApiClient;
import com.example.plutusecurus.data.TransAPI;
import com.example.plutusecurus.dtos.GetUserResponse;
import com.example.plutusecurus.utils.SharedPreferencesConfig;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.zxing.WriterException;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlannerActivity extends AppCompatActivity {

    private PieChart pie1;
    String house,food,transport,essential,misc,gift,luxury,medical,total;
    float h,f,t,e,m,g,lu,mis,tot;
    TextView House,Food,Transport,Essential,Misc,Gift,Luxury,Medical,ph,pf,pt,pe,pm,pg,plu,pmis;
    ImageView backButton;
    //ghjghgh

    private TransAPI transAPI;
    SharedPreferencesConfig sharedPreferencesConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);
        transAPI = ApiClient.getApiClient().create(TransAPI.class);
        sharedPreferencesConfig = new SharedPreferencesConfig(this);

        pie1=findViewById(R.id.pie_chart_1);
        backButton = findViewById(R.id.back_button_planner);
        House=findViewById(R.id.house_amt);
        Food=findViewById(R.id.food_amt);
        Transport=findViewById(R.id.transport_amt);
        Essential=findViewById(R.id.essentials_amt);
        Misc=findViewById(R.id.misc_amt);
        Gift=findViewById(R.id.gift_amt);
        Luxury=findViewById(R.id.luxury_amt);
        Medical=findViewById(R.id.medical_amt);
        ph=findViewById(R.id.house_percentage);
        pf=findViewById(R.id.food_percentage);
        pt=findViewById(R.id.transition_percentage);
        pe=findViewById(R.id.essentials_percentage);
        pmis=findViewById(R.id.misc_percentage);
        pg=findViewById(R.id.gift_percentage);
        plu=findViewById(R.id.luxury_percentage);
        pm=findViewById(R.id.medicine_percentage);

        getUser();

        backButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(PlannerActivity.this, MainActivity.class);
            PlannerActivity.this.startActivity(myIntent);
            finish();
        });

    }

    private void getUser() {
        transAPI.getUser(sharedPreferencesConfig.readPublicKey())
                .enqueue(new Callback<GetUserResponse>() {
                    @Override
                    public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body()!=null) {
                                GetUserResponse.Spending spending = response.body().getUser().getSpending();
                                house=String.valueOf(spending.getHousing());
                                food=String.valueOf(spending.getFood());
                                transport=String.valueOf(spending.getTransport());
                                essential=String.valueOf(spending.getEssentials());
                                misc=String.valueOf(spending.getMisc());
                                gift=String.valueOf(spending.getGifts());
                                luxury=String.valueOf(spending.getLuxury());
                                medical=String.valueOf(spending.getMedical());
                                // total=String.valueOf(spending.());
                                total = String.valueOf(spending.getHousing() + spending.getFood() + spending.getTransport() + spending.getEssentials() + spending.getMisc()
                                + spending.getGifts() + spending.getLuxury() + spending.getMedical());

                                h = Float.parseFloat(house);
                                f = Float.parseFloat(food);
                                t = Float.parseFloat(transport);
                                e = Float.parseFloat(essential);
                                mis =Float.parseFloat(misc);
                                g = Float.parseFloat(gift);
                                lu = Float.parseFloat(luxury);
                                m = Float.parseFloat(medical);
                                tot=h+f+t+e+mis+g+lu+m;

                                ph.setText(Float.toString(100*h/tot)+"%");
                                pf.setText(Float.toString(100*f/tot)+"%");
                                pe.setText(Float.toString(100*e/tot)+"%");
                                pg.setText(Float.toString(100*g/tot)+"%");
                                pt.setText(Float.toString(100*t/tot)+"%");
                                pmis.setText(Float.toString(100*mis/tot)+"%");
                                plu.setText(Float.toString(100*lu/tot)+"%");
                                pm.setText(Float.toString(100*m/tot)+"%");


                                House.setText("Rs. "+house);
                                Food.setText("Rs. "+food);
                                Essential.setText("Rs. "+essential);
                                Gift.setText("Rs. "+gift);
                                Transport.setText("Rs. "+transport);
                                Misc.setText("Rs. "+misc);
                                Luxury.setText("Rs. "+luxury);
                                Medical.setText("Rs. "+medical);

                                loadPieChart1();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GetUserResponse> call, Throwable t) {

                    }
                });
    }

    private void loadPieChart1(){

        pie1.setDrawHoleEnabled(false);
        pie1.setUsePercentValues(true);
        pie1.setCenterTextSize(8f);
        pie1.setEntryLabelColor(Color.BLACK);
        pie1.setCenterTextSize(8f);
        pie1.getDescription().setEnabled(false);
        Legend l=pie1.getLegend();
        l.setDrawInside(false);
        l.setEnabled(false);

        ArrayList<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry((h/tot),"Housing"));
        entries.add(new PieEntry((f/tot),"Food"));
        entries.add(new PieEntry((m/tot),"Medication"));
        entries.add(new PieEntry((t/tot),"Transport"));
        entries.add(new PieEntry((e/tot),"Essentials"));
        entries.add(new PieEntry((lu/tot),"Luxury"));
        entries.add(new PieEntry((g/tot),"Gift"));
        entries.add(new PieEntry((mis/tot),"Misc."));

        ArrayList<Integer> colors =new ArrayList<>();
        for(int color: ColorTemplate.MATERIAL_COLORS){ colors.add(color); }
        for(int color:ColorTemplate.VORDIPLOM_COLORS){ colors.add(color); }
        PieDataSet dataSet=new PieDataSet(entries,"Expenses");
        dataSet.setColors(colors);

        PieData data=new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pie1));
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.BLACK);
        pie1.setData(data);
        pie1.invalidate();
        pie1.animateX(1400, Easing.EaseInOutQuad);
    }
}