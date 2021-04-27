/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuhoodgym_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tran Nhan Nghia
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        
        //set full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Load du lieu len bang
        loadInfoCustomer();
       
        //Set auto ID
        setID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        rdbNu = new javax.swing.JRadioButton();
        rdbNam = new javax.swing.JRadioButton();
        spnDOB = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txtWork = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtFindPhoneNumber = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        jLabel3.setText("Phone Number");

        jLabel4.setText("DOB");

        jLabel5.setText("Sex");

        txtID.setFocusable(false);

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nu");
        rdbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbNam);
        rdbNam.setText("Nam");
        rdbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNamActionPerformed(evt);
            }
        });

        spnDOB.setModel(new javax.swing.SpinnerDateModel());
        spnDOB.setEditor(new javax.swing.JSpinner.DateEditor(spnDOB, "dd/MM/YYYY"));

        jLabel6.setText("Nghe nghiep");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbNu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addComponent(txtID))
                            .addComponent(rdbNam))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(spnDOB)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtWork, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdbNam)
                    .addComponent(jLabel6)
                    .addComponent(txtWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rdbNu)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel12.setText("Total");

        txtTotal.setFocusable(false);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtFindPhoneNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFindPhoneNumberMouseClicked(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnClear)
                                    .addComponent(btnModify)
                                    .addComponent(btnDel))
                                .addGap(307, 307, 307)
                                .addComponent(txtFindPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnFind)))
                        .addGap(0, 334, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFindPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFind)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnAdd)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(btnModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(202, 202, 202))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadInfoCustomer() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            String query="SELECT * FROM Customer;";
            Connection con=DriverManager.getConnection(dbURL);
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel m=new DefaultTableModel(new Object[]{"ID","Name", "Sex", "DOB", "Phone Number","Nghe nghiep"}, 0);
               tblCustomer.setModel(m);
            while (rs.next()) {
                ((DefaultTableModel)tblCustomer.getModel()).addRow(new Object[]{
                    rs.getString(1), 
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getDate(4), 
                    rs.getString(5),
                    rs.getString(6),
                }); 
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        //set Total Employee
        setTotal();
    }

    private void setTotal() {
        int sum=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            String query="SELECT COUNT(*) AS SUM_Cus FROM Customer;";
            Connection connector=DriverManager.getConnection(dbURL);
            PreparedStatement ps=connector.prepareStatement(query);
            ResultSet sum_Emp=ps.executeQuery();
            while(sum_Emp.next()){
                sum=sum_Emp.getInt("SUM_Cus");
            }
        }catch(Exception ex){
            sum=0;
        }
        txtTotal.setText(String.valueOf(sum));
    }

    private void setID() {
        String id=null;
        String ancestors; //Tien to C
        int numberID; //so duoi 00x || 0xx
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
            String query="SELECT MAX(ID_Customer) AS MAX_ID FROM Customer;";
            Connection connector=DriverManager.getConnection(dbURL);
            PreparedStatement ps=connector.prepareStatement(query);
            ResultSet rs_STT=ps.executeQuery();
            while(rs_STT.next()){
                id=rs_STT.getString("MAX_ID");
            }
        }catch(Exception ex){
            numberID=0;
        }
        
        ancestors=id.substring(0, 1); //C
        numberID=Integer.valueOf(id.substring(1, 4)); //number
        
        if(numberID<9) txtID.setText(ancestors +"00"+ String.valueOf(numberID+1));
        else if(numberID<99) txtID.setText(ancestors +"0"+ String.valueOf(numberID+1));
        else txtID.setText(ancestors + String.valueOf(numberID+1));
    }
    
    private boolean confirmInfoCustomer(){
        boolean check=true;
        if(txtName.getText().equals("")==true || txtPhoneNumber.getText().equals("")==true){
            JOptionPane.showMessageDialog(rootPane, "Phai nhap day du cac thong tin co ban nhu: Ten, So dien thoai");
            check=false;
        }
        return check;
    }
    
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        String id=txtID.getText();
        String name=txtName.getText();
        int confirm=JOptionPane.showConfirmDialog(rootPane, "Ban co chac muon xoa khach hang "+name+" khoi danh sach khong?","",JOptionPane.YES_NO_OPTION);
        if(confirm== JOptionPane.YES_OPTION){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                String query="DELETE Customer WHERE ID_Customer=? AND Name_Customer=?;";
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, id);
                ps.setString(2, name);

                ps.executeUpdate();
            }catch(Exception ex){
                System.out.println(ex);
            }
            btnClearActionPerformed(evt);
            loadInfoCustomer();
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(confirmInfoCustomer()==true){
            String query="INSERT INTO Customer VALUES(?,?,?,?,?,?);";
            String id=txtID.getText();
            String name=txtName.getText();
            String sex=gioiTinh;
            String dob=new SimpleDateFormat("yyyy-MM-dd").format(spnDOB.getValue());
            String phoneNumber=txtPhoneNumber.getText();
            String work=txtWork.getText();
            
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, sex);
                ps.setString(4, dob);
                ps.setString(6, phoneNumber);
                ps.setString(5, work);
                
                ps.executeUpdate();
            }catch(Exception ex){
                System.out.println(ex);
            }
            btnClearActionPerformed(evt);
            loadInfoCustomer();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private String gioiTinh;
    private void rdbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNamActionPerformed
        gioiTinh="Nam";
    }//GEN-LAST:event_rdbNamActionPerformed

    private void rdbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNuActionPerformed
        gioiTinh="Nu";
    }//GEN-LAST:event_rdbNuActionPerformed

    Calendar cal=Calendar.getInstance();
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        setID();
        txtName.setText("");
        rdbNam.setSelected(true);
        spnDOB.setValue(cal.getTime());
        txtPhoneNumber.setText("");
        txtWork.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        String id=txtID.getText();
        String name=txtName.getText();
        String sex=gioiTinh;
        String dob=new SimpleDateFormat("yyyy-MM-dd").format(spnDOB.getValue());
        String phoneNumber=txtPhoneNumber.getText();
        String work=txtWork.getText();
        
        int confirm=JOptionPane.showConfirmDialog(rootPane, "Ban co chac muon chinh sua thong tin khong?","",JOptionPane.YES_NO_OPTION);
        if(confirm== JOptionPane.YES_OPTION){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                String query="UPDATE Customer SET Name_Customer=?, Sex=?,DOB=?,PhoneNumber_Customer=?, Work=? WHERE ID_Customer=?; ";
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(query);
                
                ps.setString(1, name);
                ps.setString(2, sex);
                ps.setString(3, dob);
                ps.setString(4, phoneNumber);
                ps.setString(5, work);
                ps.setString(6, id);

                ps.executeUpdate();
            }catch(Exception ex){
                System.out.println(ex);
            }
            btnClearActionPerformed(evt);
            loadInfoCustomer();
        } 
    }//GEN-LAST:event_btnModifyActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        int selectedIndex=tblCustomer.getSelectedRow();
        txtID.setText(tblCustomer.getValueAt(selectedIndex, 0)+"");
        txtName.setText(tblCustomer.getValueAt(selectedIndex, 1)+"");
        
        if(tblCustomer.getValueAt(selectedIndex, 2).equals("Nam"))
            rdbNam.setSelected(true);
        else rdbNu.setSelected(true);
        

