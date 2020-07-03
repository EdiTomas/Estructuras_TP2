/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.tp2_201503783;

import Circular.ListaCircular;
import static edd.tp2_201503783.Menu.ANSI_BLACK;
import static edd.tp2_201503783.Menu.ANSI_BLUE;
import java.util.Scanner;

/**
 *
 * @author edi
 */
public class MenuCircular {
    Scanner Sn = new Scanner(System.in);
    Scanner Entrada = new Scanner(System.in);
    
    
    
    int Opcion;
   // ListaOrdenada LO = new ListaOrdenada();
      ListaCircular Lc = new ListaCircular();
    public void Opciones() {

        System.out.println(ANSI_BLUE + "Bienvenido  a la lista-Circular");
        System.out.println(ANSI_BLUE + "Por favor  escoja  la opcion que desea realizar");
        boolean acceso = true;
        int id;
        int indice;
        int existe;
        String Nombre;
        String Apellido;

        while (acceso) {
            try {
                System.out.println(ANSI_BLACK + "1) Insertar");
                System.out.println(ANSI_BLACK + "2) Buscar"  );
                System.out.println(ANSI_BLACK + "3) Eliminar");
                System.out.println(ANSI_BLACK + "4) Graficar");
                System.out.println(ANSI_BLACK + "5) Regresar");
                

                Opcion = Sn.nextInt();
                switch (Opcion) {
                    case 1:      //insertar
                              System.out.println("ingrese el id");
                              id = Sn.nextInt();
                                   Sn.nextLine();
                        if(Lc.Existe(id))
                        {
                           System.out.println(" El elemento ya existe");
                        }else{
                        
                        System.out.println("ingrese el Nombre");
                        Nombre = Sn.nextLine();
                        System.out.println("ingrese el Apellido");
                        Apellido = Sn.nextLine();
                        Lc.Insertar(id, Nombre, Apellido);
                       
                        }
                                 
                        break;
                    case 2:       // Buscar 
                               System.out.println("ingrese el id que desea buscar");
                                indice = Sn.nextInt();
                                Sn.nextLine();
                                
                                if(Lc.Existe(indice)){
                                   Lc.Buscar(indice);
                                 }else{
                                    System.out.println("El elemento no existe");     
                                }
                        break;
                    case 3:       //  Eliminar
                                System.out.println("ingrese el id que desea Eliminar");
                                existe = Sn.nextInt();
                                     Sn.nextLine();
                                Lc.Eliminiar(existe);
                        break;
                     case 4:      //  Graficar;
                               Lc.Graficar();
                               Lc.GenerarGrafica();
                               System.out.println("Se ha Graficado con exito");
                        break;    
                        
                     case 5:       //  Regresar;
                        
                           acceso = false;
                       
                         break;    
                        
                        
                        
                        
                    default:
                }
            } catch (Exception e) {
                System.out.println("Debes insertar un número");
                Sn.next();
            }
        } // fin while

    }
    
    
    
    
    
}
