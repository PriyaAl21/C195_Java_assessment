package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;
import model.DataStorage;
import utilities.Crud;
import utilities.JDBC;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class CustomerAppointmentScreen extends Crud  implements Initializable {

    public TableView<Customer> customerTable;
    public TableColumn<Customer,Integer> customerIdCol;
    public TableColumn<Customer, String> customerNameCol;
    public TableColumn<Customer, String> addressCol;
    public TableColumn<Customer, String> postalCodeCol;
    public TableColumn<Customer, String> phoneCol;
    public TableColumn<Customer, LocalDateTime> createDateCol;
    public TableColumn<Customer, String> createdByCol;
    public TableColumn<Customer, Timestamp> lastUpdateCol;
    public TableColumn<Customer, String> lastUpdatedByCol;
    public TableColumn<Customer, Integer> divisionIdCol;

    public ObservableList<Customer> getDbList() {
        return dbList;
    }

    public ObservableList<Customer> dbList = FXCollections.observableArrayList();
    public TableView apptTable;
    public TableColumn apptIdCol;
    public TableColumn titleCol;
    public TableColumn descriptionCol;
    public TableColumn locationCol;
    public TableColumn contactCol;
    public TableColumn typeCol;
    public TableColumn startDateTimeCol;
    public TableColumn endDateTimeCol;
    public TableColumn cusIdCol;
    public TableColumn userIdCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


//            Statement st = null;
//            ResultSet rs;
//            try {
//                st = JDBC.getConnection().createStatement();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            String sqlStatement = "Select * from customers";
//            try {
//                st.execute(sqlStatement);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            try {
//                rs = st.getResultSet();
        ResultSet rs = null;
        try {
            rs = Select("Select * from customers");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//
            try {
                Customer.populate(rs);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//                    int customerId = Integer.parseInt(rs.getString("Customer_ID"));
//                    String customerName = rs.getString("Customer_Name");
//                    String address = rs.getString("Address");
//                    String postalCode = rs.getString("Postal_Code");
//                    String phone = rs.getString("Phone");
//                    LocalDateTime createDate = rs.getTimestamp("Create_Date").toLocalDateTime();
//                    String createdBy = rs.getString("Created_By");
//                   Timestamp lastUpdate = rs.getTimestamp("Last_Update");
//                    String lastUpdatedBy = rs.getString("Last_Updated_By");
//                    int divisionId = Integer.parseInt(rs.getString("Division_ID"));
//
//                    Customer one = new Customer(customerId, customerName, address, phone, postalCode, createDate, createdBy, lastUpdate,
//                            lastUpdatedBy, divisionId);
//                    DataStorage.getAllCustomers().add(one);
//                    System.out.println(one.getCustomerId());
//
                //}
            }


            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            customerNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerName"));
            addressCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
            postalCodeCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("postalCode"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
            createDateCol.setCellValueFactory(new PropertyValueFactory<Customer, LocalDateTime>("createDate"));
            createdByCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("createdBy"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<Customer, Timestamp>("lastUpdate"));
            lastUpdatedByCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastUpdatedBy"));
            divisionIdCol.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("divisionId"));
            customerTable.setItems(DataStorage.getAllCustomers());

        }







    //}

    public void onAdd(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AddCustomerScreen.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Customer");
           // Scene scene = new Scene(root,700,500);
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onEdit(ActionEvent actionEvent) {
    }

    public void onDelete(ActionEvent actionEvent) {
    }
}