//        spnDOB.setValue(tblEmployee.getValueAt(selectedIndex, 3)+"");
//        System.out.println(tblEmployee.getValueAt(selectedIndex, 3));
//        System.out.println(cal.getTime());
        //spnDOB.setValue(cal.getTime());
        
        txtPhoneNumber.setText(tblCustomer.getValueAt(selectedIndex, 4)+"");
        txtWork.setText(tblCustomer.getValueAt(selectedIndex, 5)+"");
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void txtFindPhoneNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindPhoneNumberMouseClicked
        loadInfoCustomer();
    }//GEN-LAST:event_txtFindPhoneNumberMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String id=null;
        if(txtFindPhoneNumber.getText().equals("")==false){
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbURL="jdbc:sqlserver://MSI\\SQLEXPRESS:1433; databaseName=ChuhoodGym; user=test; password=1234567890"; 
                String query="SELECT ID_Customer FROM Customer WHERE PhoneNumber_Customer=?;";
                Connection con=DriverManager.getConnection(dbURL);
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, txtFindPhoneNumber.getText());
                ResultSet rs_STT=ps.executeQuery();
                while(rs_STT.next()){
                    id=rs_STT.getString("ID_Customer");
                }
                int numberID=Integer.valueOf(id.substring(1, 4)); //number
                int indexCurrentRow=numberID-1;
                tblCustomer.getSelectionModel().addSelectionInterval(indexCurrentRow,indexCurrentRow);
                //tblEmployee.selectAll(); Lay toan bo
               
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Khong duoc co chu cai");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Ban chua nhap thong tin tim kiem");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnModify;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JSpinner spnDOB;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtFindPhoneNumber;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtWork;
    // End of variables declaration//GEN-END:variables
}