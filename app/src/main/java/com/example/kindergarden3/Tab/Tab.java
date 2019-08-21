package com.example.kindergarden3.Tab;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.kindergarden3.R;

public class Tab extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        setTabs() ;
    }
    private void setTabs()
    {
        addTab(getString(R.string.creation), R.drawable.creation_black, TabPageOneCreation.class);
        addTab(getString(R.string.videocamera), R.drawable.camera_black, TabPageTwoVideoCamera.class);
        addTab(getString(R.string.profile), R.drawable.profile_black, TabPageThreeProfile.class);

    }

    private void addTab(String labelId, int drawableId, Class<?> c)
    {
        TabHost tabHost = getTabHost();
        Intent intent = new Intent(this, c);
        TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(drawableId);

        spec.setIndicator(tabIndicator);
        spec.setContent(intent);
        tabHost.addTab(spec);
    }

}