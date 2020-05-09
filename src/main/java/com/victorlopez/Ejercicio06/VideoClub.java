package com.victorlopez.Ejercicio06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VideoClub {
    private ArrayList<Empresa> empresas;
    private ArrayList<Actor> actores;
    private ArrayList<Socio> socios;
    private ArrayList<Multimedia> productos;
    private ArrayList<Plataforma> plataformas;
    private ArrayList<Alquiler> alquileres;

    public VideoClub() {
        this.empresas = new ArrayList<>();
        this.actores = new ArrayList<>();
        this.socios = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.plataformas = new ArrayList<>();
        this.alquileres = new ArrayList<>();
        casosPrueba();
    }
    public Alquiler alquilerActualSocio(Socio s){
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getSocio().getDni().equals(s.getDni())){
                if (alquileres.get(i).getFechaDevolucion() == null){
                    return alquileres.get(i);
                }
            }
        }
        return null;
    }
    /**
     * Método para buscar un Socio por DNI
     * @param dni dni a buscar
     * @return socio en caso de encontrarlo o null
     */
    public Socio buscarSocioDni(String dni){
        for (int i = 0; i < socios.size(); i++) {
            Socio s = socios.get(i);
            if (s.getDni().equalsIgnoreCase(dni)){
                return s;
            }
        }
        return null;
    }

    /**
     * Método para alquilar un multimedia
     * @param m multimedia a alquilar
     * @param s socio que quiere alquilarlo
     * @return true si está disposible y se puede alquilar y false si no
     * @throws AlquilerPendienteException si el usuario tiene un alquiler no puede alquilar
     */
    public boolean alquilarMultimedia(Multimedia m, Socio s) throws AlquilerPendienteException {
        int i = 0;
        while (i < alquileres.size()){
            Alquiler a = alquileres.get(i);
            if (s.getDni().equalsIgnoreCase(a.getSocio().getDni())){
                if (a.getFechaDevolucion() == null){
                    throw new AlquilerPendienteException("Este cliente todavía tiene alquileres pendientes");
                }
            }
            i++;
        }
        if (m.isDisponible()){
            alquileres.add(new Alquiler(m, s, LocalDate.now()));
            m.setDisponible(false);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Método para devolver un objeto multimedia
     * @param m Multimedia a devolver
     * @return true si se ha podido devolver y false si no
     */
    public boolean devolverMultimedia(Multimedia m){
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getMultimedia().getId() == m.getId()){
                if (!alquileres.get(i).getMultimedia().isDisponible()){
                    alquileres.get(i).devolver(LocalDate.now());
                    m.setDisponible(true);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Método para consultar el precio de devolucion del producto
     * @param m multimedia a consultar precio
     * @return precio
     */
    public int consultarPrecioDevolucion(Multimedia m){
        int precio = -1;
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getMultimedia().getId() == m.getId()){
                precio = alquileres.get(i).precioFinal(LocalDate.now());
            }
        }
        return precio;
    }
    /**
     * Método que busca un multimedia por ID
     * @param id id del multimedia
     * @return devuelve null o el objeto encontrado
     */
    public Multimedia buscarMultimediaId(int id){
        for (int i = 0; i < productos.size(); i++) {
            Multimedia m = productos.get(i);
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }
    public ArrayList<Socio> sociosConRecargo(){
        ArrayList<Socio> s = new ArrayList<>();
        for (int i = 0; i < alquileres.size(); i++) {
            Alquiler a = alquileres.get(i);
            if (a.getFechaDevolucion() == null){
                s.add(a.getSocio());
            }
        }
        return s;
    }
    /**
     * Método para obtener los alquileres de un socio
     * @param s socio a valorar
     * @return ArrayList de Socio
     */
    public ArrayList<Alquiler> alquileresSocio(Socio s){
        ArrayList<Alquiler> encontrados = new ArrayList<>();
        for (int i = 0; i < alquileres.size(); i++) {
            Socio s2 = alquileres.get(i).getSocio();
            if (s.getDni().equalsIgnoreCase(s2.getDni())){
                encontrados.add(alquileres.get(i));
            }
        }
        return encontrados;
    }
    /**
     * Casos de prueba
     */
    private void casosPrueba(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate f1 = LocalDate.parse("15-12-2000",fmt);
        LocalDate f2 = LocalDate.parse("01-04-1971",fmt);
        LocalDate f3 = LocalDate.parse("06-03-1985",fmt);
        LocalDate f4 = LocalDate.parse("26-08-1978",fmt);
        LocalDate f5 = LocalDate.parse("26-10-2010",fmt);
        LocalDate f6 = LocalDate.parse("18-11-2013",fmt);
        LocalDate f7 = LocalDate.parse("18-04-2020",fmt);
        LocalDate f8 = LocalDate.parse("20-04-2020",fmt);
        LocalDate f9 = LocalDate.parse("02-04-2019",fmt);
        LocalDate f10 = LocalDate.parse("20-04-2020",fmt);
        plataformas.add(new Plataforma("Play Store", "Google"));
        plataformas.add(new Plataforma("Play Station Store", "Sony"));
        plataformas.add(new Plataforma("Apple Store", "Apple Inc."));
        empresas.add(new Empresa("Sony Pictures", "sony@enterprise.com"));
        empresas.add(new Empresa("Google", "google@gmail.com"));
        empresas.add(new Empresa("Apple", "apple@apple.inc"));
        actores.add(new Actor("53944153E","Jairo", "Salvá", f3, Sexo.HOMBRE));
        actores.add(new Actor("28994850S","María", "Pérez", f2, Sexo.MUJER));
        actores.add(new Actor("28992702Y","Juana", "Tortilla", f1, Sexo.MUJER));
        actores.add(new Actor("54375926Q","Mario", "Fornés", f4, Sexo.HOMBRE));
        productos.add(new Pelicula(120,"One piece", empresas.get(0), Formato.DVD, actores.get(0),actores.get(1), f5));
        productos.add(new Pelicula(90,"Boku no hero academia", empresas.get(1), Formato.CD, actores.get(3),actores.get(2), f6));
        productos.add(new Videojuego("Clash Royale", empresas.get(2), Formato.ARCHIVO, f6, plataformas.get(2)));
        productos.add(new Videojuego("Call of Duty", empresas.get(0), Formato.CD, f5, plataformas.get(1)));
        productos.add(new Videojuego("Merda a l'ull", empresas.get(1), Formato.DVD, f1, plataformas.get(0)));
        socios.add(new Socio("54375561L","Victor","lópez",f2,"Jesus Pobre"));
        socios.add(new Socio("21305008Q", "Antonio", "Fornés", f2, "Valencia"));
        socios.add(new Socio("28992702Y", "Paco", "Reig", f1, "Gata de Gorgos"));
        alquileres.add(new Alquiler(productos.get(2),socios.get(0), f7));
        alquileres.get(0).devolver(f8);
        alquileres.add(new Alquiler(productos.get(1),socios.get(1), f7));
        alquileres.get(1).devolver(f8);
        alquileres.add(new Alquiler(productos.get(0),socios.get(0), f9));
        alquileres.get(2).devolver(f10);
        alquileres.add(new Alquiler(productos.get(2), socios.get(0), f10));
        alquileres.add(new Alquiler(productos.get(1), socios.get(1), f10));
    }

    /**
     * Método para obtener todas las películas
     * @return ArrayList de Películas
     */
    public ArrayList<Pelicula> getPeliculas(){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Pelicula){
                peliculas.add((Pelicula)productos.get(i));
            }
        }
        return peliculas;
    }

    /**
     * Método para obtener videojuegos
     * @return ArrayList de videojuegos
     */
    public ArrayList<Videojuego> getVideojuegos(){
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Videojuego){
                videojuegos.add((Videojuego)productos.get(i));
            }
        }
        return videojuegos;
    }

    /**
     * Método para obtener los autores, emresas
     * @return ArrayList de Empresa
     */
    public ArrayList<Empresa> getAutores() {
        return empresas;
    }

    /**
     * Método para obtener los actores
     * @return ArrayList de actores
     */
    public ArrayList<Actor> getActores() {
        return actores;
    }
    /**
     * Método para obtener los socios
     * @return ArrayList de socios
     */
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    /**
     * Método para obtener todos los productos
     * @return ArrayList de Multimedia
     */
    public ArrayList<Multimedia> getProductos() {
        return productos;
    }
    /**
     * Método para obtener las plataformas
     * @return ArrayList de Plataforma
     */
    public ArrayList<Plataforma> getPlataformas() {
        return plataformas;
    }

    /**
     * Método para añadir un nuevo socio
     * @param dni dni del socio
     * @param nombre nombre del socio
     * @param apellidos apellidos del socio
     * @param fechaNacimiento fecha de nacimiento
     * @param poblacion poblacion en la que reside
     */
    public void addSocio(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String poblacion){
        socios.add(new Socio(dni, nombre, apellidos, fechaNacimiento, poblacion));
    }

    /**
     * Método que busca plataformas por ID
     * @param id id a buscar
     * @return Plataforma si es encontrada o null
     */
    public Plataforma buscarPlataformaId(int id){
        for (int i = 0; i < plataformas.size(); i++) {
            if (id == plataformas.get(i).getId()){
                return plataformas.get(i);
            }
        }
        return null;
    }

    /**
     * Método para buscar ActrizDNI
     * @param dni dni a buscar
     * @return Actor si es encontrada o null
     */
    public Actor buscarActrizDNI(String dni){
        for (int i = 0; i < actores.size(); i++) {
            if (actores.get(i).getDni().equals(dni)){
                if (actores.get(i).getSexo() == Sexo.MUJER){
                    return actores.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Método para buscar actor por DNI
     * @param dni dni a buscar
     * @return Actor si es encontrado o null
     */
    public Actor buscarActorDNI(String dni){
        for (int i = 0; i < actores.size(); i++) {
            if (actores.get(i).getDni().equals(dni)){
                if (actores.get(i).getSexo() == Sexo.HOMBRE){
                    return actores.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Método para buscar empresa por ID
     * @param id id a buscar
     * @return Empresa si es encontrado o Null
     */
    public Empresa buscarEmpresaId(int id){
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == id){
                return empresas.get(i);
            }
        }
        return null;
    }

    /**
     * Método para añadir un Videojuego
     * @param titulo título
     * @param e Empresa creadora
     * @param f Formato del videojuego
     * @param fechaEstreno fecha estreno
     * @param plataforma plataforma en la que se encuentra
     */
    public void addVideojuego(String titulo, Empresa e, Formato f,LocalDate fechaEstreno, Plataforma plataforma){
        productos.add(new Videojuego(titulo, e, f,fechaEstreno, plataforma));
    }

    /**
     * Método para añadir una nueva película
     * @param duracion duracion de la pelicula
     * @param titulo titulo
     * @param e empresa que la ha producido
     * @param formato formato en la que se encuentra
     * @param actorPrincipal actor principal
     * @param actrizPrincipal actriz principal
     * @param fechaEstreno fecha de estreno de la película
     */
    public void addPelicula(int duracion, String titulo, Empresa e, Formato formato, Actor actorPrincipal, Actor actrizPrincipal, LocalDate fechaEstreno){
        productos.add(new Pelicula(duracion,titulo, e, formato, actorPrincipal, actrizPrincipal, fechaEstreno));
    }

}
