package books;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTabbedPane;

public class h_Manager_Rent extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	
	public h_Manager_Rent() {
		setPreferredSize(new Dimension(990, 600));
		setLayout(null);
		add(getTabbedPane());
		setVisible(true);
		

	}

	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.setPreferredSize(new Dimension(990, 600));
			tabbedPane.setBounds(0, 0, 990, 600);
			tabbedPane.addTab("연체도서관리", null, getPanel(), null);
			tabbedPane.addTab("연체회원관리", null, getPanel_3(), null);
			tabbedPane.addTab("대출관리", null, getPanel_1(), null);
			tabbedPane.addTab("반납관리", null, getPanel_2(), null);
			
			tabbedPane.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		
			tabbedPane.setOpaque(true);
		}
		return tabbedPane;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(240, 248, 255));
			panel.setPreferredSize(new Dimension(990, 600));
			panel.add(new h_RentOverdueB());
			panel.updateUI();
			panel.setVisible(true);
		}
		return panel;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(240, 248, 255));
			panel_1.setPreferredSize(new Dimension(810, 535));
			panel_1.add(new h_RentRent());
			panel_1.updateUI();
			panel_1.setVisible(true);
		}
		return panel_1;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(240, 248, 255));
			panel_2.setPreferredSize(new Dimension(810, 535));
			panel_2.add(new h_RentReturn(this));
			panel_2.updateUI();
			panel_2.setVisible(true);
		}
		return panel_2;
	}
	public JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(new Color(240, 248, 255));
			panel_3.setPreferredSize(new Dimension(810, 535));
			panel_3.add(new h_RentOverdueM());
			panel_3.setVisible(true);
		}
		return panel_3;
	}
}
