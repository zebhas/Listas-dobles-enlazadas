/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasdobles;

/**
 *
 * @author Guest
 */
// Clase principal con el método main
import java.io.PrintStream;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ListaDoblementeEnlazada<Integer> miLista = new ListaDoblementeEnlazada<>();
        ListaDoblementeEnlazada<Integer> otraLista = new ListaDoblementeEnlazada<>();
        System.out.println("¿La Lista 1 inicialmente está vacía? " + miLista.estaVacia());
        System.out.println("¿La Lista 2 inicialmente está vacía? " + otraLista.estaVacia());
        System.out.println("Tamaño de la Lista 1: " + miLista.tamaño());
        System.out.println("Tamaño de la Lista 2: " + otraLista.tamaño());
        System.out.println();
        System.out.println("_________________________________");
        System.out.println("Agregando elementos a la lista 1 : ");

        miLista.agregarAlInicio(9);
        miLista.agregarAlFinal(3);
        miLista.agregarEnMedio(0);
         miLista.agregarAlInicio(2);
        
         
        
        System.out.println("Lista 1:");
        for (Integer item : miLista) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("mostrar lista desde el final :  ");
         miLista.mostrarDesdeElFinal();
        System.out.println("Tamaño de la Lista 1: " + miLista.tamaño());

        System.out.println("_________________________________________");

        System.out.println("Agregando elementos a la lista 2: ");
        otraLista.agregarAlFinal(2);
        otraLista.agregarAlInicio(1);
        otraLista.agregarAlFinal(4);
        otraLista.agregarEnMedio(5);

        System.out.println("Lista 2:");
        for (Integer item : otraLista) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("mostrar lista desde el final :  ");
         otraLista.mostrarDesdeElFinal();
         
        System.out.println("Tamaño de la Lista 2: " + otraLista.tamaño());

        System.out.println("_________________________________________");

        System.out.println("Tamaño de la Lista 1: " + miLista.tamaño());
        System.out.println("Tamaño de la Lista 2: " + otraLista.tamaño());
        System.out.println();
        System.out.println("_________________________________________");

        System.out.println("¿La Lista 1 contiene 3? " + miLista.contiene(3));
        System.out.println("¿La Lista 2 contiene 3? " + otraLista.contiene(3));
        System.out.println();
        System.out.println("_________________________________________");

        System.out.println("¿Lista 1 es igual a Lista 2? " + miLista.equals(otraLista));
        System.out.println("_________________________________________");
        System.out.println("Se ha eliminado el último elemento de la lista 1 : ");
        miLista.eliminarUltimo();
        System.out.println("Lista 1 actualizada después de eliminar el último elemento:");
        for (Integer item : miLista) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("_________________________________________");

        System.out.println("Se ha eliminado el último elemento de la lista 2: ");
        otraLista.eliminarUltimo();
        System.out.println("Lista 2 actualizada después de eliminar el último elemento:");
        for (Integer item : otraLista) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("_________________________________________");

        System.out.println("¿La Lista 1 está vacía? " + miLista.estaVacia());
        System.out.println("¿La Lista 2 está vacía? " + otraLista.estaVacia());
        System.out.println("_________________________________________");

        System.out.println("¿Lista 1 es igual a Lista 2 después de eliminar el último elemento de Lista 2? " + miLista.equals(otraLista));

    }
    
}
