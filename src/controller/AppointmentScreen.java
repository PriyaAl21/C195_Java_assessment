package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointment;
import model.DataStorage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import utilities.Crud;

public class AppointmentScreen extends Crud implements Initializable {
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
    public Button addAppointment;
    public Button modifyAppointment;
    public Button deleteAppointment;
    public RadioButton viewWeek;
    public ToggleGroup weekMonth;
    public RadioButton viewMonth;
    public RadioButton viewAll;
    public Button viewCustomers;
    public Button exitButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ResultSet rs = null;
        try {
            rs = Select("select appointments.Appointment_ID,  appointments.Title, appointments.Description ,appointments.Location,contacts.contact_Name,\n" +
                    "appointments.Type,appointments.Start,appointments.End,appointments.Customer_ID,appointments.User_ID\n" +
                    "from appointments \n" +
                    "join contacts\n" +" on appointments.Contact_ID = contacts.Contact_ID");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                Appointment.populate(rs);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        aptIdCol.setCellValueFactory(new PropertyValueFactory<>("aptId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        startDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("startDateNTime"));
        endDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("endDateNTime"));
        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        userIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        aptTable.setItems(DataStorage.getAllAppointments());

    }



    public void OnAddAppointment(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AddAppointmentScreen.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Customers");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void OnModifyAppointment(ActionEvent actionEvent) {
    }

    public void OnDeleteAppointment(ActionEvent actionEvent) {
    }

    public void OnViewWeek(ActionEvent actionEvent) {
    }

    public void OnViewMonth(ActionEvent actionEvent) {
    }

    public void OnViewAll(ActionEvent actionEvent) {
    }

    public void OnViewCustomers(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/CustomerScreen.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Customers");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OnExit(ActionEvent actionEvent) {
    }


}
