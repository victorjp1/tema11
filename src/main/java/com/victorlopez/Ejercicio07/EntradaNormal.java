package com.victorlopez.Ejercicio07;

public class EntradaNormal extends Entrada{
    protected int numLoteria;
    private static final int PRECIO_BASE = 30;

    /**
     * Constructor de Entrada Normal
     * @param id id de la entrada
     * @param partido partido al que pertenece
     * @param zona zona a la que pertenece
     * @param fila fila a la que pertenece
     * @param asiento asiento a la que pertenece
     * @param numLoteria numero de loteria
     */
    public EntradaNormal(int id, Partido partido, Zona zona, Fila fila, Asiento asiento, int numLoteria) {
        super(id, partido, zona, fila, asiento);
        this.numLoteria = numLoteria;
        precioFinal = precioFinal(PRECIO_BASE);

    }

    @Override
    public String toString() {
        return "Entrada {" +
                ", ID = " + id +
                ", Partido = " + partido +
                ", Zona = " + zona.getId() +
                ", Fila = " + fila.getId() +
                ", Asiento = " + asiento.getId() +
                ", Número Loteria = " + numLoteria +
                ", Precio Final=" + precioFinal +
                '}';
    }
}
