public class BinaryTree {
    private Node gate;
    private BinaryTree left, right;
    
    public BinaryTree(Node gateType, BinaryTree t1, BinaryTree t2){
        this.gate = gateType;
        left = t1;
        right = t2;

    }

    public String printTree(){
        return null;
    }
}
