package com.evoldig.mascotashop.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evoldig.mascotashop.Pojo.Dummy;
import com.evoldig.mascotashop.R;

import java.util.ArrayList;

/**
 * Created by jazocar on 26/10/16.
 */

public class AdaptadorDummy extends RecyclerView.Adapter <AdaptadorDummy.ViewHolderDummy> {

    ArrayList<Dummy> mascotas;
    Activity activity;

    public AdaptadorDummy(ArrayList<Dummy> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public AdaptadorDummy.ViewHolderDummy onCreateViewHolder(ViewGroup parent, int viewType) {
        View Vd = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewdummy,parent, false);


        return new ViewHolderDummy(Vd);
    }



    @Override
    public void onBindViewHolder(final ViewHolderDummy viewHolderDummy, int position) {

        final Dummy mascota = mascotas.get(position);
        viewHolderDummy.imgfotoDummy.setImageResource(mascota.getFoto());
        //viewHolderDummy.tvNombreDummy.setText(mascota.getNombre());
        viewHolderDummy.tvRaitingDummy.setText(String.valueOf(mascota.getRaiting()));



        //Generar una acción al pisar el boton like

        /*viewHolderDummy.btnLikeDummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Contador de Like
                int Suma = mascota.getRaiting();
                mascota.setRaiting(++Suma);
                viewHolderDummy.tvRaitingDummy.setText(String.valueOf(mascota.getRaiting()));

                Toast.makeText(activity, "Diste Like a" + mascota.getNombre(),Toast.LENGTH_SHORT).show();
            }
        }); */




    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class ViewHolderDummy extends RecyclerView.ViewHolder {

        private ImageView imgfotoDummy;
       // private TextView  tvNombreDummy;
       // private ImageView btnLikeDummy;
        private TextView tvRaitingDummy;

        public ViewHolderDummy(View itemView) {
            super(itemView);
            imgfotoDummy = (ImageView) itemView.findViewById(R.id.imgFotoDummy);
         //   tvNombreDummy = (TextView) itemView.findViewById(R.id.tvNombreDummy);
         //   btnLikeDummy = (ImageView) itemView.findViewById(R.id.btnLikeDummy);
            tvRaitingDummy = (TextView) itemView.findViewById(R.id.tvRaitingDummy);
        }
    }
}
