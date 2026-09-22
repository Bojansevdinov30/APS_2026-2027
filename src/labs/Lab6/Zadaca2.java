package labs.Lab6;

public class Zadaca2 {
    /*int najgolemaSuma=Integer.MIN_VALUE;
    int maxSumOfNodesAtOddLevelInEachSubtree(TreeNode<Integer> node){
        if(node==null){
            return 0;
        }
        maxSumOfNodesAtOddLevelInEachSubtreeRecursively(node, 0);
        return najgolemaSuma;
    }
    int maxSumOfNodesAtOddLevelInEachSubtreeRecursively(TreeNode<Integer> node, int level){
        if(node==null){
            return 0;
        }
        int add;
        if(level%2!=0) {
            add=node.data;
        }
        else add=0;
        int leftSubtree=maxSumOfNodesAtOddLevelInEachSubtreeRecursively(node.left, level+1);
        int rightSubtree=maxSumOfNodesAtOddLevelInEachSubtreeRecursively(node.right, level+1);
        int total=leftSubtree+rightSubtree+add;
        if(total>najgolemaSuma){
            najgolemaSuma=total;
        }
        return total;
    }





Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        BinaryTree<Integer> tree=new BinaryTree<>();
        int koren=input.nextInt();
        input.nextLine();
        tree.makeRoot(koren);
        for(int i=0;i<n-1;i++){
            String vlez=input.nextLine();
            String [] deloviVlez=vlez.split(" ");
            int vrednostTatko=Integer.parseInt(deloviVlez[0]);
            int vrednostJazel=Integer.parseInt(deloviVlez[1]);
            String levoilidesno=deloviVlez[2];
            TreeNode<Integer> findTatko=tree.najdiJazelSoVrednostKey(tree.root, vrednostTatko);
            if(findTatko!=null){
                if(levoilidesno.equals("LEFT")){
                    tree.addLeftChild(vrednostJazel, findTatko);
                }
                else{
                    tree.addRightChild(vrednostJazel, findTatko);
                }
            }
        }
        System.out.println(tree.maxSumOfNodesAtOddLevelInEachSubtree(tree.root));*/
}
