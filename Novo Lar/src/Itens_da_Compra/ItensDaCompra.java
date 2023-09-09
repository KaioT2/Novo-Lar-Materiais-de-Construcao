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
    private Compra compra;
    private Fornecedor fornecedor;
    private Produto produto;
    private double quantidade;
    private double subtotal;
    private double total;

    public ItensDaCompra() {
    }

    public ItensDaCompra(Compra compra, Fornecedor fornecedor, Produto produto, double quantidade, double subtotal, double total) {
        this.compra = compra;
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.total = total;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
