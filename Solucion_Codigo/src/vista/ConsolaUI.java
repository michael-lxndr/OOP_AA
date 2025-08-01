package vista;

import controlador.ArchivoController;
import controlador.ComercioController;
import controlador.ProductoController;
import modelo.*;

import java.util.*;

public class ConsolaUI {

    private final ComercioController comercioController = new ComercioController();
    private final ProductoController productoController = new ProductoController();
    private final ArchivoController archivoController = new ArchivoController();

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("==== SIMULADOR DE COMERCIO LOCAL ====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar punto comercial");
            System.out.println("3. Simular actividad");
            System.out.println("4. Generar reporte");
            System.out.println("5. Guardar productos en CSV");
            System.out.println("6. Cargar productos desde CSV");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarProducto();
                case 2 -> registrarPuntoComercial();
                case 3 -> comercioController.simularActividad();
                case 4 -> comercioController.generarReporte();
                case 5 -> archivoController.guardarProductos("productos.csv", productoController.getProductos());
                case 6 -> {
                    List<Producto> cargados = archivoController.cargarProductos("productos.csv");
                    cargados.forEach(productoController::registrarProducto);
                }
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void registrarProducto() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Costo: ");
        double costo = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(id, nombre, precio, costo, stock);
        productoController.registrarProducto(producto);
        System.out.println("Producto registrado.\n");
    }

    private void registrarPuntoComercial() {
        System.out.print("ID del punto comercial: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        System.out.println("Tipo de comercio:");
        System.out.println("1. Feria itinerante");
        System.out.println("2. Tienda local");
        System.out.println("3. Mercado fijo");
        System.out.print("Seleccione tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        List<Producto> productos = new ArrayList<>(productoController.getProductos());
        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(new Vendedor(1, "Vendedor Genérico"));

        ActividadEconomica actividad = switch (tipo) {
            case 1 -> {
                System.out.print("Costo transporte: ");
                double transporte = scanner.nextDouble();
                System.out.print("Costo instalación: ");
                double instalacion = scanner.nextDouble();
                List<Recurso> recursosFeria = new ArrayList<>();
                recursosFeria.add(new Recurso("Ventas del día", 200, 1000));
                yield new FeriaItinerante("Feria Itinerante", recursosFeria, transporte, instalacion);
            }
            case 2 -> {
                List<Recurso> recursosTienda = new ArrayList<>();
                yield new TiendaLocal("Tienda Local", recursosTienda, productos);
            }
            case 3 -> {
                System.out.print("Costo de espacio: ");
                double espacio = scanner.nextDouble();
                System.out.print("Rotación de productos: ");
                double rotacion = scanner.nextDouble();
                List<Recurso> recursosMercado = new ArrayList<>();
                recursosMercado.add(new Recurso("Rotación alta", 150, 800));
                yield new MercadoFijo("Mercado Fijo", recursosMercado, espacio, rotacion);
            }
            default -> null;
        };

        PuntoComercial punto = new PuntoComercial(id, nombre, ubicacion, actividad, productos, vendedores);
        comercioController.registrarPuntoComercial(punto);
        System.out.println("Punto comercial registrado.\n");
    }
}
