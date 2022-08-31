import java.awt.Image;
import javax.swing.ImageIcon;

public class NotNode extends Node{
    public NotNode(){
        type = "gate";
        name = "¬";
        image = new ImageIcon("NOTGate.png").getImage();
    }
}
