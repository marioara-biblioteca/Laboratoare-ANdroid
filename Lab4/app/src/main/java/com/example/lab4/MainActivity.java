package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab4.lab6.ACVariu;
import com.example.lab4.lab6.AcvariuActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button goToCreate;
    private List<ACVariu> acvarii=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        if(intent.getExtras()!=null){
            ACVariu acVariu=(ACVariu) intent.getSerializableExtra("acvariu");
            Log.d("primire",acVariu.toString());
            acvarii.add(acVariu);//Acest obiect îl adăugați într-o listă de obiecte.
            acvarii.add(new ACVariu(2,3,4));
        }

        if(acvarii!=null){
            ArrayAdapter<ACVariu> acvariuAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,acvarii);
            ListView lv=findViewById(R.id.listView);
            lv.setAdapter(acvariuAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity.this,acvarii.get(i).toString(),Toast.LENGTH_SHORT).show();
                }
            });
            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                    acvariuAdapter.remove(acvariuAdapter.getItem(i));
                    acvariuAdapter.notifyDataSetChanged();
                    //face automat si asta
                    //acvarii.remove(i);//va fi sters din lista de obiecte
                    return true;
                }
            });
        }
        goToCreate=findViewById(R.id.goToCreate);
        goToCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CreareObiecteActivity.class);
                startActivity(intent);
            }
        });

        Button goToPestiAdapter=findViewById(R.id.customPestiAdapter);
        goToPestiAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AcvariuActivity.class);
                startActivity(intent);
            }
        });

    }
}