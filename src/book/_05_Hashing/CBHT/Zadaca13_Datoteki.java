package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;
import java.util.LinkedList;

/*Информациите за организациjата на датотечниот систем на серверот на ФИНКИ
се зачувани во хеш табела. За секоjа датотека се знае неjзината содржина и
патеката на коjа се нао´га. Ваша задача е да ги наjдете сите датотеки кои имаат
идентична содржина.
Влез: Во првиот ред е даден броjот на датотеки 𝑁 . Во следните 𝑁 редици се
дадени податоци за секоjа датотека во формат „path file (content)”, каде што path
е патеката на директориумот во коj се нао´га датотеката, file е називот на дато-
теката заедно со наставката и content е содржината на датотеката. Во следниот
ред е даден броj на команди 𝑀 . Во следните 𝑀 редици се дадени команди во
формат „cmd path file (content)” каде што cmd може да биде add, delete или find.
Командата add треба да jа додаде датотеката file со содржина content во дирек-
ториумот коj се нао´га на патеката path. Командата delete треба да jа избрише
датотеката file со содржина content од директориумот коj се нао´га на патеката
path. Командата find треба да провери дали постои датотеката file со содржина
content во директориумот со патека path и да испечати на екран „true” или „false”.
Во последната редица од влезот е дадена содржината content.
Излез: Листа од сите патеки на сите датотеките со содржина content.
Пример:
Влез:
2
root/a/ 1.txt (abcd)
root/a/ 2.txt (efgh)
3
add root/c/d/ 4.txt (efgh)
delete root/a/ 1.txt (abcd)
find root/a/ 1.txt (abcd)
efgh
Излез:
false
root/a/2.txt root/c/d 4.txt*/
public class Zadaca13_Datoteki {
    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        CBHT<String, LinkedList<String>> table =
                new CBHT<>(2 * n + 1);

        // Initial files
        for (int i = 0; i < n; i++) {

            String line = br.readLine();

            String[] parts = line.split(" ");

            String path = parts[0];
            String file = parts[1];
            String content = parts[2];

            String fullPath = path + file;

            SLLNode<MapEntry<String, LinkedList<String>>> node =
                    table.search(content);

            if (node == null) {
                LinkedList<String> files = new LinkedList<>();
                files.add(fullPath);

                table.insert(content, files);
            } else {
                node.getElement().getValue().add(fullPath);
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {

            String line = br.readLine();
            String[] parts = line.split(" ");

            String command = parts[0];
            String path = parts[1];
            String file = parts[2];
            String content = parts[3];

            String fullPath = path + file;

            SLLNode<MapEntry<String, LinkedList<String>>> node =
                    table.search(content);

            if (command.equals("add")) {

                if (node == null) {
                    LinkedList<String> files = new LinkedList<>();
                    files.add(fullPath);

                    table.insert(content, files);
                } else {
                    node.getElement().getValue().add(fullPath);
                }

            } else if (command.equals("delete")) {

                if (node != null) {
                    node.getElement().getValue().remove(fullPath);

                    if (node.getElement().getValue().isEmpty()) {
                        table.delete(content);
                    }
                }

            } else if (command.equals("find")) {

                if (node != null &&
                        node.getElement().getValue().contains(fullPath)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }

        String wantedContent = br.readLine();

        SLLNode<MapEntry<String, LinkedList<String>>> result =
                table.search(wantedContent);

        if (result != null) {
            for (String file : result.getElement().getValue()) {
                System.out.print(file + " ");
            }
        }
    }
}
