package com.example.kindergarden3.Creation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentActivity;

import com.example.kindergarden3.Database.DatabaseHandler;
import com.example.kindergarden3.R;
import com.example.kindergarden3.Tab.TabPageOneCreation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 16.10.2015.
 */
public class CreationAdd extends FragmentActivity implements View.OnClickListener{
    private TextView txtTitle,  tvTitleCreation, tvSelectAuthor;
    private EditText titleCreation;
    public ImageButton btnBack;
    private Typeface fontRobotoMedium, fontRobotoRegular;
    private Button  addCreation;
    private String stTitleCreation;
    private ImageView addImageCreation;
    private Spinner spAuthor;
    private int REQUEST_CODE = 1;
    String stringTitleCreation, stringAuthor, stringTime;
    Integer intImageCreation, intImageAuthor;
    DatabaseHandler db = new DatabaseHandler(this);

    int[] lvImageAuthor = new int[]{
            R.drawable.image_profile, R.drawable.image_profile, R.drawable.image_profile, R.drawable.image_profile,
    };
    String[] lvAuthor = new String[]{
            "Зухаа Жамбыл", "Зухаа Жамбыл", "Зухаа Жамбыл", "Зухаа Жамбыл",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_creation);

        db = new DatabaseHandler(this);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        //DB Creation - export -> image, titleCreation, imageAuthor, date( время 08:23 23.08.2019 )

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.add));
        txtTitle.setTypeface(fontRobotoMedium);
        tvTitleCreation = (TextView) findViewById(R.id.tvTitleCreation);
        tvTitleCreation.setTypeface(fontRobotoRegular);
        titleCreation = (EditText) findViewById(R.id.editTitle);
        titleCreation.setTypeface(fontRobotoRegular);
        tvSelectAuthor = (TextView) findViewById(R.id.tvSelectAuthor);
        tvSelectAuthor.setTypeface(fontRobotoRegular);
        addImageCreation = (ImageView) findViewById(R.id.addImageCreation);

        spAuthor = (Spinner) findViewById(R.id.spAuthor);
        tvSelectAuthor.setTypeface(fontRobotoRegular);

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        tvSelectAuthor.setTypeface(fontRobotoMedium);
        btnBack.setOnClickListener(this);


        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("lv_image_author", Integer.toString(lvImageAuthor[i]));
            hm.put("lv_author", lvAuthor[i]);
            aList.add(hm);
        }

        String[] from = {"lv_image_author", "lv_author"};
        int[] to = {R.id.imageAuthor, R.id.tvAuthor};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_author_spinner, from, to);
        spAuthor.setAdapter(simpleAdapter);

        addImageCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent select = new Intent();
                select.setType("image/");
                select.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(select, "Select Picture"), REQUEST_CODE);
            }
        });


        addCreation = (Button) findViewById(R.id.addCreation);
        addCreation.setTypeface(fontRobotoMedium);
        addCreation.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int ResultCode, Intent data) {
       super.onActivityResult(requestCode, ResultCode, data);

       if(requestCode==REQUEST_CODE && ResultCode==RESULT_OK && data!= null && data.getData()!= null) {
            Uri uri = data.getData();
            try {
                Bitmap image = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                addImageCreation.setImageBitmap(image);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                NavUtils.navigateUpFromSameTask(this);
                break;
            case R.id.addCreation:

                String stringTitleCreation, stringAuthor;
                Integer intImageCreation, intImageAuthor;



                stringTitleCreation = "" + titleCreation.getText();
                stringTitleCreation = "" + titleCreation.getText();
/*
                DatabaseHandler db = new DatabaseHandler(this);
                db.addSubject(new SubjectData(stFullName, stCommentSubject));
                List<SubjectData> subjects = db.getAllSubjects();
                for (SubjectData cn : subjects) {
                    String log = "Id: " + cn.getSubjectID() + " ,Names: " + cn.getSubjectName() + " ,Group: " + cn.getSubjectComment();
                    Log.d("Name: ", log);
                }
                */
                break;
        }
    }
}
