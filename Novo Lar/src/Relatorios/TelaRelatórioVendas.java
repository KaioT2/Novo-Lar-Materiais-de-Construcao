/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Relatorios;

import Connection.ConnectionFactory;
import Outros.ZoomPadraoJRViewer;
import ViewPrincipal.TelaPrincipal;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Kaio Dias
 */
public class TelaRelatórioVendas extends javax.swing.JFrame {

    /**
     * Creates new form TelaRelatórioVendas
     */
    private Calendar dataPadraoInicio = Calendar.getInstance();

    private Calendar dataPadraoFim = Calendar.getInstance();

    private SimpleDateFormat da = new SimpleDateFormat("dd/MM/yyyy");

    public TelaRelatórioVendas() {
        initComponents();
        
        //Exibição padrão (Últimos 30 dias)
        dataPadraoInicio.add(Calendar.DAY_OF_MONTH, -30);
        String dataInicio = da.format(dataPadraoInicio.getTime());
        String dataFim = da.format(dataPadraoFim.getTime());

        gerarRelatorio(dataInicio, dataFim);
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
        jLabel1 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        txtData_Inicio = new javax.swing.JFormattedTextField();
        txtData_Fim = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        desk = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de vendas - Novo Lar");

        jPanel1.setBackground(new java.awt.Color(14, 33, 69));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filtros:");

        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(14, 33, 69));
        btnFiltrar.setText("Aplicar Filtros");
        btnFiltrar.setMinimumSize(new java.awt.Dimension(108, 18));
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseReleased(evt);
            }
        });

        txtData_Inicio.setForeground(new java.awt.Color(14, 33, 69));
        try {
            txtData_Inicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtData_Fim.setForeground(new java.awt.Color(14, 33, 69));
        try {
            txtData_Fim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("De:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("até");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData_Fim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 562, Short.MAX_VALUE)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtData_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtData_Fim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        desk.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desk, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(desk)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 611, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseReleased
        // TODO add your handling code here:
        gerarRelatorio(txtData_Inicio.getText(), txtData_Fim.getText());
    }//GEN-LAST:event_btnFiltrarMouseReleased

    private void gerarRelatorio(String dataInicial, String dataFinal) {
    try (Connection conn = ConnectionFactory.getConnection()) {

        String dataInicialFormatada = dateConverter(dataInicial);
        String dataFinalFormatada = dateConverter(dataFinal);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Data_Inicio", dataInicialFormatada);
        parametros.put("Data_Fim", dataFinalFormatada);

        // Caminho e propriedades do relatório
        String src = "Relatorios/RelatorioDeVendas.jasper";
        JasperPrint relatorioPreenchido = JasperFillManager.fillReport(src, parametros, conn);

        // Cria uma tela que armazenará a visualização do relatório
        JInternalFrame telaRelatorios = new JInternalFrame(null, true, true, true, true);

        ZoomPadraoJRViewer painelRelatorio = new ZoomPadraoJRViewer(relatorioPreenchido);

         ((BasicInternalFrameUI) telaRelatorios.getUI()).setNorthPane(null);
         
        // Adiciona um InternalFrameListener para ajustar o tamanho quando o JDesktopPane for redimensionado
        desk.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarTamanhoInternalFrame(telaRelatorios);
            }
        });

        // Adiciona o painel do relatório ao JInternalFrame
        telaRelatorios.getContentPane().add(painelRelatorio);

        // Adiciona o JInternalFrame ao JDesktopPane
        desk.add(telaRelatorios);

        // Ajusta o tamanho do JInternalFrame para ocupar todo o JDesktopPane
        ajustarTamanhoInternalFrame(telaRelatorios);

        // Torna o JInternalFrame visível
        telaRelatorios.setVisible(true);

    } catch (Exception ex) {
        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório!");
    }
}

private void ajustarTamanhoInternalFrame(JInternalFrame internalFrame) {
    // Obtém as dimensões do JDesktopPane
    Dimension tamanhoDesk = desk.getSize();

    // Define o tamanho do JInternalFrame igual ao tamanho do JDesktopPane
    internalFrame.setSize(tamanhoDesk.width, tamanhoDesk.height);
}


    public static String dateConverter(String inputDate) {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            LocalDate date = LocalDate.parse(inputDate, inputFormatter);

            String convertedDate = date.format(outputFormatter);

            return convertedDate;
        } catch (Exception e) {
            return "Data de entrada inválida";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JDesktopPane desk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtData_Fim;
    private javax.swing.JFormattedTextField txtData_Inicio;
    // End of variables declaration//GEN-END:variables
}
