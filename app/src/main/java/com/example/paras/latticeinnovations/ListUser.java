package com.example.paras.latticeinnovations;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.paras.latticeinnovations.helper.DatabaseHelper;

import java.util.ArrayList;

public class ListUser extends AppCompatActivity {
    ListView lvUser;
    DatabaseHelper helper = new DatabaseHelper(ListUser.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        lvUser = (ListView) findViewById(R.id.lvUser);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = helper.getAllData();
        if(data.getCount()== 0)
        {
            Toast.makeText(ListUser.this,"Database empty",Toast.LENGTH_LONG).show();
        }
        else {
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                lvUser.setAdapter(listAdapter);
            }
        }
    }
}
