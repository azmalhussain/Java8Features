package FunctionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/*
BinaryOperator<T>

Method: T apply(T t1, T t2)
Purpose: Takes two values of same type, returns same type.
Special case of BiFunction<T,T,T>
 */
public class BinaryOperatorDemo {
    public static void main(String[] args) {
        // apply(): main method (inherited from BiFunction)
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("apply(): " + add.apply(5, 3)); // 8

        // maxBy(): returns larger value based on comparator
        BinaryOperator<Integer> maxOp = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println("maxBy(): " + maxOp.apply(10, 20)); // 20

        // minBy(): returns smaller value based on comparator
        BinaryOperator<Integer> minOp = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println("minBy(): " + minOp.apply(10, 20)); // 10
    }
}
