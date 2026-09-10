package auds.auds3;

/*
Najdi dva najmali elementi vo niza so razdeli pa vladej
*/
public class Zadaca6 {

    public static class TwoSmallest {
        private int a; // a < b
        private int b;

        public TwoSmallest() {

        }

        public TwoSmallest(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    public static TwoSmallest findTwoSmallest(int[] array, int l, int r) {
        if (l == r) {
            return new TwoSmallest(array[l], Integer.MAX_VALUE);
        }
        int mid = (l + r) / 2;
        TwoSmallest r1 = findTwoSmallest(array, l, mid);
        TwoSmallest r2 = findTwoSmallest(array, mid + 1, r);

        TwoSmallest result = new TwoSmallest();
        if (r1.getA() < r2.getA()) {
            result.setA(r1.getA());
            if (r1.getB() < r2.getA()) {
                result.setB(r1.getB());
            } else {
                result.setB(r2.getA());
            }

        } else {
            result.setA(r2.getA());
            if (r2.getB() < r1.getA()) {
                result.setB(r2.getB());
            } else {
                result.setB(r1.getA());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {9, 2, 4, 6, 12, 8, 7, 3, 1, 5};

        TwoSmallest tsm = findTwoSmallest(array, 0, array.length - 1);
        System.out.println(tsm.getA() + " " + tsm.getB());
    }

}
