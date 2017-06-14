package com.example.ramiro.proyectostudyjams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class RutaLinea extends AppCompatActivity {

    private String[] datosI = {"Kalajahuira","Chuquiaguillo","Villa el Carmen","Villa Fatima","Tejada Sorzano","Mercado Yungas","Plaza Murillo","Perez","Calle Santa Cruz","Max Paredes","Garita","Cementerio",
            "Portada","Plaza Ballivian"};
    private String[] datosV = {"Plaza Ballivian","Portada","Cemneterio","Garita","Plaza Eguino","Perez","Yanacocha","Tejada Sorzano","Mercado Yungas","Villa Fatima","villa el carmen","Chuquiaguillo",
            "kalajahuira","Plaza Ballivian"};
    private String[] datosIO = {"villa el carmen","hospital arcoiris","avenida bush","avenida de los poetas","obrajes ","calacoto","cotacota"};
    private String[] datosVO = {"max paredes ","garita","cementerio ","tejar","faro murillo ","chuquiaguillo","villa el carmen","villa fatima"};

    private ListView lvDatosI;
    private ArrayAdapter<String> adaptadorI;
    private ListView lvDatosV;
    private ArrayAdapter<String> adaptadorV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta_linea);
        lvDatosI = (ListView)findViewById(R.id.lvListaRutaI);
        lvDatosV = (ListView)findViewById(R.id.lvListaRutaV);
        String Nombre;
        Bundle bundle = getIntent().getExtras();
        Nombre=bundle.getString("datoN"," ").toString();
        if (Nombre.equals("Virgen de Fatima")){
            adaptadorI = new ArrayAdapter<String>(getApplicationContext(),R.layout.item,datosIO);
            lvDatosI.setAdapter(adaptadorI);
            adaptadorV = new ArrayAdapter<String>(getApplicationContext(),R.layout.item,datosVO);
            lvDatosV.setAdapter(adaptadorV);
        }else{
            adaptadorI = new ArrayAdapter<String>(getApplicationContext(),R.layout.item,datosI);
            lvDatosI.setAdapter(adaptadorI);
            adaptadorV = new ArrayAdapter<String>(getApplicationContext(),R.layout.item,datosV);
            lvDatosV.setAdapter(adaptadorV);
        }



    }
}
