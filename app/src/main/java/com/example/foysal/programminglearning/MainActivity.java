package com.example.foysal.programminglearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button buttonA,buttonB,buttonC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        buttonA=(Button) findViewById(R.id.btn1);
        buttonB=(Button) findViewById(R.id.btn2);
        buttonC=(Button) findViewById(R.id.btn3);
        buttonA.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CplusPlus_activity.class);
               // intent.putExtra("cplusplus","Cplusplus");
                startActivity(intent);
            }
        }
        );
        buttonB.setOnClickListener(new View.OnClickListener() {

                                       public void onClick(View view) {
                                           Intent intent = new Intent(MainActivity.this, Algorithm_activity.class);
                                           //intent.putExtra("Algorithm","Cplusplus");
                                           startActivity(intent);
                                       }
                                   }
        );
        buttonC.setOnClickListener(new View.OnClickListener() {

                                       public void onClick(View view) {
                                           Intent intent = new Intent(MainActivity.this, noteActivity.class);
                                          // intent.putExtra("cplusplus","Cplusplus");
                                           startActivity(intent);
                                       }
                                   }
        );
    }
}
