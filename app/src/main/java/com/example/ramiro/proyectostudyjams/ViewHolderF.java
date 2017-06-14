package com.example.ramiro.proyectostudyjams;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ramiro on 31/5/2017.
 */

public class ViewHolderF extends RecyclerView.ViewHolder {
    TextView Nombre;
    ImageView Linea;
    Button buttonMas;
    Button buttonRuta;
    Intent intent;

    public ViewHolderF(final View itemView) {
        super(itemView);

        Nombre = (TextView)itemView.findViewById(R.id.tvNombreS);
        Linea= (ImageView) itemView.findViewById(R.id.ivLinea);
        buttonMas = (Button)itemView.findViewById(R.id.buttonMasF);
        buttonRuta = (Button)itemView.findViewById(R.id.buttonRutaF);

        buttonRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(itemView.getContext(),RutaLinea.class);
                intent.putExtra("datoN",Nombre.getText().toString());
                itemView.getContext().startActivity(intent);
            }
        });

        buttonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(itemView.getContext(),DescripcionSindicato.class);
                itemView.getContext().startActivity(intent);
            }
        });

    }

}
