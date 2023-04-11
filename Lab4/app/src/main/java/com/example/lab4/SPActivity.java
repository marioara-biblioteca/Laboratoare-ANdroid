package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spactivity);

        Button addToSp=(Button)findViewById(R.id.addToSp);
        addToSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tvCuloare=(EditText) findViewById(R.id.tvCuloare);
                EditText tvDim=(EditText) findViewById(R.id.tvDimensiune);
                String culoare=tvCuloare.getText().toString();
                int dim=Integer.parseInt(tvDim.getText().toString());

                SharedPreferences sp=getSharedPreferences("culori_dimensiuni", MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                if (sp.contains("counter")){
                    int counter=sp.getInt("counter",0);
                    editor.putString("culoare"+counter,culoare);
                    editor.putInt("dimensiune"+counter,dim);
                    counter++;
                    editor.putInt("counter",counter);
                }else{
                    //suntem la prima rulare
                    editor.putInt("counter",1);
                    editor.putString("culoare"+0,culoare);
                    editor.putInt("dimensiune"+0,dim);
                }
            }
        });
    }
}