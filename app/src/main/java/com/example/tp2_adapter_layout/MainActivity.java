package com.example.tp2_adapter_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView notesList;
    AutoCompleteTextView matierList;
    String[][] mesNotes = {
            {"12", "14", "9"},
            {"10", "19"},
            {"14"}
    };
    String[] mesMatieres = {"anglais", "java", "android"};
    HashMap<String, String[]> matiereNoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //https://www.youtube.com/watch?v=4l2cEESo50E
        matiereNoteList = new HashMap<String, String[]>();
        matiereNoteList.put("anglais", new String[] {"12", "14", "9"});
        matiereNoteList.put("java", new String[] {"10", "19"});
        matiereNoteList.put("android", new String[] {"14"});

        matierList = (AutoCompleteTextView) findViewById(R.id.matiereTv);
        ArrayAdapter<String> matierListAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, (String[]) matiereNoteList.keySet().toArray(new String[0]));
        matierList.setAdapter(matierListAdapter);
        matierList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s= (String) matierList.getAdapter().getItem(position);
                showMatiereNotesList(s);
            }
        });
    }

    private void showNotesList(int matiereIndex){
        notesList = findViewById(R.id.notesList);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, mesNotes[matiereIndex]);
        notesList.setAdapter(listAdapter);
        final String[] res = {"reussite"};
        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s= (String) notesList.getAdapter().getItem(position);
                if (Integer.parseInt(s) < 10) {
                    res[0] = "echec";
                } else {
                    res[0] = "reussite";
                }
                Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(position).toString(), 12);
                toast.show();
            }
        });
    }

    private void showMatiereNotesList(String matiereIndex){
        notesList = findViewById(R.id.notesList);
        //ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
        //        this, android.R.layout.simple_list_item_1, matiereNoteList.get(matiereIndex));
        //notesList.setAdapter(listAdapter);
        notesList.setAdapter(new MaLigneAdapter(this, matiereNoteList.get(matiereIndex)));
        final String[] res = {"reussite"};
        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s= (String) notesList.getAdapter().getItem(position);
                if (Integer.parseInt(s) < 10) {
                    res[0] = "echec";
                } else {
                    res[0] = "reussite";
                }

            }
        });
    }}