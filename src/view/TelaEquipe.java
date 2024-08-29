package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaEquipe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEquipe frame = new TelaEquipe();
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
	public TelaEquipe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Título "Equipe"
		JLabel lblTitulo = new JLabel("Equipe");
		lblTitulo.setFont(new Font("Swis721 BlkCn BT", Font.BOLD, 24));
		lblTitulo.setBounds(175, 20, 100, 30);
		contentPane.add(lblTitulo);

		// Texto com os integrantes
		JLabel lblIntegrantes = new JLabel("<html>Integrantes:<br>"
				+ "- Gustavo - Front end<br>"
				+ "- Luan - Documentação<br>"
				+ "- Marcos - Modelagem<br>"
				+ "- Wagner - Back end</html>");
		lblIntegrantes.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 18));
		lblIntegrantes.setBounds(30, 70, 250, 150);
		contentPane.add(lblIntegrantes);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVoltar.setBounds(300, 200, 100, 30);
		contentPane.add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
				dispose();
			}
		});

	}
}
