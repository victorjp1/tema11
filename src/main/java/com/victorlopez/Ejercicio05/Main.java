package com.victorlopez.Ejercicio05;

import com.victorlopez.Lib;
import java.util.Scanner;

public class Main {
    static boolean validado;
    static Scanner lector;
    static Inventario inventario;
    public static void main(String[] args) {
        int opcion;
        lector = new Scanner(System.in);
        inventario = new Inventario();
        boolean salir = false;
        casosPrueba();
        do{
            opcion=menu();
            switch (opcion){
                case 1://Opción para añadir un Item al menú
                    int sobrante = addItem();
                    imprimirSobrante(sobrante);
                    break;
                case 2://Opción para borrar un Item del menú
                    removeItem();
                    break;
                case 3://Opción para mostrar el inventario
                    System.out.println(inventario.toString());
                    Lib.pausa();
                    break;
                case 0:
                    salir = true;
                    break;
            }

        }while(!salir);
    }

    /**
     * Items añadidos para casos de prueba
     */
    public static void casosPrueba(){
        inventario.addItem(new Espada(), 1);
        inventario.addItem(new Madera(), 66);
        inventario.addItem(new EnderPearl(), 25);
        inventario.addItem(new Espada(), 1);
    }
    /**
     * Método para imprimir el sobrante al añadir
     * @param sobrante sobrante al añadir
     */
    public static void imprimirSobrante(int sobrante){
        if(sobrante > 0) {
            System.out.println("Han sobrado " + sobrante);
        }else {
            System.out.println("Items añadidos correctamente.");
        }
        Lib.pausa();
    }

    /**
     * Método que muestra el menú principal de la App
     * @return opciṕn ya validada
     */
    public static int menu(){
        int opcion = -1;
        do {
            System.out.println("Elije una opción:");
            System.out.println("---------------------");
            System.out.println("1. Añadir objetos");
            System.out.println("2. Borrar objetos");
            System.out.println("3. Mostrar inventario");
            System.out.println("---------------------");
            System.out.println("0. Salir");

            try{
                opcion= Integer.parseInt(lector.nextLine());
                if(opcion >= 0 && opcion <= 3){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción fuera de rango");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();

            }
        }while (!validado);
        return opcion;
    }

    /**
     * Método para añadir items al inventario
     * @return Cantidad que no se ha podido incluir en el inventario
     */
    public static int addItem(){
        int opcion = menuItems();
        Item item=valorarItem(opcion);
           if(item!=null) {
               int cantidad;
               do {
                   System.out.println("Introduce la cantidad a añadir:");
                   try {
                       cantidad = Integer.parseInt(lector.nextLine());
                       if (cantidad >= 1){
                           validado = true;
                       }else {
                           validado = false;
                           System.out.println("No puedes añadir un número negativo de Items");
                           Lib.pausa();
                       }
                   } catch (NumberFormatException nfe) {
                       System.out.println("Formato incorrecto");
                       validado = false;
                       cantidad = 0;
                       Lib.pausa();
                   }
               } while (!validado);
               return inventario.addItem(item, cantidad);
           }
           return 0;
    }

    /**
     * Método para borrar un Item del inventario
     */
    public static void removeItem(){
        int total;
        Item item;
        int cantidad;
        int opcion;
        System.out.println("Que objeto deseas borrar?");
        opcion = menuItems();
        item = valorarItem(opcion);
        if(item != null) {
            total = inventario.numExistenciasItem(item);
            if (total <= 0) {
                System.out.println("No tienes objetos de este tipo disponibles");
            }else{
                System.out.println("Tienes " + total + " objetos disponibles");
                do {
                    System.out.println("Introduce la cantidad de objetos que desea borrar");
                    try {
                        cantidad = Integer.parseInt(lector.nextLine());
                        validado = true;
                        if(cantidad < total){
                            inventario.removeItem(item,cantidad);
                        }else{
                            inventario.removeItem(item,total);
                            System.out.println("Se han borrado todas las existencias de este Item");
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorrecto");
                        validado = false;
                    }
                }while(!validado);
            }
        }
    }

    /**
     * Método para elegir un Item
     * @param opcion opción previamente elegida en un menú
     * @return Item elegido, si el user ha elegido salir en el menu devuelve null
     */
    public static Item valorarItem(int opcion){
        switch (opcion){
            case 1:
                return new Pico();
            case 2:
                return new Espada();
            case 3:
                return new Hacha();
            case 4:
                return new Madera();
            case 5:
                return new Piedra();
            case 6:
                return new Huevo();
            case 7:
                return new EnderPearl();
            default:
                return null;
        }
    }

    /**
     * Menú para elegir Items
     * @return devolvemos la opcion elegida ya validada
     */
    public static int menuItems() {
        int opcion = -1;
        do {
            System.out.println("Elije un item");
            System.out.println("1. Pico");
            System.out.println("2. Espada");
            System.out.println("3. Hacha");
            System.out.println("4. Madera");
            System.out.println("5. Piedra");
            System.out.println("6. Huevo");
            System.out.println("7. Piedra de Ender");
            System.out.println("----------------------------");
            System.out.println("0. Volver al menú principal");

            try {
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 7) {
                    validado = true;
                } else {
                    validado = false;
                    System.out.println("Opción incorrecta!");
                    Lib.pausa();
                }
            } catch (NumberFormatException nfe) {
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
        } while (!validado);
        return opcion;
    }
}
