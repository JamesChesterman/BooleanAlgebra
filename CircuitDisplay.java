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
    private int imgWidth = 50;
    private int imgHeight = 50;
    Graphics2D g2d;
    private boolean drawing;
    private BinaryTree tree;

    Image andImage, orImage, notImage;

    public CircuitDisplay(){
        y = GUI.getHEIGHT() / 6;
        w = GUI.getWIDTH();
        h = GUI.getHEIGHT() - y;
        setBounds(x, y, w, h);
        setBackground(GUI.getLightGreen());
        //andImage = new ImageIcon("digger.jpg").getImage();
        drawing = false;
    }

    public void setTree(BinaryTree tree){
        this.tree = tree;
        drawing = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.blue);
        g2d.setStroke(new BasicStroke(5));
        //g2d.drawLine(0, 0, 1200, 500);
        //g2d.drawRect(0, 0, 300, 300);
        //g2d.drawImage(image, 200, 200, 200, 200, null);

        if(drawing == true){
            drawTree(tree, w-(w/6), (h/2)-(imgHeight/2));
        }
    }

    
    public void drawTree(BinaryTree t, int X, int Y){
        if(t != null){
            System.out.println("HERE");
            g2d.drawImage(t.gate.getImage(), X, Y, imgWidth, imgHeight, null);
            validate();
            repaint();
            drawTree(t.left, X-50, Y-50);
            drawTree(t.right, X-50, Y+50);
        }
    }
    

   
}
