/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.ConnectionFactory;
import Venda.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaio Dias
 */
public class VendaDAO {

    public int numVendas() { //Conta o número de vendas para setar o id da venda ao arir a tela de venda
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int numLinhas = 0;
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM venda");
            rs = stmt.executeQuery();

            if (rs.next()) {
                numLinhas = rs.getInt(1); // Obtém o valor da primeira coluna do resultado
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao contar as linhas: " + ex.getMessage());

            return 0;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); // Certifique-se de fechar o ResultSet também
        }
        return numLinhas;
    }

    public void create(Venda v) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Verifica se a venda já existe com base no CNPJ e no nome
            stmt = con.prepareStatement("SELECT COUNT(*) FROM venda WHERE idvenda = ?");
            stmt.setInt(1, v.getIdVenda());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                // Se venda não existe...
                stmt = con.prepareStatement("INSERT INTO venda (dataVenda, total, idCliente, idFuncionario, status_venda, desconto) VALUES(?,?,?,?,?,?)");
                stmt.setString(1, v.getDataVenda());
                stmt.setDouble(2, v.getTotal());
                stmt.setInt(3, v.getCliente().getIdCliente());
                stmt.setInt(4, v.getFuncionario().getIdFuncionario());
                stmt.setString(5, v.getStatusVenda());
                stmt.setDouble(6, v.getDesconto());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Venda já existe!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar2: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public int numVendasMes() { //Conta as vendas do mês atual
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int numLinhas = 0;
        try {
            stmt = con.prepareStatement("SELECT count(*) FROM venda WHERE MONTH(dataVenda) = MONTH(NOW());");
            rs = stmt.executeQuery();

            if (rs.next()) {
                numLinhas = rs.getInt(1); // Obtém o valor da primeira coluna do resultado
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao contar as linhas: " + ex.getMessage());

            return 0;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); 
        }
        return numLinhas;
    }
    
    public double totalVendasMes() { //Soma o total das vendas do mês
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int numLinhas = 0;
        try {
            stmt = con.prepareStatement("SELECT sum(total) FROM venda WHERE MONTH(dataVenda) = MONTH(NOW());");
            rs = stmt.executeQuery();

            // Move o cursor para a primeira linha do resultado (se houver)
            if (rs.next()) {
                numLinhas = rs.getInt(1); // Obtém o valor da primeira coluna do resultado
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao contar as linhas: " + ex.getMessage());

            return 0;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); 
        }
        return numLinhas;
    }
}
