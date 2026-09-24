package PrethodniIspitni._2024;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

/*Дадена е двострано поврзана листа чии што јазли содржат по еден природен број. Листата треба да се подели на две резултантни листи, т.ш. во првата листа треба да се сместат сите јазли кои содржат броеви помали или еднакви на просекот на листата, а во втората сите јазли кои содржат броеви поголеми од просекот на листата. Јазлите во резултантните листи се додаваат според обратен редослед од оној по кој по кој се појавуваат во дадената листа (т.е. прво се започнува со разгледување на последниот јазол од влезната листа и се додава во соодветната резултантна листа, па претпоследниот итн...).

Во првиот ред од влезот е даден бројот на јазли во листата, а во вториот ред се дадени броевите од кои се составени јазлите по редослед во листата. Во првиот ред од излезот треба да се испечатат јазлите по редослед од првата резултантна листа (броеви помали или еднакви на просекот на листата), во вториот ред од втората (броеви поголеми од просекот на листата) .

Име на класа (за Java): PodeliListaProsek

Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.

Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.
Sample input
5
4 2 1 5 3
Sample output
3 1 2
5 4*/
public class RandomZadaca1_PodeliListaProsek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        DLL<Integer> list = new DLL<>();

        String[]parts = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++){
            list.insertLast(Integer.parseInt(parts[i]));
        }
        PodeliListaProsek(list, n);

    }
    public static void PodeliListaProsek(DLL<Integer> list, int n){
        float avg = 0;
        DLLNode<Integer> tmp = list.getFirst();
        DLL<Integer> pomali = new DLL<>();
        DLL<Integer> pogolemi = new DLL<>();

        while (tmp != null){
            avg += tmp.getElement();
            tmp = tmp.getSucc();
        }

        avg = avg / n;

        tmp = list.getLast();
        while (tmp != null){
            if (tmp.getElement() <= avg){
                pomali.insertLast(tmp.getElement());
            }
            else {
                pogolemi.insertLast(tmp.getElement());
            }
            tmp = tmp.getPred();
        }

        System.out.println(pomali);
        System.out.println(pogolemi);
    }
}
