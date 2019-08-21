package com.example.kindergarden3.Registration;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kindergarden3.R;
import com.example.kindergarden3.Tab.Tab;

public class RegistrationKGpart4 extends AppCompatActivity implements View.OnClickListener {

    /*EditText etParol;
    Spinner spType, spStudent;
    String stType, stParol, s, p, nameStudent="1", passStudent="2";
    DatabaseHandler db = new DatabaseHandler(this);
    //java.util.List<StudentData> students;
    ArrayList<String> List;
    */
    private Button  btnFinish;
    private EditText editLogin, editPass, editPassRepeat;
    private Typeface fontRobotoMedium, fontRobotoRegular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_kg_part4);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        editLogin = (EditText) findViewById(R.id.editLogin);
        editPass = (EditText) findViewById(R.id.editPass);
        editPassRepeat = (EditText) findViewById(R.id.editPassRepeat);
        editLogin.setTypeface(fontRobotoRegular);
        editPass.setTypeface(fontRobotoRegular);
        editPassRepeat.setTypeface(fontRobotoRegular);

        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setTypeface(fontRobotoRegular);
        btnFinish.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFinish:
                startActivity(new Intent(RegistrationKGpart4.this, Tab.class));
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
