import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ModificarCliente {

    public TextField textoClientetoMod;
    public TextField textoNombre;
    public TextField textoEmail;
    public TextField textoTelefono;
    public TextField textoAviso;

    public void opcionMenu(ActionEvent actionEvent) {
        String nombre = textoClientetoMod.getText();

        int posMod = buscarCliente(nombre);
        if (posMod == -1) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Nombre no registrado");
            mensaje.showAndWait();
        } else {
            textoClientetoMod.setText("");
            textoAviso.setText("Puede modificar el Cliente");
        }
    }

    public void modificar(ActionEvent actionEvent) {
        String nombre = textoClientetoMod.getText();

        int posMod = buscarCliente(nombre);
        modificarCliente(posMod, textoNombre, textoEmail, textoTelefono);

        textoNombre.setText("");
        textoEmail.setText("");
        textoTelefono.setText("");
    }

    public void modificarCliente(int posMod, TextField textoNombre, TextField textoEmail, TextField textoTelefono) {
        String nombre = textoNombre.getText();
        String email = textoEmail.getText();
        String telefono = textoTelefono.getText();

        Cliente cliente = new Cliente(nombre, email, telefono);
        Menu.clientes.set(posMod, cliente);

        escribirBinario();
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
