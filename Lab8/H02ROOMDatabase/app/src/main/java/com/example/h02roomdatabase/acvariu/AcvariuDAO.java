package com.example.h02roomdatabase.acvariu;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AcvariuDAO {
    @Insert
    void insertAcvariu(Acvariu acvariu);
    @Query("UPDATE Acvariu SET cantitate = cantitate + 1 WHERE material=:material")
    void incrementCantitate(String material);
    @Delete
    void deleteAcvariu(Acvariu acvariu);
    @Query("SELECT * FROM Acvariu")
    List<Acvariu> getAllAcvarii();
    @Query("SELECT * FROM Acvariu WHERE material= :material")
    Acvariu getAcvariu(String material);
    @Query("SELECT * FROM Acvariu WHERE cantitate BETWEEN :start AND :end")
    Acvariu getSpecificAcvariu(int start,int end);
    @Query("DELETE FROM Acvariu WHERE cantitate >= :param")
    void deleteSpecificAcvariu(int param);


}
