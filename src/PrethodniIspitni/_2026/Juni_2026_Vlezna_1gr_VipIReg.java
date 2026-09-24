package PrethodniIspitni._2026;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*Испит Јуни - влезна задача - прва група

Има ticket office со 2 редици: VIP и Regular. Оние кои чекаат во VIP редица секогаш се услужуваат пред оние во Regular,
во редоследот по кој се дојдени. Во првиот ред се внесува број N кој означува колку вкупно команди се внесуваат.
Команди:
arrive <id> REG: доаѓа човек со ID <id> во Regular queue
arrive <id> VIP: доаѓа човек со ID <id> во VIP queue
status: покажува колку луѓе чекаат за услуга по редослед како ќе бидат услужени во формат Waiting: <id1> <id2> ..., ако нема никој во
queue печати Waiting: empty
serve: го услужува првиот кој е на ред во редицата, принта во формат Serving: <id>, ако нема никој принта Serving: empty

Пример:

Input:
9
arrive 101 REG
arrive 102 VIP
arrive 103 REG
status
serve
arrive 104 VIP
status
serve
serve

Output:
Waiting: 102 101 103
Serving: 102
Waiting: 104 101 103
Serving: 104
Serving: 101*/
public class Juni_2026_Vlezna_1gr_VipIReg {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> vip = new ArrayDeque<>();
        Queue<Integer> regular = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            String command = sc.next();

            if (command.equals("arrive")) {

                int id = sc.nextInt();
                String type = sc.next();

                if (type.equals("VIP")) {
                    vip.offer(id);
                } else {
                    regular.offer(id);
                }

            } else if (command.equals("serve")) {

                if (!vip.isEmpty()) {

                    System.out.println("Serving: " + vip.poll());

                } else if (!regular.isEmpty()) {

                    System.out.println("Serving: " + regular.poll());

                } else {

                    System.out.println("Serving: empty");
                }

            } else if (command.equals("status")) {

                if (vip.isEmpty() && regular.isEmpty()) {

                    System.out.println("Waiting: empty");

                } else {

                    System.out.print("Waiting:");

                    for (int id : vip) {
                        System.out.print(" " + id);
                    }

                    for (int id : regular) {
                        System.out.print(" " + id);
                    }

                    System.out.println();
                }
            }
        }
    }
}
