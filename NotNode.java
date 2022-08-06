public class NotNode extends Node{
    public NotNode(char name){
        type = "gate";
        this.name = "¬" + String.valueOf(name);
    }
}
