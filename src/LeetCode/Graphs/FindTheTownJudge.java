package LeetCode.Graphs;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {

        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        // Count incoming and outgoing trust relationships
        for (int[] relationship : trust) {

            int person = relationship[0];
            int trustedPerson = relationship[1];

            outDegree[person]++;
            inDegree[trustedPerson]++;
        }

        // Find the person with:
        // 0 outgoing edges
        // n - 1 incoming edges
        for (int person = 1; person <= n; person++) {

            if (outDegree[person] == 0 &&
                    inDegree[person] == n - 1) {

                return person;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // something
    }
}
