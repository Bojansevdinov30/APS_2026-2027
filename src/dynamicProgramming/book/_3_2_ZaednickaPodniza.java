package dynamicProgramming.book;

import java.util.*;

/* Подниза на дадена низа се добива со изоставање на нула или повеќе
елементи. Формално, за дадена низа 𝑋 = (𝑥1, 𝑥2, ⋯ 𝑥𝑚), друга низа
𝑍 = (𝑧1, 𝑧2, ⋯ 𝑧𝑛) е подниза, ако постои една строго растечка низа
( 𝑖1, 𝑖2, ⋯ 𝑖𝑘) од индексите на 𝑋 такви што за сите 𝑗 = 1, 2, . . . , 𝑘 ,
имаме 𝑥𝑖𝑗 = 𝑧𝑗 . На пример, 𝑍 = (𝐵, 𝐶, 𝐷, 𝐵) е подниза на 𝑋 =
(𝐴, 𝐵, 𝐶, 𝐷, 𝐴, 𝐵), каде соодветната низа од индекси на 𝑋 кои се во 𝑍
е 2, 3, 5, 7. За две дадени низи 𝑋 и 𝑌 , велиме дека низата 𝑍 е
заедничка подниза на 𝑋 и 𝑌 ако е подниза и на двете низи 𝑋 и 𝑌. На
пример, ако 𝑋 = (𝐴, 𝐵, 𝐶, 𝐷, 𝐴, 𝐵) и 𝑌 = ( 𝐵, 𝐷, 𝐶, 𝐵, 𝐴, 𝐵) , низата
(𝐵, 𝐶, 𝐴)е заеднички подниза и на двете, но не е најдполгата, бидејќи
има должина 3. Низата (𝐵, 𝐶, 𝐵, 𝐴) e исто така заедничкa за двете
низи 𝑋 и 𝑌 и има должина 4 и бидејќи не постои заедничка подниза
со должина 5 или поголема, таа е најдолга заедничка подниза. Во
проблемот за најдолга заедничка подниза за две низи треба да ја
најдеме нивната заедничка најдолга подниза.
*/
public class _3_2_ZaednickaPodniza {


    public static void lcs(String a, String b) {
        int[][] A = new int[a.length() + 1][b.length() + 1];
        // pravata redica i prvata kolona vekje se inicijalizirani na 0

        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    A[i + 1][j + 1] = A[i][j] + 1;
                else
                    A[i + 1][j + 1] = Math.max(A[i + 1][j], A[i][j + 1]);

        System.out.println(A[a.length()][b.length()]);
        String result = "";
        for (int x = a.length(), y = b.length(); x != 0 && y != 0; ) {
            if (a.charAt(x - 1) == b.charAt(y - 1)) {
                result = a.charAt(x - 1) + result;
                x--;
                y--;
            } else if (A[x][y] == A[x][y - 1])
                y--;
            else if (A[x][y] == A[x - 1][y])
                x--;
        }

        System.out.println(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        lcs(scanner.next(), scanner.next());
    }

}
