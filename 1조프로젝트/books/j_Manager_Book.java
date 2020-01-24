/*
 * 2020/01/21
 * bookPanel 생성자로 전달
 */

package books;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;

public class j_Manager_Book extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3; 
	h_Manager_Main main;
	j_BookManagement bookPanel;
	private JPanel panel_4;

	/**
	 * Create the panel.
	 */
	
	public j_Manager_Book(h_Manager_Main main) {
		this();
		this.main = main;
	}
	
	public j_Manager_Book() {
		setBackground(new Color(253, 245, 230));
		setPreferredSize(new Dimension(876, 590));
		setLayout(new BorderLayout(0, 0));
		add(getTabbedPane());
		setVisible(true);

	}
	

	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setPreferredSize(new Dimension(700, 500));
			tabbedPane.addTab("도서등록", null, getPanel(), null);
			tabbedPane.addTab("도서수정·삭제", null, getPanel_1(), null);
			tabbedPane.addTab("분류코드설정", null, getPanel_2(), null);
			tabbedPane.addTab("희망도서목록", null, getPanel_3(), null);
			
			// @주현 tabbedPane 폰트, 배경 설정
			tabbedPane.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
			tabbedPane.setBackground(new Color(253, 245, 230));
			tabbedPane.setOpaque(true);
		}
		return tabbedPane;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(253, 245, 230));
			panel.setPreferredSize(new Dimension(680, 540));
			j_BookInsert bookInsert = new j_BookInsert();
			bookInsert.getLblNewLabel().setOpaque(true);
			bookInsert.getLblNewLabel().setBackground(new Color(253, 245, 230));
			bookInsert.getLblNewLabel().setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 30));
			bookInsert.setPreferredSize(new Dimension(600, 500));
			bookInsert.getBtnNewButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bookInsert.getBtnNewButton().setLocation(232, 414);
			panel.add(bookInsert);
			panel.updateUI();
			panel.setVisible(true);
		}
		return panel;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			j_BookManagement bookManagement = new j_BookManagement();
			panel_1.updateUI();
			bookManagement.getBtnNewButton_1().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//상세보기 버튼 눌렀을때
					j_BookDetail detail = new j_BookDetail(bookManagement);
					main.getContentPane().add(detail);
					detail.toFront();
				}
			});
			bookManagement.getScrollPane().setBounds(6, 59, 817, 353);
			bookManagement.setPreferredSize(new Dimension(830, 462));
		
			panel_1.add(bookManagement);
			panel_1.updateUI();
			panel_1.setVisible(true);
			
		}
		return panel_1;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			j_BookCategoryInsert ci = new j_BookCategoryInsert();
			ci.getBtnNewButton().setLocation(151, 234);
			ci.getTCode().setLocation(177, 183);
			ci.getTName().setLocation(177, 143);
			ci.getLabel().setLocation(101, 186);
			ci.getLblNewLabel_1().setLocation(101, 146);
			ci.getLblNewLabel().setBounds(0, 31, 399, 90);
			ci.setBounds(14, 45, 399, 348);
			panel_2.add(ci);
			panel_2.add(getPanel_4_1());
			
			panel_2.updateUI();
			panel_2.setVisible(true);
		}
		return panel_2;
	}
	public JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			j_HopeBookList j_HopeBookList_ = new j_HopeBookList();
			j_HopeBookList_.getScrollPane().setSize(750, 442);
			j_HopeBookList_.getScrollPane().setLocation(107, 45);
			panel_3.add(j_HopeBookList_);
			panel_3.updateUI();
			panel_3.setVisible(true);
		}
		return panel_3;
	}
	public JPanel getPanel_4_1() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBounds(420, 12, 400, 439);
			panel_4.setLayout(null);
			
			j_BookCategorySelect cs = new j_BookCategorySelect();
			cs.setBounds(14, 33, 361, 345);
			panel_4.add(cs);
			panel_4.updateUI();
			panel_4.setVisible(true);
		}
		return panel_4;
	}
}
