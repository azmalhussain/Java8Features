package FunctionalInterfaces;

import java.util.function.Function;

/*
Function<T,R>

Method: R apply(T t)
Purpose: Transforms an input of type T into output of type R.
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, String> intToString = x -> x.toString();

        // Chaining: andThen(), compose()
        // andThen applies the first function, then passes result to second
        int resultAndThen = stringLength.andThen(square).apply("Azmal");
        System.out.println("andThen result: " + resultAndThen); // 25

        // compose applies intToString first, then stringLength
        int resultCompose = stringLength.compose(intToString).apply(12345);
        System.out.println("compose result: " + resultCompose); // 5

        // Using identity(): function that always returns its input argument.
        Function<String, String> identity = Function.identity();
        String res = identity.apply("Azmal Hussain");
        System.out.println(res);
    }
}
