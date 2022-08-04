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

    public EquationEnter(){
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

    private ActionListener actions = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == submitButton){
                System.out.println(textfield.getText());
                BinaryTree tree = Translator.translate(textfield.getText());
                System.out.println(BinaryTree.printTree(tree));
            }
        }
    };
}
