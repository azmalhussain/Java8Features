# Java Primitive Streams (IntStream, LongStream, DoubleStream)

Java provides three special stream types for working with primitive values efficiently:

```IntStream → for int```

```LongStream → for long```

```DoubleStream → for double```

These avoid boxing/unboxing and are faster than ```Stream<Integer>``` or ```Stream<Double>```.

---

## 1. IntStream

Creating IntStream

```java
IntStream s1 = IntStream.of(1, 2, 3, 4);
IntStream s2 = IntStream.range(1, 5);       // 1,2,3,4
IntStream s3 = IntStream.rangeClosed(1, 5); // 1,2,3,4,5
```

Common Operations

```java
int sum = IntStream.of(1, 2, 3).sum();
double avg = IntStream.of(1, 2, 3).average().getAsDouble();
int max = IntStream.of(1, 2, 3).max().getAsInt();
int min = IntStream.of(1, 2, 3).min().getAsInt();
long count = IntStream.of(1, 2, 3).count();
```

Converting to Object Stream

```java
List<Integer> list = IntStream.of(1, 2, 3)
        .boxed()
        .collect(Collectors.toList());

Integer[] arr = IntStream.of(1, 2, 3)
        .boxed()
        .toArray(Integer[]::new);
```

---

## 2. LongStream

```java
long total = LongStream.of(100L, 200L, 300L).sum();

boolean any = LongStream.range(1, 10).anyMatch(n -> n > 5);
```

---

## 3. DoubleStream

```
double avg = DoubleStream.of(2.5, 3.6, 7.0)
        .average()
        .getAsDouble();

DoubleStream.of(1.1, 2.2).map(d -> d *2).forEach(System.out::println);
```

## 4. Operations

#### Intermediate

```
filter()
map()
mapToObj() : Convert primitive → object stream.
mapToInt/mapToLong/mapToDouble : Convert between primitive types.
sorted()
distinct()
limit()
skip()
boxed() : Convert primitive → Stream<Integer>
```

#### Terminal

```
sum()
average()
min()
max()
count()
summaryStatistics()
forEach()
anyMatch()/allMatch()/noneMatch()
findFirst()/findAny()
reduce()
```
