# Collectors in Stream API (Terminal Operation)

## 1. What are Collectors?

**Collectors** is a **utility class** that contains many ready-made methods to convert a stream into a final result.

Each method returns a **Collector** object, which we pass to collect().

Collectors basically define **how the stream's elements should be combined.**

```declarative
collect() = "Combine all stream elements into a final container using a Collector"
```

---

## 2. Most Common Collectors

### 2.1 Collectors.toList()

Converts a stream into a List.

```java
List<Integer> list = numbers.stream().collect(Collectors.toList());
```

### 2.2 Collectors.toSet()

Converts a stream into a Set (removes duplicates).

```java
Set<String> set = names.stream().collect(Collectors.toSet());
```

### 2.3 Collectors.toMap()

Creates a Map from the stream.

```java
Map<Integer, String> map = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));

Method reference
is used:
For every 'Student'
object in
the stream,
Student::getId ==>(student)->student.

getId()
```

### 2.4 Collectors.joining()

Joins strings together.

```java
String s = names.stream().collect(Collectors.joining(", "));
```

### 2.5 Collectors.counting()

Counts the number of elements.

```java
long count = items.stream().collect(Collectors.counting());
```

### 2.6 Collectors.summingInt(), averagingInt()

Gets sum or average of numeric values.

```java
int sum = numbers.stream().collect(Collectors.summingInt(n -> n));
```

### 2.7 Collectors.groupingBy()

Groups the data based on a key — one of the most powerful collectors.

```java
Map<String, List<Student>> group = students.stream()
        .collect(Collectors.groupingBy(Student::getDepartment));
```

### 2.7.1 Collectors.mapping()

Collectors.mapping() is used inside another collector (like groupingBy, toSet, etc.)

Its job is:

```Convert each element into something else, then collect them using another collector (like toList, toSet, averagingDouble, etc.)```

Think of it as a pre-processing step before the final collection.

```java
Map<String, List<String>> deptToNames = students.stream()
        .collect(
                Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.mapping(Student::getName, Collectors.toList())
                )
        );
```

**✔ What happens here?**

```
First we group students by department
Inside each group, instead of collecting whole Student objects
'mapping()' extracts only the names
And finally makes a list of names for each department
```

Without mapping()~~,~~ groupingBy would give:
```Map<String, List<Student>>```

With mapping(), we get:
```Map<String, List<String>>```

### 2.8 Collectors.partitioningBy()

Separates data into two groups based on a boolean condition.

```java
Map<Boolean, List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
```

### 2.9 Collectors.summarizingInt()

**Collectors.summarizingInt()** takes an int-producing function (like Student::getMarks) and returns an object of type
IntSummaryStatistics.

This object automatically calculates:

```
count → total number of items
sum → total marks
min → minimum marks
max → maximum marks
average → average marks
```

Example:

```
IntSummaryStatistics stats = students.stream()
.collect(Collectors.summarizingInt(Student::getMarks));

System.out.println(stats.getCount());   // total number of students
System.out.println(stats.getSum());     // total marks
System.out.println(stats.getMin());     // lowest marks
System.out.println(stats.getMax());     // highest marks
System.out.println(stats.getAverage()); // avg marks```