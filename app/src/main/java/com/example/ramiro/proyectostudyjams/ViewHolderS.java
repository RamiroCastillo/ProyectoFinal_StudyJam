package com.example.ramiro.proyectostudyjams;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ramiro on 3/6/2017.
 */

public class ViewHolderS extends RecyclerView.ViewHolder {
    TextView NombreS;
    ImageView LineaSi;
    Intent intent;

    public ViewHolderS(final View itemView) {
        super(itemView);

        NombreS = (TextView)itemView.findViewById(R.id.tvNombreSindicato);
        LineaSi= (ImageView) itemView.findViewById(R.id.ivSindicato);

        LineaSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(itemView.getContext(),DescripcionSindicato.class);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
