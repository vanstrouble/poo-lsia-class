import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
}
