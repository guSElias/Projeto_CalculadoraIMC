package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        // Definir o Look and Feel do sistema operacional, se disponível
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                TelaInicial frame = new TelaInicial();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaInicial() {
        initialize();
    }

    private void initialize() {
        setTitle("Calculadora IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("CALCULADORA IMC");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitulo.setBounds(62, 20, 311, 50);
        contentPane.add(lblTitulo);

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCadastrar.setBounds(155, 100, 126, 45);
        contentPane.add(btnCadastrar);

        JButton btnLogar = new JButton("LOGAR");
        btnLogar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogar.setBounds(155, 170, 126, 45);
        contentPane.add(btnLogar);

        // Adicionar ação aos botões
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });

        btnLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaLogin();
            }
        });
    }

    // Método para abrir a tela de cadastro
    private void abrirTelaCadastro() {
        dispose(); // Fecha a tela atual
        TelaCadastroCliente telaCadastro = new TelaCadastroCliente();
        telaCadastro.setVisible(true);
    }

    // Método para abrir a tela de login
    private void abrirTelaLogin() {
        dispose(); // Fecha a tela atual
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}
