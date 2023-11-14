/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Compra.Compra;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaio Dias
 */
public class CompraDAO {

    public int numCompra() { //Método que conta o número de compras para setar um a mais na tela de cmpra
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int numLinhas = 0;
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM compra");
            rs = stmt.executeQuery();

            
            if (rs.next()) {
                numLinhas = rs.getInt(1); //Pega o número de linhas
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao contar as linhas: " + ex.getMessage());

            return 0;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); 
        }
        return numLinhas;
    }

    public void create(Compra c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Verifica se a compra já existe com base no CNPJ e no nome
            stmt = con.prepareStatement("SELECT COUNT(*) FROM compra WHERE idCompra = ?");
            stmt.setInt(1, c.getIdCompra());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                // Se compra não existe...
                stmt = con.prepareStatement("INSERT INTO compra (dataCompra, total, idfuncionario, idfornecedor, desconto) VALUES(?,?,?,?,?)");
                stmt.setString(1, c.getDataCompra());
                stmt.setDouble(2, c.getTotal());
                stmt.setInt(3, c.getFuncionario().getIdFuncionario());
                stmt.setInt(4, c.getFornecedor().getIdFornecedor());
                stmt.setDouble(5, c.getDesconto());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Compra já existe!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar2: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
