package book._06_Trees.NonlinearDS;
/*Нека е дадено бинарно дрво кое се состои од цифрите 1-9. Да се напише функциjа
коjа што ´ке jа пресмета сумата на сите броеви кои се формираат на патот од
коренот до соодветниот лист на дрвото.
Пример:
Влез:
Бинарно дрво од слика 6-15
Излез:
351 + 3532 + 3539 + 3116 = 10538*/
public class Zadaca9_SumaPatistaKorenList {
    // ja imas vo BTree, a eve ja i tuka
    /*public static int sumNumbers(BNode<Integer> node, int currentNumber) {

    if (node == null) {
        return 0;
    }

    currentNumber = currentNumber * 10 + node.info;

    // We have completed one root-to-leaf number
    if (node.left == null && node.right == null) {
        return currentNumber;
    }

    return sumNumbers(node.left, currentNumber)
            + sumNumbers(node.right, currentNumber);
}*/
}
