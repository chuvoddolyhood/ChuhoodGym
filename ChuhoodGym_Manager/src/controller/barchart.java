package controller;



import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Nhan Nghia
 */
public class barchart{
    public JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "The Average Number Of Customers Chart",
                "Day of week", "Peoples",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
       
        
        barChart.setBackgroundPaint(new Color(198,198,198));
        barChart.setBorderVisible(false);
        barChart.setBorderPaint(new Color(54, 63, 73));
        barChart.getCategoryPlot().setBackgroundPaint(new Color(54, 63, 73));
        barChart.getCategoryPlot().setDomainGridlinePaint(new Color(54, 63, 73));
        barChart.getCategoryPlot().setDomainGridlinesVisible(false);
        barChart.getCategoryPlot().setOutlinePaint(new Color(54, 63, 73));
        
        return barChart;
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(monCus, "Số người", "Mon");
        dataset.addValue(tueCus, "Số người", "Tue");
        dataset.addValue(wedCus, "Số người", "Wed");
        dataset.addValue(thuCus, "Số người", "Thu");
        dataset.addValue(friCus, "Số người", "Fri");
        dataset.addValue(satCus, "Số người", "Sat");
        dataset.addValue(sunCus, "Số người", "Sun");
        
        return dataset;
    }
    
    public void setupBarChart(JPanel panel) {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(panel.getWidth(), panel.getHeight()));
        chartPanel.setBackground(Color.BLACK);
        
        
        panel.removeAll();
        panel.setLayout(new CardLayout());
        panel.add(chartPanel);
        panel.validate();
        panel.repaint();
    }
    
    //Sau khi bam nut show chart
    private static int monCus, tueCus, wedCus, thuCus, friCus, satCus, sunCus;
    
        public void pushNumberIntoBarChart(int mon, int tue, int wed, int thu, int fri, int sat, int sun){
        monCus=mon;
        tueCus=tue;
        wedCus=wed;
        thuCus=thu;
        friCus=fri;
        satCus=sat;
        sunCus=sun;
        
    }
    
    
    
   

    
    
    
    
    
//    public static void main(String[] args) {
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
