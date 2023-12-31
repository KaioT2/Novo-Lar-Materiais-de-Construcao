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
    private String codigo;
    private Categoria categoria;
    private Double precoUn;
    private Double precoCusto;
    private int estoque;

    public Produto() {
    }

    public Produto(int idProduto, Fornecedor fornecedor, String nome, String codigo, Categoria categoria, Double precoUn, Double precoCusto, int estoque) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    
}
