package labs.Lab3;

import java.util.Scanner;

/* Во една скоро сортирана низа, да се најде елемент којшто НЕ е сортиран и да се отпечати колку елементи
   се такви во низата. Исто така, за секој out-of-order број во низата, да се каже колку места треба да се
   помести, за да биде низата сортирана. Пример:

   Input:
   8
   1 3 4 5 2 6 8 7

   Output:
   2 elements are out-of-order!
   Element "2" has to be shifted 3 positions!
   Element "7" has to be shifted 1 positions!

   */
public class Zadaca1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] niza = new int[n];
        for (int i = 0; i < n; i++) {
            niza[i] = input.nextInt();
        }
        int counter = 0;
        for (int i = 1; i < n; i++) {
            if (niza[i] < niza[i - 1]) {
                counter++;
            }
        }
        System.out.println(counter + " elements are out-of-order!");
        boolean flag = true;
        int x = 0;
        for (int i = 1; i < n; i++) {
            if (niza[i] < niza[i - 1]) {
                flag = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (niza[i] < niza[j]) {
                        x++;
                    }
                }
            }
            if (flag == false) {
                System.out.println("Element " + niza[i] + " has to be shifted " + x + " positions!");
            }
            flag = true;
            x = 0;
        }
    }
}