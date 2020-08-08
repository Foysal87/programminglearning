package com.example.foysal.programminglearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Algorithm_activity extends AppCompatActivity {
   Toolbar toolbar2;
    ListView algorithmListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_activity);
        toolbar2=(Toolbar) findViewById(R.id.toolbar_algorithm);
        toolbar2.setTitle(getResources().getString(R.string.algorithm));
        algorithmListView=(ListView) findViewById(R.id.algorithmListView);
        ArrayAdapter<String> cAdapter = new ArrayAdapter<String>(Algorithm_activity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.algorithmitem)
        );
        algorithmListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(Algorithm_activity.this,Algorithm_item.class);
                intent.putExtra("SubName2",algorithmListView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
        algorithmListView.setAdapter(cAdapter);
    }
}