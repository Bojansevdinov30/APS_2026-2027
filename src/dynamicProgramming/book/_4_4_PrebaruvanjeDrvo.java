package dynamicProgramming.book;

import java.util.Scanner;

/*
Дадена е подредена низа 𝑘1, 𝑘2, … , 𝑘𝑛 од 𝑛 различни клучa. За секој
клуч 𝑘𝑖 ни е дадена веројатност 𝑝𝑖 дека тој ќе се пребарува.
Дозволено е да се пребаруваат и елементи кои не се во низата, па
206
така имаме и 𝑛 + 1 фиктивни клуча 𝑑0, 𝑑1, … , 𝑑𝑛 , кои ги
претставуваат вредностите кои не се во низата 𝑘1, 𝑘2, … , 𝑘𝑛, односно
ги претставуваат интервалите помеѓу два клуча. Така 𝑑0 ги
претставува сите вредности помали од 𝑘1 , 𝑑𝑛 ги претставува сите
вредности поголеми од 𝑘𝑛 и за i = 1, 2, . . . , n – 1, 𝑑𝑖 ги претставува
сите вредности меѓу 𝑘𝑖 и 𝑘𝑖+1. За секој фиктивен клуч 𝑑𝑖 дадена ни е
веројатност 𝑞𝑖 за пребарување на вредностите меѓу 𝑘𝑖 и 𝑘𝑖+1 . Од
овие клучеви треба да се изгради бинарно пребарувачко во кое секој
клуч 𝑘𝑖 е внатрешен јазол, а секој фиктивен клуч е лист. Секое
пребарување е или успешно (наоѓање на клуч 𝑘𝑖 ) или неуспешно
(наоѓање на фиктивен клучн 𝑑𝑖 ), па сумата од сите веројатности е
еднаква на 1, т.е.
∑ 𝑝𝑖
𝑛
𝑖=1
+ ∑ 𝑞𝑖
𝑛
𝑖=0
= 1.
Проблемот е да се најде вакво бинарно пребарувачко дрво за кое
просечниот број на чекори за пребарување во него биде најмал. Ова
ќе го нарекуваме цена на дрвото, па сакаме оваа цена да биде
најниска.
*/
public class _4_4_PrebaruvanjeDrvo {

    public static void printMatrix(float[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%.2f ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        float[] p = new float[n + 1];
        float[] q = new float[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scn.nextFloat();
        }
        for (int i = 0; i <= n; i++) {
            q[i] = scn.nextFloat();
        }

        float[][] A = new float[n + 2][n + 2];
        float[][] C = new float[n + 2][n + 2];
        float[][] w = new float[n + 2][n + 2];

        for (int i = 1; i <= n + 1; i++)
            A[i][i - 1] = w[i][i - 1] = q[i - 1];

        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                A[i][j] = Float.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                for (int r = i; r <= j; r++) {
                    float t = A[i][r - 1] + A[r + 1][j] +w[i][j];
                    if (t < A[i][j]) {
                        A[i][j] = t;
                        C[i][j] = r;
                    }

                }
            }
        }
        System.out.println("A");
        printMatrix(A);
        System.out.println("w");
        printMatrix(w);
        System.out.println("C");
        printMatrix(C);
    }

}
