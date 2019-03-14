package view.tooLate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Student;

public class TooLatePresenter {
    TooLateView view;
    Student model;

    public TooLatePresenter(Student model) {
        this.model = model;
        this.view = new TooLateView(model);

        addEventHandlers();
    }

    public TooLateView getView() {
        return view;
    }

    private void addEventHandlers() {
        view.btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage s = (Stage)view.getScene().getWindow();
                s.close();
            }
        });
    }
}
