package com.evoldig.mascotashop.Fragment;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;

import com.evoldig.mascotashop.Adapter.AdaptadorMascota;
import com.evoldig.mascotashop.Menu.Contacto;
import com.evoldig.mascotashop.Pojo.Mascota;
import com.evoldig.mascotashop.Presentador.RecyclerViewFragmentPresenter;
import com.evoldig.mascotashop.Presentador.iRecyclerViewFragmentPresenter;
import com.evoldig.mascotashop.R;

import java.util.ArrayList;

/**
 * Created by jazocar on 22/10/16.
 */

public class RecyclerviewFragment extends Fragment implements iRecyclerViewFragment  {


    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private iRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.fragment_recyclerview, container, false);




       listaMascotas = (RecyclerView) V.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());






        //inicializarListaMascota();
        //inicializarAdaptador();




        return V;
        // return super.onCreateView(inflater, container, savedInstanceState);


    }



    //public AdaptadorMascota adaptador;

    /*public void inicializarAdaptador () {

    } */

    /*public void inicializarListaMascota () {

    } */


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public AdaptadorMascota crearAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AdaptadorMascota adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
