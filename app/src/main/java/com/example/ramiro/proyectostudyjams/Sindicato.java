package com.example.ramiro.proyectostudyjams;

import java.util.ArrayList;

/**
 * Created by Ramiro on 30/5/2017.
 */

public class Sindicato {
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private int imagen;

    public Sindicato(String nombre,int imagen) {
        Nombre = nombre;
        this.imagen = imagen;

    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


}
