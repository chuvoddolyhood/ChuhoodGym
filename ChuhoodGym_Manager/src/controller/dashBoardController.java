/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Tran Nhan Nghia
 */
public class dashBoardController {
    private int countCusAttendant;
    private String idCustomer;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendarStart, calendarCurrent;
    
    public void getIDCustomerCheckOut(String txtIDCheckout){
        idCustomer=txtIDCheckout;  
    }
        
    //Get current day from database table Weekday
    //If it has available then it be must checked out
    //Besides, confirm dont check out
    private Date getCurrentDate(){
        Date currentdatefromdatabase=null;
        String query="SELECT MAX(Date_Workout) AS currentdate FROM Weekdays WHERE ID_Customer=?;";
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, idCustomer);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    currentdatefromdatabase=rs.getDate("currentdate");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        return currentdatefromdatabase;
    }
    
    private String getIDContract(){
        String IDContract=null;
        String query="SELECT MAX(ID_Contract) IDContract FROM Gym_Contract WHERE ID_Customer=?;";
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, idCustomer);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    IDContract=rs.getString("IDContract");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        return IDContract;
    }
    
    private Date getDateEndContract(){
        Date dateEndFromDatabase=null;
        String query="SELECT Date_End AS dateEnd FROM Gym_Contract WHERE ID_Contract=?;";
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, getIDContract());

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    dateEndFromDatabase=rs.getDate("dateEnd");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        return dateEndFromDatabase;
    }
    

    private String setStatus(){
        String status=null;

        //current < end -> -1
        //current > end -> 1
        //current = end -> 0
        if(getCurrentDate().compareTo(getDateEndContract())==-1)
            status="Live";
        else status="Expire";
        
        return status;
    }
    
    public void updateStatusContract(){
        String query="UPDATE Gym_Contract SET status=? WHERE ID_Contract=?";           
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, setStatus());
            ps.setString(2, getIDContract());

            ps.executeUpdate();
            
        }catch(Exception ex){
                System.out.println(ex);
        }
    }
}
