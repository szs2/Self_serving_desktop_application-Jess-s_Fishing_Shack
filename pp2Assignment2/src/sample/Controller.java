package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller {

    public javafx.scene.control.Button btnCustomer;
    public javafx.scene.control.Button btnStaff;
    public javafx.scene.control.Button btnOwner;


    public void Customer(javafx.event.ActionEvent event) throws IOException {

        Parent cuslogParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        btnCustomer.getScene().getWindow().hide();
        Scene cuslogScene = new Scene(cuslogParent);

        Stage cusWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        cusWindow.setScene(cuslogScene);
        cusWindow.show();
    }

    public void Staff(javafx.event.ActionEvent event) throws IOException {

        Parent stafflogParent = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));
        btnStaff.getScene().getWindow().hide();
        Scene stafflogScene = new Scene(stafflogParent);

        Stage sWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        sWindow.setScene(stafflogScene);
        sWindow.show();
    }

    public void Owner(javafx.event.ActionEvent event) throws IOException {

        Parent ownerlogParent = FXMLLoader.load(getClass().getResource("OwnerLogin.fxml"));
        btnOwner.getScene().getWindow().hide();
        Scene ownerlogScene = new Scene(ownerlogParent);

        Stage oWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        oWindow.setScene(ownerlogScene);
        oWindow.show();
    }

}
