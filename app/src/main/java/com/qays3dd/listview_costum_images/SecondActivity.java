package com.qays3dd.listview_costum_images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    int bird[] = {R.drawable.bird_1,
            R.drawable.bird_2,
            R.drawable.bird_3,
            R.drawable.bird_4,
            R.drawable.bird_5,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView ls = (ListView) findViewById(R.id.listView2);

        ArrayList<listItmeA> listA = new ArrayList<listItmeA>();

        String[]names = getResources().getStringArray(R.array.Names);
        int id=0;
        for(String i : names){
            listA.add(new listItmeA(id, bird[id],i,"-"));
            id++;
        }


        ListAdapter listAdapter = new ListAdapter(listA);
        ls.setAdapter(listAdapter);


    }

    class ListAdapter extends BaseAdapter {
        ArrayList<listItmeA> list = new ArrayList<listItmeA>();

        ListAdapter(ArrayList<listItmeA> list2) {
            this.list = list2;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position).name;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.row_item2, null);
            TextView Title = (TextView) view.findViewById(R.id.textView2);
            TextView txtid = (TextView) view.findViewById(R.id.textView_id);
            ImageView img = (ImageView) view.findViewById(R.id.imageView2);

            Title.setText(list.get(i).name);
            txtid.setText(String.valueOf(list.get(i).id));
            img.setImageResource(list.get(i).img);
            final int n = i;
            Button btn = (Button) view.findViewById(R.id.button2);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), n + " - btn", Toast.LENGTH_SHORT).show();
                }
            });


            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), n + " - img", Toast.LENGTH_SHORT).show();
                }
            });

            Title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), n + " - Title", Toast.LENGTH_SHORT).show();
                }
            });


            return view;
        }
    }
}
