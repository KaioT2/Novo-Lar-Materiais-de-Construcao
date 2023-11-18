/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Relatorios;

import Cliente.Cliente;
import Connection.ConnectionFactory;
import Funcionario.Funcionario;
import Outros.ZoomPadraoJRViewer;
import ViewVenda.TelaClientesvenda;
import ViewVenda.TelaFuncionariosVenda;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

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

    private String consultaSQL = "SELECT v.idVenda, c.nome AS nome_cliente, f.nome AS nome_funcionario, "
            + "v.total, DATE_FORMAT(STR_TO_DATE(v.dataVenda, '%Y-%m-%d'), '%d-%m-%Y') AS DataFormatada "
            + "FROM venda v INNER JOIN cliente c ON v.idcliente = c.idcliente INNER JOIN funcionario f "
            + "ON v.idFuncionario = f.idFuncionario";

    public TelaRelatórioVendas() {
        initComponents();

        //Exibição padrão (Últimos 30 dias)
        dataPadraoInicio.add(Calendar.DAY_OF_MONTH, -30);
        String dataInicio = da.format(dataPadraoInicio.getTime());
        String dataFim = da.format(dataPadraoFim.getTime());

        gerarRelatorio(dataInicio, dataFim, "", "");
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
        txtData_Inicio = new javax.swing.JFormattedTextField();
        txtData_Fim = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        txtFuncionario = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        btnFuncionario = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        desk = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de vendas - Novo Lar");

        jPanel1.setBackground(new java.awt.Color(14, 33, 69));

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

        btnFuncionario.setText("Selecionar Funcionário");
        btnFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFuncionarioMouseReleased(evt);
            }
        });

        btnCliente.setText("Selecionar Cliente");
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnClienteMouseReleased(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(14, 33, 69));
        btnLimpar.setText("Limpar Campos");
        btnLimpar.setMinimumSize(new java.awt.Dimension(108, 18));
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLimparMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData_Fim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFuncionario)
                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtData_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 666, Short.MAX_VALUE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData_Fim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliente)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtData_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(34, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desk)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desk)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseReleased
        // TODO add your handling code here:
        if (!(txtData_Inicio.getText().equals("  /  /    ") || txtData_Fim.getText().equals("  /  /    "))) {
            consultaSQL += " WHERE v.dataVenda BETWEEN $P{Data_Inicio} AND $P{Data_Fim}";
        }
        if (!txtCliente.getText().equals("") && !txtFuncionario.getText().equals("")) {
            if (contemWhere(consultaSQL)) {
                consultaSQL += " and c.nome = $P{Nome_Cliente} and f.nome = $P{Nome_Funcionario}";
                gerarRelatorio(txtData_Inicio.getText(), txtData_Fim.getText(), txtCliente.getText(), txtFuncionario.getText());
            } else {
                consultaSQL += " WHERE c.nome = $P{Nome_Cliente} and f.nome = $P{Nome_Funcionario}";
                gerarRelatorio(null, null, txtCliente.getText(), txtFuncionario.getText());
            }

        } else if (!txtCliente.getText().equals("")) {
            if (contemWhere(consultaSQL)) {
                consultaSQL += " and c.nome = $P{Nome_Cliente}";
                gerarRelatorio(txtData_Inicio.getText(), txtData_Fim.getText(), txtCliente.getText(), null);
            } else {
                consultaSQL += " WHERE c.nome = $P{Nome_Cliente}";
                gerarRelatorio(null, null, txtCliente.getText(), null);
            }

        } else if (!txtFuncionario.getText().equals("")) {
            if (contemWhere(consultaSQL)) {
                consultaSQL += " and f.nome = $P{Nome_Funcionario}";
                gerarRelatorio(txtData_Inicio.getText(), txtData_Fim.getText(), null, txtFuncionario.getText());
            } else {
                consultaSQL += " WHERE f.nome = $P{Nome_Funcionario}";
                gerarRelatorio(null, null, null, txtFuncionario.getText());
            }
        } else if (txtCliente.getText().isEmpty() && txtFuncionario.getText().isEmpty() && txtData_Inicio.getText().equals("  /  /    ") && txtData_Fim.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Preencha algúm campo para filtrar o relatório!");
        }
        System.out.println(consultaSQL);
    }//GEN-LAST:event_btnFiltrarMouseReleased

    private void btnClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseReleased
        // TODO add your handling code here:
        TelaClientesvenda telaClientesVenda = new TelaClientesvenda();
        telaClientesVenda.setTelaRelatorioVenda(this);
        telaClientesVenda.setVisible(true);
    }//GEN-LAST:event_btnClienteMouseReleased

    private void btnFuncionarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuncionarioMouseReleased
        // TODO add your handling code here:
        TelaFuncionariosVenda telaFuncionariosVenda = new TelaFuncionariosVenda();
        telaFuncionariosVenda.setTelaRelatorioVenda(this);
        telaFuncionariosVenda.setVisible(true);
    }//GEN-LAST:event_btnFuncionarioMouseReleased

    private void btnLimparMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseReleased
        // TODO add your handling code here:
        txtData_Fim.setText("");
        txtData_Inicio.setText("");
        txtCliente.setText("");
        txtFuncionario.setText("");
    }//GEN-LAST:event_btnLimparMouseReleased

    private void gerarRelatorio(String dataInicial, String dataFinal, String nomeCliente, String nomeFuncionario) {
        try ( Connection conn = ConnectionFactory.getConnection()) {
            String dataInicialFormatada = dateConverter(dataInicial);
            String dataFinalFormatada = dateConverter(dataFinal);

            // Configuração dos parâmetros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Data_Inicio", (dataInicial != null) ? dataInicialFormatada : null);
            parametros.put("Data_Fim", (dataFinal != null) ? dataFinalFormatada : null);
            parametros.put("Nome_Cliente", (nomeCliente != null) ? nomeCliente : null);
            parametros.put("Nome_Funcionario", (nomeFuncionario != null) ? nomeFuncionario : null);

            // Criação do JasperDesign a partir do arquivo JRXML ou do relatório compilado
            JasperDesign design = JRXmlLoader.load("Relatorios/RelatorioDeVendas.Jrxml");
            JRDesignQuery jq = new JRDesignQuery();
            jq.setText(consultaSQL);
            design.setQuery(jq);
            // Compilação do JasperDesign para JasperReport
            JasperReport relatorio = JasperCompileManager.compileReport(design);

            // Criação de um objeto JasperPrint, que representa o relatório preenchido
            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorio, parametros, conn);

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

    public static boolean contemWhere(String input) {
        // Converte a string para minúsculas para tornar a verificação sem distinção entre maiúsculas e minúsculas
        String textoEmMinusculo = input.toLowerCase();

        // Verifica se a string contém a palavra "where"
        return textoEmMinusculo.contains("where");
    }

    public static boolean contemAnd(String input) {
        // Converte a string para minúsculas para tornar a verificação sem distinção entre maiúsculas e minúsculas
        String textoEmMinusculo = input.toLowerCase();

        // Verifica se a string contém a palavra "where"
        return textoEmMinusculo.contains("and");
    }

    //Adiciona o fucionário responsável pela venda
    public void inserirFuncionario(Funcionario f) {
        txtFuncionario.setText(f.getNome());
    }

    //Adiciona o cliente da compra
    public void inserirCliente(Cliente c) {
        txtCliente.setText(c.getNome());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JDesktopPane desk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtData_Fim;
    private javax.swing.JFormattedTextField txtData_Inicio;
    private javax.swing.JTextField txtFuncionario;
    // End of variables declaration//GEN-END:variables
}
