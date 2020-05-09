package com.victorlopez.Ejercicio07;

public class Asiento {
    private int id;
    private boolean ocupado;

    /**
     * Constructor de Asiento
     * @param id id de asiento
     */
    public Asiento(int id) {
        this.id = id;
        ocupado = false;
    }

    public int getId() {
        return id;
    }

    /**
     * Método para saber si el asiento se encuentra ocupado
     * @return valor booleano
     */
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Asiento {" +
                "id = " + id;
        if (this.isOcupado()){
            aux += "Estado = Ocupado \n";
        }else{
            aux += "Estado = Libre \n";
        }
        return aux;
    }
}
