package PrethodniIspitni._2022;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/*Find all drivers who were caught speeding, attach the time of the violation,
sort those violations by time, and print the drivers in chronological order.*/
public class RandomZadaca4_mvrRadar {
    static class SpeedingTicket implements Comparable<SpeedingTicket> {
        public Driver driver;
        public String time;

        @Override
        public String toString() {
            return this.driver.name + " " + this.driver.lastName;
        }

        @Override
        public int compareTo(SpeedingTicket o) {
            return this.time.compareTo(o.time);
        }

    }

    static class Driver {
        String name;
        String lastName;

        public Driver(String name, String lastName) {
            super();
            this.name = name;
            this.lastName = lastName;
        }


    }

    public static void main(String[] args) throws IOException {
        ArrayList<SpeedingTicket> al = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] pom;
        int N = Integer.parseInt(s);
        CBHT<String, Driver> t = new CBHT<String, Driver>(2 * N + 1);
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            pom = s.split(" ");
            t.insert(pom[0], new Driver(pom[1], pom[2]));
        }
        s = br.readLine();
        int speedLimit = Integer.parseInt(s);
        s = br.readLine();
        pom = s.split(" ");
        String[] entry = new String[3];
        s = "";
        for (int i = 0; i < pom.length; s = "") {
            entry[0] = pom[i++];
            entry[1] = pom[i++];
            entry[2] = pom[i++];
            if (Integer.parseInt(entry[1]) > speedLimit) {
                SLLNode<MapEntry<String, Driver>> node = t.search(entry[0]);
                if (node != null) {
                    SpeedingTicket speedingTicketInstance = new SpeedingTicket();
                    speedingTicketInstance.driver = node.element.value;
                    speedingTicketInstance.time = entry[2];
                    al.add(speedingTicketInstance);
                } else {
                    //?
                }
            }
        }
        Collections.sort(al);
        al.forEach(u -> System.out.println(u));
    }
}
