package MethodReferences;

import java.util.function.Supplier;

public class InstanceMethodRefDemo {
    public String getMessage() {
        return "Hello, Azmal!";
    }

    public static void main(String[] args) {
        InstanceMethodRefDemo obj = new InstanceMethodRefDemo();

        Supplier<String> supplier = obj::getMessage;

        System.out.println(supplier.get()); // Hello, Azmal!
    }
}
