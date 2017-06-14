package com.example.ramiro.proyectostudyjams;

/**
 * Created by Ramiro on 30/5/2017.
 */

public class Ruta {
    private int IdR;
    private String Nombre;

    public Ruta(int idR, String nombre) {
        IdR = idR;
        Nombre = nombre;
    }

    public int getIdR() {
        return IdR;
    }

    public void setIdR(int idR) {
        IdR = idR;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
