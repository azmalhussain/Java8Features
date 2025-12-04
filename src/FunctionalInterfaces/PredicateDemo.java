package FunctionalInterfaces;

import java.util.function.Predicate;

/*
Predicate<T>

Method: boolean test(T t)
Purpose: Tests a condition, returns true or false.
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7));  // false

        // Chaining: and(), or(), negate()
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println(isEven.and(isPositive).test(4));  // true
        System.out.println(isEven.and(isPositive).test(-2)); // false

        System.out.println(isEven.or(isPositive).test(-2)); // false

        System.out.println(isEven.negate().test(7));  // true
    }
}
