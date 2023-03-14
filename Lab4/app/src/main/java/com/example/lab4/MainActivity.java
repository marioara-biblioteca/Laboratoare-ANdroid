package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goToCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        if(intent.getExtras()!=null){
            ACVariu acVariu=(ACVariu) intent.getSerializableExtra("acvariu");
            Log.d("primire",acVariu.toString());
        }
        goToCreate=findViewById(R.id.goToCreate);
        goToCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CreareObiecteActivity.class);
                startActivity(intent);
            }
        });

    }
}