package com.example.ramiro.proyectostudyjams;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PrincipalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PrincipalFragment extends Fragment {
    private Button button;
    private Button buttonB;
    private ImageButton imageButtonLF;
    private Intent intentI;
    private Intent intent;
    private Intent intentB;
    private Intent intentF;
    private Button buttonI;
    private EditText editText;
    private EditText editTextB;

    private OnFragmentInteractionListener mListener;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_principal, container, false);
        editTextB = (EditText)v.findViewById(R.id.EditTexB);
        editText = (EditText)v.findViewById(R.id.Ubi);
        button = (Button)v.findViewById(R.id.GoogleMaps);
        buttonB = (Button) v.findViewById(R.id.idBucar);
        imageButtonLF = (ImageButton) v.findViewById(R.id.lvFavorito);
        ArrayList<Sindicato> lista=new ArrayList<Sindicato>();

        lista.add(new Sindicato("Señor de Mayo",R.drawable.sindicato));
        lista.add(new Sindicato("Virgen de Fatima",R.drawable.sindicato_dos));
        lista.add(new Sindicato("Corazon de Jesus",R.drawable.sindicato_tres));
        RecyclerView contenedor = (RecyclerView) v.findViewById(R.id.RecyclerViewSindicatos);
        // Usar esta línea para mejorar el rendimiento
        // si sabemos que el contenido no va a afectar
        // el tamaño del RecyclerView
        contenedor.setHasFixedSize(true);
        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // Asociamos un adapter (ver más adelante cómo definirlo)
        contenedor.setAdapter(new AdaptadorSindicato(lista));
        contenedor.setLayoutManager(layoutManager);
        imageButtonLF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirFavoritos();
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextB.getText().toString().equals("")){
                    AbrirListaB();
                }else{
                    Toast.makeText(getContext(),"Introdusca una Zona o Calle",Toast.LENGTH_SHORT).show();
                }

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editText.getText().toString().equals("")) {
                    abrirGoogleMaps();
                } else {
                    Toast.makeText(getContext(),"Introdusca una Ubicacion",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void abrirGoogleMaps() {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:"+editText.getText().toString())); //"geo:-16.504014,-68.130906"
        startActivity(intent);
    }

    public void AbrirListaB(){
        intentB= new Intent(getActivity(),ListaLineasEncontradas.class);
        intentB.putExtra("datoB",editTextB.getText().toString());
        startActivity(intentB);
    }

    public void AbrirFavoritos(){
        intentF= new Intent(getContext(),ListaFavorito.class);
        startActivity(intentF);
    }


}
