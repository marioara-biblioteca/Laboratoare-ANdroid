package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.example.lab4.lab6.ACVariu;
import com.example.lab4.lab6.Peste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CreareObiecteActivity extends AppCompatActivity {
    Button trimite;
    CheckBox peste1,peste2,peste3;
    EditText material;
    Spinner capacitatePesti;
    RadioButton necesitaCuratare;
    TimePicker timePicker;
    static int idPesti=0;
    ACVariu acVariu=null;
    private void writeToFile(ACVariu acVariu){
        try {
            FileOutputStream fos;
            fos = openFileOutput("acvariu", MODE_PRIVATE);
            fos.write(acVariu.toString().getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readFromFile() {
            try {
                FileInputStream fis = openFileInput("acvariu");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr);
                String acvariu = reader.readLine();
                Toast.makeText(this,
                        acvariu,
                        Toast.LENGTH_SHORT).show();
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_obiecte);

        SharedPreferences sp=getSharedPreferences("culori_dimensiuni", MODE_PRIVATE);
        int counter=sp.getInt("counter",0)-1;
        //ultima culoare
        String culoare=sp.getString("culoare"+counter,"");
        int dimensiune=sp.getInt("dimensiune"+counter,0);

        View view=findViewById(R.id.creareObjLayout);
        view.setBackgroundColor(Color.parseColor(culoare));



        String[] items = new String[]{"1","2","3","4"};

        peste1=(CheckBox)findViewById(R.id.pesteAuriu);
        peste2=(CheckBox)findViewById(R.id.pesteClaun);
        peste3=(CheckBox)findViewById(R.id.pesteCoral);
        material=(EditText)findViewById(R.id.material);
        capacitatePesti=(Spinner) findViewById(R.id.capacitate);
        necesitaCuratare=(RadioButton) findViewById(R.id.curatare);
        trimite=(Button) findViewById(R.id.trimite);
        timePicker=(TimePicker)findViewById(R.id.timePicker);

        material.setTextSize(dimensiune);
        trimite.setTextSize(dimensiune);

        Intent intent=getIntent();
        if(intent.getExtras()!=null){
            acVariu=intent.getSerializableExtra("acvariu",ACVariu.class);
            material.setText("Material primit: " + acVariu.getMaterial());

        }else{
            acVariu=new ACVariu();
        }


        //Log.d("TIME",timePicker.getHour()+timePicker.getMinute()+"");

        trimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                ACVariu acVariu=new ACVariu(1,2,3);

                 */
                List<Peste> pesti = new ArrayList<>();

                if (necesitaCuratare.isChecked())
                    acVariu.setTrebuieSpalat(true);
                else acVariu.setTrebuieSpalat(false);

                Log.d("acvariu", "spalat setata");

                if (material.getText() != null) {
                    acVariu.setMaterial(material.getText().toString());
                    Log.d("acvariu", "material setata");
                }

                if (peste1.isChecked())
                    pesti.add(new Peste("peste auriu", idPesti++));
                if (peste2.isChecked())
                    pesti.add(new Peste("peste clown", idPesti++));
                if (peste3.isChecked())
                    pesti.add(new Peste("peste coral", idPesti++));

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreareObiecteActivity.this, android.R.layout.simple_spinner_item, items);
                capacitatePesti.setAdapter(adapter);
                capacitatePesti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        acVariu.setCapacitatePesti(Integer.valueOf(parent.getItemAtPosition(position).toString()));
                        Log.d("acvariu", "capacitate setata");
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub
                    }
                });

                //LAB7 - atunci când un nou obiect de tipul clasei voastre este creat să fie salvat și într-un fișier. Salvarea noului obiect se face prin adăugarea acestuia în fișier

                  writeToFile(acVariu);
                  readFromFile();
//
//                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                intent.putExtra("acvariu",acVariu);
//                startActivity(intent);

            }

        });
    }
}
