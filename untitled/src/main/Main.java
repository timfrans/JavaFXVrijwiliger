package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.group.GroupView;
import view.main.MainView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainView main = new MainView();
        Scene scene = new Scene(main);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Tracker");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
