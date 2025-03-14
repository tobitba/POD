package ej4;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientAttendant implements Callable<Integer > {
    private final IBranchClientQueueService clientService;
    private final ClientPriority priority;
    public ClientAttendant(IBranchClientQueueService clientService,
                           ClientPriority priority) {
        this.clientService = clientService;
        this.priority = priority;
    }
    @Override
    public Integer call() throws Exception {
        //boolean stillWorking = true;
        AtomicInteger clientsServed = new AtomicInteger();
        AtomicInteger cyclesWithNoClients = new AtomicInteger();
        while (/*stillWorking && */cyclesWithNoClients.get() < 6546868) { //if 3 cycles with no client end.
//get one client and sleep for random amount of seconds to
            //simulate service time
// or if no client sleep to simulate waiting time.
            Optional.ofNullable(clientService.clientForPriority(priority)).ifPresentOrElse( client -> {
                System.out.println("Attendant #" + Thread.currentThread().threadId() + "prioridad" + priority + ":Atendiendo  " + client.toString() + "priority" + client.priority());
                clientsServed.getAndIncrement();
                System.out.println("Attendant #" + Thread.currentThread().getId() + ":Despachado  " + client.toString() + "priority" + client.priority());
                cyclesWithNoClients.set(0);
                } , cyclesWithNoClients::getAndIncrement);
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
        }
        return clientsServed.get(); // how many clients
    }
}