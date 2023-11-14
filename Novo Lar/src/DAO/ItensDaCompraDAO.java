/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.ConnectionFactory;
import Itens_da_Compra.ItensDaCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaio Dias
 */
public class ItensDaCompraDAO {
    public void create(ItensDaCompra ic) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            stmt = con.prepareStatement("SELECT COUNT(*) FROM itens_da_compra WHERE idItemCompra = ?");
            stmt.setInt(1, ic.getIdItemCompra());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                // Se compra não existe...
                stmt = con.prepareStatement("INSERT INTO itens_da_compra (idcompra, idproduto, quantidade, precoCusto, desconto, total) VALUES(?,?,?,?,?,?)");
                stmt.setInt(1, ic.getCompra().getIdCompra());
                stmt.setInt(2, ic.getProduto().getIdProduto());
                stmt.setDouble(3, ic.getQuantidade());
                stmt.setDouble(4, ic.getProduto().getPrecoCusto());
                stmt.setDouble(5, ic.getDesconto());
                stmt.setDouble(6, ic.getSubtotal());

                stmt.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Item já existe!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar1: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void atualizarEstoque(ItensDaCompra ic){ //Método que atualiza o estoque do produto conforme a quantidade comprada
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET estoque = estoque + ? WHERE idProduto = ?");
            stmt.setDouble(1, ic.getQuantidade());
            stmt.setInt(2, ic.getProduto().getIdProduto());

            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
