package com.victorlopez.Ejercicio02;

import com.victorlopez.Ejercicio01.Punto;

import java.util.ArrayList;

public class Poligono {
    private ArrayList<Punto> poligono;

    /**
     * Constructor de la clase punto
     * @param p ArrayList de puntos
     */
    public Poligono(ArrayList<Punto> p) {
        this.poligono = p;
    }

    /**
     * Método que traslada el polígono
     * @param x num de coordenadas x a desplazar
     * @param y num de coordenadas y a desplazar
     */
    public void traslada(double x, double y){
        for (int i = 0; i < numVertex(); i++) {
            Punto p = poligono.get(i);
            p.setX(p.getX() + x);
            p.setY(p.getY() + y);
        }
    }

    /**
     * Método que devuelve el número de vertices que tiene el poligono
     * @return num de vertices
     */
    public int numVertex(){
        return poligono.size();
    }
    @Override
    public String toString() {
        return "Poligono" +
                poligono.toString();
    }

    /**
     * Método que calcula el perímetro de polígonos irregulares
     * @return devuelve el perímetro
     */
    public double perimetro(){
        double perimetro = 0;
            perimetro += poligono.get(0).distancia(poligono.get(1)) * numVertex();
        return perimetro;
    }

}
