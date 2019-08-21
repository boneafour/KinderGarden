package com.example.kindergarden3.Registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kindergarden3.Database.DatabaseHandler;
import com.example.kindergarden3.Database.ShortInfoData;
import com.example.kindergarden3.R;
import com.example.kindergarden3.Tab.Tab;

import java.io.IOException;
import java.util.List;

public class RegistrationKGpart2 extends AppCompatActivity implements View.OnClickListener {

    /*EditText etParol;
    Spinner spType, spStudent;
    String stType, stParol, s, p, nameStudent="1", passStudent="2";
    DatabaseHandler db = new DatabaseHandler(this);
    //java.util.List<StudentData> students;
    ArrayList<String> List;
    */
    private ImageView imgKG;
    private Spinner spReg, spMKR;
    private EditText editName, editAdress;
    private Button btnLoadImage, btnNext;
    private Typeface fontRobotoMedium, fontRobotoRegular;
    private int REQUEST_CODE = 1;
    String stReg, stMKR, stNameKG, stAdress;
    Drawable drawableImgKG;
    Integer intImgKG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_kg_part2);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        imgKG = (ImageView) findViewById(R.id.imageKinderGarden);
        spReg = (Spinner) findViewById(R.id.spReg);
        spMKR = (Spinner) findViewById(R.id.spMKR);
        editName = (EditText) findViewById(R.id.editName);
        editAdress = (EditText) findViewById(R.id.editAdress);
        btnNext = (Button) findViewById(R.id.btnNext);

        // SPINNER TYPEFACE
        editName.setTypeface(fontRobotoMedium);
        editAdress.setTypeface(fontRobotoMedium);
        btnNext.setTypeface(fontRobotoRegular);
        btnNext.setOnClickListener(this);

/*        imgKG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent select = new Intent();
                select.setType("image/");
                select.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(select, "Select Picture"), REQUEST_CODE);
            }
        });
        */
    }

    @Override
    public void onActivityResult(int requestCode, int ResultCode, Intent data) {
        super.onActivityResult(requestCode, ResultCode, data);

        if(requestCode==REQUEST_CODE && ResultCode==RESULT_OK && data!= null && data.getData()!= null) {
            Uri uri = data.getData();
            try {
                Bitmap image = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgKG.setImageBitmap(image);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:

                stReg = "" + spReg.getSelectedItem().toString();
                stMKR = "" + spReg.getSelectedItem().toString();
                stNameKG = "" + editName.getText();
                stAdress = "" + editAdress.getText();


                //getImage(imgKG);

                DatabaseHandler db = new DatabaseHandler(this);
                db.addShortInfo(new ShortInfoData(stReg, stMKR, stNameKG, stAdress));
                List<ShortInfoData> subjects = db.getAllShortInfo();
                for (ShortInfoData cn : subjects) {
                    String log = "Id: " + cn.getShortInfoID() + " ,Region: " + cn.getShortInfoReg() + " ,MKR: " + cn.getShortInfoMKR()+ " ,Name: " + cn.getShortInfoName()+ " ,Adress: " + cn.getShortInfoAdress();
                    Log.d("Name: ", log);
                }

                startActivity(new Intent(RegistrationKGpart2.this, RegistrationKGpart3.class));

                break;
        }
    }
}
