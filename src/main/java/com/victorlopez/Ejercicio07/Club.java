package com.victorlopez.Ejercicio07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Club {
    private ArrayList<Partido> partidos;
    ArrayList<Jugador> jugadores;
    private Estadio estadio;

    /**
     * Constructor de Club
     * @param estadio Estadio del club
     */
    public Club(Estadio estadio) {
        this.estadio = estadio;
        partidos = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    /**
     * Constructor Club
     * @param jugadores jugadores del club
     * @param estadio estadio del club
     */
    public Club(ArrayList<Jugador> jugadores, Estadio estadio) {
        this.jugadores = jugadores;
        this.estadio = estadio;
    }

    /**
     * Constructor Club, se creará un estadio por defecto, junto con partidos y entradas
     */
    public Club() {
        this.estadio = estadioDefault();
        partidos = new ArrayList<>();
        jugadores = new ArrayList<>();
        casosPrueba();
    }

    /**
     * Método para crear partidos y entradas de prueba
     */
    private void casosPrueba(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("15-12-2020", fmt);
        LocalDate date2 = LocalDate.parse("05-08-2021", fmt);
        LocalDate date3 = LocalDate.parse("08-10-2020", fmt);
        LocalDate date4 = LocalDate.parse("06-09-2022", fmt);
        partidos.add(new Partido(new Estadio (this.estadio), Afluencia.ALTA_AFLUENCIA, date, "Victor", "Tallarina"));
        partidos.add(new Partido(new Estadio (this.estadio), Afluencia.ALTA_AFLUENCIA, date2, "Barcelona", "Real Madrid"));
        partidos.add(new Partido(new Estadio (this.estadio), Afluencia.BAJA_AFLUENCIA, date3, "Villareal", "Real Madrid"));
        partidos.add(new Partido(new Estadio (this.estadio), Afluencia.MEDIA_AFLUENCIA, date4, "Atletico de Madrid", "Real Maddrid"));
        //Casos de prueba primer partido
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0).getAsientos().get(0));
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(1), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(1), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(1).getAsientos().get(1));
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(1), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(2), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(2).getAsientos().get(2));
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(3), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4).getAsientos().get(6));
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(3), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4).getAsientos().get(6));
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(3), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4).getAsientos().get(6));
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(1), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(1).getAsientos().get(6));
        partidos.get(0).addEntrada(partidos.get(0).getEstadio().getZonas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(3), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(2).getAsientos().get(4));
       //Casos de prueba segundo partido
        partidos.get(1).addEntrada(partidos.get(0).getEstadio().getZonas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0).getAsientos().get(0));
        partidos.get(1).addEntrada(partidos.get(0).getEstadio().getZonas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(1), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(1).getAsientos().get(1));
        partidos.get(1).addEntrada(partidos.get(0).getEstadio().getZonas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(2).getAsientos().get(2));
        partidos.get(1).addEntrada(partidos.get(0).getEstadio().getZonas().get(3), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4).getAsientos().get(6));
        //Casos de prueba tercer partido
        partidos.get(2).addEntrada(partidos.get(0).getEstadio().getZonas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0).getAsientos().get(0));
        partidos.get(2).addEntrada(partidos.get(0).getEstadio().getZonas().get(1), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(1), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(1).getAsientos().get(1));
        partidos.get(2).addEntrada(partidos.get(0).getEstadio().getZonas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(2).getAsientos().get(2));
        partidos.get(2).addEntrada(partidos.get(0).getEstadio().getZonas().get(3), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4).getAsientos().get(6));
        //Casos de prueba cuarto partido
        partidos.get(3).addEntrada(partidos.get(0).getEstadio().getZonas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0), partidos.get(0).getEstadio().getZonas().get(0).getFilas().get(0).getAsientos().get(0));
        partidos.get(3).addEntrada(partidos.get(0).getEstadio().getZonas().get(1), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(1), partidos.get(0).getEstadio().getZonas().get(1).getFilas().get(1).getAsientos().get(1));
        partidos.get(3).addEntrada(partidos.get(0).getEstadio().getZonas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(2), partidos.get(0).getEstadio().getZonas().get(2).getFilas().get(2).getAsientos().get(2));
        partidos.get(3).addEntrada(partidos.get(0).getEstadio().getZonas().get(3), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4).getAsientos().get(6));
        partidos.get(3).addEntrada(partidos.get(0).getEstadio().getZonas().get(3), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4), partidos.get(0).getEstadio().getZonas().get(3).getFilas().get(4).getAsientos().get(6));
    }
    /**
     * Método para crear un estadio por defecto
     * @return Estadio creado
     */
    private Estadio estadioDefault(){
        Estadio e = new Estadio("Santiago Bernabeu", 500, TipoCesped.NATURAL);
        e.addZona(TipoZona.ESTANDARD);
        e.addZona(TipoZona.ESTANDARD);
        e.addZona(TipoZona.ESTANDARD);
        e.addZona(TipoZona.VIP);
        return e;
    }

    /**
     * Método para añadir un nuevo jugador
     * @param dni dni del jugador
     * @param posiciones posiciones en las que sabe jugar
     * @param dorsal dorsal del jugador
     */
    public void addJugador(String dni, ArrayList<String> posiciones, int dorsal){
        jugadores.add(new Jugador(dni, posiciones, dorsal));
    }

    /**
     * Método para añadir un nuevo partido
     * @param afluencia afluencia del partido
     * @param fecha fecha del partido
     * @param visitante equipo visitante
     * @param local equipo local
     */
    public void addPartido(Afluencia afluencia, LocalDate fecha, String visitante, String local ){
        partidos.add(new Partido(new Estadio(estadio), afluencia, fecha, visitante, local));
    }
    public Partido buscarPartidoId(int id){
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getId() == id){
                return partidos.get(i);
            }
        }
        return null;
    }
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /**
     * Método para obtener todos los partidos que no se han jugado
     * @return ArrayList de Partido con los partidos no jugados
     */
    public ArrayList<Partido> getPartidosNoJugados(){
        ArrayList<Partido> p = new ArrayList<>();
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getFecha().isAfter(LocalDate.now())){
                p.add(partidos.get(i));
            }
        }
        return p;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    @Override
    public String toString() {
        return "Club {" +
                "Partidos = " + partidos.toString() +
                ", Jugadores=" + jugadores.toString() +
                ", Estadio=" + estadio.toString() +
                '}';
    }
}
