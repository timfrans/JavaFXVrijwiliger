package view.tooLate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Student;

public class TooLateView extends BorderPane {
    Button btnClose;
    ImageView img;
    Label title;

    public TooLateView(Student s) {
        initNodes(s);

        alignNodes();
    }

    private void initNodes(Student s) {
        this.btnClose = new Button("Close");
        HBox btnBox = new HBox(btnClose);

        img = new ImageView(s.getImgUrl());

        title = new Label("You can join the class after the break");
        HBox titleBox = new HBox(title);
    }

    private void alignNodes() {
        this.setPadding(new Insets(10));

        HBox titleBox = (HBox)title.getParent();
        titleBox.setAlignment(Pos.CENTER);
        this.setTop(titleBox);

        this.setCenter(img);

        HBox btnBox = (HBox)btnClose.getParent();
        btnBox.setAlignment(Pos.CENTER);
        this.setBottom(btnBox);
    }
}
