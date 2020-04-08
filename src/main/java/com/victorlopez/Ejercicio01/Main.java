package com.victorlopez.Ejercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x,y;//Variables que almacenan coordenadas.
        Scanner lector = new Scanner(System.in);//Declaramos el escáner.
        System.out.println("Introduce la X: ");//Pedimos la X.
        x = lector.nextDouble();lector.nextLine(); //Leemos la X
        System.out.println("Introduce la y: ");
        y = lector.nextDouble();lector.nextLine();//Leemos la y
        Punto p1 = new Punto(x, y);//Creamos un objeto punto
        System.out.println("Coordenadas punto 1");
        System.out.println(p1.toString());
        lector.nextLine();
        System.out.println("Introduce la X: ");
        x = lector.nextDouble();lector.nextLine();
        System.out.println("Introduce la y: ");
        y = lector.nextDouble();lector.nextLine();
        Punto p2 = new Punto(x, y);
        System.out.println("Coordenadas punto 2:");
        System.out.println(p2.toString());
        lector.nextLine();
        System.out.println("Distancia entre puntos");
        System.out.printf("%.2f %n",p1.distancia(p2));
    }

}
