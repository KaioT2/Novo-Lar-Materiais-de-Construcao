/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Categoria.Categoria;
import Connection.ConnectionFactory;
import Fornecedor.Fornecedor;
import Produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaio Dias
 */
public class ProdutoDAO {
    
    
    public void create(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM produto WHERE codigo = ? OR nome = ?");
            stmt.setString(1, String.valueOf(p.getCodigo()));
            stmt.setString(2, p.getNome());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                stmt = con.prepareStatement("INSERT INTO produto (idFornecedor, nome, codigo, idCategoria, precoUn, precoCusto, estoque) VALUES(?,?,?,?,?,?,?)");
                stmt.setInt(1, p.getFornecedor().getIdFornecedor());
                stmt.setString(2, p.getNome());
                stmt.setInt(3, p.getCodigo());
                stmt.setInt(4, p.getCategoria().getIdCategoria());
                stmt.setDouble(5, p.getPrecoUn());
                stmt.setDouble(6, p.getPrecoCusto());
                stmt.setDouble(7, p.getEstoque());
                

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Produto já existe!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Produto> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Produto> produtos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT p.idProduto as pid, p.idFornecedor as pforn, p.nome as pnome, codigo, p.idcategoria as pcat, precoUn, precoCusto, estoque FROM produto p inner join fornecedor f on f.idFornecedor = p.idfornecedor inner join categoria c on p.idcategoria = c.idCategoria");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                Fornecedor fornecedor = new Fornecedor();
                Categoria categoria = new Categoria();

                produto.setIdProduto(rs.getInt("pid"));
                
                fornecedor.setIdFornecedor(rs.getInt("pforn"));
                produto.setFornecedor(fornecedor);
                
                produto.setNome(rs.getString("pnome"));
                produto.setCodigo(rs.getInt("codigo"));
                
                categoria.setIdCategoria(rs.getInt("pcat"));
                produto.setCategoria(categoria);
                
                produto.setPrecoCusto(rs.getDouble("precoCusto"));
                produto.setPrecoUn(rs.getDouble("precoUn"));
                produto.setEstoque(rs.getDouble("estoque"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public ArrayList<Produto> searchForName(String nome, String codigo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Produto> produtos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE nome LIKE ? or codigo LIKE ?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + codigo + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                Fornecedor fornecedor = new Fornecedor();
                Categoria categoria = new Categoria();

                produto.setIdProduto(rs.getInt("idProduto"));
                
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                produto.setFornecedor(fornecedor);
                
                produto.setNome(rs.getString("nome"));
                produto.setCodigo(rs.getInt("codigo"));
                
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                produto.setCategoria(categoria);
                
                produto.setPrecoCusto(rs.getDouble("precoCusto"));
                produto.setPrecoUn(rs.getDouble("precoUn"));
                produto.setEstoque(rs.getDouble("estoque"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public void update(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET idFornecedor = ?, nome = ?, codigo = ?, idCategoria = ?, precoUn = ?, precoCusto = ? estoque = ? WHERE idProduto = ?");
                stmt.setInt(1, p.getFornecedor().getIdFornecedor());
                stmt.setString(2, p.getNome());
                stmt.setInt(3, p.getCodigo());
                stmt.setInt(4, p.getCategoria().getIdCategoria());
                stmt.setDouble(5, p.getPrecoUn());
                stmt.setDouble(6, p.getPrecoCusto());
                stmt.setDouble(7, p.getEstoque());
                stmt.setInt(8, p.getIdProduto());
                
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, p.getIdProduto());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
