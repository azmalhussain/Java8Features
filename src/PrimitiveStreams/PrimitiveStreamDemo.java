package PrimitiveStreams;

import java.util.*;
import java.util.stream.*;

public class PrimitiveStreamDemo {

    public static void main(String[] args) {

        IntStream numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // -------------------
        // INTERMEDIATE OPS
        // -------------------

        // 1. filter()
        IntStream filtered = numbers.filter(n -> n > 10);

        // Create a fresh stream (because streams can't be reused)
        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 2. map()
        IntStream mapped = numbers.map(n -> n * 2);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 3. sorted()
        IntStream sorted = numbers.sorted();

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 4. distinct()
        IntStream distinct = numbers.distinct();

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 5. limit() and skip()
        IntStream limited = numbers.limit(3);     // first 3
        IntStream skipped = numbers.skip(2);      // skip first 2

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 6. boxed()   (convert primitive → object stream)
        Stream<Integer> boxed = numbers.boxed();

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 7. mapToObj() (primitive → object)
        Stream<String> mappedToObj = numbers.mapToObj(n -> "Num: " + n);


        // -------------------
        // TERMINAL OPS
        // -------------------

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 1. sum()
        int sum = numbers.sum();
        System.out.println("Sum: " + sum);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 2. average()
        double avg = numbers.average().orElse(0);
        System.out.println("Average: " + avg);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 3. min() and max()
        int min = numbers.min().orElse(-1);
        System.out.println("Min: " + min);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);
        int max = numbers.max().orElse(-1);
        System.out.println("Max: " + max);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 4. count()
        long count = numbers.count();
        System.out.println("Count: " + count);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 5. summaryStatistics()
        IntSummaryStatistics stats = numbers.summaryStatistics();
        System.out.println("Stats: " + stats);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 6. forEach()
        System.out.print("ForEach: ");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 7. anyMatch() / allMatch() / noneMatch()
        boolean anyAbove25 = numbers.anyMatch(n -> n > 25);
        System.out.println("Any > 25: " + anyAbove25);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);
        boolean allAbove2 = numbers.allMatch(n -> n > 2);
        System.out.println("All > 2: " + allAbove2);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);
        boolean noneNegative = numbers.noneMatch(n -> n < 0);
        System.out.println("None < 0: " + noneNegative);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 8. findFirst() / findAny()
        int first = numbers.findFirst().orElse(-1);
        System.out.println("First: " + first);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);
        int any = numbers.findAny().orElse(-1);
        System.out.println("Any: " + any);

        numbers = IntStream.of(5, 10, 20, 10, 30, 40);

        // 9. reduce()
        int reduced = numbers.reduce(0, (a, b) -> a + b);  // sum using reduce
        System.out.println("Reduced Sum: " + reduced);
    }
}

