package view.guessStudent;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import model.GuessStudent;

public class GuessStudentPresenter {
    GuessStudentView guessView;
    GuessStudent guessModel;

    public GuessStudentPresenter(GuessStudent guessModel) {
        this.guessModel = guessModel;
        this.guessView = new GuessStudentView(guessModel.getSelectedStudent());

        addEventHandlers();
    }

    public GuessStudentView getGuessView() {
        return guessView;
    }

    public GuessStudent getGuessModel() {
        return guessModel;
    }

    private void updateAnswer() {
        guessModel.updateAnswer(guessView.txtFirstName.getText(), guessView.txtLastName.getText());
    }

    private void addEventHandlers() {
        guessView.btnCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateAnswer();
                guessModel.checkAnswer();
                if(guessModel.isCorrect()) {
                    guessView.changeBgColor("green");
                } else {
                    guessView.changeBgColor("red");
                }
                closeStageAfterDelay();
            }
        });
    }

    private void closeStageAfterDelay() {
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage s = (Stage)guessView.getScene().getWindow();
                s.close();
            }
        });
        delay.play();
    }
}
