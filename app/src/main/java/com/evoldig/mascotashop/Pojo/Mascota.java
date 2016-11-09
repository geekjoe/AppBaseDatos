package com.evoldig.mascotashop.Pojo;

import java.io.Serializable;

/**
 * Created by jazocar on 20/10/16.
 */

public class Mascota implements Serializable {

    private int id;
    private String nombre;
    private int foto;
    private int raiting;


    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.raiting = 0;
        this.id = 0;
    }

    public Mascota() {

    }


    public int getId() { return id;}
    public void setId (int id) {this.id = id;}

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
        if (this.raiting >= 5) raiting=5;
        this.raiting = raiting;
    }
}
