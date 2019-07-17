/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jeonghoon
 */
public class Database {
    // MySQL Database
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/LibraryJH?serverTimezone=UTC";
    
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "root";

    // Database connection
    private Connection connect;

//    public Database() throws SQLException, ClassNotFoundException {
//        connectDB();
//    }
   
    public void connectDB() throws SQLException, ClassNotFoundException {
        Class.forName(MYSQL_DRIVER);
        connect = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
    }

    public void closeDB() throws SQLException {
        connect.close();
    }
    
    public void getUserList() {
        try {
            Statement stmt = connect.createStatement();
            
            String query = String.format("select * from UsersView");
            ResultSet resultSet = stmt.executeQuery(query);

            while(resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String family = resultSet.getString(3);
                String age = resultSet.getString(4);

                System.out.printf("%s, %s, %s, %s", id, name, family, age);
            }            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
