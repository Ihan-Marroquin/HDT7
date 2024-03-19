package com.hdt7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class AppTest {

    static class BinaryTree {
        private TreeNode<String> root;

        public BinaryTree() {
            root = null;
        }

        public void insert(String data) {
            root = insertRec(root, data);
        }

        private TreeNode<String> insertRec(TreeNode<String> root, String data) {
            if (root == null) {
                root = new TreeNode<>(data);
                return root;
            }

            if (data.compareTo(root.data) < 0)
                root.left = insertRec(root.left, data);
            else if (data.compareTo(root.data) > 0)
                root.right = insertRec(root.right, data);

            return root;
        }

        public boolean search(String data) {
            return searchRec(root, data);
        }

        private boolean searchRec(TreeNode<String> root, String data) {
            if (root == null)
                return false;

            if (root.data.equals(data))
                return true;

            if (data.compareTo(root.data) < 0)
                return searchRec(root.left, data);
            else
                return searchRec(root.right, data);
        }
    }

    static class TreeNode<E extends Comparable<E>> {
        E data;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    @Test
    public void testBinaryTreeInsertAndSearch() {
        BinaryTree arbol = new BinaryTree();
        arbol.insert("casa");
        arbol.insert("perro");
        arbol.insert("tarea");
        arbol.insert("mujer");
        arbol.insert("pueblo");
        arbol.insert("si");

        assertTrue(arbol.search("casa"));
        assertTrue(arbol.search("perro"));
        assertTrue(arbol.search("tarea"));
        assertTrue(arbol.search("mujer"));
        assertTrue(arbol.search("pueblo"));
        assertTrue(arbol.search("si"));

        assertFalse(arbol.search("house"));
        assertFalse(arbol.search("dog"));
        assertFalse(arbol.search("homework"));
        assertFalse(arbol.search("woman"));
        assertFalse(arbol.search("town"));
        assertFalse(arbol.search("yes"));
    }

    @Test
    public void testAppTranslation() {
        String texto = "The woman asked me to do my homework about my town.";
        String traduccionEsperada = "*The* mujer *asked* *me* *to* *do* *my* tarea *about* *my* pueblo";
        assertEquals(traduccionEsperada, App.translateText(texto));
    }

    static class App {

        public static String translateText(String texto) {
            Map<String, String> dictionary = new HashMap<>();
            dictionary.put("house", "casa");
            dictionary.put("dog", "perro");
            dictionary.put("homework", "tarea");
            dictionary.put("woman", "mujer");
            dictionary.put("town", "pueblo");
            dictionary.put("yes", "si");

            StringBuilder traduccion = new StringBuilder();
            String[] palabras = texto.split(" ");

            for (String palabra : palabras) {
                String palabraLimpia = palabra.toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!palabraLimpia.isEmpty()) {
                    if (dictionary.containsKey(palabraLimpia)) {
                        traduccion.append(dictionary.get(palabraLimpia)).append(" ");
                    } else {
                        traduccion.append("*").append(palabra).append("* ");
                    }
                }
            }

            return traduccion.toString().trim();
        }
    }
}
