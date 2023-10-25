/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ViewPrincipal;

import DAO.VendaDAO;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Kaio Dias
 */
public class Home extends javax.swing.JInternalFrame {

    private int permissaoUsuario;

    public Home(int permissaoUsuario) {
        initComponents();
        atualizarTotalVendas();
        
        ((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        this.permissaoUsuario = permissaoUsuario;
        
        if (permissaoUsuario != 1) {
            btnMostrar.setEnabled(false);
            btnMostrar.setSelected(true);
        }

        Timer timer = new Timer(900, e -> {
            VendaDAO v = new VendaDAO();
            String totalVendas = "Valor total das vendas: R$" + String.valueOf(v.totalVendasMes());
            String numVendas = "Quantidades de vendas: " + String.valueOf(v.numVendasMes());
            if (!btnMostrar.isSelected()) {
                txtTotalVendasMes.setText(totalVendas);
                txtQuantidadeVendasMes.setText(numVendas);
            }
        });
        timer.start();
    }

    public void atualizarTotalVendas() {
        VendaDAO v = new VendaDAO();
        String totalVendas = "Valor total das vendas: R$" + String.valueOf(v.totalVendasMes());
        String numVendas = "Quantidades de vendas: " + String.valueOf(v.numVendasMes());
        if (!btnMostrar.isSelected()) {
            txtTotalVendasMes.setText(totalVendas);
            txtQuantidadeVendasMes.setText(numVendas);
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

        jPanel1 = new javax.swing.JPanel();
        painelVendasMes = new Outros.PanelRound();
        panelRound2 = new Outros.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtTotalVendasMes = new javax.swing.JLabel();
        txtQuantidadeVendasMes = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JCheckBox();
        painelProdBaixoEstoque = new Outros.PanelRound();
        panelRound5 = new Outros.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        painelAniversariantes = new Outros.PanelRound();
        panelRound7 = new Outros.PanelRound();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setForeground(java.awt.Color.white);
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        painelVendasMes.setBackground(new java.awt.Color(14, 33, 69));
        painelVendasMes.setForeground(new java.awt.Color(255, 255, 255));
        painelVendasMes.setRoundBottomLeft(30);
        painelVendasMes.setRoundBottomRight(30);
        painelVendasMes.setRoundTopLeft(30);
        painelVendasMes.setRoundTopRight(30);

        panelRound2.setBackground(new java.awt.Color(31, 53, 126));
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vendas do mês");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        txtTotalVendasMes.setBackground(new java.awt.Color(14, 33, 69));
        txtTotalVendasMes.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtTotalVendasMes.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalVendasMes.setOpaque(true);

        txtQuantidadeVendasMes.setBackground(new java.awt.Color(14, 33, 69));
        txtQuantidadeVendasMes.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtQuantidadeVendasMes.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantidadeVendasMes.setOpaque(true);

        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("Ocultar dados");
        btnMostrar.setBorder(null);
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMostrarMouseReleased(evt);
            }
        });
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelVendasMesLayout = new javax.swing.GroupLayout(painelVendasMes);
        painelVendasMes.setLayout(painelVendasMesLayout);
        painelVendasMesLayout.setHorizontalGroup(
            painelVendasMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelVendasMesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelVendasMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrar)
                    .addGroup(painelVendasMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTotalVendasMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantidadeVendasMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelVendasMesLayout.setVerticalGroup(
            painelVendasMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelVendasMesLayout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtTotalVendasMes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtQuantidadeVendasMes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        painelProdBaixoEstoque.setBackground(new java.awt.Color(14, 33, 69));
        painelProdBaixoEstoque.setRoundBottomLeft(30);
        painelProdBaixoEstoque.setRoundBottomRight(30);
        painelProdBaixoEstoque.setRoundTopLeft(30);
        painelProdBaixoEstoque.setRoundTopRight(30);

        panelRound5.setBackground(new java.awt.Color(31, 53, 126));
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Produtos com baixo estoque");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout painelProdBaixoEstoqueLayout = new javax.swing.GroupLayout(painelProdBaixoEstoque);
        painelProdBaixoEstoque.setLayout(painelProdBaixoEstoqueLayout);
        painelProdBaixoEstoqueLayout.setHorizontalGroup(
            painelProdBaixoEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelProdBaixoEstoqueLayout.setVerticalGroup(
            painelProdBaixoEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdBaixoEstoqueLayout.createSequentialGroup()
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAniversariantes.setBackground(new java.awt.Color(14, 33, 69));
        painelAniversariantes.setRoundBottomLeft(30);
        painelAniversariantes.setRoundBottomRight(30);
        painelAniversariantes.setRoundTopLeft(30);
        painelAniversariantes.setRoundTopRight(30);

        panelRound7.setBackground(new java.awt.Color(31, 53, 126));
        panelRound7.setRoundTopLeft(30);
        panelRound7.setRoundTopRight(30);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Aniversariantes do mês");

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelAniversariantesLayout = new javax.swing.GroupLayout(painelAniversariantes);
        painelAniversariantes.setLayout(painelAniversariantesLayout);
        painelAniversariantesLayout.setHorizontalGroup(
            painelAniversariantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelAniversariantesLayout.setVerticalGroup(
            painelAniversariantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAniversariantesLayout.createSequentialGroup()
                .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(painelVendasMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                            .addComponent(painelProdBaixoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(painelAniversariantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(150, 150, 150)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelProdBaixoEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelVendasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(72, 72, 72)
                    .addComponent(painelAniversariantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseClicked

    }//GEN-LAST:event_btnMostrarMouseClicked

    private void btnMostrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseReleased
        // TODO add your handling code here:
        if (btnMostrar.isSelected()) {
            txtTotalVendasMes.setText("#########");
            txtQuantidadeVendasMes.setText("#########");
        } else {
            atualizarTotalVendas();
        }
    }//GEN-LAST:event_btnMostrarMouseReleased

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btnMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private Outros.PanelRound painelAniversariantes;
    private Outros.PanelRound painelProdBaixoEstoque;
    private Outros.PanelRound painelVendasMes;
    private Outros.PanelRound panelRound2;
    private Outros.PanelRound panelRound5;
    private Outros.PanelRound panelRound7;
    private javax.swing.JLabel txtQuantidadeVendasMes;
    private javax.swing.JLabel txtTotalVendasMes;
    // End of variables declaration//GEN-END:variables
}