/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ViewListagem;

import DAO.FornecedorDAO;
import Fornecedor.Fornecedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaio Dias
 */
public class TelaListaFornecedores extends javax.swing.JFrame {

    /**
     * Creates new form TelaListaFornecedores
     */
    
    
    
    public TelaListaFornecedores() {
        initComponents();
        atualizarTabela();
    }


    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaForn.getModel();
        modelo.setRowCount(0); // Limpa os dados da tabela

        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> fornecedores = fornecedorDAO.read(); // Obtem a lista de fornecedores

        for (Fornecedor f : fornecedores) {
            modelo.addRow(new Object[]{
                f.getIdFornecedor(),
                f.getNome(),
                f.getEndereco(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado(),
                f.getCep(),
                f.getTelefone(),
                f.getEmail(),
                f.getCnpj()
            });
        }
    }

    public void searchJTableForName(String nome, String cnpj) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaForn.getModel();
        modelo.setNumRows(0);
        FornecedorDAO fdao = new FornecedorDAO();

        for (Fornecedor f : fdao.searchForName(nome, cnpj)) {

            modelo.addRow(new Object[]{
                f.getIdFornecedor(),
                f.getNome(),
                f.getEndereco(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado(),
                f.getCep(),
                f.getTelefone(),
                f.getEmail(),
                f.getCnpj()
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
        tabelaForn = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de fornecedores");

        tabelaForn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Rua", "Bairro", "Cidade", "Estado", "CEP", "Telefone", "E-mail", "CNPJ"
            }
        ));
        tabelaForn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFornMouseClicked(evt);
            }
        });
        tabelaForn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaFornKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaForn);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar)
                                .addGap(875, 875, 875)))
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaFornMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornMouseClicked
        // TODO add your handling code here:
       
        btnAtualizar.setEnabled(true);
    }//GEN-LAST:event_tabelaFornMouseClicked

    private void tabelaFornKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaFornKeyReleased
    }//GEN-LAST:event_tabelaFornKeyReleased

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        searchJTableForName(txtBusca.getText(), txtBusca.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        if (tabelaForn.getSelectedRow() != -1) {
            Fornecedor f = new Fornecedor();
            FornecedorDAO dao = new FornecedorDAO();

            f.setIdFornecedor((int) tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 0));

            dao.delete(f);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Cliente para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        
        
        
        if(tabelaForn.getSelectedRow() != -1){
            Fornecedor f = new Fornecedor();
            FornecedorDAO dao = new FornecedorDAO();
            
            f.setNome(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 1).toString());
            f.setEndereco(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 2).toString());
            f.setBairro(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 3).toString());
            f.setCidade(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 4).toString());
            f.setEstado(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 5).toString());
            f.setCep(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 6).toString());
            f.setTelefone(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 7).toString());
            f.setEmail(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 8).toString());
            f.setCnpj(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 9).toString());
            f.setIdFornecedor(Integer.parseInt(tabelaForn.getValueAt(tabelaForn.getSelectedRow(), 0).toString()));
            dao.update(f);
            atualizarTabela();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        // TODO add your handling code here:
        searchJTableForName(txtBusca.getText(), txtBusca.getText());
    }//GEN-LAST:event_txtBuscaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaForn;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
