package com.example.kindergarden3.Registration;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kindergarden3.R;

public class RegistrationParentpart3 extends AppCompatActivity implements View.OnClickListener {

    /*EditText etParol;
    Spinner spType, spStudent;
    String stType, stParol, s, p, nameStudent="1", passStudent="2";
    DatabaseHandler db = new DatabaseHandler(this);
    //java.util.List<StudentData> students;
    ArrayList<String> List;
    */

    private static final int DIALOG_ID = 1;
    int myHour = 00;
    int myMinute = 00;
    private ImageView addImageChild;
    private Spinner spGender;
    private EditText editNameChild;
    private Button  btnNext, birthdayChild;
    private Typeface fontRobotoMedium, fontRobotoRegular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_parent_part3);

        fontRobotoMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        fontRobotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");


        addImageChild = (ImageView) findViewById(R.id.addImageChild);
        spGender = (Spinner) findViewById(R.id.spGender);
        editNameChild = (EditText) findViewById(R.id.editNameChild);
        birthdayChild = (Button) findViewById(R.id.birthdayChild);
        btnNext = (Button) findViewById(R.id.btnNext);

        // SPINNER TYPEFACE
        editNameChild.setTypeface(fontRobotoMedium);
        birthdayChild.setTypeface(fontRobotoMedium);
        btnNext.setTypeface(fontRobotoMedium);
        btnNext.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNext:
                startActivity(new Intent(RegistrationParentpart3.this, RegistrationParentpart4.class));
                break;

            case R.id.birthdayChild:
                showDialog(DIALOG_ID);
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

    @Override
    protected Dialog onCreateDialog(int id) {
            if (id == DIALOG_ID) {
            return new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    birthdayChild.setText(year + "-" + getResources().getStringArray(R.array.months)[monthOfYear] + "-" +
                            dayOfMonth );
                }
            }, 2019, 8, 23);
        }
        return super.onCreateDialog(id);
    }
}
