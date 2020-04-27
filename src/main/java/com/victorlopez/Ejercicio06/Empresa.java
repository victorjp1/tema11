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

    /**
     * Método para obtener el nombre de la empresa
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el ID de la empresa
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Método toString de empresa
     * @return String generado
     */
    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", id=" + id +
                '}';
    }
}
