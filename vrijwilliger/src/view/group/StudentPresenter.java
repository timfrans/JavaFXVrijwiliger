package view.group;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import view.guessStudent.GuessStudentPresenter;
import view.interrogation.InterrogationPresenter;
import view.table.Table;
import view.tooLate.TooLatePresenter;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentPresenter {
    private StudentView groupView;
    private Game gameModel;

    public StudentPresenter(StudentView group) {
        this.groupView = group;
        gameModel = Game.getInstance();

        setTableData();

        addEventHandler();
    }

    private void setTableData() {
        groupView.groupTable.setItems(gameModel.getGroup().createStudentsObservable());
        groupView.selectedStudentTable.setItems(gameModel.createSelectedStudentsObservable());
    }

    public void addEventHandler() {
        groupView.btnTooLate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Student s = groupView.groupTable.getSelectionModel().getSelectedItem();
                    s.increaseTooLate();
                    if(s.getTooLate() == 2) {
                        TooLatePresenter iPresenter = new TooLatePresenter(s);
                        Stage tStage = new Stage();
                        tStage.initOwner(groupView.getScene().getWindow());
                        tStage.initModality(Modality.APPLICATION_MODAL);
                        tStage.setScene(new Scene(iPresenter.getView()));
                        tStage.setResizable(false);
                        tStage.showAndWait();
                    }
                } catch(NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("No student selected");
                    alert.setContentText("Select a student and try again.");
                    alert.showAndWait();
                } finally {
                    new FileManager().writeStudents(gameModel.mergeStudentLists());
                }
            }
        });

        groupView.btnAddStud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Student s = groupView.groupTable.getSelectionModel().getSelectedItem();
                moveStudent(s, groupView.groupTable, groupView.selectedStudentTable);
                groupView.groupTable.getSelectionModel().select(null);
            }
        });

        groupView.btnRemStud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Student s = groupView.selectedStudentTable.getSelectionModel().getSelectedItem();
                moveStudent(s, groupView.selectedStudentTable, groupView.groupTable);
                groupView.selectedStudentTable.getSelectionModel().select(null);
            }
        });

        groupView.btnLowestStud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    List<Student> s = gameModel.getGroup().pickStudents();
                    moveStudents(s, groupView.groupTable, groupView.selectedStudentTable);
                } catch(NoSuchElementException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("No student selected");
                    alert.setContentText("All students have been added");
                    alert.showAndWait();
                    return;
                }
            }
        });

        groupView.btnInterrogate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InterrogationPresenter iPresenter = new InterrogationPresenter(new Interrogation(gameModel.selectStudent(gameModel.getPickedStudents())));
                Stage iStage = new Stage();
                iStage.initOwner(groupView.getScene().getWindow());
                iStage.initModality(Modality.APPLICATION_MODAL);
                iStage.setScene(new Scene(iPresenter.getInterrogationView()));
                iStage.setResizable(false);
                iStage.showAndWait();

                //SHOULD THIS CHECK HAPPEN IN PRESENTER?
                if(iPresenter.getInterrogation().isCorrect()) {
                    moveStudent(iPresenter.getInterrogation().getSelectedStudent(), groupView.selectedStudentTable, groupView.groupTable);
                    new FileManager().writeStudents(gameModel.mergeStudentLists());
                }
            }
        });

        groupView.btnGuessStud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage gStage = new Stage();
                    GuessStudentPresenter gPresenter = new GuessStudentPresenter(new GuessStudent(gameModel.selectStudent(gameModel.getStudentsToGuess())));
                    gStage.initOwner(groupView.getScene().getWindow());
                    gStage.initModality(Modality.APPLICATION_MODAL);
                    gStage.setScene(new Scene(gPresenter.getGuessView()));
                    gStage.setResizable(false);
                    gStage.showAndWait();

                    if(gPresenter.getGuessModel().isCorrect()) {
                        gameModel.filterStudentsToGuess();
                        new FileManager().writeStudents(gameModel.mergeStudentLists());
                    }
                } catch(IllegalArgumentException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("All students guessed correctly");
                    alert.setContentText("Reset this in the group menu");
                    alert.showAndWait();
                    return;
                }
            }
        });

        groupView.btnDeleteStud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Student s = groupView.groupTable.getSelectionModel().getSelectedItem();
                    groupView.groupTable.getItems().remove(s);
                } catch(NoSuchElementException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("No student selected");
                    alert.setContentText("Select a student and try again");
                    alert.showAndWait();
                    return;
                }
                finally {
                    new FileManager().writeStudents(gameModel.mergeStudentLists());
                }
            }
        });
    }

    private void moveStudent(Student s, Table from, Table to) {
        try {
            if(s == null) {
                throw new NullPointerException();
            } else {
                to.getItems().add(s);
                from.getItems().remove(s);
            }
        } catch(NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No student selected");
            alert.setContentText("Select a student and try again.");
            alert.showAndWait();
        }
    }

    private void moveStudents(List<Student> s, Table from, Table to) {
        to.getItems().addAll(s);
        from.getItems().removeAll(s);
    }
}
