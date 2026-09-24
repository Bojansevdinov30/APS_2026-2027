package dadeniVezbi.courses;

import dataStructures.BNode;
import dataStructures.BTree;

import java.io.*;
import java.util.StringTokenizer;

public class ZadacaZaIspit_4 {
    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
        BNode<String>[] nodes = new BNode[N];
        BTree<String> tree = new BTree<String>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<String>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }


        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String[] split = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            // Vasiot kod ovde

            BNode<String> lca = BTree.findLCA(tree.root, from, to);

            if (lca == null) {
                System.out.println("ERROR");
            } else {
                // Calculate distances
                int distFromLCA = BTree.findDistance(lca, from, 0);
                int distToLCA = BTree.findDistance(lca, to, 0);

                if (distFromLCA == -1 || distToLCA == -1) {
                    System.out.println("ERROR");
                } else {
                    System.out.println((distFromLCA + distToLCA) * 2);
                }
            }
        }
        br.close();
    }

}
