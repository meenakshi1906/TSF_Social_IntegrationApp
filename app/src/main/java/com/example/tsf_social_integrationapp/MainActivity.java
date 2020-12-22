package com.example.tsf_social_integrationapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    LinearLayout expandableView;
    Button arrowBtn;
    LinearLayout cardView;
    LinearLayout expandableView1;
    Button arrowBtn1;
    EditText email, password;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardView = findViewById(R.id.cardView);

        expandableView1 = findViewById(R.id.expandableView1);
        arrowBtn1 = findViewById(R.id.arrowBtn1);

        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });

        arrowBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView1.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView1.setVisibility(View.VISIBLE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView1.setVisibility(View.GONE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });


    }


    public void Login_Fn(View view){

        String emailEntered= email.getText().toString();
        String passwordEntered= password.getText().toString();

        Intent intent = new Intent(this, next_page.class);

        try {


            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("User_details", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS haha(sr_no INT PRIMARY KEY, name VARCHAR,age INT(3),lives_in TEXT,hometown TEXT,studied_in TEXT,works_at TEXT,current_position TEXT,password VARCHAR,mail VARCHAR,phone INT(10))");
            sqLiteDatabase.execSQL("Insert into haha(sr_no,name,age,lives_in,hometown,studied_in,works_at,current_position,mail,phone,password) values (1,'Mansi',19,'Vizag','Delhi','Navy Children School','Not yet working','Student','mansi2001@yahoo.co.in',8938292995,'abc')");
            sqLiteDatabase.execSQL("Insert into haha(sr_no,name,age,lives_in,hometown,studied_in,works_at,current_position,mail,phone,password) values (2,'Devika',25,'Kochi','Aluva','GEC-Thrissur','TCS','Assistant Engineer','devu491@gmail.com',9495001314,'efg')");
            sqLiteDatabase.execSQL("Insert into haha(sr_no,name,age,lives_in,hometown,studied_in,works_at,current_position,mail,phone,password) values (3,'Meenakshi',20,'Kochi','Aluva','CUSAT','Not yet working','Student','meenu20001906@gmail.com',7306362322,'hij')");
            sqLiteDatabase.execSQL("Insert into haha(sr_no,name,age,lives_in,hometown,studied_in,works_at,current_position,mail,phone,password) values (4,'Juliet',19,'Kochi','Kochi','CUSAT','Not yet working','Student','juliet@gmail.com',8714479304,'xyz')");
            Cursor no_of_rows = sqLiteDatabase.rawQuery("SELECT COUNT() FROM haha",null);
            Log.d(TAG,"no of rows is "+no_of_rows);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM haha WHERE mail="+emailEntered+" AND password="+passwordEntered,null);

            int name_index = cursor.getColumnIndex("name");
            int age_index = cursor.getColumnIndex("age");
            int lives_index = cursor.getColumnIndex("lives_in");
            int hometown_index = cursor.getColumnIndex("hometown");
            int studied_index = cursor.getColumnIndex("studied_in");
            int works_index = cursor.getColumnIndex("works_at");
            int position_index = cursor.getColumnIndex("current_position");
            int mail_index = cursor.getColumnIndex("mail");
            int phone_index = cursor.getColumnIndex("phone");


                intent.putExtra("name", cursor.getString(name_index));
                intent.putExtra("age", cursor.getInt(age_index));
                intent.putExtra("lives", cursor.getString(lives_index));
                intent.putExtra("hometown", cursor.getString(hometown_index));
                intent.putExtra("studied", cursor.getString(studied_index));
                intent.putExtra("works", cursor.getString(works_index));
                intent.putExtra("position", cursor.getString(position_index));
                intent.putExtra("mail", cursor.getString(mail_index));
                intent.putExtra("phone", cursor.getInt(phone_index));
                startActivity(intent);

              Toast.makeText(this, "Profile of " + cursor.getString(name_index), Toast.LENGTH_LONG).show();


            while (cursor==null){
                Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}