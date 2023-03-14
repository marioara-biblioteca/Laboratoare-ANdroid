package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private  static String tag="MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Toast.makeText(this,"onCreate() MainActivity2",Toast.LENGTH_SHORT).show();
       
           if(getIntent().getExtras()!=null){
               int suma=getIntent().getExtras().getInt("suma");
               Toast.makeText(this,"Suma este "+suma,Toast.LENGTH_SHORT).show();
           }
    }

    public void goToMainActivity3(View view){
        Intent intent=new Intent(this,MainActivity3.class);
        int[] integers=new int[2];
        integers[0]=0;
        integers[1]=1;
        intent.putExtra("myintegers",integers);
        startActivity(intent);

    }



}