import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearVideojuego {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoPlataforma;
    public TextField textoAnio;
    public TextField textoCompania;

    public void guardar(ActionEvent actionEvent) {
        llenarVideojuego(textoSKU, textoNombre, textoPrecio, textoPlataforma, textoAnio, textoCompania);

        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoPlataforma.setText("");
        textoAnio.setText("");
        textoCompania.setText("");
    }

    public void llenarVideojuego(TextField textoSKU, TextField textoNombre, TextField textoPrecio, TextField textoPlataforma, TextField textoAnio, TextField textoCompania) {
        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        String plataforma = textoPlataforma.getText();
        int anio = Integer.parseInt(textoAnio.getText());
        String compania = textoCompania.getText();

        Videojuego videojuego = new Videojuego(sku, nombre, precio, plataforma, anio, compania);
        Menu.productos.add(videojuego);

        escribirBinario(videojuego);
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
