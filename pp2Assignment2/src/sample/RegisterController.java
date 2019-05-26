package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.TextField;



import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterController {
    public javafx.scene.control.Button btnRegBack;
    public javafx.scene.control.Button btnRegSubmit;

    @FXML
    private TextField cName;

    @FXML
    private TextField cEmail;

    @FXML
    private TextField cAddress;

    @FXML
    private TextField cTel;

    @FXML
    public PasswordField txtpRegPass;
    @FXML
    private RadioButton btnR;
    private String newsLetter;


    public void backLogin(javafx.event.ActionEvent event) throws IOException {

        Parent backOwnerMainParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        btnRegBack.getScene().getWindow().hide();

        Scene backOwnerMainScene = new Scene(backOwnerMainParent);

        Stage cusWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        cusWindow.setScene(backOwnerMainScene);
        cusWindow.show();
    }



    public void regSubmit(javafx.event.ActionEvent event) throws IOException, SQLException {
        ConnectCusDB connectCusDB = new ConnectCusDB();
        Connection connection = connectCusDB.getConnection();

        Pattern pw = Pattern.compile("((?=.*[a-zA-Z])(?=.*[^a-zA-Z]).*(?=.*[^a-zA-Z]).{8,15})");
        Pattern em = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");

        Matcher pass = pw.matcher(txtpRegPass.getText());
        Matcher email = em.matcher(cEmail.getText());

        if(btnR.isSelected()){
            newsLetter="yes";
        }else{
            newsLetter="no";
        }

        if(email.find() && email.group().equals(cEmail.getText())) {
            if (pass.matches()) {

                System.out.println("Login Successful");

                String sql = "INSERT INTO customerdetails VALUES('" + cName.getText() + "','" + cEmail.getText() + "','" + txtpRegPass.getText() + "','"
                        + cAddress.getText() + "','" + cTel.getText() + "','" + newsLetter + "');";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.executeUpdate();
                //ResultSet State=statement.executeQuery(sql);

                Parent regSubmitParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
                btnRegSubmit.getScene().getWindow().hide();

                Scene regSubmitScene = new Scene(regSubmitParent);

                Stage cusWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

                cusWindow.setScene(regSubmitScene);
                cusWindow.show();

            } else {
                System.out.println("Login Error");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password validation");
                alert.setContentText("ERROR, Your password must contain 'at least 8' characters and two must be 'non-alphabetic'. Please, reset it.");
                alert.showAndWait();

            }
        }else {
            System.out.println("Login Error");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password validation");
            alert.setContentText("Invalid Email Address.Please, reset it.");
            alert.showAndWait();
        }

    }
}


