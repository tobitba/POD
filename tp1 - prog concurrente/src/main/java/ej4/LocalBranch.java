package ej4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class LocalBranch {
    private static Integer AMOUNT_OF_CLIENTS = 200;
    private static Integer AMOUNT_OF_RECEPTIONIST = 2;
    private static Integer AMOUNT_OF_ATTENDANTS_HIGH = 3;
    private static Integer AMOUNT_OF_ATTENDANTS_PRIORITY = 1;
    private static Integer AMOUNT_OF_ATTENDANTS_NORMAL = 2;


    private static void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService receptionists = Executors.newFixedThreadPool(AMOUNT_OF_RECEPTIONIST);
        ExecutorService high = Executors.newFixedThreadPool(AMOUNT_OF_ATTENDANTS_HIGH);
        ExecutorService priority = Executors.newFixedThreadPool(AMOUNT_OF_ATTENDANTS_PRIORITY);
        ExecutorService normal = Executors.newFixedThreadPool(AMOUNT_OF_ATTENDANTS_NORMAL);
        List<Future<Integer>> attendants = new ArrayList<>();
        IBranchClientQueueService service = new BranchClientQueueService();
        for (int i = 0; i < AMOUNT_OF_RECEPTIONIST; i++) {
            receptionists.submit(new Receptionist(service));
        }
        for (int i = 0; i < AMOUNT_OF_ATTENDANTS_HIGH; i++) {
            attendants.add( high.submit(new ClientAttendant(service,ClientPriority.HIGH)));
        }
        for (int i = 0; i < AMOUNT_OF_ATTENDANTS_PRIORITY; i++) {
            attendants.add( priority.submit(new ClientAttendant(service,ClientPriority.PRIORITY)));
        }
        for (int i = 0; i < AMOUNT_OF_ATTENDANTS_NORMAL; i++) {
            attendants.add( normal.submit(new ClientAttendant(service,ClientPriority.NORMAL)));
        }

        for(Future<Integer> attendant : attendants){
            System.out.println(attendant.get());
        }

        shutdown(receptionists);
        shutdown(high);
        shutdown(priority);
        shutdown(normal);



    }
}