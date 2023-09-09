/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compra;

import Fornecedor.Fornecedor;
import Funcionario.Funcionario;
import Produto.Produto;

/**
 *
 * @author Kaio Dias
 */
public class Compra {
    private int idCompra;
    private Fornecedor fornecedor;
    private Produto produto;
    private Funcionario funcionario;
    private double total;
    private String dataCompra;

    public Compra() {
    }

    public Compra(int idCompra, Fornecedor fornecedor, Produto produto, Funcionario funcionario, double total, String dataCompra) {
        this.idCompra = idCompra;
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.funcionario = funcionario;
        this.total = total;
        this.dataCompra = dataCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }
    
    
}
