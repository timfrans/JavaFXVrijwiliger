package view.main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import view.group.StudentView;

public class MainView extends BorderPane {
    StudentView dataView;
    MenuItem resetScore;
    MenuItem resetTooLate;
    MenuItem resetGuessedStud;

    public MainView() {
        initNodes();

        alignNodes();

        initPresenter();

        this.getStylesheets().add("css/main.css");
    }

    private void initPresenter() {
        new MainPresenter(this);
    }


    private void initNodes() {
        resetScore = new MenuItem("reset score");
        resetTooLate = new MenuItem("reset too late");
        resetGuessedStud = new MenuItem("reset guessed students");

        dataView = new StudentView();
    }

    private void alignNodes() {
        final Menu groupMenu = new Menu("group", null, resetScore, resetTooLate, resetGuessedStud);
        final MenuBar bar = new MenuBar(groupMenu);
        this.setTop(bar);

        this.setCenter(dataView);
    }
}
