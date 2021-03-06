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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tran Nhan Nghia
 */
public class adminController {
    public String getCurrentDayFromSystem(){
        String currentdate;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        currentdate = dateFormat.format(cal.getTime());
        return currentdate;
    }
    
    private int sumMoney;
    private int countContract;
    private boolean loadMoneyAndContract(){
        boolean check=false;
        try{
            String queryFindPass="SELECT SUM(Cost) AS Tong_Tien, COUNT(*) AS Tong_So_HD FROM Gym_Contract WHERE Date_Enroll=?;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(queryFindPass);
            ps.setString(1, getCurrentDayFromSystem());
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                check=true;
                sumMoney=rs.getInt(1);
                countContract=rs.getInt(2);   
            }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
    
    private int numberOfPeopleDaily;
    private boolean loadCustomer(){
        boolean check=false;
        try{
            String queryFindPass="SELECT COUNT(*) AS So_Luong_Nguoi FROM Weekdays WHERE Date_Workout=?;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(queryFindPass);
            ps.setString(1, getCurrentDayFromSystem());
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                check=true;
                numberOfPeopleDaily=rs.getInt(1);               
            }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
    
    public void reloadForm(JLabel labelMoney, JLabel labelCustomer, JLabel labelContract){
        if(loadMoneyAndContract()){
            labelMoney.setText(String.valueOf(sumMoney/1000));
            labelContract.setText(String.valueOf(countContract));
        }
        if(loadCustomer()) labelCustomer.setText(String.valueOf(numberOfPeopleDaily));
    }
    
    private int moneyYear;
    private boolean getSumMoneyInYear(String year){
        boolean check=false;
        try{
            String queryFindPass="SELECT SUM(Cost) AS Tong_Tien FROM Gym_Contract WHERE YEAR(Date_Enroll)=?;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(queryFindPass);
            ps.setString(1, year);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                check=true;
                moneyYear=rs.getInt(1);               
            }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
    
    private int moneyMonth;
    private boolean getSumMoneyInMonthOfYear(String month, String year){
        boolean check=false;
        try{
            String queryFindPass="SELECT SUM(Cost) AS Tong_Tien FROM Gym_Contract WHERE MONTH(Date_Enroll)=? AND YEAR( Date_Enroll)=?;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(queryFindPass);
            ps.setString(1, month);
            ps.setString(2, year);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                check=true;
                moneyMonth=rs.getInt(1);             
            }           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return check;
    }
    
    public void getMoneyRevenue(String month, String year, JLabel labelMoneyRevenue){
        if(month.equals("*")){
            if(getSumMoneyInYear(year))
                labelMoneyRevenue.setText(String.valueOf(moneyYear) + " VND");
        }
        else{
            if(getSumMoneyInMonthOfYear(month, year))
                labelMoneyRevenue.setText(String.valueOf(moneyMonth) + " VND");
        }   
    }
    
    public void setMoneyAverage(JLabel lblTotalAverage, String year){
        getSumMoneyInYear(year);
        lblTotalAverage.setText(String.valueOf((float)moneyYear/12)+" VND");
    }
    
    //Lay so luong KH trong cac thang tu CSDL
//    private int[] customerPerMonth=new int[10000];
    private final ArrayList<Integer> customerPerMonth = new ArrayList<>();
    private void getNumberOfCustomerFromDatabase(){
        String year=getCurrentDayFromSystem().substring(0, 4);
        int numberOfCustomer = 0;
        
        
        //Chay bien month de lay so luong 12 thang
        for(int month=1;month<=12;month++){
            try{
                String queryFindPass="SELECT COUNT(*) AS So_Luong_KH FROM Weekdays WHERE MONTH(Date_Workout)=? AND YEAR( Date_Workout)=?;";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(queryFindPass);
                ps.setInt(1, month);
                ps.setString(2, year);
                ResultSet rs=ps.executeQuery();

                while(rs.next()){
                    numberOfCustomer=rs.getInt(1);             
                }           
            }catch(Exception ex){
                ex.printStackTrace();
            }
            customerPerMonth.add(numberOfCustomer);
        }
        
        
    }
    int mon=4; int tue=2; int wed=1; int thu=7; int fri=9; int sat=3; int sun=3;
    public void showLineChart(){
        getNumberOfCustomerFromDatabase();
        //Chuyen so luong KH lay duoc tu CSDL sang Line Chart
        lineChart lc = new lineChart();
        lc.pushNumberOfCustomerToLineChart(customerPerMonth);  
    }
}
