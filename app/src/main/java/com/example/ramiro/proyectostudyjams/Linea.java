package com.example.ramiro.proyectostudyjams;

import java.util.ArrayList;

/**
 * Created by Ramiro on 30/5/2017.
 */

public class Linea {

    private String Numero;
    private int imagen;
    private String Color;
    private ArrayList<Ruta> ListaRutas;

    public Linea(String numero, int imagen, String color, ArrayList<Ruta> listaRutas) {
        this.Numero = numero;
        this.imagen = imagen;
        this.Color = color;
        ListaRutas = listaRutas;
    }


    public int getImagen() {
        return imagen;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public ArrayList<Ruta> getListaRutas() {
        return ListaRutas;
    }

    public void setListaRutas(ArrayList<Ruta> listaRutas) {
        ListaRutas = listaRutas;
    }
}
