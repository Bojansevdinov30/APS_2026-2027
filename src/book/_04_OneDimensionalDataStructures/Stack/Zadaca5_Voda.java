package book._04_OneDimensionalDataStructures.Stack;

import dataStructures.LinkedStack;

import java.util.Scanner;

/*Да се напише алгоритам со коj ´ке се имплементира играта “Направи молекула
на вода”. Во оваа игра на располагање имате два типа атоми (H-водород, и O-
кислород). За да се направи молекула на вода (H2O) потребно е да имате два
атоми на водород и еден атом на кислород. На почеток се генерира една случаjна
секвенца од атоми. Ваша задача е од тоj влез, како доа´гаат атомите да генерирате
молекули и да кажете колку такви молекули се креирале, и кои атоми останале
несврзани.
Влез: Во влезот е дадена секвенца од случаjни атоми
Излез: На излез треба да се испечати броjот на молекули H2O, и несврзаните
атоми од водород и кислород.
Пример:
Влез:
H H O H H O H H O H H H H H O H O H O O H O O H H H
Излез:
8
H
O
*/
public class Zadaca5_Voda {

    public static void water(String atoms){
        String[] tokens = atoms.split(" ");
        LinkedStack<Character> hydrogen = new LinkedStack<>();
        LinkedStack<Character> oxygen = new LinkedStack<>();
        for (String token : tokens) {
            if(token.equals("H")){
                hydrogen.push('H');
            }else if(token.equals("O")){
                oxygen.push('O');
            }
        }
        int counter = 0;
        while (!(hydrogen.size() <=1) && !oxygen.isEmpty()){
                counter++;
                hydrogen.pop();
                hydrogen.pop();
                oxygen.pop();
        }
        System.out.println(counter);
        while(!hydrogen.isEmpty()){
            System.out.println(hydrogen.pop());
        }
        while(!oxygen.isEmpty()){
            System.out.println(oxygen.pop());
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String atoms =  sc.nextLine();
        water(atoms);
    }
}
