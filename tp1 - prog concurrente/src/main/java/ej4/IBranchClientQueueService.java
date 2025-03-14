package ej4;

public interface IBranchClientQueueService {
    void receiveClient(Client client);
    Client clientForPriority(ClientPriority priority);
}
