package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.List;
//static allows static declarations of a class to be used without instantiating that class.
import static model.predicates.StudentPredicate.*;

public class Group {
    private List<Student> students;

    private String name;

    public Group(List<Student> s) {
        students = s;
        name = "INF101";
    }

    public List<Student> getStudents() {
        return students;
    }

    //when everyone has the same score first element will always be chosen
    public List<Student> pickStudents() {
        //stream.min() gives student from list<Student> that meets comparator req
        //Comparator.comparingInt returns optional --> get() to get the student
        //dubble :: lambda??? do not really understand
        int lowest = students.stream().min(Comparator.comparingInt(Student::getScore)).get().getScore();
        return filterStudents(students, hasLowestScore(lowest));
    }

    public void resetScores() {
        for(Student s: students) {
            s.scoreProperty().setValue(0);
        }
    }

    public void resetTooLates() {
        for(Student s: students) {
            s.tooLateProperty().setValue(0);
        }
    }

    public void resetGuessedStud() {
        for(Student s: students) {
            s.setGuessed(false);
        }
    }

    public ObservableList<Student> createStudentsObservable() {
        return FXCollections.observableList(students);
    }
}