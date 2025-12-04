package MethodReferences;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ArbitraryObjectMethodRefDemo {
    public static void main(String[] args) {
//        Function<String, String> func = (s) -> s.toUpperCase();
        Function<String, String> func = String::toUpperCase;

//        BiFunction<String, String, Integer> biFunc = (a, b) -> a.indexOf(b);
        BiFunction<String, String, Integer> biFunc = String::indexOf;


        System.out.println(func.apply("azmal")); // AZMAL
        System.out.println(biFunc.apply("Hello World","Worl"));
    }
}
