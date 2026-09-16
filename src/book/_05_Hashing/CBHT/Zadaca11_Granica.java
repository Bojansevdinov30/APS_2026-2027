package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

/*Донесен е нов закон со коj не се дозволува да jа напуштите државата со стар
пасош ако во ме´гувреме сте го промениле името или презимето (односно мора да
имате пасош со новото име и презиме). За таа цел постоjат два регистри: еден на
издадени патни дозволи (пасоши) и еден на лица кои го промениле своето име
или презиме. Ваша задача е за даден броj на пасош (лице кое дошло на граница)
да проверите дали смее да jа напушти државата (т.е. дали има промена во своето
име или презиме).
Влез: Во првата линиjа е даден броj на лица 𝑁 на кои им е издадена патна
дозвола. Во наредните 𝑁 линии се дадени броевите на пасош и имињата и пре-
зимињата на лицата. Потоа е даден броj 𝑀 на лица кои го промениле своето име
или презиме. Во наредните 𝑀 линии дадени се прво старите, па новите имиња
на лицата. Во последниот ред е даден броj на пасош коj треба да се провери.
Излез: Да се испечати дали лицето со дадениот броj на пасош смее („Allowed”)
или не смее („Not allowed”) да на jа напушти државата.
Пример 1:
Влез:
4
A112233 IvanaIvanovska
B345680 AleksandarPetreski
A878999 ElenaTrajkovska
B783789 IvanIvanov
2
PetrankaJanevska PetrankaPetrovska
AleksandarPetreski AleksandarKocevski
B345680
Излез:
Not Allowed
Пример 1:
Влез:
4
A112233 IvanaIvanovska
B345680 AleksandarPetreski
A878999 ElenaTrajkovska
B783789 IvanIvanov
2
PetrankaJanevska PetrankaPetrovska
AleksandarPetreski AleksandarKocevski
B783789
Излез:
Allowed
*/
public class Zadaca11_Granica {
    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        CBHT<String, String> passports = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");

            String passportNumber = parts[0];
            String name = parts[1];

            passports.insert(passportNumber, name);
        }

        int m = Integer.parseInt(br.readLine());

        CBHT<String, String> changedNames = new CBHT<>(2 * m);

        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split("\\s+");

            String oldName = parts[0];
            String newName = parts[1];

            changedNames.insert(oldName, newName);
        }

        String passportToCheck = br.readLine();

        SLLNode<MapEntry<String, String>> passportNode =
                passports.search(passportToCheck);

        if (passportNode == null) {
            System.out.println("Not Allowed");
            return;
        }

        String passportName = passportNode.getElement().getValue();

        SLLNode<MapEntry<String, String>> changedNode =
                changedNames.search(passportName);

        if (changedNode != null) {
            System.out.println("Not Allowed");
        } else {
            System.out.println("Allowed");
        }
    }
}
