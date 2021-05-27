/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tran Nhan Nghia
 */
public class manageAccountEmployeeController {
    public void loadInfoAccountEmployee(JTable table){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            String query="SELECT E.ID_Employee, E.Name_Employee, A.Username, A.Password, W.Title_Work\n" +
                            "FROM Employee E JOIN Account A ON A.ID_Employee=E.ID_Employee\n" +
"				JOIN Work W ON E.ID_Work=W.ID_Work";
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel m=new DefaultTableModel(new Object[]{"ID","Name", "User Name", "Password", "Work"}, 0);
               table.setModel(m);
            while (rs.next()) {
                ((DefaultTableModel)table.getModel()).addRow(new Object[]{
                    rs.getString(1), 
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getString(4), 
                    rs.getString(5),
                }); 
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void findNameEmployee(String employeeID, String nameEmployee, String workEmployee){
        System.out.println(employeeID + nameEmployee+ workEmployee);
        
        String name = null;
        String titleWork = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            String query="SELECT Name_Employee,  W.Title_Work\n" +
                            "FROM Employee E JOIN Work W ON E.ID_Work = W.ID_Work\n" +
                            "WHERE ID_Employee=?";
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ps.setString(1, employeeID);
            while (rs.next()) {
                name=rs.getString("Name_Employee");
                titleWork=rs.getString("Title_Work");
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        nameEmployee=name;
        workEmployee=titleWork;
        System.out.println(nameEmployee+ workEmployee);
    }
    
}
