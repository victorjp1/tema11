package com.victorlopez.Ejercicio07;

import java.util.ArrayList;

public class Jugador {
    private String dni;
    private ArrayList<String> posiciones;
    private int dorsal;

    /**
     * Constructor de Jugador
     * @param dni dni del jugador
     * @param posiciones posiciones en las que es capaz de jugar
     * @param dorsal dorsal del jugador
     */
    public Jugador(String dni, ArrayList<String> posiciones, int dorsal) {
        this.dni = dni;
        this.posiciones = posiciones;
        this.dorsal = dorsal;
    }

    @Override
    public String toString() {
        return "Jugador {" +
                "DNI = '" + dni + '\'' +
                ", Posiciones=" + posiciones .toString()+
                ", Dorsal = " + dorsal +
                '}' + "\n";
    }
}
