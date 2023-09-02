package DAO;

import java.sql.Connection;
import Connection.ConnectionFactory;
import Fornecedor.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FornecedorDAO {

    public void create(Fornecedor f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM fornecedor WHERE cnpj = ? OR nome = ?");
            stmt.setString(1, f.getCnpj());
            stmt.setString(2, f.getNome());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                stmt = con.prepareStatement("INSERT INTO fornecedor (nome, endereco, bairro, cidade, estado, cep, telefone, email, cnpj) VALUES(?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, f.getNome());
                stmt.setString(2, f.getEndereco());
                stmt.setString(3, f.getBairro());
                stmt.setString(4, f.getCidade());
                stmt.setString(5, f.getEstado());
                stmt.setString(6, f.getCep());
                stmt.setString(7, f.getTelefone());
                stmt.setString(8, f.getEmail());
                stmt.setString(9, f.getCnpj());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor já existe!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Fornecedor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Fornecedor> fornecedores = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedor");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(Integer.valueOf(rs.getInt("idFornecedor")));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setEstado(rs.getString("estado"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));

                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }

    public ArrayList<Fornecedor> searchForName(String nome, String cnpj) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Fornecedor> fornecedores = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedor WHERE nome LIKE ? or cnpj LIKE ?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + cnpj + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(Integer.valueOf(rs.getInt("idFornecedor")));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setEstado(rs.getString("estado"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCnpj(rs.getString("cnpj"));

                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }

    public void update(Fornecedor f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE fornecedor SET nome = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, telefone = ?, email = ?, cnpj = ? WHERE idFornecedor = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getBairro());
            stmt.setString(4, f.getCidade());
            stmt.setString(5, f.getEstado());
            stmt.setString(6, f.getCep());
            stmt.setString(7, f.getTelefone());
            stmt.setString(8, f.getEmail());
            stmt.setString(9, f.getCnpj());
            stmt.setInt(10, f.getIdFornecedor());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Fornecedor f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM fornecedor WHERE idFornecedor = ?");
            stmt.setInt(1, f.getIdFornecedor());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
