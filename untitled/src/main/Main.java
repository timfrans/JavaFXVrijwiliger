package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.group.GroupView;
import view.guessStudent.GuessStudentView;
import view.interrogation.InterrogationView;
import view.main.MainView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        //MainView main = new MainView();
        GuessStudentView v = new GuessStudentView("test.png");
        Scene scene = new Scene(v);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Tracker");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
