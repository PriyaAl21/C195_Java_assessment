package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utilities.Crud;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddAppointmentScreen extends Crud implements Initializable {
    public TextField titleField;
    public TextField descriptionField;
    public TextField locationField;
    public TextField typeField;
    public ComboBox<String> chooseContact;
    public TextField ApptIdField;
    public Button addAppointmentButton;
    public Button OnCancel;
    public TextField startDateTimeField;
    public TextField endDateTimeField;
    public TextField customerIDField;
    public TextField userIDField;
    public DatePicker dateField;
    public ComboBox<String> chooseStartHours;
    public ComboBox<String> chooseStartMin;
    public ComboBox<String> chooseEndHours;
    public ComboBox<String> chooseEndMin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
// contact names in combo box
        ObservableList<String> contactNames = FXCollections.observableArrayList();
        try {
            ResultSet rs = (ResultSet) Select("select * from contacts");
            while (rs.next()) {
                contactNames.add(rs.getString("Contact_Name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        chooseContact.setItems(contactNames);

//hours
        ObservableList<String> hours = FXCollections.observableArrayList();

        for(int i = 8; i<23 && i>=8;i++){
            System.out.println(String.valueOf(i));
            if(String.valueOf(i).length()==1){
                hours.add("0"+String.valueOf(i));
                System.out.println("0"+String.valueOf(i));
            }
            else{
                hours.add(String.valueOf(i));

            }
        }
        hours.add("test");
        chooseStartHours.setItems(hours);
        chooseEndHours.setItems(hours);

//minutes
        ObservableList<String> minutes = FXCollections.observableArrayList();

        String[] minArray = {"00","15","30","45"} ;
            for(int i=0;i<minArray.length;i++){
                minutes.add(minArray[i]);

            }
           chooseStartMin.setItems(minutes);
            chooseEndMin.setItems(minutes);
    }

    public void OnAddAppointment(ActionEvent actionEvent) {

    }

    public void OnCancel(ActionEvent actionEvent) {
    }

    public void OnChooseContact(ActionEvent actionEvent) {
    }


}
