package ej4;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Queue;

public class BranchClientQueueService implements IBranchClientQueueService{
    private final EnumMap<ClientPriority, Queue<Client>> clientQueues = new EnumMap<>(ClientPriority.class);  //TODO: ver porque enummap no castea a map
    //TODO: preguntar tema final

    public BranchClientQueueService() {
        for(ClientPriority priority : ClientPriority.values()) {
            clientQueues.put(priority, new LinkedList<>());
        }
    }



    @Override
    public void receiveClient(Client client) {
        synchronized (this) {
            clientQueues.get(client.priority()).add(client);
        }
    }

    @Override
    public Client clientForPriority(ClientPriority priority) {
        synchronized (this) {
            return clientQueues.get(priority).poll();
        }
    }
}
