package PrethodniIspitni._2020;

import dataStructures.BNode;

/*За дадено бинарно дрво, пронајдете ја должината на најдолгата патека која се состои од последователни јазли (родител-дете,
 односно патека движечки се од горе надолу во хиерархијата) со вредности во последователен растечки редослед (разликата меѓу даден
 претходник и следбеник во патеката е 1).
Пример:
        10
       /  \
     11    9
    / \   / \
   13 12 13  8
Максимална должина на патека со јазли во последователен растечки редослед е 3 (за јазлите: 10, 11, 12).
Појаснување:
Патеката 10, 11, 13 не се зема во предвид бидејќи се гледа разликата меѓу 13 и 11, која треба да изнесува 1 за да се смета за
валидна патека.
        5
       / \
      8  11
     /    \
    9     10
   /      /
  6      15
Максимална должина на патека со последователни јазли во растечки редослед е 2 (за јазлите: 8, 9).
Појаснување:
Патеката 5,8,9 не се зема во предвид бидејќи се гледа разликата меѓу 8 и 5 која не изнесува 1. Затоа, патеката 8,9 останува
единствена патека во ова бинарно дрво со јазли во последователен растечки редослед.*/
public class Januari_2020_DopolnitelenDel_1_drvoRasteckaNiza {
    public static int longestConsecutivePath(BNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        return longestConsecutivePath(node, null, 0);
    }

    private static int longestConsecutivePath(
            BNode<Integer> node,
            BNode<Integer> parent,
            int currentLength) {

        if (node == null) {
            return currentLength;
        }

        // Calculate the length of the consecutive path ending at this node
        if (parent != null && node.info == parent.info + 1) {
            currentLength++;
        } else {
            currentLength = 1;
        }

        // Continue independently down both children
        int left = longestConsecutivePath(node.left, node, currentLength);
        int right = longestConsecutivePath(node.right, node, currentLength);

        return Math.max(currentLength, Math.max(left, right));
    }
}
