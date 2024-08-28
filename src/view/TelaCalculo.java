package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class TelaCalculo extends JFrame {

    private JTextField textFieldPeso;
    private JTextField textFieldAltura;

    // Método para calcular o IMC
    public double calcularIMC(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("O peso e a altura devem ser valores positivos e diferentes de zero.");
        }

        return peso / (altura * altura);
    }

    public TelaCalculo(String cpfUsuario) {
        setTitle("Cálculo IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPeso = new JLabel("PESO:");
        lblPeso.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblPeso.setBounds(10, 46, 87, 61);
        contentPane.add(lblPeso);

        textFieldPeso = new JTextField();
        textFieldPeso.setBounds(107, 63, 251, 36);
        contentPane.add(textFieldPeso);
        textFieldPeso.setColumns(10);

        JLabel lblAltura = new JLabel("ALTURA:");
        lblAltura.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblAltura.setBounds(10, 113, 87, 82);
        contentPane.add(lblAltura);

        textFieldAltura = new JTextField();
        textFieldAltura.setBounds(107, 134, 251, 32);
        contentPane.add(textFieldAltura);
        textFieldAltura.setColumns(10);

        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double peso = Double.parseDouble(textFieldPeso.getText());
                double altura = Double.parseDouble(textFieldAltura.getText());
                double imc = calcularIMC(peso, altura);
                JOptionPane.showMessageDialog(null, "Seu IMC é: " + String.format("%.2f", imc));
            }
        });

        btnCalcular.setBounds(154, 207, 125, 32);
        contentPane.add(btnCalcular);

        JLabel lblKg = new JLabel("Kg");
        lblKg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblKg.setBounds(368, 46, 87, 61);
        contentPane.add(lblKg);

        JLabel lblM = new JLabel("m");
        lblM.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblM.setBounds(368, 113, 87, 82);
        contentPane.add(lblM);
    }
}
