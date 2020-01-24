package books;

import java.awt.BasicStroke;

import java.awt.Color;

import java.awt.Font;

import java.awt.GradientPaint;

import java.awt.Paint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFrame;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.axis.CategoryAxis;

import org.jfree.chart.axis.CategoryLabelPositions;

import org.jfree.chart.axis.NumberAxis;

import org.jfree.chart.labels.CategoryItemLabelGenerator;

import org.jfree.chart.labels.ItemLabelAnchor;

import org.jfree.chart.labels.ItemLabelPosition;

import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.DatasetRenderingOrder;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.category.BarRenderer;

import org.jfree.chart.renderer.category.CategoryItemRenderer;

import org.jfree.chart.renderer.category.LineAndShapeRenderer;

import org.jfree.chart.renderer.category.StandardBarPainter;

import org.jfree.chart.title.TextTitle;

import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.GradientPaintTransformType;

import org.jfree.ui.HorizontalAlignment;

import org.jfree.ui.StandardGradientPaintTransformer;

import org.jfree.ui.TextAnchor;

 



public class ChartTest1 {

 

      

       // Run As > Java Application ���� �����ϸ� �ٷ� Ȯ���� �� ����.

    public static void main(final String[] args) {

       ChartTest1 demo = new ChartTest1();

             JFreeChart chart = demo.getChart();

             ChartFrame frame1=new ChartFrame("Bar Chart",chart);

             frame1.setSize(500,200); 

             frame1.setVisible(true);

    }

   

    public JFreeChart getChart() {

      

        // ������ ����

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1



 

        // ������ �Է� ( ��, ����, ī�װ� )

        // �׷��� 1       

        dataset1.addValue(bringData("jan"), "���� �̿��� �� ", "1��");

        dataset1.addValue(bringData("feb"),  "���� �̿��� �� ", "2��");

        dataset1.addValue(bringData("mar"),  "���� �̿��� �� ", "3��");

        dataset1.addValue(bringData("apr"),  "���� �̿��� �� ", "4��");

        dataset1.addValue(bringData("may"),  "���� �̿��� �� ", "5��");

        dataset1.addValue(bringData("jun"),  "���� �̿��� �� ", "6��");

        dataset1.addValue(bringData("jul"),  "���� �̿��� �� ", "7��");

        dataset1.addValue(bringData("aug"), "���� �̿��� �� ", "8��");

        dataset1.addValue(bringData("sep"),  "���� �̿��� �� ", "9��");

        dataset1.addValue(bringData("oct"),  "���� �̿��� �� ", "10��");

        dataset1.addValue(bringData("nov"),  "���� �̿��� �� ", "11��");

        dataset1.addValue(bringData("decem"),  "���� �̿��� �� ", "12��");

 


        // �׷��� 3       

       

 

        // ������ ���� �� ����

        // ������ ����

        final BarRenderer renderer = new BarRenderer();

     

       

        // ���� �ɼ� ����

        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

        final ItemLabelPosition p_center = new ItemLabelPosition(

                ItemLabelAnchor.CENTER, TextAnchor.CENTER

            );

        final ItemLabelPosition p_below = new ItemLabelPosition(

                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

                     );

        Font f = new Font("Gulim", Font.BOLD, 14);

        Font axisF = new Font("Gulim", Font.PLAIN, 14);

       

        // ������ ����

        // �׷��� 1

        renderer.setBaseItemLabelGenerator(generator);

        renderer.setBaseItemLabelsVisible(true);

        renderer.setBasePositiveItemLabelPosition(p_center);

        renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

        renderer.setSeriesPaint(0, new Color(0,162,255));

 


           


       

        // plot ����

        final CategoryPlot plot = new CategoryPlot();

       

        // plot �� ������ ����

        plot.setDataset(dataset1);

        plot.setRenderer(renderer);



 

        // plot �⺻ ����

        plot.setOrientation(PlotOrientation.VERTICAL);             // �׷��� ǥ�� ����

        plot.setRangeGridlinesVisible(true);                       // X�� ���̵� ���� ǥ�ÿ���

        plot.setDomainGridlinesVisible(true);                      // Y�� ���̵� ���� ǥ�ÿ���

 

        // ������ ���� ���� : dataset ��� ������� ������ ( ��, ���� ����Ѱ� �Ʒ��� �� )

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

       

        // X�� ����

        plot.setDomainAxis(new CategoryAxis());              // X�� ���� ����

        plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����

        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // ī�װ� �� ��ġ ����

 

        // Y�� ����

        plot.setRangeAxis(new NumberAxis());                 // Y�� ���� ����

        plot.getRangeAxis().setTickLabelFont(axisF);  // Y�� ���ݶ� ��Ʈ ����

       

        // ���õ� plot�� �������� chart ����

        final JFreeChart chart = new JFreeChart(plot);

        chart.setTitle("2019 ���� �̿��� �� "); // ��Ʈ Ÿ��Ʋ

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // ��Ʈ ���� Ÿ��Ʋ

        return chart;

    }
    
    public int bringData(String find) {
    	Connection conn;
    	conn = DBConn.getConn();
    	int r=0;
    	String sql = " select countuser from months where month=?  ";
    	try {
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, find);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next()) {
		    	r = rs.getInt("countuser");
		    }
		    
		    rs.close();
		    ps.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return r;
    	
    }

 

}









