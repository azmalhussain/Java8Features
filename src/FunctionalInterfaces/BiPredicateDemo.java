package FunctionalInterfaces;

import java.util.function.BiPredicate;

/*
BiPredicate<T,U>

Method: boolean test(T t, U u)
Purpose: Takes 2 inputs, returns boolean.
 */
public class BiPredicateDemo {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isSumGreater = (a, b) -> (a + b) > 10;
        System.out.println(isSumGreater.test(4, 7)); // true
        System.out.println(isSumGreater.test(3, 5)); // false
    }
}
