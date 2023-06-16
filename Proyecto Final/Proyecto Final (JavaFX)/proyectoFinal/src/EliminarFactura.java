import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EliminarFactura {
    public TextField textoSKUtoDelete;

    public void opcionMenu(ActionEvent actionEvent) {
        String skuEliminar = textoSKUtoDelete.getText();
        int posDel = buscarFactura(skuEliminar);

        if (posDel == -1) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Nombre no registrado");
            mensaje.showAndWait();
        } else {
            Menu.facturas.remove(posDel);
            Menu.archivoFacturas.delete();

            escribirBinario();
        }
        textoSKUtoDelete.setText("");
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

    public void escribirBinario() {
        try {
            FileOutputStream archivo = new FileOutputStream(Menu.archivoFacturas);
            ObjectOutputStream escribir = new ObjectOutputStream(archivo);

            escribir.writeObject(Menu.facturas);
            escribir.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        }
    }
}
