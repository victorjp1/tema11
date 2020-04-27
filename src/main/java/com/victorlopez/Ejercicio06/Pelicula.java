package com.victorlopez.Ejercicio06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pelicula extends Multimedia{
    private int minutosDuracion;
    private Actor actorPrincipal;
    private Actor actrizPrincipal;
    private final String FECHA_REBAJA = "01-01-2012";

    public Pelicula(int duracion,String titulo, Empresa autor, Formato formato, Actor actorPrincipal, Actor actrizPrincipal, LocalDate fechaEstreno) {
        super(titulo, autor, formato, fechaEstreno);
        this.minutosDuracion = duracion;
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
        this.precioFinal = precioFinal();
    }

    /**
     * Método para calcular el precio final del producto base, sin contar recargos
     * @return
     */
    public int precioFinal(){
        int precioFinal = PRECIO_BASE;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaLimite = LocalDate.parse(FECHA_REBAJA,fmt);
        if (fechaEstreno.isBefore(fechaLimite)){
            precioFinal -= 1;
        }
        return precioFinal;
    }

    /**
     * Método para obtener los minutos de duración
     * @return minutos de duracion
     */
    public int getMinutosDuracion() {
        return minutosDuracion;
    }

    /**
     * Método para obtener el Actor Principal
     * @return Actor principal (Actor)
     */
    public Actor getActorPrincipal() {
        return actorPrincipal;
    }

    /**
     * Método para obtener la Actriz Principal
     * @return Devolver la Actriz Principal
     */
    public Actor getActrizPrincipal() {
        return actrizPrincipal;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                "minutosDuracion=" + minutosDuracion +
                ", actorPrincipal=" + actorPrincipal +
                ", actrizPrincipal=" + actrizPrincipal +
                ", autor=" + autor +
                ", formato=" + formato +
                ", fechaEstreno=" + fechaEstreno +
                ", disponible=" + disponible +
                ", precioFinal=" + precioFinal +
                '}' + "\n";
    }
}
