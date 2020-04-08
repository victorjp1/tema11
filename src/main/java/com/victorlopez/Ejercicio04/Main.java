package com.victorlopez.Ejercicio04;

import java.util.ArrayList;

public class Main {
    static ArrayList<Electrodomestico> productos;
    static Tienda t;
    public static void main(String[] args) {
        productos = new ArrayList<>();
        casosPrueba();
        t = new Tienda(productos);
        precioFinal();
        double[] precios = t.totalPreciosPorClase();
        System.out.println("Precio total de televisiones: ");
        System.out.println(precios[0]);
        System.out.println("Precio total de lavadoras: ");
        System.out.println(precios[1]);
        System.out.println("Precio total de electrodomésticos: ");
        System.out.println(precios[2]);
    }

    /**
     * Método para imprimir los precios finales de todos los productos
     */
    public static void precioFinal(){
        System.out.println("Precios finales de todos los productos: ");
        for (int i = 0; i < t.getProductos().size(); i++) {
            System.out.println(t.getProductos().get(i).precioFinal());
        }
    }
    /**
     * Método para añadir casos de prueba.
     */
    public static void casosPrueba(){
        productos.add(new Television());
        productos.add(new Lavadora());
        productos.add(new Electrodomestico());
        productos.add(new Television(400,50));
        productos.add(new Lavadora(300,150));
        productos.add(new Television(200, "rojo", 'C',40, 50, true));
        productos.add(new Lavadora(250, "blanco", 'B',200, 50));
        productos.add(new Television(600, "negro", 'A',20, 30, false));
        productos.add(new Lavadora(500, "azul", 'F',400, 15));
        productos.add(new Television(2000, "negro", 'A',60, 100, true));
        productos.add(new Electrodomestico(1500, "gris", 'A',60));
    }
}
