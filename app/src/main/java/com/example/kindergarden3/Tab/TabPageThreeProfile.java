package com.example.kindergarden3.Tab;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import com.example.kindergarden3.Creation.CreationAdd;
import com.example.kindergarden3.Profile.EditProfile;
import com.example.kindergarden3.Profile.KinderGarden;
import com.example.kindergarden3.Profile.Notifications;
import com.example.kindergarden3.Profile.TimeTable;
import com.example.kindergarden3.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TabPageThreeProfile extends FragmentActivity implements View.OnClickListener {
    private TextView  tvNameParents, tvNameChild;
    private ImageView imageProfile;
    public ImageView btnEdit;
    private Button btnNotification;
    private Typeface fontRobotoMedium, fontRobotoRegular;

    // Array of strings for ListView Title
    int[] lvIconMenu = new int[]{
            R.drawable.kinder_garden, R.drawable.resting_place, R.drawable.event, R.drawable.childrens_goods_, R.drawable.tech_support,
    };
    String[] lvMenu = new String[]{
            "Детский сад", "Место отдыха", "Мероприятие в городе",  "Детские товары", "Техническая поддержка",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_page_three_profile);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");


        tvNameParents = (TextView) findViewById(R.id.tvNameParents);
        tvNameParents.setTypeface(fontRobotoMedium);
        tvNameChild = (TextView) findViewById(R.id.tvNameChild);
        tvNameChild.setTypeface(fontRobotoMedium);

        imageProfile = (ImageView) findViewById(R.id.imageProfile);
        btnEdit = (ImageView) findViewById(R.id.btnEdit);
        btnNotification = (Button) findViewById(R.id.btnNotification);
        btnNotification.setTypeface(fontRobotoMedium);
        btnNotification.setOnClickListener(this);




        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("lv_icon_menu", Integer.toString(lvIconMenu[i]));
            hm.put("lv_menu", lvMenu[i]);
            aList.add(hm);
        }

        String[] from = {"lv_icon_menu", "lv_menu"};
        int[] to = {R.id.iconMenu, R.id.tvMenu};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.adapter_profile, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if(position==0){
                    startActivity(new Intent(TabPageThreeProfile.this, KinderGarden.class));
                }
                else if (position==1){
                    startActivity(new Intent(TabPageThreeProfile.this, KinderGarden.class));
                }
                else if(position==2){
                    startActivity(new Intent(TabPageThreeProfile.this, TimeTable.class));
                }
                else if(position==3){
                    startActivity(new Intent(TabPageThreeProfile.this, TabPageTwoVideoCamera.class));
                }
                else if(position==4){
                    startActivity(new Intent(TabPageThreeProfile.this, TabPageTwoVideoCamera.class));
                }
            }
        });
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNotification:
                startActivity(new Intent(this, Notifications.class));
                break;

            case R.id.btnEdit:
                startActivity(new Intent(this, EditProfile.class));
            break;
        }
    }
}
