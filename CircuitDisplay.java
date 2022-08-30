import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

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
        setBackground(GUI.getLightGreen());
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.blue);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0, 0, 600, 500);
        g2d.drawRect(0, 0, 300, 300);
    }
}
