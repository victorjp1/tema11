package com.victorlopez.Ejercicio03;

import java.util.Scanner;

public class Main {
    static Scanner lector;
    public static void main(String[] args) {
        String matricula;
        lector = new Scanner(System.in);
        System.out.println("Introduce la matrícula del cotxe");
        matricula = lector.nextLine().toUpperCase().trim();
        TipoCambio tipo = tipoCambio();
        switch (tipo){
            case AUTOMATICO:
                CocheCambioAutomatico c = new CocheCambioAutomatico(matricula);
                System.out.println(c.toString());
                c.acelerar(60);
                System.out.println(c.toString());
                break;
            case MANUAL:
                CocheCambioManual c1 = new CocheCambioManual(matricula);
                System.out.println(c1.toString());
                c1.cambiarMarcha(3);
                c1.acelerar(60);
                System.out.println(c1.toString());
                break;
        }
    }
    public static TipoCambio tipoCambio(){
        int opcion = -1;
        boolean validado;
        do {
            try{
                System.out.println("Hay dos tipos de coches, automáticos y manuales");
                System.out.println("Elige el tipo coche");
                System.out.println("1. Automático");
                System.out.println("2. Manual");
                System.out.println("Elige tu opción: ");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion == 1 || opcion == 2){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opcion incorrecta");
                }
            }catch (NumberFormatException nfe){
                validado = false;
            }
        }while (!validado);
        if (opcion == 1){
            return TipoCambio.AUTOMATICO;
        }else{
            return TipoCambio.MANUAL;
        }
    }
}
