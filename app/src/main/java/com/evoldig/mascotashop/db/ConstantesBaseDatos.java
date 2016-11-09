package com.evoldig.mascotashop.db;

/**
 * Created by jazocar on 1/11/16.
 */

public final class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS = "mascotas";
    public static final String TABLE_MASCOTAS_ID = "id";
    public static final String TABLE_MASCOTAS_NOMBRE = "nombre";
    public static final String TABLE_MASCOTAS_FOTO = "foto";

    public static final String TABLE_LIKE_MASCOTA = "mascota_likes";
    public static final String TABLE_LIKE_MASCOTA_ID = "id";
    public static final String TABLE_LIKE_MASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKE_MASCOTA_NUMERO_LIKES = "numero_likes";

    public static final String TABLE_RAITING_MASCOTA = "mascota_raiting";
    public static final String TABLE_RAITING_MASCOTA_ID = "id";
    public static final String TABLE_RAITING_MASCOTA_ID_RAITING = "id_raiting";
    public static final String TABLE_RAITING_MASCOTA_ID_NUMERO_LIKES = "rating_numero_likes";
    public static final String TABLE_RAITING_MASCOTA_NOMBRE = "raiting_nombre";
    public static final String TABLE_RAITING_MASCOTA_FOTO = "raiting_foto";
}
