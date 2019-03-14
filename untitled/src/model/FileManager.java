package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileManager {
    String path;

    public FileManager() {
        this.path = "resources/groups/inf101.txt";
    }

    private List<Student> readStudents() {
        List<Student> studentList = new ArrayList<Student>();
        Path path = Paths.get(this.path);
        File file = path.toFile();
        Pattern pattern = Pattern.compile(";|\\r\\n");
        try(Scanner scanner = new Scanner(file).useDelimiter(pattern)) {
            while(scanner.hasNext()) {
                studentList.add(createStudent(scanner));
            }
        } catch(FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File not found!");
            alert.setContentText("File not found!");
            e.printStackTrace();
            alert.showAndWait();
        }
        return studentList;
    }

    public Group createGroup() {
        return new Group(readStudents());
    }


    private Student createStudent(Scanner scanner) {
        String firstName = scanner.next();
        String lastName = scanner.next();
        IntegerProperty score = new SimpleIntegerProperty(scanner.nextInt());
        IntegerProperty tooLate = new SimpleIntegerProperty(scanner.nextInt());
        boolean isGuessed = scanner.nextBoolean();
        String id = scanner.next();
        String imgUrl = scanner.next();
        return new Student(firstName, lastName, score, tooLate, isGuessed, id, imgUrl);
    }

    public void writeStudents(List<Student> students) {


        Path path = Paths.get("resources/groups/inf101.txt");
        File file = path.toFile();
        try(Formatter form = new Formatter(file)) {
            for(Student s: students) {
                form.format(s.toString());
                form.format("\r\n");
                form.flush();
            }
        } catch(FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File not found");
            alert.setContentText("File not found");
            alert.showAndWait();

        }
    }
}
