package com.example.ramiro.proyectostudyjams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DescripcionSindicato extends AppCompatActivity {
    Button buttonLS;
    Intent intentLS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_sindicato);

        buttonLS = (Button) findViewById(R.id.btn_Lineas_S);
        buttonLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentLS = new Intent(getApplicationContext(),LineasSindicato.class);
                startActivity(intentLS);
                finish();
            }
        });
    }
}
