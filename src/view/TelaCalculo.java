package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CalculoIMCDAO;
import model.CalculoIMC;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TelaCalculo extends JFrame {

	private JTextField textField;
	private JTextField textField_1;
	
	// Método para calcular o IMC
    public double calcularIMC(double peso, double altura) {
        // Verificando se os valores são válidos
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("O peso e a altura devem ser valores positivos e diferentes de zero.");
        }

        // Fórmula do cálculo do IMC: peso / (altura * altura)
        double imc = peso / (altura * altura);
        return imc;
    }
    
 // Método para salvar o cálculo do IMC no banco de dados
    public void salvarIMCNoBanco(double peso, double altura, String cpfUsuario) {
        // Calculando o IMC
        double imc = calcularIMC(peso, altura);

        // Criando uma instância de java.util.Date para representar a data atual
        java.util.Date dataAtual = new java.util.Date();

        // Convertendo java.util.Date para java.sql.Date
        java.sql.Date dataSQL = new java.sql.Date(dataAtual.getTime());

        // Criando uma instância de CalculoIMC com os valores a serem salvos
        CalculoIMC calculoIMC = new CalculoIMC(0, cpfUsuario, peso, altura, imc, dataSQL);

        // Salvando no banco de dados usando o CalculoIMCDAO
        CalculoIMCDAO calculoIMCDAO = new CalculoIMCDAO();
        calculoIMCDAO.salvarCalculoIMC(calculoIMC);
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

		textField = new JTextField();
		textField.setBounds(107, 63, 251, 36);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblAltura = new JLabel("ALTURA:");
		lblAltura.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAltura.setBounds(10, 113, 87, 82);
		contentPane.add(lblAltura);

		textField_1 = new JTextField();
		textField_1.setBounds(107, 134, 251, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSalvar = new JButton("CALCULAR");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarIMCNoBanco(Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()), cpfUsuario);
				JOptionPane.showMessageDialog(null, "IMC salvo com sucesso no banco de dados!");
			}
		});

		btnSalvar.setBounds(154, 207, 125, 32);
		contentPane.add(btnSalvar);
		
		JLabel lblPeso_1 = new JLabel("Kg");
		lblPeso_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPeso_1.setBounds(368, 46, 87, 61);
		contentPane.add(lblPeso_1);
		
		JLabel lblM = new JLabel("m");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM.setBounds(368, 113, 87, 82);
		contentPane.add(lblM);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(323, 194, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU OPÇÕES");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("HISTÓRICO");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("LOGOUT");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial telaInicial = new TelaInicial(); 
				telaInicial.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}
}