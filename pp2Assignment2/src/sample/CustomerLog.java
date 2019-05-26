package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerLog {
    public javafx.scene.control.Button btnBackCusLog;
    public javafx.scene.control.Button btnPurchase;

    public void backCusLog(javafx.event.ActionEvent event) throws IOException {

        Parent backCusLogParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        btnBackCusLog.getScene().getWindow().hide();

        Scene backCusLogScene = new Scene(backCusLogParent);

        Stage cusWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        cusWindow.setScene(backCusLogScene);
        cusWindow.show();
    }

    public void cPurchase(javafx.event.ActionEvent event) throws IOException {

        Parent cPurchaseParent = FXMLLoader.load(getClass().getResource("Purchase.fxml"));
        btnPurchase.getScene().getWindow().hide();

        Scene cPurchaseScene = new Scene(cPurchaseParent);

        Stage cpWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        cpWindow.setScene(cPurchaseScene);
        cpWindow.show();
    }
}
