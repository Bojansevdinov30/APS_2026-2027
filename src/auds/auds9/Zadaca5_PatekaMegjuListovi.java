package auds.auds9;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

import java.io.*;

/*За дадено бинарно пребарувачко дрво чии јазли содржат N
природни броеви (1≤N≤250) помеѓу секој пар од листови постои
единствена патека. Кон секој пар на листови се поврзува
асоциранa сума која се добива со собирање на броевите од сите
јазли кои што се наоѓаат на патеката од едниот до другиот лист.
Која е максималната сума која што се јавува како асоцирана сума
за некој пар од листови во дрвото?
Влез: Во првиот ред е даден бројот N на јазли. Во наредните N
реда се дадени вредности на јазлите за вметнување во дрвото.
Излез: Максималната сума која што се јавува како асоцирана сума
за некој пар од листови во дрвото.*/
public class Zadaca5_PatekaMegjuListovi {

    static class Res {
        int maxSum = Integer.MIN_VALUE;
    }

    public static int maxPathSumUtil(BNode<Integer> node, Res res) {

        if (node == null) {
            return 0;
        }

        // Leaf
        if (node.left == null && node.right == null) {
            return node.info;
        }

        int leftSum = maxPathSumUtil(node.left, res);
        int rightSum = maxPathSumUtil(node.right, res);

        // Both children exist, so a leaf-to-leaf path
        // can pass through this node.
        if (node.left != null && node.right != null) {

            res.maxSum = Math.max(
                    res.maxSum,
                    leftSum + node.info + rightSum
            );

            // Parent can only continue through ONE branch.
            return node.info + Math.max(leftSum, rightSum);
        }

        // Only one child exists.
        if (node.left != null) {
            return node.info + leftSum;
        }

        return node.info + rightSum;
    }

    public static int maxPathSum(BNode<Integer> root) {
        Res res = new Res();
        maxPathSumUtil(root, res);
        return res.maxSum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BinarySearchTree<Integer> tree =
                new BinarySearchTree<>();

        for (int i = 0; i < n; i++) {
            tree.insert(Integer.parseInt(br.readLine()));
        }

        System.out.println(maxPathSum(tree.getRoot()));
    }
}