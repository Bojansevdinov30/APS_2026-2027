package auds.auds3;

/*
Студент се спрема да оди на патување.
Дозволено му е да носи еден куфер со
максимална тежина од 20 кг. Студентот се
двоуми помеѓу облека, книги и друштвени
игри. Откако ги измерил и оценил овие работи,
студентот ја добил следната табела:
# Објект Вредност Тежина
1 Облека 200 10
2 Книги 150 20
3 Монопол, карти… 5 0.5
4 CD player, MP3 player… 80 5
Што да понесе студентот, така што вредноста
на понесените работи да биде максимална?
• Постојат две верзии на овој проблем:
– Fractional knapsack проблем: Студентот може да
земе делови од објекти односно може да се одлучи
да понесе само еден дел xi од објектот оi, каде 0 ≤ xi
≤ 1.
– 0-1 knapsack проблем: проблемот е исто поставен,
но објектите не можат да се поделат на помали
делови, така што студентот ќе мора да се одлучи
дали ќе го земе објектот или не. Значи не може да
земе само дел од објектот (xi =0 или xi =1).
*/
public class Zadaca1 {
    // fractional so greedy, 0/1 so dinamicko

    private static void sort(int[] p, int[] w, int n) {
        int tmpP, tmpW;
        float ratioI, ratioJ;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ratioI = (float) p[i] / w[i];
                ratioJ = (float) p[j] / w[j];
                if (ratioI < ratioJ) {
                    tmpP = p[i];
                    p[i] = p[j];
                    p[j] = tmpP;
                    tmpW = w[i];
                    w[i] = w[j];
                    w[j] = tmpW;
                }
            }
        }
    }

    public static float fractionalKnapsack(int[] p, int[] w, float C, int n, float[] x) {
        sort(p, w, n);
        float profit = 0;
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (C > w[i]) {
                C -= w[i];
                profit += p[i];
                x[i] = 1;
            } else {
                profit += (C / (float) w[i]) * p[i];
                x[i] = (C / (float) w[i]);
                C = 0;
                break;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        float C = 20;    // C - capacity
        int n = 3;      // n - broj na predmeti
        int[] p = {25, 24, 15};    // p[] profits
        int[] w = {18, 15, 10};    // w[] weights
        float[] x = new float[3];    // x[] vektor resenie

        System.out.println(fractionalKnapsack(p, w, C, n, x));
    }

}
