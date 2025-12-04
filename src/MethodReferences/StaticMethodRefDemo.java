package MethodReferences;

import java.util.function.Function;

public class StaticMethodRefDemo {
    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> func = StaticMethodRefDemo::square;

        System.out.println(func.apply(5)); // 25
    }
}
