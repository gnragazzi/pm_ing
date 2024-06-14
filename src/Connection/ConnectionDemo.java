/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author gera
 */
public class ConnectionDemo {
    String userName,password,url,driver;
    Connection con;
    Statement st;

public ConnectionDemo() {
        userName="root";
        password="usuario";
        url="jdbc:mysql://localhost:3306/mydb";
        driver="com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, userName, password);
            st=con.createStatement();
            System.out.println("Connection is successful");
            System.out.println(con);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
    public Connection getConexión()
    {
        return con;
    }
}