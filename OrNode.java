import javax.swing.ImageIcon;

public class OrNode extends Node{
    public OrNode(){
        type = "gate";
        name = "+";
        image = new ImageIcon("ORGate.png").getImage();   
    }
}
