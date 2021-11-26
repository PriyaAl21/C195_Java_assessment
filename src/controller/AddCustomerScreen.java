package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Country;
import model.Customer;
import model.Division;
import utilities.Crud;
import utilities.DBQuery;
import utilities.JDBC;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddCustomerScreen extends Crud implements Initializable {
    public TextField customerNameField;
    public TextField streetNameField;
    public TextField phoneField;
    public TextField postalCodeField;
    public ComboBox<String> chooseCountry;
    public ComboBox<String> chooseDivision;
    public Button addCustomerButton;
    public Button OnCancelAdd;

    public Customer customer;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customer = new Customer();
        ObservableList<String> countryNames = FXCollections.observableArrayList();
        try {
            ResultSet rs = (ResultSet) Select("select * from countries");
            while (rs.next()) {
                countryNames.add(rs.getString("Country"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        chooseCountry.setItems(countryNames);

    }



    public void OnChooseCountry(ActionEvent actionEvent) throws Exception{
        int id=0;
        ObservableList<String>divisionNames = FXCollections.observableArrayList();
        String one = (String) chooseCountry.getSelectionModel().getSelectedItem();

        ResultSet rs1 = (ResultSet) Select("Select * from countries where Country = "+ '"'+one+'"');
        while (rs1.next()) {
            id = Integer.parseInt(rs1.getString("Country_ID"));
        }


       ResultSet rs2 = (ResultSet) Select("Select * from first_level_divisions where Country_ID = "+ id);
        while (rs2.next()) {
           divisionNames.add(rs2.getString("Division"));
        }
        chooseDivision.setItems(divisionNames);

    }

    public void OnChooseDivision(ActionEvent actionEvent) throws SQLException {
        String one =  chooseDivision.getSelectionModel().getSelectedItem();
        ResultSet rs = (ResultSet) Select("Select * from first_level_divisions where Division = "+ '"'+one+'"');
        while (rs.next()) {
            customer.setDivisionId(Integer.parseInt(rs.getString("Division_ID")));
            System.out.println(customer.getDivisionId());
        }

    }

    public void OnAddCustomer(ActionEvent actionEvent) {
        //ResultSet rs
    }

    public void OnCancel(ActionEvent actionEvent) {
    }

    public void OnCustomerName(ActionEvent actionEvent) {
       String name =  customerNameField.getText();
       customer.setCustomerName(name);
    }

    public void OnStreetName(ActionEvent actionEvent) {
        String name =  streetNameField.getText();
        customer.setAddress(name);
    }

    public void OnPhoneNum(ActionEvent actionEvent) {
        String num =  phoneField.getText();
        customer.setPhone(num);
    }

    public void OnPostalCode(ActionEvent actionEvent) {
        String post =  postalCodeField.getText();
        customer.setPostalCode(post);
    }
}
