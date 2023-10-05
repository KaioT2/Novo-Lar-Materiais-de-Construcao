/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Categoria.Categoria;
import java.sql.Connection;
import Connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaio Dias
 */
public class CategoriaDAO {

    public void create(Categoria c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM categoria WHERE descricao = ?");
            stmt.setString(1, c.getDescricao());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                stmt = con.prepareStatement("INSERT INTO categoria (descricao) VALUES(?)");
                stmt.setString(1, c.getDescricao());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente já existe!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Categoria> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Categoria> categorias = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM categoria ORDER BY descricao");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setDescricao(rs.getString("descricao"));

                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return categorias;
    }

    public ArrayList<Categoria> searchForName(String descricao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Categoria> categorias = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM categoria WHERE descricao LIKE ?");
            stmt.setString(1, "%" + descricao + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setDescricao(rs.getString("descricao"));

                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return categorias;
    }

    public void update(Categoria c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE categoria SET descricao = ? WHERE idcategoria = ?");
            stmt.setString(1, c.getDescricao());
            stmt.setInt(2, c.getIdCategoria());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Categoria c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?");
            stmt.setInt(1, c.getIdCategoria());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
