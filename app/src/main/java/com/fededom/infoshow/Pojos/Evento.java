package com.fededom.infoshow.Pojos;

/**
 * Created by Fededom on 16/05/2017.
 */

public class Evento {

    private String titulo;
    private String fechaHora;
    private String lugar;
    private String descripcion;
    private String imagen;


    
    public Evento() {

    }

    public Evento( String titulo, String fechaHora, String lugar, String descripcion, String imagen ) {
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }





}
