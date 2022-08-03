import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;


public class GUI extends JFrame{
    public GUI(){
        setTitle("Boolean Algebra");
        setBounds(50, 50, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        //JPanel content = new JPanel();
        //content.setLayout(null);
        //add(content);
        setLayout(null);

        EquationEnter equationEnter = new EquationEnter();
        equationEnter.setBackground(Color.RED);
        equationEnter.setBounds(0, 0, 250, 250);
        add(equationEnter);

        EquationEnter equationEnter2 = new EquationEnter();
        equationEnter2.setBackground(Color.GREEN);
        equationEnter2.setBounds(250, 0, 250, 250);
        add(equationEnter2);
        setVisible(true);
    }
}
