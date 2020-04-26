package com.victorlopez.Ejercicio06;

public class Plataforma {
    public static int nPlataformas = 0;
    int id;
    String nombre;
    String companyia;//Lo haría con una clase pero en este ejercicio lo veo innecesario

    public Plataforma(String nombre, String companyia) {
        this.id = ++nPlataformas;
        this.nombre = nombre;
        this.companyia = companyia;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", companyia='" + companyia + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getCompanyia() {
        return companyia;
    }
}
