package com.example.dbpracticeandroidlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button collectionsBtn;
    Button practiceBtn;
    Button testBtn;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        setContentView(R.layout.activity_home);
        ((TextView)findViewById(R.id.userInfo)).setText("Username: " + username);

        collectionsBtn=(Button) findViewById(R.id.collectionsBtn);
        practiceBtn=(Button) findViewById(R.id.practiceBtn);
        testBtn=(Button) findViewById(R.id.testBtn);

        collectionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CollectionsActivity.class);
                startActivity(intent);

            }
        }
        );
    }
}