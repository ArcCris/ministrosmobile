package com.example.copazo.ministros.Model;

public class Direccion {

    private String nombre;
    private String lng;
    private String lat;

    public Direccion(String nombre, String lng, String lat){
        this.nombre = nombre;
        this.lng = lng;
        this.lat = lat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
