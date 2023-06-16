import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearCliente {

    public TextField textoNombre;
    public TextField textoEmail;
    public TextField textoTelefono;

    public void guardar(ActionEvent actionEvent) {
        llenarCLiente(textoNombre, textoEmail, textoTelefono);

        textoNombre.setText("");
        textoEmail.setText("");
        textoTelefono.setText("");
    }

    public void llenarCLiente(TextField textoNombre, TextField textoEmail, TextField textoTelefono) {
        String nombre = textoNombre.getText();
        String email = textoEmail.getText();
        String telefono = textoTelefono.getText();

        Cliente cliente = new Cliente(nombre, email, telefono );
        Menu.clientes.add(cliente);

        escribirBinario();
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
