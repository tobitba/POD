import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ej5 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la ruta del directorio: ");
        Path initialPath = Paths.get(input.nextLine());
        ExecutorService executor = Executors.newCachedThreadPool();
        AtomicLong counter = new AtomicLong(0);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(initialPath)) {
            stream.forEach( path -> executor.submit(() -> {

                if(path.toFile().isFile()) {
                    try {
                        counter.getAndAdd(Files.lines(path).count());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }));
        } catch (Exception e) {
            //do something
        }


        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println(counter.get());
    }


    private static void viewDirectory(Path path, ExecutorService executor) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path archivo : stream) {
                File file =  archivo.toFile();
                if(file.isDirectory()){
                    System.out.printf("Directorio: %s%n", file.getName());
                }else {
                    System.out.printf("Archivo: %s%n", file.getName());
                }
            }
        } catch (Exception e) {
            System.err.print("Error al ver el Path");
        }
    }

}
