package com.example.foysal.programminglearning;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class noteActivity extends AppCompatActivity {

    Toolbar toolbar3;
    static ArrayList<String>notes=new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    static ArrayList<String>noteTtile=new ArrayList<>();
    static ArrayAdapter arrayAdapter1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.add_note_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.add_note)
        {
            Intent intent =new Intent(getApplicationContext(),noteEditor.class);
            startActivity(intent);
            return true;

        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        toolbar3=(Toolbar) findViewById(R.id.notesToolbar);
        toolbar3.setTitle("My NoteBook");
        setSupportActionBar(toolbar3);
        ListView listView=(ListView) findViewById(R.id.noteList);
        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("com.example.foysal.programminglearning", Context.MODE_PRIVATE);
       // SharedPreferences sharedPreferences1= getSharedPreferences("com.example.foysal.programminglearning", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        HashSet<String>set=(HashSet<String>) sharedPreferences.getStringSet("notes",null);
        HashSet<String>set1=(HashSet<String>) sharedPreferences.getStringSet("notesTitle",null);
        if(set1==null) {

        }
        else
        {
            notes=new ArrayList(set);
            noteTtile=new ArrayList(set1);
        }
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,noteTtile);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent intent= new Intent(getApplicationContext(),noteEditor.class);
                intent.putExtra("noteId",i);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemDelete=i;
               new AlertDialog.Builder(noteActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
                                                               .setTitle("Are you sure?")
                                                                .setMessage("Do You want to delete this note?")
                                                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                                        notes.remove(itemDelete);
                                                                        noteTtile.remove(itemDelete);
                                                                        arrayAdapter.notifyDataSetChanged();
                                                                        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("com.example.foysal.programminglearning", Context.MODE_PRIVATE);
                                                                       // SharedPreferences sharedPreferences1= getApplicationContext().getSharedPreferences("com.example.foysal.programminglearning", Context.MODE_PRIVATE);
                                                                        HashSet<String> set=new HashSet(noteActivity.notes);
                                                                        HashSet<String>set1 =new HashSet(noteActivity.noteTtile);
                                                                        //SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                        //sharedPreferences.edit().clear();
                                                                        //sharedPreferences.edit().clear();
                                                                        sharedPreferences.edit().putStringSet("notes",set).apply();
                                                                        sharedPreferences.edit().putStringSet("noteTitle",set1).apply();
                                                                    }
                                                                }).setNegativeButton("No",null).show();


                return true;
            }
        });
    }
}
