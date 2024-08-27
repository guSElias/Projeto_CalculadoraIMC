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

import DAO.UsuarioDAO;
import control.ValidaDadosUsuario;
import model.Usuario;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textField.getText();
				String nome = textField_1.getText();
				String senha = passwordField.getText();

				if (!ValidaDadosUsuario.isCpfValido(cpf)) {
					// Mensagem de erro para CPF inválido
					JOptionPane.showMessageDialog(null, "CPF inválido. Por favor, insira um CPF válido.", "Erro de CPF", JOptionPane.ERROR_MESSAGE);
					return;
				} 

				if (!ValidaDadosUsuario.isSenhaValida(senha)) {
					// Mensagem de erro para senha inválida
					JOptionPane.showMessageDialog(null, "Senha inválida. A senha deve conter caracteres válidos.", "Erro de Senha", JOptionPane.ERROR_MESSAGE);
					return;
				} 
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = new Usuario(cpf, nome, senha);
				usuarioDAO.cadastraUsuario(usuario);		 
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");	  

				dispose();

				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);

			}
		});


		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setBounds(160, 226, 140, 27);
		contentPane.add(btnCadastrar);

		passwordField = new JPasswordField();
		passwordField.setBounds(107, 165, 295, 32);
		contentPane.add(passwordField);

		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
		lblSenha.setBounds(10, 144, 87, 72);
		contentPane.add(lblSenha);

		JLabel LBLnome = new JLabel("CPF: ");
		LBLnome.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
		LBLnome.setBounds(10, 77, 87, 61);
		contentPane.add(LBLnome);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(107, 94, 295, 36);
		contentPane.add(textField);

		JLabel lblNome = new JLabel("NOME: ");
		lblNome.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
		lblNome.setBounds(10, 10, 87, 61);
		contentPane.add(lblNome);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(107, 27, 295, 36);
		contentPane.add(textField_1);
	}
}