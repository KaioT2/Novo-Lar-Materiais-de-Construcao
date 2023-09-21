/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Categoria.Categoria;
import Produto.Produto;
import DAO.ProdutoDAO;
import Fornecedor.Fornecedor;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaio Dias
 */
public class TelaListarProdutos extends javax.swing.JFrame {

    /**
     * Creates new form TelaListarFuncionarios
     */
    public TelaListarProdutos() {
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
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Produtos");

        tabelaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "fornecedor", "nome", "codigo", "categoria", "preço", "custo", "estoque"
            }
        ));
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

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAtualizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 646, Short.MAX_VALUE)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdMouseClicked
        // TODO add your handling code here:

        btnAtualizar.setEnabled(true);
        btnExcluir.setEnabled(true);
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

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tabelaProd.getSelectedRow() != -1) {
            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setIdProduto((int) tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 0));

            dao.delete(p);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:

        if (tabelaProd.getSelectedRow() != -1) {
            Produto c = new Produto();
            ProdutoDAO dao = new ProdutoDAO();
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setIdFornecedor(Integer.parseInt(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 1).toString()));
            c.setFornecedor(fornecedor);
            
            c.setNome(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 2).toString());
            c.setCodigo(Integer.parseInt(tabelaProd.getValueAt(tabelaProd.getSelectedRow(),3).toString()));
            
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(Integer.parseInt(tabelaProd.getValueAt(tabelaProd.getSelectedRow(), 4).toString()));
            c.setCategoria(categoria);
            
            c.setPrecoUn(Double.parseDouble(tabelaProd.getValueAt(tabelaProd.getSelectedRow(),5).toString()));
            c.setPrecoCusto(Double.parseDouble(tabelaProd.getValueAt(tabelaProd.getSelectedRow(),6).toString()));
            c.setEstoque(Integer.parseInt(tabelaProd.getValueAt(tabelaProd.getSelectedRow(),7).toString()));
            c.setIdProduto(Integer.parseInt(tabelaProd.getValueAt(tabelaProd.getSelectedRow(),0).toString()));
            dao.update(c);
            atualizarTabela();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaProd;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
