package book._06_Trees.NonlinearDS;
/*Нека е дадено бинарно дрво со цели броеви. Да се напише функциjа коjа што ´ке
го провери дали даденото бинарно дрво е збирно дрво. Збирно дрво е бинарно
дрво каде вредноста на еден jазел е еднаква со збирот од вредностите на jазлите
во неговото лево и неговото десно поддрво. Се смета дека празно дрво е збирно
дрво и збирот е 0.
Пример:
Влез:
Бинарно дрво од слика 6-14
Излез:
The given tree is a SumTree*/
public class Zadaca8_ZbirnoDrvo {
    // ja imas vo BTree, a eve ja i tuka
    /*public static int sum(BNode<Integer> node) {
    if (node == null) {
        return 0;
    }

    return node.info + sum(node.left) + sum(node.right);
}

public static boolean isSumTree(BNode<Integer> node) {
    if (node == null) {
        return true;
    }

    // A leaf is automatically a SumTree
    if (node.left == null && node.right == null) {
        return true;
    }

    int leftSum = sum(node.left);
    int rightSum = sum(node.right);

    return node.info == leftSum + rightSum
            && isSumTree(node.left)
            && isSumTree(node.right);
}*/
}
