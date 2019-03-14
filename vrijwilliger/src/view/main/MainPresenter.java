package view.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.FileManager;
import model.Game;

public class MainPresenter {
    private MainView mainView;
    private Game gameModel;

    public MainPresenter(MainView view) {
        this.mainView = view;
        this.gameModel = Game.getInstance();

        addEventHandlers();
    }

    private void addEventHandlers() {
        mainView.resetScore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameModel.getGroup().resetScores();
                new FileManager().writeStudents(gameModel.mergeStudentLists());
            }
        });

        mainView.resetTooLate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameModel.getGroup().resetTooLates();
                new FileManager().writeStudents(gameModel.mergeStudentLists());
            }
        });

        mainView.resetGuessedStud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameModel.getGroup().resetGuessedStud();
                gameModel.filterStudentsToGuess();
                new FileManager().writeStudents(gameModel.mergeStudentLists());
            }
        });
    }
}
