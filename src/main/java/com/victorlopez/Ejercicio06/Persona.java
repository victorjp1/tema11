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

    public String getPersona() {
        return persona;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

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

    public int getEdad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        int a = periodo.getYears();
        return a;
    }
}
