package books;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

public class h_Manager_Statistic extends JPanel {
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;


	public h_Manager_Statistic() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(909, 550));
		setLayout(null);
		add(getLblNewLabel());
		add(getPanel_1());
		add(getPanel_2());
		setVisible(true);
	
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD1B5\uACC4\uC790\uB8CC");
			lblNewLabel.setFont(new Font("�����ٸ�����", Font.BOLD, 34));
			lblNewLabel.setBounds(412, 33, 138, 53);
		}
		return lblNewLabel;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(676, 177));
			panel_1.setBounds(140, 96, 676, 194);
			ChartTest1 test = new ChartTest1();
		    JFreeChart chart = test.getChart();
		    ChartPanel panel = new ChartPanel(chart);
		    panel.setPreferredSize(new Dimension(656, 177));
		    panel_1.add(panel);
		    panel_1.updateUI();
		    panel_1.setVisible(true);
		    panel_1.setBackground(new Color(240,248,255));
		}
		return panel_1;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(140, 305, 676, 213);
			ChartTest2 test = new ChartTest2();
			JFreeChart chart = test.getChart();
			ChartPanel panel = new ChartPanel(chart);
			panel.setPreferredSize(new Dimension(656, 177));
			panel.setBackground(new Color(240,248,255));
			panel_2.add(panel);
			panel_2.updateUI();
			panel_2.setVisible(true);
			panel_2.setBackground(new Color(240,248,255));
			
		}
		return panel_2;
	}
}
