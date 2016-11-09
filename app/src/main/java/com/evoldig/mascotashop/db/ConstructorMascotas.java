package com.evoldig.mascotashop.db;

import android.content.ContentValues;
import android.content.Context;

import com.evoldig.mascotashop.Pojo.Mascota;
import com.evoldig.mascotashop.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by jazocar on 31/10/16.
 */

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        //mascotas = new ArrayList<Mascota>();
       /* ArrayList <Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mila", R.drawable.mila));
        mascotas.add(new Mascota("Coby", R.drawable.coby));
        mascotas.add(new Mascota("Missa", R.drawable.missa));
        mascotas.add(new Mascota("Ray", R.drawable.ray));
        mascotas.add(new Mascota("Sofy", R.drawable.sofi));
        mascotas.add(new Mascota("Spy", R.drawable.spy));
        mascotas.add(new Mascota("Sussy", R.drawable.sussy));
        mascotas.add(new Mascota("Tommy",R.drawable.tommy));
        return mascotas; */

        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodasLasMascotas();

    }

    public void insertarTresMascotas (BaseDatos db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mila");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mila);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Coby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.coby);
        //db.insertarMascota(contentValues);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Missa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.missa);
        //db.insertarMascota(contentValues);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Ray");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ray);
        //db.insertarMascota(contentValues);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Sofi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.sofi);
        //db.insertarMascota(contentValues);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Spy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.spy);
        //db.insertarMascota(contentValues);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Sussy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.sussy);
        //db.insertarMascota(contentValues);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Tommy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.tommy);

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);

    }

    public int obtenerLikesMascota (Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }

}
