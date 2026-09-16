package book._05_Hashing.OBHT;

import java.io.*;
import java.text.*;
import java.util.*;

/*Обjавен е распоред на испитна сесиjа на ФИНКИ. Во него се дадени датуми,
време на почеток, имиња на предмети и простории. Ваша задача е за даден датум
да испечатите кои испити се полагаат на тоj датум (со сите нивни детали).
Влез: Во првиот ред од влезот е даден броjот на испити 𝑁 , а во следните
𝑁 реда се дадени датум и време на полагањето (формат dd/mm/yyyyhh:mm),
просториjата и името на испитот. Во последниот ред е даден датумот за коj
треба да испечатите кои испити се полагаат тоj датум.
Излез: Деталите на испитите за тоj датум, сортирани според времето на
почеток на испитот.
Пример:
Влез:
5
27/01/2016 14:00 Rooms Kalkulus 1/Matematika 1
27/01/2016 08:00 Laboratories Napredno programiranje
28/01/2016 08:00 Laboratories Algoritmi i podatochni strukturi
28/01/2016 14:00 Rooms Diskretna matematika 1
28/01/2016 09:00 315 Kalkulus 3
28/01/2016
Излез:
08:00 Laboratories Algoritmi i podatochni strukturi
09:00 315 Kalkulus 3
14:00 Rooms Diskretna matematika 1
*/
public class Zadaca10_IspitnaSesija {
    static class Exam implements Comparable<Exam> {
        String name;
        Date time;
        String room;
        String date;

        Exam(String name, Date time, String room, String date) {
            this.name = name;
            this.time = time;
            this.room = room;
            this.date = date;
        }

        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // морам вака за да му кажам дека сакам само часовите и минутите
            return sdf.format(time) + " " + room + " " + name;
        }

        @Override
        public int compareTo(Exam o) {
            return this.time.compareTo(o.time);
        }

    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Exam>> exams = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // вака за да знае што да чита

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ", 4); // најмногу 4 - 1 пати ќе го подели
            String date = tokens[0];
            Date time = sdf.parse(tokens[1]); // треба помошничето да му испарсира
            String room = tokens[2];
            String name = tokens[3];
            Exam exam = new Exam(name, time, room, date);
            if (!exams.containsKey(date)) {
                exams.put(date, new ArrayList<>());
                exams.get(date).add(exam);
            } else exams.get(date).add(exam);
        }

        String query = br.readLine();
        Collections.sort(exams.get(query));
        for (Exam exam : exams.get(query)) {
            System.out.println(exam.toString());
        }

        // Во задачава штосот беше како да го читаме влезот.
        // Фала богу има прекрасна функција .split(String regex, int limit)
        // којашто ни овозможува да го цепкаме стрингот одреден број пати.
        // Кога го внесувам int limit, јас и кажувам на split функцијата
        // да го цепка стрингот limit - 1 пати, овозможувајќи ми
        // да го задржам како што треба името на предметот
        // (името на предметот има празни места пр. Калкулус 1)

    }


}
// ili vaka
/*import java.util.*;

class Exam implements Comparable<Exam> {
    String time;
    String room;
    String subject;

    public Exam(String time, String room, String subject) {
        this.time = time;
        this.room = room;
        this.subject = subject;
    }

    @Override
    public int compareTo(Exam other) {
        return this.time.compareTo(other.time);
    }

    @Override
    public String toString() {
        return time + " " + room + " " + subject;
    }
}

public class ExamSchedule {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, ArrayList<Exam>> schedule = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ", 4);

            String date = parts[0];
            String time = parts[1];
            String room = parts[2];
            String subject = parts[3];

            Exam exam = new Exam(time, room, subject);

            if (!schedule.containsKey(date)) {
                schedule.put(date, new ArrayList<>());
            }

            schedule.get(date).add(exam);
        }

        String wantedDate = sc.nextLine();

        ArrayList<Exam> exams = schedule.get(wantedDate);

        if (exams != null) {
            Collections.sort(exams);

            for (Exam exam : exams) {
                System.out.println(exam);
            }
        }
    }
}
*/