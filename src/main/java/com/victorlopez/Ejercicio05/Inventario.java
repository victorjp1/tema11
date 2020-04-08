package com.victorlopez.Ejercicio05;

public class Inventario {
    private Slot[] inventario;//Casillas del inventario
    private static final int NUM_SLOTS = 7;//Constante para el constructor por defecto

    /**
     * Constructor por defecto de la clase inventario
     */
    public Inventario() {
        this(NUM_SLOTS);
    }

    /**
     * Constructor de la clase inventario
     * @param numSlots numero de slots del inventario.
     */
    public Inventario(int numSlots) {
        this.inventario = new Slot[numSlots];
        inicializarInventario();
    }
    private void inicializarInventario(){
        for(int i = 0; i < inventario.length; i++){
            inventario[i] = new Slot();
        }
    }
    /**
     * Método para añadir Items al inventario, primero miro si existe ese Item en el Inventario,
     * si no existe voy mirando que slots están vacíos y rellenandolos con este Item.
     * @param item item a introducir
     * @param cantidad cantidad a introducir
     * @return devuelve el excedente que no cabe en el inventario
     */
    public int addItem(Item item, int cantidad){
        for(int i = 0; i < inventario.length; i++){
            if(inventario[i].getItem() != null && inventario[i].getItem().getClass().equals(item.getClass())){
                cantidad = inventario[i].stackItem(cantidad);
            }
        }
        if(cantidad > 0){
            for(int i = 0; i < inventario.length && cantidad > 0; i++){
                if(inventario[i].isVacio()){
                    inventario[i].setItem(item);
                    cantidad = inventario[i].stackItem(cantidad);
                }
            }
        }
        return cantidad;
    }

    /**
     * Método to String de la clase Inventario.
     * @return
     */
    @Override
    public String toString(){
        String aux = "";
        for (int i = 0; i < inventario.length; i++) {
            aux += "Slot " + (i+1) + ": " + inventario[i].toString() + "\n";
        }
        return aux;
    }

    /**
     * Método que calcula el número de existencias que tiene del objeto
     * @param item Item a encontrar
     * @return número de existencias
     */
    public int numExistenciasItem(Item item) {
        int sum = 0;
        for (int i = 0; i < inventario.length; i++) {
            Slot s = inventario[i];
            if (s.getItem() != null && s.getItem().getClass().equals(item.getClass())) {
                sum += s.getStack();
            }
        }
        return sum;
    }

    /**
     * Método para eliminar Items del inventario
     * @param item Item a eliminar
     * @param cantidad cantidad de ese Item a eliminar
     */
    public void removeItem(Item item, int cantidad){
        int diferencia;
        for (int i = 0; i < inventario.length && cantidad > 0;i++){
            if(inventario[i].getItem().getClass().equals((item.getClass()))){
                diferencia = cantidad - inventario[i].getStack();
                if(diferencia >= 0){
                    cantidad -= inventario[i].getStack();
                    inventario[i].unstackItem(inventario[i].getStack());
               }else{
                    inventario[i].unstackItem(cantidad);
                    cantidad = 0;
               }
            }
        }
    }

}
