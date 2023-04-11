package com.example.lab4.lab6;
@SuppressWarnings("serial")
public class Peste {
    private String specie;
    private int  id;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public Peste(String specie, int id, int image) {
        this.specie = specie;
        this.id = id;
        this.image = image;
    }

    public Peste(String specie, int image) {
        this.specie = specie;
        this.image=image;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Peste{" +
                "specie='" + specie + '\'' +
                '}';
    }
}
