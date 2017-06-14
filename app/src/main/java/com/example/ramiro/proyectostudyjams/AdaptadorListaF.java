package com.example.ramiro.proyectostudyjams;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Ramiro on 31/5/2017.
 */

public class AdaptadorListaF extends RecyclerView.Adapter<ViewHolderF> {
    private List<Sindicato> listaSindicatos;

    public AdaptadorListaF(List<Sindicato> listaSindicatos) {
        this.listaSindicatos = listaSindicatos;
    }
    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView*/
    @Override
    public ViewHolderF onCreateViewHolder(ViewGroup parent,
                                          int viewType) {
        // Creamos una nueva vista
        View vista = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_f, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings
        // ...


        return new ViewHolderF(vista) {
        };
    }
    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolderF holder, int position) {

        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos


        holder.Nombre.setText(listaSindicatos.get(position).getNombre());
        holder.Linea.setImageResource(listaSindicatos.get(position).getImagen());
    }
    @Override
    public int getItemCount() {
        return listaSindicatos.size();
    }



}

