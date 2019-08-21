package com.example.kindergarden3.Profile;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
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
public class Notifications extends FragmentActivity implements View.OnClickListener{
    private TextView txtTitle;
    public FragmentTabHost mTabHost;
    public ImageButton btnBack;


    // Array of strings for ListView Title
    int[] lvIconNotification = new int[]{
            R.drawable.childrens_goods_, R.drawable.childrens_goods_, R.drawable.childrens_goods_, R.drawable.creation3,
            R.drawable.childrens_goods_, R.drawable.childrens_goods_, R.drawable.childrens_goods_, R.drawable.creation3,
    };
    String[] lvTittle = new String[]{
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
        setContentView(R.layout.activity_notifications);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.notification));
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("lv_icon_notification", Integer.toString(lvIconNotification[i]));
            hm.put("lv_tittle", lvTittle[i]);
            hm.put("lv_data", lvData[i]);
            aList.add(hm);
        }

        String[] from = {"lv_icon_notification", "lv_tittle", "lv_data"};
        int[] to = {R.id.iconNotification, R.id.tvNotification, R.id.tvDateNotification};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.adapter_notification, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view_notification);
        androidListView.setAdapter(simpleAdapter);
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           case R.id.btnBack:
               NavUtils.navigateUpFromSameTask(this);
              break;
        }
    }
    }

