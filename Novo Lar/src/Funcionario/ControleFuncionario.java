/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionario;

import Fornecedor.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author Kaio Dias
 */
public class ControleFuncionario {
    private ArrayList <Funcionario> lista = new ArrayList();
    
    public String getFuncionario() {
        
        String f ="";

        for (int i = 0 ; i<lista.size();i++) {
            
            Funcionario funcionario = lista.get(i);
            
            f+= "Nome: "+funcionario.getNome()+ "\n";
            f+= "Endereço: "+funcionario.getEndereco()+ "\n";
            f+= "Telefone: "+funcionario.getTelefone()+ "\n";
            f+= "Cpf: "+funcionario.getCpf()+ " ";
            f+= "Cargo: "+funcionario.getCargo()+" "+"\n";
            f+= "Carga Horária: "+funcionario.getCargaHoraria()+" "+"\n";
            f+= "Salário: "+funcionario.getSalario()+" "+"\n";
            f+="\n=========================================\n";
        }

        return f;
    }

    
    public void adicionarfuncionario(Funcionario f){
        lista.add(f);
    }
}
