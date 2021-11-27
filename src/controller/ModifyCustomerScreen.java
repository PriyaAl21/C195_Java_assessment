package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Customer;
import utilities.Crud;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static controller.LogInScreen.name;

public class ModifyCustomerScreen extends Crud implements Initializable {
    public TextField customerNameId;
    public TextField customerNameField;
    public TextField streetNameField;
    public TextField phoneField;
    public TextField postalCodeField;
    public ComboBox<String> chooseCountry;
    public ComboBox<String> chooseDivision;
    public Button modifyCustomerButton;
    public Button OnCancel;
    public Customer customer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    public void populateModifyForm(Customer customer) throws SQLException {
        this.customer = customer;
        customerNameId.setPromptText(String.valueOf(customer.getCustomerId()));
        customerNameField.setText(customer.getCustomerName());
        streetNameField.setText(customer.getAddress());
        phoneField.setText(customer.getPhone());
        postalCodeField.setText(customer.getPostalCode());
        int id = customer.getDivisionId();
        ResultSet rs3 = Select("Select * from first_level_divisions where Division_ID = "+ id);
        String divName = null;
        while(rs3.next()){
            divName = rs3.getString("Division");
        }

        chooseDivision.setPromptText(divName);


        String countryName = null;
        ResultSet rs = Select("Select * from countries join first_level_divisions \n" +
                "on countries.Country_ID=first_level_divisions.Country_ID\n" +
                "where first_level_divisions.Division_ID = " + customer.getDivisionId());
        while (rs.next()) {
            countryName = rs.getString("Country");
            chooseCountry.setPromptText(countryName);
        }

        ObservableList<String> countryNames = FXCollections.observableArrayList();
        try {
            ResultSet rs1= (ResultSet) Select("select * from countries");
            while (rs1.next()) {
                countryNames.add(rs1.getString("Country"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        chooseCountry.setItems(countryNames);


        ObservableList<String>divisionNames = FXCollections.observableArrayList();

        ResultSet rs2 = Select("Select * from first_level_divisions join countries \n" +
                "on countries.Country_ID=first_level_divisions.Country_ID\n" +
                "where countries.Country = "+'"'+countryName+'"' );
        while (rs2.next()) {
            divisionNames.add(rs2.getString("Division"));
        }
        chooseDivision.setItems(divisionNames);



    }

    public void OnChooseCountry(ActionEvent actionEvent) {
    }

    public void OnChooseDivision(ActionEvent actionEvent) {
    }

    public void OnUpdateCustomer(ActionEvent actionEvent) throws SQLException {
       // customerNameId.setPromptText(String.valueOf(customer.getCustomerId()));
        String customerName = customerNameField.getText();
        String street = streetNameField.getText();
        String phone = phoneField.getText();
        String postalCode= postalCodeField.getText();
        LocalDateTime createDate = customer.getCreateDate();
        String createdBy = customer.getCreatedBy();
        String division =  chooseDivision.getSelectionModel().getSelectedItem();

        int divisionId = 0;
        ResultSet rs = (ResultSet) Select("Select * from first_level_divisions where Division = "+ '"'+division+'"');
        while (rs.next()) {
            divisionId = (rs.getInt("Division_ID"));
        }
        System.out.println("UPDATE customers SET Customer_Name = " +'"'+ customerName+'"' +" Address = " +'"'+ street+'"'+
                " Postal_Code = " +'"'+ postalCode+'"'+" Phone = " +'"'+ phone+'"'+" Create_Date = "+'"'+ createDate +'"'+
                " Created_By = "+'"'+ createdBy+'"'+" Last_Update = "+'"'+ Timestamp.valueOf(LocalDateTime.now())+'"'+" Last_Updated_By = "+
                '"'+LogInScreen.name+'"'+" Division_ID = "+divisionId);

    }
//Create_Date  Created_By  Last_Update Last_Updated_By Division_ID
    public void OnCancel(ActionEvent actionEvent) {
    }


}
