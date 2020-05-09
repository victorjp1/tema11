package com.victorlopez.Ejercicio07;

import java.util.ArrayList;

public class Fila {
    private int id;
    private static final int N_ASIENTOS_DEFAULT = 10;
    ArrayList<Asiento> asientos;

    /**
     * Constructor fila
     * @param id id de la fila
     * @param nAsientos numero de asientos de la fila
     */
    public Fila(int id, int nAsientos) {
        this.id = id;
        asientos = new ArrayList<>();
        crearAsientos(nAsientos);
    }

    /**
     * Constructor de fila
     * @param id id de la fila
     */
    public Fila(int id) {
        this(id, N_ASIENTOS_DEFAULT);
    }

    /**
     * Método para buscar el asiento por ID
     * @param id id a buscar
     * @return Fila o null
     */
    public Asiento buscarAsientoId(int id){
        for (int i = 0; i < asientos.size(); i++) {
            if (asientos.get(i).getId() == id)
                return asientos.get(i);
        }
        return null;
    }

    /**
     * Método para crear asientos
     * @param nAsientos numero de asientos a crear
     */
    private void crearAsientos(int nAsientos){
        if (nAsientos > 0){
            for (int i = 1; i <= nAsientos; i++) {
                asientos.add(new Asiento(i));
            }
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    @Override
    public String toString() {
        return "Fila {" +
                "ID = " + id + "\n" +
                ", Asientos = " + asientos +
                '}' + "\n";
    }
}
