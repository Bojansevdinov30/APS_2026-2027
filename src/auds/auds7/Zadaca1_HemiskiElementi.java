package auds.auds7;

import dataStructures.CBHT;

class ChemicalElement implements Comparable<ChemicalElement> {
    // A ChemicalElement object represents a chemical element.
// Each element contains the two characters of the chemical symbol.
// The first character must be an uppercase letter. Where present,
// the second character must be a lowercase letter. If absent, the
// second character is a space.
    private char sym1, sym2; // The two letters of the chemical symbol.

    public ChemicalElement(String symbol) {
        sym1 = Character.toUpperCase(symbol.charAt(0));
        if (symbol.length() >= 2) sym2 = Character.toLowerCase(symbol.charAt(1));
        else sym2 = ' ';
    }

    public int hashCode() {
        return sym1 - 'A';
    } // избраната хеш функција

    public int compareTo(ChemicalElement that) {
        if (this.sym1 != that.sym1) return Character.compare(this.sym1, that.sym1);
        else return Character.compare(this.sym2, that.sym2);
    }
}

public class Zadaca1_HemiskiElementi {
    public static void main(String[] args) {
        CBHT<ChemicalElement, Integer> table1 = new CBHT<ChemicalElement, Integer>(26);
        table1.insert(new ChemicalElement("H"), 1);
        table1.insert(new ChemicalElement("He"), 2);
        table1.insert(new ChemicalElement("Li"), 3);
        table1.insert(new ChemicalElement("Be"), 4);
        table1.insert(new ChemicalElement("Na"), 11);
        table1.insert(new ChemicalElement("Mg"), 12);
        table1.insert(new ChemicalElement("K"), 19);
        table1.insert(new ChemicalElement("Ca"), 20);
        table1.insert(new ChemicalElement("Rb"), 37);
        table1.insert(new ChemicalElement("Sr"), 38);
        table1.insert(new ChemicalElement("Cs"), 55);
        table1.insert(new ChemicalElement("Ba"), 56);
        System.out.println("Table from presentation slide 6");
        System.out.println(table1);
    }
}
