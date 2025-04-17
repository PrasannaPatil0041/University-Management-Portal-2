package universitiess.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//This Class is very important as it establish Connection with sql using jdbc
//if creat object of this class in any other class it will establish connection with sql

public class Conn {
    
    Connection c;
    Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Prasanna@123");
            s = c.createStatement();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}