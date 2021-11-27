package model;

;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/** This class creates an DataStorage object which stores all customers and appointments.
 It also contains the methods to add,update or delete customers and appointments*/
public class DataStorage {

    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();

    /**
     * This method adds a part to the list of all parts
     *
     * @param customer
     */
    public static void addCustomer(Customer customer) {

        allCustomers.add(customer);

    }

    /**
     * This method adds a part to the list of all parts.
     *
     * @param appointment
     */
    public static void addAppoinment(Appointment appointment) {
        allAppointments.add(appointment);
    }

    /**This method retrieves all parts from a list of all parts*/
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    /**This method retrieves all products from a list of all products*/
    public static ObservableList<Appointment> getAllAppointments() {
        return allAppointments;
    }
}


