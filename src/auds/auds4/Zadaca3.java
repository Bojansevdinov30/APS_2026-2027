package auds.auds4;

/* Algoritam za najdolga zaednicka podsekvenca vo dva stringa i koja e nejzinata dolzina i koja e taa sekvenca
 */
public class Zadaca3 {

    public static int[][] lengthsArray(String x, String y) {
        int n = x.length();
        int m = y.length();
        int[][] lcs = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            lcs[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs;

    }


    public static int longestCommonSequenceLength(String x, String y) {
        return lengthsArray(x, y)[x.length()][y.length()];
    }

    public static String longestCommonSequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        int[][] lcs = lengthsArray(x, y);
        char[] result = new char[Math.max(n, m)];
        int len = 0, i = n, j = m;

        while (i != 0 && j != 0){
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                result[len] =  x.charAt(i - 1);
                len++;
                i--;
                j--;
            }else{
                if(lcs[i][j] == lcs[i-1][j]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        String finalResult = "";
        for (int k = 0; k < len; k++){
            finalResult += result[len - k - 1];
        }
        return finalResult;


    }

    public static void main(String[] args) {
        String x = "ggcaccacg";
        String y = "acggcggatacg";

        System.out.println(longestCommonSequenceLength(x, y));
        System.out.println(longestCommonSequence(x, y));

    }
}
