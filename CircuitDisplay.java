import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private int sizeMultiplier = 1;
    private int startX, startY;

    JButton leftButton, upButton, downButton, rightButton;

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

        leftButton = new JButton("<");
        leftButton.setFont(GUI.getNormalFont());
        leftButton.addActionListener(actions);
        add(leftButton);

        upButton = new JButton("^");
        upButton.setFont(GUI.getNormalFont());
        upButton.addActionListener(actions);
        add(upButton);

        downButton = new JButton("v");
        downButton.setFont(GUI.getNormalFont());
        downButton.addActionListener(actions);
        add(downButton);

        rightButton = new JButton(">");
        rightButton.setFont(GUI.getNormalFont());
        rightButton.addActionListener(actions);
        add(rightButton);

        startX = w-(w/5);
        startY = (h/2)-(imgHeight/2);

    }

    private ActionListener actions = new ActionListener() {
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == upButton){
                startY += 50;
                drawing = true;
                repaint();
            }else if(e.getSource() == downButton){
                startY -= 50;
                drawing = true;
                repaint();
            }else if(e.getSource() == leftButton){
                startX += 50;
                drawing = true;
                repaint();
            }else if(e.getSource() == rightButton){
                startX -= 50;
                drawing = true;
                repaint();
            }
        }
    };

    public void setTree(BinaryTree tree){
        this.tree = tree;
        //System.out.println(BinaryTree.maxLength(tree));
        sizeMultiplier = BinaryTree.maxLength(tree);
        drawing = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.blue);
        g2d.setFont(GUI.getNormalFont());
        g2d.setStroke(new BasicStroke(5));
        //g2d.drawImage(leftImage, 0, 0, 50, 100, null);

        if(drawing == true){
            drawTree(tree, startX, startY, "top", sizeMultiplier);
        }
    }

    
    public void drawTree(BinaryTree t, int X, int Y, String direction, int sizeMultiplier){
        if(sizeMultiplier == this.sizeMultiplier){
            //Means it's the first node you're drawing. So put the Q here.
            g2d.drawImage(straightImage, X+imgWidth, Y, imgWidth, imgHeight, null);
            g2d.drawString("Q", X+(2*imgWidth)+5, Y+(4*imgHeight/6));
        }
        if(t != null){
            System.out.println("x:" + X + " y:" + Y);
            if(direction == "left"){
                g2d.drawImage(leftImage, X+imgWidth, Y+(imgHeight/2), imgWidth, sizeMultiplier*imgHeight, null);
            }else if(direction == "right"){
                g2d.drawImage(rightImage, X+imgWidth, Y-((2*(sizeMultiplier-1)+1) * (imgHeight/2)), imgWidth, sizeMultiplier*imgHeight, null);
            }else if(direction == "straight"){
                g2d.drawImage(straightImage, X+imgWidth, Y, imgWidth, imgHeight, null);
            }
            if(t.gate.getType().equals("gate")){
                g2d.drawImage(t.gate.getImage(), X, Y, imgWidth, imgHeight, null);
            }else{
                g2d.drawString(t.gate.getName(), X+(imgWidth/2), Y+(4*imgHeight/6));
            }
            //Don't put this, it will jsut call the paintComponent method again and do all this over and over.
            //repaint();
            if(t.right == null){
                if(t.left != null){
                    drawTree(t.left, X-(2*imgWidth), Y, "straight", sizeMultiplier-1);
                }
            }else{
                if(t.left != null){
                    drawTree(t.left, X-(2*imgWidth), Y-((sizeMultiplier-1)*imgHeight), "left", sizeMultiplier-1);
                }
                if(t.right != null){
                    drawTree(t.right, X-(2* imgWidth), Y+((sizeMultiplier-1)*imgHeight), "right", sizeMultiplier-1);
                }
                
            }
        }else{
            drawing = false;
        }
    }
    

   
}
