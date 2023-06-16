import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Crear {

    public TextField textoOpcion;

    public void opcionMenu(ActionEvent actionEvent) {
        int opcion = Integer.parseInt(textoOpcion.getText());

        switch (opcion) {
            case 1:
                productos();
                break;
            case 2:
                clientes();
                break;
            case 3:
                facturas();
                break;
            case 4:
                Alert mensaje = new Alert(Alert.AlertType.ERROR);
                mensaje.setTitle("Error");
                mensaje.setContentText("Opción inválida");
                mensaje.showAndWait();
                break;
        }
    }

    public void productos() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearProducto.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void clientes() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearCliente.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void facturas() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearFactura.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }
}
