package ar.edu.itba.pod.concurrency.exercises.e3;

import ar.edu.itba.pod.concurrency.exercises.e1.GenericService;
import ar.edu.itba.pod.concurrency.exercises.e1.GenericServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutorTest {
    private GenericService service;
    private static final int  COUNT = 5;

    @BeforeEach
    public final void before() {
        service = new GenericServiceImpl();
    }

    @Test
    public final void test() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> result = pool.submit((Callable<Integer>) () -> {
            for(int i = 0; i < COUNT; i++) {service.addVisit();}
            System.out.println("estoy en thread!!");
            return service.getVisitCount();
        });
        System.out.println("estoy en afuera!!");
        assertEquals(COUNT, result.get());
    }
}
