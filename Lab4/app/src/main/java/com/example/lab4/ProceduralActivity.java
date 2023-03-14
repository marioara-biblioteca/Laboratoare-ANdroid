package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//am setat in manifest ca aplicatia sa porneasca cu aceasta activitate
//switch cu MainActtivity pentru flow-ul celorlalte cerinte
/*
* TextView
* EditText
* RadioBtn
* Spinner
* Stars
* Switch
* Checkbox1 2 3
* Button
* */

public class ProceduralActivity extends AppCompatActivity {
    private CheckBox pesteCheckBox(String nume){
        CheckBox peste=new CheckBox(this);
        peste.setText(nume);
        peste.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        200));
        return peste;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedural);
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        //adaugare TextView
        TextView tv=new TextView(this);
        tv.setText("Introduceti date acvariu: ");
        ll.addView(tv);

        //Adaugare EditText
        EditText material = new EditText(this);
        material.setText("");
        material.setHint("enter name");
        material.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        ll.addView(material);

        //Adaugare Radio Button
        RadioButton necesitaCuratare=new RadioButton(this);
        necesitaCuratare.setText("Necesita Curatare?");
        necesitaCuratare.setLayoutParams(
                new LinearLayout.LayoutParams(
                  ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
        ll.addView(necesitaCuratare);

        //Adaugare 3 Checkboxuri
        CheckBox peste=pesteCheckBox("peste auriu");
        ll.addView(peste);
        peste=pesteCheckBox("peste clown");
        ll.addView(peste);
        peste=pesteCheckBox("peste coral");
        ll.addView(peste);


        //Adaugare Buton
        Button trimite = new Button(this);
        trimite.setText("Trimite");
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity= Gravity.CENTER_HORIZONTAL;
        trimite.setLayoutParams(lp);
        trimite.setGravity(Gravity.RIGHT);
        ll.addView(trimite);
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
            }
        });
        setContentView(ll);


    }
}