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
    public void create(Cliente f){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        stmt = con.prepareStatement("SELECT COUNT(*) FROM cliente WHERE cpf = ? OR nome = ?");
        stmt.setString(1, f.getCpf());
        stmt.setString(2, f.getNome());
        rs = stmt.executeQuery();
        
        if (rs.next() && rs.getInt(1) == 0) {
            stmt = con.prepareStatement("INSERT INTO cliente (nome, cpf, endereco, telefone) VALUES(?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getTelefone());

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

    
    public ArrayList<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> clientees = new ArrayList();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(Integer.valueOf(rs.getInt("idCliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                
                clientees.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientees;
    }
    
    public ArrayList<Cliente> searchForName(String nome, String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> clientees = new ArrayList();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? or cpf LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            stmt.setString(2, "%"+cpf+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(Integer.valueOf(rs.getInt("idCliente")));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                
                clientees.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientees;
    }
    
    public void update(Cliente f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, endereco = ?, telefone = ? WHERE idCliente = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getTelefone());
            stmt.setInt(5, f.getIdCliente());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Cliente f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            stmt.setInt(1, f.getIdCliente());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
}
}
