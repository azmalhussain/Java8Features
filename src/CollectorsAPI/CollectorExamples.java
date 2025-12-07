package CollectorsAPI;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private final int id;
    private final String name;
    private final String department;
    private final int marks;

    public Student(int id, String name, String department, int marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
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

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + "(" + department + ", " + marks + ")";
    }
}

public class CollectorExamples {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1, "Ayaan", "CS", 85),
                new Student(2, "Bilal", "EC", 78),
                new Student(3, "Ibrahim", "CS", 92),
                new Student(4, "Danish", "ME", 67),
                new Student(5, "Farhan", "EC", 88)
        );

        // 1. Collectors.toList()
        List<String> namesList = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("List of Names: " + namesList);

        // 2. Collectors.toSet()
        Set<String> deptSet = students.stream()
                .map(Student::getDepartment)
                .collect(Collectors.toSet());
        System.out.println("Set of Departments: " + deptSet);

        // 3. Collectors.toMap()
        Map<Integer, String> idNameMap = students.stream()
                .collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println("ID -> Name Map: " + idNameMap);

        // 4. Collectors.joining()
        String joinedNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + joinedNames);

        // 5. Collectors.counting()
        long count = students.stream()
                .collect(Collectors.counting());
        System.out.println("Total Students: " + count);

        // 6. summingInt()
        int totalMarks = students.stream()
                .collect(Collectors.summingInt(Student::getMarks));
        System.out.println("Total Marks: " + totalMarks);

        // 7. averagingInt()
        double averageMarks = students.stream()
                .collect(Collectors.averagingInt(Student::getMarks));
        System.out.println("Average Marks: " + averageMarks);

        // 8. groupingBy()
        Map<String, List<Student>> groupByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println("Students Grouped by Department: " + groupByDept);

        // 9. mapping() inside groupingBy()
        Map<String, List<String>> deptToNames = students.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getDepartment,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        )
                );
        System.out.println("Department -> Names List: " + deptToNames);

        // 10. partitioningBy() → Marks >= 80
        Map<Boolean, List<Student>> partition = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getMarks() >= 80));
        System.out.println("Partition: Marks >= 80 : " + partition);

        // 11. summarizingInt()
        IntSummaryStatistics stats = students.stream()
                .collect(Collectors.summarizingInt(Student::getMarks));
        System.out.println("Marks Summary: " + stats);
    }
}
