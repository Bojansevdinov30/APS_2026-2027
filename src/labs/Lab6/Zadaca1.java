package labs.Lab6;

public class Zadaca1 {
    /*funkcijata:

int maxSumOfLeavesInEachSubtree(TreeNode<Integer> node){
        if(node==null){
            return 0;
        }
        maxSumOfLeavesInEachSubtreeRecursively(node);
        return maxSum;
    }
    int maxSum=Integer.MIN_VALUE;
    int maxSumOfLeavesInEachSubtreeRecursively(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        if(node.left == null && node.right == null)  return node.data;
        int vrednostLevoPoddrvo = maxSumOfLeavesInEachSubtreeRecursively(node.left);
        int vrednostDesnoPoddrvo = maxSumOfLeavesInEachSubtreeRecursively(node.right);
        int vrednostTotal=vrednostLevoPoddrvo+vrednostDesnoPoddrvo;
        if(vrednostTotal>maxSum){
            maxSum=vrednostTotal;
        }
        return vrednostTotal;
    }


mainot:

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
        System.out.println(tree.maxSumOfLeavesInEachSubtree(tree.root));*/
}
