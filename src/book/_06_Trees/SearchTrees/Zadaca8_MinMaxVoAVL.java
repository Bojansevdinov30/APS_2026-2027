package book._06_Trees.SearchTrees;

import dataStructures.AVLNode;

/*Да се напише функциjа за определување на минимален и максимален елемент
во AVL дрво.*/
public class Zadaca8_MinMaxVoAVL {
    public static <T extends Comparable<T>> T min(AVLNode<T> node) {

        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = (AVLNode<T>) node.left;
        }

        return node.data;
    }

    public static <T extends Comparable<T>> T max(AVLNode<T> node) {

        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = (AVLNode<T>) node.right;
        }

        return node.data;
    }
}
