package ej4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LocalBranch {
    private static Integer AMOUNT_OF_CLIENTS = 200;
    private static Integer AMOUNT_OF_RECEPTIONIST = 2;
    private static Integer AMOUNT_OF_ATTENDANTS_HIGH = 3;
    private static Integer AMOUNT_OF_ATTENDANTS_PRIORITY = 1;
    private static Integer AMOUNT_OF_ATTENDANTS_NORMAL = 2;


    private void shutdown(ExecutorService executor) throws InterruptedException {
        executor.shutdown();
        if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
            executor.shutdownNow();
        }
    }


    public static void main(String[] args) {
        ExecutorService receptionists = Executors.newFixedThreadPool(AMOUNT_OF_RECEPTIONIST);
        ExecutorService high = Executors.newFixedThreadPool(AMOUNT_OF_ATTENDANTS_HIGH);
        ExecutorService priority = Executors.newFixedThreadPool(AMOUNT_OF_ATTENDANTS_PRIORITY);
        ExecutorService normal = Executors.newFixedThreadPool(AMOUNT_OF_ATTENDANTS_NORMAL);
        IBranchClientQueueService service = new BranchClientQueueService();
        for (int i = 0; i < AMOUNT_OF_RECEPTIONIST; i++) {
            receptionists.submit(new Receptionist(service));
        }
        for (int i = 0; i < AMOUNT_OF_ATTENDANTS_HIGH; i++) {
            high.submit(new ClientAttendant(service,ClientPriority.HIGH));
        }
        for (int i = 0; i < AMOUNT_OF_ATTENDANTS_PRIORITY; i++) {
            priority.submit(new ClientAttendant(service,ClientPriority.PRIORITY));
        }
        for (int i = 0; i < AMOUNT_OF_ATTENDANTS_NORMAL; i++) {
            normal.submit(new ClientAttendant(service,ClientPriority.NORMAL));
        }



    }
}