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
    public JFreeChart createChart() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "The Number Of Customers In The Year",
                "Month", "Peoples",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
       
        
        lineChart.setBackgroundPaint(new Color(198,198,198));
//        barChart.setBorderVisible(false);
//        barChart.setBorderPaint(new Color(54, 63, 73));
//        barChart.getCategoryPlot().setBackgroundPaint(new Color(54, 63, 73));
//        barChart.getCategoryPlot().setDomainGridlinePaint(new Color(54, 63, 73));
//        barChart.getCategoryPlot().setDomainGridlinesVisible(false);
//        barChart.getCategoryPlot().setOutlinePaint(new Color(54, 63, 73));
        
        return lineChart;
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(month[0], "Số người", "Jan");
        dataset.addValue(month[1], "Số người", "Feb");
        dataset.addValue(month[2], "Số người", "Mar");
        dataset.addValue(month[3], "Số người", "Apr");
        dataset.addValue(month[4], "Số người", "May");
        dataset.addValue(month[5], "Số người", "Jun");
        dataset.addValue(month[6], "Số người", "Jul");
        dataset.addValue(month[7], "Số người", "Aug");
        dataset.addValue(month[8], "Số người", "Sep");
        dataset.addValue(month[9], "Số người", "Oct");
        dataset.addValue(month[10], "Số người", "Nov");
        dataset.addValue(month[11], "Số người", "Dec");

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
    
    //Sau khi bam nut show chart
    private static int[] month=new int[12];
    public void pushNumberOfCustomerToLineChart(ArrayList<Integer> customerPerMonth){
        for(int i=0;i<customerPerMonth.size();i++){
            month[i]=customerPerMonth.get(i);
        }
    }
    
}
