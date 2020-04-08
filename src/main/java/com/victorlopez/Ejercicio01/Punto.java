package com.victorlopez.Ejercicio01;

public class Punto {
    private double x;
    private double y;

    /**
     * Constructor de la clase punto
     * @param x coordenada x
     * @param y coordenada y
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor por defecto de la clase punto
     */
    public Punto(){
        this(-1,-1);
    }

    /**
     * Método para obtener la coordenada x del punto
     * @return coordenada x del punto
     */
    public double getX() {
        return x;
    }

    /**
     * Método para cambiar la coordenada x
     * @param x coordenada a cambiar
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Método para obtener la coordenada y
     * @return coordenada y
     */
    public double getY() {
        return y;
    }

    /**
     * Método para cambiar la coordenada y
     * @param y coordenada a cambiar
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Método para calcular la distancia entre 2 puntos
     * @param p2 segundo punto a valorar
     * @return distancia entre los 2 puntos
     */
    public double distancia(Punto p2){
            double cateto1 = x - p2.getX();
            double cateto2 = y - p2.getY();
            double hipotenusa = Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
            return hipotenusa;
    }

    /**
     * To String de Punto
     * @return String generado
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
