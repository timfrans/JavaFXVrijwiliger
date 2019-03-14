package view.guessStudent;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Student;

public class GuessStudentView extends BorderPane {
    private ImageView imgV;
    TextField txtFirstName;
    TextField txtLastName;
    Button btnCheck;

    public GuessStudentView(Student s) {
        initializeNodes(s);

        alignNodes();

        this.getStylesheets().add("css/main.css");
    }

    private void initializeNodes(Student s) {
        Image img = new Image(s.getImgUrl());
        imgV = new ImageView(img);

        txtFirstName = new TextField("First name");
        txtLastName = new TextField("Last name");
        HBox txtFieldBox = new HBox(40, txtFirstName, txtLastName);
        txtFieldBox.setAlignment(Pos.CENTER);

        btnCheck = new Button("CHECK");
        HBox bttnBox = new HBox(btnCheck);
        bttnBox.setAlignment(Pos.CENTER);

        VBox formBox = new VBox(10, txtFieldBox, bttnBox);
        this.setBottom(formBox);
    }

    private void alignNodes() {
        this.setCenter(imgV);
        this.setMargin(imgV, new Insets(0,0,10,0));

        this.setPadding(new Insets(10));
        btnCheck.setPadding(new Insets(10, 20, 10, 20));
    }

    void changeBgColor(String c) {
        this.setStyle("-fx-background-color: " + c);
    }
}
