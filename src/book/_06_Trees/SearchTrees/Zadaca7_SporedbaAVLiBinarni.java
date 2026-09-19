package book._06_Trees.SearchTrees;

import dataStructures.AVLNode;
import dataStructures.BNode;

/*Да се напише метода за одредување разлика во висините на jазлите каj AVL дрво.
Да се спореди овоj метод со методот за балансирано бинарно пребарувачко дрво
од претходните примери под услов двете дрва да се исполнети со исти елементи.*/
public class Zadaca7_SporedbaAVLiBinarni {
    // razlika e toa sto kaj AVL visinata se cuva i moze odma da se dobie a kaj binarnive mora rekurzivno da se presmeta
    // Кај AVL висината веќе се чува во самиот јазол
    public static <T extends Comparable<T>> int heightAVL(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }

        return node.getHeight();
    }

    // Разлика меѓу висината на левото и десното поддрво кај AVL
    public static <T extends Comparable<T>> int differenceAVL(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }

        return heightAVL((AVLNode<T>) node.left)
                - heightAVL((AVLNode<T>) node.right);
    }


    // Кај обично бинарно дрво висината мора рекурзивно да се пресмета
    public static <T extends Comparable<T>> int heightBST(BNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(
                heightBST(node.left),
                heightBST(node.right)
        );
    }

    // Разлика меѓу висината на левото и десното поддрво кај BST
    public static <T extends Comparable<T>> int differenceBST(BNode<T> node) {
        if (node == null) {
            return 0;
        }

        return heightBST(node.left) - heightBST(node.right);
    }
}
