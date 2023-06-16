import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VisualizarCliente {
    public TextField textoNombre;
    public TextArea mClientes;

    public void ver(ActionEvent actionEvent) {
        String nombreEliminar = textoNombre.getText();
        int posDel = buscarCliente(nombreEliminar);

        if (posDel != -1) {
            mClientes.setText(Menu.clientes.get(posDel).toString());
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Producto no registrado");
            mensaje.showAndWait();
        }
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
}
