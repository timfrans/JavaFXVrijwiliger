package view.group;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.table.Table;

public class StudentView extends GridPane {
    Table groupTable;
    Table selectedStudentTable;

    Button btnAddStud;
    Button btnRemStud;
    Button btnLowestStud;
    Button btnTooLate;
    Button btnGuessStud;
    Button btnInterrogate;
    Button btnDeleteStud;

    public StudentView() {
        initNodes();

        alignNodes();

        initPresenter();
    }

    private void initPresenter() {
        new StudentPresenter(this);
    }

    private void initNodes() {
        groupTable = new Table();
        selectedStudentTable = new Table();

        btnAddStud = new Button("+");
        btnRemStud = new Button("-");
        btnLowestStud = new Button("LOWEST SCORE");
        btnGuessStud = new Button("GUESS NAME");
        btnTooLate = new Button("TOO LATE");
        btnInterrogate = new Button("INTERROGATE");
        btnDeleteStud = new Button("DELETE STUDENT");
    }

    private void alignNodes() {
        VBox studManag = new VBox(20, btnGuessStud,btnTooLate, btnDeleteStud);
        studManag.setAlignment(Pos.CENTER);
        HBox tableManag = new HBox(10, btnAddStud, btnRemStud, btnLowestStud);
        tableManag.setAlignment(Pos.CENTER);
        VBox selectQuiz = new VBox(20, btnInterrogate);
        selectQuiz.setAlignment(Pos.CENTER);

        this.add(groupTable, 0, 0);
        this.add(studManag, 1,0);
        this.add(tableManag, 0, 1);
        this.add(selectedStudentTable, 0,2);
        this.add(selectQuiz,1,2);

        btnAddStud.setId("iconBtn");
        btnRemStud.setId("iconBtn");


        this.setPadding(new Insets(10));
        this.setHgap(20);
        this.setVgap(10);
    }
}
