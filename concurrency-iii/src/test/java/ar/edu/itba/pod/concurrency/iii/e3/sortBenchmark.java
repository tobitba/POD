package ar.edu.itba.pod.concurrency.iii.e3;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;


import org.junit.jupiter.api.Test;

/**
 * Benchmar to compare between {@link Arrays#parallelSort(int[])} and
 * {@link Arrays#sort(int[])}
 */
public class sortBenchmark {


    private static int[]  numbers(int tam, Random random) {
        final int[] array = new int[tam];
        for (int i = 0; i < tam; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    @Test
    public void benchmark_all() {
        int multiplier = 1000000;
        int[] first = numbers(10*multiplier, new Random());
        int[] second = numbers(25*multiplier, new Random());
        int[] third = numbers(50*multiplier, new Random());
        Consumer<int[]> consumer = Arrays::sort;
        Consumer<int[]> consumer2 = Arrays::parallelSort;
        benchmark(first,consumer,"first sort");
        benchmark(first,consumer2,"first par");
        benchmark(second,consumer,"sec sort");
        benchmark(second,consumer2,"sec par");
        benchmark(third,consumer,"third sort");
        benchmark(third,consumer2,"third par");

    }

    void benchmark(int[] array, final Consumer<int[]> order, String message) {
        long accumulator = 0;
        for (int i = 0; i < 4; i++) {
            int[] cp = Arrays.copyOf(array, array.length);
            long start = System.currentTimeMillis();
            order.accept(cp);
            long end = System.currentTimeMillis();
            accumulator += end - start;
        }
        System.out.println(message+" took "+ (accumulator/4));
    }
}
