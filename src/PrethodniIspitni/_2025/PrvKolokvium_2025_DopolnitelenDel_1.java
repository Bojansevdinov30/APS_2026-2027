package PrethodniIspitni._2025;

import java.util.Scanner;

/*DP

Најди го бројот на wow поднизи во стринг

Input
wwoww
Output
4

Explanitaion:
w-ow-
w-o-w
-wow-
-wo-w

Input
ooooowwwwwoooo
Output
0

Input
woowow
Output
6

Начин:
wo-w--
wo---w
w-ow--
w-o--w
w---ow
---wow


----

*/
public class PrvKolokvium_2025_DopolnitelenDel_1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        long w = 0;
        long wo = 0;
        long wow = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == 'w') {
                wow += wo;
                w++;
            }
            else if (c == 'o') {
                wo += w;
            }
        }

        System.out.println(wow);
    }
}
