package com.victorlopez.Ejercicio06;

import java.time.LocalDate;
import java.time.Period;

public class Alquiler implements Comparable<Alquiler>{
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private Multimedia m;
    private int precioFinal;
    private Socio socio;
    //Constructor habitual
    public Alquiler(Multimedia m, Socio socio,LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        this.socio = socio;
        fechaDevolucion = null;
        this.m = m;
    }


    /**
     * Método para devolver un multimedia
     * @param fechaDevolucion
     */
    public void devolver(LocalDate fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
        precioFinal = precioFinal();
    }

    /**
     * Precio final con recargos
     * @return Precio Final
     */
    public int precioFinal(){
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

    /**
     * Precio final solamente para calcular en caso de que queramos saber el precio antes
     * @param f fecha ficticia de devolucion
     * @return precio Final
     */
    public int precioFinal(LocalDate f){
        int precioFinal = m.precioFinal;
        Period periodo = Period.between(fechaAlquiler, f);
        int d = periodo.getDays();
        if (d > 3){
            d -= 3;
            precioFinal += (d*2);
        }
        return precioFinal;
    }

    /**
     * Método para obtener la fecha del Alquiler
     * @return fecha (LocalDate)
     */
    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    /**
     * Método para devolver la fecha de Devolucion
     * @return fecha de devolucion (Localdate)
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Método para obtener el producto alquilado
     * @return objeto multimedia
     */
    public Multimedia getMultimedia() {
        return m;
    }

    /**
     * Método para obtener el precio final
     * @return precio final
     */
    public int getPrecioFinal() {
        return precioFinal;
    }

    /**
     * Método para obtener el socio
     * @return socio
     */
    public Socio getSocio() {
        return socio;
    }
    /**
     * Método para calcular años a través de una fecha
     * @return devolvemos un entero, la edad del paciente
     */
    public int getAnyos(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaAlquiler, ahora);
        int a = periodo.getYears();
        return a;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "fechaAlquiler=" + fechaAlquiler +
                ", fechaDevolucion=" + fechaDevolucion +
                ", m=" + m +
                ", precioFinal=" + precioFinal +
                ", socio=" + socio +
                '}';
    }

    /**
     * Método para comparar por fecha de alquiler
     * @param alquiler alquiler a comparar
     * @return diferencia
     */
    @Override
    public int compareTo(Alquiler alquiler) {
        return getAnyos() - alquiler.getAnyos();
    }
}

