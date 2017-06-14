package com.example.ramiro.proyectostudyjams;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ListaLineasEncontradas extends AppCompatActivity {
    private String arrayR[] = new String[1000];
    private String arrayS[] = new String[1000];
    private String arrayE[] = new String[1000];
    private String nombreArchivoExternoRuta = "RutaIda.txt";
    private String nombreArchivoExternoSindicato = "Sindicatos.txt";
    private  String DireccionB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lineas_encontradas);
        verificaPermiso();
        ArrayList<Sindicato> lista=new ArrayList<Sindicato>();
        Bundle bundle = getIntent().getExtras();
        DireccionB=bundle.getString("datoB"," ").toString();
        Toast.makeText(getApplicationContext(),DireccionB,Toast.LENGTH_SHORT).show();
        leerExternoRutaIda();
        leerExternoSindicato();
        for (int i=0;i<arrayR.length;i++){
            if (DireccionB.equals(arrayR[i].substring(0,arrayR[i].length()-5))){
                int j = 0 ;
                arrayE[j] =arrayR[i];
                j++;
            }
        }
        for (int i=0;i<arrayE.length;i++){
            for (int j=0;i<arrayS.length;j++){
                if (arrayE[i].substring(arrayE[i].length()-3,arrayE[i].length()).equals(arrayS[j].substring(arrayS[j].length()-3))){
                    if (arrayE[i].substring(arrayE[i].length()-3,arrayE[i].length()).equals("286")){
                        lista.add(new Sindicato("Señor de Mayo",R.drawable.linea_286));
                    }else{
                        if (arrayE[i].substring(arrayE[i].length()-3,arrayE[i].length()).equals("320")){
                            lista.add(new Sindicato("Señor de Mayo",R.drawable.linea_320));
                        }else{
                            if (arrayE[i].substring(arrayE[i].length()-3,arrayE[i].length()).equals("241")){
                                lista.add(new Sindicato("Virgen de Fatima",R.drawable.linea_241));
                            }else{
                                if (arrayE[i].substring(arrayE[i].length()-3,arrayE[i].length()).equals("326")){
                                    lista.add(new Sindicato("Virgen de Fatima",R.drawable.linea_326));
                                }else{
                                    if (arrayE[i].substring(arrayE[i].length()-3,arrayE[i].length()).equals("394")){
                                        lista.add(new Sindicato("Litoral",R.drawable.linea_394));
                                    }else{
                                        lista.add(new Sindicato("Señor de Mayo",R.drawable.linea_dos));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        lista.add(new Sindicato("Señor de Mayo",R.drawable.linea_286));
        lista.add(new Sindicato("Señor de Mayo",R.drawable.linea_320));
        lista.add(new Sindicato("Virgen de Fatima",R.drawable.linea_241));
        lista.add(new Sindicato("Virgen de Fatima",R.drawable.linea_326));
        lista.add(new Sindicato("Litoral",R.drawable.linea_394));
        RecyclerView contenedor = (RecyclerView) findViewById(R.id.RecyclerViewLineasE);
        // Usar esta línea para mejorar el rendimiento
        // si sabemos que el contenido no va a afectar
        // el tamaño del RecyclerView
        contenedor.setHasFixedSize(true);
        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // Asociamos un adapter (ver más adelante cómo definirlo)
        contenedor.setAdapter(new AdaptadorListasB(lista));
        contenedor.setLayoutManager(layoutManager);
    }

    public void leerExternoRutaIda() {
        try {
            verificaPermiso();
            File file = Environment.getExternalStorageDirectory();
            File f = new File(file.getAbsolutePath(),
                    "/ClasedePersistencia/"+"prueba_Persistencia.txt");
            Toast.makeText(getApplicationContext(),"Rami",Toast.LENGTH_SHORT).show();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f)));
            String texto = br.readLine();
            br.close();
            Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_SHORT).show();
            //arrayE = texto.split(",");

        }catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void leerExternoSindicato() {
        try {
            File file = Environment.getExternalStorageDirectory();
            File f = new File(file.getAbsolutePath(),
                    "/DatosSindicatos/"+nombreArchivoExternoSindicato);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f)));
            String texto = br.readLine();
            br.close();
            arrayS = texto.split(",");

        }catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void verificaPermiso() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            } else {
                // Continuar con el codigo
            }
        } else {
            // Continuar con el codigo
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("Permiso", "Concedido");
                } else {
                    Log.e("Permiso", "Denegado");
                }
                return;
            }
        }
    }

    public void guardarExterno() {
        if (!DireccionB.equals("")) {
            boolean sdDisponible = false;
            boolean sdAccesoEscritura = false;
            String state = Environment.getExternalStorageState();// devuelve la rtua  en forrma  de cadena de la memoria externa
            if (Environment.MEDIA_MOUNTED.equals(state)){ // da prioridad a la memoria sd pero si no tines se guarda en le interno
                sdDisponible = true;        //para ruta  de imagnes
                sdAccesoEscritura = true;
            }else {
                if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) { //apidemos min 5 activitis
                    sdDisponible = true;
                    sdAccesoEscritura = false;
                } else {
                    sdDisponible = false;
                    sdAccesoEscritura = false;
                }
            }
            if (sdDisponible && sdAccesoEscritura) {
                try {
                    File dir = new File(Environment.getExternalStorageDirectory()+"/DatosT/");

                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    File file = new File(dir, nombreArchivoExternoRuta);
                    try {
                        OutputStreamWriter osw = new OutputStreamWriter(
                                new FileOutputStream(file));
                        osw.write(DireccionB);
                        osw.close();

                    }catch (Exception e) {
                        System.out.println("Error: "+e.getMessage());
                    }

                } catch (Exception e) {
                    System.out.println("Error: "+e.getMessage());
                }
            } else {
                System.out.println("No se puede escribir en su memoria");
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "Debe ingresar datos para guardar",
                    Toast.LENGTH_SHORT).show();
        }
    }


}
