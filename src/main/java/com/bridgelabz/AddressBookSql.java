package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressBookSql {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/addressbookServices?useSSL=false";
        String username = "root";
        String password = "123456789";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath!", e);
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection done successful!!" + con);
            Statement statement=con.createStatement();
            //  statement.executeUpdate("select firstname,city from addressBook order by firstname ASC");
            ResultSet resultSet =statement.executeQuery("select * from addressbook where Type='Family'");
            while(resultSet.next()){
                System.out.println("firstname:"+resultSet.getString("firstname"));
                System.out.println("lastname:"+resultSet.getString("lastname"));
                System.out.println("address:"+resultSet.getString("address"));
                System.out.println("city:"+resultSet.getString("city"));
                System.out.println("state:"+resultSet.getString("state"));
                System.out.println("zip:"+resultSet.getInt("zip"));
                System.out.println("phoneNumber:"+resultSet.getString("phoneNumber"));
                System.out.println("email:"+resultSet.getString("email"));
                System.out.println("Type:"+resultSet.getString("Type"));
            }
        } catch (Exception e) {


        }
    }
}
