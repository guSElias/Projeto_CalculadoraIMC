package control;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DAO.Conexao;
import DAO.clienteDAO;

public class ValidaDadosUsuario {

	public static boolean isCpfValido(String cpf) {
		clienteDAO clienteDAO = new clienteDAO();

		if (clienteDAO.isCpfExistente(cpf)) {
			JOptionPane.showMessageDialog(null, "O cpf selecionado já existe");
			return false;
		}else {
			return cpf.length() == 11;
		}
	}

	public static boolean isCaracteresSenhaValidos(String senha) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*., ?]).+$";
		return senha.matches(regex);
	}

	public static boolean isSenhaValida(String senha) {
		return isCaracteresSenhaValidos(senha) && senha.length() >= 6 && senha.length() <= 15;
	}
}