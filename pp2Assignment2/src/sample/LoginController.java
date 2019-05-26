package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;

public class LoginController {

    public javafx.scene.control.Button btnBack;
    public javafx.scene.control.Button btnCusCreate;
    @FXML
    private Label lblCusLog;

    @FXML
    private Label lblCusUserN;

    @FXML
    private Label lblCusPass;

    @FXML
    private Label lblCusStatus;

    @FXML
    private TextField txtCusUserN;

    @FXML
    private TextField txtCusPass;
    @FXML
    private TextField txtfCusUserN;
    @FXML
    private TextField txtfCusPassword;
    @FXML
    private Label isConnected;

    public void CustomerLogin(javafx.event.ActionEvent event) throws SQLException, IOException {
        ConnectCusDB connectCusDB = new ConnectCusDB();
        Connection connection= connectCusDB.getConnection();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customerdetails WHERE EmailAddress= '" + txtfCusUserN.getText() + "' AND Password='" + txtfCusPassword.getText() + "';";

            //statement.executeUpdate();
            ResultSet State = statement.executeQuery(sql);
            if (State.next()) {
                Parent cusloginParent = FXMLLoader.load(getClass().getResource("CustomerLog.fxml"));
                Scene cusloginScene = new Scene(cusloginParent);

                Stage cusWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

                cusWindow.setScene(cusloginScene);
                cusWindow.show();
                isConnected.setText("Connected");
            }else{
                isConnected.setText("Not Connected");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void backMain(javafx.event.ActionEvent event) throws IOException {

        Parent backMainParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        btnBack.getScene().getWindow().hide();

        Scene backMainScene = new Scene(backMainParent);

        Stage cusWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        cusWindow.setScene(backMainScene);
        cusWindow.show();
    }

    public void createNew(javafx.event.ActionEvent event) throws IOException {



        Parent createNewParent = FXMLLoader.load(getClass().getResource("Register.fxml"));
        btnCusCreate.getScene().getWindow().hide();

        Scene createNewScene = new Scene(createNewParent);

        Stage cusWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        cusWindow.setScene(createNewScene);
        cusWindow.show();
    }



}
