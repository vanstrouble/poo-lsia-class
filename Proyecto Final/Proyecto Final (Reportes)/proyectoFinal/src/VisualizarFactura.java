import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VisualizarFactura {

    public TextField textoSKU;
    public TextArea mFacturas;

    public void ver(ActionEvent actionEvent) {
        String skuEliminar = textoSKU.getText();
        int posDel = buscarFactura(skuEliminar);

        if (posDel != -1) {
            mFacturas.setText(Menu.facturas.get(posDel).toString());
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Producto no registrado");
            mensaje.showAndWait();
        }
    }

    public static Integer buscarFactura(String SKU) {
        String sku = SKU;
        for (int i = 0; i < Menu.facturas.size(); i++) {
            if (Menu.facturas.get(i).getSKU().contains(sku)) {
                return i;
            }
        }
        return -1;
    }

    public void clicGenerarReporte(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/generarReporte.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }
}
