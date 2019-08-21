package com.example.kindergarden3.VideoCamera;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentActivity;

import com.example.kindergarden3.R;

/**
 * Created by user on 16.10.2015.
 */
public class CameraAdd extends FragmentActivity implements View.OnClickListener {
    private TextView txtTitle;
    public ImageButton btnBack;
    private Typeface fontRobotoMedium, fontRobotoRegular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camera);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");


        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.add));
        txtTitle.setTypeface(fontRobotoMedium);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
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
