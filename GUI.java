import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class GUI extends JFrame{
    private static int WIDTH = 800;
    private static int HEIGHT = 800;
    private static Color lightPurple = new Color(245, 125, 255);
    private static Color darkPurple = new Color(168, 52, 179);
    private static Color lightGreen = new Color(197, 255, 150);
    private static Color medGreen = new Color(183, 255, 124);
    private static Color darkGreen = new Color(119, 179, 70);
    private static Font normalFont = new Font("Comic Sans MS", Font.PLAIN, 25);

    public static Color getLightPurple(){
        return lightPurple;
    }

    public static Color getDarkPurple(){
        return darkPurple;
    }

    public static Color getLightGreen(){
        return lightGreen;
    }

    public static Color getMedGreen(){
        return medGreen;
    }

    public static Color getDarkGreen(){
        return darkGreen;
    }

    public static int getWIDTH(){
        return WIDTH;
    }

    public static int getHEIGHT(){
        return HEIGHT;
    }

    public static Font getNormalFont(){
        return normalFont;
    }

    public GUI(){
        setTitle("Boolean Algebra");
        setBounds(50, 50, WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        CircuitDisplay circuitDisplay = new CircuitDisplay();
        add(circuitDisplay);

        EquationEnter equationEnter = new EquationEnter(circuitDisplay);
        add(equationEnter);

        setVisible(true);
    }
}
