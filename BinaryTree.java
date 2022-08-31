public class BinaryTree {
    public Node gate;
    public BinaryTree left, right;
    
    public BinaryTree(Node gateType, BinaryTree t1 , BinaryTree t2 ){
        this.gate = gateType;
        left = t1;
        right = t2;

    }

    //This is pre-order traversal
    public static String printTree(BinaryTree t){
        if(t == null){
            return "";
        }else{
            return t.gate.getName() + printTree(t.left) + printTree(t.right);
        }

    }

    public static int maxNum(int num1, int num2){
        if(num2 > num1){
            return num2;
        }else{
            return num1;
        }
    }

    public static int maxLength(BinaryTree t){
        if(t==null){
            return 0;
        }else{
            return BinaryTree.maxNum(maxLength(t.left), maxLength(t.right)) + 1;
        }
    }

    public static String printRight(BinaryTree t){
        return printTree(t.right);
    }
}
