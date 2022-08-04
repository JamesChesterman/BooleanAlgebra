public class BinaryTree {
    public Node gate;
    public BinaryTree left, right;
    
    public BinaryTree(Node gateType, BinaryTree t1, BinaryTree t2){
        this.gate = gateType;
        left = t1;
        right = t2;

    }

    public static String printTree(BinaryTree t){
        if(t == null){
            return "";
        }else{
            return t.gate.getName() + printTree(t.left) + printTree(t.right);
        }

    }
}
