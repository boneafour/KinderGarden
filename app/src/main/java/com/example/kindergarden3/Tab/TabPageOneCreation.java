package com.example.kindergarden3.Tab;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import com.example.kindergarden3.Creation.CreationAdd;
import com.example.kindergarden3.Profile.Notifications;
import com.example.kindergarden3.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by HYHY on 11.10.2015.
 */
public class TabPageOneCreation extends FragmentActivity implements View.OnClickListener{

    private TextView txtTitle;
    private ImageView imageCreation, imageAuthor;
    public ImageButton btnAdd;
    private TextView tvTitleCreation, tvDate;
    private Typeface fontRobotoMedium, fontRobotoRegular;




    // Array of strings for ListView Title

    int[] lvCreation = new int[]{
            R.drawable.creation2, R.drawable.creation4, R.drawable.creation2, R.drawable.creation3,
            R.drawable.creation2, R.drawable.creation4, R.drawable.creation2, R.drawable.creation3,
    };

    int[] lvAuthor = new int[]{
            R.drawable.image_profile, R.drawable.image_profile, R.drawable.image_profile, R.drawable.image_profile,
            R.drawable.image_profile, R.drawable.image_profile, R.drawable.image_profile, R.drawable.image_profile,
    };

    String[] lvCreationName = new String[]{
            "Детское творчество 1", "Детское творчество 2", "Детское творчество 3", "Детское творчество 4",
            "Детское творчество 5", "Детское творчество 6", "Детское творчество 7", "Детское творчество 8",
    };




    String[] lvData = new String[]{
            "Время:12:01 23.08.1996г.", "Время:12:01 23.08.1996г.", "Время:12:01 23.08.1996г.", "Время:12:01 23.08.1996г.",
            "Время:12:01 23.08.1996г.", "Время:12:01 23.08.1996г.", "Время:12:01 23.08.1996г.", "Время:12:01 23.08.1996г.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_page_one_creation);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.creation));
        txtTitle.setTypeface(fontRobotoMedium);

        tvTitleCreation = (TextView) findViewById(R.id.tvTitleCreation);
        tvDate = (TextView) findViewById(R.id.tvDate);
        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("lv_creation", Integer.toString(lvCreation[i]));
            hm.put("lv_author", Integer.toString(lvAuthor[i]));
            hm.put("lv_creation_name", lvCreationName[i]);
            hm.put("lv_data", lvData[i]);
            aList.add(hm);
        }

        String[] from = {"lv_creation", "lv_author", "lv_creation_name", "lv_data"};
        int[] to = {R.id.imageCreation, R.id.imageAuthor, R.id.tvTitleCreation, R.id.tvDate};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.adapter_creation, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.btnAdd:
               startActivity(new Intent(TabPageOneCreation.this, CreationAdd.class));
                break;
        }
    }
    }

