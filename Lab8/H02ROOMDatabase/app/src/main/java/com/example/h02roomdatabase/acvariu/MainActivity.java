package com.example.h02roomdatabase.acvariu;



import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.h02roomdatabase.R;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = null;
    DatabaseReference myRef = null;
    private static AcvariuDatabase acvariuDatabase;
    private List<Acvariu> acvarii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acvariuDatabase = Room.databaseBuilder(
                this,
                AcvariuDatabase.class,
                "AcvariuDatabase"
        ).allowMainThreadQueries().build();
        FirebaseApp.initializeApp(MainActivity.this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> acvariiIterable = dataSnapshot.getChildren();
                AcvariuAdapter adapter=new AcvariuAdapter(MainActivity.this,acvarii);
                ListView lv=findViewById(R.id.listView);
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Toast.makeText(MainActivity.this, acvarii.get(i).toString(), Toast.LENGTH_SHORT).show();
                        acvariuDatabase.acvariuDAO().deleteAcvariu(acvarii.get(i));
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        acvarii=new ArrayList<>(
                Arrays.asList(
                        new Acvariu("sticla",10),
                        new Acvariu("lemn",20),
                        new Acvariu("plastic",30),
                        new Acvariu("metal",40)

                ));


    }

    public void selectMethod(View view) {

        List<Acvariu> acvarii=acvariuDatabase.acvariuDAO().getAllAcvarii();
        Toast.makeText(this, acvarii.toString(), Toast.LENGTH_SHORT).show();
    }
    public  void selectOneMethod(View view){
        Acvariu acvariu=acvariuDatabase.acvariuDAO().getAcvariu("sticla");
        Toast.makeText(this, acvariu.toString(), Toast.LENGTH_SHORT).show();
    }
    public void selectBetween(View view){
        Acvariu acvariu=acvariuDatabase.acvariuDAO().getSpecificAcvariu(10,30);
        Toast.makeText(this, acvariu.toString(), Toast.LENGTH_SHORT).show();
    }
    public void insertMethod(View view) {
        myRef.child("acvariu1").setValue(acvarii.get(0));
    }

    public  void deleteOneMethod(View view){
        acvariuDatabase.acvariuDAO().deleteSpecificAcvariu(5);

    }
    public  void updateOneMethod(View view){
        acvariuDatabase.acvariuDAO().incrementCantitate("sticla");

    }

}
