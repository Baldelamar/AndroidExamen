package models;

import java.io.Serializable;

public class Persona implements Serializable {

    private String Nombre;
    private String Telefono;
    private String Descripcion;
    private int color;

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    private String Ubicacion;

    public  String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    public int getColor() {
        return color;
    }

    public Persona(String nombre, String telefono, String descripcion, int color, String ubicacion) {
        Nombre = nombre;
        Telefono = telefono;
        Descripcion = descripcion;
        this.color = color;
        Ubicacion = ubicacion;
    }

    public void setColor(int color) {
        this.color = color;
    }


}
