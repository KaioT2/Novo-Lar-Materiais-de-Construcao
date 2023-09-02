package Funcionario;

public class Funcionario {
    private int idFuncionario;
    private String senha;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String CEP;
    private String estado;
    private String cpf;
    private double cargaHoraria;
    private String cargo;
    private double salario;
    private String telefone;
    private String email;
    private String dataNasc;
    private String dataContratacao;
    private String status;
    private int permissao;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String senha, String nome, String endereco, String bairro, String cidade, String CEP, String estado, String cpf, double cargaHoraria, String cargo, double salario, String telefone, String email, String dataNasc, String dataContratacao, String status, int permissao) {
        this.idFuncionario = idFuncionario;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.CEP = CEP;
        this.estado = estado;
        this.cpf = cpf;
        this.cargaHoraria = cargaHoraria;
        this.cargo = cargo;
        this.salario = salario;
        this.telefone = telefone;
        this.email = email;
        this.dataNasc = dataNasc;
        this.dataContratacao = dataContratacao;
        this.status = status;
        this.permissao = permissao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    
}
