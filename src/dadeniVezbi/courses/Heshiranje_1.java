package dadeniVezbi.courses;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Heshiranje_1 {
    public static class Customer {
        String name;
        String lastname;
        int budget;
        String ipAddress;
        String time;
        String city;
        int price;
        int count;

        public Customer(String name, String lastname, int budget, String ipAddress, String time, String city, int price) {
            this.name = name;
            this.lastname = lastname;
            this.budget = budget;
            this.ipAddress = ipAddress;
            this.time = time;
            this.city = city;
            this.price = price;
            this.count = 1;
        }

        public void updateCount() {
            this.count += 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        CBHT<String, Customer> hashtable = new CBHT<>(n * 2);

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String lastname = sc.next();
            int budget = sc.nextInt();
            String ipAddress = sc.next();
            String time = sc.next();
            String city = sc.next();
            int price = sc.nextInt();
            sc.nextLine();

            Customer c = new Customer(name, lastname, budget, ipAddress, time, city, price);
            SLLNode<MapEntry<String, Customer>> node = hashtable.search(city);


            int cHours = Integer.parseInt(c.time.split(":")[0]);
            int cMinutes = Integer.parseInt(c.time.split(":")[1]);

            if (cHours > 11) {
                if (node == null) {
                    hashtable.insert(city, c);
                } else {
                    String nTime = node.getElement().getValue().time;
                    int pHours = Integer.parseInt(nTime.split(":")[0]);
                    int pMinutes = Integer.parseInt(nTime.split(":")[1]);
                    if (cHours < pHours || (cHours == pHours && cMinutes < pMinutes)) {
                        c.count = node.getElement().getValue().count + 1;
                        hashtable.insert(city, c);
                    } else {
                        hashtable.search(city).getElement().getValue().updateCount();
                    }
                }
            }
        }

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String name = sc.next();
            String lastname = sc.next();
            int budget = sc.nextInt();
            String ipAddress = sc.next();
            String time = sc.next();
            String city = sc.next();
            int cena = sc.nextInt();
            sc.nextLine();

            Customer c = new Customer(name, lastname, budget, ipAddress, time, city, cena);
            SLLNode<MapEntry<String, Customer>> node = hashtable.search(city);

            System.out.println("City: " + city + " has the following number of customers:");
            System.out.println(node.getElement().getValue().count);

            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(node.getElement().getValue().name + " " + node.getElement().getValue().lastname + " with salary " + node.getElement().getValue().budget + " from address " + node.getElement().getValue().ipAddress + " who logged in at " + node.getElement().getValue().time);
            System.out.println();
        }
    }

}
