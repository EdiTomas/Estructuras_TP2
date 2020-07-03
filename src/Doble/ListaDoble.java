/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doble;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author edi
 */
public class ListaDoble {

    // null<-a->null         
    NodoDoble Primero;
    NodoDoble Ultimo;

    public Boolean EstaVacia() {

        return Primero == null && Ultimo == null;
    }

    public void listaOrdenada(int id, String Nombre, String Apellido) {
        NodoDoble Nuevo = new NodoDoble(id, Nombre, Apellido);
        if (Primero == null) {
            Primero = Nuevo;
        } else {
            NodoDoble Actual, Anterior;
            Actual = Anterior = Primero;
            while (Actual.getSiguiente() != null) {
                Anterior = Actual;
                Actual = Actual.getSiguiente();
            } // fin del wnile
            if (Actual.getId() < id) {
                Actual.setSiguiente(Nuevo);
                Nuevo.setAnterior(Actual);
                Actual = Nuevo;
            } else {
                Actual = Anterior = Primero;
                while (Actual != null) {
                    if (Anterior.getId() < id && id < Actual.getId()) {
                        break;
                    } else {
                        Anterior = Actual;
                        Actual = Actual.getSiguiente();
                    } // fin del else y el if
                } // fin del while             
                Anterior.setSiguiente(Nuevo);
                Nuevo.setAnterior(Anterior);
                Nuevo.setSiguiente(Actual);
                Actual.setAnterior(Nuevo);
            }
        } // fin del else if

        return;
    }

    public void InsertarOrdenado(int id, String Nombre, String Apellido) {
        NodoDoble Nuevo = new NodoDoble(id, Nombre, Apellido);
        if (Primero == null) {
            Primero = Ultimo = Nuevo;
        } else if (Ultimo.getId() < id) {
            Ultimo.setSiguiente(Nuevo);
            Nuevo.setAnterior(Ultimo);
            Ultimo = Nuevo;
        } else {
            NodoDoble actual = Primero;
            NodoDoble Anterior = Primero;
            while (actual.getSiguiente() != null) {
                if (Anterior.getId() < id && id < actual.getId()) {
                    break;
                } else {
                    Anterior = actual;
                    actual = actual.getSiguiente();
                }
            }

            Anterior.setSiguiente(Nuevo);
            Nuevo.setAnterior(Anterior);
            Nuevo.setSiguiente(actual);
            actual.setAnterior(Nuevo);
        }
    }

    public void insertarListaDobleCircular(int id, String Nombre, String Apellido) {
        NodoDoble Nuevo = new NodoDoble(id, Nombre, Apellido);
        if (EstaVacia()) {
            Primero = Ultimo = Nuevo;
            Primero.setSiguiente(Ultimo);
            Ultimo.setSiguiente(Primero);
            Primero.setAnterior(Ultimo);
            Ultimo.setAnterior(Primero);
        } else if (id < Primero.getId()) {

            Nuevo.setSiguiente(Primero);
            Primero.setAnterior(Nuevo);
            Nuevo.setAnterior(Ultimo);
            Primero = Nuevo;
            Ultimo.setSiguiente(Primero);

        } else if (Ultimo.getId() < id) {
            Ultimo.setSiguiente(Nuevo);
            Primero.setAnterior(Nuevo);
            Nuevo.setAnterior(Ultimo);
            Nuevo.setSiguiente(Primero);
            Ultimo = Nuevo;

        } else {
            NodoDoble actual = Primero;
            NodoDoble Anterior = Primero;
            do {
                if (Anterior.getId() < id && id < actual.getId()) {
                    break;
                } else {
                    Anterior = actual;
                    actual = actual.getSiguiente();
                }  // fin del else if 
            } while (actual != Primero);

            Anterior.setSiguiente(Nuevo);
            Nuevo.setAnterior(Anterior);
            Nuevo.setSiguiente(actual);
            actual.setAnterior(Nuevo);
        }

    }

    public String RecorrerListaCircular() {

        String Cuerpo = "";

        if (!EstaVacia()) {
            NodoDoble Actual = Primero;
            NodoDoble Anterior = null;
            do {
                Cuerpo += "node" + Actual.getId() + "[label = " + "\"{<val> ant |" + Actual.getId() + " \n " + Actual.getNombre() + " \n " + Actual.getApellido() + "|<ptr> sig}\"" + "];\n";
                Actual = Actual.getSiguiente();
            } while (Actual != Primero);

            Actual = Primero;

            do {
                if (Actual.getAnterior() == Primero && Actual.getSiguiente() == Primero) {
                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getAnterior().getId() + ";\n";
                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getSiguiente().getId() + ";\n";

                } /*
                  else if(Actual.getAnterior()== null && Actual.getSiguiente() !=null) 
                  {
                     Cuerpo += "node"+Actual.getId()+"->"+"node"+Actual.getSiguiente().getId()+";\n";
                  }else if(Actual.getAnterior()!= null && Actual.getSiguiente() ==null){
                        Cuerpo += "node"+Actual.getId()+"->"+"node"+Actual.getAnterior().getId()+";\n";
                  
                  }
                 */ else {

                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getAnterior().getId() + ";\n";
                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getSiguiente().getId() + ";\n";
                }
                Actual = Actual.getSiguiente();
            } while (Actual != Primero);

        } else {
            System.out.println("La lista Esta Vacia");
        }
        return Cuerpo;
    }

