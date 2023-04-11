package com.example.h02roomdatabase.acvariu;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Acvariu {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="material")
    private String material;
    @ColumnInfo(name="cantitate")
    private int capacitatePesti;

    public Acvariu( String material, int capacitatePesti) {
        this.material = material;
        this.capacitatePesti = capacitatePesti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacitatePesti() {
        return capacitatePesti;
    }

    public void setCapacitatePesti(int capacitatePesti) {
        this.capacitatePesti = capacitatePesti;
    }

    @Override
    public String toString() {
        return "Acvariu{" +
                "material='" + material + '\'' +
                ", capacitatePesti=" + capacitatePesti +
                '}';
    }
}
