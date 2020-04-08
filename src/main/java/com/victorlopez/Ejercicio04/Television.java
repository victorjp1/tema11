package com.victorlopez.Ejercicio04;

public class Television extends Electrodomestico{
    private double resolucion;
    private boolean smartTV;
    private static boolean SMARTTV_DEFAULT = false;
    private static double RESOLUCION_DEFAULT = 20;

    /**
     * Constructor por defecto de televisión
     */
    public Television() {
        super();
        smartTV = SMARTTV_DEFAULT;
        resolucion = RESOLUCION_DEFAULT;
    }

    /**
     * Constructor con 2 valores de TV
     * @param precioBase precio base de la TV
     * @param peso peso de la TV
     */
    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        smartTV = SMARTTV_DEFAULT;
        resolucion = RESOLUCION_DEFAULT;
    }

    /**
     * Constructor con todos los valores de TV
     * @param precioBase precio de la TV
     * @param color color de la TV
     * @param consumo consumo de la TV
     * @param peso peso de la TV
     * @param resolucion resolucion de la TV
     * @param smartTV boolean que determina si es Smart TV o no
     */
    public Television(double precioBase, String color, char consumo, double peso, double resolucion, boolean smartTV) {
        super(precioBase, color, consumo, peso);
        this.resolucion = resolucion;
        this.smartTV = smartTV;
    }

    /**
     * Método para obtener el precio final de la TV
     * @return precio final de la TV
     */
    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (smartTV){
            precioFinal += 50;
        }
        if (resolucion > 40){
            precioFinal *= 1.3;
        }
        return precioFinal;
    }

    /**
     * Método get de resolucion
     * @return devuelve la resolucion
     */
    public double getResolucion() {
        return resolucion;
    }
    /**
     * Método get de si es Smart TV o no
     * @return devuelve true si es Smart TV y false si no lo es
     */
    public boolean isSmartTV() {
        return smartTV;
    }
}
