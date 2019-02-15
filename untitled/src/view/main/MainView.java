package view.main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.group.GroupView;

public class MainView extends VBox {
    HBox studDataBox;
    HBox selectedStudBox;
    HBox studManagementBttnsBox;

    VBox studManagementBox;
    VBox groupBttnsBox;

    Button teLaatBttn;
    Button raadtStudBttn;
    Button addStudentBttn;
    Button remStudentBttn;

    Button ondervraagBttn;

    public MainView() {
        initializeNodes();

        alignNodes();
    }


    private void initializeNodes() {
        initializeBttns();

        //tableview with buttons of all students
        studManagementBttnsBox = new HBox(20);
        studManagementBttnsBox.getChildren().addAll(addStudentBttn, remStudentBttn);

        studManagementBox = new VBox(20);
        studManagementBox.getChildren().addAll(new GroupView(), studManagementBttnsBox);

        groupBttnsBox = new VBox(40);
        groupBttnsBox.getChildren().addAll(teLaatBttn, raadtStudBttn);

        studDataBox = new HBox(20);
        studDataBox.getChildren().addAll(studManagementBox, groupBttnsBox);

        //tableview of selected students
        selectedStudBox = new HBox(20);
        selectedStudBox.getChildren().addAll(new GroupView(), ondervraagBttn);

        this.getChildren().addAll(studDataBox, selectedStudBox);
    }

    private void alignNodes() {
        alignBttns();

        this.setSpacing(20);
        this.setPadding(new Insets(10));

        groupBttnsBox.setAlignment(Pos.CENTER);
        studManagementBttnsBox.setAlignment(Pos.CENTER);
        selectedStudBox.setAlignment(Pos.CENTER_LEFT);

        studDataBox.setPrefHeight(300);
        selectedStudBox.setPrefHeight(300);
    }




    private void initializeBttns() {
        teLaatBttn = new Button("Te Laat");
        raadtStudBttn = new Button("Raadt Student");
        ondervraagBttn = new Button("Ondervraag");
    }

    private void alignBttns() {
        teLaatBttn.setPrefWidth(150);
        teLaatBttn.setPrefHeight(40);

        raadtStudBttn.setPrefWidth(150);
        raadtStudBttn.setPrefHeight(40);


        addStudentBttn = new Button("+");
        addStudentBttn.setPrefWidth(30);
        remStudentBttn = new Button("-");
        remStudentBttn.setPrefWidth(30);

        ondervraagBttn.setPrefWidth(150);
        ondervraagBttn.setPrefHeight(40);
    }
}
