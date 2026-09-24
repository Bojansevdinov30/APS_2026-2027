package labs.Lab1;

import java.util.Scanner;

public class Lab1_ex6 {
    static void printInitials(String name) {
        name = name.toUpperCase();
        char[] inicijali = name.toCharArray();
        int zaPrv = 0;
        for (int i = 0; i < inicijali.length; i++) {
            if (inicijali[i] == ' ' && zaPrv == 0) {
                zaPrv++;
                System.out.print(inicijali[0] + "" + inicijali[i + 1]);
            } else if (inicijali[i] == ' ' && zaPrv != 0) {
                System.out.print(inicijali[i + 1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String name;
        input.nextLine();

        for (int i = 0; i < n; i++) {
            name = input.nextLine();
            printInitials(name);
            System.out.println();
        }
    }
}
