package auds.auds5;

import dataStructures.ArrayQueue;

import java.util.Scanner;

/*Да се одреди колку работно време (во
минути) е потребно на студентската служба
за да ги опслужи студентите кои не биле
опслужени за тој ден.*/
public class Zadaca4_StudentskaSluzba2 {
    static class Student {
        String index;
        int minutes;

        Student(String index, int minutes) {
            this.index = index;
            this.minutes = minutes;
        }
    }

    static int minutesNeededForStudents(ArrayQueue<Student> studentsQueue) {
        int minutes = 0;
        Student tempStudent = studentsQueue.peek();
        while (tempStudent != null) {
            minutes += tempStudent.minutes;
            studentsQueue.dequeue();
            tempStudent = studentsQueue.peek();
        }
        return minutes;
    }

    public class StudentServiceQueue {
        static Zadaca3_StudentskaSluzba.Student iterateStudentsQueue(ArrayQueue<Zadaca3_StudentskaSluzba.Student> studentsQueue) {
            int minutes = 180;
            Zadaca3_StudentskaSluzba.Student tempStudent = studentsQueue.peek();
            while (tempStudent != null) {
                if (minutes < tempStudent.minutes) {
                    break;
                } else {
                    minutes -= tempStudent.minutes;
                    studentsQueue.dequeue();
                }
                tempStudent = studentsQueue.peek();
            }
            return tempStudent;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vnesi broj na studenti");
            int n = scanner.nextInt();
            ArrayQueue<Zadaca3_StudentskaSluzba.Student> studentsQueue = new ArrayQueue<Zadaca3_StudentskaSluzba.Student>(n);
            for (int i = 0; i < n; i++) {
                System.out.println("Vnesi index na studentot");
                String index = scanner.nextLine();
                System.out.println("Vnesi minuti potrebni za opsluzuvanje na studentot");
                int minutes = scanner.nextInt();
                Zadaca3_StudentskaSluzba.Student student = new Zadaca3_StudentskaSluzba.Student(index, minutes);
                studentsQueue.enqueue(student);
            }
            Zadaca3_StudentskaSluzba.Student student = iterateStudentsQueue(studentsQueue);
            if (studentsQueue.isEmpty()) {
                System.out.println("Opsluzeni se site studenti");
            } else {
                System.out.println("Prviot student sto nema da e opsluzen e: " + student.index);
                System.out.println("Broj na studenti koi ne se opsluzeni za deneska: " + studentsQueue.getLength());
            }
        }
    }

}
