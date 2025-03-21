import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class pruebaFuture {
    private static int MAX_FIBONACCI = 92;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_FIBONACCI/2 + 1);

        List<Future<result>> futures = IntStream
                .range(0, MAX_FIBONACCI)
                .mapToObj(number -> executor.submit(new prueba(number)))
                .toList();
        for(Future<result> future : futures) {
            result resultado = future.get();
            System.out.printf("fibo(%d) = %d%n", resultado.n(), resultado.result());
        }

        executor.shutdown();
        if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
            executor.shutdownNow();
        }

    }




}
