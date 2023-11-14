package Produto;

import Itens_da_Compra.ItensDaCompra;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kaio Dias
 */
public class CompraTableModel extends AbstractTableModel {

    private List<Produto> produtos = new ArrayList<>();
    private List<ItensDaCompra> itensDeCompra = new ArrayList<>();
    private String[] colunas = {"Item", "id", "Código", "Nome", "Preco Custo", "Quantidade", "Desconto %", "Subtotal"};

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
                return produtos.get(linha).getPrecoCusto();
            case 5:
                return itensDeCompra.get(linha).getQuantidade();
            case 6:
                return itensDeCompra.get(linha).getDesconto();
            case 7:
                double subtotal = itensDeCompra.get(linha).getSubtotal();
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
                produtos.get(linha).setPrecoCusto(Double.parseDouble(valor.toString()));
                break;
            case 5:
                itensDeCompra.get(linha).setQuantidade(Double.parseDouble(valor.toString()));
                calcularEAtualizarSubtotal(linha);
                break;
            case 6:
                itensDeCompra.get(linha).setDesconto(Double.parseDouble(valor.toString()));
                calcularEAtualizarSubtotal(linha);
                break;
            case 7:
                itensDeCompra.get(linha).setSubtotal(Double.parseDouble(valor.toString()));
                break;
        }

        this.fireTableRowsUpdated(linha, linha);
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return coluna == 5 || coluna == 6;
    }

    public void addRow(Produto p, ItensDaCompra i) {
        this.produtos.add(p);
        this.itensDeCompra.add(i);

        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.produtos.remove(linha);
        this.itensDeCompra.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAllRows() {
        produtos.clear(); 
        itensDeCompra.clear(); 
        fireTableDataChanged(); 
    }

    public double calcularEAtualizarSubtotal(int linha) {
        Produto produto = produtos.get(linha);
        ItensDaCompra item = itensDeCompra.get(linha);

        double preco = produto.getPrecoCusto();
        double quantidade = item.getQuantidade();
        double subtotal = preco * quantidade;

        if (item.getDesconto() > 0) {
            double descontoPorcentagem = item.getDesconto();
            double desconto = (descontoPorcentagem / 100) * subtotal;
            subtotal -= desconto;
        }

        item.setSubtotal(subtotal);

        double descontoTotal = 0;
        double valorTotal = 0;

        for (ItensDaCompra compra : itensDeCompra) {
            valorTotal += compra.getSubtotal();
            if (compra.getDesconto() > 0) {
                descontoTotal += (compra.getDesconto() / 100) * compra.getSubtotal();
            }
        }

        // Calcular o desconto total em porcentagem
        double descontoTotalPercentual = 0;
        if (valorTotal > 0) {
            descontoTotalPercentual = (descontoTotal / valorTotal) * 100;
        }

        // Agora você tem o descontoTotalPercentual atualizado com base nos itens de venda
        //System.out.println("Desconto total em porcentagem: " + descontoTotalPercentual + "%");
        fireTableCellUpdated(linha, 6);
        return descontoTotalPercentual;
    }
    
    public double calcularTotalSubtotal() {
        double total = 0.0;

        for (ItensDaCompra item : itensDeCompra) {
            total += item.getSubtotal();
        }

        return total;
    }
}


