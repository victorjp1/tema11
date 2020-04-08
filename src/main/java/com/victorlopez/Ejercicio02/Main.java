package com.victorlopez.Ejercicio02;

import com.victorlopez.Ejercicio01.Punto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Punto> p = new ArrayList<>();
        p.add(new Punto(0,0));
        p.add(new Punto(2,0));
        p.add(new Punto(2,2));
        p.add(new Punto(0,2));
        Poligono poligono = new Poligono(p);
        System.out.println("Vértices del polígono:");
        System.out.println(poligono.toString());
        System.out.println("Perímetro del polígono:");
        System.out.println(poligono.perimetro());
        poligono.traslada(4,-3);
        System.out.println("Información del polígono después de desplazar:");
        System.out.println(poligono.toString());
        System.out.println("Perímetro del polígono después de desplazar:");
        System.out.println(poligono.perimetro());
        System.out.println("Número de vértices del polígono: ");
        System.out.println(poligono.numVertex());
    }
}
