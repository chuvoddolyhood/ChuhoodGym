/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Tran Nhan Nghia
 */
public class lineChart {
    public JFreeChart createChart(){
        JFreeChart lineChart = ChartFactory.createLineChart(
            "The Number Of Customers Chart",
            "Month", "Peoples",
            createDataset(), PlotOrientation.VERTICAL, false, false, false);
    
        lineChart.setBackgroundPaint(new Color(198,198,198));
        
        return lineChart;
    }

   private CategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue( thang1 , "So nguoi" , "1" );
//      dataset.addValue( month[1] , "So nguoi" , "2" );
//      dataset.addValue( month[2] , "So nguoi" , "3" );
      dataset.addValue( thang4 , "So nguoi" , "4" );
      dataset.addValue( thang5 , "So nguoi" , "5" );
//      dataset.addValue( month[5] , "So nguoi" , "6" );
//      dataset.addValue( month[6] , "So nguoi" , "7" );
//      dataset.addValue( month[7] , "So nguoi" , "8" );
//      dataset.addValue( month[8] , "So nguoi" , "9" );
//      dataset.addValue( month[9] , "So nguoi" , "10" );
//      dataset.addValue( month[10] , "So nguoi" , "11" );
      dataset.addValue( 100 , "So nguoi" , "12" );

//      for(int i=0;i<12;i++){

           System.out.println(thang1 +""+thang2 +""+thang3 +""+thang4 +""+thang5);
//        }
      
      return dataset;
   }
   
//    private static int month[] = new int[12];
    public static int thang1,thang2,thang3, thang4, thang5;
    //Chuyen so luong KH lay duoc tu CSDL sang Line Chart
    public void pushNumberOfCustomerToLineChart(ArrayList<Integer> customerPerMonth){
//        for(int i=0;i<customerPerMonth.size();i++){
//           month[i]=customerPerMonth.get(i); 
            thang1=customerPerMonth.get(0);
            thang2=customerPerMonth.get(1); 
            thang3=customerPerMonth.get(2); 
            thang4=customerPerMonth.get(3); 
            thang5=customerPerMonth.get(4); 
//        }
//        for(int i=0;i<12;i++){
           System.out.println(thang1 +""+thang2 +""+thang3 +""+thang4 +""+thang5);
//        }
    }
    
   
    public void setupLineChart(JPanel panel) {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(panel.getWidth(), panel.getHeight()));
        chartPanel.setBackground(Color.BLACK);
        
        
        panel.removeAll();
        panel.setLayout(new CardLayout());
        panel.add(chartPanel);
        panel.validate();
        panel.repaint();
    }
   
   
//       public static void main(String[] args) {
//        ChartPanel chartPanel = new ChartPanel(createChart());
//        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
//        JFrame frame = new JFrame();
//        frame.add(chartPanel);
////        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
//        frame.setSize(600, 400);
////        frame.setLocationRelativeTo(null);
////        frame.setResizable(false);
//        frame.setVisible(true);
//    }
    
}
