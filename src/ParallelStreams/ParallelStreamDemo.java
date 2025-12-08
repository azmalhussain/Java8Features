package ParallelStreams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args) {

        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();

        long startTime = System.currentTimeMillis();
        List<Long> factorialsList = list.stream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        factorialsList = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + " ms");


        // Cumulative Sum
        // [1, 2, 3, 4, 5] --> [1, 3, 6, 10, 15]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15]");

        AtomicInteger sum = new AtomicInteger(0);  // shared mutable state
        List<Integer> parallelCumulativeSum = numbers.stream().parallel().map(sum::addAndGet).toList();
        System.out.println("Actual result with parallel stream: " + parallelCumulativeSum);

        final int[] s = {0};
        List<Integer> sequentialCumulativeSum = numbers.stream().map(x -> {
            x = s[0] + x; // 's' reference is still 'final', modifying content is allowed
            return s[0] = x;
        }).toList();
        System.out.println("Actual result with sequential stream: " + sequentialCumulativeSum);


        // Understand forEachOrdered()
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Using forEach (parallel stream):");
        num.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Using forEachOrdered (parallel stream):");
        num.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();

    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
