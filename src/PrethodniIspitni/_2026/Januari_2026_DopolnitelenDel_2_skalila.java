package PrethodniIspitni._2026;

import java.math.BigInteger;
import java.util.Scanner;

/*2. Даден е цел број N. Се наоѓате на скалило 0 и треба да стигнете до скалило N. Во еден чекор можете да се поместите: 1) за 1 скалило, или 2) за 2 скалила. Да се пресмета бројот на различни начини на кои може да се стигне до скалило N.

Влез: Еден цел број N (0 ≤ N ≤ 10^7)

Излез: Испечати еден цел број — бројот на начини да се стигне до скалило N.

Пример

Влез: 5

Излез: 8*/
// zadacava e kako fibonaci da resavas
public class Januari_2026_DopolnitelenDel_2_skalila {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 0) {
            System.out.println(1);
            return;
        }

        BigInteger prev2 = BigInteger.ONE;
        BigInteger prev1 = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {

            BigInteger current = prev1.add(prev2);

            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}
