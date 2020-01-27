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

public class h_Manager_Rent extends JPanel {

	private JTabbedPane tabbedPane;
	private JPanel delayBook;
	private JPanel delayMember;
	private JPanel rentManage;
	private JPanel returnManage; 
	private JPanel panel_4;
	int index;

	
	public h_Manager_Rent(int index) {
		this();
		this.index = index;
		add(getTabbedPane());
	}
	
	public h_Manager_Rent() {
		setBackground(new Color(253, 245, 230));
		setPreferredSize(new Dimension(876, 590));
		setLayout(new BorderLayout(0, 0));
		setVisible(true);
	}
	
	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setPreferredSize(new Dimension(700, 500));
			tabbedPane.addTab("연체도서관리", null, getDelayBook(), null);
			tabbedPane.addTab("연체회원관리", null, getDelayMember(), null);
			tabbedPane.addTab("대출관리", null, getRentManage(), null);
			tabbedPane.addTab("반납관리", null, getReturnManage(), null);
			tabbedPane.setSelectedIndex(index);
			
			// @주현 tabbedPane 폰트, 배경 설정
			tabbedPane.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
			tabbedPane.setBackground(new Color(253, 245, 230));
			tabbedPane.setOpaque(true);
		}
		return tabbedPane;
	}
	public JPanel getDelayBook() {
		if (delayBook == null) {
			delayBook = new JPanel();
			delayBook.setBackground(new Color(253, 245, 230));
			delayBook.setPreferredSize(new Dimension(680, 540));
			delayBook.add(new h_RentOverdueB());
		}
		return delayBook;
	}
	public JPanel getDelayMember() {
		if (delayMember == null) {
			delayMember = new JPanel();
			delayBook.setBackground(new Color(253, 245, 230));
			delayBook.setPreferredSize(new Dimension(680, 540));
			delayMember.add(new h_RentOverdueM());
			delayMember.updateUI();
			delayMember.setVisible(true);
			
		}
		return delayMember;
	}
	public JPanel getRentManage() {
		if (rentManage == null) {
			rentManage = new JPanel();
			rentManage.add(new h_RentRent());
		}
		return rentManage;
	}
	public JPanel getReturnManage() {
		if (returnManage == null) {
			returnManage = new JPanel();
			returnManage.add(new h_RentReturn(this));
		}
		return returnManage;
	}
	public JPanel getPanel_4_1() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			
			panel_4.setBounds(457, 12, 436, 439);
			panel_4.setLayout(null);
		}
		return panel_4;
	}
}
