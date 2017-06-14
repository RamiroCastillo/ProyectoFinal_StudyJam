package com.example.ramiro.proyectostudyjams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LineasSindicato extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineas_sindicato);
        ArrayList<Linea> lista=new ArrayList<Linea>();

        lista.add(new Linea("286",R.drawable.linea_286,"Rojo",null));
        lista.add(new Linea("391",R.drawable.linea_dos,"Verde",null));
        lista.add(new Linea("320",R.drawable.linea_tres,"Azul",null));
        lista.add(new Linea("889",R.drawable.linea_241,"Rojo",null));
        lista.add(new Linea("841",R.drawable.linea_326,"Verde",null));


        RecyclerView contenedor = (RecyclerView) findViewById(R.id.RecyclerViewLS);
        // Usar esta línea para mejorar el rendimiento
        // si sabemos que el contenido no va a afectar
        // el tamaño del RecyclerView
        contenedor.setHasFixedSize(true);
        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // Asociamos un adapter (ver más adelante cómo definirlo)
        contenedor.setAdapter(new AdaptadorListaLineas(lista));
        contenedor.setLayoutManager(layoutManager);
    }
}
