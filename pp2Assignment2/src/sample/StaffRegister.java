package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaffRegister {
    public javafx.scene.control.Button btnSRegSubmit;

    @FXML
    private TextField sRegEmail;

    @FXML
    private TextField sRegID;

    @FXML
    private TextField sRegPass;

    @FXML
    private TextField sRegName;

    public void sRegSubmit(javafx.event.ActionEvent event) throws IOException, SQLException {
        ConnectStaffDB connectConnectStaffDB = new ConnectStaffDB();
        Connection connection= connectConnectStaffDB.getConnection();

        Pattern em = Pattern.compile("[a-zA-Z0-9]([a-zA-Z0-9._])*@[a-zA-Z0-9]+([.][a-zA-Z]+)");

        Matcher email = em.matcher(sRegEmail.getText());

        if (email.matches()) {
            String sql = "INSERT INTO staff_details VALUES('" + sRegID.getText() + "','" + sRegPass.getText() + "','" + sRegName.getText() + "','" + sRegEmail.getText() + "');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            //ResultSet State=statement.executeQuery(sql);

            Parent regSubmitParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
            btnSRegSubmit.getScene().getWindow().hide();

            Scene regSubmitScene = new Scene(regSubmitParent);

            Stage cusWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

            cusWindow.setScene(regSubmitScene);
            cusWindow.show();
        }else{
            System.out.println("Login ERROR");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password validation");
            alert.setContentText("Invalid Email Address.");
            alert.showAndWait();
        }
    }

}
