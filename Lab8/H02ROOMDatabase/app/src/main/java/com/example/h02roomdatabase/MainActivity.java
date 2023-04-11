package com.example.h02roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.h02roomdatabase.acvariu.Acvariu;
import com.example.h02roomdatabase.acvariu.AcvariuDatabase;
import com.example.h02roomdatabase.cafea.Cafea;
import com.example.h02roomdatabase.cafea.CafeaDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static AcvariuDatabase acvariuDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acvariuDatabase = Room.databaseBuilder(
                this,
                AcvariuDatabase.class,
                "AcvariuDatabase"
        ).allowMainThreadQueries().build();
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

        Acvariu acvariu=new Acvariu("sticla",20);
        acvariuDatabase.acvariuDAO().insertAcvariu(acvariu);
    }
    public  void deleteMethod(View view){

    }
    public  void deleteOneMethod(View view){
        acvariuDatabase.acvariuDAO().deleteSpecificAcvariu(5);

    }
    public  void updateOneMethod(View view){
        acvariuDatabase.acvariuDAO().incrementCantitate("sticla");

    }

}
