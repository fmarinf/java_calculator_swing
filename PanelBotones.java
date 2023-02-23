import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelBotones extends JPanel implements ActionListener {

    private JButton[] btnNums;
    private JButton[] btnOps;
    private JButton btnEquals, btnClear;
    private JTextField txtDisplay;

    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";

    public PanelBotones() {

        setLayout(new GridLayout(4, 4));

        // Crea los botones de los números
        btnNums = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnNums[i] = new JButton(Integer.toString(i));
            add(btnNums[i]);
            btnNums[i].addActionListener(this);
        }

        // Crea los botones de las operaciones
        btnOps = new JButton[4];
        btnOps[0] = new JButton("+");
        btnOps[1] = new JButton("-");
        btnOps[2] = new JButton("*");
        btnOps[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            add(btnOps[i]);
            btnOps[i].addActionListener(this);
        }

        // Crea los botones de igual y limpiar
        btnEquals = new JButton("=");
        btnClear = new JButton("C");
        add(btnClear);
        add(btnEquals);
        btnClear.addActionListener(this);
        btnEquals.addActionListener(this);

        // Crea el campo de texto de la pantalla de la calculadora
        txtDisplay = new JTextField(10);
        txtDisplay.setEditable(false);
        add(txtDisplay);
    }

    // Función que maneja la acción de los botones de la calculadora
    public void actionPerformed(ActionEvent e) {
        // Obtener el botón que se presionó
        JButton btn = (JButton) e.getSource();
        String btnText = btn.getText();

        // Si el botón es un número
        if (btnText.matches("[0-9]")) {
            txtDisplay.setText(txtDisplay.getText() + btnText);
        }
        // Si el botón es una operación
        else if (btnText.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(txtDisplay.getText());
            operator = btnText;
            txtDisplay.setText("");
        }
        // Si el botón es igual
        else if (btnText.equals("=")) {
            num2 = Double.parseDouble(txtDisplay.getText());
            if (operator.equals("+")) {
                result = num1 + num2;
            }
            else if (operator.equals("-")) {
                result = num1 - num2;
            }
            else if (operator.equals("*")) {
                result = num1 * num2;
            }
            else if (operator.equals("/")) {
                result = num1 / num2;
            }
            txtDisplay.setText(Double.toString(result));
        }
        // Si el botón es limpiar
        else if (btnText.equals("C")) {
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = "";
            txtDisplay.setText("");
        }
    }
}