import controlador.ArchivoController;
import controlador.ComercioController;
import controlador.ProductoController;
import vista.ConsolaUI;

public class Main {
    public static void main(String[] args) {
        ComercioController comercioController = new ComercioController();
        ProductoController productoController = new ProductoController();
        ArchivoController archivoController = new ArchivoController();

        ConsolaUI consola = new ConsolaUI(comercioController, productoController, archivoController);
        consola.mostrarMenu();
    }
}
