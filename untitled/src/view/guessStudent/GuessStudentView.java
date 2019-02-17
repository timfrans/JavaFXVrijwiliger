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

public class GuessStudentView extends BorderPane {
    private ImageView imgV;

    private VBox formBox;
    private HBox txtFieldBox;
    private TextField txtFirstName;
    private TextField txtLastName;

    private Button checkBttn;
    private HBox bttnBox;

    public GuessStudentView(String url) {
        initializeNodes(url);

        alignNodes();
    }

    private void initializeNodes(String url) {
        Image img = new Image(url);
        imgV = new ImageView(img);

        txtFirstName = new TextField("Voornaam");
        txtLastName = new TextField("Ahternaam");
        txtFieldBox = new HBox(40, txtFirstName, txtLastName);

        checkBttn = new Button("Controleer");
        bttnBox = new HBox(checkBttn);

        formBox = new VBox(10, txtFieldBox, bttnBox);
    }

    private void alignNodes() {
        this.setCenter(imgV);
        this.setMargin(imgV, new Insets(0,0,10,0));

        this.setPadding(new Insets(10));
        checkBttn.setPadding(new Insets(10, 20, 10, 20));

        this.setBottom(formBox);
        txtFieldBox.setAlignment(Pos.CENTER);
        bttnBox.setAlignment(Pos.CENTER);
    }
}
