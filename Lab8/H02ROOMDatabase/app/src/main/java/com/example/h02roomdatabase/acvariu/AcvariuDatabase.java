package com.example.h02roomdatabase.acvariu;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Acvariu.class},version = 1)
public abstract class AcvariuDatabase extends RoomDatabase {
    public abstract AcvariuDAO acvariuDAO();
}
