package com.victorlopez.Ejercicio05;

public class Slot {

    private boolean vacio;//Variable que dice
    private int stack;//Variable que almacena el Stack que tiene en este momento
    private Item item;//Objeto que contiene el Slot

    /**
     * Constructor de la clase Slot
     */
    public Slot() {
        vacio = true;
        item = null;
        stack = 0;
    }

    /**
     * Método para cambiar el tipo de Item del Slot
     * @param objeto nuevo objeto
     */
    public void setItem(Item objeto){
            this.item = objeto;
            vacio = false;
    }

    /**
     * Método para añadir existenciasa de un Item
     * @param num número de existencias
     * @return cantidad que ha sobrado.
     */
    public int stackItem(int num){
        int sobrante = 0;
        if(stack + num > item.getMaxStack()){
            sobrante = num - (item.getMaxStack() - stack);
            stack = item.getMaxStack();
        }else{
            stack += num;
            sobrante = 0;
        }
        return sobrante;
    }

    /**
     * Método para quitar Stack de un Item
     * @param num número de existencias a eliminar
     * @return stack total
     */
    public int unstackItem(int num){
        stack -= num;
        if(stack <= 0){
            stack = 0;
            vacio = true;
        }
        return stack;
    }

    /**
     * Método que devuelve el Item que hay en el Slot
     * @return Item en el Slot
     */
    public Item getItem(){
        return item;
    }

    /**
     * Método que dice si el Slot está vacío o no
     * @return true o false, true si está vacía, false si no lo está
     */
    public boolean isVacio(){
        return vacio;
    }

    /**
     * Imprime el Slot
     * @return Nombre y stack del Item
     */
    public String toString() {
        if (isVacio()){
            return "\"Vacío\"";
        }else{
            return stack + " " + item.getNombre();
        }
    }

    /**
     * Método que consulta el Stack actual del Item
     * @return stack actual del Item
     */
    public int getStack(){
        return stack;
    }
}
