package com.victorlopez.Ejercicio05;

public abstract class Item {
    int maxStack;//Máxima capacidad de stack
    String nombre;//Nombre del objeto
    /**
     * Método getter del máximo de Stack que tiene el objeto
     * @return Stack máximo
     */
    public int getMaxStack(){
        return maxStack;
    }
    /**
     * Método getter del nombre del objeto
     * @return Nombre del objeto
     */
    public String getNombre(){
        return nombre;
    }
}
