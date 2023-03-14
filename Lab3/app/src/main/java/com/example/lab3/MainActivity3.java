package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private int[]arr=new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //Toast.makeText(this,"onCreate() MainActivity3",Toast.LENGTH_SHORT).show();
        //int[] integers=new int[2];
        this.arr=getIntent().getExtras().getIntArray("myintegers");
        Toast.makeText(this,"My integers are: "+this.arr[0]+" "+this.arr[1],Toast.LENGTH_SHORT).show();
    }

    public void goodbye(View view){
//       finish();
        Intent intent=new Intent(this, MainActivity2.class);
        intent.putExtra("suma",this.arr[0]+this.arr[1]);
        finish();
    }
}