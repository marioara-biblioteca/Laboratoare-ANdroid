package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CreareObiecteActivity extends AppCompatActivity {
    Button trimite;
    CheckBox peste1,peste2,peste3;
    EditText material;
    Spinner capacitatePesti;
    RadioButton necesitaCuratare;
    static int idPesti=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_obiecte);

        String[] items = new String[]{"1","2","3","4"};

        peste1=(CheckBox)findViewById(R.id.pesteAuriu);
        peste2=(CheckBox)findViewById(R.id.pesteClaun);
        peste3=(CheckBox)findViewById(R.id.pesteCoral);
        material=(EditText)findViewById(R.id.material);
        capacitatePesti=(Spinner) findViewById(R.id.capacitate);
        necesitaCuratare=(RadioButton) findViewById(R.id.curatare);
        trimite=(Button) findViewById(R.id.trimite);

        trimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACVariu acVariu=new ACVariu(1,2,3);
                List<Peste> pesti=new ArrayList<>();

                if(necesitaCuratare.isChecked())
                    acVariu.setTrebuieSpalat(true);
                else acVariu.setTrebuieSpalat(false);

                Log.d("acvariu","spalat setata");

                if(material.getText()!=null) {
                    acVariu.setMaterial(material.getText().toString());
                    Log.d("acvariu","material setata");
                }

                if(peste1.isChecked())
                    pesti.add(new Peste("peste auriu",idPesti++));
                if(peste2.isChecked())
                    pesti.add(new Peste("peste clown",idPesti++));
                 if(peste3.isChecked())
                    pesti.add(new Peste("peste coral",idPesti++));

                 ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreareObiecteActivity.this,android.R.layout.simple_spinner_item, items);
                capacitatePesti.setAdapter(adapter);
                capacitatePesti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        acVariu.setCapacitatePesti(Integer.valueOf(parent.getItemAtPosition(position).toString()));
                        Log.d("acvariu","capacitate setata");
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub
                    }
                });

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("acvariu",acVariu);
                startActivity(intent);

            }
        });
    }
}