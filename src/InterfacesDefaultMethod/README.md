# Java Interface Default Methods

## 1. What is a Default Method?

A default method in an interface is a method that has a body, defined using the default keyword.

```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting...");
    }
}
```

---

## 2. Why Were Default Methods Introduced?

Default methods were added in Java 8 to allow:

Adding new methods to interfaces without breaking existing implementations.

Supporting new features like Stream API, functional programming, etc.

---

## 3. How Default Methods Work

If a class implements an interface with a default method, it automatically inherits it.

```java
class Car implements Vehicle { }

new Car().start();   // Uses the default implementation
```

---

## 4. Overriding a Default Method

A class can override a default method just like normal methods.

```java
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starts differently!");
    }
}
```

---

## 5. Multiple Interface Conflict (Diamond Problem)

If two interfaces define the same default method, the implementing class must override it.

```java
interface A { default void show() { System.out.println("A"); } }
interface B { default void show() { System.out.println("B"); } }

class C implements A, B {
    @Override
    public void show() {
        A.super.show(); // or B.super.show()
    }
}
```
