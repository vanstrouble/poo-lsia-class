import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearFactura {
    public TextField textoSKUProducto;
    public TextField textoNombreCliente;
    public TextField textoSKUFactura;
    public TextField textoFecha;

    public void guardar(ActionEvent actionEvent) {
        llenarFactura(textoSKUProducto, textoNombreCliente, textoSKUFactura, textoFecha);
    }

    public void llenarFactura(TextField textoSKUProducto, TextField textoNombreCliente, TextField textoSKUFactura, TextField textoFecha) {
        String SKU = textoSKUFactura.getText(), fecha = textoFecha.getText(), producto = textoSKUProducto.getText(), name = textoNombreCliente.getText();
        Float total;
        Integer auxC = buscarCliente(name), auxP = buscarProducto(producto);
        if (auxC != -1) {
            if (auxP != -1) {
                Integer posicion = buscarProducto(producto);
                total = Menu.productos.get(posicion).getPrecio();

                Factura factura = new Factura(SKU, fecha, producto, name, total);
                Menu.facturas.add(factura);

                escribirBinario();

                textoSKUFactura.setText("");
                textoNombreCliente.setText("");
                textoFecha.setText("");
                textoSKUProducto.setText("");
            }
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("No existe el cliente");
            mensaje.showAndWait();
        }
    }

    public void escribirBinario() {
        try {
            FileOutputStream archivo = new FileOutputStream(Menu.archivoFacturas);
            ObjectOutputStream escribir = new ObjectOutputStream(archivo);

            escribir.writeObject(Menu.facturas);
            escribir.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        }
    }

    public Integer buscarProducto(String SKU) {
        String sku = SKU;
        for (int i = 0; i < Menu.productos.size(); i++) {
            if (Menu.productos.get(i).getSKU().contains(sku)) {
                return i;
            }
        }
        return -1;
    }

    public Integer buscarCliente(String nombre) {
        String name = nombre;
        for (int i = 0; i < Menu.clientes.size(); i++) {
            if (Menu.clientes.get(i).getNombre().contains(name)) {
                return i;
            }
        }
        return -1;
    }
}
