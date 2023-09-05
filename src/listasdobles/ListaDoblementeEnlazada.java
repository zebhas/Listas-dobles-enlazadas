/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasdobles;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Iterable<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamaño;

    public ListaDoblementeEnlazada() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    private class Nodo<T> {

        T dato;
        Nodo<T> anterior;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    public void eliminarUltimo() {
        if (!estaVacia()) {
            if (tamaño == 1) {
                cabeza = null;
                cola = null;
            } else {
                cola = cola.anterior;
                cola.siguiente = null;
            }
            tamaño--;

            System.out.println("Tamaño de la lista  actualizado: " + tamaño);
            System.out.println("_____________________________________________");
        } else {
            System.out.println("La lista está vacía. No se puede eliminar el último elemento.");
        }
    }
public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        tamaño++;
        ordenar();
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        tamaño++;
        ordenar();
    }

    public void agregarEnMedio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            Nodo<T> anterior = null;

            while (actual != null && actual.dato.compareTo(dato) < 0) {
                anterior = actual;
                actual = actual.siguiente;
            }

            if (anterior == null) {
                // El nuevo nodo se insertará al principio de la lista
                nuevoNodo.siguiente = cabeza;
                cabeza.anterior = nuevoNodo;
                cabeza = nuevoNodo;
            } else if (actual == null) {
                // El nuevo nodo se insertará al final de la lista
                anterior.siguiente = nuevoNodo;
                nuevoNodo.anterior = anterior;
                cola = nuevoNodo;
            } else {
                // El nuevo nodo se insertará en medio de la lista
                nuevoNodo.siguiente = actual;
                nuevoNodo.anterior = anterior;
                actual.anterior = nuevoNodo;
                anterior.siguiente = nuevoNodo;
            }
        }
        tamaño++;
    }

    private void ordenar() {
        if (tamaño > 1) {
            Nodo<T> current = cabeza;
            while (current.siguiente != null) {
                Nodo<T> next = current.siguiente;
                if (current.dato.compareTo(next.dato) > 0) {
                    // Swap the data
                    T temp = current.dato;
                    current.dato = next.dato;
                    next.dato = temp;
                    current = cabeza; // Start over after swapping
                } else {
                    current = current.siguiente;
                }
            }
        }
    }
    

    // Verificar si la lista está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }

    // Obtener el tamaño de la lista
    public int tamaño() {
        return tamaño;
    }

    // Consultar un valor en la lista
    public boolean contiene(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Determinar si dos listas son iguales
    public boolean equals(ListaDoblementeEnlazada<T> otraLista) {
        if (tamaño() != otraLista.tamaño()) {
            return false;
        }
        Nodo<T> actualEsta = cabeza;
        Nodo<T> actualOtra = otraLista.cabeza;
        while (actualEsta != null) {
            if (!actualEsta.dato.equals(actualOtra.dato)) {
                return false;
            }
            actualEsta = actualEsta.siguiente;
            actualOtra = actualOtra.siguiente;
        }
        return true;
    }

    public void mostrarDesdeElFinal() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    // Implementación del iterador
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }

            public void mostrarDesdeElFinal() {
                if (estaVacia()) {
                    System.out.println("La lista está vacía.");
                    return;
                }

                Nodo<T> actual = cola;
                while (actual != null) {
                    System.out.print(actual.dato + " ");
                    actual = actual.anterior;
                }
                System.out.println();
            }
        };
    }
}
