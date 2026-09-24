package PrethodniIspitni._2026;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Vlezna Ispit January 2026 prv termin
Call centar chuva dnevnik od izvrsheni povici, i operatori koi gi izvrshile povicite, ima n zapisi, m operatori, zapisite se vo format:
"call (br na telefon)" - oznacuva dodavanje na povik vo redica na chekanje, "start (operator)" - oznachuva operator zapocnuva so
povik od redicata, "end (operator)" - operatorot zavrshuva so povikot, "status", dokolku se vnese status da se ispechati vo momentot
kolku chekaat vo redica za povik, i da se ispechati kolku operatori vo momentot rabotat

primer
INPUT:
12 2
call 123
call 223
call 345
start op1
call 456
start op2
status
call 67
end op 1
status
end op 2
status

OUTPUT:
status:
busy operators: 2
clients waiting: 2

status:
busy operators:1
clients waiting: 3

status:
busy operators: 0
clients waiting: 3*/
public class Januari_2026_Vlezna_1gr_OperatoriIKlienti {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<String> clients = new LinkedList<>();

        HashMap<String, Boolean> operators = new HashMap<>();

        // Initially, all operators are free
        for (int i = 1; i <= m; i++) {
            operators.put("op" + i, false);
        }

        for (int i = 0; i < n; i++) {

            String command = sc.next();

            if (command.equals("call")) {

                String phone = sc.next();

                // Add client to the waiting queue
                clients.add(phone);

            } else if (command.equals("start")) {

                String operator = sc.next();

                // Operator takes the first client from the queue
                clients.remove();

                // Operator becomes busy
                operators.put(operator, true);

            } else if (command.equals("end")) {

                String operator = sc.next();

                // Operator becomes free
                operators.put(operator, false);

            } else if (command.equals("status")) {

                int busyOperators = 0;

                for (boolean busy : operators.values()) {
                    if (busy) {
                        busyOperators++;
                    }
                }

                System.out.println("status:");
                System.out.println("busy operators: " + busyOperators);
                System.out.println("clients waiting: " + clients.size());
                System.out.println();
            }
        }
    }
}
