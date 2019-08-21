package com.example.kindergarden3.Registration;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kindergarden3.Authorization.Authorization;
import com.example.kindergarden3.R;
import com.example.kindergarden3.Tab.Tab;

public class RegistrationChoose extends AppCompatActivity implements View.OnClickListener {

    /*EditText etParol;
    Spinner spType, spStudent;
    String stType, stParol, s, p, nameStudent="1", passStudent="2";
    DatabaseHandler db = new DatabaseHandler(this);
    //java.util.List<StudentData> students;
    ArrayList<String> List;
    */
    private TextView tvPart, tvChoose, tvPrivacyPolicy;
    private Button btnKinderGarden, btnParent;
    private Typeface fontRobotoMedium, fontRobotoRegular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_part_one);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        tvPart = (TextView) findViewById(R.id.tvPart);
        tvChoose = (TextView) findViewById(R.id.tvChoose);
        tvPrivacyPolicy = (TextView) findViewById(R.id.tvPrivacyPolicy);
        btnKinderGarden = (Button) findViewById(R.id.btnKinderGarden);
        btnParent = (Button) findViewById(R.id.btnParent);

        tvPart.setTypeface(fontRobotoMedium);
        tvChoose.setTypeface(fontRobotoMedium);
        tvPrivacyPolicy.setTypeface(fontRobotoMedium);
        btnKinderGarden.setTypeface(fontRobotoRegular);
        btnParent.setTypeface(fontRobotoRegular);

        btnKinderGarden.setOnClickListener(this);
        btnParent.setOnClickListener(this);
        tvPrivacyPolicy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnKinderGarden:
                startActivity(new Intent(RegistrationChoose.this, RegistrationKGpart2.class));
                break;

            case R.id.btnParent:
                startActivity(new Intent(RegistrationChoose.this, RegistrationParentpart2.class));
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
