package com.victorlopez.Ejercicio03;

public abstract class Coche {
    protected String matricula;
    protected int velocidadActual;
    protected int marchaActual;
    protected int[] velocidadMarchas;

    /**
     * Constructor de la clase coche
     * @param matricula matrícula del coche
     */
    public Coche(String matricula) {
        this.matricula = matricula;
        velocidadActual = 0;
        marchaActual = 0;
        velocidadMarchas = new int[5];
        asignarVelocidades();
    }

    /**
     * Método para asignar límite de velocidades a las 5 marchas
     */
    protected void asignarVelocidades(){
        int velocidad = 30;
        for (int i = 0; i < velocidadMarchas.length; i++) {
            velocidadMarchas[i] = velocidad * (i+1);
        }
    }

    /**
     * Método para obtener la matrícula del coche
     * @return String que es la matricula del coche.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método para cambiar la matricula del coche
     * @param matricula nueva matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Método para obtener la velocidad actual del coche
     * @return devolvemos la velocidad actual
     */
    public int getVelocidadActual() {
        return velocidadActual;
    }

    /**
     * Método para cambiar la velocidad actual
     * @param velocidadActual velocidad a cambiar
     */
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    /**
     * Método para obtener la marcha actual del coche
     * @return devolvemos la marcha actual del coche
     */
    public int getMarcha() {
        return marchaActual;
    }

    /**
     * Método para cambiar la marcha del coche
     * @param marcha marcha a cambiar
     */
    protected void cambiarMarcha(int marcha){
        if (marcha <= 5 && marcha >= 0){
            this.marchaActual = marcha;
        }else{
            this.marchaActual = velocidadMarchas.length -1;
        }
    }

    /**
     * Método para acelerar el coche
     * @param velocidad velocidad que queremos acelerar
     */
    public void acelerar(int velocidad){
        int velocidadTotal;
        velocidadTotal = velocidad + velocidadActual;
        if (velocidad > 0){
            if (velocidadTotal > velocidadMarchas[marchaActual -1]){
                velocidadActual = velocidadMarchas[marchaActual -1];
            }else{
                velocidadActual = velocidadTotal;
            }
        }
    }

    /**
     * Método para frenar al coche
     * @param velocidad velocidad a frenar
     */
    public void frenar(int velocidad){
        int velocidadTotal;
        velocidadTotal = velocidad + velocidadActual;
        if (velocidad > 0){
            if (velocidadTotal < velocidadMarchas[marchaActual -2]){
                velocidadActual = velocidadMarchas[marchaActual -2];
            }else{
                velocidadActual = velocidadTotal;
            }
        }
    }

    /**
     * Método to String del coche
     * @return devolvemos los datos del coche
     */
    @Override
    public String toString() {
        return "Cotxe { " +
                "Matricula = " + matricula +
                ", Velocidad Actual = " + velocidadActual +
                ", Marcha Actual = " + (marchaActual + 1) +
                ", Velocidad Máxima Marchas = " + StringVelocidadMarchas() +
                '}';
    }

    /**
     * Método para obtener la velocidad máxima de las marchas
     * @return String con la info
     */
    public String StringVelocidadMarchas(){
        String aux = "";
        for (int i = 0; i < velocidadMarchas.length; i++) {
            aux += " Marcha "+ (i+1) + " " + velocidadMarchas[i] + "km/h; ";
        }
        return aux;
    }
}
