package DAO;

import Connection.ConnectionFactory;
import Funcionario.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    public boolean checkLogin(String cpf, String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE cpf = ? and senha = ?");
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
              check = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
    
    public void create(Funcionario f){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        // Verifica se o funcionario já existe com base no CNPJ e no nome
        stmt = con.prepareStatement("SELECT COUNT(*) FROM funcionario WHERE cpf = ? OR nome = ?");
        stmt.setString(1, f.getCpf());
        stmt.setString(2, f.getNome());
        rs = stmt.executeQuery();
        
        if (rs.next() && rs.getInt(1) == 0) {
            // Se funcionario não existe...
            stmt = con.prepareStatement("INSERT INTO funcionario (nome, cpf, endereco, telefone, cargo, cargaHoraria, salario, senha) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getCargo());
            stmt.setDouble(6, f.getCargaHoraria());
            stmt.setDouble(7, f.getSalario());
            stmt.setString(8, f.getSenha());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionario já existe!");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}

    
    public ArrayList<Funcionario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Funcionario> funcionarios = new ArrayList();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setIdFuncionario(Integer.valueOf(rs.getInt("idFuncionario")));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setCargaHoraria(Double.parseDouble(rs.getString("cargaHoraria")));
                funcionario.setSalario(Double.parseDouble(rs.getString("salario")));
                funcionario.setSenha(rs.getString("senha"));
                
                funcionarios.add(funcionario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return funcionarios;
    }
    
    public ArrayList<Funcionario> searchForName(String nome, String cpf){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Funcionario> funcionarios = new ArrayList();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE nome LIKE ? or cpf LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            stmt.setString(2, "%"+cpf+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setIdFuncionario(Integer.valueOf(rs.getInt("idFuncionario")));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setCargaHoraria(Double.parseDouble(rs.getString("cargaHoraria")));
                funcionario.setSalario(Double.parseDouble(rs.getString("salario")));
                funcionario.setSenha(rs.getString("senha"));
                
                funcionarios.add(funcionario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return funcionarios;
    }
    
    public void update(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome = ?, cpf = ?, endereco = ?, telefone = ?, cargo = ?, cargaHoraria = ?, salario = ? WHERE idFuncionario = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getCargo());
            stmt.setDouble(6, f.getCargaHoraria());
            stmt.setDouble(7, f.getSalario());
            stmt.setInt(8, f.getIdFuncionario());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE idFuncionario = ?");
            stmt.setInt(1, f.getIdFuncionario());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
}
}
