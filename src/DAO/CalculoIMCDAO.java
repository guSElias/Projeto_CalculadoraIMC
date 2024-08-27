package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.CalculoIMC;

public class CalculoIMCDAO {

    public boolean salvarCalculoIMC(CalculoIMC calculoIMC) {
        Connection conexao = null;
        PreparedStatement codigo = null;

        try {
            conexao = Conexao.conectarBD();
            String sql = "INSERT INTO calculos_imc (cpf_usuario, peso, altura, imc, data_consulta) VALUES (?, ?, ?, ?, ?)";
            codigo = conexao.prepareStatement(sql);

            codigo.setString(1, calculoIMC.getCpfUsuario());
            codigo.setDouble(2, calculoIMC.getPeso());
            codigo.setDouble(3, calculoIMC.getAltura());
            codigo.setDouble(4, calculoIMC.getImc());
            codigo.setDate(5, new java.sql.Date(calculoIMC.getDataConsulta().getTime()));

            codigo.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conexao, codigo);
        }
    }

    public List<CalculoIMC> getCalculosIMCByCPF(String cpfUsuario) {
        List<CalculoIMC> calculos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement codigo = null;
        ResultSet dadosBD = null;

        try {
            conexao = Conexao.conectarBD();
            String sql = "SELECT * FROM calculos_imc WHERE cpf_usuario = ?";
            codigo = conexao.prepareStatement(sql);
            codigo.setString(1, cpfUsuario);

            dadosBD = codigo.executeQuery();

            while (dadosBD.next()) {
                int id = dadosBD.getInt("id");
                double peso = dadosBD.getDouble("peso");
                double altura = dadosBD.getDouble("altura");
                double imc = dadosBD.getDouble("imc");
                Date dataConsulta = dadosBD.getDate("data_consulta");

                CalculoIMC calculo = new CalculoIMC(id, cpfUsuario, peso, altura, imc, dataConsulta);
                calculos.add(calculo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conexao, codigo, dadosBD);
        }

        return calculos;
    }

    // Método para fechar as conexões e recursos
    private void closeResources(Connection conexao, PreparedStatement codigo) {
        try {
            if (codigo != null) {
                codigo.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para fechar as conexões, código SQL e dados do banco
    private void closeResources(Connection conexao, PreparedStatement codigo, ResultSet dadosBD) {
        try {
            if (dadosBD != null) {
                dadosBD.close();
            }
            closeResources(conexao, codigo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
