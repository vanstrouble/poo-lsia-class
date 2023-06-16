import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ModificarMusica {
    public TextField textoSKU;
    public TextField textoNombre;
    public TextField textoPrecio;
    public TextField textoFormato;
    public TextField textoArtista;
    public TextField textoAnio;
    public TextField textoTrackList;
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
        modificarMusica();

        textoSKUtoMod.setText("");
        textoSKU.setText("");
        textoNombre.setText("");
        textoPrecio.setText("");
        textoFormato.setText("");
        textoArtista.setText("");
        textoAnio.setText("");
        textoTrackList.setText("");
    }

    public void modificarMusica() {
        String skuMod = textoSKUtoMod.getText();
        int pos = buscarProducto(skuMod);

        String sku = textoSKU.getText();
        String nombre = textoNombre.getText();
        Float precio = Float.parseFloat(textoPrecio.getText());
        int anio = Integer.parseInt(textoAnio.getText());
        String formato = textoFormato.getText();
        String artista = textoArtista.getText();
        String tracList = textoTrackList.getText();

        Musica musica = new Musica(sku, nombre, precio, anio, formato, tracList, artista);
        Menu. productos.set(pos, musica);

        escribirBinario(musica);
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
