package com.evoldig.mascotashop.Pojo;

import java.io.Serializable;

/**
 * Created by jazocar on 26/10/16.
 */

public class Dummy implements Serializable {

    private String nombre;
    private int foto;
    private int raiting;

    public Dummy(String nombre, int foto, int raiting) {
        this.nombre = nombre;
        this.foto = foto;
        this.raiting = raiting;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;


    }
}
