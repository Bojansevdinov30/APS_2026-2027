package PrethodniIspitni._2026;
/*бинарно дрво чии јазли содржат цели броеви, да се пресмета сумата на вредностите на сите јазли што се наоѓаат на непарна
длабочина во оригиналното дрво во секое од неговите поддрва и да се врати максималната од овие суми. Коренот се наоѓа на длабочина 0.

Влез:
Првиот ред содржи цел број N. Потоа е дадена вредноста на коренот, а во следните N-1 редови се дадени вредноста на родителот
(посточеки јазли), вредноста на јазол што треба да биде негово дете и дали тоа дете е лево или десно дете на родителот. Нема да
има два јазли со иста вредност.

Излез:
Максимална сума на јазлите на непарна длабочина во некое поддрво.

Пример:
Влез:
9
5
5 -15 LEFT
-15 11 LEFT
-15 1 RIGHT
5 20 RIGHT
20 25 LEFT
20 21 RIGHT
25 2 LEFT
25 -5 RIGHT

Излез:
17

Објаснување:
Поддрвото во коренот има сума на јазли на непарна длабочина -15 + 20 + 2 + (-5) = 2
Поддрвото со корен во -15 има сума на јазли на непарна длабочина -15
Поддрвото со корен во 11 има сума на јазли на непарна длабочина 0
Поддрвото со корен во 1 има сума на јазли на непарна длабочина 0
Поддрвото со корен во 20 има сума на јазли на непарна длабочина 20 + 2 + (-5) = 17
Поддрвото со корен во 25 има сума на јазли на непарна длабочина 2 + (-5) = -3
Поддрвото со корен во 21 има сума на јазли на непарна длабочина 0
Поддрвото со корен во 2 има сума на јазли на непарна длабочина 2
Поддрвото со корен во -5 има сума на јазли на непарна длабочина -5*/
public class RandomZadaca3_jazliNaNeparnaDlabocina {
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
