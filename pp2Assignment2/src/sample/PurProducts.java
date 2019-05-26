package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PurProducts {
    private final SimpleStringProperty product_ID;
    private final SimpleStringProperty product_Name;
    private final SimpleStringProperty product_Size;
    private final SimpleIntegerProperty available_Quantity;
    private final SimpleIntegerProperty product_Price;

    /*private String product_ID;
    private String product_Name;
    private String product_Size;
    private int available_Quantity;
    private int product_Price;*/


    public PurProducts(String product_ID, String product_Name, String product_Size, Integer available_Quantity, Integer product_Price){
        super();
        this.product_ID = new SimpleStringProperty(product_ID);
        this.product_Name = new SimpleStringProperty(product_Name);
        this.product_Size = new SimpleStringProperty(product_Size);
        this.available_Quantity = new SimpleIntegerProperty(available_Quantity);
        this.product_Price = new SimpleIntegerProperty(product_Price);

    }

   /* public PurProducts(String product_ID, String product_Name, String product_Size, Integer available_Quantity, Integer product_Price){
        this.product_ID = product_ID;
        this.product_Name = product_Name;
        this.product_Size = product_Size;
        this.available_Quantity =  available_Quantity;
        this.product_Price = product_Price;

    }*/


    public String getProduct_ID(){
        return product_ID.get();
    }
    public String getProduct_Name(){
        return product_Name.get();
    }
    public String getProduct_Size(){
        return product_Size.get();
    }
    public Integer getAvailable_Quantity(){
        return available_Quantity.get();
    }
    public Integer getProduct_Price(){
        return product_Price.get();
    }

}
