package PrethodniIspitni._2026;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

/*Vlezna vtora grupa: Dll lista, da se najdi prvo pojavuvanje na paren i posledno pojavuvanke na neparen broj.
Potoa da se ispechati paren i negova pozicija i neparen i negova pozicija. Na kraj da im se smenat mestata na ovie broja i da se ispechati
listata.*/
public class PrvKolokvium_2026_Vlezna_parenNeparenLista {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DLL<Integer> list = new DLL<>();

        for (int i = 0; i < n; i++) {
            int number = input.nextInt();
            list.insertLast(number);
        }

        // Find the first even number
        DLLNode<Integer> evenNode = list.getFirst();
        int evenPosition = 0;

        while (evenNode != null && evenNode.getElement() % 2 != 0) {
            evenNode = evenNode.getSucc();
            evenPosition++;
        }

        // Find the last odd number
        DLLNode<Integer> oddNode = list.getLast();
        int oddPosition = n - 1;

        while (oddNode != null && oddNode.getElement() % 2 == 0) {
            oddNode = oddNode.getPred();
            oddPosition--;
        }

        // Print the numbers and their positions
        System.out.println("Even: " + evenNode.getElement());
        System.out.println("Position: " + evenPosition);

        System.out.println("Odd: " + oddNode.getElement());
        System.out.println("Position: " + oddPosition);

        // Swap their values
        int temp = evenNode.getElement();
        evenNode.setElement(oddNode.getElement());
        oddNode.setElement(temp);

        // Print the resulting list
        System.out.println(list);
    }
}
