import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ModificarBocinas {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoMarca;
    public TextField textoTamanio;
    public TextField textoPotencia;
    public TextField textoSKUtoMod;
    public TextField textoAviso;

    public void opcionMenu(ActionEvent actionEvent) {
        String skuMod = textoSKUtoMod.getText();

        int posMod = buscarProducto(skuMod);
        if (posMod == -1) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Código no registrado");
            mensaje.showAndWait();
        } else {
            textoAviso.setText("Puede modificar el Producto");
        }
    }

    public void guardar(ActionEvent actionEvent) {
        modificarBocinas();

        textoSKUtoMod.setText("");
        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoMarca.setText("");
        textoTamanio.setText("");
        textoPotencia.setText("");
    }

    public void modificarBocinas() {
        String skuMod = textoSKUtoMod.getText();
        int posMod = buscarProducto(skuMod);

        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        String marca = textoMarca.getText();
        String tamanio = textoTamanio.getText();
        int potencia = Integer.parseInt(textoPotencia.getText());

        Bocinas bocinas = new Bocinas(sku, nombre, precio, marca, potencia, tamanio);
        Menu.productos.set(posMod, bocinas);

        escribirBinario(bocinas);
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

    public void escribirBinario(Bocinas bocinas) {
        try {
            FileOutputStream archivo = new FileOutputStream(Menu.archivoProductos);
            ObjectOutputStream escribir = new ObjectOutputStream(archivo);

            escribir.writeObject(Menu.productos);
            escribir.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        }
    }
}
