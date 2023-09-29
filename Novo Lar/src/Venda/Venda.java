/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Venda;

import Cliente.Cliente;
import Funcionario.Funcionario;

/**
 *
 * @author Kaio Dias
 */
public class Venda {
    private int idVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private double total;
    private String statusVenda;
    private double desconto;
    private String dataVenda;

    public Venda() {
    }

    public Venda(int idVenda, Cliente cliente, Funcionario funcionario, double total, String statusVenda, double desconto, String dataVenda) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.total = total;
        this.statusVenda = statusVenda;
        this.desconto = desconto;
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    
}
