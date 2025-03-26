import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class pruebaFuture {
    private static int MAX_FIBONACCI = 92;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_FIBONACCI/2 + 1); //TODO: porque pide try with resource

        List<Future<result>> futures = IntStream
                .range(0, MAX_FIBONACCI)
                .mapToObj(number -> executor.submit(new prueba(number)))
                .toList();   //TODO: eficiencia?
        for(Future<result> future : futures) {
            result resultado = future.get(); //TODO: como úedo hacer si quiero recuperar el primero que termina y no ir en orden de insert en la lista
            System.out.printf("fibo(%d) = %d%n", resultado.n(), resultado.result());
        }

        executor.shutdown();
        if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
            executor.shutdownNow();
        }

    }




}
