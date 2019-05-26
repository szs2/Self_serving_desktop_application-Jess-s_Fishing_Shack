package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;

public class OwnerLogin {
    public javafx.scene.control.Button btnOwnerBack;
    public javafx.scene.control.Button btnOwnerLSubmit;

    @FXML
    private Label lblOwnerStatus;

    @FXML
    private TextField txtOwnerPass;

    @FXML
    private PasswordField txtpOwnerPass;

    public void backOwnerMain(javafx.event.ActionEvent event) throws IOException {

        Parent backOwnerMainParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        btnOwnerBack.getScene().getWindow().hide();

        Scene backOwnerMainScene = new Scene(backOwnerMainParent);

        Stage cusWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        cusWindow.setScene(backOwnerMainScene);
        cusWindow.show();
    }

    public void OwnerSubmit  (javafx.event.ActionEvent event) throws IOException {

        if(txtpOwnerPass.getText().equals("Owner")) {
            Parent OwnerSubmitParent = FXMLLoader.load(getClass().getResource("OwnerSelect.fxml"));
            btnOwnerBack.getScene().getWindow().hide();

            Scene OwnerSubmitScene = new Scene(OwnerSubmitParent);

            Stage osWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

            osWindow.setScene(OwnerSubmitScene);
            osWindow.show();
        }else{
            lblOwnerStatus.setText("Invalid Password");
        }
    }

}
