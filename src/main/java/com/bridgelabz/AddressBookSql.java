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
            statement.executeUpdate("insert into addressBook(firstname,lastname,address,city,state,zip,phonenumber,email) \n" +
                    "values ('sarfaraz','khan','Hosa oni','Mumbai','Maharashtra',58009,'8217468990','praju@123'),\n" +
                    "('Paru','Hanasi','Gandhi nagar','Dharwad','karanataka',58001,'8277498990','paru@123'),\n" +
                    "('chinnu','Hanasi','Vidya Giri','Pune','Maharashtra',58007,'7797468990','chinnu@123'),\n" +
                    "('Pratham','Hanasi','Hosa oni','Manali','Himachal Pradesh',58008,'8217468990','pratham@123'),\n" +
                    "('Paarth','Hanasi','Nekar oni','Dharwad','Karanataka',58006,'9997468990','paarth@123') ");
            ResultSet resultSet =statement.executeQuery("select * from addressBook");
            while(resultSet.next()){
                System.out.println("firstname:"+resultSet.getString("firstname"));
                System.out.println("lastname:"+resultSet.getString("lastname"));
                System.out.println("address:"+resultSet.getString("address"));
                System.out.println("city:"+resultSet.getString("city"));
                System.out.println("state:"+resultSet.getString("state"));
                System.out.println("zip:"+resultSet.getInt("zip"));
                System.out.println("phoneNumber:"+resultSet.getString("phoneNumber"));
                System.out.println("email:"+resultSet.getString("email"));
            }
        } catch (Exception e) {

        }
    }
}
