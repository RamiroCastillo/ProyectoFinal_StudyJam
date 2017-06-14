package com.example.ramiro.proyectostudyjams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListaFavorito extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favorito);
        ArrayList<Sindicato> lista=new ArrayList<Sindicato>();

        lista.add(new Sindicato("Señor de Mayo",R.drawable.linea_326));
        lista.add(new Sindicato("Virgen de Fatima",R.drawable.linea_dos));
        lista.add(new Sindicato("Corazon de Jesus",R.drawable.linea_tres));
        lista.add(new Sindicato("Litoral",R.drawable.linea_286));
        RecyclerView contenedor = (RecyclerView) findViewById(R.id.RecyclerViewLineasF);
        // Usar esta línea para mejorar el rendimiento
        // si sabemos que el contenido no va a afectar
        // el tamaño del RecyclerView
        contenedor.setHasFixedSize(true);
        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // Asociamos un adapter (ver más adelante cómo definirlo)
        contenedor.setAdapter(new AdaptadorListaF(lista));
        contenedor.setLayoutManager(layoutManager);

    }
}
