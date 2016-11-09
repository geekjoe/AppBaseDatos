package com.evoldig.mascotashop.Pojo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.evoldig.mascotashop.Adapter.AdaptadorMascota;
import com.evoldig.mascotashop.Fragment.iRecyclerViewFragment;
import com.evoldig.mascotashop.Pojo.Mascota;
import com.evoldig.mascotashop.Presentador.RecyclerViewFragmentPresenter;
import com.evoldig.mascotashop.Presentador.iRecyclerViewFragmentPresenter;
import com.evoldig.mascotashop.R;

import java.util.ArrayList;


public class DetalleMascota extends AppCompatActivity implements iRecyclerViewFragment  {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private iRecyclerViewFragmentPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_mascota);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setTitle("");
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasSeleccionadas);
        presenter = new RecyclerViewFragmentPresenter(this, getBaseContext());

    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public AdaptadorMascota crearAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AdaptadorMascota adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
