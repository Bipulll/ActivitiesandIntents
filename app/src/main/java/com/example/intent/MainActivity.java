package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int MALE = R.id.main_activity_male;
    private final int FEMALE = R.id.main_activity_female;

    private EditText name;
    private EditText address;
    private EditText age;
    private RadioButton rb;
    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.main_activity_name);
        address  = findViewById(R.id.main_activity_address);
        age = findViewById(R.id.main_activity_age);
        Button submitBtn = findViewById(R.id.main_activity_btn_submit);
        rg = findViewById(R.id.main_activity_rg);
        rb = findViewById(FEMALE);

        submitBtn.setOnClickListener(v -> {
            checkData(name.getText().toString(), address.getText().toString(), age.getText().toString());

            int checkedRB = rg.getCheckedRadioButtonId();
            if(checkedRB < 0) {
                rb.setError("Please select a gender!");
                return;
            }

            //set the event you want to perform when button is clicked
            //you can go to another activity in your app by creating Intent
            Intent intent = new Intent(v.getContext(), MainActivity2.class);
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("address", address.getText().toString());
            intent.putExtra("age", age.getText().toString());
            intent.putExtra("gender", rb.getText().toString());
            startActivity(intent);
        });


        rg.setOnCheckedChangeListener((radioGroup, i) -> {
            switch(i) {
                case MALE:
                    rb = findViewById(MALE);
                    break;

                case FEMALE:
                    rb = findViewById(FEMALE);
                    break;
            }
        });
    }

    public void checkData(String name, String address, String age) {
        if(name.trim().equals("")) {
            this.name.setError("Please enter a name!");
            return;
        }
        else if(address.trim().equals("")) {
            this.address.setError("Please enter an address!");
            return;
        }
        else if(age.trim().equals("")) {
            this.age.setError("Please enter an age!");
            return;
        }

        try{
            Integer.parseInt(age);
        }
        catch(Exception ex) {
            this.age.setError("Please enter an age!");
        }
    }
}