package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class clienteDAO {

    public boolean isClienteValido(String cpf, String senha) {
        String sql =  "SELECT * from cliente where CPF = ? and senha = ?";

        if (cpf == null || cpf.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            return false;
        }
        
        PreparedStatement codigo = null;

        try {    
            codigo = Conexao.conectarBD().prepareStatement(sql);
            codigo.setString(1, cpf);
            codigo.setString(2, senha);

            ResultSet dadosBD = codigo.executeQuery();

            if (dadosBD.next()) { 
                String senhaBD = dadosBD.getString("senha");

                if(senhaBD.equals(senha)) 
                    return true;
                else 
                    return false;

            } else {  
                return false;            
            }

        } catch (Exception e) {
            System.out.println("ERRO isClienteValido ClienteDAO.....");
            e.printStackTrace();
            return false;
        } finally {
            try {
                codigo.close();
            } catch (SQLException e) {
                System.out.println("ERRO no codigo.close do isClienteValido.....");
                e.printStackTrace();
            }
        }    
    }

    public boolean isCpfExistente(String cpf) {
        String sql =  "SELECT * from cliente where CPF = ?";

        PreparedStatement codigo = null;

        try {    
            codigo = Conexao.conectarBD().prepareStatement(sql);
            codigo.setString(1, cpf);

            ResultSet dadosBD = codigo.executeQuery();

            if (dadosBD.next())  
                return true;
            else 
                return false;

        } catch (Exception e) {
            System.out.println("ERRO isCpfExistente ClienteDAO.....");
            e.printStackTrace();
            return false;
        } finally {
            try {
                codigo.close();
            } catch (SQLException e) {
                System.out.println("ERRO no codigo.close do isCpfExistente.....");
                e.printStackTrace();
            }
        }    
    }

    public boolean cadastraCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (CPF, nome, idade, altura, peso, senha, renda)"
                   + " VALUES (?,?,?,?,?,?,?)";

        PreparedStatement codigo = null;

        try {
            codigo = Conexao.conectarBD().prepareStatement(sql);
            codigo.setString(1, cliente.getCpf());
            codigo.setString(2, cliente.getNome());
            codigo.setInt(3, cliente.getIdade());
            codigo.setDouble(4, cliente.getAltura());
            codigo.setDouble(5, cliente.getPeso());
            codigo.setString(6, cliente.getSenha());
            codigo.setDouble(7, cliente.getRenda());

            codigo.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados do cliente no banco! ");
            e.printStackTrace();
            return false;
        } finally {
            try {
                codigo.close();
            } catch (SQLException e) {
                System.out.println("Erro no codigo.close cadastra cliente! ");
                e.printStackTrace();
            }
        }
    }

    public Cliente dadosCliente(String cpf) {
        String sql =  "SELECT * from cliente where cpf = ?";

        PreparedStatement codigo = null;

        try {    
            codigo = Conexao.conectarBD().prepareStatement(sql);
            codigo.setString(1, cpf);

            ResultSet dadosBD = codigo.executeQuery();

            if (dadosBD.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(dadosBD.getString("cpf"));
                cliente.setNome(dadosBD.getString("nome"));
                cliente.setIdade(dadosBD.getInt("idade"));
                cliente.setAltura(dadosBD.getDouble("altura"));
                cliente.setPeso(dadosBD.getDouble("peso"));
                cliente.setSenha(dadosBD.getString("senha"));
                cliente.setRenda(dadosBD.getDouble("renda"));

                return cliente;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO dadosCliente ClienteDAO.....");
            e.printStackTrace();
            return null;
        } finally {
            try {
                codigo.close();
            } catch (SQLException e) {
                System.out.println("ERRO no codigo.close do dadosCliente.....");
                e.printStackTrace();
            }
        }    
    }

    public boolean alteraDadosCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET"
                   + " nome = ?,"
                   + " idade = ?,"
                   + " altura = ?,"
                   + " peso = ?,"
                   + " senha = ?,"
                   + " renda = ?"
                   + " WHERE cpf = ?";

        PreparedStatement codigo = null;

        try {
            codigo = Conexao.conectarBD().prepareStatement(sql);
            codigo.setString(1, cliente.getNome());
            codigo.setInt(2, cliente.getIdade());
            codigo.setDouble(3, cliente.getAltura());
            codigo.setDouble(4, cliente.getPeso());
            codigo.setString(5, cliente.getSenha());
            codigo.setDouble(6, cliente.getRenda());
            codigo.setString(7, cliente.getCpf());

            codigo.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do cliente no banco! ");
            e.printStackTrace();
            return false;
        } finally {
            try {
                codigo.close();
            } catch (SQLException e) {
                System.out.println("Erro no codigo.close altera cliente! ");
                e.printStackTrace();
            }
        }
    }

    public boolean deletaCliente(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        PreparedStatement codigo = null;

        try {
            codigo = Conexao.conectarBD().prepareStatement(sql);
            codigo.setString(1, cpf);

            codigo.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente no banco! ");
            e.printStackTrace();
            return false;

        } finally {
            try {
                codigo.close();
            } catch (SQLException e) {
                System.out.println("Erro no codigo.close deleta cliente! ");
                e.printStackTrace();
            }
        }
    }
}
