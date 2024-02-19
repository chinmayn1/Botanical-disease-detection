package www.ascox.in;

import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;
import java.util.Arrays;

public class Chart1 extends ApplicationFrame {

    public Chart1(final String title) {
        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    public XYDataset createDataset() {

        final XYSeries series1 = new XYSeries("Existing");
        final XYSeries series2 = new XYSeries("Proposed");

        try {

            String a = "";
            String b = "";
            String c = "";
            String d = "";
            String e = "";

            int i = 0;
            float a1[] = {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            float a2[] = {0, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1};
            float a3[] = {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            float a4[] = {0, 2, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1};
            double hh = 0;
            for (i = 2; i <= 11; i++) {
                double g = Math.random() * 20;
                float P = (float) g;
                a1[i] = P;

                float ff = (float) 0.6;
                P = P - ff;
                a2[i] = P;

                hh = Math.random() * 21;
                float P1 = (float) hh;
                a3[i] = P1;

                float ff1 = (float) 0.6;
                P1 = P1 - ff1;
                a4[i] = P1;

            }
            Arrays.sort(a1);
            for (float number : a1) {

                String se = String.valueOf(number);
                a = a + se + " ";

            }

            Arrays.sort(a2);
            for (float number : a2) {

                String se = String.valueOf(number);
                c = c + se + " ";

            }

            Arrays.sort(a3);
            for (float number : a3) {

                String se = String.valueOf(number);
                d = d + se + " ";

            }

            Arrays.sort(a4);
            for (float number : a4) {

                String se = String.valueOf(number);
                e = e + se + " ";

            }

            int i1 = 0;
            int a11[] = {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};;
            for (i1 = 2; i1 <= 11; i1++) {
                double g = Math.random() * 20;
                int P = (int) g;

                a11[i1] = P;
            }
            Arrays.sort(a11);
            for (int number : a11) {

                String se = String.valueOf(number);
                b = b + se + " ";
            }

            String arr1[] = c.split(" ");
            String arr2[] = b.split(" ");//X

            for (int k = arr1.length; k > 0; k--) {
                double v1 = Double.parseDouble(arr1[k - 1]);
                double v2 = Double.parseDouble(arr2[k - 1]);
                series1.add(v2, v1);
            }

            //==================================================              
            String arr3[] = a.split(" ");
            String arr4[] = b.split(" ");

            for (int k = arr3.length; k > 0; k--) {
                double v1 = Double.parseDouble(arr3[k - 1]);
                double v2 = Double.parseDouble(arr4[k - 1]);
                series2.add(v2, v1);
            }

//=============================================   
        } catch (Exception e) {
            e.printStackTrace();
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Comparison of Edge and Pattern Genrated Algorithm",
                "Edge Detection",
                "Pattern Genrated Algorithm",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        chart.setBackgroundPaint(Color.white);
        final XYPlot plot1 = chart.getXYPlot();
        plot1.setBackgroundPaint(Color.WHITE);
        plot1.setDomainGridlinePaint(Color.BLACK);
        plot1.setRangeGridlinePaint(Color.BLACK);

        final XYPlot plot2 = chart.getXYPlot();
        plot2.setBackgroundPaint(Color.white);
        plot2.setDomainGridlinePaint(Color.BLACK);
        plot2.setRangeGridlinePaint(Color.BLACK);

        final XYPlot plot3 = chart.getXYPlot();
        plot3.setBackgroundPaint(Color.WHITE);
        plot3.setDomainGridlinePaint(Color.BLACK);
        plot3.setRangeGridlinePaint(Color.BLACK);

        return chart;
    }

  /*  public static void main(final String[] args) {

        Chart1 c1 = new Chart1("Comparison of Canny and Colour Algorithm");
        c1.pack();
        c1.setVisible(true);

    }*/
}
