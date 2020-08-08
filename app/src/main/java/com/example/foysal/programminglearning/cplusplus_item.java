package com.example.foysal.programminglearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class cplusplus_item extends AppCompatActivity {
    TextView textView_cplusplus;
    Toolbar cctoolBar;

    public String cplusplus_item(InputStream input) {
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
        setContentView(R.layout.activity_cplusplus_item);
        cctoolBar = (Toolbar) findViewById(R.id.toolbar_cplusplus_item);
        textView_cplusplus = (TextView) findViewById(R.id.textView_library);
        Bundle cbundle = getIntent().getExtras();
        if (cbundle != null) {
            cctoolBar.setTitle(cbundle.getString("SubName"));
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("library")) {
                InputStream input = getResources().openRawResource(R.raw.library_code);
                textView_cplusplus.setText(cplusplus_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Variable")) {
                InputStream input = getResources().openRawResource(R.raw.variable);
                textView_cplusplus.setText(cplusplus_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Input-Output System")) {
                InputStream input = getResources().openRawResource(R.raw.inputoutputsystem);
                textView_cplusplus.setText(cplusplus_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Array")) {
                InputStream input = getResources().openRawResource(R.raw.array);
                textView_cplusplus.setText(cplusplus_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("String")) {
                InputStream input = getResources().openRawResource(R.raw.string);
                textView_cplusplus.setText(cplusplus_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("File input-output System")) {
                InputStream input = getResources().openRawResource(R.raw.file_input_output_system);
                textView_cplusplus.setText(cplusplus_item(input));
            }
            if (cctoolBar.getTitle().toString().equalsIgnoreCase("Min-Max")) {
                InputStream input = getResources().openRawResource(R.raw.min_max);
                textView_cplusplus.setText(cplusplus_item(input));
            }

        }
    }
}
