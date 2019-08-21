package com.example.kindergarden3.Tab;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import com.example.kindergarden3.Creation.CreationAdd;
import com.example.kindergarden3.R;
import com.example.kindergarden3.VideoCamera.CameraAdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by HYHY on 11.10.2015.
 */
public class TabPageTwoVideoCamera extends FragmentActivity implements View.OnClickListener{
    private TextView txtTitle, tvRecord, tvCamera, tvRoom;
    public FragmentTabHost mTabHost;
    public ImageButton btnAdd;
    private Typeface fontRobotoMedium, fontRobotoRegular;

    //public SurfaceView camera;
    /*
        <SurfaceView
        android:id="@+id/surfaceView"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        android:layout_marginTop="5dp"
        android:scaleType="centerCrop"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

     */


    // Array of strings for ListView Title
    int[] lvCamera = new int[]{
            R.drawable.camera1, R.drawable.camera2, R.drawable.camera3, R.drawable.camera4,
    };
    String[] lvRecord = new String[]{
            "Запись", "Запись", "Запись", "Не работает",
    };
    String[] lvCameraNumber = new String[]{
            "Камера 1", "Камера 2", "Камера 3", "Камера 4",
    };
    String[] lvRoom = new String[]{
            "Игровая комната", "Комната отдыха", "Игровая площадка", "Улица",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_page_two_videocamerd);


        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setTypeface(fontRobotoMedium);
        txtTitle.setText(getString(R.string.videocamera));

        tvRecord = (TextView) findViewById(R.id.tvRecord);
        tvCamera = (TextView) findViewById(R.id.tvCamera);
        tvRoom = (TextView) findViewById(R.id.tvRoom);


        //camera = (SurfaceView) findViewById(R.id.camera);

        btnAdd = (ImageButton) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("lv_camera", Integer.toString(lvCamera[i]));
            hm.put("lv_record", lvRecord[i]);
            hm.put("lv_camera_num", lvCameraNumber[i]);
            hm.put("lv_room", lvRoom[i]);
            aList.add(hm);
        }

        String[] from = {"lv_camera", "lv_record", "lv_camera_num", "lv_room"};
        int[] to = {R.id.camera, R.id.tvRecord, R.id.tvCamera, R.id.tvRoom};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.adapter_camera, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                startActivity(new Intent(TabPageTwoVideoCamera.this, CameraAdd.class));
                break;
        }
    }
}

