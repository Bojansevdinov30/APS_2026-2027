package PrethodniIspitni._2022;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Januari_2022_Vlezna2_Task {
    static class Task {
        private int id;
        private int hours;
        private int priority;

        public Task(int id, int hours, int priority) {
            this.id = id;
            this.hours = hours;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getHours() {
            return hours;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

    public static void work(SLL<Task> toDo, SLL<Task> inProgress) {
        SLLNode<Task> nodeToDo = toDo.getHead(),
                nodeInProgress = inProgress.getHead();

        SLLNode<Task> mostImportantTodo = toDo.getHead();


        int maxImportanceToDo = nodeToDo.element.getHours() * nodeToDo.element.getPriority() * 2;
        int minImportanceInProgress = nodeInProgress.element.getHours() * nodeInProgress.element.getPriority() * 2;

        nodeInProgress = nodeInProgress.succ;
        nodeToDo = nodeToDo.succ;
        while (nodeToDo != null) {
            if (maxImportanceToDo < nodeToDo.element.getHours() * nodeToDo.element.getPriority() * 2) {
                maxImportanceToDo = nodeToDo.element.getHours() * nodeToDo.element.getPriority() * 2;
                mostImportantTodo = nodeToDo;
            }
            nodeToDo = nodeToDo.succ;
        }
        inProgress.insertFirst(mostImportantTodo.element);
        toDo.delete(mostImportantTodo);

        SLLNode<Task> leastImportantInProgress = inProgress.getHead();

        while (nodeInProgress != null) {
            if (minImportanceInProgress > nodeInProgress.element.getHours() * nodeInProgress.element.getPriority() * 2) {
                minImportanceInProgress = nodeInProgress.element.getHours() * nodeInProgress.element.getPriority() * 2;
                leastImportantInProgress = nodeInProgress;
            }
            nodeInProgress = nodeInProgress.succ;
        }
        toDo.insertLast(leastImportantInProgress.element);
        inProgress.delete(leastImportantInProgress);

    }

    public static void main(String[] args) {
        SLL<Task> toDoList = new SLL<>();
        SLL<Task> InProgress = new SLL<>();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < n; i++) {
            int id = input.nextInt();
            int hours = input.nextInt();
            int priority = input.nextInt();

            Task t1 = new Task(id, hours, priority);
            toDoList.insertLast(t1);
        }
        for (int j = 0; j < m; j++) {
            int id = input.nextInt();
            int hours = input.nextInt();
            int priority = input.nextInt();

            Task t2 = new Task(id, hours, priority);
            InProgress.insertLast(t2);
        }
        work(toDoList, InProgress);
        System.out.println(toDoList.toString());
        System.out.println(InProgress.toString());
    }

}
