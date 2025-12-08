# What Are Parallel Streams?

A **parallel stream** splits the data into **multiple chunks** and processes them **simultaneously on different CPU
cores**.

## 1. How to Create a Parallel Stream?

There are two ways:

From an existing stream:

```list.stream().parallel()```

Directly:

```list.parallelStream()```

--- 

## 2. When to Use Parallel Streams?

Use when:

```
✔ The task is CPU heavy
✔ The dataset is large (10,000 – millions)
✔ The operations are independent (no shared state)
✔ The task is pure computation (not I/O)
```

---

## 3. Maintaining Order in Parallel Stream

Use **forEachOrdered()**:

```
list.parallelStream().forEachOrdered(System.out::println);
```

This gives the same order as input.