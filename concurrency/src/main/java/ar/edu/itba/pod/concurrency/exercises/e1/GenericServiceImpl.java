package ar.edu.itba.pod.concurrency.exercises.e1;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Basic implementation of {@link GenericService}.
 */
public class GenericServiceImpl implements GenericService {

    private int visits = 0;

    @Override
    public String echo(String message) {
        return message;
    }

    @Override
    public String toUpper(String message) {
        return Optional.ofNullable(message).map(String::toUpperCase).orElse(message);
    }

    @Override
    public void addVisit() {
        visits++;
    }

    @Override
    public int getVisitCount() {
        return visits;
    }

    Queue<String> queue = new LinkedList<>();

    @Override
    public boolean isServiceQueueEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void addToServiceQueue(String name) {
        queue.add(Optional.ofNullable(name).orElseThrow(NullPointerException::new));
    }

    @Override
    public String getFirstInServiceQueue() {
        return Optional.ofNullable(queue.poll()).orElseThrow(() -> new IllegalStateException("No one in queue"));
    }
}
