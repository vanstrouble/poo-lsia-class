import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Menu {
    static ArrayList<Producto> productos = new ArrayList<Producto>();
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static ArrayList<Factura> facturas = new ArrayList<Factura>();

    static File archivoProductos = new File("archivoProductos.bin");
    static File archivoClientes = new File("archivoClientes.bin");
    static File archivoFacturas = new File("archivoFacturas.bin");

    public TextField textoOpcion;


    public void opcionMenu(ActionEvent actionEvent) {
        convArchProd();
        convArchClien();
        convArchFact();

        int opcion = Integer.parseInt(textoOpcion.getText());

        switch (opcion) {
            case 1:
                menuCrear();
                break;
            case 2:
                menuVisualizar();
                break;
            case 3:
                menuModificar();
                break;
            case 4:
                menuEliminar();
                break;
            default:
                Alert mensaje = new Alert(Alert.AlertType.ERROR);
                mensaje.setTitle("Error");
                mensaje.setContentText("Opción inválida");
                mensaje.showAndWait();
                break;
        }
    }

    public void menuCrear() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/Crear.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void menuVisualizar() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/Visualizar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void menuModificar() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/Modificar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }

    public void menuEliminar() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("FX/Eliminar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }



    public static void convArchProd() {
        try {
            FileInputStream archivo = new FileInputStream(archivoProductos);
            ObjectInputStream lectura = new ObjectInputStream(archivo);
            productos = (ArrayList<Producto>)lectura.readObject();

            lectura.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error. " + e);
        }
    }

    public static void convArchClien() {
        try {
            FileInputStream archivo = new FileInputStream(archivoClientes);
            ObjectInputStream lectura = new ObjectInputStream(archivo);
            clientes = (ArrayList<Cliente>)lectura.readObject();

            lectura.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error. " + e);
        }
    }

    public static void convArchFact() {
        try {
            FileInputStream archivo = new FileInputStream(archivoFacturas);
            ObjectInputStream lectura = new ObjectInputStream(archivo);
            facturas = (ArrayList<Factura>)lectura.readObject();

            lectura.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error. " + e);
        }
    }
}