    public void Insertar(int id, String Nombre, String Apellido) {
        if (EstaVacia()) {
            NodoDoble Nuevo = new NodoDoble(id, Nombre, Apellido);
            Primero = Ultimo = Nuevo;
            Primero.setSiguiente(null);
            Primero.setAnterior(null);
            Ultimo.setSiguiente(null);
            Ultimo.setAnterior(null);
            System.out.println("id :" + " Se ha insertado con Exito!");

        } else {
            NodoDoble Nuevo = new NodoDoble(id, Nombre, Apellido);
            Ultimo.setSiguiente(Nuevo);
            Nuevo.setAnterior(Ultimo);
            Nuevo.setSiguiente(null);
            Ultimo = Nuevo;
            System.out.println("id :" + " Se ha insertado con Exito!");

        }
    }

    public Boolean Existe(int id) {
        Boolean existe = false;
        NodoDoble actual = Primero;
        while (actual != null) {
            if (id == actual.getId()) {
                existe = true;
                break;
            }
            actual = actual.getSiguiente();
        }

        return existe;
    }

    public void Buscar(int id) {

        if (!EstaVacia()) {
            NodoDoble actual = Primero;
            while (actual != null) {

                if (id == actual.getId()) {

                    System.out.println("id: " + actual.getId());
                    System.out.println("Nombre : " + actual.getNombre());
                    System.out.println("Apellido : " + actual.getApellido());

                    break;
                }
                actual = actual.getSiguiente();
            }

        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void Eliminiar(int id) {
        if (!EstaVacia()) {
            NodoDoble Actual = Primero;
            NodoDoble Anterior = null;
            while (Actual != null) {
                if (id == Actual.getId()) {
                    break;
                } else {
                    Anterior = Actual;
                    Actual = Actual.getSiguiente();
                }
            }

            if (Actual != null) {

                if (Primero == Actual && Ultimo == Actual) {
                    System.out.println("id : " + Actual.getId() + " Se ha Eliminado con exito!");
                    Primero = Ultimo = null;
                    Primero.setSiguiente(null);
                } else if (Actual == Primero) {
                    System.out.println("id : " + Actual.getId() + "Se ha Eliminado con exito!");
                    // Primero = Primero.getSiguiente();
                    Primero = null;
                    Actual = Actual.getSiguiente();
                    Primero = Actual;
                    Primero.setAnterior(null);
                } else if (Actual == Ultimo) {
                    System.out.println("id : " + Actual.getId() + "Se ha Eliminado con exito!");
                    Anterior.setSiguiente(Ultimo.getSiguiente());

                } else {
                    System.out.println("id : " + Actual.getId() + "Se ha Eliminado con exito!");
                    Anterior.setSiguiente(Actual.getSiguiente());
                    // Actual.setAnterior(Anterior.getAnterior());
                    Actual.getSiguiente().setAnterior(Actual.getAnterior());
//   Actual.setSiguiente(null);
                }
                Actual = null;
            }
        } else {
            System.out.println("La lista esta Vacia");
        }
    }

    public String RecorrerArbol() {

        String Cuerpo = "";

        if (!EstaVacia()) {
            NodoDoble Actual = Primero;
            NodoDoble Anterior = null;
            while (Actual != null) {
                Cuerpo += "node" + Actual.getId() + "[label = " + "\"{<val> ant |" + Actual.getId() + " \n " + Actual.getNombre() + " \n " + Actual.getApellido() + "|<ptr> sig}\"" + "];\n";
                Actual = Actual.getSiguiente();
            }
            Actual = Primero;

            while (Actual != null) {
                if (Actual.getAnterior() == null && Actual.getSiguiente() == null) {

                } else if (Actual.getAnterior() == null && Actual.getSiguiente() != null) {
                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getSiguiente().getId() + ";\n";
                } else if (Actual.getAnterior() != null && Actual.getSiguiente() == null) {
                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getAnterior().getId() + ";\n";

                } else {

                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getAnterior().getId() + ";\n";
                    Cuerpo += "node" + Actual.getId() + "->" + "node" + Actual.getSiguiente().getId() + ";\n";
                }
                Actual = Actual.getSiguiente();
            }

        } else {
            System.out.println("La lista Esta Vacia");
        }
        return Cuerpo;
    }

    public void Graficar() {
        try {
            String ruta = "listadoble.dot";
            // Si el archivo no existe es creado
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    " digraph G {\n"
                    + "     rankdir=LR; "
                    + "" + " node[ shape=record, fontcolor=black, color=coral1];  \n"
                    + "edge[color=chartreuse1] \n"
            );
            bw.write(RecorrerArbol() + "\n" + "}");

            bw.close();
            fw.close();

            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "listadoble.png", "listadoble.dot");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

            pbuilder = new ProcessBuilder("eog", "listadoble.png");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void GraficarListaDoblementeCircular() {
        try {
            String ruta = "listadoblementecircular.dot";
            // Si el archivo no existe es creado
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    " digraph G {\n"
                    + "     rankdir=LR; "
                    + "" + " node[ shape=record, fontcolor=black, color=coral1];  \n"
                    + "edge[color=chartreuse1] \n"
            );
            bw.write(this.RecorrerListaCircular() + "\n" + "}");

            bw.close();
            fw.close();

            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "listadoblementecircular.png", "listadoblementecircular.dot");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

            pbuilder = new ProcessBuilder("eog", "listadoblementecircular.png");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
