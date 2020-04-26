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

    @Override
    public String toString() {
        return "Multimedia {" +
                "titulo = '" + titulo + '\'' +
                ", autor = " + autor.toString() +
                ", formato = " + formato +
                '}' + "\n";
    }
    public boolean equals(Multimedia m) {
        if (getTitulo().equals(m.getTitulo())){
            return getAutor().getId() == m.getAutor().getId();
        }
        return false;
    }

    public int getId() {
        return id;
    }

    abstract int precioFinal();

    static class OrdenarPorAño implements Comparator<Multimedia>{

        @Override
        public int compare(Multimedia m1, Multimedia m2) {
            return m1.getAnyos() - m2.getAnyos();
        }
    }
    public Multimedia(String titulo, Empresa autor, Formato formato, LocalDate fechaEstreno) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.fechaEstreno = fechaEstreno;
        this.id = ++nMultimedia;
        this.disponible = true;
    }
    @Override
    public int compareTo(Multimedia m){
        return this.titulo.compareTo(m.titulo);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public int getPRECIO_BASE() {
        return PRECIO_BASE;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }

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
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Empresa getAutor() {
        return autor;
    }

    public void setAutor(Empresa autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}
