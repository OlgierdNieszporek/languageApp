package com.example.dbpracticeandroidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CollectionsActivity extends AppCompatActivity {
    Button createColectionBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);

        createColectionBtn = (Button) findViewById(R.id.createColectionBtn);
        createColectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CreateCollectionActivity.class);
                startActivity(intent);
            }
        });
    }
}