package com.victorlopez.Ejercicio06;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected String persona;
    protected LocalDate fechaNacimiento;
    public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método que devuelve la fecha de Nacimiento
     * @return Devuelve la fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que devuelve el DNI
     * @return DNI (String)
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método para obtener el nombre
     * @return Nombre (String)
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Persona {" +
                "dni = '" + dni + '\'' +
                ", nombre = '" + nombre + '\'' +
                ", fechaNacimiento = " + fechaNacimiento +
                '}';
    }
}
