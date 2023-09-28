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
public class VendaDAO {

    public ArrayList<Produto> read(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Produto> produtos = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT p.idProduto as pid, p.idFornecedor as pforn, p.nome as pnome, codigo, p.idcategoria as pcat, precoUn, precoCusto, estoque FROM produto p inner join fornecedor f on f.idFornecedor = p.idfornecedor inner join categoria c on p.idcategoria = c.idCategoria where idproduto = ?");
            stmt.setInt(1, p.getIdProduto());
            rs = stmt.executeQuery();
            System.out.println(stmt.toString());
            while (rs.next()) {

                Produto produto = new Produto();
                Fornecedor fornecedor = new Fornecedor();
                Categoria categoria = new Categoria();

                produto.setNome(rs.getString("pnome"));
                produto.setCodigo(rs.getString("codigo"));

                produto.setPrecoUn(rs.getDouble("precoUn"));

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
