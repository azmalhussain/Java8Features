package FunctionalInterfaces;

import java.util.function.UnaryOperator;

/*
UnaryOperator<T>

Method: T apply(T t)
Purpose: Takes a value and returns a value of the same type.
Special case of Function<T,T>
 */

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // 25
    }
}
