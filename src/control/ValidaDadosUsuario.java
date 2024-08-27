package control;

public class ValidaDadosUsuario {

	public static boolean isCpfValido(String cpf) {
		return cpf.length() == 11;
	}

	public static boolean isCaracteresSenhaValidos(String senha) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*., ?]).+$";
		return senha.matches(regex);
	}

	public static boolean isSenhaValida(String senha) {
		return isCaracteresSenhaValidos(senha) && senha.length() >= 6 && senha.length() <= 15;
	}
}