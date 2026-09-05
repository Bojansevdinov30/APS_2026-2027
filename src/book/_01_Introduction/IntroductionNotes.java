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

    private IntroductionNotes() {
    }
}
