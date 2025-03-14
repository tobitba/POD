public class ej2 {
    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";
        Thread thread = new Thread(() -> {
            System.out.printf("Hello!, my state is %s%n",
                    Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
                synchronized (lock) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("Thread state: %s%n", thread.getState());
        thread.start();
        Thread.sleep(500);
        System.out.printf("Thread state: %s%n", thread.getState());
        Thread.sleep(2000);
        System.out.printf("Thread state: %s%n", thread.getState());
        synchronized (lock) {
            lock.notifyAll(); //TODO: PORQUE PUEDO ENTRAR ACA, SI EL LOCK LO TIENE EL OTRO THREAD ______________________________________________________________________
        }
        thread.join();
        System.out.printf("Thread state: %s%n", thread.getState());
    }
}