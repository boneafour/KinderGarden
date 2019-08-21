package com.example.kindergarden3.Profile;

import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import com.example.kindergarden3.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by HYHY on 11.10.2015.
 */
public class KinderGarden extends FragmentActivity implements View.OnClickListener{
    private TextView txtTitle, tvNameKG, tvAddressKG, tvInfo, tvPrice, tvAge, tvGroup, tvAddress, tvPhone, Site;
    private Button callButton;
    private ImageView imageKinderGarden;
    public ImageButton btnBack;
    private Typeface fontRobotoMedium, fontRobotoRegular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinder_garden);


        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.kinderGarden));
        txtTitle.setTypeface(fontRobotoMedium);
        tvNameKG = (TextView) findViewById(R.id.tvNameKG);
        tvNameKG.setTypeface(fontRobotoRegular);
        tvAddressKG = (TextView) findViewById(R.id.tvAddressKG);
        tvAddressKG.setTypeface(fontRobotoRegular);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        tvInfo.setTypeface(fontRobotoRegular);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvPrice.setTypeface(fontRobotoRegular);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvAge.setTypeface(fontRobotoRegular);
        tvGroup = (TextView) findViewById(R.id.tvGroup);
        tvGroup.setTypeface(fontRobotoRegular);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvAddress.setTypeface(fontRobotoRegular);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvPhone.setTypeface(fontRobotoRegular);
        Site = (TextView) findViewById(R.id.Site);
        Site.setTypeface(fontRobotoRegular);

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        callButton = (Button) findViewById(R.id.callButton);
        callButton.setTypeface(fontRobotoMedium);
        callButton.setOnClickListener(this);

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.btnBack:
               NavUtils.navigateUpFromSameTask(this);
              break;
            case R.id.callButton:
                break;
        }
    }
    }

