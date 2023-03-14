package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
/*
Log.v(); // Verbose
Log.d(); // Debug
Log.i(); // Info
Log.w(); // Warning
Log.e(); // Error
*/
public class MainActivity extends AppCompatActivity {
    private  static String tag="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this,"onCreate() MainActivity",Toast.LENGTH_SHORT).show();
        Log.d(tag,"onCreate() debug MainActivity");
        Log.e(tag,"onCreate() error MainActivity");
        Log.v(tag,"onCreate() verbose MainActivity");
        Log.w(tag,"onCreate() warning MainActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this,"onStart() MainActivity",Toast.LENGTH_SHORT).show();
        Log.d(tag,"onStart() MainActivity");
        Log.e(tag,"onStart() error MainActivity");
        Log.v(tag,"onStart() verbose MainActivity");
        Log.w(tag,"onStart() warning MainActivity");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(this,"onRestart() MainActivity",Toast.LENGTH_SHORT).show();
        Log.d(tag,"onRestart() MainActivity");
        Log.e(tag,"onRestart() error MainActivity");
        Log.v(tag,"onRestart() verbose MainActivity");
        Log.w(tag,"onRestart() warning MainActivity");
    }
    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this,"onResume() MainActivity",Toast.LENGTH_SHORT).show();
        Log.d(tag,"onResume() MainActivity");
        Log.e(tag,"onResume() error MainActivity");
        Log.v(tag,"onResume() verbose MainActivity");
        Log.w(tag,"onResume() warning MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this,"onPause() MainActivity",Toast.LENGTH_SHORT).show();
        Log.d(tag,"onPause() MainActivity");
        Log.e(tag,"onPause() error MainActivity");
        Log.v(tag,"onPause() verbose MainActivity");
        Log.w(tag,"onPause() warning MainActivity");
    }
    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this,"onStop() MainActivity",Toast.LENGTH_SHORT).show();
        Log.d(tag,"onStop() MainActivity");
        Log.e(tag,"onStop() error MainActivity");
        Log.v(tag,"onStop() verbose MainActivity");
        Log.w(tag,"onStop() warning MainActivity");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this,"onDestroy() MainActivity",Toast.LENGTH_SHORT).show();
        Log.d(tag,"onDestroy() MainActivity");

    }
    public void goToMainActivity2(View view){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public void close(View view){
        finish();
        System.exit(0);
    }
}