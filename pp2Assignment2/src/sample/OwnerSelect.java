package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class OwnerSelect {
    public javafx.scene.control.Button btnMSD;

    public void manageStaffDetails(javafx.event.ActionEvent event) throws IOException {

        Parent manageSDParent = FXMLLoader.load(getClass().getResource("StaffRegister.fxml"));
        btnMSD.getScene().getWindow().hide();

        Scene manageSDScene = new Scene(manageSDParent);

        Stage msdWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        msdWindow.setScene(manageSDScene);
        msdWindow.show();
    }
}
