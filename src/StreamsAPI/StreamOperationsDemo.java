package StreamsAPI;

import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;
import java.io.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private int salary;
    private List<String> skills;

    public Employee(int id, String name, String department, int salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + department + ") Salary=" + salary;
    }
}

public class StreamOperationsDemo {

    public static void main(String[] args) throws Exception {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 85000, Arrays.asList("Java", "Spring")),
                new Employee(2, "Bob", "HR", 55000, Arrays.asList("Communication")),
                new Employee(3, "Charlie", "IT", 95000, Arrays.asList("Java", "AWS", "Docker")),
                new Employee(4, "David", "Finance", 65000, Arrays.asList("Excel", "Reporting")),
                new Employee(5, "Eve", "IT", 45000, Arrays.asList("HTML", "CSS"))
        );

        // --------------------------------------------------------
        // 1️⃣ STREAM SOURCES
        // --------------------------------------------------------

        Stream<Employee> stream1 = employees.stream();                  // Collection Source
        Stream<String> stream2 = Stream.of("A", "B", "C");               // Stream.of()
        IntStream stream3 = IntStream.range(1, 5);                       // Numeric Stream
//        Stream<String> stream4 = Files.lines(new File("test.txt").toPath());  // File source (example)

        // (We will use these concepts in real processing below)

        // --------------------------------------------------------
        // 2️⃣ INTERMEDIATE OPERATIONS
        // ↓ Each returns a new Stream
        // --------------------------------------------------------

        System.out.println("\n=== Filter: Employees with salary > 60000 ===");
        employees.stream()
                .filter(e -> e.getSalary() > 60000)
                .forEach(System.out::println);

        System.out.println("\n=== Map: Only Employee names ===");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\n=== FlatMap: All skills (flattened) ===");
        employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .forEach(System.out::println);

        System.out.println("\n=== Sorted: By salary descending ===");
        employees.stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(System.out::println);

        System.out.println("\n=== Distinct: Unique skills ===");
        employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n=== Limit & Skip ===");
        employees.stream().skip(1).limit(3).forEach(System.out::println);

        // --------------------------------------------------------
        // 3️⃣ TERMINAL OPERATIONS
        // ↓ Triggers execution
        // --------------------------------------------------------

        System.out.println("\n=== Count ===");
        long count = employees.stream().count();
        System.out.println("Total employees: " + count);

        System.out.println("\n=== Collect: List of IT Employees ===");
        List<Employee> itEmployees =
                employees.stream()
                        .filter(e -> e.getDepartment().equals("IT"))
                        .collect(Collectors.toList());
        System.out.println(itEmployees);

        System.out.println("\n=== Collect: Names joined ===");
        String namesJoined = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(namesJoined);

        System.out.println("\n=== Reduce: Total Salary ===");
        Optional<Integer> totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce((a, b) -> a + b);
        totalSalary.ifPresent(System.out::println);

        System.out.println("\n=== Max and Min salary of All Employee ===");
        Optional<Employee> max = employees.stream().max((o1, o2) -> o1.getSalary() - o2.getSalary());
        max.ifPresent(System.out::println);

        Optional<Employee> min = employees.stream().min(Comparator.comparingInt(Employee::getSalary));
        min.ifPresent(System.out::println);

        // NOTE: If comparator is descending → max() returns smallest value (since comparison basis is reversed)
        System.out.println("max: " + Stream.of(44, 2, 69).max((o1, o2) -> o2 - o1));

        System.out.println("\n=== FindFirst: First IT Employee ===");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .findFirst()
                .ifPresent(System.out::println);


        System.out.println("\n=== anyMatch / allMatch / noneMatch ===");
        boolean anyHigh = employees.stream().anyMatch(e -> e.getSalary() > 100000);
        boolean allITLow = employees.stream().allMatch(e -> e.getSalary() < 1000000);
        boolean noneFinanceLow = employees.stream().noneMatch(e -> e.getDepartment().equals("Marketing"));

        System.out.println("Any salary > 1L: " + anyHigh);
        System.out.println("All employees salary < 10L: " + allITLow);
        System.out.println("No one in Marketing: " + noneFinanceLow);

    }
}
