/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Itens_da_Compra;

import Compra.Compra;
import Fornecedor.Fornecedor;
import Produto.Produto;

/**
 *
 * @author Kaio Dias
 */
public class ItensDaCompra {
    private int idItemCompra;
    private Compra compra;
    private Fornecedor fornecedor;
    private Produto produto;
    private double quantidade;
    private double precoCusto;
    private double total;

    public ItensDaCompra() {
    }

    public ItensDaCompra(int idItemCompra, Compra compra, Fornecedor fornecedor, Produto produto, double quantidade, double precoCusto, double total) {
        this.idItemCompra = idItemCompra;
        this.compra = compra;
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.total = total;
    }

    public int getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(int idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
