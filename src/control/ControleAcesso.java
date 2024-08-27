package control;

import DAO.UsuarioDAO;

public class ControleAcesso {

	public static boolean efetuaLogin(String cpf, String senha) {

		UsuarioDAO bdUsuario = new UsuarioDAO();
		return bdUsuario.isUsuarioValido(cpf, senha);

	}
}