package com.victorlopez.Ejercicio07;
import com.victorlopez.Lib;

import java.util.Arrays;

public class Bombo {
    private int[] bolas;//Bolas a extraer
    private int contador;//Contador de número de elementos en el array
    private int min;//Mínimo número a empezar
    private int max;//Máximo número a empezar

    /**
     * Constructor de la clase bombo
     * @param MIN mínimo número para las bolas a generar
     * @param MAX máximo número para las bolas a generar
     */
    public Bombo(final int MIN, final int MAX) {
        int bola = MIN;
        this.min = MIN;
        this.max = MAX;
        contador = (MAX - MIN) + 1;
        bolas = new int[contador];
        //Llenamos el array de las bolas con sus respectivos valores
        for (int i = 0; i < bolas.length; i++){
            bolas[i] = bola++;
        }
    }

    /**
     * Método para rellenar las bolas del bombo
     */
    public void rellenar(){
        contador = (max - min) + 1;
    }

    /**
     * Método para sacar bola, cambiándola la posición de la bola por la última y decrementando el contador con el que recorremos
     * @return devuelve la bola
     */
    public int sacarBola(){
        int pos = Lib.aleatorio(0, contador -1);
        int aux;
        aux = bolas[pos];
        bolas[pos] = bolas[contador -1];
        bolas[contador-1] = aux;
        contador--;
        return aux;
    }

    /**
     * Método que devuelve las bolas del bombo
     * @return devuelve un String
     */
    @Override
    public String toString() {
        return "Bombo{" +
                "bolas=" + Arrays.toString(bolas) +
                '}';
    }
}
