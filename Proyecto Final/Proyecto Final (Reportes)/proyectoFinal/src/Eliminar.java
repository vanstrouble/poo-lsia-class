import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Eliminar {

    public TextField textoOpcion;

    public void opcionMenu(ActionEvent actionEvent) {
        int opcion = Integer.parseInt(textoOpcion.getText());

        switch (opcion) {
            case 1:
                Productos();
                break;
            case 2:
                Clientes();
                break;
            case 3:
                Facturas();
                break;
            case 4:
                Alert mensaje = new Alert(Alert.AlertType.ERROR);
                mensaje.setTitle("Error");
                mensaje.setContentText("Opción inválida");
                mensaje.showAndWait();
                break;
        }
    }

    public void Productos() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/eliminarProducto.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void Clientes() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/eliminarCliente.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void Facturas() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/eliminarFactura.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }
}
