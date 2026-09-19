package auds.auds8;
import dataStructures.SLLTree;
import dataStructures.Tree;

import java.util.*;
/*Да се напише програма која ќе може да изгради Општо Дрво од N
јазли кои содржат различни имиња при што на влез е дадено
името на коренот, а потоа N-1 имиња на нов јазол и име на
постоечки јазол кој што треба да биде родител на новиот јазол.
N
root
parent_1 node_1
parent_2 node_2
…
parent_N node_N
Пример:
Влез:
7
Koren
Koren Jazol1
Koren Jazol2
Jazol1 Jazol3
Jazol3 Jazol4
Jazol2 Jazol5
Koren Jazol6
Излез:
Koren
Jazol6
Jazol2
Jazol5
Jazol1
Jazol3
Jazol4*/
public class Zadaca8_OpstoDrvo {


        public static void main(String[] args) {
            Scanner sc = new Scanner(example_input_2); // (System.in);
            SLLTree<String> tree = new SLLTree<String>();
            Map<String, Tree.Node<String>> nodes = new HashMap<>();
            int n = sc.nextInt();
            String valueRoot = sc.next();
            tree.makeRoot(valueRoot);
            Tree.Node<String> nodeRoot = tree.getRoot();
            nodes.put(valueRoot, nodeRoot);
            for(int i = 1 ; i < n ; i++) {
                String valueParent = sc.next(), valueChild = sc.next();
                Tree.Node<String> nodeParent = nodes.get(valueParent);
                Tree.Node<String> nodeChild = tree.addChild(nodeParent, valueChild);
                nodes.put(valueChild, nodeChild);
            }
            tree.printTree();
        }
        static final String example_input = "7\nKoren\nKoren A\nKoren B\nA C\nB D\nA E\nC F";
        static final String example_input_2 = "7\nKoren\nKoren Jazol1\nKoren Jazol2\nJazol1 Jazol3\nJazol3 Jazol4\nJazol2 Jazol5\nKoren Jazol6";

}
