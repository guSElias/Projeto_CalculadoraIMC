package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.clienteDAO;

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
        setBounds(100, 100, 450, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        clienteDAO clienteDAO = new clienteDAO();
        		
        
        JLabel lblPeso = new JLabel("PESO:");
        lblPeso.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblPeso.setBounds(10, 34, 87, 61);
        contentPane.add(lblPeso);

        // Campo de texto para exibir o Peso
        JTextField txtPeso = new JTextField();
        txtPeso.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtPeso.setBounds(107, 51, 250, 36);
        txtPeso.setEditable(false); // Torna o campo não editável
        txtPeso.setText(String.valueOf(clienteDAO.dadosPesoAltura(cpfUsuario).getPeso()));
        contentPane.add(txtPeso);

        // Label para Altura
        JLabel lblAltura = new JLabel("ALTURA:");
        lblAltura.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblAltura.setBounds(10, 101, 87, 72);
        contentPane.add(lblAltura);

        // Campo de texto para exibir a Altura
        JTextField txtAltura = new JTextField();
        txtAltura.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtAltura.setBounds(107, 122, 250, 32);
        txtAltura.setEditable(false); // Torna o campo não editável
        txtAltura.setText(String.valueOf(clienteDAO.dadosPesoAltura(cpfUsuario).getAltura()));
        contentPane.add(txtAltura);
        
        JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVoltar.setBounds(154, 277, 125, 32);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
				dispose();
			}
		});
        
        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double peso = clienteDAO.dadosPesoAltura(cpfUsuario).getPeso();
                double altura = clienteDAO.dadosPesoAltura(cpfUsuario).getAltura();
                double imc = calcularIMC(peso, altura);
                JOptionPane.showMessageDialog(null, "Seu IMC é: " + String.format("%.2f", calcularIMC(peso, altura)));
            }
            
        });

        btnCalcular.setBounds(154, 207, 125, 32);
        contentPane.add(btnCalcular);

        JLabel lblKg = new JLabel("Kg");
        lblKg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblKg.setBounds(368, 51, 87, 61);
        contentPane.add(lblKg);

        JLabel lblM = new JLabel("m");
        lblM.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblM.setBounds(368, 122, 87, 82);
        contentPane.add(lblM);
    }
}
