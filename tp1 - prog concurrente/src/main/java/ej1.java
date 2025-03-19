import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ej1 {
    public static class T1 implements Runnable {
        @Override
        public void run() {
            System.out.print("A");
            System.out.print("B");
        }
    }
    public static class T2 implements Runnable {
        @Override
        public void run() {
            System.out.print("1");
            System.out.print("2");
        }
    }
    public static void main(final String[] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        try {
            pool.execute(new T1());
            pool.execute(new T2());
            pool.shutdown();
            if (!pool.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
    }
}
//todo: PREGUNTAR SI ESTA BIEN
/*
AB12
12AB
A12B
1A2B
...



 */