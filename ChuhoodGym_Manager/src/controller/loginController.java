/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import chuhoodgym_manager.DashBoard;
import chuhoodgym_manager.Login;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Nhan Nghia
 */
public class loginController extends Login{
    private String name;
    private char[] pass;
    
    //Lay username va pass tu form login
    public void getNamePass(String username, char[] password){
        name=username;
        pass=password;
    }
    
    //Kiem tra thong tin nhap day du hay ko
    private boolean confirmInfo(){
        boolean check=true;
        if(pass.length==0){
            JOptionPane.showMessageDialog(rootPane, "Chua nhap password");
            check=false;
        }
        else if(name.equals("")==true){
            JOptionPane.showMessageDialog(rootPane, "Chua nhap username");
            check=false;
        }
        return check;
    }
    
    //Gia ma mat khau
    private boolean decodePassword(String passwordFromDatabase){
        boolean checkPass=true;
        char[] passWordFromInput=pass; //Mat khau bi ma hoa lay tu form
        char[] passWordFormDatabaseToChar = passwordFromDatabase.toCharArray(); //Mat khau lay tu database chuyen sang char
        
        if (passWordFromInput.length != passWordFormDatabaseToChar.length) {
            checkPass = false;
        } else {
            checkPass = Arrays.equals (passWordFromInput, passWordFormDatabaseToChar);
        }
        
        //Zero out the password.
        Arrays.fill(passWordFormDatabaseToChar,'0');

        return checkPass;
    }
    
    private String getPassword; //Lay password dung 
    //Lay password tu csdl sau khi nhap username va kiem tra mat khau co dung hay khong
    private boolean isPasswordCorrect() {
        boolean isCorrect = true;
        String userName=name;
        String passwordFromDatabase=null;
        try{
            String queryFindPass="SELECT Password FROM Account WHERE Username=?;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(queryFindPass);
            ps.setString(1, userName);
            ResultSet rs=ps.executeQuery();
            
            //Co Bug: Neu nhap khong dung username thi resultset se rong
            
            if(rs.next()){
                passwordFromDatabase=rs.getString("Password");
                if(rs.wasNull())
                    JOptionPane.showMessageDialog(rootPane, "Tai khoan khong ton tai");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        getPassword=passwordFromDatabase;
        
        //Giai ma password va kiem tra
        if(decodePassword(passwordFromDatabase)==false){
            isCorrect = false;
            JOptionPane.showMessageDialog(rootPane, "Sai mat khau");
        }
    
    return isCorrect;
}
        
    public void login(){
        String titleWork = null;
        if(confirmInfo()==true){
            if(isPasswordCorrect()==true){
                //Xu ly kiem tra neu nguoi dung dang nhap user va pass chinh xac la admin thi moi login vao
                //Con khong phai thi khong vao duoc
                
                String query="SELECT W.Title_Work FROM Employee E JOIN Account A ON E.ID_Employee=A.ID_Employee "
                    + "JOIN Work W ON E.ID_Work=W.ID_Work WHERE A.Username=? AND A.Password=?;";
                String userName=name;
                String inputPasswordToDatabase = getPassword;
                try{
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                    Connection con=DriverManager.getConnection(dbURL);
                    PreparedStatement ps=con.prepareStatement(query);
                    ps.setString(1, userName);
                    ps.setString(2,inputPasswordToDatabase);
                    
                    ResultSet rs=ps.executeQuery();
                    while(rs.next())
                            titleWork=rs.getString("Title_Work");
                }catch(Exception ex){
                    System.out.println(ex);
                }
                if(titleWork.equals("Quan ly")==true){
                    DashBoard db=new DashBoard();
                    db.setVisible(true);
                    db.setUserNameAdmin(name);
//                    super.setVisible(false);
                    Login l = new Login();
                    l.setVisible(false);
                }   
                else JOptionPane.showMessageDialog(rootPane, "Ban khong phai quan ly");
            }
        }
        else JOptionPane.showMessageDialog(rootPane, "Dang nhap Khong Thanh Cong");
    }
        
    public void keypressedLogin(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           login();
        }
    } 
}
