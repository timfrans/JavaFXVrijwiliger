package model.predicates;

import model.Student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentPredicate {
    public static Predicate<Student> isNotGuessed() {
        return student -> student.isGuessed() == false;
    }

    public static Predicate<Student> hasLowestScore(int lowest) {
        return student -> student.getScore() == lowest;
    }

    public static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.<Student>toList());
    }
}
