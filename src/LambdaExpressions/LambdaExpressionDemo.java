package LambdaExpressions;

import java.util.*;
import java.util.function.*;

public class LambdaExpressionDemo {
    public static void main(String[] args) {

        // Old Java
        Operation op = new Operation() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };
        int result = op.apply(10, 5);
        System.out.println("result: " + result);

        // Lambda expression
        Operation op1 = (a, b) -> a + b;
        int result1 = op1.apply(10, 5);
        System.out.println("result1: " + result1);
    }
}