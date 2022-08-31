import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

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

    Image leftImage, rightImage, straightImage;

    public CircuitDisplay(){
        y = GUI.getHEIGHT() / 6;
        w = GUI.getWIDTH();
        h = GUI.getHEIGHT() - y;
        setBounds(x, y, w, h);
        setBackground(GUI.getLightGreen());
        leftImage = new ImageIcon("LeftBranch.png").getImage();
        rightImage = new ImageIcon("RightBranch.png").getImage();
        straightImage = new ImageIcon("StraightLine.png").getImage();
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

        if(drawing == true){
            drawTree(tree, w-(w/6), (h/2)-(imgHeight/2), "top");
        }
    }

    
    public void drawTree(BinaryTree t, int X, int Y, String direction){
        if(t != null){
            if(direction == "left"){
                g2d.drawImage(leftImage, X+(imgWidth/2), Y+(2*imgHeight/3), imgWidth, imgHeight, null);
            }else if(direction == "right"){
                g2d.drawImage(rightImage, X+(imgWidth/2), Y-(2*imgHeight/3), imgWidth, imgHeight, null);
            }else if(direction == "straight"){
                g2d.drawImage(straightImage, X+(imgWidth/2), Y, imgWidth, imgHeight, null);
            }
            g2d.drawImage(t.gate.getImage(), X, Y, imgWidth, imgHeight, null);
            validate();
            repaint();
            if(t.right == null){
                drawTree(t.left, X-50, Y, "straight");
            }else{
                drawTree(t.left, X-50, Y-50, "left");
                drawTree(t.right, X-50, Y+50, "right");
            }
        }
    }
    

   
}
