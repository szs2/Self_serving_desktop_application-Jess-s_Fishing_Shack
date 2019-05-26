package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffLogin  {
    public javafx.scene.control.Button btnStaffBack;

    @FXML
    private TextField txtfStaffEmail;
    @FXML
    private TextField txtpStaffPassword;
    @FXML
    private Label lblStaffConnect;

    public void backStaffLogin(javafx.event.ActionEvent event) throws IOException {

        Parent backStaffLoginParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        btnStaffBack.getScene().getWindow().hide();

        Scene backStaffLoginScene = new Scene(backStaffLoginParent);

        Stage cusWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        cusWindow.setScene(backStaffLoginScene);
        cusWindow.show();
    }

    public void StaffLogin(javafx.event.ActionEvent event) throws SQLException, IOException {
        ConnectStaffDB connectStaffDB = new ConnectStaffDB();
        Connection connection= connectStaffDB.getConnection();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM staff_details WHERE StaffEmail= '" + txtfStaffEmail.getText() + "' AND StaffPassword='" + txtpStaffPassword.getText() + "';";

            //statement.executeUpdate();
            ResultSet Stat = statement.executeQuery(sql);
            if (Stat.next()) {
                Parent staffLoginParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene staffLoginScene = new Scene(staffLoginParent);

                Stage slWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

                slWindow.setScene(staffLoginScene);
                slWindow.show();
                lblStaffConnect.setText("Connected");
            }else{
                lblStaffConnect.setText("Not Connected");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
