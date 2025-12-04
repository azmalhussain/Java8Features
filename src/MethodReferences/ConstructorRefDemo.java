package MethodReferences;

import java.util.function.Supplier;

public class ConstructorRefDemo {
    public static void main(String[] args) {
//        Supplier<Student> supplier = () -> new Student();
        Supplier<Student> supplier = Student::new;
        Student s = supplier.get();
    }
}

class Student {
    public Student() {
        System.out.println("Student object created.");
    }
}
