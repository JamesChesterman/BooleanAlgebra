import javax.swing.ImageIcon;

public class AndNode extends Node {

    public AndNode(){
        type = "gate";
        name = ".";
        image = new ImageIcon("ANDGate.png").getImage();
    }
}
