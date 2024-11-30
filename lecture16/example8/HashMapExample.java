package lecture16.example8;

import java.util.HashMap;

class Student {
    int matricNumber;
    String name;

    public Student(int matricNumber, String name) {
        this.matricNumber = matricNumber;
        this.name = name;
    }

    int getMatricNumber() { return matricNumber; }
    String getName() { return name; }
}

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();
        Student s1 = new Student(1, "Tan Puay Hwee");
        Student s2 = new Student(2, "David Brown");
        Student s3 = new Student(3, "Satish Gupta");

        studentMap.put(s1.getMatricNumber(), s1);
        studentMap.put(s2.getMatricNumber(), s2);
        studentMap.put(s3.getMatricNumber(), s3);

        Student retStudent = null;
        for (int key = 1; key < 4; key++) {
            retStudent = studentMap.get(key);
            System.out.println("Student with key = " + key + " is called " + retStudent.getName());
        }
    }
}
