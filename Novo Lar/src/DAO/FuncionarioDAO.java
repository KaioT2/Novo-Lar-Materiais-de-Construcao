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

    public int checkLogin(String cpf, String senha) {
        Connection con = ConnectionFactory.getConnection(); //Cria uma conexão com o BD
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int permissao = -1; //Se o lohin falhar permissão = -1

        try {
            //Consulta a permissão com base no cpf e senha
            stmt = con.prepareStatement("SELECT permissao FROM funcionario WHERE cpf = ? AND senha = ?");
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            rs = stmt.executeQuery(); //Executa o código SQL

            if (rs.next()) { //Se achar algúm funcionário, pega o nível de permissão
                permissao = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); //Fecha a conexão
        }
        return permissao;
    }
    
    public void create(Funcionario f) { //Insere um novo funcionário ao BD
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Verifica se o funcionario já existe com base no CNPJ e no nome
            stmt = con.prepareStatement("SELECT COUNT(*) FROM funcionario WHERE cpf = ? OR nome = ?");
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNome());
            rs = stmt.executeQuery(); //Executa o código SQL

            if (rs.next() && rs.getInt(1) == 0) {
                // Se funcionario não existe...
                stmt = con.prepareStatement("INSERT INTO funcionario (nome, endereco, bairro, cidade, estado, cep, telefone, email, cpf, dataNasc, dataContrata, senha, cargo, cargaHoraria, salario, status, permissao) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, f.getNome());
                stmt.setString(2, f.getEndereco());
                stmt.setString(3, f.getBairro());
                stmt.setString(4, f.getCidade());
                stmt.setString(5, f.getEstado());
                stmt.setString(6, f.getCEP());
                stmt.setString(7, f.getTelefone());
                stmt.setString(8, f.getEmail());
                stmt.setString(9, f.getCpf());
                stmt.setString(10, f.getDataNasc());
                stmt.setString(11, f.getDataContratacao());
                stmt.setString(12, f.getSenha());
                stmt.setString(13, f.getCargo());
                stmt.setDouble(14, f.getCargaHoraria());
                stmt.setDouble(15, f.getSalario());
                stmt.setString(16, f.getStatus());
                stmt.setInt(17, f.getPermissao());

                stmt.executeUpdate(); //Executa o código SQL
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

    public ArrayList<Funcionario> read() { //Leitura da tabela de funcionários 
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Funcionario> funcionarios = new ArrayList(); //Lista que armazena funcionários

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario order by nome");
            rs = stmt.executeQuery(); //Executa o código SQL

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setEstado(rs.getString("estado"));
                funcionario.setCEP(rs.getString("cep"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargaHoraria(Double.parseDouble(rs.getString("cargaHoraria")));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDataNasc(rs.getString("dataNasc"));
                funcionario.setDataContratacao(rs.getString("dataContrata"));
                funcionario.setSalario(Double.parseDouble(rs.getString("salario")));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setPermissao(rs.getInt("permissao"));
                funcionario.setStatus(rs.getString("status"));

                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcionarios;
    }
    
    public ArrayList<Funcionario> searchForName(String nome, String cpf) {//Busca de funcionários por nome e/ou CPF
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Funcionario> funcionarios = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE nome LIKE ? or cpf LIKE ?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + cpf + "%");
            rs = stmt.executeQuery(); //Executa o código SQL

            while (rs.next()) {
                //Para cada funcionário que achar cria um objeto de Funcionário
                Funcionario funcionario = new Funcionario();

                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setEstado(rs.getString("estado"));
                funcionario.setCEP(rs.getString("cep"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargaHoraria(Double.parseDouble(rs.getString("cargaHoraria")));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDataNasc(rs.getString("dataNasc"));
                funcionario.setDataContratacao(rs.getString("dataContrata"));
                funcionario.setSalario(Double.parseDouble(rs.getString("salario")));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setPermissao(rs.getInt("permissao"));
                funcionario.setStatus(rs.getString("status"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcionarios;
    }
    
    public void update(Funcionario f) {//Método que atualiza os dados de um funcionário

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, telefone = ?, email = ?, cpf = ?, dataNasc = ?, dataContrata = ?, cargo = ?, cargaHoraria = ?, status = ?, permissao = ? WHERE idFuncionario = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEndereco());
            stmt.setString(3, f.getBairro());
            stmt.setString(4, f.getCidade());
            stmt.setString(5, f.getEstado());
            stmt.setString(6, f.getCEP());
            stmt.setString(7, f.getTelefone());
            stmt.setString(8, f.getEmail());
            stmt.setString(9, f.getCpf());
            stmt.setString(10, f.getDataNasc());
            stmt.setString(11, f.getDataContratacao());
            stmt.setString(12, f.getCargo());
            stmt.setDouble(13, f.getCargaHoraria());
            stmt.setString(14, f.getStatus());
            stmt.setInt(15, f.getPermissao());
            stmt.setInt(16, f.getIdFuncionario());

            stmt.executeUpdate(); //Executa o código SQL
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Funcionario f) { //Método que deleta um fucnionário do BD

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE idFuncionario = ?");
            stmt.setInt(1, f.getIdFuncionario());

            stmt.executeUpdate(); //Executa o código SQL
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public String nomeDeUsuario(String cpf, String senha) { //Pega o usuário com base nos dados de login
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nome = "";

        try {
            stmt = con.prepareStatement("SELECT nome FROM funcionario WHERE cpf = ? AND senha = ?");
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                nome = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nome;
    }
}
