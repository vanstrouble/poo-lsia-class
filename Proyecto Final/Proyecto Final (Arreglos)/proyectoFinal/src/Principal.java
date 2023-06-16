import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {

        System.out.print("Digite el número de productos que desea agregar: ");
        Integer p = entrada.nextInt();
        Producto productos[] = new Producto[p];
        System.out.print("Digite el número de clientes que desea agregar: ");
        Integer c = entrada.nextInt();
        Cliente clientes[] = new Cliente[c];
        System.out.print("Digite el número de facturas que desea agregar: ");
        Integer f = entrada.nextInt();
        Factura facturas[] = new Factura[f];

        for (int i = 0; i < productos.length; i++) {
            productos[i] = null;
        }
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = null;
        }
        for (int i = 0; i < facturas.length; i++) {
            facturas[i] = null;
        }

        menu(productos, clientes, facturas);
    }


    private static void menu(Producto productos[], Cliente clientes[], Factura facturas[]) {
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
                    crear(productos, clientes, facturas);
                    break;
                case 2:
                    visualizar(productos, clientes, facturas);
                    break;
                case 3:
                    modificar(productos, clientes, facturas);
                    break;
                case 4:
                    eliminar(productos, clientes, facturas);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Error. Digite una opción váida");
                    break;
            }
        } while (opcion != 5);
    }


    public static void crear(Producto productos[], Cliente clientes[], Factura facturas[]) {
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
                crearProducto(productos);
                break;
            case 2:
                crearCliente(clientes);
                break;
            case 3:
                crearFactura(facturas, clientes, productos);
                break;
            case 4:
                menu(productos, clientes, facturas);
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }

    public static void visualizar(Producto productos[], Cliente clientes[], Factura facturas[]) {
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
                visualizarProducto(productos);
                break;
            case 2:
                visualizarCliente(clientes);
                break;
            case 3:
                visualizarFactura(facturas);
                break;
            case 4:
                menu(productos, clientes, facturas);
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }

    public static void modificar(Producto productos[], Cliente clientes[], Factura facturas[]) {
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
                modificarProducto(productos);
                break;
            case 2:
                modificarCliente(clientes);
                break;
            case 3:
                modificarFactura(facturas, clientes, productos);
                break;
            case 4:
                menu(productos, clientes, facturas);
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }

    public static void eliminar(Producto productos[], Cliente clientes[], Factura facturas[]) {
        Byte opcion;

        System.out.println("\n¿Qué desea eliminar?");
        System.out.println("1. Productos");
        System.out.println("2. Clientes");
        System.out.println("3. Facturas");
        System.out.println("4. Regresar");
        opcion = entrada.nextByte();

        switch (opcion) {
            case 1:
                eliminarProducto(productos);
                break;
            case 2:
                eliminarCliente(clientes);
                break;
            case 3:
                eliminarFactura(facturas);
                break;
            case 4:
                menu(productos, clientes, facturas);
                break;
            default:
                System.out.println("Error. Opción inválidad");
                break;
        }
    }


    public static void crearProducto(Producto[] elementos) {
        Byte opción;
        Integer posicion = posDisProducto(elementos);

        if (posicion == -1) {
            System.out.println("No hay espacio disponible");
        } else {
            System.out.println("\n\tIngrese el producto a registrar: ");
            System.out.println("1. Pelicula");
            System.out.println("2. Musica");
            System.out.println("3. Videojuego");
            System.out.println("4. Audifonos");
            System.out.println("5. Bocinas");
            System.out.println("6. Tornamesa");
            System.out.print("Opción: ");
            opción = entrada.nextByte();

            switch (opción) {
                case 1:
                    elementos[posicion] = llenarPelicula(elementos[posicion]);
                    break;
                case 2:
                    elementos[posicion] = llenarMusica(elementos[posicion]);
                    break;
                case 3:
                    elementos[posicion] = llenarVideojuego(elementos[posicion]);
                    break;
                case 4:
                    elementos[posicion] = llenarAudifonos(elementos[posicion]);
                    break;
                case 5:
                    elementos[posicion] = llenarBocinas(elementos[posicion]);
                    break;
                case 6:
                    elementos[posicion] = llenarTornamesa(elementos[posicion]);
                    break;
                default:
                    System.out.println("Error. Opción inválida");
                    break;
            }
        }
    }

    public static void crearCliente(Cliente[] elementos)  {
        Integer posicion = posDisCliente(elementos);

        if (posicion == -1) {
            System.out.println("No hay espacio");
        } else {
            elementos[posicion] = llenarCliente(elementos[posicion]);
        }
    }

    public static void crearFactura(Factura[] facturas, Cliente[] clientes, Producto[] productos) {
        Integer posF  = posDisFactura(facturas);

        if (posF != -1) {
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = entrada.next();

            System.out.print("Digite el SKU del producto: ");
            String SKU = entrada.next();

            Integer posC = buscarCliente(clientes, nombre);
            Integer posP = buscarProducto(productos, SKU);

            if (posC == -1 || posP == -1) {
                System.out.println("\nError");
            } else {
                String product = productos[posP].getNombre();
                Float precio = productos[posP].getPrecio();
                facturas[posF] = llenarFactura(facturas[posF], nombre, product, precio);
            }
        }
    }



    public static void visualizarProducto(Producto[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null) {
                System.out.println(elementos[i].toString());
            }
        }
    }

    public static void visualizarCliente(Cliente[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null) {
                System.out.println(elementos[i].toString());
            }
        }
    }

    public static void visualizarFactura(Factura[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null) {
                System.out.println(elementos[i].toString());
            }
        }
    }



    private static void modificarProducto(Producto[] elementos) {
        System.out.print("\n\tIngrese el SKU a modificar: ");
        String SKUMod = entrada.next();
        int posMod = buscarProducto(elementos, SKUMod);
        if (posMod == -1) {
            System.out.println("\nCódigo no registrado");
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
                    elementos[posMod] = llenarPelicula(elementos[posMod]);
                    break;
                case 2:
                    elementos[posMod] = llenarMusica(elementos[posMod]);
                    break;
                case 3:
                    elementos[posMod] = llenarVideojuego(elementos[posMod]);
                    break;
                case 4:
                    elementos[posMod] = llenarAudifonos(elementos[posMod]);
                    break;
                case 5:
                    elementos[posMod] = llenarBocinas(elementos[posMod]);
                    break;
                case 6:
                    elementos[posMod] = llenarTornamesa(elementos[posMod]);
                    break;
                default:
                    System.out.println("Error. Opción inválida");
                    break;
            }
        }
    }

    public static void modificarCliente(Cliente[] elementos) {
        System.out.print("\nIngrese el nombre que desea modificar: ");
        String nombre = entrada.next();

        int posMod = buscarCliente(elementos, nombre);
        if (posMod == -1) {
            System.out.println("\nCliente no encontrado");
        } else {
            elementos[posMod] = llenarCliente(elementos[posMod]);
        }
    }

    public static void modificarFactura(Factura[] facturas, Cliente[] clientes, Producto[] productos) {
        System.out.print("\n\tIngrese el SKU de factura que desea modificar: ");
        String SKUMod = entrada.next();

        int posF = buscarFactura(facturas, SKUMod);
        if (posF == -1) {
            System.out.println("\nNo existe la factura");
        } else {
            if (posF != -1) {
                System.out.print("Ingrese el nombre del cliente: ");
                String nombre = entrada.next();
                System.out.print("Ingrese el SKU del producto: ");
                String SKU = entrada.next();

                int posC = buscarCliente(clientes, nombre);
                int posP = buscarProducto(productos, SKU);

                if (posC == -1 || posP == -1) {
                    System.out.println("\nError");
                } else {
                    String product = productos[posP].getNombre();
                    Float precio = productos[posP].getPrecio();
                    llenarFactura(facturas[posF], nombre, product, precio);
                }
            }
        }
    }



    public static void eliminarProducto(Producto[] elementos) {
        System.out.print("\n\tIngrese el SKU que desea borrar: ");
        String SKUDel = entrada.next();

        int posDel = buscarProducto(elementos, SKUDel);
        if (posDel == -1) {
            System.out.println("\nCódigo no encontrado o no registrado");
        } else {
            elementos[posDel] = null;
        }
    }

    public static void eliminarCliente(Cliente[] elementos) {
        System.out.print("\n\tIngrese el nombre del cliente que desea eliminar: ");
        String nombre = entrada.next();

        int posDel = buscarCliente(elementos, nombre);
        if (posDel == -1) {
            System.out.println("\nCliente no localizado o no registrado");
        } else {
            elementos[posDel] = null;
        }
    }

    public static void eliminarFactura(Factura[] elementos) {
        System.out.print("\n\tIngrese el SKU de la factura que desea eliminar: ");
        String SKUDel = entrada.next();

        int posDel = buscarFactura(elementos, SKUDel);
        if (posDel == -1) {
            System.out.println("\nFactura no encontrada o no registrada");
        } else {
            elementos[posDel] = null;
        }
    }



    public static Producto llenarPelicula(Producto elementos) {
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

        return new Pelicula(SKU, nombre, precio, region, anio, formato, actores);
    }

    public static Producto llenarVideojuego(Producto elementos) {
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

        return new Videojuego(SKU, nombre, precio, plataforma, anio, compania);
    }

    public static Producto llenarMusica(Producto elementos) {
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

        return new Musica(SKU, nombre, precio, anio, formato,tracList, artista);
    }

    public static Producto llenarAudifonos(Producto elementos) {
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

        return new Audifonos(SKU, nombre, precio, marca, tipo);
    }

    public static Producto llenarBocinas(Producto elementos) {
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

        return new Bocinas(SKU, nombre, precio, marca, potencia, tamanio);
    }

    public static Producto llenarTornamesa(Producto elementos) {
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

        return new Tornamesa(SKU, nombre, precio, marca, parada, velocidadRotacion);
    }


    public static Cliente llenarCliente(Cliente elementos) {
        String nombre, email, telefono;

        System.out.print("\nIngrese el nombre del cliente: ");
        nombre = entrada.next();
        System.out.print("Ingrese el email del cliente: ");
        email = entrada.next();
        System.out.print("Digite el teléfono del cliente: ");
        telefono = entrada.next();

        return new Cliente(nombre, email, telefono );
    }

    public static Factura llenarFactura(Factura facturas, String nombre, String pName, Float precio) {
        String SKU, fecha, producto = pName, name = nombre;
        Float total = precio;

        System.out.print("\nDigite el SKU de la factura: ");
        SKU = entrada.next();
        System.out.print("Ingrese la fecha: ");
        fecha = entrada.next();

        return new Factura(SKU, fecha, producto, name, total);
    }



    public static Integer buscarProducto(Producto[] elementos, String SKU) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].getSKU().equals(SKU)) {
                return i;
            }
        }
        return -1;
    }

    public static Integer buscarCliente(Cliente[] elementos, String nombre) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static Integer buscarFactura(Factura[] elementos, String SKU) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].getSKU().equals(SKU)) {
                return i;
            }
        }
        return -1;
    }

    public static Integer posDisProducto(Producto[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static Integer posDisCliente(Cliente[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static Integer posDisFactura(Factura[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
