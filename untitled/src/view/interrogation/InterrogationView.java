package view.interrogation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class InterrogationView extends BorderPane {
    ImageView imgV;

    HBox bttnBox;
    Button correctBttn;
    Button falseBttn;

    public InterrogationView(String url) {
        initializeNodes(url);

        alignNodes();
    }

    private void initializeNodes(String url) {
        Image img = new Image(url);
        imgV = new ImageView(img);

        correctBttn = new Button("Juist");
        falseBttn = new Button("Fout");

        bttnBox = new HBox(40, correctBttn, falseBttn);
    }

    private void alignNodes() {
        correctBttn.setPadding(new Insets(10, 20, 10, 20));
        falseBttn.setPadding(new Insets(10, 20, 10, 20));

        this.setPadding(new Insets(10));

        this.setCenter(imgV);
        this.setMargin(imgV, new Insets(0,0,10,0));

        this.setBottom(bttnBox);
        bttnBox.setAlignment(Pos.CENTER);
    }
}
