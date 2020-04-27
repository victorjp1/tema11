package com.victorlopez.Ejercicio06;

import com.victorlopez.Lib;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static boolean validado;
    private static Scanner lector;
    private static VideoClub videoClub;
    public static void main(String[] args) {
        videoClub = new VideoClub();
        lector = new Scanner(System.in);
        boolean salir = false;
        do {
            int opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    gestionAltas();
                    break;
                case 2:
                    gestionAlquileres();
                    break;
                case 3:
                    consultas();
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }while (!salir);
    }

    /**
     * Método para la gestión de los alquileres
     */
    public static void gestionAlquileres(){
        boolean volver = false;
        do {
            int opcion = menuAlquileres();
            switch (opcion){
                case 1:
                    alquilarMultimedia();
                    break;
                case 2:
                    devolverMultimedia();
                    break;
                case 0:
                    volver = true;
                    break;
            }
        }while (!volver);
    }

    /**
     * Método para devolver un multimedia
     */
    public static void devolverMultimedia(){
        System.out.println("Datos del producto: ");
        int precio;
        int id = pedirId();
        boolean aceptaPrecio;
        Multimedia m =videoClub.buscarMultimediaId(id);
        if (m != null){
            precio = videoClub.consultarPrecioDevolucion(m);
            if (precio > 0){
                aceptaPrecio = consultarCliente(precio);
                if (aceptaPrecio){
                    videoClub.devolverMultimedia(m);
                    System.out.println("Alquiler devuelto correctamente");
                }else {
                    System.out.println("Se ha cancelado la devolución");
                }
            }else{
                System.out.println("No existe un alquiler pendiente con ese producto");
            }
        }else{
            System.out.println("No existe un producto con ese ID");
        }
    }

    /**
     * Método para consultar el precio
     * @param precio precio a consultar
     * @return true si acepta, false si no
     */
    public static boolean consultarCliente(int precio){
        char c;
        do {
            System.out.println("El precio total es de: " + precio);
            System.out.println("El cliente acepta el precio? [S/N]");
            c = lector.nextLine().toUpperCase().trim().charAt(0);
            if (c == 'S'){
                return true;
            }else if (c == 'N'){
                return false;
            }else{
                validado = false;
                System.out.println("Opción no válida");
            }
        }while (!validado);
        return false;
    }

    /**
     * Método para alquilar multimedia un producto
     */
    public static void alquilarMultimedia(){
        System.out.println("Introduce los datos del socio");
        String dni = pedirDni();
        Socio s = videoClub.buscarSocioDni(dni);
        int id;
        if (s != null){
            System.out.println("Vamos con los datos del producto");
            id = pedirId();
            Multimedia m = videoClub.buscarMultimediaId(id);
            if (m != null){
                if (m.isDisponible()){
                    try{
                        videoClub.alquilarMultimedia(m, s);
                        System.out.println("Alquilado correctamente.");
                        System.out.println("Dispones de 3 días para disfrutar nuestro producto.");
                    }catch (AlquilerPendienteException ape){
                        System.out.println(ape.getMessage());
                    }
                }else{
                    System.out.println("El producto no se encuentra disponible");
                }
            }else {
                System.out.println("No existe ningún multimedia con ese ID");
                System.out.println("Ve al apartado de consultas para encontrar el ID que buscas");
            }
        }else{
            System.out.println("No existe un socio con ese DNI");
            Lib.pausa();
            Lib.limpiarPantalla();
        }
    }

    /**
     * Menú de alquileres
     * @return opcion ya validada
     */
    public static int menuAlquileres(){
        int opcion = -1;
        do {
            try{
                System.out.println("*********************");
                System.out.println("** MENÚ ALQUILERES **");
                System.out.println("*********************");
                System.out.println("1. Alquilar Multimedia");
                System.out.println("2. Devolver Multimedia");
                System.out.println("----------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 2){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto!");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return opcion;
    }

    /**
     * Método para las consultas realizar las consultas
     */
    public static void consultas(){
        boolean volver = false;
        do {
            int opcion = menuConsultas();
            switch (opcion){
                case 1:
                    System.out.println(videoClub.getProductos().toString());
                    break;
                case 2:
                    ArrayList<Pelicula> peliculas = videoClub.getPeliculas();
                    Collections.sort(peliculas);
                    System.out.println(peliculas.toString());
                    break;
                case 3:
                    ArrayList<Videojuego> videojuegos = videoClub.getVideojuegos();
                    Collections.sort( videojuegos, new Multimedia.OrdenarPorAño());
                    System.out.println(videojuegos.toString());
                    break;
                case 4:
                    ArrayList<Alquiler> a1 = alquileresSocio();
                    if (a1 != null){
                        Collections.sort(a1);
                        System.out.println(a1.toString());
                    }
                    break;
                case 5:
                    Alquiler a = alquilerActualSocio();
                    if (a != null){
                        System.out.println(a.toString());
                    }else {
                        System.out.println("No tiene alquileres ahora mismo");
                    }
                    break;
                case 6:
                    ArrayList<Socio> s = videoClub.sociosConRecargo();
                    System.out.println(s.toString());
                    break;
                case 0:
                    volver = true;
                    System.out.println("Has elegido volver");
                    break;
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (!volver);
    }
    public static Alquiler alquilerActualSocio(){
        System.out.println("Datos del socio:");
        String dni = pedirDni();
        Socio s = videoClub.buscarSocioDni(dni);
        if (s == null){
            System.out.println("No existe un socio con ese DNI");
        }else{
            return videoClub.alquilerActualSocio(s);
        }
        return null;
    }
    /**
     * Método para imprimir los alquileres de un socio
     */
    public static ArrayList<Alquiler> alquileresSocio(){
        System.out.println("Datos del socio:");
        String dni = pedirDni();
        Socio s = videoClub.buscarSocioDni(dni);
        if (s == null){
            System.out.println("No existe un socio con ese DNI");
        }else{
            return videoClub.alquileresSocio(s);
        }
        return null;
    }
    /**
     * Método para el menú de consultas
     * @return devuelve la opcion ya validada
     */
    public static int menuConsultas(){
        int opcion = -1;
        do {
            try{
                System.out.println("***************");
                System.out.println("** Consultas **");
                System.out.println("***************");
                System.out.println("1. Todos los objetos Multimedia");
                System.out.println("2. Todas las películas ordenadas por título");
                System.out.println("3. Todos los videojuegos ordenados por año");
                System.out.println("4. Alquileres de un socio por año");
                System.out.println("5. Alquileres actuales de un socio");
                System.out.println("6. Socios con recargos pendientes");
                System.out.println("------------------------");
                System.out.println("0. Volver");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 6){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Formato incorrecto!!");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto!!");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return opcion;
    }

    /**
     * Metodo que gestiona las altas
     */
    public static void gestionAltas() {
        boolean volver = false;
        do {
            int opcion = menuAltas();
            switch (opcion) {
                case 1:
                    nuevaPelicula();
                    break;
                case 2:
                    nuevoVideojuego();
                    break;
                case 3:
                    nuevoSocio();
                case 0:
                    volver = true;
            }
        }while (!volver);
    }

    /**
     * Método para añadir un nuevo socio
     */
    public static void nuevoSocio(){
        LocalDate fechaNacimiento = pedirFechaNacimiento();
        if (getEdad(fechaNacimiento) < 18){
            System.out.println("No puede existir un socio menor de edad");
        }else{
            String dni = pedirDni();
            String nombre = pedirNombre();
            String apellidos = pedirApellidos();
            String poblacion = pedirPoblacion();
            videoClub.addSocio(dni, nombre, apellidos, fechaNacimiento, poblacion);
        }
    }

    /**
     * Método para obtener la edad de una fecha
     * @param fechaNacimiento fecha a valorar
     * @return años que han pasado
     */
    public static int getEdad(LocalDate fechaNacimiento){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        int a = periodo.getYears();
        return a;
    }

    /**
     * Método para pedir la poblacion al socio
     * @return devuelve la poblacion
     */
    public static String pedirPoblacion(){
        String poblacion;
        do {
            System.out.println("Introduce la población del socio:");
            poblacion = lector.nextLine();
            if (poblacion.length() >= 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("Debe tener mínimo 3 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return poblacion;
    }
    /**
     * Método para pedir los apellidos
     * @return apellidos ya validados y en minúsculas
     */
    public static String pedirApellidos(){
        String apellidos;
        do {
            System.out.println("Introduce los apellidos:");
            apellidos = lector.nextLine().trim().toLowerCase();
            if (apellidos.length() > 2){
                validado = true;
            }else{
                validado = false;
                System.out.println("Debe tener almenos 3 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return apellidos;
    }
    /**
     * Método para pedir el nombre del paciente
     * @return devuelve el nombre ya validado y en minúsculas
     */
    public static String pedirNombre(){
        String nombre;
        do {
            System.out.println("Introduce el nombre:");
            nombre = lector.nextLine().trim().toLowerCase();
            if (nombre.length() >= 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("El nombre debe tener mínimo 3 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return nombre;
    }

    /**
     * Método para pedir la fecha de nacimiento del paciente
     * @return devuelve la fecha ya validada
     */
    public static LocalDate pedirFechaNacimiento(){
        LocalDate fechaNacimiento = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            Lib.limpiarPantalla();
            System.out.println("Fecha de nacimiento (dd-mm-yyyy): ");
            String fechaNacimientoString = lector.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoString,fmt);
                validado = true;
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha de fabricación no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pausa();
            }
        } while (!validado);
        return fechaNacimiento;
    }

    /**
     * Método para añadir un videojuego
     */
    public static void nuevoVideojuego(){
        System.out.println("Empezamos con los datos del videojuego");
        String titulo = pedirTitulo();
        Empresa e = pedirEmpresa();
        Formato f = pedirFormato();
        LocalDate fechaEstreno = pedirFechaEstreno();
        Plataforma p = pedirPlataforma();
        videoClub.addVideojuego(titulo, e, f,fechaEstreno, p);
    }

    /**
     * Método para pedir la plataforma
     * @return devuelve la plataforma
     */
    public static Plataforma pedirPlataforma(){
        int id;
        Plataforma p = null;
        do {
            try {
                System.out.println("Introduce el ID de la plataforma");
                id = Integer.parseInt(lector.nextLine());
                p = videoClub.buscarPlataformaId(id);
                if (p == null){
                    validado = false;
                    System.out.println("No existe ninguna plataforma con ese ID");
                }else{
                    validado = true;
                    System.out.println("Plataforma encontrada");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto!!");
            }
        }while (!validado);
        return p;
    }

    /**
     * Método para añadir una nueva película.
     */
    public static void nuevaPelicula() {
        System.out.println("Vamos con los datos de la película:");
        String titulo = pedirTitulo();
        Empresa e = pedirEmpresa();
        Formato f = pedirFormato();
        Actor actorPrinc = pedirActorPrincipal();
        Actor actrizPrinc = pedirActrizPrincipal();
        LocalDate fechaEstreno = pedirFechaEstreno();
        int duracion = pedirDuracion();
        videoClub.addPelicula(duracion,titulo,e, f, actorPrinc, actrizPrinc, fechaEstreno);
    }

    /**
     * Método para pedir duración de la película
     * @return duración
     */
    public static int pedirDuracion(){
        int duracion = -1;
        do {
            try{
                System.out.println("Introduce la duración de la pelicula:");
                duracion = Integer.parseInt(lector.nextLine());
                if (duracion >= 1){
                    validado = true;
                }else {
                    validado = false;
                    System.out.println("Duración demasiado corta");
                    Lib.pausa();
                    Lib.limpiarPantalla();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return duracion;
    }

    /**
     * Método para pedir la actriz principal de la pelicula
     * @return actriz principal (Actor)
     */
    public static Actor pedirActrizPrincipal(){
        Actor a;
        System.out.println("Seguimos con la Actriz Principal:");
        do{
            String dni = pedirDni();
            a = videoClub.buscarActrizDNI(dni);
            if (a == null){
                validado = false;
                System.out.println("No existe ninguna Actriz con ese DNI");
            }else{
                validado = true;
                System.out.println("Actriz encontrada correctamente");
            }
        }while (!validado);
        return a;
    }

    /**
     * Método para pedir el Actor Principal
     * @return Actor principal (Actor)
     */
    public static Actor pedirActorPrincipal(){
        Actor a;
        System.out.println("Seguimos con el Actor Principal");
        do{
            String dni = pedirDni();
            a = videoClub.buscarActorDNI(dni);
            if (a == null){
                validado = false;
                System.out.println("No existe un actor con ese DNI");
            }else{
                validado = true;
                System.out.println("Actor encontrado correctamente");
            }
        }while (!validado);
        return a;
    }

    /**
     * Método para pedir el formato
     * @return Formato
     */
    public static Formato pedirFormato(){
        int opcion = menuFormato();
        switch (opcion){
            case 1:
                return Formato.CD;
            case 2:
                return Formato.DVD;
            case 3:
                return Formato.BLURAY;
            case 4:
                return Formato.ARCHIVO;
        }
        return null;
    }

    /**
     * Menú para elegir el formato
     * @return opcion ya validada
     */
    public static int menuFormato(){
        int opcion = -1;
        do {
            System.out.println("Elije el formato:");
            System.out.println("1. CD");
            System.out.println("2. DVD");
            System.out.println("3. BLU-RAY");
            System.out.println("4. ARCHIVO");
            try{
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 1 && opcion <= 4) {
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opcion incorrecta");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }

    /**
     * Método para pedir la empresa
     * @return Empresa
     */
    public static Empresa pedirEmpresa(){
        Empresa a;
        do {
            int id = pedirId();
            a = videoClub.buscarEmpresaId(id);
            if (a == null){
                validado = false;
                System.out.println("No existe una empresa con ese ID");
            }else{
                validado = true;
                System.out.println("Empresa encontrado");
            }
        }while (!validado);
        Lib.pausa();
        Lib.limpiarPantalla();
        return a;
    }

    /**
     * Método para pedir un ID
     * @return ID ya validado
     */
    public static int pedirId(){
        int id = -1;
        do {
            try{
                System.out.println("Introduce el ID:");
                id =Integer.parseInt(lector.nextLine());
                if (id > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Debe ser mayor que 0");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return id;
    }

    /**
     * Método para pedir el título
     * @return Título ya validado
     */
    public static String pedirTitulo(){
        String titulo;
        do {
            System.out.println("Introduce el título:");
            titulo = lector.nextLine();
            if (titulo.length() >= 3){
                validado = true;
            }else {
                validado = false;
                System.out.println("Debe tener mínimo 3 caracteres");
            }
        }while (!validado);
        return titulo;
    }

    /**
     * Menú de altas
     * @return opcion elegida ya validada
     */
    public static int menuAltas(){
        int opcion = -1;
        do {
            System.out.println("********************");
            System.out.println("**** Menú Altas ****");
            System.out.println("********************");
            System.out.println("1. Nueva Película");
            System.out.println("2. Nuevo Videojuego");
            System.out.println("3. Nuevo Socio");
            System.out.println("--------------------");
            System.out.println("0. Volver");
            try{
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 3){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Elija una opción del menú");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }

    /**
     * Menú principal de la App
     * @return opcion ya validada
     */
    public static int mostrarMenu(){
        int opcion = -1;
        do {
            System.out.println("********************");
            System.out.println("** Menú principal **");
            System.out.println("********************");
            System.out.println("1. Altas");
            System.out.println("2. Alquileres");
            System.out.println("3. Listados");
            System.out.println("--------------------");
            System.out.println("0. Salir");
            try{
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 3){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Elija una opción del menú");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }
    /**
    * Método para pedir el DNI
    * @return dni validado
    */
    public static String pedirDni(){
        String dni;
        do {
            System.out.println("Introduce el número de DNI: ");
            dni = lector.nextLine().toUpperCase().trim();
            try{
                if (compruebaNIF(dni)){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Letra incorrecta");
                    Lib.pausa();
                    Lib.limpiarPantalla();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Introduce un número de DNI correcto:");
                System.out.println("Ejemplo: 54375561L");
                Lib.pausa();
                Lib.limpiarPantalla();
            }

        }while (!validado);
        return dni;
        }

    /**
     * Método que comprueba si el NIF es correcto
     * @param nif nif a comprobar
     * @return boolean que dice si es correcto o no
     */
    public static boolean compruebaNIF(String nif) {
        StringBuilder dniString = new StringBuilder();
        // Cogemos como letra el último caracter del NIF
        char letra = nif.charAt(nif.length()-1);
        char c;
        for(int i = 0; i < nif.length(); i++) {
            // Si es un dígito lo añadimos a dniString
            c = nif.charAt(i);
            if(Character.isDigit(c)) {
                dniString.append(c);
            }
        }
        return letra == obtenerLetraDNI(Integer.parseInt(dniString.toString()));
    }

    /**
     * Obtener la letra correspondiente del dni
     * @param dni dni a valorar
     * @return letra correcta de deni
     */
    public static char obtenerLetraDNI(int dni) {
        String tabla = "TRWAGMYFPDXBNJZSQVHLCKE";
        return tabla.charAt(dni % 23);
    }
    /**
     * Método para pedir la fecha de estreno
     * @return devuelve la fecha ya validada
     */
    public static LocalDate pedirFechaEstreno(){
        LocalDate fechaEstreno = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            Lib.limpiarPantalla();
            System.out.println("Fecha de estreno (dd-mm-yyyy): ");
            String fechaNacimientoString = lector.nextLine();
            try {
                fechaEstreno = LocalDate.parse(fechaNacimientoString,fmt);
                validado = true;
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha de estreno no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pausa();
            }
        } while (!validado);
        return fechaEstreno;
    }
}



