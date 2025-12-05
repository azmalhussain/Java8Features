# Stream APIs in Java

## 1. What is the Stream API?

API = Application Programming Interface
(a group of classes + interfaces + methods that let you perform specific operations)

Stream API (introduced in Java 8) is a **powerful way to process data** using **pipelines**.

It lets you perform operations like:

```
filtering
mapping
sorting
reducing
```

**without writing loops.**

---

## 2. Why is it called "Stream"?

Because it treats data as a **flow of elements** moving through a pipeline.

```declarative
NOT a collection.
NOT stored.
Just flowing from start → end.
```

#### Note:

Collection **stores** data.

Stream **processes** data.

---

## 3. Stream Pipeline Structure

A Stream pipeline has 3 stages:

#### 1. Source

Where data comes from i.e. Stream creation

```declarative
Object Streams (Collection based)
- list.stream()
- set.stream()
- Stream.of()

Array-based Streams
- Arrays.stream()

Primitive Streams
- IntStream.range()
- LongStream.of()
- DoubleStream.of()

Infinite Streams
- Stream.generate()
- Stream.iterate()

Get Stream from String literal
- s.chars()
```

#### 2. Intermediate operations

These transform / filter data

```declarative
map()
filter()
sorted()
distinct()
limit()
skip()
flatMap()

(All lazy: they don’t run immediately.)
```

#### 3. Terminal operation

This executes the pipeline

```declarative
forEach()
collect()
reduce()
count()
min()
max()
toList()
toSet()

anyMatch()
allMatch()
noneMatch()
findFirst()
findAny()
```

**Once terminal runs → Stream is consumed.**

---

## 4. Important Concepts

#### Streams are immutable

They do NOT change the original list.

#### Streams are one-time use

You cannot reuse a Stream after a terminal operation.

#### Operations are lazy

Nothing runs until a terminal operation is called.

---

## 5. Stateless vs Stateful Operations

#### 1. Stateless Operations
Operations that do NOT depend on the previous or next elements in the stream.
Each element is processed independently, without storing any state.
```declarative
Characteristics
- No memory is required.
- Processing is per-element.
- Safe for parallel execution.
- Fast and lightweight.

Examples
- map()
- filter()
- flatMap()
- peek()
```

#### 2. Stateful Operations
Operations that require knowledge of multiple elements to produce the result.
They must store state (keep memory) while processing.
```declarative
Characteristics
- Need memory or internal buffering.
- Cannot output result until they have seen more(or all) elements.
- Slower compared to stateless operations.
- Some are intermediate, some are terminal.

Examples
- sorted() → needs all elements to sort
- distinct() → must remember seen elements
- limit() → counts elements
- skip() → also counts elements
```