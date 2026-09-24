package PrethodniIspitni._2026;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*1. Во оперативен систем, датотеките се организирани во хиерархија од директориуми (фолдери). Секоја датотека е зададена со својата големина и апсолутна Windows патека (пр. C:\Users\Petar\Docs\file.txt).

Потребно е да се изгради структурата на директориуми и да се пресмета вкупната големина на секој директориум. Вкупната големина на директориум е збир од големините на сите датотеки во тој директориум и во сите негови поддиректориуми.

Влез: Во првиот ред е даден број N — број на датотеки. Во следните N редици се дадени:

size absolute_path

size — позитивен цел број.

absolute_path — апсолутна патека со \.

Последниот елемент во патеката е име на датотека.

Сите патеки започнуваат со диск (пр. C:\, D:\).

Излез:

За секој директориум испечатете:

full_folder_path = total_size

Директориумите да се испечатат лексикографски подредени според целосната патека.

Пример:

Влез:

5

120 C:\Users\Petar\Docs\paper.pdf

30 C:\Users\Petar\Docs\todo.txt

200 C:\Users\Petar\Pictures\img.png

10 D:\Music\Rock\song.mp3

40 C:\Users\Petar\Docs\Sub\notes.md

Излез:

C:\ = 390

C:\Users = 390

C:\Users\Petar = 390

C:\Users\Petar\Docs = 190

C:\Users\Petar\Docs\Sub = 40

C:\Users\Petar\Pictures = 200

D:\ = 10

D:\Music = 10

D:\Music\Rock = 10
*/
public class Januari_2026_DopolnitelenDel_1_operativenSistemFajloviOrganizacija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // TreeMap keeps the directory paths lexicographically sorted
        Map<String, Long> folders = new TreeMap<>();

        for (int i = 0; i < N; i++) {

            long size = sc.nextLong();
            String path = sc.next();

            String[] parts = path.split("\\\\");

            /*
             * Example:
             * C:\Users\Petar\Docs\paper.pdf
             *
             * parts:
             * ["C:", "Users", "Petar", "Docs", "paper.pdf"]
             */

            String currentPath = parts[0] + "\\";

            // The root directory: C:\
            folders.put(currentPath, folders.getOrDefault(currentPath, 0L) + size);

            // All directories except the last element (the file)
            for (int j = 1; j < parts.length - 1; j++) {

                if (currentPath.equals(parts[0] + "\\")) {
                    currentPath += parts[j];
                } else {
                    currentPath += "\\" + parts[j];
                }

                folders.put(currentPath, folders.getOrDefault(currentPath, 0L) + size);
            }
        }

        // TreeMap automatically gives lexicographical order
        for (Map.Entry<String, Long> entry : folders.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
// without a TreeMap
/*import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        HashMap<String, Long> folders = new HashMap<>();

        for (int i = 0; i < N; i++) {

            long size = sc.nextLong();
            String path = sc.next();

            // Split the Windows path
            String[] parts = path.split("\\\\");

            // Start with the root directory
            String currentPath = parts[0] + "\\";

            // Add the file size to the root
            folders.put(
                    currentPath,
                    folders.getOrDefault(currentPath, 0L) + size
            );

            // Process all directories, but not the file
            for (int j = 1; j < parts.length - 1; j++) {

                currentPath += parts[j];

                folders.put(
                        currentPath,
                        folders.getOrDefault(currentPath, 0L) + size
                );

                currentPath += "\\";
            }
        }

        // Get all directory paths
        ArrayList<String> paths =
                new ArrayList<>(folders.keySet());

        // Sort them lexicographically
        Collections.sort(paths);

        // Print
        for (String path : paths) {
            System.out.println(
                    path + " = " + folders.get(path)
            );
        }
    }
}*/