package ar.edu.itba.pod.concurrency.exercises.e2;

import ar.edu.itba.pod.concurrency.exercises.e1.GenericService;
import ar.edu.itba.pod.concurrency.exercises.e1.GenericServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThreadTest {
    private GenericService service;
    private final static int VISIT_COUNT = 5;

    @BeforeEach
    public final void before() {
        service = new GenericServiceImpl();
    }

    @Test
    public final void test() throws InterruptedException {
        Thread thread_1 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < VISIT_COUNT; i++){
                    service.addVisit();
                }
                System.out.println(service.getVisitCount());
            }
        };
        thread_1.start();
        thread_1.join();
        assertEquals(VISIT_COUNT, service.getVisitCount());

    }

    @Test
    public final void test2() throws InterruptedException {
        Thread thread_1 = new Thread(() -> {
            for(int i = 0; i < VISIT_COUNT; i++){
                service.addVisit();
            }
            System.out.println(service.getVisitCount());
        });
        thread_1.start();
        thread_1.join();
        assertEquals(VISIT_COUNT, service.getVisitCount());
    }

}
