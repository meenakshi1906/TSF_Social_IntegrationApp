package com.example.tsf_social_integrationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class next_page extends AppCompatActivity {
     TextView name;
    TextView age;
    TextView lives;
    TextView from;
    TextView studied;
    TextView works;
    TextView position;
    TextView mail;
    TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_page);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        lives = findViewById(R.id.lives);
        from = findViewById(R.id.from);
        studied = findViewById(R.id.studied);
        works = findViewById(R.id.works);
        position = findViewById(R.id.position);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);

        String username = getIntent().getStringExtra("name");
        name.setText(username);

        int age_index = getIntent().getIntExtra("age",20);
        age.setText(age_index);

        String lives_in = getIntent().getStringExtra("lives");
        lives.setText(lives_in);

        int phone_no = getIntent().getIntExtra("phone",923892893);
        from.setText(phone_no);

        String from = getIntent().getStringExtra("hometown");
        studied.setText(from);

        String studied_in = getIntent().getStringExtra("studied");
        works.setText(studied_in);

        String works_at = getIntent().getStringExtra("works");
        position.setText(works_at);

        String current_position = getIntent().getStringExtra("position");
        mail.setText(current_position);

        String e_mail = getIntent().getStringExtra("mail");
        phone.setText(e_mail);






  }


}
