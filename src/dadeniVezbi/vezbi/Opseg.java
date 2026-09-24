package dadeniVezbi.vezbi;

import java.util.Scanner;

/*Дадена е равенката: x2+s(x)+200·x=N каде што x, N се природни броеви, а s(x) е функција која што го дава збирот на цифри
на бројот x. Даден е и бројот N и два природни броеви A и B, каде што A≤B и A, B≤1,000,000,000. Потребно е да проверите дали
постои природен број x во опсегот [A, B] така што е задоволена равенката, и ако постои тогаш треба да се врати како резултат.
Ако таков природен број x во опсегот [A, B] што ја задоволува равенката не постои, тогаш се враќа -1.
 */
public class Opseg {
        public static int s(int x) {
            int tmp = x;
            int sum = 0;

            while (tmp > 0) {
                sum += tmp % 10;
                tmp = tmp / 10;
            }

            return sum;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(findXinRange(a, b, n));
        }

        public static int findXinRange(int a, int b, int n) {
            int t = a;
            int x = -1;

            while (t <= b) {
                int equation = (t * t) + s(t) + (200 * t);
                if (n == equation) {
                    x = t;
                    break;
                }
                t++;
            }

            return x;
        }
}
