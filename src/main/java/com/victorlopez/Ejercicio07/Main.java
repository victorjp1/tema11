package com.victorlopez.Ejercicio07;

import com.victorlopez.Lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static Club club;
    private static boolean validado;
    private static Scanner lector;
    public static void main(String[] args) {
        boolean salir = false;
        lector = new Scanner(System.in);
        club = new Club();
        do {
            int opcion = menuPrincipal();
            switch (opcion){
                case 1:
                    nuevoPartido();//Método para añadir un nuevo partido
                    break;
                case 2:
                    gestionEntradas();//Método para la gestión de entradas de un partido
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }while (!salir);
    }

    /**
     * Método para introducir un nuevo partido
     */
    private static void nuevoPartido(){
        LocalDate fechaPartido = pedirFecha();
        Afluencia a = pedirAfluencia();
        System.out.println("Empezamos con el equipo local:");
        String local = pedirNombreEquipo();
        System.out.println("Seguimos con el equipo visitante:");
        String visitante = pedirNombreEquipo();
        club.addPartido(a, fechaPartido, visitante, local);
    }

    /**
     * Método para pedir el nombre del equipo
     * @return nombre ya validado
     */
    private static String pedirNombreEquipo(){
        String nombre;
        do {
            System.out.println("Introduce el nombre del equipo: ");
            nombre = lector.nextLine();
            if (nombre.length() > 2){
                validado = true;
            }else{
                validado = false;
                System.out.println("Demasiado corto");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return nombre;
    }

    /**
     * Método para pedir la afluencia
     * @return devuelve la Afluencia elegida
     */
    private static Afluencia pedirAfluencia(){
        int opcion = menuAfluencia();
        switch (opcion){
            case 1:
                return Afluencia.ALTA_AFLUENCIA;
            case 2:
                return Afluencia.MEDIA_AFLUENCIA;
            case 3:
                return Afluencia.BAJA_AFLUENCIA;
        }
        return null;
    }

    /**
     * Método para mostrar el menú de afluencias
     * @return devuelve la opción ya validada
     */
    private static int menuAfluencia(){
        int opcion = -1;
        do {
            try {
                System.out.println("********************");
                System.out.println("** Menú afluencia **");
                System.out.println("********************");
                System.out.println("1. Alta afluencia");
                System.out.println("2. Media afluencia");
                System.out.println("3. Baja afluencia");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 1 && opcion <= 3){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opcion incorrecta");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return opcion;
    }
    /**
     * Método para pedir una fecha
     * @return devuelve la fecha ya validada
     */
    public static LocalDate pedirFecha(){
        LocalDate fecha = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            Lib.limpiarPantalla();
            System.out.println("Introduce la fecha (dd-mm-yyyy): ");
            String fechaString = lector.nextLine();
            try {
                fecha = LocalDate.parse(fechaString,fmt);
                if (fecha.isAfter(LocalDate.now())){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("No puedes añadir un partido que ya se ha jugado");
                    Lib.pausa();
                }
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        } while (!validado);
        return fecha;
    }

    /**
     * Método para la gestión de entradas de un partido
     */
    private static void gestionEntradas(){
        Partido p = elegirPartido();
        boolean volver = false;
        do {
            int opcion = menuGestionEntradas();
            switch (opcion){
                case 1:
                    venderEntrada(p);
                    break;
                case 2:
                    devolucionEntradas(p);
                    break;
                case 3:
                    localidades(p, true);
                    break;
                case 4:
                    localidades(p, false);
                    break;
                case 5:
                    recaudacionPartido(p);
                    break;
                case 6:
                    System.out.println("En este partido se han vendido " + p.getEntradas().size() + " entradas");
                    break;
                case 0:
                    volver = true;
                    break;
            }
        }while (!volver);
    }

    /**
     * Método para mostrar localidades, ocupadas o libres
     * @param p partido a valorar
     * @param ocupado si es true, mostrara los ocupados, si es false los libres
     */
    private static void localidades(Partido p, boolean ocupado){
        Estadio e = p.getEstadio();
        for (int i = 0; i < e.getZonas().size(); i++) {
            System.out.println("Zona " + (i+1));
            for (int j = 0; j < e.getZonas().get(i).getFilas().size(); j++) {
                System.out.println("Fila " + (j+1));
                for (int k = 0; k < e.getZonas().get(i).getFilas().get(j).getAsientos().size(); k++) {
                    Asiento a = e.getZonas().get(i).getFilas().get(j).getAsientos().get(k);
                    if (a.isOcupado() == ocupado){
                        System.out.println("Asiento " + (k+1));
                        a.toString();
                    }
                }
            }
        }
    }

    /**
     * Método para hacer devoluciones de entradas
     * @param p partido a valorar
     */
    private static boolean devolucionEntradas(Partido p){
        System.out.println("Vamos con los datos de la entrada:");
        int id = pedirId();
        Entrada e = p.eliminarEntrada(id);
        if (e == null){
            System.out.println("No existe una entrada con ese ID");
            validado = false;
        }else{
            System.out.println("Eliminada correctamente");
            validado = true;
        }
        Lib.pausa();
        Lib.limpiarPantalla();
        return validado;
    }

    /**
     * Método para pedir un ID
     * @return ID validado (por encima de 0)
     */
    private static int pedirId(){
        int id = -1;
        do {
            try {
                System.out.println("Introduce el ID:");
                id = Integer.parseInt(lector.nextLine());
                if (id < 0){
                    validado = false;
                    System.out.println("No existen IDs negativos");
                }else{
                    validado = true;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return id;
    }

    /**
     * Método para buscar la recaudación de un partido
     * @param p partido a valorar
     */
    private static void recaudacionPartido(Partido p){
        double recaudacion;
        recaudacion = p.getRecaudacion();
        System.out.println("En este partido se han recolectado: " + recaudacion + " €");
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para vender entradas
     * @param p partido sobre el cual vendemos la entrada
     */
    private static void venderEntrada(Partido p){
        Zona zona = pedirZona(p.getEstadio());
        Fila fila = pedirFila(zona);
        Asiento asiento = pedirAsiento(fila);
        Entrada e = p.addEntrada(zona, fila, asiento);
        if (e == null){
            System.out.println("El asiento se encuentra ocupado");
        }else{
            System.out.println(e.toString());
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para pedir un asiento específico de una fila
     * @param f fila a valorar
     * @return Asiento elegido
     */
    private static Asiento pedirAsiento(Fila f){
        int id;
        Asiento a = null;
        do {
            try {
                System.out.println(f.getAsientos().toString());
                System.out.println("Introduce el ID del asiento: ");
                id = Integer.parseInt(lector.nextLine());
                a = f.buscarAsientoId(id);
                if (a != null){
                    validado = true;
                    System.out.println("Asiento elegido correctamente");
                }else{
                    System.out.println("No existe un asiento con ese ID");
                    validado = false;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (!validado);
        return a;
    }

    /**
     * Método para pedir la fila
     * @param z zona en la que se encuentra
     * @return Fila elegida
     */
    private static Fila pedirFila(Zona z){
        int id;
        Fila f = null;
        do {
            try {
                System.out.println(z.getFilas().toString());
                System.out.println("Introduce el ID de la fila: ");
                id = Integer.parseInt(lector.nextLine());
                f = z.buscarFilaId(id);
                if (z != null){
                    validado = true;
                    System.out.println("Fila elegida correctamente");
                }else{
                    System.out.println("No existe una fila con ese ID");
                    validado = false;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (!validado);
        return f;
    }

    /**
     * Método para pedir la zona
     * @param e estadio a elegir la zona
     * @return Zona elegida
     */
    private static Zona pedirZona(Estadio e){
        int id;
        Zona z = null;
        do {
            try{
                System.out.println(e.getZonas().toString());
                System.out.println("Introduce el ID de la zona:");
                id = Integer.parseInt(lector.nextLine());
                z = e.buscarZonaId(id);
                if (z == null){
                    System.out.println("No existe una zona con ese ID");
                    validado = false;
                }else{
                    System.out.println("Zona seleccionada correctamente");
                    validado = true;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (!validado);
        return z;
    }

    /**
     * Método para elegir un Partido
     * @return Partido elegido
     */
    private static Partido elegirPartido(){
        int id;
        Partido p = null;
        ArrayList<Partido> partidos = club.getPartidosNoJugados();
        Collections.sort(partidos);
        do {
            try{
                System.out.println("Elige un partido:");
                System.out.println(partidos.toString());
                System.out.println("Introduce el ID del partido:");
                id = Integer.parseInt(lector.nextLine());
                p = club.buscarPartidoId(id);
                if (p == null){
                    System.out.println("No existe ningún partido con ese ID");
                    validado = false;
                }else{
                    validado = true;
                    System.out.println("Partido elegido correctamente");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (!validado);
        return p;
    }

    /**
     * Método para el menú de gestión de entradas
     * @return eleccion ya validada
     */
    private static int menuGestionEntradas(){
        int opcion = -1;
        do {
            try{
                System.out.println("********************");
                System.out.println("** Gestión entradas **");
                System.out.println("********************");
                System.out.println("1. Venta de entradas");
                System.out.println("2. Devolver una entrada");
                System.out.println("3. Listado de localidades ocupadas");
                System.out.println("4. Listado de localidades libres");
                System.out.println("5. Mostrar recaudación del partido");
                System.out.println("6. Mostrar número entradas vendidas");
                System.out.println("--------------------------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion <= 6 && opcion >= 0){
                    validado = true;
                }else{
                    System.out.println("Opción incorrecta");
                    validado = false;
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return opcion;
    }

    /**
     * Método que muestra el menú principal de la app
     * @return eleccion ya validada
     */
    private static int menuPrincipal(){
        int opcion = -1;
        do {
            try{
                System.out.println("********************");
                System.out.println("** Gestión entradas **");
                System.out.println("********************");
                System.out.println("1. Nuevo partido");
                System.out.println("2. Gestión de entradas");
                System.out.println("------------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion <= 2 && opcion >= 0){
                    validado = true;
                }else{
                    System.out.println("Opción incorrecta");
                    validado = false;
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return opcion;
    }
}
