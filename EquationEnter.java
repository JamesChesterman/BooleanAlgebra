import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.*;

public class EquationEnter extends JPanel{
    private int x = 0;
    private int y = 0;
    private int w;
    private int h;
    JButton submitButton;
    JTextField textfield;
    CircuitDisplay circuitDisplay;
    BinaryTree tree;

    public EquationEnter(CircuitDisplay circuitDisplay){
        this.circuitDisplay = circuitDisplay;
        w = GUI.getWIDTH();
        h = GUI.getHEIGHT() / 6;
        setBounds(x, y, w, h);
        setBackground(GUI.getLightPurple());

        textfield = new JTextField(25);
        textfield.setFont(GUI.getNormalFont());
        textfield.setBounds(w/10, h/10, w/2, h/3);
        add(textfield);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(actions);
        add(submitButton);
    }

    public BinaryTree getTree(){
        return tree;
    }

    private ActionListener actions = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == submitButton){
                tree = Translator.translate(textfield.getText());
                //AndNode dot = new AndNode();
                //LetterNode A = new LetterNode('A');
                //LetterNode B = new LetterNode('B');
                //LetterNode C = new LetterNode('C');
                //BinaryTree tree1 = new BinaryTree(dot, new BinaryTree(dot, new BinaryTree(A, null, null), new BinaryTree(B, null, null)), new BinaryTree(C, null, null));
                System.out.println(BinaryTree.printTree(tree));
                //System.out.println(BinaryTree.printRight(tree));

                //circuitDisplay.drawTree(tree, 500, 500);
                circuitDisplay.setTree(tree);
            }
        }
    };
}
