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
public class VendaTableModel extends AbstractTableModel {

    private List<Produto> dados = new ArrayList<>();
    private List<ItensDaVenda> dadosVenda = new ArrayList<>();
    //o problema é colocar o id na lista de colunas. Não sei o porquê
    private String[] colunas = {"Item", "id", "Código", "Nome", "Preco", "Quantidade", "Desconto %", "Subtotal"};

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
                return dados.get(linha).getIdProduto();
            case 2:
                return dados.get(linha).getCodigo();
            case 3:
                return dados.get(linha).getNome();
            case 4:
                return dados.get(linha).getPrecoUn();
            case 5:
                return dadosVenda.get(linha).getQuantidade();
            case 6:
                return dadosVenda.get(linha).getDesconto();
            case 7:
                double subtotal = dadosVenda.get(linha).getSubtotal();
                return decimalFormat.format(subtotal);
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha);
                break;
            case 1:
                dados.get(linha).setIdProduto(Integer.parseInt(valor.toString()));
                break;
            case 2:
                dados.get(linha).setCodigo(valor.toString());
                break;
            case 3:
                dados.get(linha).setNome(valor.toString());
                break;
            case 4:
                dados.get(linha).setPrecoUn(Double.parseDouble(valor.toString()));
                break;
            case 5:
                dadosVenda.get(linha).setQuantidade(Double.parseDouble(valor.toString()));
                calcularEAtualizarSubtotal(linha);
                break;
            case 6:
                dadosVenda.get(linha).setDesconto(Double.parseDouble(valor.toString()));
                calcularEAtualizarSubtotal(linha);
                break;
            case 7:
                dadosVenda.get(linha).setSubtotal(Double.parseDouble(valor.toString()));
                break;
        }

        this.fireTableRowsUpdated(linha, linha);
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return coluna == 5 || coluna == 6;
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
    
    public void removeAllRows() {
        dados.clear(); 
        dadosVenda.clear(); 
        fireTableDataChanged(); 
    }

    public double calcularEAtualizarSubtotal(int linha) {
        Produto produto = dados.get(linha);
        ItensDaVenda item = dadosVenda.get(linha);

        double preco = produto.getPrecoUn();
        double quantidade = item.getQuantidade();
        double subtotal = preco * quantidade;

        if (item.getDesconto() > 0) {
            double descontoPorcentagem = item.getDesconto();
            double desconto = (descontoPorcentagem / 100) * subtotal;
            subtotal -= desconto;
        }

        item.setSubtotal(subtotal);

        // Calcular o desconto total em porcentagem após calcular o subtotal de cada item
        double descontoTotal = 0;
        double valorTotal = 0;

        for (ItensDaVenda venda : dadosVenda) {
            valorTotal += venda.getSubtotal();
            if (venda.getDesconto() > 0) {
                descontoTotal += (venda.getDesconto() / 100) * venda.getSubtotal();
            }
        }

        // Calcular o desconto total em porcentagem
        double descontoTotalPercentual = 0;
        if (valorTotal > 0) {
            descontoTotalPercentual = (descontoTotal / valorTotal) * 100;
        }

        //System.out.println("Desconto total em porcentagem: " + descontoTotalPercentual + "%");
        fireTableCellUpdated(linha, 6);
        return descontoTotalPercentual;
    }
    
    public double calcularTotalSubtotal() {
        double total = 0.0;

        for (ItensDaVenda item : dadosVenda) {
            total += item.getSubtotal();
        }

        return total;
    }
}


