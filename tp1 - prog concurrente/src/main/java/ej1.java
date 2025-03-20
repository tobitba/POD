import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
*   RESPUESTA VERIFICADA POR CATEDRA
*   Se imprimen todas las permutaciones de A,B,1 y 2 posibles excepto las que tengan a B antes que A y/o 2 antes de 1
*   (es imposible que primero se imprima B antes que A)
* posibles combinaciones:
* AB12
* A12B
* 12AB
* A1B2
* ...
*
* */





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
