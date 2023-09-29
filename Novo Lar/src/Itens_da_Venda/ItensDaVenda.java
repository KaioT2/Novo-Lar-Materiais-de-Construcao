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
    private int idItemVenda;
    private Venda venda;
    private Produto produto;
    private double quantidade;
    private double desconto;
    private double subtotal;
    private String data;
    private double precoUn;

    public ItensDaVenda() {
    }

    public ItensDaVenda(int idItemVenda, Venda venda, Produto produto, double quantidade, double desconto, double subtotal, String data, double precoUn) {
        this.idItemVenda = idItemVenda;
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.subtotal = subtotal;
        this.data = data;
        this.precoUn = precoUn;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPrecoUn() {
        return precoUn;
    }

    public void setPrecoUn(double precoUn) {
        this.precoUn = precoUn;
    }

    
}
