package com.evoldig.mascotashop.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evoldig.mascotashop.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jazocar on 1/11/16.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = " CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + " ( "
                + ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, "
                + ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER) ";
                //+")";
        String queryCrearTablaLikesMascotas = " CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA + " ( "
                + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " INTEGER, "
                + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + " INTEGER, "
                + "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " ) "
                + "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")"
                + ")";
        String queryCrearTablaRaiting = " CREATE TABLE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA + " ( "
                + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_RAITING + "INTEGER, "
                + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_NUMERO_LIKES + "INTEGER, "
                + "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_RAITING + ")"
                + "REFERENCES" + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")"
                + ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascotas);
        db.execSQL(queryCrearTablaRaiting);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList <Mascota> mascotas = new ArrayList<>();

        String query = " SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = " SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + " ) as likes "
                    + " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA
                    + " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " = " + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()) {
                mascotaActual.setRaiting(registrosLikes.getInt(0));
            } else {
                mascotaActual.setRaiting(0);
            }


            mascotas.add(mascotaActual);


        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();

    }

    public void insertarLikeContacto (ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKE_MASCOTA, null, contentValues);
       // db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public  void insertarRaitingMascota (ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAITING_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascota (Mascota mascota) {



        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES+")"
                + " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA
                + " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + "="+ mascota.getId();

        /*String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + ")"
                + " FROM " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA
                + " WHERE " + ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + "=" + mascota.getId(); */

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()) {
            likes = registros.getInt(0);
        }

        db.close();

        return  likes;
    }


}
