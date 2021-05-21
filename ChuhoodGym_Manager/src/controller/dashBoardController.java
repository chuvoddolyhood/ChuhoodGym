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
    
    private String monthTracking;
    private String yearTracking;
    public void getMonthAndYearTracking(String month, String year){
        monthTracking=month;
        yearTracking=year;
        
    }
    
    
    private void getNumberOfCustomerInTheMonth(){
        int[] numberCustomerOfWeek= new int[7]; //Luu so luong khach hang theo thu trong tuan goi tu database
        String[] dayOfWeekDTB= new String[7]; //Luu ten thu trong tuan goi tu database
        String[] date = {"Fri", "Mon", "Sat", "Sun", "Thu", "Tue", "Wed"}; //Dung de doi chieu

        String query="SELECT ID_Weekdays, COUNT(ID_Customer) AS So_luong_KH FROM Weekdays WHERE MONTH(Date_Workout)=? "
                + "AND YEAR(Date_Workout)=? GROUP BY ID_Weekdays ORDER BY ID_Weekdays ASC;";           
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, monthTracking);
            ps.setString(2, yearTracking);
            
            ResultSet rs = ps.executeQuery();
            
            int i=0; //Bien chay ngay trong CSDL dayOfWeek[]
            int j=0; //Bien chay ngay doi chieu String[] date
            int old_j = 0; //Bien luu tam cua bien j cu
            while (rs.next()) { //rs se chay den cuoi
                dayOfWeekDTB[i]=rs.getString("ID_Weekdays");
                //Xu ly ngay trong CSDL phai khop voi ngay xuat ra tren barchart
                //Tranh truong hop co 1 ngay ko co khach ma gan nham vao ngay khac
                do{
                    if(dayOfWeekDTB[i].equals(date[j])){
                        numberCustomerOfWeek[i]=rs.getInt("So_luong_KH");
                        old_j=j;
                    }
                    else j++;
                }while(!dayOfWeekDTB[i].equals(date[old_j]));

                i++;
                j++;
            }
            
        }catch(Exception ex){
                System.out.println(ex);
        }
        fri=numberCustomerOfWeek[0];
        mon=numberCustomerOfWeek[1];
        sat=numberCustomerOfWeek[2];
        sun=numberCustomerOfWeek[3];
        thu=numberCustomerOfWeek[4];
        tue=numberCustomerOfWeek[5];
        wed=numberCustomerOfWeek[6];
    }
    
    private int mon, tue, wed, thu, fri, sat, sun;
    public void getDay(){
        getNumberOfCustomerInTheMonth();
        barchart chart= new barchart();
        chart.pushNumberIntoBarChart(mon, tue, wed, thu, fri, sat, sun);
    }
}
