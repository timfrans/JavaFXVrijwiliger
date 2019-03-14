package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import view.table.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//static allows static declarations of a class to be used without instantiating that class.
import static model.predicates.StudentPredicate.*;

public class Game {
    //singleton class
    private static Game singleton = null;
    private Group group;

    private List<Student> pickedStudents;
    private List<Student> studentsToGuess;

    private Game() {
        this.group = new FileManager().createGroup();
        this.pickedStudents = new ArrayList<Student>();
        filterStudentsToGuess();
    }

    public static Game getInstance() {
        if(singleton == null) {
            singleton = new Game();
        }

        return singleton;
    }

    public Group getGroup() {
        return group;
    }

    public List<Student> getPickedStudents() {
        return pickedStudents;
    }

    public List<Student> getStudentsToGuess() {
        return studentsToGuess;
    }

    //select random student from pickedStudents
    public Student selectStudent(List<Student> l) {
        int size = l.size();
        Student s = l.get(generateStudentIndex(size-1));
        return s;
    }

    private int generateStudentIndex(int max) {
        Random r = new Random();
        return r.ints(0, max + 1).findFirst().getAsInt();
    }

    public void filterStudentsToGuess() {
        this.studentsToGuess = filterStudents(group.getStudents(), isNotGuessed());

    }

    public ObservableList<Student> createSelectedStudentsObservable() {
        return FXCollections.observableList(pickedStudents);
    }

    public List<Student> mergeStudentLists() {
        List<Student> allStudents = new ArrayList<Student>(pickedStudents);
        allStudents.addAll(group.getStudents());
        return allStudents;
    }
}
