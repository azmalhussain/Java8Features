package FunctionalInterfaces;

import java.util.function.BiConsumer;

/*
BiConsumer<T,U>

Method: void accept(T t, U u)
Purpose: Takes 2 inputs, returns nothing.
 */
public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printNameAndAge = (name, age) -> System.out.println(name + " is " + age + " years old");
        printNameAndAge.accept("Azmal", 26); // Azmal is 26 years old
    }
}
