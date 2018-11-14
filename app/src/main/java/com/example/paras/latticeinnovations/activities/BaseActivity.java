package com.example.paras.latticeinnovations.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.paras.latticeinnovations.R;

public class BaseActivity extends AppCompatActivity {

    private Button btnCreate, userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        userList = (Button) findViewById(R.id.userList);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(BaseActivity.this,SignUp.class);
                startActivity(signUp);
            }
        });
    }
}
