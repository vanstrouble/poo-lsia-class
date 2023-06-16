import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearPelicula {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoFormato;
    public TextField textoCodigoR;
    public TextField textoAnio;
    public TextField textoActor;

    public void guardar(ActionEvent actionEvent) {
        llenarPelicula(textoSKU, textoNombre, textoPrecio, textoFormato, textoCodigoR, textoAnio, textoActor);

        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoFormato.setText("");
        textoCodigoR.setText("");
        textoAnio.setText("");
        textoActor.setText("");
    }

    public void llenarPelicula(TextField textoSKU, TextField textoNombre, TextField textoPrecio, TextField textoFormato, TextField textoCodigoR, TextField textoAnio, TextField textoActor) {
        String SKU = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        int region = Integer.parseInt(textoCodigoR.getText());
        int anio = Integer.parseInt(textoAnio.getText());
        String formato = textoFormato.getText();
        String actores = textoActor.getText();

        Pelicula pelicula = new Pelicula(SKU, nombre, precio, region, anio, formato, actores);
        Menu.productos.add(pelicula);

        escribirBinario(pelicula);
    }

    public void escribirBinario(Pelicula pelicula) {
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
