package com.victorlopez.Ejercicio06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Videojuego extends Multimedia{
    private Plataforma plataforma;
    private final String FECHA_REBAJA = "01-01-2010";
    public Videojuego(String titulo, Empresa autor, Formato formato, LocalDate fechaEstreno, Plataforma plataforma) {
        super(titulo, autor, formato, fechaEstreno);
        this.plataforma = plataforma;
        precioFinal = precioFinal();
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public int precioFinal(){
        int precioFinal = PRECIO_BASE;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaLimite = LocalDate.parse(FECHA_REBAJA,fmt);
        if (fechaEstreno.isBefore(fechaLimite)){
            precioFinal -= 1;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", formato=" + formato +
                ", fechaEstreno=" + fechaEstreno +
                ", disponible=" + disponible +
                "plataforma=" + plataforma +
                ", precioFinal=" + precioFinal +
                '}';
    }
}
