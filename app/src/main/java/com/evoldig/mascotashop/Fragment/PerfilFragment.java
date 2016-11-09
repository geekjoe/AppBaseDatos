package com.evoldig.mascotashop.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evoldig.mascotashop.Adapter.AdaptadorDummy;
import com.evoldig.mascotashop.Pojo.Dummy;
import com.evoldig.mascotashop.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Dummy> mascotasdummy;
    private RecyclerView listaMascotasdummy;


    /*public PerfilFragment() {
        // Required empty public constructor


    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Vo = inflater.inflate(R.layout.fragment_perfil, container,false);

        //Pasa Datos de Reycler view
        listaMascotasdummy = (RecyclerView) Vo.findViewById(R.id.DvMascotas);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasdummy.setLayoutManager(glm);
        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasdummy.setLayoutManager(llm); */
        inicializarListaMascota();
        inicializarAdaptador();


     return Vo;
    }


    public AdaptadorDummy adaptador;

    public void inicializarAdaptador () {

        adaptador = new AdaptadorDummy(mascotasdummy, getActivity());
        listaMascotasdummy.setAdapter(adaptador);

    }

    public void inicializarListaMascota () {
        mascotasdummy = new ArrayList<Dummy>();
        mascotasdummy.add(new Dummy("Ray1", R.drawable.ray1,5));
        mascotasdummy.add(new Dummy("Ray2", R.drawable.ray2,2));
        mascotasdummy.add(new Dummy("Ray3", R.drawable.ray3,5));
        mascotasdummy.add(new Dummy("Ray4", R.drawable.ray4,1));
        mascotasdummy.add(new Dummy("Ray5", R.drawable.ray5,3));
        mascotasdummy.add(new Dummy("Ray6", R.drawable.ray6,6));
    }

}
