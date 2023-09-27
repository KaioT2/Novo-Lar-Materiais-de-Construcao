package Produto;

import Itens_da_Venda.ItensDaVenda;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kaio Dias
 */
public class ProdutoTableModel extends AbstractTableModel {
    
    private List<Produto> dados = new ArrayList<>();
    private List<ItensDaVenda> dadosVenda = new ArrayList<>();

    private String[] colunas = {"Item", "Código", "Nome", "Preco", "Quantidade", "Desconto", "Subtotal"};

    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        switch (coluna) {
            case 0:
                return linha + 1;
            case 1:
                return dados.get(linha).getCodigo();
            case 2:
                return dados.get(linha).getNome();
            case 3:
                return dados.get(linha).getPrecoUn();
            case 4:
                return dadosVenda.get(linha).getQuantidade();
            case 5:
                return dadosVenda.get(linha).getDesconto();
            case 6:
                // Formata o subtotal com duas casas decimais
                double subtotal = dadosVenda.get(linha).getSubtotal();
                return decimalFormat.format(subtotal);
        }
        return null;
    }


    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna) {
            case 0:
                 dados.get(linha);
                 break;
            case 1:
                 dados.get(linha).setCodigo(Integer.parseInt(valor.toString()));
                 break;
            case 2:
                 dados.get(linha).setNome(valor.toString());
                 break;
            case 3:
                 dados.get(linha).setPrecoUn(Double.parseDouble(valor.toString()));
                 break;
            case 4:
                 dadosVenda.get(linha).setQuantidade(Double.parseDouble(valor.toString()));
                 calcularEAtualizarSubtotal(linha);
                 break;
            case 5:
                 dadosVenda.get(linha).setDesconto(Double.parseDouble(valor.toString()));
                 calcularEAtualizarSubtotal(linha);
                 break;
            case 6:
                 
                 break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
    
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        // Permite a edição apenas nas colunas de quantidade e desconto
        return coluna == 4 || coluna == 5;
    }

    public void addRow(Produto p, ItensDaVenda i) {
        this.dados.add(p);
        this.dadosVenda.add(i);
        
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.dadosVenda.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void calcularEAtualizarSubtotal(int linha) {
        Produto produto = dados.get(linha);
        ItensDaVenda item = dadosVenda.get(linha);

        double preco = produto.getPrecoUn();
        double quantidade = item.getQuantidade();
        double subtotal = preco * quantidade;

        // Verifica se há um desconto definido no item da venda
        if (item.getDesconto() > 0) {
            double descontoPorcentagem = item.getDesconto();
            double desconto = (descontoPorcentagem / 100) * subtotal;
            subtotal -= desconto;
        }

        // Atualiza o subtotal na lista de dadosVenda
        item.setSubtotal(subtotal);

        // Atualiza o valor na tabela
        fireTableCellUpdated(linha, 6); // Onde 6 é o índice da coluna Subtotal
    }

}
