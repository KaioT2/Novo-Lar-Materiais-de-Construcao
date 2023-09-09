/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Itens_da_Venda;

import Produto.Produto;
import Venda.Venda;

/**
 *
 * @author Kaio Dias
 */
public class ItensDaVenda {
    private Venda venda;
    private Produto produto;
    private double quantidade;
    private double subtotal;
    private double total;

    public ItensDaVenda() {
    }

    public ItensDaVenda(Venda venda, Produto produto, double quantidade, double subtotal, double total) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.total = total;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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
