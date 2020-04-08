package com.victorlopez.Ejercicio03;

public class CocheCambioAutomatico extends Coche{
    /**
     * Constructor de la clase
     * @param matricula matricula a colocar
     */
    public CocheCambioAutomatico(String matricula) {
        super(matricula);
    }

    /**
     * Mñetodo para acelerar el coche
     * @param v velocidad a acelerar
     */
    @Override
    public void acelerar(int v) {
        velocidadActual += v;
        super.cambiarMarcha(seleccionarMarcha());
    }

    /**
     * Mñetodo para frenar con el coche
     * @param v velocidad a frenar
     */
    @Override
    public void frenar(int v) {
        super.frenar(v);
        super.cambiarMarcha(seleccionarMarcha());
    }

    /**
     * Método para seleccionar la marcha
     * @return
     */
    protected int seleccionarMarcha(){
        int marcha;
        if (velocidadActual >= 0 && velocidadActual < velocidadMarchas[0]){
            marcha = 1;
        }else if(velocidadActual >= velocidadMarchas[0] && velocidadActual < velocidadMarchas[1]){
            marcha = 2;
        }else if (velocidadActual >= velocidadMarchas[1] && velocidadActual < velocidadMarchas[2]){
            marcha = 3;
        }else if (velocidadActual >= velocidadMarchas[2] && velocidadActual < velocidadMarchas[3]){
            marcha = 4;
        }else{
            marcha = 5;
        }
        return marcha;
    }
}
