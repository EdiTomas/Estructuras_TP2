/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.tp2_201503783;

import java.util.Scanner;

/**
 *
 * @author edi
 */
public class Menu {
    

public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    Scanner sn = new Scanner(System.in);
    int Opcion = 0;

    public void Opciones() {

        System.out.println((char) 27 + "[34;47m");
        System.out.println(ANSI_BLUE + "Bienvenidos  a la Tarea Practica 2 Carnet: 201503783");
        System.out.println(ANSI_BLUE + "Por favor escoja la lista con la  que quiere interactuar" + "\n");
             MenuCircular mc = new MenuCircular();    
             MenuDoble Md = new MenuDoble();             
            
                      
        while (true) {
            System.out.println(ANSI_RED + "1). Lista Doble ");
            System.out.println(ANSI_RED + "2). Lista Circular ");
            System.out.println(ANSI_RED + "3). Salir " + "\n");

            try {
                System.out.println(ANSI_BLUE + "Escribe una de las Opciones ");

                System.out.println("--------");
                Opcion = sn.nextInt();
                System.out.println("--------");

                switch (Opcion) {
                    case 1:  // Lista Doble 
                             Md.Opciones();
                        break;
                    case 2:  //  Lista Circular
                             mc.Opciones();
                        break;
                   
                    case 3:
                        System.exit(0);
                        break;
                }

            } catch (Exception error) {
               System.out.println(ANSI_CYAN + "Debes insertar un número");
                sn.next();
            }
        }// fin del while

    }





}
