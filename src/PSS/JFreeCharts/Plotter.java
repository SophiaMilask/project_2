import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;

public class Plotter {

    public void showGraph(ArrayList<Integer> xValues, ArrayList<Integer> yValues, String title) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        // Add the x and y values to the dataset
        for (int i = 0; i < xValues.size(); i++) {
            data.addValue(yValues.get(i), "Values", xValues.get(i).toString());
        }

        // Create the chart
        JFreeChart chart = ChartFactory.createLineChart(
                title,           // Chart title
                "x",      // x-axis label
                "y",      // y-axis label
                data          // Points to plot
        );

        // Create a panel with preferred dimensions
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 800));

        // Display chart in window and exit the program when window is closed
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // Original, salted, and smoothed graphs will show up at same time in different windows
    public void showAllGraphs(ArrayList<Integer> xValues, ArrayList<Integer> originalYValues,
                              ArrayList<Integer> saltedYValues, ArrayList<Integer> smoothedYValues) {
        // Show the original graph
        showGraph(xValues, originalYValues, "Original Function");

        // Show the salted graph
        showGraph(xValues, saltedYValues, "Salted Function");

        // Show the smoothed graph
        showGraph(xValues, smoothedYValues, "Smoothed Function");
    }
}
