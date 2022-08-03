import javax.swing.*;
import java.awt.Color;

public class CircuitDisplay extends JPanel {
    private int x = 0;
    private int y;
    private int w;
    private int h;

    public CircuitDisplay(){
        y = GUI.getHEIGHT() / 6;
        w = GUI.getWIDTH();
        h = GUI.getHEIGHT() - y;
        setBounds(x, y, w, h);
        setBackground(Color.GREEN);
    }
}