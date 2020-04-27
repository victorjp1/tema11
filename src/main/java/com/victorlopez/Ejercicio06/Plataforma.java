package com.victorlopez.Ejercicio06;

public class Plataforma {
    public static int nPlataformas = 0;
    int id;//id de la plataforma
    String nombre;//Nombre de la plataforma
    String companyia;//Compañia a la que pertenece la plataforma

    public Plataforma(String nombre, String companyia) {
        this.id = ++nPlataformas;
        this.nombre = nombre;
        this.companyia = companyia;
    }

    /**
     * Método para obtener el id
     * @return id de la plataforma
     */
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

    /**
     * Método para obtener el nombre de la plataforma
     * @return nombre de la plataforma
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la compañia
     * @return compañia(String)
     */
    public String getCompanyia() {
        return companyia;
    }
}
