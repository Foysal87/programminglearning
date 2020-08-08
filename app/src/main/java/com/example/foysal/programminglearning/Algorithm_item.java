package com.example.foysal.programminglearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Algorithm_item extends AppCompatActivity {
    TextView textView_cplusplus, textView_cplusplus_code;
    Toolbar cctoolBar;

    public String algorithm_item(InputStream input) {
        String str = "";
        try {
            byte[] buffer = new byte[input.available()];
            while (input.read(buffer) != -1) {
                str = new String(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;


    }
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm_item);
        cctoolBar = (Toolbar) findViewById(R.id.toolbar_algorithm_item);
        textView_cplusplus = (TextView) findViewById(R.id.textView_library3);
        Bundle cbundle = getIntent().getExtras();
        if (cbundle != null) {
            cctoolBar.setTitle(cbundle.getString("SubName2"));
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("nCr modulo Prime Power")) {
                InputStream input = getResources().openRawResource(R.raw.algo1);
                textView_cplusplus.setText(algorithm_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Sum of nCi where i is upto k")) {
                InputStream input = getResources().openRawResource(R.raw.algo2);
                textView_cplusplus.setText(algorithm_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Number of Solutions of a Equation")) {
                InputStream input = getResources().openRawResource(R.raw.algo3);
                textView_cplusplus.setText(algorithm_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Prime Factorization Large")) {
                InputStream input = getResources().openRawResource(R.raw.algo4);
                textView_cplusplus.setText(algorithm_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Prime Counting Function")) {
                InputStream input = getResources().openRawResource(R.raw.algo5);
                textView_cplusplus.setText(algorithm_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Power Tower")) {
                InputStream input = getResources().openRawResource(R.raw.algo6);
                textView_cplusplus.setText(algorithm_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Mobius Function")) {
                InputStream input = getResources().openRawResource(R.raw.algo7);
                textView_cplusplus.setText(algorithm_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Modular Inverse")) {
                InputStream input = getResources().openRawResource(R.raw.algo8);
                textView_cplusplus.setText(algorithm_item(input));
            }
        }
    }
}
