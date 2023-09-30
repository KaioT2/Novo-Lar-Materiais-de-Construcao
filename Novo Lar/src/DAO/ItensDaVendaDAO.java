/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.ConnectionFactory;
import Itens_da_Venda.ItensDaVenda;
import Produto.Produto;
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
public class ItensDaVendaDAO {
    public void create(ItensDaVenda iv) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Verifica se a venda já existe com base no CNPJ e no nome
            stmt = con.prepareStatement("SELECT COUNT(*) FROM itens_da_venda WHERE idItemVenda = ?");
            stmt.setInt(1, iv.getIdItemVenda());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                // Se venda não existe...
                stmt = con.prepareStatement("INSERT INTO itens_da_venda (idVenda, data, idProduto, quantidade, precoUn, desconto, total) VALUES(?,?,?,?,?,?,?)");
                stmt.setInt(1, iv.getVenda().getIdVenda());
                stmt.setString(2, iv.getData());
                stmt.setInt(3, iv.getProduto().getIdProduto());
                stmt.setDouble(4, iv.getQuantidade());
                stmt.setDouble(5, iv.getProduto().getPrecoUn());
                stmt.setDouble(6, iv.getDesconto());
                stmt.setDouble(7, iv.getSubtotal());

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
    
    public void atualizarEstoque(ItensDaVenda iv){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET estoque = estoque - ? WHERE idProduto = ?");
            stmt.setDouble(1, iv.getQuantidade());
            stmt.setInt(2, iv.getProduto().getIdProduto());

            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
