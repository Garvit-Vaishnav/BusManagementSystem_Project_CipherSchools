package bus_managment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SignupLogin {
    static  String user="";
    public String signup(String name, long phone, String email, String state, String city, String street, String password){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busmanagement", "postgres", "Garvit");

            //Storing the data in database and database name is 'details';
            String query="Insert into details (name, email, street, city, state, password,phone) values (?,?,?,?,?,?,?);";
            PreparedStatement pstmt = connection.prepareStatement(query);


            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,street);
            pstmt.setString(4,city);
            pstmt.setString(5,state);
            pstmt.setString(6,password);
            pstmt.setLong(7,phone);


            pstmt.executeUpdate();
            System.out.println("Data updated");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Not Updated");
        }
       return "signup successfull";
    }

    public String login(String email, String password){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busmanagement", "postgres", "Garvit");

            //Fetching the data from database and database name is 'details';
            String query="select * from details where email='"+email+"' and password='"+password+"';";
            PreparedStatement pstmt = connection.prepareStatement(query);

            ResultSet rs=pstmt.executeQuery();
            int count=0;
            String user="";
            while(rs.next()){
                user=rs.getString(1);
                count++;

            }

            if(count==1) {
                return user+" Sucessfuly login";
            }
            else{
                return "email and password are wrong";
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("techanical");
        }
        return "Glitch";
    }
}
