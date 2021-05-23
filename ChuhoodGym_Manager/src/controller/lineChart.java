/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Tran Nhan Nghia
 */
public class lineChart {
    public static JFreeChart createChart(){
        JFreeChart lineChart = ChartFactory.createLineChart(
            "The Number Of Customers Chart",
            "Month", "Peoples",
            createDataset(), PlotOrientation.VERTICAL, false, false, false);
    
        lineChart.setBackgroundPaint(new Color(198,198,198));
        
        return lineChart;
    }

   private static DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue( 15 , "So nguoi" , "1" );
      dataset.addValue( 30 , "So nguoi" , "2" );
      dataset.addValue( 60 , "So nguoi" ,  "3" );
      dataset.addValue( 120 , "So nguoi" , "4" );
      dataset.addValue( 240 , "So nguoi" , "5" );
      dataset.addValue( 300 , "So nguoi" , "6" );
      dataset.addValue( 300 , "So nguoi" , "7" );
      dataset.addValue( 300 , "So nguoi" , "8" );
      dataset.addValue( 300 , "So nguoi" , "9" );
      dataset.addValue( 300 , "So nguoi" , "10" );
      dataset.addValue( 300 , "So nguoi" , "11" );
      dataset.addValue( 300 , "So nguoi" , "12" );

      return dataset;
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
