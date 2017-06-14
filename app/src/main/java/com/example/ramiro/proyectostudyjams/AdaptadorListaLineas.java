package com.example.ramiro.proyectostudyjams;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Ramiro on 1/6/2017.
 */

public class AdaptadorListaLineas extends RecyclerView.Adapter<ViewHolderL> {
    private List<Linea> listaLineas;

    public AdaptadorListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }
    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView*/
    @Override
    public ViewHolderL onCreateViewHolder(ViewGroup parent,
                                          int viewType) {
        // Creamos una nueva vista
        View vista = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_lineas_s, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings
        // ...


        return new ViewHolderL(vista) {
        };
    }
    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolderL holder, int position) {

        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos


        holder.Color.setText(listaLineas.get(position).getColor());
        holder.LineaR.setImageResource(listaLineas.get(position).getImagen());
    }
    @Override
    public int getItemCount() {
        return listaLineas.size();
    }

}

