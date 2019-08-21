package com.example.kindergarden3.Registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kindergarden3.R;

import java.io.IOException;

public class RegistrationKGpart3 extends AppCompatActivity implements View.OnClickListener {

    /*EditText etParol;
    Spinner spType, spStudent;
    String stType, stParol, s, p, nameStudent="1", passStudent="2";
    DatabaseHandler db = new DatabaseHandler(this);
    //java.util.List<StudentData> students;
    ArrayList<String> List;
    */
    private Spinner spFrom, spBefore;
    private EditText etAbout, editPrice, editAge, quantityPrice, phonePrice, site;
    private TextView tvDash;
    private Button  btnNext;
    private Typeface fontRobotoMedium, fontRobotoRegular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_kg_part3);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");


        spFrom = (Spinner) findViewById(R.id.spFrom);
        spBefore = (Spinner) findViewById(R.id.spBefore);
        etAbout = (EditText) findViewById(R.id.etAbout);
        editPrice = (EditText) findViewById(R.id.editPrice);
        editAge = (EditText) findViewById(R.id.editAge);
        quantityPrice = (EditText) findViewById(R.id.quantityPrice);
        phonePrice = (EditText) findViewById(R.id.phonePrice);
        site = (EditText) findViewById(R.id.site);
        btnNext = (Button) findViewById(R.id.btnNext);

        // SPINNER TYPEFACE
        etAbout.setTypeface(fontRobotoMedium);
        editPrice.setTypeface(fontRobotoMedium);
        editAge.setTypeface(fontRobotoMedium);
        quantityPrice.setTypeface(fontRobotoMedium);
        phonePrice.setTypeface(fontRobotoMedium);
        site.setTypeface(fontRobotoMedium);
        btnNext.setTypeface(fontRobotoRegular);
        btnNext.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                startActivity(new Intent(RegistrationKGpart3.this, RegistrationKGpart4.class));
                break;

           /* case R.id.loginButton:
                stParol = etParol.getText().toString();
                etParol.setText("");
                stType=spType.getSelectedItem().toString();
                nameStudent = spStudent.getSelectedItem().toString();
                System.out.println(spStudent.getSelectedItem().toString()+" --------- "+stParol);
                for(StudentData cn : students){
                    s = cn.getStudentName();
                    p = cn.getStudentPhone();
                    if(nameStudent==s){
                        passStudent=p;
                    }
                }
                System.out.println(nameStudent+" --------- "+passStudent);

                if (stType.equals("Мұғәлім") && stParol.equals("12345")) {
                    Intent intent2 = new Intent(this, MainActivity.class);
                    startActivity(intent2);
                }
                else if (stType.equals("Оқушы") && nameStudent.equals(nameStudent) && stParol.equals(passStudent)) {
                    Intent intent = new Intent(this, MainActivity1.class);
                    intent.putExtra("sName", nameStudent);
                    intent.putExtra("sPass", passStudent);
                    startActivity(intent);
                }
                else if (stType.equals("Мұғәлім") && (stParol.equals(""))) {
                    Toast.makeText(Authorization.this, "Құпия сөзді енгізіңіз", Toast.LENGTH_SHORT).show();
                }
                else if (stType.equals("Админ") && stParol.equals("admin")) {
                    Intent intent1 = new Intent(this, MainActivity2.class);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(Authorization.this, "Құпия сөз дұрыс емес", Toast.LENGTH_SHORT).show();
                }

                break;*/
        }
    }
}
