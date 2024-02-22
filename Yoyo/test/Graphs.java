
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

        Map<String, Double> monthlyRevenue = new LinkedHashMap<>();
        monthlyRevenue.put("Jan", 1000.0);
        monthlyRevenue.put("Feb", 1200.0);
        monthlyRevenue.put("Mar", 1500.0);
        monthlyRevenue.put("Apr", 1700.0);
        monthlyRevenue.put("May", 1800.0);
        monthlyRevenue.put("Jun", 1900.0);
        monthlyRevenue.put("Jul", 2000.0);
        monthlyRevenue.put("Aug", 2100.0);
        monthlyRevenue.put("Sep", 2200.0);
        monthlyRevenue.put("Oct", 2300.0);
        monthlyRevenue.put("Nov", 2400.0);
        monthlyRevenue.put("Dec", 2500.0);
        
        MonthlyRevenueGraph.setLayout(new BorderLayout());
        createLineChart(monthlyRevenue,MonthlyRevenueGraph, "Monthly Revenue Comparison", "Month", "Revenue(RM)");
        
        Map<String, Double> monthlyUnitsSold = new LinkedHashMap<>();
        monthlyUnitsSold.put("Jan", 15.0);
        monthlyUnitsSold.put("Feb", 17.0);
        monthlyUnitsSold.put("Mar", 18.0);
        monthlyUnitsSold.put("Apr", 16.0);
        monthlyUnitsSold.put("May", 20.0);
        monthlyUnitsSold.put("Jun", 36.0);
        monthlyUnitsSold.put("Jul", 21.0);
        monthlyUnitsSold.put("Aug", 38.0);
        monthlyUnitsSold.put("Sep", 43.0);
        monthlyUnitsSold.put("Oct", 55.0);
        monthlyUnitsSold.put("Nov", 67.0);
        monthlyUnitsSold.put("Dec", 75.0);
        
        MonthlyUnitsSoldGraph.setLayout(new BorderLayout());
        createLineChart(monthlyUnitsSold,MonthlyUnitsSoldGraph, "Monthly Units Sold Comparison", "Month", "UnitsSold");
        
        cardLayoutContent = (CardLayout)(ContentCards.getLayout()); 
        cardLayoutButton = (CardLayout)(ButtonCards.getLayout());

    
    private void createLineChart(Map<String, Double> monthlyRevenue, JPanel panel, String title, String xLabel, String yLabel) {

        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String month : monthlyRevenue.keySet()) {
            dataset.addValue(monthlyRevenue.get(month), "Revenue", month);
        }

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
            title,
            xLabel,
            yLabel,
            dataset,
            PlotOrientation.VERTICAL,
            false, // Include legend
            false, // Include tooltips
            false // No URL generator
        );

        // Customize chart (optional)
        customizeChart(chart); // Call a separate method for customization

        // Add chart to the panel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
    private void customizeChart(JFreeChart chart) {
        
        // Optional customizations
        chart.getPlot().setBackgroundPaint(new Color(246,245,249)); 
        
        // Add rounded corners to lines (optional)
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 128, 255)); // Set point color to blue
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6)); // Change shape to circle
        renderer.setBaseShapesVisible(true);
        renderer.setDrawOutlines(false);
        renderer.setUseFillPaint(true);
        renderer.setBaseFillPaint(new Color(0, 128, 255));

    }