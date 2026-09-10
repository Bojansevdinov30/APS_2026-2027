package dynamicProgramming.book;

import java.util.*;

/*
Група од 𝑛 > 1 деца наредени во редица и фатени за рака играат оро.
На почеток едно од децата е на чело на орото, но во текот на
играњето последниот од орото доаѓа на почеток односно станува
ороводец, а другите не се менуваат. За орото да биде поинтересно,
децата треба да се облечат во маички во 𝑚 > 1 различни бои и треба
да се наредат така да за цело време додека трае играњето нема две
деца едно до друго во маички од иста боја. На колку различни
начини може децата да се распределат на почеток? Ако бројот на
начини на прераспределување е голем, треба да се испечати по
модул 100000007.
*/
public class _2_4_SharenoOro {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // children
        int m = scn.nextInt(); // colors

        int[] A = new int[n + 1]; // number of valid ways to color i
        int[] B = new int[n + 1]; // number of ways to color i children in a normal line, where adjacent children have different colors.

        A[2] = B[2] = m * (m - 1);

        for (int i = 3; i <= n; i++) {
            B[i] = (B[i - 1] * (m - 1)) % 100000007;
            A[i] = (B[i] - A[i - 1] + 100000007) % 100000007;
        }

        System.out.println(A[n]);
    }

}
