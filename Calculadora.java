import javax.swing.*;
import java.awt.*;


public class Calculadora extends JFrame {

    public Calculadora() {

        // Crea el panel de botones
        PanelBotones panel = new PanelBotones();

        // Crea el campo de texto de la pantalla de la calculadora
        JTextField txtDisplay = new JTextField(10);
        txtDisplay.setEditable(false);

        // Añade los componentes al panel principal
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.add(txtDisplay);
        c.add(panel);
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.setTitle("Calculadora");
        calc.setSize(250, 200);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }
}