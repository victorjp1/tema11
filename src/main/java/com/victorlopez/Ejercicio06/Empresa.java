package com.victorlopez.Ejercicio06;

public class Empresa{
    private String nombre;
    private String mail;
    private int id;
    private static int nEmpresas = 0;
    public Empresa(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.id = ++nEmpresas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", id=" + id +
                '}';
    }
}
