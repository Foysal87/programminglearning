package com.example.foysal.programminglearning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class noteEditor extends AppCompatActivity {

    int noteId;
    Toolbar toolbar4;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
        toolbar4=(Toolbar) findViewById(R.id.note_editor);
        toolbar4.setTitle("New Algorithm");
        EditText editText=(EditText) findViewById(R.id.editText);
        EditText editText1=(EditText) findViewById(R.id.editText1);

        Intent intent=getIntent();
        noteId=intent.getIntExtra("noteId",-1);
        if(noteId!=-1)
        {
            editText.setText(noteActivity.notes.get(noteId));
            editText1.setText(noteActivity.noteTtile.get(noteId));

        }
        else
        {
            noteActivity.notes.add("");
            noteActivity.noteTtile.add("");
            noteId=noteActivity.notes.size()-1;
            noteActivity.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    noteActivity.notes.set(noteId,String.valueOf(charSequence));
                SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("com.example.foysal.programminglearning", Context.MODE_PRIVATE);
                HashSet<String> set=new HashSet(noteActivity.notes);
               // HashSet<String>set1 =new HashSet<>(noteActivity.noteTtile);
                sharedPreferences.edit().clear();
                sharedPreferences.edit().putStringSet("notes",set).apply();
               // sharedPreferences.edit().putStringSet("noteTitle",set1).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                noteActivity.noteTtile.set(noteId,String.valueOf(charSequence));
                noteActivity.arrayAdapter.notifyDataSetChanged();
                SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("com.example.foysal.programminglearning", Context.MODE_PRIVATE);
                //HashSet<String> set=new HashSet<>(noteActivity.notes);
                HashSet<String>set1 =new HashSet(noteActivity.noteTtile);
                //sharedPreferences.edit().putStringSet("notes",set).apply();
                sharedPreferences.edit().clear();
                sharedPreferences.edit().putStringSet("noteTitle",set1).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
