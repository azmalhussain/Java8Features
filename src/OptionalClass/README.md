# Optional in Java

## 1. What is Optional?

Optional is a container object that may or may not contain a non-null value.
Its main purpose is to avoid **NullPointerException**.

Use it mainly as **method return type.**

---

## 2. How to Create Optional?

#### 2.1 Optional.empty()

Creates an empty Optional.

```
Optional<String> op = Optional.empty();
```

#### 2.2 Optional.of(value)

Value must NOT be null.

```
Optional<String> op = Optional.of("Hello");   // OK
Optional<String> op2 = Optional.of(null);     // throws NPE
```

#### 2.3 Optional.ofNullable(value)

Accepts null safely.

```Optional<String> op = Optional.ofNullable(name);```

---

## 3. Important Optional Methods

#### 3.1 isPresent() / isEmpty()
```
if (op.isPresent()) {
    System.out.println(op.get());
}
```

#### 3.2 get()

Returns the value (avoid if possible).

```
op.get();
```

#### 3.3 orElse(defaultValue)

Returns default if value is null.

```
String result = Optional.ofNullable(name).orElse("Default Name");
```

#### 3.4 orElseGet(Supplier)

Lazy default value.

```
String result = Optional.ofNullable(name).orElseGet(() -> "Generated Default");
```

#### 3.5 orElseThrow()

Throws custom exception if empty.

```
String result = Optional.ofNullable(name).orElseThrow(() -> new RuntimeException("Missing"));
```

#### 3.6 ifPresent(Consumer)
```
Optional.of("Hello").ifPresent(v -> System.out.println(v));
```

#### 3.7 ifPresentOrElse()
```
Optional.ofNullable(name)
    .ifPresentOrElse(
        v -> System.out.println("Name: " + v),
        () -> System.out.println("Not found")
    );
```