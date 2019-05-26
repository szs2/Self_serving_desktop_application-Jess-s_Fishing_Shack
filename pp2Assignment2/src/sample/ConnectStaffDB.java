package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectStaffDB {
    public Connection sconnection;

    public Connection getConnection() throws SQLException {

        String dbName="jfs application";
        String customerName="root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            sconnection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,customerName,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        /*} catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }*/
        return sconnection;

    } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}

