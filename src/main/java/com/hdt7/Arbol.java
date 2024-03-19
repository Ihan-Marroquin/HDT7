package com.hdt7;

// Clase para representar un árbol binario de búsqueda
class Arbol {
    private Nodo<String> raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(String dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo<String> insertarRec(Nodo<String> raiz, String dato) {
        if (raiz == null) {
            raiz = new Nodo<>(dato);
            return raiz;
        }

        if (dato.compareTo(raiz.dato) < 0)
            raiz.izquierda = insertarRec(raiz.izquierda, dato);
        else if (dato.compareTo(raiz.dato) > 0)
            raiz.derecha = insertarRec(raiz.derecha, dato);

        return raiz;
    }

    public void recorridoEnOrden() {
        recorridoEnOrdenRec(raiz);
    }

    private void recorridoEnOrdenRec(Nodo<String> raiz) {
        if (raiz != null) {
            recorridoEnOrdenRec(raiz.izquierda);
            System.out.print(raiz.dato + " ");
            recorridoEnOrdenRec(raiz.derecha);
        }
    }

    public boolean buscar(String dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo<String> raiz, String dato) {
        if (raiz == null)
            return false;

        if (raiz.dato.equals(dato))
            return true;

        if (dato.compareTo(raiz.dato) < 0)
            return buscarRec(raiz.izquierda, dato);
        else
            return buscarRec(raiz.derecha, dato);
    }
}