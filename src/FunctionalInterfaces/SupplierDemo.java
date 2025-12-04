package FunctionalInterfaces;

import java.util.function.Supplier;

/*
Supplier<T>

Method: T get()
Purpose: Supplies a value, takes no input.
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println(randomNumber.get());

        Supplier<String> helloSupplier = () -> "Hello World!";
        System.out.println(helloSupplier.get());
    }
}
