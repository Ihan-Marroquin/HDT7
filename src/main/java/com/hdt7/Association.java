package com.hdt7;

// Clase para representar una asociación entre una llave (inglés) y un valor (español)
class Association<K extends Comparable<K>, V> {
    K key;
    V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
