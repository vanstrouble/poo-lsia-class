import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearBocinas {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoMarca;
    public TextField textoTamanio;
    public TextField textoPotencia;

    public void guardar(ActionEvent actionEvent) {
        llenarBocinas(textoSKU, textoNombre, textoPrecio, textoMarca, textoTamanio, textoPotencia);

        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoMarca.setText("");
        textoTamanio.setText("");
        textoPotencia.setText("");
    }

    public void llenarBocinas(TextField textoSKU, TextField textoNombre, TextField textoPrecio, TextField textoMarca, TextField textoTamanio, TextField textoPotencia) {
        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        String marca = textoMarca.getText();
        String tamanio = textoTamanio.getText();
        int potencia = Integer.parseInt(textoPotencia.getText());

        Bocinas bocinas = new Bocinas(sku, nombre, precio, marca, potencia, tamanio);
        Menu.productos.add(bocinas);

        escribirBinario(bocinas);
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
