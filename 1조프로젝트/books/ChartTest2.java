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

 

      

       // Run As > Java Application 으로 실행하면 바로 확인할 수 있음.

    public static void main(final String[] args) {

       ChartTest2 demo = new ChartTest2();

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

        dataset1.addValue(bringData(100), "장르별 이용자 수", "코딩");

        dataset1.addValue(bringData(200),  "장르별 이용자 수", "철학");

        dataset1.addValue(bringData(300),  "장르별 이용자 수", "종교");

        dataset1.addValue(bringData(400),  "장르별 이용자 수", "사회");

        dataset1.addValue(bringData(500),  "장르별 이용자 수", "예술");

        dataset1.addValue(bringData(600),  "장르별 이용자 수", "언어");

        dataset1.addValue(bringData(700),  "장르별 이용자 수", "문학");

        dataset1.addValue(bringData(800), "장르별 이용자 수", "역사");

        dataset1.addValue(bringData(900),  "장르별 이용자 수", "코믹");

        dataset1.addValue(bringData(150),  "장르별 이용자 수", "자바");
        

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

        Font f = new Font("나눔바른고딕 Light", Font.PLAIN, 14);

        Font axisF = new Font("나눔바른고딕 Light", Font.PLAIN, 14);

       

        // 렌더링 세팅

        // 그래프 1

        renderer.setBaseItemLabelGenerator(generator);

        renderer.setBaseItemLabelsVisible(true);

        renderer.setBasePositiveItemLabelPosition(p_center);

        renderer.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

        renderer.setSeriesPaint(0, new Color(100,149,237));

 


           


       

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

        chart.setTitle("장르별 이용자 수 "); // 차트 타이틀
        chart.setBackgroundPaint(new Color(240,248,255));

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // 차트 서브 타이틀

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









