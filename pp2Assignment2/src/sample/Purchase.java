package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;



public class Purchase implements Initializable{
    public javafx.scene.control.TextField txtQuantity;
    @FXML
    private TextField txtfProID;
    @FXML
    private TextField txtfProName;
    @FXML
    private TextField txtfProSize;
    @FXML
    private TextField txtfProPrice;
    @FXML
    private TextField txtfQuantity;
    @FXML
    private TextField txtfTotPrice;
    @FXML
    private Label error;
    private int total;


    @FXML private TableView<PurProducts> table;
    @FXML private TableColumn<PurProducts, String> product_ID;
    @FXML private TableColumn<PurProducts, String> product_Name;
    @FXML private TableColumn<PurProducts, String> product_Size;
    @FXML private TableColumn<PurProducts, Integer> available_Quantity;
    @FXML private TableColumn<PurProducts, Integer> product_Price;

    public ObservableList<PurProducts> list = FXCollections.observableArrayList(
            new PurProducts("FL01","Fishing Line","100m",20,150),
            new PurProducts("FL02","Fishing Line","200m",15,230),
            new PurProducts("FL03","Fishing Line","300m",18,300),
            new PurProducts("SI01","Sinkers","10g",7,100),
            new PurProducts("SI02","Sinkers","20g",16,150),
            new PurProducts("SI03","Sinkers","30g",22,190),
            new PurProducts("SW01","Swivels","small",28,200),
            new PurProducts("SW02","Swivels","medium",14,250),
            new PurProducts("SW03","Swivels","large",17,300)
    );


    @Override
    public void initialize(URL location, ResourceBundle rescoutces) {
        product_ID.setCellValueFactory(new PropertyValueFactory<PurProducts, String>("product_ID"));
        product_Name.setCellValueFactory(new PropertyValueFactory<PurProducts, String>("product_Name"));
        product_Size.setCellValueFactory(new PropertyValueFactory<PurProducts, String>("product_Size"));
        available_Quantity.setCellValueFactory(new PropertyValueFactory<PurProducts, Integer>("available_Quantity"));
        product_Price.setCellValueFactory(new PropertyValueFactory<PurProducts, Integer>("product_Price"));
        table.setItems(list);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection.getProduct_ID().equals("FL01")) {
                txtfProID.setText("FL01");
                txtfProName.setText("Fishing Line");
                txtfProSize.setText("100m");
                txtfProPrice.setText("150");
            }else if (newSelection.getProduct_ID().equals("FL02")) {
                txtfProID.setText("FL02");
                txtfProName.setText("Fishing Line");
                txtfProSize.setText("200m");
                txtfProPrice.setText("230");
            }else if (newSelection.getProduct_ID().equals("FL03")) {
                txtfProID.setText("FL03");
                txtfProName.setText("Fishing Line");
                txtfProSize.setText("300m");
                txtfProPrice.setText("300");
            }else if (newSelection.getProduct_ID().equals("SI01")) {
                txtfProID.setText("SI01");
                txtfProName.setText("Sinkers");
                txtfProSize.setText("10");
                txtfProPrice.setText("100");
            }else if (newSelection.getProduct_ID().equals("SI02")) {
                txtfProID.setText("SI02");
                txtfProName.setText("Sinkers");
                txtfProSize.setText("20");
                txtfProPrice.setText("150");
            }else if (newSelection.getProduct_ID().equals("SI03")) {
                txtfProID.setText("SI02");
                txtfProName.setText("Sinkers");
                txtfProSize.setText("30");
                txtfProPrice.setText("190");
            }else if (newSelection.getProduct_ID().equals("SW01")) {
                txtfProID.setText("SW01");
                txtfProName.setText("Swivels");
                txtfProSize.setText("small");
                txtfProPrice.setText("200");
            }else if (newSelection.getProduct_ID().equals("SW02")) {
                txtfProID.setText("SW02");
                txtfProName.setText("Swivels");
                txtfProSize.setText("medium");
                txtfProPrice.setText("200");
            }else if (newSelection.getProduct_ID().equals("SW03")) {
                txtfProID.setText("SW03");
                txtfProName.setText("Swivels");
                txtfProSize.setText("large");
                txtfProPrice.setText("200");
            }

        });
    }

    public boolean convertIS(String s){
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public void add  (javafx.event.ActionEvent event){
        if(!(convertIS(txtfQuantity.getText()))) {
            error.setText("Enter integer please");
        }else{
            error.setText("");
            total = Integer.parseInt(txtfProPrice.getText()) * Integer.parseInt(txtfQuantity.getText());
            txtfTotPrice.setText(Integer.toString(total));
        }
    }

    public void buy  (javafx.event.ActionEvent event) throws SQLException {
        ConnectCusDB connectCusDB = new ConnectCusDB();
        Connection connection= connectCusDB.getConnection();

        String sql = "INSERT INTO purchaseproduct VALUES('"+txtfProID.getText()+"','"+txtfProName.getText()+"','"+txtfProSize.getText()+"',"+Integer.parseInt(txtfQuantity.getText())+
                ","+total+");";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        statement1.executeUpdate();
    }
}

