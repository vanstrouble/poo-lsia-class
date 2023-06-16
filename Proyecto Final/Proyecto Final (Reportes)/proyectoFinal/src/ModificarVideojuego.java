import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ModificarVideojuego {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoPlataforma;
    public TextField textoAnio;
    public TextField textoCompania;
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
        modificarVideojuego();

        textoSKUtoMod.setText("");
        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoPlataforma.setText("");
        textoAnio.setText("");
        textoCompania.setText("");
    }

    public void modificarVideojuego() {
        String skuMod = textoSKUtoMod.getText();
        int pos = buscarProducto(skuMod);

        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        String plataforma = textoPlataforma.getText();
        int anio = Integer.parseInt(textoAnio.getText());
        String compania = textoCompania.getText();

        Videojuego videojuego = new Videojuego(sku, nombre, precio, plataforma, anio, compania);
        Menu.productos.set(pos, videojuego);

        escribirBinario(videojuego);
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

    public void escribirBinario(Videojuego videojuego) {
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
