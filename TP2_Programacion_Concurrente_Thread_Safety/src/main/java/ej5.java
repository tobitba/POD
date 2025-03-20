import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/*
   CORRECION CATEDRA:
   esta bien perooo el que esta en las soluciones en campus es mejor porque al usar los resultados de los Future con .get
   el thread principal es el unico que hace la suma en la variable final. En mi version al usar el AtomicLong todos los threads van a querer
   acceder a esa variable lo que hace que este programa se bloquee mas que el de la catedra, ya que al usar Futures cada thread corre, genera
   su resultado y listo, el unico thread que se bloquea (sin contar bloqueos del so y demas) es el principal al esperar a que termine cada thread
*
*  */


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



}
