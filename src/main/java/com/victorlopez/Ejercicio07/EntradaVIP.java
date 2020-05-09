package com.victorlopez.Ejercicio07;

public class EntradaVIP extends Entrada{
    private static final int PRECIO_BASE = 80;
    private String passwdTaquilla;

    /**
     * Constructor de Entrada VIP
     * @param id id de la entrada
     * @param partido partido de la entrada
     * @param zona zona de la entrada
     * @param fila fila de la entrada
     * @param asiento asiento de la entrada
     */
    public EntradaVIP(int id, Partido partido, Zona zona, Fila fila, Asiento asiento) {
        super(id, partido, zona, fila, asiento);
        precioFinal = precioFinal(PRECIO_BASE);
        passwdTaquilla = getPasswdTaquilla();
    }

    @Override
    public String toString() {
        return "Entrada VIP {" +
                "Contraseña taquilla = '" + passwdTaquilla + '\'' +
                ", ID = " + id +
                ", Partido = " + partido.toString() +
                ", Zona = " + zona.getId() +
                ", Fila = " + fila.getId() +
                ", Asiento = " + asiento.getId() +
                ", Precio Final = " + precioFinal +
                '}';
    }

    /**
     * Método para generar una contraseña única y no deducible
     * @return password
     */
    private String getPasswdTaquilla() {
        String passwd = java.util.UUID.randomUUID().toString();
        passwd = passwd.replaceAll("-", "");
        passwd = passwd.substring(0, 9).toUpperCase();
        passwd += String.format("%02d",zona.getId());
        passwd += String.format("%02d",fila.getId());
        passwd += String.format("%02d",asiento.getId());
        return passwd;
    }
}
