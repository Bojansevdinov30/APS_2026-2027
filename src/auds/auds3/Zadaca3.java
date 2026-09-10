package auds.auds3;

import java.util.ArrayList;
import java.util.Scanner;

/*
Дадени се N затворени интервали. Да се
најдат сите интервали кои се преклопуваат
и да се спојат. На крај излезот да содржи
само дисјунктни интервали.
*/
public class Zadaca3 {
    public static class ClosedInterval implements Comparable<ClosedInterval> {
        private int start, end;
        private boolean toDelete;

        public ClosedInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isToDelete() {
            return toDelete;
        }

        public void setToDelete(boolean toDelete) {
            this.toDelete = toDelete;
        }

        @Override
        public String toString() {
            return "Interval [ " + start + ", " + end + " ]";
        }

        @Override
        public int compareTo(ClosedInterval that) {
            return this.start - that.start;
        }

        public void mergeInterval(ClosedInterval that) {
            this.start = Math.min(this.start, that.start);
            this.end = Math.max(this.end, that.end);
        }

        public boolean isOverlaping(ClosedInterval that) {
            if (that.start >= this.start && that.start <= this.end) return true;
            if (this.start >= that.start && this.start <= that.end) return true;
            return false;
        }
    }

    public static void mergeIntervals(ArrayList<ClosedInterval> intervals) {
        //sortiraj gi intervalite
        for (int i = 0; i < intervals.size() - 1; i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).compareTo(intervals.get(j)) > 0) {
                    ClosedInterval ci = intervals.get(i);
                    intervals.set(i, intervals.get(j));
                    intervals.set(j, ci);
                }
            }
        }
        for (int i = 0; i < intervals.size() - 1; i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                //baraj preklopeni intervali
                if (intervals.get(i).isOverlaping(intervals.get(j))) {
                    //merge them
                    intervals.get(i).mergeInterval(intervals.get(j));
                    // and delete the second interval
                    intervals.get(j).setToDelete(true);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ClosedInterval> intervals = new ArrayList<ClosedInterval>();
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            intervals.add(new ClosedInterval(s, e));
        }
        mergeIntervals(intervals);
        for (ClosedInterval interval : intervals) {
            if (!interval.isToDelete()) {
                System.out.println(interval);
            }
        }
    }

}
