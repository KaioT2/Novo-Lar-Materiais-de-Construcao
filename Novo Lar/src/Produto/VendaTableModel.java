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

    private List<Produto> produtos = new ArrayList<>();
    private List<ItensDaVenda> itensDeVenda = new ArrayList<>();
    private String[] colunas = {"Item", "id", "Código", "Nome", "Preco", "Quantidade", "Desconto %", "Subtotal"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return produtos.size();
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
                return produtos.get(linha).getIdProduto();
            case 2:
                return produtos.get(linha).getCodigo();
            case 3:
                return produtos.get(linha).getNome();
            case 4:
                return produtos.get(linha).getPrecoUn();
            case 5:
                return itensDeVenda.get(linha).getQuantidade();
            case 6:
                return itensDeVenda.get(linha).getDesconto();
            case 7:
                double subtotal = itensDeVenda.get(linha).getSubtotal();
                return decimalFormat.format(subtotal);
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                produtos.get(linha);
                break;
            case 1:
                produtos.get(linha).setIdProduto(Integer.parseInt(valor.toString()));
                break;
            case 2:
                produtos.get(linha).setCodigo(valor.toString());
                break;
            case 3:
                produtos.get(linha).setNome(valor.toString());
                break;
            case 4:
                produtos.get(linha).setPrecoUn(Double.parseDouble(valor.toString()));
                break;
            case 5:
                itensDeVenda.get(linha).setQuantidade(Double.parseDouble(valor.toString()));
                calcularEAtualizarSubtotal(linha);
                break;
            case 6:
                itensDeVenda.get(linha).setDesconto(Double.parseDouble(valor.toString()));
                calcularEAtualizarSubtotal(linha);
                break;
            case 7:
                itensDeVenda.get(linha).setSubtotal(Double.parseDouble(valor.toString()));
                break;
        }

        this.fireTableRowsUpdated(linha, linha);
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return coluna == 5 || coluna == 6;
    }

    public void addRow(Produto p, ItensDaVenda i) {
        this.produtos.add(p);
        this.itensDeVenda.add(i);

        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.produtos.remove(linha);
        this.itensDeVenda.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAllRows() {
        produtos.clear(); 
        itensDeVenda.clear(); 
        fireTableDataChanged(); 
    }

    public double calcularEAtualizarSubtotal(int linha) {
        Produto produto = produtos.get(linha);
        ItensDaVenda item = itensDeVenda.get(linha);

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

        for (ItensDaVenda venda : itensDeVenda) {
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

        for (ItensDaVenda item : itensDeVenda) {
            total += item.getSubtotal();
        }

        return total;
    }
}


