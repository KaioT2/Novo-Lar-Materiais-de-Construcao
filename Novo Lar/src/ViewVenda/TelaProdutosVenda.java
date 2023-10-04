/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ViewVenda;

import Produto.Produto;
import DAO.ProdutoDAO;
import Itens_da_Venda.ItensDaVenda;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaio Dias
 */
public class TelaProdutosVenda extends javax.swing.JFrame {
    private TelaVenda telaVenda;
    /**
     * Creates new form TelaListarFuncionarios
     */
    public TelaProdutosVenda() {
        initComponents();
        atualizarTabela();
    }
    
    public TelaProdutosVenda(TelaVenda telaVenda) {
        this.telaVenda = telaVenda;
        initComponents();
        atualizarTabela();
    }

    public void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaProd.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getFornecedor().getIdFornecedor(),
                p.getNome(),
                p.getCodigo(),
                p.getCategoria().getIdCategoria(),
                p.getPrecoUn(),
                p.getPrecoCusto(),
                p.getEstoque()
            });

        }

    }
    
       public void searchJTableForName(String nome, String codigo) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaProd.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto p : pdao.searchForName(nome, codigo)) {

            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getFornecedor().getIdFornecedor(),
                p.getNome(),
                p.getCodigo(),
                p.getCategoria().getIdCategoria(),
                p.getPrecoUn(),
                p.getPrecoCusto(),
                p.getEstoque()
            });

        }

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaProd = new javax.swing.JTable();
        txtBusca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Produtos");

        tabelaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "fornecedor", "nome", "codigo", "categoria", "preço", "custo", "estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdMouseClicked(evt);
            }
        });
        tabelaProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaProdKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaProd);
        if (tabelaProd.getColumnModel().getColumnCount() > 0) {
            tabelaProd.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar produto");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 646, Short.MAX_VALUE)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelecionar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSelecionar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdMouseClicked
        if (evt.getClickCount() == 2) { // Duplo clique
            if (tabelaProd.getSelectedRow() != -1) {
                
                Produto p = new Produto();
                
                p.setIdProduto(Integer.parseInt(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 0).toString()));
                p.setCodigo(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 3).toString());
                p.setNome(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 2).toString());
                p.setPrecoUn(Double.parseDouble(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 5).toString()));
                
                ItensDaVenda i = new ItensDaVenda();
                
                i.setDesconto(0.0);
                i.setQuantidade(1);
                
                telaVenda.inserirProduto(p, i);
                this.dispose();
            }
        }
    }//GEN-LAST:event_tabelaProdMouseClicked

    private void tabelaProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaProdKeyReleased
    }//GEN-LAST:event_tabelaProdKeyReleased

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchJTableForName(txtBusca.getText(), txtBusca.getText());
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        searchJTableForName(txtBusca.getText(), txtBusca.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        // TODO add your handling code here:
        searchJTableForName(txtBusca.getText(), txtBusca.getText());
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (tabelaProd.getSelectedRow() != -1) {

            Produto p = new Produto();

            p.setIdProduto(Integer.parseInt(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 0).toString()));
            p.setCodigo(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 3).toString());
            p.setNome(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 2).toString());
            p.setPrecoUn(Double.parseDouble(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 5).toString()));

            ItensDaVenda i = new ItensDaVenda();

            i.setDesconto(0.0);
            i.setQuantidade(1);

            telaVenda.inserirProduto(p, i);
            this.dispose();

            }    }//GEN-LAST:event_btnSelecionarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaProd;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}