import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ModificarFactura {

    public TextField textoSKUtoMod;
    public TextField textoAviso;
    public TextField textoSKUFactura;
    public TextField textoFecha;
    public TextField textoNombreCliente;
    public TextField textoSKUProducto;

    public void opcionMenu(ActionEvent actionEvent) {
        String skuMod = textoSKUtoMod.getText();
        int posMod = buscarFactura(skuMod);
        if (posMod == -1) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("No existe la factura");
            mensaje.showAndWait();
        } else {
            textoAviso.setText("Puede modificar la venta");
            textoSKUtoMod.setText("");
        }
    }

    public void modificarFactura(ActionEvent actionEvent) {
        String skuMod = textoSKUtoMod.getText();
        int posMod = buscarFactura(skuMod);

        String SKU = textoSKUFactura.getText();
        String fecha = textoFecha.getText();
        String producto = textoSKUProducto.getText();
        String nombre = textoNombreCliente.getText();
        Float total;
        Integer auxC = buscarCliente(nombre), auxP = buscarProducto(producto);
        if (auxC != -1) {
            if (auxP != -1) {
                String nombreProd = Menu.productos.get(auxP).getNombre();
                total = Menu.productos.get(auxP).getPrecio();
                Factura factura = new Factura(SKU, fecha, nombreProd, nombre, total);
                Menu.facturas.set(posMod, factura);
                escribirBinario();

                textoSKUFactura.setText("");
                textoNombreCliente.setText("");
                textoFecha.setText("");
                textoSKUProducto.setText("");
            } else {
                Alert mensaje = new Alert(Alert.AlertType.ERROR);
                mensaje.setTitle("Menu");
                mensaje.setContentText("No existe el producto");
                mensaje.showAndWait();
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

    public static Integer buscarProducto(String SKU) {
        String sku = SKU;
        for (int i = 0; i < Menu.productos.size(); i++) {
            if (Menu.productos.get(i).getSKU().contains(sku)) {
                return i;
            }
        }
        return -1;
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

    public static Integer buscarFactura(String SKU) {
        String sku = SKU;
        for (int i = 0; i < Menu.facturas.size(); i++) {
            if (Menu.facturas.get(i).getSKU().contains(sku)) {
                return i;
            }
        }
        return -1;
    }
}
