package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectCusDB {
    public Connection connection;

    public Connection getConnection() throws SQLException {

        String dbName="jfs application";
        String customerName="root";
        //String email = "";
        String password = "";
        //String address = "";
       // String tel = "";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,customerName,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return connection;

    }
}

