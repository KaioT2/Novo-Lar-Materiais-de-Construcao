/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.FuncionarioDAO;
import Funcionario.Funcionario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaio Dias
 */
public class TelaFuncionariosVenda extends javax.swing.JFrame {
    private TelaVenda telaVenda;

    public void setTelaVenda(TelaVenda telaVenda) {
        this.telaVenda = telaVenda;
    }
    /**
     * Creates new form TelaListarFuncionario
     */
    public TelaFuncionariosVenda() {
        initComponents();
        atualizarTabela();
    }
    
    public void atualizarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaFunc.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO fdao = new FuncionarioDAO();
        
        for(Funcionario f: fdao.read()){
            
            modelo.addRow(new Object[]{
                f.getIdFuncionario(),
                f.getNome(),
                f.getCargo(),
                f.getStatus()
            });
            
        }
        
    }
    
    public void searchJTableForName(String nome, String cpf){
        DefaultTableModel modelo = (DefaultTableModel) tabelaFunc.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO fdao = new FuncionarioDAO();
        
        for(Funcionario f: fdao.searchForName(nome, cpf)){
            
            modelo.addRow(new Object[]{
                f.getIdFuncionario(),
                f.getNome(),
                f.getCargo(),
                f.getStatus()
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

        btnSelecionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaFunc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de funcionários ");

        btnSelecionar.setText("Selecionar Funcionário");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        tabelaFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cargo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncMouseClicked(evt);
            }
        });
        tabelaFunc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaFuncKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaFunc);
        if (tabelaFunc.getColumnModel().getColumnCount() > 0) {
            tabelaFunc.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelecionar)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSelecionar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        searchJTableForName(txtBusca.getText(),txtBusca.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void tabelaFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncMouseClicked
        // TODO add your handling code here:
         
         if (evt.getClickCount() == 2) { // Duplo clique
            if (tabelaFunc.getSelectedRow() != -1) {
                
                Funcionario f = new Funcionario();
                
                f.setIdFuncionario(Integer.parseInt(tabelaFunc.getValueAt(tabelaFunc.getSelectedRow(), 0).toString()));
                f.setNome(tabelaFunc.getValueAt(tabelaFunc.getSelectedRow(), 1).toString());
                
                telaVenda.inserirFuncionario(f);
                this.dispose();
            }
        }
    }//GEN-LAST:event_tabelaFuncMouseClicked

    private void tabelaFuncKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaFuncKeyReleased

    }//GEN-LAST:event_tabelaFuncKeyReleased

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        // TODO add your handling code here:
        
        if (tabelaFunc.getSelectedRow() != -1) {
                //TelaVenda telaVenda = new TelaVenda();
                Funcionario f = new Funcionario();
                
                f.setIdFuncionario(Integer.parseInt(tabelaFunc.getValueAt(tabelaFunc.getSelectedRow(), 0).toString()));
                f.setNome(tabelaFunc.getValueAt(tabelaFunc.getSelectedRow(), 1).toString());
                
                telaVenda.inserirFuncionario(f);
                this.dispose();
            }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        // TODO add your handling code here:
        searchJTableForName(txtBusca.getText(), txtBusca.getText());
    }//GEN-LAST:event_txtBuscaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaFunc;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
