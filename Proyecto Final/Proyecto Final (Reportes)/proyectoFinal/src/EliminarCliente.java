import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EliminarCliente {

    public TextField textoNombreCliente;

    public void opcionMenu(ActionEvent actionEvent) {
        String nombreEliminar = textoNombreCliente.getText();
        int posDel = buscarCliente(nombreEliminar);

        if (posDel == -1) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Nombre no registrado");
            mensaje.showAndWait();
        } else {
            Menu.clientes.remove(posDel);
            Menu.archivoClientes.delete();

            escribirBinario();
        }
        textoNombreCliente.setText("");
    }

    public static Integer buscarCliente(String nombre) {
        String name = nombre;
        for (int i = 0; i < Menu.clientes.size(); i++) {
            if (Menu.clientes.get(i).getNombre().contains(name)) {
                return i;
            }
        }
        return -1;
    }

    public void escribirBinario() {
        try {
            FileOutputStream archivo = new FileOutputStream(Menu.archivoClientes);
            ObjectOutputStream escribir = new ObjectOutputStream(archivo);

            escribir.writeObject(Menu.clientes);
            escribir.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        }
    }
}
