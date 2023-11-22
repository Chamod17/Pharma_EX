package pharma_ex;


import java.sql.*;

public class Db {
    public static Connection getCon;

    public  Connection getCon(){

        String URL = "jdbc:mysql://localhost/mysql/pharmacy_db";
        String user= "root";
        String password = "";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             getCon = DriverManager.getConnection(URL,user,password);

        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        return getCon();
    }

}
