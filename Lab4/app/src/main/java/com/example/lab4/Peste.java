package com.example.lab4;
@SuppressWarnings("serial")
public class Peste {
    private String specie;
    private int  id;

    public Peste(String specie,int id) {
        this.specie = specie;
        this.id=id;
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
}
