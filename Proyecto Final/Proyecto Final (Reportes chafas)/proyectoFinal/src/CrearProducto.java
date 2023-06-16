import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrearProducto {

    public TextField textoOpcion;

    public void opcionMenu(ActionEvent actionEvent) {
        int opcion = Integer.parseInt(textoOpcion.getText());

        switch (opcion) {
            case 1:
                Pelicula();
                break;
            case 2:
                Musica();
                break;
            case 3:
                Videojuego();
                break;
            case 4:
                Audifonos();
                break;
            case 5:
                Bocinas();
                break;
            case 6:
                Tornamesa();
                break;
            default:
                Alert mensaje = new Alert(Alert.AlertType.ERROR);
                mensaje.setTitle("Error");
                mensaje.setContentText("Opción inválida");
                mensaje.showAndWait();
                break;
        }
    }

    public void Pelicula() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearPelicula.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void Musica() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearMusica.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void Videojuego() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearVideojuego.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void Audifonos() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearAudifonos.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void Bocinas() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearBocinas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void Tornamesa() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/crearTornamesa.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }
}
