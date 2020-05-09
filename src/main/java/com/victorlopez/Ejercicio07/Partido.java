package com.victorlopez.Ejercicio07;

import java.time.LocalDate;
import java.util.ArrayList;

public class Partido implements Comparable<Partido>{
    private static int nPartidos = 0;
    private int nEntradas = 0;
    private int id;
    private Estadio estadio;
    private Afluencia afluencia;
    private LocalDate fecha;
    private String visitante;
    private String local;
    private ArrayList<Entrada> entradas;
    private Bombo bombo;//Bombo para realizar el sorteo de las entradas

    /**
     * Constructor de Partido
     * @param estadio Estadio que tendrá
     * @param afluencia Afluencia del partido
     * @param fecha fecha del partido
     * @param visitante equipo visitante
     * @param local equipo local
     */
    public Partido(Estadio estadio, Afluencia afluencia, LocalDate fecha, String visitante, String local) {
        this.id = ++nPartidos;
        this.estadio = estadio;
        this.afluencia = afluencia;
        this.fecha = fecha;
        this.visitante = visitante;
        this.local = local;
        entradas = new ArrayList<>();
        bombo = new Bombo(1, estadio.getNAsientos());
    }

    /**
     * Método para añadir una nueva entrada
     * @param zona zona en la que se va a comprar
     * @param fila Fila en la que se va a comprar
     * @param asiento asiento a comprar
     * @return
     */
    public Entrada addEntrada(Zona zona, Fila fila, Asiento asiento){
        if (asiento.isOcupado())
            return null;
        Entrada e = null;
        switch (zona.getTipoZona()){
            case ESTANDARD:
                e = new EntradaNormal(++nEntradas, this, zona, fila, asiento, bombo.sacarBola());
                entradas.add(e);
                asiento.setOcupado(true);
                break;
            case VIP:
                e = new EntradaVIP(++nEntradas, this, zona, fila, asiento);
                entradas.add(e);
                asiento.setOcupado(true);
                break;
        }
        return e;
    }

    /**
     * Método para eliminar una entrada
     * @param id id de la entrada
     * @return devuelve Entrada o null si no se ha encontrado
     */
    public Entrada eliminarEntrada(int id){
        for (int i = 0; i < entradas.size(); i++) {
            if (entradas.get(i).getId() == id){
                Entrada e = entradas.get(i);
                e.asiento.setOcupado(false);
                entradas.remove(i);
                return e;
            }
        }
        return null;
    }

    /**
     * Método para obtener la recaudación total de un partido
     * @return Recaudación
     */
    public double getRecaudacion(){
        double recaudacion = 0;
        for (int i = 0; i < entradas.size(); i++) {
            recaudacion += entradas.get(i).getPrecioFinal();
        }
        return recaudacion;
    }
    public Estadio getEstadio() {
        return estadio;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public int getId() {
        return id;
    }
    public Afluencia getAfluencia() {
        return afluencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getVisitante() {
        return visitante;
    }

    public String getLocal() {
        return local;
    }

    @Override
    public String toString() {
        return "Partido {" +
                "ID = " + id +
                ", Afluencia = " + afluencia +
                ", Fecha=" + fecha +
                ", Visitante='" + visitante + '\'' +
                ", Local='" + local + '\'' +
                '}' + "\n";
    }

    /**
     * Método para ordenar partidos por fecha
     * @param p partido a valorar
     * @return diferencia
     */
    @Override
    public int compareTo(Partido p) {
        return getFecha().compareTo(p.getFecha());
    }

}
