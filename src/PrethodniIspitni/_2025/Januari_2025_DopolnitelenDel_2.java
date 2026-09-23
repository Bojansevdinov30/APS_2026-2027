package PrethodniIspitni._2025;

import dataStructures.AdjacencyListGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Во ракометарски натпревар играат два тима. Во низа од n линии да се напишат играчите коишто можат да си ја подадат топката
(пар од играчи со соодветно име и тим) и времетраење на подавањето
Потоа да се напишат уште k линии од играчите кои имаат пристап до голот, и на крај уште една линија за играчот кај којшто се наоѓа
моментално топката.
Да се најде најкраткото време за топката да стигне до голот.
Пр.
Player1 Team1 Player2 Team2 1
Player1 Team1 Player3 Team1 2
Player1 Team1 Player4 Team1 5
Player2 Team2 Player5 Team1 1
Player3 Team1 Player4 Team1 1
2
Player1 Team1 2
Player3 Team1 3
Player1 Team1
output: 2 */
public class Januari_2025_DopolnitelenDel_2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        // Read passes
        for (int i = 0; i < n; i++) {

            String player1 = input.next();
            String team1 = input.next();

            String player2 = input.next();
            String team2 = input.next();

            int time = input.nextInt();

            String from = player1 + " " + team1;
            String to = player2 + " " + team2;

            graph.addEdge(from, to, time);
        }

        // Read players who have access to the goal
        int k = input.nextInt();

        HashMap<String, Integer> goalPlayers = new HashMap<>();

        for (int i = 0; i < k; i++) {

            String player = input.next();
            String team = input.next();

            int time = input.nextInt();

            String key = player + " " + team;

            goalPlayers.put(key, time);
        }

        // Player who currently has the ball
        String startPlayer = input.next() + " " + input.next();

        // Dijkstra
        Map<String, Integer> distances = graph.shortestPath(startPlayer);

        // Find minimum total time
        int minTime = Integer.MAX_VALUE;

        for (String player : goalPlayers.keySet()) {

            if (distances.containsKey(player)
                    && distances.get(player) != Integer.MAX_VALUE) {

                int passTime = distances.get(player);
                int goalTime = goalPlayers.get(player);

                int totalTime = passTime + goalTime;

                if (totalTime < minTime) {
                    minTime = totalTime;
                }
            }
        }

        System.out.println(minTime);
    }
}
