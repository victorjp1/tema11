package com.victorlopez.Ejercicio06;

import java.time.LocalDate;

public class Actor extends Persona{
    private Sexo sexo;
    public Actor(String dni, String nombre,String apellidos, LocalDate fechaNacimiento,Sexo s ) {
        super(dni, nombre,apellidos, fechaNacimiento);
        this.sexo = s;
    }

    @Override
    public String toString() {
        return "Actor {" +
                ", dni = '" + dni + '\'' +
                ", Nombre = '" + nombre + '\'' +
                ", Fecha deNacimiento = " + fechaNacimiento +
                '}';
    }

    /**
     * Método para obtener el sexo del actor
     * @return Sexo
     */
    public Sexo getSexo() {
        return sexo;
    }
}
