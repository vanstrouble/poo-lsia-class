package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField textoNombre;
    public Label etiquetaNombre;
    public Button botonSaludar;

    public void clicSaludar(ActionEvent actionEvent) {
        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Personita especial");
        mensaje.setContentText(String.format("¿Sabías quién es muy importante para mí? %s", textoNombre.getText()));
        // mensaje.show();
        mensaje.showAndWait(); // Espera hasta que se cierra la ventana
        System.out.println("Hola " + textoNombre.getText());
    }
}
