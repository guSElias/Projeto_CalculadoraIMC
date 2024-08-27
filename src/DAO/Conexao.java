package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static String url = "jdbc:mysql://localhost:3306/Projeto_imc"; //Nome da base de dados
	private static String user = "root"; //nome do usuario do mysql
	private static String password = ""; //senha do mysql



	public static Connection conectarBD() {
		try{
			Connection conexao = DriverManager.getConnection(url, user, password);
			return conexao;

		}catch(SQLException sqlErro) {
			System.out.println("ERRO: Conex�o");
			return null;
		} 
	}	
}