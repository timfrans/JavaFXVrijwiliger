package view.interrogation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Student;

public class InterrogationView extends BorderPane {
    Label namelbl;

    ImageView imgV;

    HBox bttnBox;
    Button correctBttn;
    Button falseBttn;

    public InterrogationView(Student s) {
        initializeNodes(s);

        alignNodes();

        this.getStylesheets().add("css/main.css");
    }

    private void initializeNodes(Student s) {
        namelbl = new Label(s.getFirstName() + " " + s.getLastName());

        Image img = new Image(s.getImgUrl());
        imgV = new ImageView(img);

        correctBttn = new Button("CORRECT");
        falseBttn = new Button("WRONG");

        bttnBox = new HBox(40, correctBttn, falseBttn);
    }

    private void alignNodes() {
        correctBttn.setPadding(new Insets(10, 20, 10, 20));
        falseBttn.setPadding(new Insets(10, 20, 10, 20));

        this.setPadding(new Insets(10));

        namelbl.setId("title");
        HBox nameBox = new HBox(namelbl);
        nameBox.setAlignment(Pos.CENTER);
        this.setTop(nameBox);

        this.setCenter(imgV);
        this.setMargin(imgV, new Insets(10,0,10,0));

        this.setBottom(bttnBox);
        bttnBox.setAlignment(Pos.CENTER);
    }
}
