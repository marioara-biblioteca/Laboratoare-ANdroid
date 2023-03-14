package com.example.lab4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("serial")
public class ACVariu implements Serializable {
    private List<Peste> pesti=new ArrayList<>();
    private String material;
    private float lungime,latime,inaltime;
    private boolean trebuieSpalat;
    private int capacitatePesti;

    public ACVariu(float lungime, float latime, float inaltime) {
        this.lungime = lungime;
        this.latime = latime;
        this.inaltime = inaltime;
    }

    public List<Peste> getPesti() {
        return pesti;
    }

    public void setPesti(List<Peste> pesti) {
        this.pesti = pesti;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getLungime() {
        return lungime;
    }

    public void setLungime(float lungime) {
        this.lungime = lungime;
    }

    public float getLatime() {
        return latime;
    }

    public void setLatime(float latime) {
        this.latime = latime;
    }

    public float getInaltime() {
        return inaltime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }

    public boolean isTrebuieSpalat() {
        return trebuieSpalat;
    }

    public void setTrebuieSpalat(boolean trebuieSpalat) {
        this.trebuieSpalat = trebuieSpalat;
    }

    public int getCapacitatePesti() {
        return capacitatePesti;
    }

    public void setCapacitatePesti(int capacitatePesti) {
        this.capacitatePesti = capacitatePesti;
    }

    @Override
    public String toString() {
        return "ACVariu{" +
                "pesti=" + pesti +
                ", material='" + material + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", inaltime=" + inaltime +
                ", trebuieSpalat=" + trebuieSpalat +
                ", capacitatePesti=" + capacitatePesti +
                '}';
    }
}
