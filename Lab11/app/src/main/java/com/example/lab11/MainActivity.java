package com.example.lab11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.cerc:{
                Intent it=new Intent(this,MapsActivity.class);
                it.putExtra("type","circle");
                startActivity(it);
                break;
            }
            case R.id.poligon:{
                Intent it=new Intent(this,MapsActivity.class);
                it.putExtra("type","square");
                startActivity(it);
                break;
            }

            default:
                break;
        };
        return true;
    }
}