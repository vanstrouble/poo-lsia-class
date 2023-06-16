import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearTornamesa {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoMarca;
    public TextField textoFrenado;
    public TextField textoRotacion;

    public void guardar(ActionEvent actionEvent) {
        llenarTornamesa(textoSKU, textoNombre, textoPrecio, textoMarca, textoFrenado, textoRotacion);

        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoMarca.setText("");
        textoFrenado.setText("");
        textoRotacion.setText("");
    }

    public void llenarTornamesa(TextField textoSKU, TextField textoNombre, TextField textoPrecio, TextField textoMarca, TextField textoFrenado, TextField textoRotacion) {
        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        String marca = textoMarca.getText();
        String frenado = textoFrenado.getText();
        Float rotacion = Float.parseFloat(textoRotacion.getText());

        Tornamesa tornamesa = new Tornamesa(sku, nombre, precio, marca, frenado, rotacion);
        Menu.productos.add(tornamesa);

        escribirBinario(tornamesa);
    }

    public void escribirBinario(Tornamesa tornamesa) {
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
