/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Outros;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class ZoomPadraoJRViewer extends JRViewer {

    public ZoomPadraoJRViewer(JasperPrint jrPrint) {
        super(jrPrint);
        // Define o zoom inicial para 70%
        setZoomRatio(0.7f);
    }
}
