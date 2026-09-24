package PrethodniIspitni._2021;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Juni_2021_Vlezna2_ModificiranjeLista {
    public static void delete(SLL<Integer> list1) {
        /*
        SLLNode<Integer> node1=list1.getFirst(),
                node2=node1.succ;


        while(node1!=null){
            int brojac=0;
            while(node2!=null){
                brojac=1;
                if(node1.element.equals(node2.element)){
                    brojac++;
                }
                node2=node2.succ;
            }

            if(brojac%2==0)
            {
                node2=list1.getFirst();
                while(node2!=null)
                {
                    list1.delete(node1);
                    node2=node2.succ;
                }
            }

            node1=node1.succ;
            if(node1!=null) node2=node1.succ;
        }*/
        SLLNode<Integer> node1 = list1.getHead(), node2 = node1.succ;
        while (node1 != null) {
            SLLNode<Integer> tmp = node1;
            int brojac = 0;
            node2 = list1.getHead();
            while (node2 != null) {

                if (node1.element.equals(node2.element)) {
                    //if(brojac>=2) brojac++;
                    //else brojac=2;
                    brojac++;
                }
                node2 = node2.succ;
            }

            if (brojac % 2 == 0 && brojac >= 2) {
                node2 = list1.getHead();
                while (node2 != null) {
                    if (node2.element.equals(tmp.element)) {
                        list1.delete(node2);
                    }
                    node2 = node2.succ;
                }
            }

            node1 = node1.succ;
            if (node1 != null) node2 = node1.succ;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }

        delete(list1);
        System.out.println(list1);
    }
}
