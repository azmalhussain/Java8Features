# Method References in Java

## 1. What are Method References?

A **method reference** is a shorthand for a lambda expression that **calls an existing method**.

**Instead of writing:**

```java
str -> System.out.println(str)
```

**You can write:**

```java
System.out::println
```

It makes code more concise and readable.

---

## 2. Types of Method References

Java provides **4 types**:

2.1 **Reference to a static method**

```java
ClassName::staticMethod
```

2.2 **Reference to an instance method of a particular object**

```java
object::instanceMethod
```

2.3 **[IMPORTANT] Reference to an instance method of any object of a specific type**

```java
ClassName::instanceMethod
```
```       
Function<String, String> func = (s) -> s.toUpperCase();
Function<String, String> func = String::toUpperCase;

BiFunction<String, String, Integer> biFunc = (a, b) -> a.indexOf(b);
BiFunction<String, String, Integer> biFunc = String::indexOf;

👉 The first parameter of the functional interface becomes the object
👉 Second parameter becomes the argument to the method
```

2.4 **Reference to a constructor**

```java
ClassName::new
```

---

## 3. Rule for Method Reference Matching

A **method reference** works only if Java can call that **method** using the **functional interface’s method** signature.

i.e. The method should fit the *functional interface's* **parameters** and **return** type

Parameters match ✔

Return type matches ✔


---

