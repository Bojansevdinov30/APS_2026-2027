package book._01_Introduction;

/*
 * Nekoi pravila:
 *
 * System.out.print e isto so System.out.println, samo println stava nov red
 * na kraj.
 *
 * Za citanje se koristi import java.util.Scanner, sto na pocetok se
 * deklarira kako Scanner input = new Scanner(System.in). Potoa se koristat
 * input.nextInt(), input.nextShort(), input.nextDouble() itn.
 *
 * Kod so generici:
 *
 * Namesto List list = new ArrayList(), koristime
 * List<String> list = new ArrayList<String>().
 *
 * Genericka klasa moze da se deklarira so public class Box<T> {}.
 *
 * Pri nasleduvanje vazno e tipovite vo <> da se isti. Znakot ? e dzoker za
 * nepoznat tip na podatok i ne moze da se koristi pri povik na genericki
 * metod. Pristapuvanje do elementi kako Object e sigurno, a ogranicuvanje
 * pri nasleduvanje se pravi so extends.
 */
public final class IntroductionNotes {
    public static int stepen1(int n, int k) {
        // O(n) recursion complexity
        if (k == 0) return 1;
        else {
            return n * stepen1(n, k - 1);
        }
    }

    public static int stepen2(int n, int k) {
        // O(logn) recursion complexity
        // eden call(n/2) dava logn ako sekoj od tie callovi e O(1)
        if (k == 0) return 1;
        else if (k % 2 == 0) {
            return stepen2(n * n, k / 2);
        } else {
            return n * stepen2(n * n, (k - 1) / 2);
        }
    }

    public static int stepen3(int n, int k) {
        // O(n) recursion complexity
        if (k == 0) return 1;

        else if (k % 2 == 0) {
            return stepen3(n, k / 2) * stepen3(n, k / 2);
        } else {
            return n * stepen3(n * n, (k - 1) / 2) * stepen3(n * n, (k - 1) / 2);
        }

    }

    private IntroductionNotes() {
    }
}
