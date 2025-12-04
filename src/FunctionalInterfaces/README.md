# Functional Interface in Java

## 1. What is a Functional Interface?

A **Functional Interface (FI)** is an interface with exactly one abstract method (also called a SAM – Single Abstract Method). 

*It can have **default** and **static** methods.*

*Lambdas in Java can only implement functional interfaces.*

**Syntax:**

```java
@FunctionalInterface
interface MyFunction {
    // Single abstract method
    void execute();

    // Default method
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }

    // Static method
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        MyFunction myFunc = () -> System.out.println("Executing the abstract method!");
        
        myFunc.execute();          // calls the abstract method
        myFunc.defaultMethod();    // calls default method
        
        MyFunction.staticMethod(); // calls static method
    }
}

✅ @FunctionalInterface annotation is optional but recommended.
❌ Compilation error if more than one abstract method exists.
```

---

## 2. Predefined Functional Interfaces in Java 8

Java 8 provides many **built-in functional interfaces** in **java.util.function** package:

![Predefined Functional Interfaces in Java 8](src/FunctionalInterfaces/Predefined Functional Interfaces.jpg)
