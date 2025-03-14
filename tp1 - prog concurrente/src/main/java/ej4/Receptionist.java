package ej4;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Receptionist implements Callable<Integer > {
    private static final Integer AMOUNT_OF_CLIENTS = 100;
    private final IBranchClientQueueService clientService;
    public Receptionist(final IBranchClientQueueService clientService) {
        this.clientService = clientService;
    }
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < AMOUNT_OF_CLIENTS; i++) {
// simulate one client and enqueue
// sleep for a couple of random seconds.
            //creo un client con una prioridad aleatoria
            Client client = new Client("Cliente %d".formatted(i), ClientPriority.values()[ThreadLocalRandom.current().nextInt(0, 3)]);
            System.out.println("Receptionist #" + Thread.currentThread().getId() + ":Comenzando  " + client.toString() );
            //inserrto en queue
            clientService.receiveClient(client);
            System.out.println("Receptionist #" + Thread.currentThread().getId() + ":Despachado  " + client.toString() );
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000,5000));
        }
        return AMOUNT_OF_CLIENTS;
    }
}