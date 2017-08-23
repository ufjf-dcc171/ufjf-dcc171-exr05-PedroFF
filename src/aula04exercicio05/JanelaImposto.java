package aula04exercicio05;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JanelaImposto extends JFrame {

    private JTextField texto = new JTextField(25);
    private JTextField texto2 = new JTextField(25);
    private final JCheckBox chkIcms = new JCheckBox("ICMS");
    private final JCheckBox chkTributo = new JCheckBox("Tributo");
    private JButton calculaImposto = new JButton();

    public JanelaImposto() throws HeadlessException {
        super("Calcula imposto");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        texto.setText("Digite o valor da mercadoria em dólar.");
        texto2.setText("Digite o valor da cotação do dólar.");

        add(texto);
        add(texto2);
        add(chkIcms);
        add(chkTributo);

        CalculaImposto calculaImposto = new CalculaImposto();
        chkIcms.addItemListener(calculaImposto);
        chkTributo.addItemListener(calculaImposto);
    }

    private class CalculaImposto implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            Double valorDolar = Double.parseDouble(texto.getText());
            Double valorCotacao = Double.parseDouble(texto2.getText());
            double valorProduto = valorDolar * valorCotacao;
            Double resultado;
            if (chkIcms.isSelected() && chkTributo.isSelected()) {
                resultado = valorProduto + (valorProduto * 0.6) + (valorProduto *);
            }
        }
    }

}
