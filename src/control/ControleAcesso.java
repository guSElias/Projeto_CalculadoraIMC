package control;

import DAO.clienteDAO;

public class ControleAcesso {

	public static boolean efetuaLogin(String cpf, String senha) {

		clienteDAO bdUsuario = new clienteDAO();
		return bdUsuario.isClienteValido(cpf, senha);

	}
}