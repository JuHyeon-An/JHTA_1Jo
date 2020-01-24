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

 

      

       // Run As > Java Application 으로 실행하면 바로 확인할 수 있음.

    public static void main(final String[] args) {

       ChartTest1 demo = new ChartTest1();

             JFreeChart chart = demo.getChart();

             ChartFrame frame1=new ChartFrame("Bar Chart",chart);

             frame1.setSize(500,200); 

             frame1.setVisible(true);

    }

   

    public JFreeChart getChart() {

      

        // 데이터 생성

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1



 

        // 데이터 입력 ( 값, 범례, 카테고리 )

        // 그래프 1       

        dataset1.addValue(bringData("jan"), "월별 이용자 수 ", "1월");

        dataset1.addValue(bringData("feb"),  "월별 이용자 수 ", "2월");

        dataset1.addValue(bringData("mar"),  "월별 이용자 수 ", "3월");

        dataset1.addValue(bringData("apr"),  "월별 이용자 수 ", "4월");

        dataset1.addValue(bringData("may"),  "월별 이용자 수 ", "5월");

        dataset1.addValue(bringData("jun"),  "월별 이용자 수 ", "6월");

        dataset1.addValue(bringData("jul"),  "월별 이용자 수 ", "7월");

        dataset1.addValue(bringData("aug"), "월별 이용자 수 ", "8월");

        dataset1.addValue(bringData("sep"),  "월별 이용자 수 ", "9월");

        dataset1.addValue(bringData("oct"),  "월별 이용자 수 ", "10월");

        dataset1.addValue(bringData("nov"),  "월별 이용자 수 ", "11월");

        dataset1.addValue(bringData("decem"),  "월별 이용자 수 ", "12월");

 


        // 그래프 3       

       

 

        // 렌더링 생성 및 세팅

        // 렌더링 생성

        final BarRenderer renderer = new BarRenderer();

     

       

        // 공통 옵션 정의

        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

        final ItemLabelPosition p_center = new ItemLabelPosition(

                ItemLabelAnchor.CENTER, TextAnchor.CENTER

            );

        final ItemLabelPosition p_below = new ItemLabelPosition(

                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

                     );

        Font f = new Font("Gulim", Font.BOLD, 14);

        Font axisF = new Font("Gulim", Font.PLAIN, 14);

       

        // 렌더링 세팅

        // 그래프 1

        renderer.setBaseItemLabelGenerator(generator);

        renderer.setBaseItemLabelsVisible(true);

        renderer.setBasePositiveItemLabelPosition(p_center);

        renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

        renderer.setSeriesPaint(0, new Color(0,162,255));

 


           


       

        // plot 생성

        final CategoryPlot plot = new CategoryPlot();

       

        // plot 에 데이터 적재

        plot.setDataset(dataset1);

        plot.setRenderer(renderer);



 

        // plot 기본 설정

        plot.setOrientation(PlotOrientation.VERTICAL);             // 그래프 표시 방향

        plot.setRangeGridlinesVisible(true);                       // X축 가이드 라인 표시여부

        plot.setDomainGridlinesVisible(true);                      // Y축 가이드 라인 표시여부

 

        // 렌더링 순서 정의 : dataset 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

       

        // X축 세팅

        plot.setDomainAxis(new CategoryAxis());              // X축 종류 설정

        plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정

        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // 카테고리 라벨 위치 조정

 

        // Y축 세팅

        plot.setRangeAxis(new NumberAxis());                 // Y축 종류 설정

        plot.getRangeAxis().setTickLabelFont(axisF);  // Y축 눈금라벨 폰트 조정

       

        // 세팅된 plot을 바탕으로 chart 생성

        final JFreeChart chart = new JFreeChart(plot);

        chart.setTitle("2019 월별 이용자 수 "); // 차트 타이틀

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // 차트 서브 타이틀

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









