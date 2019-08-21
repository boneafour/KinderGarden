package com.example.kindergarden3.Authorization;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.kindergarden3.R;
import com.example.kindergarden3.Registration.RegistrationChoose;
import com.example.kindergarden3.Tab.Tab;

public class Authorization extends AppCompatActivity implements View.OnClickListener {

    /*EditText etParol;
    Spinner spType, spStudent;
    String stType, stParol, s, p, nameStudent="1", passStudent="2";
    DatabaseHandler db = new DatabaseHandler(this);
    //java.util.List<StudentData> students;
    ArrayList<String> List;
    */
    private TextView Login, ResetPass, Register;
    private EditText editLogin, editPass;
    private Button loginButton, registerButton;
    private Typeface fontRobotoMedium, fontRobotoRegular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        Login = (TextView) findViewById(R.id.tvLogin);
        ResetPass = (TextView) findViewById(R.id.tvResetPass);
        Register = (TextView) findViewById(R.id.tvRegister);
        editLogin = (EditText) findViewById(R.id.editLogin);
        editPass = (EditText) findViewById(R.id.editPass);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        Login.setTypeface(fontRobotoMedium);
        loginButton.setTypeface(fontRobotoMedium);
        registerButton.setTypeface(fontRobotoMedium);
        ResetPass.setTypeface(fontRobotoRegular);
        Register.setTypeface(fontRobotoRegular);
        editLogin.setTypeface(fontRobotoRegular);
        editPass.setTypeface(fontRobotoRegular);

        loginButton.setOnClickListener(this);
        ResetPass.setOnClickListener(this);
        registerButton.setOnClickListener(this);

       /* spType = (Spinner) findViewById(R.id.type);
        java.util.List<String> list = new ArrayList<String>();
        list.add("Мұғәлім");
        list.add("Оқушы");
        list.add("Админ");
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, R.layout.activity_spinner, list);
        spType.setAdapter(dataAdapter);




        etParol = (EditText) findViewById(R.id.parol);



        students = db.getAllStudents();
        List = new ArrayList<String>();

        List.add("Оқушыны танданыз:");
        for(StudentData cn : students){
            s = cn.getStudentName();
            List.add(s);
        }
        spStudent = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter teacherAdapter = new ArrayAdapter(this,R.layout.activity_spinner, List);
        spStudent.setAdapter(teacherAdapter);
*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                startActivity(new Intent(Authorization.this, Tab.class));
                break;

            case R.id.tvResetPass:
                startActivity(new Intent(Authorization.this, com.example.kindergarden3.ResetPassword.ResetPass.class));
                break;

            case R.id.registerButton:
                startActivity(new Intent(Authorization.this, RegistrationChoose.class));
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
