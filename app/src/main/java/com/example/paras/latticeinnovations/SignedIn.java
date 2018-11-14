package com.example.paras.latticeinnovations;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.paras.latticeinnovations.helper.DatabaseHelper;

public class SignedIn extends AppCompatActivity {

    Button viewData;
    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signed_in);

        viewData = (Button) findViewById(R.id.btnViewData);

        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignedIn.this,ListUser.class);
                startActivity(intent);
            }
        });

    }
}



