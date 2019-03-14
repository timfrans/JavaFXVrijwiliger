package view.interrogation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Interrogation;

public class InterrogationPresenter {
    InterrogationView interrogationView;
    Interrogation interrogation;

    public InterrogationPresenter(Interrogation interrogation) {
        this.interrogation = interrogation;
        this.interrogationView = new InterrogationView(interrogation.getSelectedStudent());

        addEventHandlers();
    }

    public InterrogationView getInterrogationView() {
        return interrogationView;
    }

    public Interrogation getInterrogation() {
        return interrogation;
    }

    private void addEventHandlers() {
        interrogationView.correctBttn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                interrogation.getSelectedStudent().increaseScore();
                interrogation.setCorrect(true);
                closeStage();
            }
        });

        interrogationView.falseBttn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeStage();
            }
        });
    }

    private void closeStage() {
        Stage stage = (Stage)interrogationView.getScene().getWindow();
        stage.close();
    }
}
