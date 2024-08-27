package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {

	public boolean isUsuarioValido(String cpf, String senha) {
		//comando SQL que será executado
		// ? significa parametro, que o valor será encaminhando durante a execuçao
		String sql =  "SELECT * from cadastro where CPF = ? and senha = ?";

		PreparedStatement codigo = null;

		try {	
			//cria um objeto para a conexao, atribui a conexao e o codigo sql a ser executado
			codigo = Conexao.conectarBD().prepareStatement(sql);

			//encaminha o valor para os parametros ? do codigo sql
			codigo.setString(1, cpf);
			codigo.setString(2, senha);

			//cria objeto que permite receber o conjunto de resultados do BD = ResultSet
			//executa o codigo sql em modo busca consulta = query
			ResultSet dadosBD = codigo.executeQuery();

			//verifica se h� valor de retorno no objeto ResultSet, ou seja no dadosBD
			if (dadosBD.next()) { 

				//pegar a senha cadastrada no BD e atribuir a variavel senhaBD
				String senhaBD = dadosBD.getString("senha");

				//verificar se a senhaBD é igual a senha digitada, considerando case sensitive
				if(senhaBD.equals(senha)) 
					return true;
				else 
					return false;

			}else  
				return false;			

		}catch (Exception e) {
			System.out.println("ERRO isUsuarioValido  usuarioDAO.....");
			e.printStackTrace();
			return false;
		} finally {
			try {
				codigo.close();
			} catch (SQLException e) {
				System.out.println("ERRO no codigo.close do isUsuarioValido.....");
				e.printStackTrace();
			}
		}	
	}

	public boolean isLoginExistente(String cpf) {
		String sql =  "SELECT * from cadastro where CPF = ?";

		PreparedStatement codigo = null;

		try {	
			codigo = Conexao.conectarBD().prepareStatement(sql);

			codigo.setString(1, cpf);

			ResultSet dadosBD = codigo.executeQuery();

			if (dadosBD.next())  
				return true;
			else 
				return false;

		}catch (Exception e) {
			System.out.println("ERRO isUsuarioExistente  usuarioDAO.....");
			e.printStackTrace();
			return false;
		} finally {
			try {
				codigo.close();
			} catch (SQLException e) {
				System.out.println("ERRO no codigo.close do isUsuarioExistente.....");
				e.printStackTrace();
			}
		}	
	}

	public boolean cadastraUsuario(Usuario usuario) {
		String sql = "INSERT INTO cadastro (CPF, nome, senha)"
				+ " VALUES (?,?,?)";

		PreparedStatement codigo = null;

		try {
			codigo = Conexao.conectarBD().prepareStatement(sql);
			codigo.setString(1, usuario.getCpf());
			codigo.setString(2, usuario.getNome());
			codigo.setString(3,usuario.getSenha());

			codigo.execute();

			return true;

		} catch (SQLException e) {
			System.out.println("Erro ao inserir dado  usuario no banco! ");
			e.printStackTrace();
			return false;
		}	finally {
			try {
				codigo.close();
			} catch (SQLException e) {
				System.out.println("Erro codigo.close cadastra usuario! ");
				e.printStackTrace();
			}
		}
	}

	public Usuario dadosUsuario(String cpf) {
		String sql =  "SELECT * from cadastro where cpf = ?";

		PreparedStatement codigo = null;

		try {	
			codigo = Conexao.conectarBD().prepareStatement(sql);

			codigo.setString(1, cpf);

			ResultSet dadosBD = codigo.executeQuery();

			if (dadosBD.next()) {
				Usuario usuario = new Usuario();
				usuario.setCpf(dadosBD.getString("cpf"));
				usuario.setNome(dadosBD.getString("nome"));
				usuario.setSenha(dadosBD.getString("senha"));


				return usuario;
			} else 
				return null;

		}catch (Exception e) {
			System.out.println("ERRO isUsuarioExistente  usuarioDAO.....");
			e.printStackTrace();
			return null;
		} finally {
			try {
				codigo.close();
			} catch (SQLException e) {
				System.out.println("ERRO no codigo.close do isUsuarioExistente.....");
				e.printStackTrace();
			}
		}	
	}

	public boolean alteraDadosUsuario(Usuario usuario) {
		String sql = "UPDATE cadastro SET"
				+ " cpf = ?,"
				+ " nome = ?,"
				+ " senha = ?"
				+ " WHERE cpf = ?";


		PreparedStatement codigo = null;

		try {
			codigo = Conexao.conectarBD().prepareStatement(sql);
			codigo.setString(1, usuario.getCpf());
			codigo.setString(2,usuario.getNome());
			codigo.setString(3, usuario.getSenha());
			codigo.setString(4, usuario.getCpf());

			codigo.execute();

			return true;

		} catch (SQLException e) {
			System.out.println("Erro ao alterar dados usuario no banco! ");
			e.printStackTrace();
			return false;
		}	finally {
			try {
				codigo.close();
			} catch (SQLException e) {
				System.out.println("Erro codigo.close cadastra usuario! ");
				e.printStackTrace();
			}
		}
	}

	public boolean deletaUsuario(String cpf) {
		String sql = "DELETE FROM cadastro WHERE cpf = ?";

		PreparedStatement codigo = null;

		try {
			codigo = Conexao.conectarBD().prepareStatement(sql);

			codigo.setString(1, cpf);

			codigo.execute();

			return true;

		} catch (SQLException e) {
			System.out.println("Erro ao deletar usuario no banco! ");
			e.printStackTrace();
			return false;

		}	finally {
			try {
				codigo.close();
			} catch (SQLException e) {
				System.out.println("Erro codigo.close cadastra usuario! ");
				e.printStackTrace();
			}
		}
	}

}