package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String age = getIntent().getStringExtra("age");
        String gender = getIntent().getStringExtra("gender");

        TextView tvName = findViewById(R.id.main_activity2_name_result);
        TextView tvAddress = findViewById(R.id.main_activity2_address_result);
        TextView tvAge = findViewById(R.id.main_activity2_age_result);
        TextView tvGender = findViewById(R.id.main_activity2_gender_result);
        Button btnClose = findViewById(R.id.main_activity2_btn_close);

        tvName.setText(name);
        tvAddress.setText(address);
        tvAge.setText(age);
        tvGender.setText(gender);

        btnClose.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }
}