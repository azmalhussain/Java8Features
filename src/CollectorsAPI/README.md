# Collectors in Stream API (Terminal Operation collect())

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

Creates a Map from the stream. **Keys** should be unique.

```java
Map<Integer, String> map = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));
```

When duplicate keys present, we need to specify **mergeFunction**.

```java
Map<String, Integer> nameToMarks = students.stream()
        .collect(Collectors.toMap(
                Student::getName,
                Student::getMarks,
                (oldVal, newVal) -> newVal      // keep latest OR any other operation
        ));
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

#### 2.7.1  groupingBy(keyExtractor)

```    
Map<String, List<Student>> group = students.stream()
        .collect(Collectors.groupingBy(Student::getDepartment));
        

Output: Department-wise students list
```

#### 2.7.2  groupingBy(keyExtractor, downstream collector)

```    
Map<String, Long> countByDept =
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.counting()
                ));
        

Output: Department-wise Count Students 
```

**Collectors.mapping()** basically extracts or transforms something from each element, inside another collector like
groupingBy, partitioningBy, toSet, etc.

```
Collectors.mapping(mapperFunction, downstreamCollector)
```

```
Map<String, List<String>> deptToNames = students.stream()
        .collect(
                Collectors.groupingBy(
                        Student::getDepartment,
                        Collectors.mapping(Student::getName, Collectors.toList())
                )
        );


Output: 
- List of names per department (mapping())
- Inside each group, instead of collecting whole Student objects 'mapping()' extracts only the names
- And finally makes a list of names for each department
```

#### 2.7.3  groupingBy(keyExtractor, Supplier<Map>, downstream)

```java
Map<String, List<Student>> sortedDept =
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getDepartment,
                        TreeMap::new,
                        Collectors.toList()
                ));
```

Output: Keys department-wise sorted.

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
System.out.println(stats.getAverage()); // avg marks
```

### 2.10 Collectors.toCollection()

It allows you to specify the type of 'collection' you want to collect the stream elements into:

```
- ArrayList 
- LinkedList
- TreeSet 
- HashSet

Note:
It cannot be used directly to collect into a 'Map', because Map is not a Collection - it is a separate interface.
```

Example:

```java
List<Integer> list = Stream.of(1, 2, 3, 4)
        .collect(Collectors.toCollection(LinkedList::new));

Queue<String> queue = Stream.of("a", "b", "c")
        .collect(Collectors.toCollection(ArrayDeque::new));
```