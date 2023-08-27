package Funcionario;

public class Funcionario {
    private String nome;
    private String endereco;
    private String cpf;
    private double cargaHoraria;
    private String cargo;
    private double salario;
    private String telefone;

    public Funcionario(String nome, String endereco, String cpf, double cargaHoraria, String cargo, double salario, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cargaHoraria = cargaHoraria;
        this.cargo = cargo;
        this.salario = salario;
        this.telefone = telefone;
    }    

    public Funcionario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
