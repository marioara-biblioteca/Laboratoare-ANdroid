package com.example.lab4.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab4.CreareObiecteActivity;
import com.example.lab4.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AcvariuActivity extends AppCompatActivity {
    private void salveazaSharePreferences(ACVariu acVariu) {
        SharedPreferences sp;
        sp = getSharedPreferences("sharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(acVariu);
        editor.putString("acvariu", json);
        editor.commit();
    }
    public void citestePreferinte() {
        SharedPreferences sp;
        sp = getSharedPreferences("sharedPref", MODE_PRIVATE);
        String mesaj = sp.getString("acvariu", "");
        Gson gson = new Gson();
        ACVariu obj = gson.fromJson(mesaj, ACVariu.class);
        Toast.makeText(this,
                mesaj ,
                Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acvariu);

        List<ACVariu> acVarius = new ArrayList<>();
        acVarius.add(new ACVariu("Sticla",R.drawable.peste_auriu));
        acVarius.add(new ACVariu("Plastic",R.drawable.peste_albastru));
        acVarius.add(new ACVariu("Metal",R.drawable.peste_clovn));

        AcvariuAdapter adapter=new AcvariuAdapter(this,acVarius);
        ListView lv=findViewById(R.id.pestiListView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(), CreareObiecteActivity.class);
                ACVariu acVariu= acVarius.get(i);
                intent.putExtra("acvariu",acVariu);
                startActivity(intent);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                salveazaSharePreferences(acVarius.get(i));

                citestePreferinte();
                return true;
            }
        });
    }
}