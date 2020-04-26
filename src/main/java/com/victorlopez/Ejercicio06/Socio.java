package com.victorlopez.Ejercicio06;

import java.time.LocalDate;

public class Socio extends Persona {
    private String poblacion;
    private boolean alquilerPendiente;
    public Socio(String dni, String nombre,String apellidos, LocalDate fechaNacimiento, String poblacion) {
        super(dni, nombre,apellidos, fechaNacimiento);
        this.poblacion = poblacion;
        alquilerPendiente = false;
    }

    public String getPoblacion() {
        return poblacion;
    }

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
                '}';
    }
}
