package com.victorlopez.Ejercicio03;

public class CocheCambioManual extends Coche{

    public CocheCambioManual(String matricula) {
        super(matricula);
    }

    /**
     * Método para cambiar de marcha
     * @param marcha marcha a cambiar
     */
    @Override
    public void cambiarMarcha(int marcha) {
        if (marcha <= 5 && marcha >= 0){
            this.marchaActual = marcha -1;
        }else{
            this.marchaActual = velocidadMarchas.length -1;
        }
    }
}
