import javax.swing.ImageIcon;

public class XorNode extends Node{
    public XorNode(){
        type = "gate";
        name = "^";
        image = new ImageIcon("XORGate.png").getImage();
    }
}
