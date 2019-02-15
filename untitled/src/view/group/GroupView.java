package view.group;

import javafx.scene.control.TableView;
import model.Student;

//contains buttons to randomly choose students and delete them
public class GroupView extends TableView<Student> {
    public GroupView() {
        this.setPrefWidth(600);
    }
}
