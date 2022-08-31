import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.*;

public class CircuitDisplay extends JPanel {
    private int x = 0;
    private int y;
    private int w;
    private int h;

    Image andImage, orImage, notImage;

    public CircuitDisplay(){
        y = GUI.getHEIGHT() / 6;
        w = GUI.getWIDTH();
        h = GUI.getHEIGHT() - y;
        setBounds(x, y, w, h);
        setBackground(GUI.getLightGreen());
        andImage = new ImageIcon("digger.jpg").getImage();
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.blue);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(0, 0, 1200, 500);
        g2d.drawRect(0, 0, 300, 300);
        //g2d.drawImage(image, 200, 200, 200, 200, null);
        
    }

   
}
