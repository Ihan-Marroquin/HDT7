package com.hdt7;

// Clase para representar un nodo en un árbol binario
class Nodo<E extends Comparable<E>> {
    E dato;
    Nodo<E> izquierda;
    Nodo<E> derecha;

    public Nodo(E dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}