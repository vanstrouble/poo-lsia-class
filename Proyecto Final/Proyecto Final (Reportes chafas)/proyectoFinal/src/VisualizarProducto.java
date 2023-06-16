import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VisualizarProducto {
    public TextField textoSKU;
    public TextArea mProductos;

    public void ver(ActionEvent actionEvent) {
        String skuEliminar = textoSKU.getText();
        int posDel = buscarProducto(skuEliminar);

        if (posDel != -1) {
            mProductos.setText(Menu.productos.get(posDel).toString());
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Producto no registrado");
            mensaje.showAndWait();
        }
    }

    public void clicReportes(ActionEvent actionEvent) {
        for (int i = 0; i < Menu.productos.size(); i++) {
            mProductos.setText(Menu.productos.get(i).toString());
            System.out.println(Menu.productos.get(i).toString() + "\n");
        }
    }

    public static Integer buscarProducto(String SKU) {
        String sku = SKU;
        for (int i = 0; i < Menu.productos.size(); i++) {
            if (Menu.productos.get(i).getSKU().contains(sku)) {
                return i;
            }
        }
        return -1;
    }
}
