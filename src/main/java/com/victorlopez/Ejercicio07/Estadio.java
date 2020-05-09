package com.victorlopez.Ejercicio07;

import java.util.ArrayList;

public class Estadio {
    private ArrayList<Zona> zonas;
    private String nombre;
    private int m2;
    private TipoCesped tipoCesped;

    /**
     * Constructor de Estadio
     * @param nombre Nombre del estadio
     * @param m2 Metros cuadrados del estadio
     * @param tipoCesped Tipo de cesped
     */
    public Estadio(String nombre, int m2, TipoCesped tipoCesped) {
        this.nombre = nombre;
        this.m2 = m2;
        this.tipoCesped = tipoCesped;
        zonas = new ArrayList<>();
    }

    /**
     * Constructor copia de Estadio
     * @param e estadio a copiar
     */
    public Estadio(Estadio e) {
        this.zonas = e.zonas;
        this.nombre = e.nombre;
        this.m2 = e.m2;
        this.tipoCesped = e.tipoCesped;
    }

    /**
     * Buscar zona por ID
     * @param id id a buscar
     * @return zona encontrada o null
     */
    public Zona buscarZonaId(int id){
        for (int i = 0; i < zonas.size(); i++) {
            if (zonas.get(i).getId() == id){
                return zonas.get(i);
            }
        }
        return null;
    }

    /**
     * Método para obtener el número de asientos
     * @return número de asientos
     */
    public int getNAsientos(){
        int nAsientos = 0;
        for (int i = 0; i < zonas.size(); i++) {
            for (int j = 0; j < zonas.get(i).getFilas().size(); j++) {
                for (int k = 0; k < zonas.get(i).getFilas().get(j).getAsientos().size(); k++) {
                    nAsientos++;
                }
            }
        }
        return nAsientos;
    }

    /**
     * Método para obtener el número de asientos (Si todas las zonas fueran iguales
     * @return nAsientos
     */
    public int getNasientos2(){
        int nAsientos;
        nAsientos = getZonas().size() * getZonas().get(0).getFilas().size() * getZonas().get(0).getFilas().get(0).getAsientos().size();
        return nAsientos;
    }

    /**
     * Método para añadir una nueva zona
     * @param tipoZona tipo de zona
     */
    public void addZona(TipoZona tipoZona){
        zonas.add(new Zona(tipoZona));
    }

    /**
     * Método para añadir una nueva zona
     * @param tipoZona tipo de zona
     * @param nFilas numero de filas en la zona
     */
    public void addZona(TipoZona tipoZona, int nFilas){
        zonas.add(new Zona(tipoZona, nFilas));
    }

    /**
     * Método para añadir una nueva zona
     * @param tipoZona tipo de zona
     * @param nFilas numero de filas de la zona
     * @param asientosPorFila numero de asientos por fila
     */
    public void addZona(TipoZona tipoZona, int nFilas, int asientosPorFila){
        zonas.add(new Zona(tipoZona, nFilas, asientosPorFila));
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getM2() {
        return m2;
    }

    public TipoCesped getTipoCesped() {
        return tipoCesped;
    }

    @Override
    public String toString() {
        return "Estadio {" +
                "Zonas = " + zonas.toString() +
                ", Nombre = '" + nombre + '\'' +
                ", Metros cuadrados = " + m2 +
                ", Tipo de cesped = " + tipoCesped +
                '}' + "\n";
    }
}
