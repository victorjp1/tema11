package com.victorlopez.Ejercicio04;

public class Electrodomestico {
    protected double precioBase;
    protected String color;
    protected char consumo;
    protected double peso;
    protected static final String COLOR_DEFAULT = "BLANCO";
    protected static final char CONSUMO_DEFAULT = 'F';
    protected static final double PRECIO_DEFAULT = 100;
    protected static final double PESO_DEFAULT = 5;
    protected static final char[] consumos = {'A','B','C','D','E','F'};
    protected static final String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};

    /**
     * Constructor por defecto de la clase electrodomestico
     */
    public Electrodomestico() {
        this(PRECIO_DEFAULT, COLOR_DEFAULT, CONSUMO_DEFAULT,PESO_DEFAULT);
    }

    /**
     * Constructor con 2 parametros
     * @param precioBase precio base del electrodomestico
     * @param peso peso del electrodomestico
     */
    public Electrodomestico(double precioBase, double peso) {
        this(precioBase, COLOR_DEFAULT, CONSUMO_DEFAULT,peso);
    }

    /**
     * Constructor con todos los datos de la clase electrodomestico
     * @param precioBase precio base
     * @param color color
     * @param consumo consumo energético que produce
     * @param peso peso
     */
    public Electrodomestico(double precioBase, String color, char consumo, double peso) {
        this.precioBase = precioBase;
        this.color = color;
        this.peso = peso;
        comprobarConsumoEnergetico(consumo);
        compruebaColor(color);
    }

    /**
     * Método para obtener el precio final del producto
     * @return precio final calculado
     */
    public double precioFinal(){
        double precioFinal;
        precioFinal = getPrecioBase();
        precioFinal += calcularExtraConsumo();
        precioFinal += calcularExtraPeso();
        return precioFinal;
    }

    /**
     * Método para calcular el precio que se le debe sumar al electrodomestico por el peso
     * @return extra a añadir
     */
    protected double calcularExtraPeso(){
        double peso = getPeso();
        if (peso >= 0 && peso <= 19){
            return 10;
        }else if(peso >= 20 && peso <= 49){
            return 50;
        }else if(peso >= 50 && peso <= 79){
            return 80;
        }else{
            return 100;
        }
    }
    /**
     * Método para calcular el precio que se le debe
     * sumar al electrodomestico por el consumo energético
     * @return extra a añadir
     */
    protected double calcularExtraConsumo(){
        char l = getConsumo();
        switch (l){
            case 'A':
                return 100;
            case 'B':
                return 80;
            case 'C':
                return 60;
            case 'D':
                return 50;
            case 'E':
                return 30;
            case 'F':
                return 10;
        }
        return 'F';
    }

    /**
     * Método que comprueba si la letra de consumo energético es correcta
     * @param c letra a comprobar
     */
    protected void comprobarConsumoEnergetico(char c) {
        boolean correcto = false;
        for (int i = 0; i < consumos.length; i++) {
            if (consumo == consumos[i]) {
                correcto = true;
                this.consumo = c;
                continue;
            }
        }
        if (!correcto) {
            consumo = 'F';
        }
    }

    /**
     * Método que comprueba si el color es correcto o no
     * @param c color a comprobar
     */
    protected void compruebaColor(String c){
        boolean correcto = false;
        for (int i = 0; i < colores.length; i++) {
            if (color.equalsIgnoreCase(colores[i])){
                correcto = true;
                color = c;
                continue;
            }
        }
        if (!correcto){
            color = "blanco";
        }
    }

    /**
     * Método get de precio base
     * @return devuelve el precio base
     */
    public double getPrecioBase() {
        return precioBase;
    }
    /**
     * Método get de color
     * @return devuelve el color
     */
    public String getColor() {
        return color;
    }
    /**
     * Método get de consumo energético
     * @return devuelve el consumo energético
     */
    public char getConsumo() {
        return consumo;
    }

    /**
     * Método get de peso
     * @return devuelve el peso
     */
    public double getPeso() {
        return peso;
    }
}
