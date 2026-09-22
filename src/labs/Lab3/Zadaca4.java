package labs.Lab3;

import java.util.Arrays;
import java.util.Scanner;

/*Given a road of length M and N available lamps. The position of each lamp on the road is given. Each lamp illuminates the part
of the road within distance 2 from its position. Find the minimum number of lamps needed to illuminate the entire road. If it is
impossible to illuminate the entire road, print -1.
For example, if the road positions are:
0 1 2 3 4 5 6 7 8 9
and a lamp is at position 4, it illuminates:
2 3 4 5 6
because it covers distance 2 to the left and right.
The goal is therefore:
Cover the whole road using as few lamps as possible.*/
public class Zadaca4 {
    public static int solve(int[] lights, int n, int length) {

        Arrays.sort(lights);

        // Convert positions from 1-based to 0-based
        for (int i = 0; i < n; i++) {
            lights[i]--;
        }

        int nextUncovered = 0;
        int i = 0;
        int numberOfLights = 0;

        while (nextUncovered < length) {

            int bestPosition = -1;

            // Find the furthest lamp that can cover nextUncovered
            while (i < n && lights[i] - 2 <= nextUncovered) {
                bestPosition = lights[i];
                i++;
            }

            // No lamp can cover the next uncovered position
            if (bestPosition == -1) {
                return -1;
            }

            // This lamp covers up to bestPosition + 2
            nextUncovered = bestPosition + 3;

            numberOfLights++;
        }

        return numberOfLights;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] lights = new int[n];

        for (int i = 0; i < n; i++) {
            lights[i] = sc.nextInt();
        }

        System.out.println(solve(lights, n, m));
    }
}
