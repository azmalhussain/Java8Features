package FunctionalInterfaces;

import java.util.function.Consumer;

/*
Consumer<T>

Method: void accept(T t)
Purpose: Performs an action with input but returns nothing.
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> greet = name -> System.out.println("Hello " + name);
        greet.accept("Azmal");

        // Chaining: andThen()
        Consumer<String> shout = name -> System.out.println(name.toUpperCase());

        greet.andThen(shout).accept("Azmal");
    }
}
