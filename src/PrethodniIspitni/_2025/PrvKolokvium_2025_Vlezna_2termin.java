package PrethodniIspitni._2025;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

/*SLL - Влезна задача

Се внесува број на стрингови, се печати низата пред промени, секој стринг што почнува со мала буква се преместува на
 крајот од листата, и па се печате листата

Input
4
ova
Eden
Zdravo
hawaii

Output
ova -> Eden -> Zdravo -> hawaii
Eden -> Zdravo -> ova -> hawaii*/
public class PrvKolokvium_2025_Vlezna_2termin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<String> niza = new SLL<>();
        for(int i = 0 ; i < N ; i++) {
            niza.insertLast(sc.next());
        }
        System.out.println(niza);
        SLLNode<String> jazol = niza.getHead();
        for(int i = 0 ; i < N;i++){
            SLLNode<String> tmp = jazol;
            if(Character.isLowerCase(jazol.getElement().charAt(0))){
                niza.insertLast(jazol.getElement());
                niza.delete(jazol);
                jazol = tmp.getSucc();
            }
            else{
                jazol = jazol.getSucc();
            }
        }
        System.out.println(niza);
    }
}
