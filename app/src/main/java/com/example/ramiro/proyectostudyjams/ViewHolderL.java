package com.example.ramiro.proyectostudyjams;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ramiro on 1/6/2017.
 */

public class ViewHolderL extends RecyclerView.ViewHolder {
    TextView Color;
    ImageView LineaR;
    Button buttonRuta;
    Intent intent;

    public ViewHolderL(final View itemView) {
        super(itemView);

        Color = (TextView)itemView.findViewById(R.id.tvColorS);
        LineaR= (ImageView) itemView.findViewById(R.id.ivLineaS);
        buttonRuta = (Button)itemView.findViewById(R.id.btn_Ruta);

        buttonRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(itemView.getContext(),RutaLinea.class);
                intent.putExtra("DatoN","nada");
                itemView.getContext().startActivity(intent);

            }
        });

    }
}
