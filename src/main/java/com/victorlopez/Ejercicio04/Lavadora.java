package com.victorlopez.Ejercicio04;

public class Lavadora extends Electrodomestico{
    private double carga;
    private static final double CARGA_DEFAULT = 5;

    public Lavadora() {
        super();
        carga = CARGA_DEFAULT;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        carga = CARGA_DEFAULT;
    }

    public Lavadora(double precioBase, String color, char consumo, double peso, double carga) {
        super(precioBase, color, consumo, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (carga > 30){
            precioFinal += 50;
        }
        return precioFinal;
    }
}
