package PrethodniIspitni._2023;

import book._04_OneDimensionalDataStructures.Stack.Zadaca9_IspitKnigi;
import dataStructures.ArrayStack;

import java.util.Scanner;

/*Додека Стефан ги потготвува испитите за полагање во jунска сесиjа, тоj има
навика да ги чува сите книги на еден куп, една врз друга. При пребарување на
дадена книга коjа му е потребна, тоj секогаш ги трга прво наjгорните, една по
една, се додека не jа земе книгата коjа му треба. Штом ´ке jа извади таа книга,
останатите кои биле над неа ги вра´ка во истиот редослед назад. Откако ´ке го
научи дадениот предмет, jа вра´ка книгата одозгора врз сите други.
Дадена е инициjалната поставеност на книгите на купот на Стефан (во редос-
лед одоздола нагоре). Дадени се и испитите по распоред на полагање за jунска
сесиjа. Ваша задача е да одредите колку пати секоjа од книгите ´ке биде извадена
и ставена назад на купот.
Влез: Во првата линиjа од влезот се дадени два броjа: М, броj на книги и N,
броj на испити.
Во втората линиjа од влезот се дадени имињата на книгите, подредени одоз-
дола нагоре.
Во третата линиjа од влезот се дадени испитите кои се полагаат по редослед.
Излез: На излез треба да се испечати за секоjа книга колку пати ´ке биде
земена и вратена назад на купот (еден „настан“ на земање-вра´кање на книгата
се брои еднаш, не два пати). Имињата на книгите се печатат во исти редослед
во коj биле дадени на влезот.
Пример:
Влез:
7 3
APS OS Мrezhi AOK Objektno Strukturno Kalkulus
APS Objektno Мrezhi
Излез: APS 3
OS 1
Мrezhi 2
AOK 2
Objektno 3
Strukturno 3
Kalkulus 3
Обjаснување: За да jа извадиме книгата за АПС, треба да ги извадиме и
вратиме назад сите останати книги во купот. Откако ´ке завршиме, jа вра´каме
наjгоре на купот. Наредно полагаме Обjектно, па за стигнеме до таа книга, треба
да ги тргнеме прво книгите за АПС, калкулус и структурно. Jа вра´каме книгата
за Обjектно наjодозгора. За да доjдеме до книгата за мрежи, треба да ги извадиме
и вратиме сите книги освен таа за ОС. На краj jа вра´каме книгата за мрежи
наjгоре.
Забелешка: Не може да има дупликати наслови на книги. Еден испит мо-
же да се поjави пове´ке пати. На излез имињата на книгите се печатат во исти
редослед во коj биле дадени на влезот.*/
public class Juni_2023_DopolnitelenDel_1_ispitiKnigi {
    // O(N x M) complexity
    public static class Book {
        private final String name;
        private int timesTaken;

        public Book(String name) {
            this.name = name;
            this.timesTaken = 0;
        }

        public String getName() {
            return name;
        }

        public void increaseTimesTaken() {
            timesTaken++;
        }

        @Override
        public String toString() {
            return name + " " + timesTaken;
        }
    }

    public static void solve(ArrayStack<Zadaca9_IspitKnigi.Book> books, String[] exams) {

        ArrayStack<Zadaca9_IspitKnigi.Book> temp = new ArrayStack<>(books.size());

        for (String exam : exams) {

            Zadaca9_IspitKnigi.Book wanted = null;

            // Remove books until we find the wanted one
            while (!books.isEmpty()) {

                Zadaca9_IspitKnigi.Book book = books.pop();

                if (book.getName().equals(exam)) {
                    wanted = book;
                    break;
                }

                temp.push(book);
            }

            // Return removed books in the same order
            while (!temp.isEmpty()) {
                Zadaca9_IspitKnigi.Book book = temp.pop();

                book.increaseTimesTaken();
                books.push(book);
            }

            // The wanted book was also taken once
            wanted.increaseTimesTaken();

            // After studying, put it on top
            books.push(wanted);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        ArrayStack<Zadaca9_IspitKnigi.Book> books = new ArrayStack<>(m);
        Zadaca9_IspitKnigi.Book[] originalOrder = new Zadaca9_IspitKnigi.Book[m];

        for (int i = 0; i < m; i++) {
            Zadaca9_IspitKnigi.Book book = new Zadaca9_IspitKnigi.Book(sc.next());

            books.push(book);
            originalOrder[i] = book;
        }

        String[] exams = new String[n];

        for (int i = 0; i < n; i++) {
            exams[i] = sc.next();
        }

        solve(books, exams);

        for (Zadaca9_IspitKnigi.Book book : originalOrder) {
            System.out.println(book);
        }
    }
}
