package com.victorlopez.Ejercicio04;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Electrodomestico> productos;

    /**
     * Constructor de clase tienda
     * @param productos ArrayList de electrodomesticos a incluir
     */
    public Tienda(ArrayList<Electrodomestico> productos) {
        this.productos = productos;
    }

    /**
     * Método para añadir electrodomesticos a la lista
     * @param e
     */
    public void addProducto(Electrodomestico e){
        productos.add(e);
    }

    /**
     * Devuelve los electrodomesticos
     * @return ArrayList con electrodomesticos
     */
    public ArrayList<Electrodomestico> getProductos() {
        return productos;
    }

    /**
     * Método que obtiene la suma del precio final de todos los electrodomesticos
     * @return cantidad obtenida
     */
    public double totalPrecioElectrodomesticos(){
        double precioFinal = 0;
        for (int i = 0; i < productos.size(); i++) {
            precioFinal += productos.get(i).precioFinal();
        }
        return precioFinal;
    }

    /**
     * Método que calcula el precio total de todos los productos de esa clase
     * @return array, primera posicion la suma de los precio de televisores
     * segunda posicion la suma de los precios de las lavadoras
     * y tercera posición la suma de electrodomesticos que no sean lavadoras ni televisores
     */
    public double[] totalPreciosPorClase(){
        double[] precios = new double[3];
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Television){
                precios[0] += productos.get(i).precioFinal();
            }else if(productos.get(i) instanceof Lavadora){
                precios[1] += productos.get(i).precioFinal();
            }
        }
        precios[2] = totalPrecioElectrodomesticos();
        return precios;
    }
}
