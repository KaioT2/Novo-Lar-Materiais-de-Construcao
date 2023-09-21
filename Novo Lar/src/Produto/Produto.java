/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Produto;

import Categoria.Categoria;
import Fornecedor.Fornecedor;

/**
 *
 * @author Kaio Dias
 */
public class Produto {
    private int idProduto;
    private Fornecedor fornecedor;
    private String nome;
    private int codigo;
    private Categoria categoria;
    private Double precoUn;
    private Double precoCusto;
    private Double estoque;

    public Produto() {
    }

    public Produto(int idProduto, Fornecedor fornecedor, String nome, int codigo, Categoria categoria, Double precoUn, Double precoCusto, Double estoque) {
        this.idProduto = idProduto;
        this.fornecedor = fornecedor;
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
        this.precoUn = precoUn;
        this.precoCusto = precoCusto;
        this.estoque = estoque;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getPrecoUn() {
        return precoUn;
    }

    public void setPrecoUn(Double precoUn) {
        this.precoUn = precoUn;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    
}
