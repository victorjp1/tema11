package com.victorlopez.Ejercicio06;

import java.time.LocalDate;

public class Socio extends Persona {
    private String poblacion;
    public Socio(String dni, String nombre,String apellidos, LocalDate fechaNacimiento, String poblacion) {
        super(dni, nombre,apellidos, fechaNacimiento);
        this.poblacion = poblacion;
    }

    /**
     * Método para obtener la poblacion del Socio
     * @return devuelve la poblacion (String)
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Método para cambiar la poblacion
     * @param poblacion poblacion a cambiar
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Socio {" +
                "Poblacion = '" + poblacion + '\'' +
                ", dni = '" + dni + '\'' +
                ", Nombre = '" + nombre + '\'' +
                ", Fecha de Nacimiento = " + fechaNacimiento +
                '}' + "\n";
    }
}
