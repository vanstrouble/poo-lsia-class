import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearAudifonos {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoMarca;
    public TextField textoTipo;

    public void guardar(ActionEvent actionEvent) {
        llenarAudifonos(textoSKU, textoNombre, textoPrecio, textoMarca, textoTipo);

        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoMarca.setText("");
        textoTipo.setText("");
    }

    public void llenarAudifonos(TextField textoSKU, TextField textoNombre, TextField textoPrecio, TextField textoMarca, TextField textoTipo) {
        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        String marca = textoMarca.getText();
        String tipo = textoTipo.getText();

        Audifonos audifonos = new Audifonos(sku, nombre, precio, marca, tipo);
        Menu.productos.add(audifonos);

        escribirBinario(audifonos);
    }

    public void escribirBinario(Audifonos audifonos) {
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
