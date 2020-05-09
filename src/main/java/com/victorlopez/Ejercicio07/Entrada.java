package com.victorlopez.Ejercicio07;

public abstract class Entrada {
    protected int id;
    protected Partido partido;
    protected Zona zona;
    protected Fila fila;
    protected Asiento asiento;
    protected double precioFinal;

    public Entrada(int id,Partido partido, Zona zona, Fila fila, Asiento asiento) {
        this.id = id;
        this.partido = partido;
        this.zona = zona;
        this.fila = fila;
        this.asiento = asiento;
    }

    public int getId() {
        return id;
    }

    public Partido getPartido() {
        return partido;
    }

    public Zona getZona() {
        return zona;
    }

    public Fila getFila() {
        return fila;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    /**
     * Método para calcular el precio final de la entrada
     * @param precioBase Precio base a valorar
     * @return Precio final
     */
    protected double precioFinal(int precioBase) {
        double precio = precioBase;
        switch (partido.getAfluencia()){
            case ALTA_AFLUENCIA:
                precio *= 1.3;
                break;
            case MEDIA_AFLUENCIA:
                break;
            case BAJA_AFLUENCIA:
                precio *= 0.75;
                break;
        }
        return precio;
    }
}
