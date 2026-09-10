package auds.auds3;

/*Robot na Mars, sobira sto e mozno poveke kamenja. Povrsinata e MxN dimenzionalna, i vo sekoj kvadrat e oznacen brojot na
kamenja. Robotot trga od gore levo i zavrsuva dole desno. i odi samo desno i dole.
*/
public class Zadaca8 {

    public static int maxRocks(int m, int n, int[][] rocks) {
        int[][] result = new int[m][n];
        result[0][0] = rocks[0][0];
        for (int j = 1; j < n; j++) {
            result[0][j] = result[0][j - 1] + rocks[0][j];
        }

        for (int i = 1; i < m; i++) {
            result[i][0] = result[i - 1][0] + rocks[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = Math.max(rocks[i-1][j],  result[i][j-1]) +  rocks[i][j];
            }
        }
        return result[m-1][n-1];

    }

    public static void main(String[] args) {
        int m = 5;
        int n = 3;
        int[][] initial = {{1, 2, 4}, {34, 5, 67}, {2, 2, 2}, {10, 20, 4}, {1, 98, 4}};
        System.out.println(maxRocks(m, n, initial));
    }

}
