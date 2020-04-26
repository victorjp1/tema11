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
    public Socio buscarSocioDni(String dni){
        for (int i = 0; i < socios.size(); i++) {
            Socio s = socios.get(i);
            if (s.getDni().equalsIgnoreCase(dni)){
                return s;
            }
        }
        return null;
    }

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
    public Multimedia buscarMultimediaId(int id){
        for (int i = 0; i < productos.size(); i++) {
            Multimedia m = productos.get(i);
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }
    public void casosPrueba(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate f1 = LocalDate.parse("15-12-2000",fmt);
        LocalDate f2 = LocalDate.parse("01-04-1971",fmt);
        LocalDate f3 = LocalDate.parse("06-03-1985",fmt);
        LocalDate f4 = LocalDate.parse("26-08-1978",fmt);
        LocalDate f5 = LocalDate.parse("26-10-2010",fmt);
        LocalDate f6 = LocalDate.parse("18-11-2013",fmt);
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
        productos.add(new Videojuego("Merda a l'ull", empresas.get(1), Formato.DVD, f5, plataformas.get(0)));
        socios.add(new Socio("54375561L","Victor","lópez",f2,"Jesus Pobre"));
        socios.add(new Socio("21305008Q", "Antonio", "Fornés", f2, "Valencia"));
        socios.add(new Socio("28992702Y", "Paco", "Reig", f1, "Gata de Gorgos"));
    }
    public ArrayList<Pelicula> getPeliculas(){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Pelicula){
                peliculas.add((Pelicula)productos.get(i));
            }
        }
        return peliculas;
    }
    public ArrayList<Videojuego> getVideojuegos(){
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Videojuego){
                videojuegos.add((Videojuego)productos.get(i));
            }
        }
        return videojuegos;
    }
    public ArrayList<Empresa> getAutores() {
        return empresas;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public ArrayList<Multimedia> getProductos() {
        return productos;
    }

    public ArrayList<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void addSocio(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String poblacion){
        socios.add(new Socio(dni, nombre, apellidos, fechaNacimiento, poblacion));
    }
    public Plataforma buscarPlataformaId(int id){
        for (int i = 0; i < plataformas.size(); i++) {
            if (id == plataformas.get(i).getId()){
                return plataformas.get(i);
            }
        }
        return null;
    }
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
    public Empresa buscarEmpresaId(int id){
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == id){
                return empresas.get(i);
            }
        }
        return null;
    }
    public void addVideojuego(String titulo, Empresa e, Formato f,LocalDate fechaEstreno, Plataforma plataforma){
        productos.add(new Videojuego(titulo, e, f,fechaEstreno, plataforma));
    }
    public void addPelicula(int duracion, String titulo, Empresa e, Formato formato, Actor actorPrincipal, Actor actrizPrincipal, LocalDate fechaEstreno){
        productos.add(new Pelicula(duracion,titulo, e, formato, actorPrincipal, actrizPrincipal, fechaEstreno));
    }
}
