package com.victorlopez.Ejercicio06;

import java.time.LocalDate;
import java.time.Period;

public class Alquiler {
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private Multimedia m;
    private int precioFinal;
    private Socio socio;

    public Alquiler(Multimedia m, Socio socio,LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        this.socio = socio;
        fechaDevolucion = null;
        this.m = m;
    }
    //Constructor para pruebas
    public Alquiler(LocalDate fechaAlquiler, LocalDate fechaDevolucion, Multimedia m, Socio socio) {
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.m = m;
        this.precioFinal = precioFinal();
        this.socio = socio;
    }

    private void devolver(LocalDate fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
        precioFinal = precioFinal();
    }
    private int precioFinal(){
        int precioFinal = m.precioFinal;
        if (fechaDevolucion != null){
            Period periodo = Period.between(fechaAlquiler, fechaDevolucion);
            int d = periodo.getDays();
            if (d > 3){
                d -= 3;
                precioFinal += (d*2);
                return precioFinal;
            }
        }
        return -1;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Multimedia getM() {
        return m;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }

    public Socio getSocio() {
        return socio;
    }
}

