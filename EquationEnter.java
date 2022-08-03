import javax.swing.JPanel;
import javax.swing.JTextField;

public class EquationEnter extends JPanel{
    private int x = 0;
    private int y = 0;
    private int w;
    private int h;

    public EquationEnter(){
        w = GUI.getWIDTH();
        h = GUI.getHEIGHT() / 6;
        setBounds(x, y, w, h);
        setBackground(GUI.getLightPurple());

        JTextField textfield = new JTextField(25);
        textfield.setFont(GUI.getNormalFont());
        textfield.setBounds(w/10, h/10, w/2, h/3);
        add(textfield);
    }
}
