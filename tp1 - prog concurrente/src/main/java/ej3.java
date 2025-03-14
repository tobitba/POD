import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ej3 {
    private static final Logger logger =            LoggerFactory.getLogger(ej3.class);
    private static final int THREAD_COUNT = 4;
    private static final Function<Integer, Callable<Void>> runner
            = (Integer index) -> () -> {
        logger.info("Starting runner: {}", index);
        Thread.sleep(1500);
       logger.info("Ending runner: {}", index);
        return null;
    };
    public static void execute(ExecutorService pool) {
        try {
            List<Future<Void>> futures = IntStream.range(0,
                    THREAD_COUNT).mapToObj(index ->
                    pool.submit(runner.apply(index))).toList();
            for (Future<Void> future : futures) {
                future.get();
            }
            pool.shutdown();
            if (!pool.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException | ExecutionException e) {
            pool.shutdownNow();
        }
    }
    public static void main(String[] args) {
        logger.info("Cached Thread Pool");
        execute(Executors.newCachedThreadPool());
        logger.info("Fixed Thread Pool");
        execute(Executors.newFixedThreadPool(2));
        logger.info("Single Thread Executor");
        execute(Executors.newSingleThreadExecutor());
        logger.info("Single Thread Executor but rejecting");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.AbortPolicy());
        execute(executor);    //TODO: QUE HACE ESTE ULTIMO Y PORQUE ME RECHAZA
    }
}
