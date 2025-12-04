package FunctionalInterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
BiFunction<T,U,R>

Method: R apply(T t, U u)
Purpose: Takes 2 inputs, returns a result.
*/
public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(5, 3)); // 15

        Function<Integer, String> convertToString = result -> "Result is: " + result;

        // Using andThen()
        var finalResult = multiply.andThen(convertToString).apply(5,3);
        System.out.println(finalResult); // "Result is: 15"
    }
}
