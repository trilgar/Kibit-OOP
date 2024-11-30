package lecture16.example9;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    // Реалізація методу compareTo для сортування за id
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class CustomComparableExample {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(3, "Alice"));
        studentList.add(new Student(1, "Bob"));
        studentList.add(new Student(2, "Charlie"));

        System.out.println("Before Sorting:");
        for (Student s : studentList) {
            System.out.println(s);
        }

        Collections.sort(studentList); // Використовується природний порядок

        System.out.println("\nAfter Sorting:");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}