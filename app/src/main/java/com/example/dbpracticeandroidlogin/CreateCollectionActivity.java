package com.example.dbpracticeandroidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateCollectionActivity extends AppCompatActivity {

    Button addBtn;
    ArrayList <String> addArray = new ArrayList<String>();
    EditText word;
    EditText translation;
    ListView display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_collection);

        word = (EditText)findViewById(R.id.word);
        translation = (EditText)findViewById(R.id.translation);
        display = (ListView)findViewById(R.id.wordList);
        addBtn=(Button)findViewById(R.id.addWordBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = word.getText().toString() + "-" + translation.getText().toString();

                if(addArray.contains(getInput)){
                    Toast.makeText(getBaseContext(),"Word already exists in this collection.",Toast.LENGTH_LONG).show();
                }
                else if(word==null||translation==null){
                    Toast.makeText(getBaseContext(),"Word already exists in this collection.",Toast.LENGTH_LONG).show();
                }
                else{
                    addArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateCollectionActivity.this, android.R.layout.simple_list_item_1, addArray);
                    display.setAdapter(adapter);
                    ((EditText)findViewById(R.id.word)).setText(" ");
                    ((EditText)findViewById(R.id.translation)).setText(" ");
                }
            }
        });
    }
}