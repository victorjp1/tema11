package com.victorlopez.Ejercicio06;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public abstract class Multimedia implements Comparable<Multimedia>{
    protected static int nMultimedia = 0;
    protected int id;
    protected String titulo;
    protected Empresa autor;
    protected Formato formato;
    protected LocalDate fechaEstreno;
    protected boolean disponible;
    protected final int PRECIO_BASE = 4;
    protected int precioFinal;

    public Multimedia(String titulo, Empresa autor, Formato formato, LocalDate fechaEstreno) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.fechaEstreno = fechaEstreno;
        this.id = ++nMultimedia;
        this.disponible = true;
    }
    @Override
    public String toString() {
        return "Multimedia {" +
                "titulo = '" + titulo + '\'' +
                ", autor = " + autor.toString() +
                ", formato = " + formato +
                '}' + "\n";
    }

    /**
     * Método para comparar 2 Multimedia
     * @param m Multimedia 2
     * @return True si son iguales y false si no
     */
    public boolean equals(Multimedia m) {
        if (getTitulo().equals(m.getTitulo())){
            return getAutor().getId() == m.getAutor().getId();
        }
        return false;
    }

    /**
     * Método para obtener el ID
     * @return  Devuelve el ID
     */
    public int getId() {
        return id;
    }

    /**
     * Método que obtiene el precio final
     * @return precio final
     */
    abstract int precioFinal();

    /**
     * Clase para ordenar por año
     */
    static class OrdenarPorAño implements Comparator<Multimedia>{
        /**
         * Método para comparar por año
         * @param m1 Multimedia 1 a comparar
         * @param m2 Multimedia 2 a comparar
         * @return La diferencia de años entre el primero y el segundo
         */
        @Override
        public int compare(Multimedia m1, Multimedia m2) {
            return m1.getAnyos() - m2.getAnyos();
        }
    }

    /**
     * Método para comparar por título
     * @param m Multimedia 2 a comparar
     * @return
     */
    @Override
    public int compareTo(Multimedia m){
        return this.titulo.compareTo(m.titulo);
    }

    /**
     * Para saber si esta disponible para alquilar
     * @return true o false
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Devuelve la fecha de estreno del multimedia
     * @return LocalDate
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Precio Base Final
     * @return devuelve el precio base final
     */
    public int getPrecioFinal() {
        return precioFinal;
    }

    /**
     * Método para cambiar la disponibilidad
     * @param disponible true o false
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Método para calcular años a través de una fecha
     * @return devolvemos un entero, la edad del paciente
     */
    public int getAnyos(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaEstreno, ahora);
        int a = periodo.getYears();
        return a;
    }

    /**
     * Método para obtener el título
     * @return Titulo (String)
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Método para cambiar el título
     * @param titulo Titulo a cambiar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Método para obtener el autor
     * @return Autor
     */
    public Empresa getAutor() {
        return autor;
    }
    /**
     * Método para cambiar el empresa
     * @param e Empresa a cambiar
     */
    public void setAutor(Empresa e) {
        this.autor = e;
    }
    /**
     * Método para obtener el Formato
     * @return Formato
     */
    public Formato getFormato() {
        return formato;
    }

    /**
     * Método para cambiar el formato
     * @param formato Formato a cambiar
     */
    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}
