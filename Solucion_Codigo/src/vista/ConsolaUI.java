package vista;

import controlador.ComercioController;
import controlador.ProductoController;
import controlador.ArchivoController;
import modelo.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class ConsolaUI {
    private ComercioController comercioController;
    private ProductoController productoController;
    private ArchivoController archivoController;
    private Scanner scanner;

    public ConsolaUI(ComercioController comercioController, ProductoController productoController, ArchivoController archivoController) {
        this.comercioController = comercioController;
        this.productoController = productoController;
        this.archivoController = archivoController;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Cargar Productos desde CSV");
            System.out.println("3. Registrar Punto Comercial");
            System.out.println("4. Mostrar Productos");
            System.out.println("5. Simular Actividad Comercial");
            System.out.println("6. Generar Reporte");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarProductoManual();
                case 2 -> cargarDesdeCSV();
                case 3 -> registrarPuntoComercialCompleto();
                case 4 -> mostrarProductos();
                case 5 -> comercioController.simularActividad();
                case 6 -> comercioController.generarReporte();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void registrarProductoManual() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("PVP: ");
        double pvp = scanner.nextDouble();
        System.out.print("Costo: ");
        double costo = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        Producto p = new Producto(id, nombre, pvp, costo, stock);
        productoController.registrarProducto(p);
        System.out.println("Producto registrado exitosamente.");
    }

    private void cargarDesdeCSV() {
        System.out.print("Ruta del archivo CSV: ");
        String ruta = scanner.nextLine();
        archivoController.cargarDesdeCSV(ruta, productoController.getProductos());
    }

    private void mostrarProductos() {
        List<Producto> productos = productoController.getProductos();
        System.out.println("=== Productos Registrados ===");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    private void registrarPuntoComercialCompleto() {
        System.out.print("ID del Punto: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nombre del Punto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        // Horario básico
        List<HorarioAtencion> horarios = new ArrayList<>();
        horarios.add(new HorarioAtencion(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(18, 0)));

        // Elegir tipo de actividad económica
        System.out.println("Seleccione tipo de actividad económica:");
        System.out.println("1. Feria Itinerante");
        System.out.println("2. Mercado Fijo");
        System.out.println("3. Negocio Base");
        int tipo = scanner.nextInt(); scanner.nextLine();

        ActividadEconomica actividad = null;

        Responsable responsable = new Responsable(1, "Admin Local", "Coordinador");

        switch (tipo) {
            case 1 -> {
                List<Responsable> responsables = new ArrayList<>();
                responsables.add(responsable);
                actividad = new FeriaItinerante("Feria", responsables);
            }
            case 2 -> {
                System.out.print("Costo espacio: ");
                double costoEspacio = scanner.nextDouble();
                System.out.print("Rotación productos: ");
                double rotacion = scanner.nextDouble();
                List<Responsable> responsables = new ArrayList<>();
                responsables.add(responsable);
                actividad = new MercadoFijo(costoEspacio, rotacion, 10, responsables);
            }
            case 3 -> {
                List<Producto> inventario = new ArrayList<>(productoController.getProductos());
                actividad = new NegocioBase(inventario, responsable, responsable); // mismo como vendedor
            }
            default -> System.out.println("Opción inválida.");
        }

        if (actividad != null) {
            PuntoComercial punto = new PuntoComercial(id, nombre, ubicacion, horarios, actividad);
            comercioController.registrarPuntoComercial(punto);
            System.out.println("Punto comercial registrado correctamente.");
        }
    }
}
