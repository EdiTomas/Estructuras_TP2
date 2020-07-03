/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circular;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author edi
 */
public class ListaCircular {

    NodoCircular Primero = null;
    NodoCircular Ultimo = null;

    public Boolean EstaVacio() {
        return Primero == null && Ultimo == null;

    }

    public void Insertar(int id, String Nombre, String Apellido) {
        if (EstaVacio()) {
            Primero = Ultimo = new NodoCircular(id, Nombre, Apellido);
            Ultimo.setSiguiente(Primero);
            Primero.setSiguiente(Primero);
        } else {
            NodoCircular Nuevo = new NodoCircular(id, Nombre, Apellido);
            Ultimo.setSiguiente(Nuevo);
            Nuevo.setSiguiente(Primero);
            Ultimo = Nuevo;
        }
    }

    public Boolean Existe(int id) {
        NodoCircular Actual = Primero;
        Boolean existe = false;
        if (!EstaVacio()) {

            do {
                if (id == Actual.getId()) {
                    existe = true;
                    break;
                }
                Actual = Actual.getSiguiente();
            } while (Primero != Actual);

        }

        return existe;
    }

    public void Buscar(int id) {

        if (!EstaVacio()) {
            NodoCircular Actual = Primero;
            do {
                if (id == Actual.getId()) {
                    System.out.println("id: " + Actual.getId());
                    System.out.println("Nombre: " + Actual.getNombre());
                    System.out.println("Apellido: " + Actual.getApellido());
                    break;
                }
                Actual = Actual.getSiguiente();
            } while (Primero != Actual);
        } else {
            System.out.println("La lista esta Vacia");
        }
    }

    public void Eliminiar(int id) {
        if (!EstaVacio()) {
            NodoCircular Actual = Primero;
            NodoCircular Anterior = null;
            do {
                if (id == Actual.getId()) {
                    break;
                } else {
                    Anterior = Actual;
                    Actual = Actual.getSiguiente();
                }
            } while (Primero != Actual);

            if (Actual != null) {

                if (Primero == Actual && Ultimo == Actual) {
                    System.out.println("id : " + Actual.getId() + " Se ha Eliminado con exito!");
                    Primero = Ultimo = null;
                    //  Primero.setSiguiente(null);
                    //   Ultimo.setSiguiente(null);

                } else if (Actual == Primero) {
                    System.out.println("id : " + Actual.getId() + "Se ha Eliminado con exito!");
                    Primero = Primero.getSiguiente();
                    Ultimo.setSiguiente(Primero);
                    Actual.setSiguiente(null);

                } else if (Actual == Ultimo) {
                    System.out.println("id : " + Actual.getId() + "Se ha Eliminado con exito!");
                    Anterior.setSiguiente(Ultimo.getSiguiente());
                    Ultimo = Anterior;
                    Actual.setSiguiente(null);

                } else {
                    System.out.println("id : " + Actual.getId() + "Se ha Eliminado con exito!");
                    Anterior.setSiguiente(Actual.getSiguiente());
                    Actual.setSiguiente(null);
                }
                Actual = null;
            }

        } else {
            System.out.println("La lista esta Vacia");
        }

        // System.out.println(Recorrido());
    }

    public String RecorrerArbol() {
        String Cuerpo = "";
        String Despliegue = "";
        String Inicio = "";
        Boolean repetir = false;
        if (!EstaVacio()) {
            NodoCircular Actual = Primero;
            do {
                   // Inicio = "";
                   
                if (Primero == Actual && Ultimo == Actual) {
                    Despliegue = "node" + Primero.getId() + "[label = " + "\"{<val>" + Primero.getId()+"\n "+ Primero.getNombre() + "\n " + Primero.getApellido() + "|<ptr> sig}\"" + "];";
                    Cuerpo = "node" + "" + Primero.getId() + "->" + "node" + Primero.getId();
                  } else if (Primero == Actual) {
                    Despliegue = "node" + Primero.getId() + "[label = " + "\"{<val>" + Primero.getId()+"\n " + Primero.getNombre() + "\n " + Primero.getApellido() + "|<ptr> sig}\"" + "];";
                    Cuerpo = "node" + "" + Primero.getId();
                  } else {
                    Despliegue += "node" + Actual.getId() + "[label = " + "\"{<val>"+ Actual.getId()+"\n " + Actual.getNombre() + "\n " + Actual.getApellido() + "|<ptr> sig}\"" + "];";
                    Cuerpo += "->" + "node" + Actual.getId();
                     if (Actual == Ultimo) 
                    {
                        Cuerpo += "->" + "node" + Primero.getId();
                    }
                }
                  Actual = Actual.getSiguiente();
              } while (Primero != Actual);
        } else {
               System.out.println("La lista Esta Vacia");
        }
        return Despliegue + "\n" + Cuerpo;
 }

    public void Graficar() {
        try {
            String ruta = "ListaCircular.dot";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    " digraph G {\n"
                    + "     rankdir=LR; "
                    + "" + " node[ shape=record, fontcolor=black, color=coral1];  \n"
                    + "edge[color=chartreuse1] \n"
            );
            bw.write(RecorrerArbol() + "\n" + "}");

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void GenerarGrafica() {
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "ListaCircular.png", "ListaCircular.dot");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
            pbuilder = new ProcessBuilder("eog","ListaCircular.png");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}



    
    
    
    
}
