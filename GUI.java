import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;


public class GUI extends JFrame{
    private static int WIDTH = 600;
    private static int HEIGHT = 600;

    public static int getWIDTH(){
        return WIDTH;
    }

    public static int getHEIGHT(){
        return HEIGHT;
    }

    public GUI(){
        setTitle("Boolean Algebra");
        setBounds(50, 50, WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        /* 
        EquationEnter equationEnter = new EquationEnter();
        equationEnter.setBackground(Color.RED);
        equationEnter.setBounds(0, 0, 250, 250);
        add(equationEnter);

        EquationEnter equationEnter2 = new EquationEnter();
        equationEnter2.setBackground(Color.GREEN);
        equationEnter2.setBounds(250, 0, 250, 250);
        add(equationEnter2);
        */

        EquationEnter equationEnter = new EquationEnter();
        add(equationEnter);

        CircuitDisplay circuitDisplay = new CircuitDisplay();
        add(circuitDisplay);

        setVisible(true);
    }
}
