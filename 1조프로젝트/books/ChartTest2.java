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

 



public class ChartTest2 {

 

      

       // Run As > Java Application ���� �����ϸ� �ٷ� Ȯ���� �� ����.

    public static void main(final String[] args) {

       ChartTest2 demo = new ChartTest2();

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

        dataset1.addValue(bringData(100), "�帣�� �̿��� ��", "�ڵ�");

        dataset1.addValue(bringData(200),  "�帣�� �̿��� ��", "ö��");

        dataset1.addValue(bringData(300),  "�帣�� �̿��� ��", "����");

        dataset1.addValue(bringData(400),  "�帣�� �̿��� ��", "��ȸ");

        dataset1.addValue(bringData(500),  "�帣�� �̿��� ��", "����");

        dataset1.addValue(bringData(600),  "�帣�� �̿��� ��", "���");

        dataset1.addValue(bringData(700),  "�帣�� �̿��� ��", "����");

        dataset1.addValue(bringData(800), "�帣�� �̿��� ��", "����");

        dataset1.addValue(bringData(900),  "�帣�� �̿��� ��", "�ڹ�");

        dataset1.addValue(bringData(150),  "�帣�� �̿��� ��", "�ڹ�");
        

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

        Font f = new Font("�����ٸ���� Light", Font.PLAIN, 14);

        Font axisF = new Font("�����ٸ���� Light", Font.PLAIN, 14);

       

        // ������ ����

        // �׷��� 1

        renderer.setBaseItemLabelGenerator(generator);

        renderer.setBaseItemLabelsVisible(true);

        renderer.setBasePositiveItemLabelPosition(p_center);

        renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

        renderer.setSeriesPaint(0, new Color(100,149,237));

 


           


       

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

        chart.setTitle("�帣�� �̿��� �� "); // ��Ʈ Ÿ��Ʋ
        chart.setBackgroundPaint(new Color(240,248,255));

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // ��Ʈ ���� Ÿ��Ʋ

        return chart;

    }
    
    public int bringData(int find) {
    	Connection conn;
    	conn = DBConn.getConn();
    	int r=0;
    	String sql = " select countuser from book_group where group_code=?  ";
    	try {
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setInt(1, find);
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









