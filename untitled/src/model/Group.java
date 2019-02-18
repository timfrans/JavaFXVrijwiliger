package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Group {
    private List<Student> students;
    private String name;

    public Group() {
        students = new ArrayList<>();
        students.add(new Student("Tim", 3));
        students.add(new Student("Pol", 10));
        students.add(new Student("Pol", 15));
        students.add(new Student("Pol", 5));
        students.add(new Student("Pol", 100));
    }

    //create GroupReader and read students
    private void deleteStudent() {

    }

    //comparable gebruiken
    public Student pickStudent() {
        Student lowest = Collections.min(students);
        return lowest;
    }
}
