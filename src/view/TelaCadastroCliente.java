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

import DAO.clienteDAO;
import DAO.clienteDAO;
import model.Cliente;

public class TelaCadastroCliente extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField textFieldCPF;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldAltura;
    private JTextField textFieldPeso;
    private JTextField textFieldRenda;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCadastroCliente frame = new TelaCadastroCliente();
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
    public TelaCadastroCliente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = textFieldCPF.getText();
                String nome = textFieldNome.getText();
                String senha = new String(passwordField.getPassword());
                int idade = Integer.parseInt(textFieldIdade.getText());
                double altura = Double.parseDouble(textFieldAltura.getText());
                double peso = Double.parseDouble(textFieldPeso.getText());
                double renda = Double.parseDouble(textFieldRenda.getText());

                clienteDAO clienteDAO = new DAO.clienteDAO();
                Cliente cliente = new Cliente(nome, idade, cpf, altura, peso, senha, renda);
                clienteDAO.cadastraCliente(cliente);		 
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");	  

                dispose();

                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
            }
        });

        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCadastrar.setBounds(160, 360, 140, 27);
        contentPane.add(btnCadastrar);

        passwordField = new JPasswordField();
        passwordField.setBounds(107, 200, 295, 32);
        contentPane.add(passwordField);

        JLabel lblSenha = new JLabel("SENHA:");
        lblSenha.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
        lblSenha.setBounds(10, 180, 87, 72);
        contentPane.add(lblSenha);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
        lblCpf.setBounds(10, 40, 87, 61);
        contentPane.add(lblCpf);

        textFieldCPF = new JTextField();
        textFieldCPF.setColumns(10);
        textFieldCPF.setBounds(107, 55, 295, 36);
        contentPane.add(textFieldCPF);

        JLabel lblNome = new JLabel("NOME:");
        lblNome.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
        lblNome.setBounds(10, 10, 87, 61);
        contentPane.add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setColumns(10);
        textFieldNome.setBounds(107, 10, 295, 36);
        contentPane.add(textFieldNome);

        JLabel lblIdade = new JLabel("IDADE:");
        lblIdade.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
        lblIdade.setBounds(10, 100, 87, 61);
        contentPane.add(lblIdade);

        textFieldIdade = new JTextField();
        textFieldIdade.setColumns(10);
        textFieldIdade.setBounds(107, 115, 295, 36);
        contentPane.add(textFieldIdade);

        JLabel lblAltura = new JLabel("ALTURA:");
        lblAltura.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
        lblAltura.setBounds(10, 140, 87, 61);
        contentPane.add(lblAltura);

        textFieldAltura = new JTextField();
        textFieldAltura.setColumns(10);
        textFieldAltura.setBounds(107, 155, 295, 36);
        contentPane.add(textFieldAltura);

        JLabel lblPeso = new JLabel("PESO:");
        lblPeso.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
        lblPeso.setBounds(10, 220, 87, 61);
        contentPane.add(lblPeso);

        textFieldPeso = new JTextField();
        textFieldPeso.setColumns(10);
        textFieldPeso.setBounds(107, 235, 295, 36);
        contentPane.add(textFieldPeso);

        JLabel lblRenda = new JLabel("RENDA:");
        lblRenda.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 20));
        lblRenda.setBounds(10, 260, 87, 61);
        contentPane.add(lblRenda);

        textFieldRenda = new JTextField();
        textFieldRenda.setColumns(10);
        textFieldRenda.setBounds(107, 275, 295, 36);
        contentPane.add(textFieldRenda);
    }
}
