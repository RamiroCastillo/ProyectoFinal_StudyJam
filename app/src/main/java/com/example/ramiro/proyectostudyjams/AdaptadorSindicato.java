package com.example.ramiro.proyectostudyjams;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Ramiro on 3/6/2017.
 */

public class AdaptadorSindicato extends RecyclerView.Adapter<ViewHolderS>{
    private List<Sindicato> listaSindicatos;

    public AdaptadorSindicato(List<Sindicato> xlistaSindicatos) {
        this.listaSindicatos = xlistaSindicatos;
    }
    @Override
    public ViewHolderS onCreateViewHolder(ViewGroup parent,
                                          int viewType) {
        // Creamos una nueva vista
        View vista = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_sindicato, parent, false);

        // Aquí podemos definir tamaños, márgenes, paddings
        // ...


        return new ViewHolderS(vista) {
        };
    }

    // Este método reemplaza el contenido de cada view,
    // para cada elemento de la lista (nótese el argumento position)
    @Override
    public void onBindViewHolder(ViewHolderS holder, int position) {

        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos


        holder.NombreS.setText(listaSindicatos.get(position).getNombre());
        holder.LineaSi.setImageResource(listaSindicatos.get(position).getImagen());
    }
    @Override
    public int getItemCount() {
        return listaSindicatos.size();
    }

}
