import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static ArrayList<Producto> productos = new ArrayList<Producto>();
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static ArrayList<Factura> facturas = new ArrayList<Factura>();

    static File archivoProductos = new File("archivoProductos.bin");
    static File archivoClientes = new File("archivoClientes.bin");
    static File archivoFacturas = new File("archivoFacturas.bin");

    static Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        convArchProd();
        convArchClien();
        convArchFact();

        menu();
    }



    private static void menu() {
        Byte opcion;

        do {
            System.out.println("\n\t.:MENU:.\n");
            System.out.println("1. Dar de alta");
            System.out.println("2. Mostrar");
            System.out.println("3. Modificar");
            System.out.println("4. Borrar");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = entrada.nextByte();
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    visualizar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Error. Digite una opción váida");
                    break;
            }
        } while (opcion != 5);
    }



    public static void crear() {
        Byte opcion;

        System.out.println("\n¿Qué desea crear?");
        System.out.println("1. Productos");
        System.out.println("2. Clientes");
        System.out.println("3. Facturas");
        System.out.println("4. Regresar");
        System.out.print("Opción: ");
        opcion = entrada.nextByte();

        switch (opcion) {
            case 1:
                crearProducto();
                break;
            case 2:
                llenarCliente();
                break;
            case 3:
                crearFactura();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }

    public static void visualizar() {
        Byte opcion;

        System.out.println("\n¿Qué desea visualizar?");
        System.out.println("1. Productos");
        System.out.println("2. Clientes");
        System.out.println("3. Facturas");
        System.out.println("4. Regresar");
        System.out.print("Opción: ");
        opcion = entrada.nextByte();

        switch (opcion) {
            case 1:
                visualizarProducto();
                break;
            case 2:
                visualizarCliente();
                break;
            case 3:
                visualizarFactura();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }

    public static void modificar() {
        Byte opcion;

        System.out.println("\n¿Qué desea modificar?");
        System.out.println("1. Productos");
        System.out.println("2. Clientes");
        System.out.println("3. Facturas");
        System.out.println("4. Regresar");
        System.out.print("Opción: ");
        opcion = entrada.nextByte();

        switch (opcion) {
            case 1:
                modificarProducto();
                break;
            case 2:
                modificarCliente();
                break;
            case 3:
                modificarFactura();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }

    public static void eliminar() {
        Byte opcion;

        System.out.println("\n¿Qué desea eliminar?");
        System.out.println("1. Productos");
        System.out.println("2. Clientes");
        System.out.println("3. Facturas");
        System.out.println("4. Regresar");
        System.out.print("5. Opción: ");
        opcion = entrada.nextByte();

        switch (opcion) {
            case 1:
                eliminarProducto();
                break;
            case 2:
                eliminarCliente();
                break;
            case 3:
                eliminarFactura();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }



    public static void crearProducto() {
        Byte opcion;

        System.out.println("\n\tIngrese el producto a registrar: ");
        System.out.println("1. Pelicula");
        System.out.println("2. Musica");
        System.out.println("3. Videojuego");
        System.out.println("4. Audifonos");
        System.out.println("5. Bocinas");
        System.out.println("6. Tornamesa");
        System.out.println("7. Regresar");
        System.out.print("Opción: ");
        opcion = entrada.nextByte();

        switch (opcion) {
            case 1:
                llenarPelicula();
                break;
            case 2:
                llenarMusica();
                break;
            case 3:
                llenarVideojuego();
                break;
            case 4:
                llenarAudifonos();
                break;
            case 5:
                llenarBocinas();
                break;
            case 6:
                llenarTornamesa();
                break;
            case 7:
                crear();
                break;
            default:
                System.out.println("Error. Opción inválida");
                break;
        }
    }

    public static void crearFactura() {
        System.out.print("\nIngrese el nombre del cliente: ");
        String nombre = entrada.next();

        System.out.print("Digite el SKU del producto: ");
        String productoSKU = entrada.next();

        llenarFactura(nombre, productoSKU);

        crear();
    }



    public static void visualizarProducto() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        visualizar();
    }

    public static void visualizarCliente() {
        for (Cliente elementos : clientes) {
            System.out.println(elementos.toString());
            System.out.println();
        }
        visualizar();
    }

    public static void visualizarFactura() {
        for (Factura elementos : facturas) {
            System.out.println(elementos.toString());
            System.out.println();
        }
        visualizar();
    }



    private static void modificarProducto() {
        System.out.print("\n\tIngrese el SKU a modificar: ");
        String SKUMod = entrada.next();
        int posMod = buscarProducto(SKUMod);
        if (posMod == -1) {
            System.out.println("\nCódigo no encontrado o no registrado");
        } else {
            System.out.println("\n\tIngrese el nuevo producto: ");
            System.out.println("1. Pelicula");
            System.out.println("2. Musica");
            System.out.println("3. Videojuego");
            System.out.println("4. Audifonos");
            System.out.println("5. Bocinas");
            System.out.println("6. Tornamesa");
            System.out.print("Opción: ");
            Byte opcion = entrada.nextByte();

            switch (opcion) {
                case 1:
                    modificarPelicula(posMod);
                    escribirProductosBin();
                    break;
                case 2:
                    modificarMusica(posMod);
                    escribirProductosBin();
                    break;
                case 3:
                    modificarVideojuego(posMod);
                    escribirProductosBin();
                    break;
                case 4:
                    modificarAudifonos(posMod);
                    escribirProductosBin();
                    break;
                case 5:
                    modificarBocinas(posMod);
                    escribirProductosBin();
                    break;
                case 6:
                    modificarTornamesas(posMod);
                    escribirProductosBin();
                    break;
                default:
                    System.out.println("Error. Opción inválida");
                    break;
            }
        }
        modificar();
    }

    public static void modificarCliente() {
        System.out.print("\nIngrese el nombre que desea modificar: ");
        String nombre = entrada.next();

        int posMod = buscarCliente(nombre);
        if (posMod == -1) {
            System.out.println("\nCliente no registrado");
        } else {
            modificarCliente(posMod);
            escribirClientesBin();
        }
        modificar();
    }

    public static void modificarFactura() {
        System.out.print("\nDigite el SKU de la factura que desea modificar: ");
        String SKU = entrada.next();

        int posMod = buscarFactura(SKU);
        if (posMod == -1) {
            System.out.println("\nCódigo no registrado");
        } else {
            modificarFactura(posMod);
            escribirFacturasBin();
        }
        modificar();
    }



    public static void eliminarProducto() {
        System.out.print("\n\tIngrese el SKU que desea borrar: ");
        String SKUDel = entrada.next();

        int posDel = buscarProducto(SKUDel);
        if (posDel == -1) {
            System.out.println("\nCódigo no encontrado o no registrado");
        } else {
            productos.remove(posDel);
            archivoProductos.delete();

            escribirProductosBin();

            System.out.println("\nSe eliminó el producto correctamente");
        }
        eliminar();
    }

    public static void eliminarCliente() {
        System.out.print("\n\tIngrese el nombre del cliente que desea eliminar: ");
        String nombre = entrada.next();

        int posDel = buscarCliente(nombre);
        if (posDel == -1) {
            System.out.println("\nCliente no localizado o no registrado");
        } else {
            buscarCliente(nombre);
            clientes.remove(posDel);
            escribirClientesBin();
        }
        eliminar();
    }

    public static void eliminarFactura() {
        System.out.print("\n\tIngrese el SKU de la factura que desea eliminar: ");
        String SKUDel = entrada.next();

        int posDel = buscarFactura(SKUDel);
        if (posDel == -1) {
            System.out.println("\nFactura no encontrada o no registrada");
        } else {
            buscarFactura(SKUDel);
            facturas.remove(posDel);
            escribirFacturasBin();
        }
        eliminar();
    }



    public static void llenarPelicula() {
        String SKU, nombre, formato, actores;
        Float precio;
        Integer region, anio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese el formato: ");
        formato = entrada.next();
        System.out.print("Digite el código de región: ");
        region = entrada.nextInt();
        System.out.print("Digite el año: ");
        anio = entrada.nextInt();
        System.out.print("Ingrese el actor principal: ");
        actores = entrada.next();

        Pelicula pelicula = new Pelicula(SKU, nombre, precio, region, anio, formato, actores);
        productos.add(pelicula);
        escribirProductosBin();
        crearProducto();
    }

    public static void llenarMusica() {
        String SKU, nombre, formato, tracList, artista;
        Float precio;
        Integer anio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese el formato: ");
        formato = entrada.next();
        System.out.print("Ingrese el artista: ");
        artista = entrada.next();
        System.out.print("Digite el año: ");
        anio = entrada.nextInt();
        System.out.print("Ingrese la track list: ");
        tracList = entrada.next();

        Musica musica = new Musica(SKU, nombre, precio, anio, formato,tracList, artista);
        productos.add(musica);
        escribirProductosBin();
        crearProducto();
    }

    public static void llenarVideojuego() {
        String SKU, nombre, plataforma, compania;
        Float precio;
        Integer anio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la plataforma: ");
        plataforma = entrada.next();
        System.out.print("Digite el año: ");
        anio = entrada.nextInt();
        System.out.print("Ingrese la compañia: ");
        compania = entrada.next();

        Videojuego videojuego = new Videojuego(SKU, nombre, precio, plataforma, anio, compania);
        productos.add(videojuego);
        escribirProductosBin();
        crearProducto();
    }

    public static void llenarAudifonos() {
        String SKU, nombre, marca, tipo;
        Float precio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la marca: ");
        marca = entrada.next();
        System.out.print("Ingrese el tipo de audifono: ");
        tipo = entrada.next();

        Audifonos audifonos = new Audifonos(SKU, nombre, precio, marca, tipo);
        productos.add(audifonos);
        escribirProductosBin();
        crearProducto();
    }

    public static void llenarBocinas() {
        String SKU, nombre, marca, tamanio;
        Float precio;
        Integer potencia;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la marca: ");
        marca = entrada.next();
        System.out.print("Ingrese el tamaño: ");
        tamanio = entrada.next();
        System.out.print("Digite la potencia (MHz): ");
        potencia = entrada.nextInt();

        Bocinas bocinas = new Bocinas(SKU, nombre, precio, marca, potencia, tamanio);
        productos.add(bocinas);
        escribirProductosBin();
        crearProducto();
    }

    public static void llenarTornamesa() {
        String SKU, nombre, marca, parada;
        Float precio, velocidadRotacion;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la marca: ");
        marca = entrada.next();
        System.out.print("Ingrese el tipo de frenado: ");
        parada = entrada.next();
        System.out.print("Digite la velocidad de rotación: ");
        velocidadRotacion = entrada.nextFloat();

        Tornamesa tornamesa = new Tornamesa(SKU, nombre, precio, marca, parada, velocidadRotacion);
        productos.add(tornamesa);
        escribirProductosBin();
        crearProducto();
    }

    public static void llenarCliente() {
        String nombre, email, telefono;

        System.out.print("\nIngrese el nombre del cliente: ");
        nombre = entrada.next();
        System.out.print("Ingrese el email del cliente: ");
        email = entrada.next();
        System.out.print("Digite el teléfono del cliente: ");
        telefono = entrada.next();

        Cliente cliente = new Cliente(nombre, email, telefono );
        clientes.add(cliente);
        escribirClientesBin();
        crear();
    }

    public static void llenarFactura(String nombre, String pName) {
        String SKU, fecha, producto = pName, name = nombre;
        Float total;
        Integer auxC = buscarCliente(nombre), auxP = buscarProducto(producto);

        if (auxC != -1) {
            if (auxP != -1) {
                System.out.print("\nDigite el SKU de la factura: ");
                SKU = entrada.next();
                System.out.print("Ingrese la fecha: ");
                fecha = entrada.next();

                Integer pos = buscarProducto(producto);
                total = productos.get(pos).getPrecio();

                Factura factura = new Factura(SKU, fecha, producto, name, total);
                facturas.add(factura);

                escribirFacturasBin();
            } else {
                System.out.println("\nNo existe el producto");
            }
        } else {
            System.out.println("\nNo existe el cliente");
        }
    }



    public static void escribirProductosBin() {
        try {
            FileOutputStream archivo = new FileOutputStream(archivoProductos);
            ObjectOutputStream escritura = new ObjectOutputStream(archivo);

            escritura.writeObject(productos);
            escritura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        }
    }

    public static void escribirClientesBin() {
        try {
            FileOutputStream archivo = new FileOutputStream(archivoClientes);
            ObjectOutputStream escritura = new ObjectOutputStream(archivo);

            escritura.writeObject(clientes);
            escritura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        }
    }

    public static void escribirFacturasBin() {
        try {
            FileOutputStream archivo = new FileOutputStream(archivoFacturas);
            ObjectOutputStream escritura = new ObjectOutputStream(archivo);

            escritura.writeObject(facturas);
            escritura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. " + e);
        } catch (IOException e) {
            System.out.println("Error. " + e);
        }
    }



    public static void modificarPelicula(Integer pos) {
        String SKU, nombre, formato, actores;
        Float precio;
        Integer region, anio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese el formato: ");
        formato = entrada.next();
        System.out.print("Digite el código de región: ");
        region = entrada.nextInt();
        System.out.print("Digite el año: ");
        anio = entrada.nextInt();
        System.out.print("Ingrese el actor principal: ");
        actores = entrada.next();

        Pelicula pelicula = new Pelicula(SKU, nombre, precio, region, anio, formato, actores);
        productos.set(pos, pelicula);
    }

    public static void modificarMusica(Integer pos) {
        String SKU, nombre, formato, tracList, artista;
        Float precio;
        Integer anio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese el formato: ");
        formato = entrada.next();
        System.out.print("Ingrese el artista: ");
        artista = entrada.next();
        System.out.print("Digite el año: ");
        anio = entrada.nextInt();
        System.out.print("Ingrese la track list: ");
        tracList = entrada.next();

        Musica musica = new Musica(SKU, nombre, precio, anio, formato,tracList, artista);
        productos.set(pos, musica);
    }

    public static void modificarVideojuego(Integer pos) {
        String SKU, nombre, plataforma, compania;
        Float precio;
        Integer anio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la plataforma: ");
        plataforma = entrada.next();
        System.out.print("Digite el año: ");
        anio = entrada.nextInt();
        System.out.print("Ingrese la compañia: ");
        compania = entrada.next();

        Videojuego videojuego = new Videojuego(SKU, nombre, precio, plataforma, anio, compania);
        productos.set(pos, videojuego);
    }

    public static void modificarAudifonos(Integer pos) {
        String SKU, nombre, marca, tipo;
        Float precio;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la marca: ");
        marca = entrada.next();
        System.out.print("Ingrese el tipo de audifono: ");
        tipo = entrada.next();

        Audifonos audifonos = new Audifonos(SKU, nombre, precio, marca, tipo);
        productos.set(pos, audifonos);
    }

    public static void modificarBocinas(Integer pos) {
        String SKU, nombre, marca, tamanio;
        Float precio;
        Integer potencia;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la marca: ");
        marca = entrada.next();
        System.out.print("Ingrese el tamaño: ");
        tamanio = entrada.next();
        System.out.print("Digite la potencia (MHz): ");
        potencia = entrada.nextInt();

        Bocinas bocinas = new Bocinas(SKU, nombre, precio, marca, potencia, tamanio);
        productos.set(pos, bocinas);
    }

    public static void modificarTornamesas(Integer pos) {
        String SKU, nombre, marca, parada;
        Float precio, velocidadRotacion;

        System.out.print("\nDigite el SKU: ");
        SKU = entrada.next();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.next();
        System.out.print("Digite el precio: ");
        precio = entrada.nextFloat();
        System.out.print("Ingrese la marca: ");
        marca = entrada.next();
        System.out.print("Ingrese el tipo de frenado: ");
        parada = entrada.next();
        System.out.print("Digite la velocidad de rotación: ");
        velocidadRotacion = entrada.nextFloat();

        Tornamesa tornamesa = new Tornamesa(SKU, nombre, precio, marca, parada, velocidadRotacion);
        productos.set(pos, tornamesa);
    }

    public static void modificarCliente(Integer pos) {
        String nombre, email, telefono;

        System.out.print("\nIngrese el nombre del cliente: ");
        nombre = entrada.next();
        System.out.print("Ingrese el email del cliente: ");
        email = entrada.next();
        System.out.print("Digite el teléfono del cliente: ");
        telefono = entrada.next();

        Cliente cliente = new Cliente(nombre, email, telefono );
        clientes.set(pos, cliente);
    }

    public static void modificarFactura(Integer pos) {
        System.out.print("\nIngrese el nuevo nombre del cliente: ");
        String nombre = entrada.next();
        System.out.print("Digite el nuevo SKU del producto: ");
        String producto = entrada.next();

        String SKU, fecha;
        Float total;
        Integer auxC = buscarCliente(nombre), auxP = buscarProducto(producto), posM = pos;

        if (auxC != -1) {
            if (auxP != -1) {
                System.out.print("Digite el nuevo SKU de la factura: ");
                SKU = entrada.next();
                System.out.print("Ingrese la fecha: ");
                fecha = entrada.next();
                String nomProd = productos.get(auxP).getNombre();
                total = productos.get(auxP).getPrecio();

                Factura factura = new Factura(SKU, fecha, nomProd, nombre, total);
                facturas.set(posM, factura);
            } else {
                System.out.println("\nNo existe el producto");
            }
        } else {
            System.out.println("\nNo existe el cliente");
        }
    }



    public static Integer buscarProducto(String SKU) {
        String sku = SKU;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getSKU().contains(sku)) {
                return i;
            }
        }
        return -1;
    }

    public static Integer buscarCliente(String nombre) {
        String name = nombre;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre().contains(name)) {
                return i;
            }
        }
        return -1;
    }

    public static Integer buscarFactura(String SKU) {
        String sku = SKU;
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getSKU().contains(sku)) {
                return i;
            }
        }
        return -1;
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
