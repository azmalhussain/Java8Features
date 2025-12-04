# Lambda Expressions in Java

## 1. What is a Lambda Expression?

A **lambda expression** is a short, inline way to write a function.  
It has **no name** and can be assigned to a variable.

**Basic form:**

```
(parameters) -> expression
```

---

## 2. Important Rule

A lambda expression can be used **only with a Functional Interface**.

A **Functional Interface** is an interface that has **exactly one abstract method** (Single Abstract Method / SAM).

**Example:**

```java

@FunctionalInterface
interface Operation {
    int apply(int a, int b);
}
```

**Old Java (Anonymous Inner Class):**

```java
Operation op = new Operation() {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
};
int result = op.apply(10, 5);
```

**Using Lambda:**

```java
Operation op = (a, b) -> a + b;
int result = op.apply(10, 5);
```

---

## 3. Lambda Syntax Variations

**Full form**
```(int x, int y) -> { return x + y; }```

**Type inference**
```(x, y) -> { return x + y; }```

**Single-line expression (no return needed)**
```(x, y) -> x + y```

**One parameter (parentheses optional)**
```n -> n * 2```

**No parameters**
```() -> System.out.println("Hello")```