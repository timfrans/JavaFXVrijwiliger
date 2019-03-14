package view.table;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import model.Student;

public class Table extends TableView<Student> {
    public Table() {
        this.setPrefWidth(600);
        this.setPrefHeight(400);

        initColumns();

        alignColumns();

        this.getStylesheets().add("css/table.css");
    }

    private void initColumns() {
        this.setEditable(false);

        TableColumn<Student, Pane> photoColumn = new TableColumn<Student, Pane>("photo");
        photoColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, Pane>, ObservableValue<Pane>>() {
            @Override
            public ObservableValue<Pane> call(TableColumn.CellDataFeatures<Student, Pane> param) {
                ImageView img = new ImageView(param.getValue().getImgUrl());
                Pane p = new Pane(img);
                p.setPrefHeight(147);
                img.fitWidthProperty().bind(p.widthProperty());
                img.fitHeightProperty().bind(p.heightProperty());
                ObjectProperty<Pane> imgProp = new SimpleObjectProperty<Pane>(p);
                return imgProp;
            }
        });

        TableColumn<Student, String> firstNameColumn = new TableColumn<Student, String>("first name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn<Student, String> lastNameColumn = new TableColumn<Student, String>("last name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn<Student, Integer> scoreColumn = new TableColumn<Student, Integer>("score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory("score"));

        TableColumn<Student, Integer> tooLateColumn = new TableColumn<Student, Integer>("times too late");
        tooLateColumn.setCellValueFactory(new PropertyValueFactory("tooLate"));
        tooLateColumn.setCellFactory(column -> {
            return new TableCell<Student, Integer>() {
                @Override
                protected void updateItem(Integer tooLate, boolean empty) {
                    super.updateItem(tooLate, empty);

                    if(tooLate == null | empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        setText(tooLate.toString());
                        if(tooLate >= 2) {
                            setStyle("-fx-background-color: #f9a7a7");
                        } else {
                            setStyle("");
                        }
                    }
                }
            };
        });

        this.getColumns().addAll(photoColumn, firstNameColumn, lastNameColumn, scoreColumn, tooLateColumn);
    }

    private void alignColumns() {
        this.getColumns().get(0).setPrefWidth(100);
        this.getColumns().get(1).prefWidthProperty().bind(this.widthProperty().subtract(100).divide(4));
        this.getColumns().get(2).prefWidthProperty().bind(this.widthProperty().subtract(100).divide(4));
        this.getColumns().get(3).prefWidthProperty().bind(this.widthProperty().subtract(100).divide(4));
        this.getColumns().get(4).prefWidthProperty().bind(this.widthProperty().subtract(100).divide(4));
    }
}
