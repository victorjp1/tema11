package com.victorlopez.Ejercicio07;

import java.util.ArrayList;

public class Zona {
    private static int nZonas = 0;
    private static final int N_FILAS_DEFAULT = 5;
    private static final int N_ASIENTOS_DEFAULT = 10;
    private ArrayList<Fila> filas;
    private TipoZona tipoZona;
    private int id;

    /**
     * Constructor Zona
     * @param tipoZona tipo de zona
     * @param nFilas numero de filas
     */
    public Zona(TipoZona tipoZona, int nFilas) {
       this(tipoZona, nFilas, N_ASIENTOS_DEFAULT);
    }

    /**
     * Constructor zona
     * @param tipoZona tipo de zona
     */
    public Zona(TipoZona tipoZona) {
        this(tipoZona, N_FILAS_DEFAULT, N_ASIENTOS_DEFAULT);
    }

    /**
     * Constructor Zona
     * @param tipoZona tipo de zona
     * @param nFilas numero de filas
     * @param asientosPorFila numero de asientos por fila
     */
    public Zona(TipoZona tipoZona, int nFilas, int asientosPorFila) {
        this.tipoZona = tipoZona;
        id = ++nZonas;
        filas = new ArrayList<>();
        crearFilas(nFilas, asientosPorFila);
    }

    /**
     * Método para crear filas de la zona
     * @param nFilas numero de filas
     */
    private void crearFilas(int nFilas){
        if (nFilas > 0){
            for (int i = 1; i <= nFilas; i++) {
                filas.add(new Fila(i));
            }
        }
    }

    /**
     * Método para buscar una fila
     * @param id id a buscar
     * @return Fila o null
     */
    public Fila buscarFilaId(int id){
        for (int i = 0; i < filas.size(); i++) {
            if (filas.get(i).getId() == id)
                return filas.get(i);
        }
        return null;
    }
    public ArrayList<Fila> getFilas() {
        return filas;
    }

    public TipoZona getTipoZona() {
        return tipoZona;
    }

    public int getId() {
        return id;
    }

    /**
     * Método para crear filas
     * @param nFilas numero de filas
     * @param asientosPorFila numero de asientos por fila
     */
    private void crearFilas(int nFilas, int asientosPorFila){
        if (nFilas > 0 && asientosPorFila > 0){
            for (int i = 1; i <= nFilas; i++) {
                filas.add(new Fila(i,asientosPorFila));
            }
        }
    }
    @Override
    public String toString() {
        return "Zona {" +
                ", ID = " + id +
                ", tipoZona = " + tipoZona + "\n" +
                "Filas = " + filas.toString() +
                '}' + "\n";
    }
}
