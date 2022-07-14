package bus_managment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static bus_managment_system.Main.sc;
import static bus_managment_system.Main.signupLogin;

public class BusOperations {

    List<Bus> busList = new ArrayList<>();

    public void addBus(String busNumber, String operatorName, String source, String destination, int fare){
        Bus bus = new Bus(busNumber,operatorName,source,destination,fare);
        busList.add(bus);
    }
    public void searchBus(String source, String destination){
        System.out.println("BUs Search");
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busmanagement", "postgres", "Garvit");

            //Fetching the data from database and database name is 'Businfo';
            String query="select * from Businfo where source='"+source+"' and destination='"+destination+"';";
            PreparedStatement pstmt = connection.prepareStatement(query);

            ResultSet rs=pstmt.executeQuery();// Contain the result data;
            int count=0;
            String user="";
            String busno="";
            int leftTicket=0;
            while(rs.next()){
                count++;
                System.out.println("Number of Bus Available "+count);
                busno=rs.getString(1);
                leftTicket=rs.getInt(5);
                System.out.println("'Bus Number= "+rs.getString(1)
                        +"'"+" | "+"'Bus operator= "+rs.getString(2)
                        +"'"+" | "+"'Source= "+rs.getString(3)
                        +"'"+" | "+"'Destination= "+rs.getString(4)
                        +"'"+" | "+"'Tickets= "+rs.getInt(5)
                        +"'"+" | "+"FareCharges= "+rs.getInt(6));

            }
            System.out.println("NO of Ticket : ");
            int n=sc.nextInt();
            if(n<leftTicket) {
                leftTicket = leftTicket - n;
            }
            else{
                System.out.println("Number of Seat Is Not Available");
            }
            String query1="update Businfo set ticket='"+leftTicket+"' where busnumber='"+busno+"';";
            pstmt = connection.prepareStatement(query1);
            pstmt.executeUpdate();
            System.out.println(user +"Congratulation..!!!! Your  Bus IS "+ busno +" Number Of bus Ticket is "+n);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("techanical");
        }

    }


    public void busDeatails(){

        System.out.println("AVAILABLE BUSES");
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busmanagement", "postgres", "Garvit");

            String query="select * from Businfo;";
            PreparedStatement pstmt = connection.prepareStatement(query); // Executing parameterized query;

            ResultSet rs=pstmt.executeQuery();
            int count=0;
            String user="";
            while(rs.next()){
                System.out.println("'Bus Number= "+rs.getString(1)
                        +"'"+" | "+"'Bus operator= "+rs.getString(2)
                        +"'"+" | "+"'Source= "+rs.getString(3)
                        +"'"+" | "+"'Destination= "+rs.getString(4)
                        +"'"+" | "+"'Tickets= "+rs.getInt(5)
                        +"'"+" | "+"FareCharges= "+rs.getInt(6));

            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("techanical");
        }

    }
}
