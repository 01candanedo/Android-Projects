package com.example.pedidosdespues;

public class Restaurante {

    private int Imagen;
    private String Nombre;
    private String Precio;
    private String Location;
    private String Rating;

    public Restaurante(int imagen, String nombre, String precio, String location, String rating) {
        Imagen = imagen;
        Nombre = nombre;
        Precio = precio;
        Location = location;
        Rating = rating;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
