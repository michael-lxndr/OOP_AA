package controlador;

import modelo.Producto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

public class ArchivoController {

    public void cargarDesdeCSV(String path, List<Producto> productos) {
        try {
            if (path == null || path.isBlank()) {
                // Detectar la carpeta desde donde se ejecuta el Main
                String basePath = Paths.get(ArchivoController.class.getProtectionDomain()
                        .getCodeSource().getLocation().toURI()).getParent().getParent().getParent().toString();

                path = basePath + File.separator + "src" + File.separator + "productos.csv";
                System.out.println("ℹ️ Usando ruta desde src: " + path);
            }

            File archivo = new File(path);
            if (!archivo.exists()) {
                System.out.println("❌ Archivo no encontrado: " + archivo.getAbsolutePath());
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                boolean primera = true;

                while ((linea = br.readLine()) != null) {
                    if (primera) {
                        primera = false; // ignorar encabezado
                        continue;
                    }

                    String[] datos = linea.split(",");
                    if (datos.length != 5) {
                        System.out.println("❗ Línea inválida: " + linea);
                        continue;
                    }

                    int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    double pvp = Double.parseDouble(datos[2].trim());
                    double costo = Double.parseDouble(datos[3].trim());
                    int stock = Integer.parseInt(datos[4].trim());

                    productos.add(new Producto(id, nombre, pvp, costo, stock));
                }

                System.out.println("✅ Productos cargados correctamente.");

            }

        } catch (IOException | NumberFormatException | URISyntaxException e) {
            System.out.println("❌ Error al procesar el archivo: " + e.getMessage());
        }
    }
}
