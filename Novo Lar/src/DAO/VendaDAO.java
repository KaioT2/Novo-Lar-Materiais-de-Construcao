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

/**
 *
 * @author Kaio Dias
 */
public class VendaDAO {
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
                produto.setEstoque(rs.getInt("estoque"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }
}
