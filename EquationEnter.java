import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class EquationEnter extends JPanel{
    private int x = 0;
    private int y = 0;
    private int w;
    private int h;

    public EquationEnter(){
        w = GUI.getWIDTH();
        h = GUI.getHEIGHT() / 6;
        setBounds(x, y, w, h);
        setBackground(GUI.getLightPurple());
    }
}
