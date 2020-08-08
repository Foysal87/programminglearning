package com.example.foysal.programminglearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CplusPlus_activity extends AppCompatActivity {
    Toolbar toolbar1;
    ListView cplusplus_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus_plus_activity);
        toolbar1=(Toolbar) findViewById(R.id.toolbar_cplusplus);
        toolbar1.setTitle(getResources().getString(R.string.cplusplus));
        cplusplus_listView=(ListView) findViewById(R.id.cplusplus_listview);
        ArrayAdapter<String> cAdapter = new ArrayAdapter<String>(CplusPlus_activity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cplusplusitem)
                );
        cplusplus_listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(CplusPlus_activity.this,cplusplus_item.class);
                intent.putExtra("SubName",cplusplus_listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
        cplusplus_listView.setAdapter(cAdapter);
    }
}
