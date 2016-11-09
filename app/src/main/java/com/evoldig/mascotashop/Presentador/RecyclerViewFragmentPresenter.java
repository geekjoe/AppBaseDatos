package com.evoldig.mascotashop.Presentador;

import android.content.Context;
import android.content.Intent;

import com.evoldig.mascotashop.Adapter.AdaptadorMascota;
import com.evoldig.mascotashop.Fragment.iRecyclerViewFragment;
import com.evoldig.mascotashop.Menu.Contacto;
import com.evoldig.mascotashop.Pojo.Mascota;
import com.evoldig.mascotashop.db.ConstructorMascotas;

import java.util.ArrayList;

/**
 * Created by jazocar on 31/10/16.
 */

public class RecyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter {

    private iRecyclerViewFragment irecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(iRecyclerViewFragment irecyclerViewFragment, Context context) {
        this.irecyclerViewFragment = irecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        irecyclerViewFragment.inicializarAdaptadorRV(irecyclerViewFragment.crearAdaptador(mascotas));
        irecyclerViewFragment.generarLinearLayoutVertical();

    }



}
