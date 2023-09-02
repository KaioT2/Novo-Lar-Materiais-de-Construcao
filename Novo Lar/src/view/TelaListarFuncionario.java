/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.FuncionarioDAO;
import Funcionario.Funcionario;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaio Dias
 */
public class TelaListarFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form TelaListarFuncionario
     */
    public TelaListarFuncionario() {
        initComponents();
        atualizarTabela();
    }
    
    public void atualizarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaFunc.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO cdao = new FuncionarioDAO();
        
        for(Funcionario f: cdao.read()){
            
            modelo.addRow(new Object[]{
                f.getIdFuncionario(),
                f.getNome(),
                f.getEndereco(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado(),
                f.getCEP(),
                f.getTelefone(),
                f.getEmail(),
                f.getCpf(),
                f.getDataNasc(),
                f.getDataContratacao(),
                f.getCargo(),
                f.getCargaHoraria(),
                f.getSalario(),
                f.getStatus(),
                f.getPermissao(),
                f.getSenha()
            });
            
        }
        
    }
    
    public void searchJTableForName(String nome, String cpf){
        DefaultTableModel modelo = (DefaultTableModel) tabelaFunc.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO cdao = new FuncionarioDAO();
        
        for(Funcionario f: cdao.searchForName(nome, cpf)){
            
            modelo.addRow(new Object[]{
                f.getIdFuncionario(),
                f.getNome(),
                f.getEndereco(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado(),
                f.getCEP(),
                f.getTelefone(),
                f.getEmail(),
                f.getCpf(),
                f.getDataNasc(),
                f.getDataContratacao(),
                f.getCargo(),
                f.getCargaHoraria(),
                f.getSalario(),
                f.getStatus(),
                f.getPermissao(),
                f.getSenha()
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

        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaFunc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de funcionários ");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        });

        tabelaFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Endereço", "Bairro", "Cidade", "Estado", "CEP", "Telefone", "E-mail", "CPF", "Data Nascimento", "Data Contratação", "Cargo", "Carga-Horaria", "Salario", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
            tabelaFunc.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(772, Short.MAX_VALUE)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(437, 437, 437)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        searchJTableForName(txtBusca.getText(),txtBusca.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tabelaFunc.getSelectedRow() != -1){
            Funcionario c = new Funcionario();
            FuncionarioDAO dao = new FuncionarioDAO();

            c.setIdFuncionario((int)tabelaFunc.getValueAt(tabelaFunc.getSelectedRow(),0));

            dao.delete(c);
            atualizarTabela();
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um Funcionario para excluir");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchJTableForName(txtBusca.getText(), txtBusca.getText());
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void tabelaFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaFuncMouseClicked

    private void tabelaFuncKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaFuncKeyReleased

    }//GEN-LAST:event_tabelaFuncKeyReleased

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
            java.util.logging.Logger.getLogger(TelaListarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaFunc;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
