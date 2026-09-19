package book._06_Trees.SearchTrees;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

import java.util.Scanner;

/*За дадено бинарно пребарувачко дрво да се напише функциjа коjа ´ке пресметува
сума на сите елементи помали или еднакви на k-от наjмал елемент во дрвото.
Вредноста за k се внесува од тастатура.*/
public class Zadaca4_SumaNaKNajmali {

    public static void sumFirstK(BNode<Integer> node, int k, int[] count, int[] sum) {

        if (node == null || count[0] >= k) {
            return;
        }

        // LEFT
        sumFirstK(node.left, k, count, sum);

        // Maybe we already reached k while traversing the left subtree
        if (count[0] >= k) {
            return;
        }

        // ROOT
        sum[0] += node.info;
        count[0]++;

        // RIGHT
        sumFirstK(node.right, k, count, sum);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }

        int k = scanner.nextInt();

        int[] count = {0};
        int[] sum = {0};

        sumFirstK(tree.getRoot(), k, count, sum);

        System.out.println(sum[0]);
    }
}
