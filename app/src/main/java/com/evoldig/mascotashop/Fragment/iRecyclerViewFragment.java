package com.evoldig.mascotashop.Fragment;

import com.evoldig.mascotashop.Adapter.AdaptadorMascota;
import com.evoldig.mascotashop.Menu.Contacto;
import com.evoldig.mascotashop.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jazocar on 31/10/16.
 */

public interface iRecyclerViewFragment {
    public void generarLinearLayoutVertical ();
    public AdaptadorMascota crearAdaptador (ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV (AdaptadorMascota adaptador);
}
