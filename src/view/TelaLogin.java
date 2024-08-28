package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.ControleAcesso;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(107, 122, 295, 32);
		contentPane.add(passwordField);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
		lblSenha.setBounds(10, 101, 87, 72);
		contentPane.add(lblSenha);

		JLabel LBLnome = new JLabel("CPF: ");
		LBLnome.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
		LBLnome.setBounds(10, 34, 87, 61);
		contentPane.add(LBLnome);

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(107, 51, 295, 36);
		contentPane.add(textFieldNome);

		JButton btnLogar = new JButton("LOGAR");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleAcesso controleAcesso = new ControleAcesso();
				if(controleAcesso.efetuaLogin(textFieldNome.getText(), passwordField.getText())) {
					JOptionPane.showMessageDialog(null, "Usuário logado com sucesso!");
					dispose();
					TelaCalculo telaCalculo = new TelaCalculo(textFieldNome.getText());
					telaCalculo.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "CPF ou senha inválidos!");
				}
			}
		});


		btnLogar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogar.setBounds(148, 194, 140, 27);
		contentPane.add(btnLogar);

	}

}