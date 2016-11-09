package com.evoldig.mascotashop.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.evoldig.mascotashop.Pojo.Mascota;
import com.evoldig.mascotashop.R;
import com.evoldig.mascotashop.db.ConstructorMascotas;

import java.util.ArrayList;

/**
 * Created by jazocar on 20/10/16.
 */

public class AdaptadorMascota extends RecyclerView.Adapter <AdaptadorMascota.MascotaViewHolder> {

    ArrayList <Mascota> mascotas;
    Activity activity;



    public AdaptadorMascota (ArrayList<Mascota> mascotas, Activity activity) {

        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Inflar el layout y lo pasará al viewholder para que el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent, false);

        return new MascotaViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRaiting.setText(String.valueOf(mascota.getRaiting()));
        //mascotaViewHolder.tvRaiting.setText(String.valueOf(mascota.getRaiting()) + " " + activity.getString(R.string.plike));






        //Generar una Acción al hacer click envia los datos.








        //Generar acción al presionar el boton de Like

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  //Contador de Like
                int Suma = mascota.getRaiting();
                mascota.setRaiting(++Suma); */


                Toast.makeText(activity, "Diste Like a" + mascota.getNombre(),Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                //mascotaViewHolder.tvRaiting.setText(String.valueOf(mascota.getRaiting()));

                mascotaViewHolder.tvRaiting.setText(constructorMascotas.obtenerLikesMascota(mascota) + " " + activity.getString(R.string.plike));

                //mascotaViewHolder.tvRaiting.setText(constructorMascotas.obtenerLikesMascota(mascota));

            }
        });




    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public  static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private ImageView btnLike;
        private TextView tvRaiting;



        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            btnLike = (ImageView) itemView.findViewById(R.id.btnLike);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRaiting);


        }
    }
}
