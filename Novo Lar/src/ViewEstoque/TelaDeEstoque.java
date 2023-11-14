/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ViewEstoque;

import DAO.ProdutoDAO;
import Produto.Produto;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaio Dias
 */
public class TelaDeEstoque extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaDeEstoque
     */
    public TelaDeEstoque() {
        initComponents();
        //Aualiza a tabela de estoque assim que a janela é é exibida
        atualizarTabela();
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null); //Não permite a movimentação do JInternalFrame
    }
    
    //Atualisa a tabela de estoque
    public void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaProd.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        //Pega os produtos vindos do DAO e preenche a lista
        for (Produto p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getNome(),
                p.getCodigo(),
                p.getPrecoUn(),
                p.getPrecoCusto(),
                p.getEstoque()
            });

        }

    }

    //Busca produtos no estoque por nome e código
    public void searchJTableForName(String nome, String codigo) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaProd.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto p : pdao.searchForName(nome, codigo)) {

            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getNome(),
                p.getCodigo(),
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

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setFrameIcon(null);
        setMaximumSize(new java.awt.Dimension(1085, 720));
        setMinimumSize(new java.awt.Dimension(1085, 720));
        setPreferredSize(new java.awt.Dimension(1085, 720));

        tabelaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "codigo", "preço", "custo", "estoque"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 474, Short.MAX_VALUE)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdMouseClicked
    }//GEN-LAST:event_tabelaProdMouseClicked

    private void tabelaProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaProdKeyReleased

    }//GEN-LAST:event_tabelaProdKeyReleased

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscaKeyPressed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        // TODO add your handling code here:
        searchJTableForName(txtBusca.getText(), txtBusca.getText());
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        searchJTableForName(txtBusca.getText(), txtBusca.getText());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaProd;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
