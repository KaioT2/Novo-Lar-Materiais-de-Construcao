package DAO;

import java.sql.Connection;
import Connection.ConnectionFactory;
import Cliente.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public void create(Cliente f) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM cliente WHERE cpf = ? OR nome = ?");
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNome());
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                stmt = con.prepareStatement("INSERT INTO cliente (nome, endereco, bairro, cidade, estado, cep, cnpj, cpf, sexo, dataNasc, telefone, email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, f.getNome());
                stmt.setString(2, f.getEndereco());
                stmt.setString(3, f.getBairro());
                stmt.setString(4, f.getCidade());
                stmt.setString(5, f.getEstado());
                stmt.setString(6, f.getCep());
                stmt.setString(7, f.getCnpj());
                stmt.setString(8, f.getCpf());
                stmt.setString(9, f.getSexo());
                stmt.setString(10, f.getDataNasc());
                stmt.setString(11, f.getTelefone());
                stmt.setString(12, f.getEmail());

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

    public ArrayList<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente order by nome");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setDataNasc(rs.getString("dataNasc"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;
    }

    public ArrayList<Cliente> searchForName(String nome, String cpf, String cnpj) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientees = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? or cpf LIKE ? OR cnpj LIKE ?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + cpf + "%");
            stmt.setString(3, "%" + cnpj + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setDataNasc(rs.getString("dataNasc"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));

                clientees.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientees;
    }

    public void update(Cliente f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, cnpj = ?, cpf = ?, sexo = ?, dataNasc = ?, telefone = ?, email = ? WHERE idCliente = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getBairro());
            stmt.setString(4, f.getCidade());
            stmt.setString(5, f.getEstado());
            stmt.setString(6, f.getCep());
            stmt.setString(7, f.getCnpj());
            stmt.setString(8, f.getCpf());
            stmt.setString(9, f.getSexo());
            stmt.setString(10, f.getDataNasc());
            stmt.setString(11, f.getTelefone());
            stmt.setString(12, f.getEmail());
            stmt.setInt(13, f.getIdCliente());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Cliente f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            stmt.setInt(1, f.getIdCliente());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Cliente> aniversariantesDoMes() { //Método que filtra os clientes que nasceram no mês atual
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> clientes = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT nome, dataNasc FROM cliente WHERE MONTH(dataNasc) = MONTH(CURRENT_DATE) ORDER BY dataNasc");
            rs = stmt.executeQuery();

            while (rs.next()) {
                //Se encontrar algúm cliente cria um objeto de cliente e preenche o nome e a data de nascimento
                Cliente cliente = new Cliente();

                cliente.setNome(rs.getString("nome"));
                cliente.setDataNasc(rs.getString("dataNasc"));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;
    }
}
