package com.example.kindergarden3.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
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
public class TimeTable extends FragmentActivity implements View.OnClickListener{
    private TextView txtTitle;
    public FragmentTabHost mTabHost;
    public ImageButton btnBack;

    // Array of strings for ListView Title
    int[] lvIconTimeTable = new int[]{
            R.drawable.childrens_goods_, R.drawable.childrens_goods_, R.drawable.childrens_goods_, R.drawable.creation3,
            R.drawable.childrens_goods_, R.drawable.childrens_goods_,
    };
    String[] lvDateTimeTable = new String[]{
            "Время:08:00-10:00", "Время:08:00-10:00", "Время:08:00-10:00", "Время:08:00-10:00",
            "Время:08:00-10:00", "Время:08:00-10:00",
    };
    String[] lvTittleTimeTable = new String[]{
            "Время творчество", "Время творчество", "Время творчество", "Время творчество",
            "Время творчество", "Время творчество",
    };
    String[] lvRoomTimeTable = new String[]{
            "Детская комната", "Детская комната", "Детская комната", "Детская комната",
            "Детская комната", "Детская комната",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.timetable));
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);


        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 6; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("lv_icon_timetable", Integer.toString(lvIconTimeTable[i]));
            hm.put("lv_date_timetable", lvDateTimeTable[i]);
            hm.put("lv_tittle_timetable", lvTittleTimeTable[i]);
            hm.put("lv_room_timetable", lvRoomTimeTable[i]);
            aList.add(hm);
        }

        String[] from = {"lv_icon_timetable", "lv_date_timetable", "lv_tittle_timetable", "lv_room_timetable"};
        int[] to = {R.id.iconTimeTable, R.id.tvDateTimeTable, R.id.tvTittleTimeTable, R.id.tvRoomTimeTable};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.adapter_timetable, from, to);


        ListView androidListView = (ListView) findViewById(R.id.list_view_timetable);
        androidListView.setAdapter(simpleAdapter);


    }


    private void prepareListData() {
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

