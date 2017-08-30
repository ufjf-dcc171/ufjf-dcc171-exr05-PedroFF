package aula04exercicio05;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class JanelaImposto extends JFrame {

    private JTextField texto = new JTextField(25);
    private JTextField texto2 = new JTextField(25);
    private final JCheckBox chkIcms = new JCheckBox("ICMS");
    private final JCheckBox chkTributo = new JCheckBox("Tributo");
    private JLabel etiqueta = new JLabel();
    private JLabel etiqueta2 = new JLabel();
    private final JButton calculaImposto = new JButton("Clique para resultado");

    public JanelaImposto() throws HeadlessException {
        super("Calcula imposto");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        etiqueta = new JLabel("Digite o valor da mercadoria em dólar.");
        etiqueta2 = new JLabel("Digite o valor da cotação do dólar.");
        add(etiqueta);
        add(texto);
        add(etiqueta2);
        add(texto2);
        add(chkTributo);
        add(chkIcms);
        add(calculaImposto);

        calculaImposto.addActionListener(new CalculaImposto());
    }

    private class CalculaImposto implements ItemListener, ActionListener {

        //public void calcula(){}
        @Override
        public void itemStateChanged(ItemEvent e) {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Double valorDolar = Double.parseDouble(texto.getText());
            Double valorCotacao = Double.parseDouble(texto2.getText());
            Double resultado = valorDolar * valorCotacao;
            if (chkTributo.isSelected()) {
                resultado = resultado + (resultado * 0.6);
                if (chkIcms.isSelected()) {
                    resultado += (resultado * 0.18);
                }
            }
                JOptionPane.showMessageDialog(null, "O valor final é: " + resultado);
        }
    }

}
