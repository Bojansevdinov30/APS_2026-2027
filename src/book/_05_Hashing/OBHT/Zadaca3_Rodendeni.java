package book._05_Hashing.OBHT;

import dataStructures.MapEntry;
import dataStructures.OBHT;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*Дадена е листа од датуми на ра´гање на сите вработени во една организациjа.
Ваша задача е за даден датум да испечатите кои вработени на организациjата
´ке слават роденден тоj ден и колку години ´ке полнат (сортирани според името
на вработениот). Доколку за дадениот датум нема родендени да се испечати
„Empty”.
Влез: Во првиот ред од влезот е даден броjот на вработени 𝑁 , а во следните 𝑁
редови се дадени името и презимето на вработениот и датата на ра´гање (формат
dd/mm/yyyy) одделени со едно празно место. Во последниот ред е даден датумот
за коj треба да испечатите кои лу´ге слават роденден на тоj датум.
Излез: Името на вработениот и колку години полни, сортирани според името
на вработениот.
Пример 1:
Влез:
3
Ivana Ivanovska 15/05/1982
Elena Todorovska 30/05/1984
Maja Petrevska 15/05/1986
15/05/2023
Излез:
Ivana Ivanovska 41
Maja Petrevska 37
Пример 2:
Влез:
4
Ivana Ivanovska 15/05/1982
Elena Todorovska 30/05/1984
Maja Petrevska 15/05/1986
Stefan Stefanovski 30/05/1975
15/04/2023
Излез:
Empty*/
public class Zadaca3_Rodendeni {
    static class Employee implements Comparable<Employee> {

        String name;
        String surname;
        String dateB;

        public Employee(String name, String surname, String dateB) {
            super();
            this.name = name;
            this.surname = surname;
            this.dateB = dateB;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getDateB() {
            return dateB;
        }

        public void setDatrB(String dateB) {
            this.dateB = dateB;
        }

        @Override
        public int compareTo(Employee o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return this.name + " " + this.surname;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String, ArrayList<Employee>> hashtable = new OBHT<String, ArrayList<Employee>>(2 * N);
        String input;

        for (int i = 1; i <= N; i++) {

            input = br.readLine();
            String[] elems = input.split(" ");
            Employee emp = new Employee(elems[0], elems[1], elems[2]);
            String key = elems[2].substring(0, 5);

            if (hashtable.search(key) != -1) {
                MapEntry<String, ArrayList<Employee>> result =
                        hashtable.getBucket(hashtable.search(key));
                ArrayList<Employee> array = result.getValue();
                array.add(emp);
                hashtable.insert(key, array);


            } else {
                ArrayList<Employee> a = new ArrayList<Employee>();
                a.add(emp);
                hashtable.insert(key, a);
            }
        }
        String dateIn = br.readLine();
        String date = dateIn.substring(0, 5);
        int yearIn = Integer.parseInt(dateIn.substring(6, 10));

        if (hashtable.search(date) != -1) {
            MapEntry<String, ArrayList<Employee>> result = hashtable.getBucket(hashtable.search(date));
            ArrayList<Employee> niza = result.getValue();
            Employee[] p = new Employee[niza.size()];
            for (int i = 0; i < p.length; i++)
                p[i] = niza.get(i);
            Arrays.sort(p);
            for (int i = 0; i < p.length; i++) {
                int year = Integer.parseInt(p[i].getDateB().substring(6, 10));
                System.out.println(p[i].toString() + " " + (yearIn - year));
            }
        } else {
            System.out.println("Empty");
        }

    }
}
