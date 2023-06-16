import Visualizador.JasperViewerFX;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GenerarReporte {

    public void clicReporte(ActionEvent actionEvent) {
        try {
            JasperCompileManager.compileReportToFile("src/Reportes/Facturas.jrxml", "src/Reportes/Facturas.jasper");
            JasperReport jrReporte = (JasperReport) JRLoader.loadObject(new File("src/Reportes/Facturas.jrxml"));

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Titulo", "Reporte");
            DefaultTableModel dtmDatos = new DefaultTableModel();
            dtmDatos.setColumnIdentifiers(new Object[]{"SKU Producto", "Nombre del cliente", "SKU Factura", "Fecha Factura"});
            dtmDatos.addRow(new Object[]{"123", "Pedro", "234", "16 de diciembre"});

            JasperPrint jrPrint = JasperFillManager.fillReport(jrReporte, parametros, new JRTableModelDataSource(dtmDatos));
            new JasperViewerFX().viewReport("Reporte", jrPrint);
        } catch (Exception e) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText(e.getMessage());
            mensaje.showAndWait();
        }
    }
}
