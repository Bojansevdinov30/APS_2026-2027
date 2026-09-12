package auds.auds3;

/*
Да се напише функција која ќе го пресмета
n-тиот степен на некој број со примена на
техниката "Раздели и владеј".
*/
public class Zadaca5_NtiStepenNaBroj {
    // O(logn) complexity, ako ne zacuvavme vo r ke bese O(n)
    int pow(int x, int n) {
        int r;
        if (n == 0)
            return (1);
        else if (n % 2 == 0) {
            r = pow(x, (n / 2));
            return r * r;
        } else {
            r = pow(x, (n / 2));
            return x * r * r;
        }
    }
}
