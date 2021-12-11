package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AppointmentTypeScreen {
    public TableView aptTable;
    public TableColumn aptIdCol;
    public TableColumn titleCol;
    public TableColumn descriptionCol;
    public TableColumn locationCol;
    public TableColumn contactCol;
    public TableColumn typeCol;
    public TableColumn startDateTimeCol;
    public TableColumn endDateTimeCol;
    public TableColumn customerIDCol;
    public TableColumn userIdCol;
    public Button close;
    public ComboBox contactCombo;

    public void OnClose(ActionEvent actionEvent) {
    }

    public void OnContactCombo(ActionEvent actionEvent) {
    }
}
