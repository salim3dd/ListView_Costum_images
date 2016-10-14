package com.qays3dd.listview_costum_images;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ls = (ListView) findViewById(R.id.listView);


        List list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + " - New Text");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        //String[] names = getResources().getStringArray(R.array.Names);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.row_item,R.id.textView,names);

        ls.setAdapter(arrayAdapter);


    }

    public void Go(View view) {
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }
}
