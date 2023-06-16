import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearMusica {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoFormato;
    public TextField textoArtista;
    public TextField textoAnio;
    public TextField textoTrackList;

    public void guardar(ActionEvent actionEvent) {
        llenarMusica(textoSKU, textoNombre, textoPrecio, textoPrecio, textoFormato, textoArtista, textoAnio, textoTrackList);

        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoFormato.setText("");
        textoArtista.setText("");
        textoAnio.setText("");
        textoTrackList.setText("");
    }

    public void llenarMusica(TextField textoSKU, TextField textoNombre, TextField textoPrecio, TextField textoPrecio1, TextField textoFormato, TextField textoArtista, TextField textoAnio, TextField textoTrackList) {
        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        int anio = Integer.parseInt(textoAnio.getText());
        String formato = textoFormato.getText();
        String artista = textoArtista.getText();
        String tracList = textoTrackList.getText();

        Musica musica = new Musica(sku, nombre, precio, anio, formato, tracList, artista);
        Menu. productos.add(musica);

        escribirBinario(musica);
    }

    public void escribirBinario(Musica musica) {
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
