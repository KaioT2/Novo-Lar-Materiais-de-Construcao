package Fornecedor;

import java.util.ArrayList;

public class ControleFornecedor {
    private ArrayList <Fornecedor> lista = new ArrayList();
    
    public String getFornecedor() {
        
        String f ="";

        for (int i = 0 ; i<lista.size();i++) {
            
            Fornecedor fornecedor = lista.get(i);
            
            f+= "Nome: "+fornecedor.getNome()+ "\n";
            f+= "Endereço: "+fornecedor.getEndereco()+ "\n";
            f+= "Telefone: "+fornecedor.getTelefone()+ "\n";
            f+= "Cnpj: "+fornecedor.getCnpj()+ " ";
            f+="\n=========================================\n";
        }

        return f;
    }

    
    public void adicionarFornecedor(Fornecedor f){
        lista.add(f);
    }
    
    
}
