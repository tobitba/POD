
import java.io.File;
import java.nio.file.*;


/***
 * Simple class to test File methods to access directories and files
 */
public class FilesTest {
    private static void directory(Path path){
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path archivo : stream) {
                File file =  archivo.toFile();
                if(file.isDirectory()){
                    System.out.printf("Directorio: %s%n", file.getName());
                    directory(archivo);
                }else {
                    System.out.printf("Archivo: %s%n", file.getName());
                }
            }
        } catch (Exception e) {
            System.err.print("Error al ver el Path");
        }
    }

    public static void main(String[] args) {
        Path ruta = Paths.get("/home/tobias/Documentos/pod"); // Cambia la ruta
        directory(ruta);

    }
}
