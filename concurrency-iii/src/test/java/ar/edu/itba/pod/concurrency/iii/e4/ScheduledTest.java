package ar.edu.itba.pod.concurrency.iii.e4;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.*;


public class ScheduledTest {

    private Runnable printTimestamp = () -> System.out.println(new Date());
    private static class Stop implements Runnable {
        ScheduledFuture<?> future;
        public Stop(ScheduledFuture<?> future) {this.future = future;}
        @Override
        public void run() {
            future.cancel(true);
        }
    }

    @Test
    public final void test() throws InterruptedException, ExecutionException {
        final ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();
        try {
            ScheduledFuture<?> future = executorService.scheduleWithFixedDelay(printTimestamp, 0, 10, TimeUnit.SECONDS);
            executorService.schedule(new Stop(future), 60, TimeUnit.SECONDS);
        } finally {
            Thread.sleep(100000);
            executorService.shutdown();
            executorService.awaitTermination(2, TimeUnit.SECONDS);
            executorService.shutdownNow();
        }
    }
}
