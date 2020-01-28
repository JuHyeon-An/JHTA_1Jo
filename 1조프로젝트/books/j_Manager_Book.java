/*
 * 2020/01/21
 * bookPanel 생성자로 전달
 */

package books;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

public class j_Manager_Book extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel Insertbook;
	private JPanel modifybook;
	private JPanel groupbook;
	private JPanel hopebook; 
	h_Manager_Main main;
	j_BookManagement bookPanel;
	int index;

	/**
	 * Create the panel.
	 */
	
	public j_Manager_Book(h_Manager_Main main, int index) {
		this();
		this.main = main;
		this.index = index;
		add(getTabbedPane());
	}
	
	public j_Manager_Book() {
		setBackground(new Color(253, 245, 230));
		setPreferredSize(new Dimension(876, 590));
		setLayout(new BorderLayout(0, 0));
//		add(getTabbedPane());

	}
	
	
	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setPreferredSize(new Dimension(700, 500));
			tabbedPane.addTab("도서등록", null, getInsertbook(), null);
			tabbedPane.addTab("도서수정·삭제", null, getModifybook(), null);
			tabbedPane.addTab("분류코드설정", null, getGroupbook(), null);
			tabbedPane.addTab("희망도서목록", null, getHopebook(), null);
			tabbedPane.setSelectedIndex(index);
			
			
			// @주현 tabbedPane 폰트, 배경 설정
			tabbedPane.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
			tabbedPane.setBackground(new Color(253, 245, 230));
			tabbedPane.setOpaque(true);
		}
		return tabbedPane;
	}
	public JPanel getInsertbook() {
		if (Insertbook == null) {
			Insertbook = new JPanel();
			Insertbook.setBackground(new Color(253, 245, 230));
			Insertbook.setPreferredSize(new Dimension(680, 540));
			j_BookInsert bookInsert = new j_BookInsert(this,main);
			bookInsert.getLblNewLabel().setOpaque(true);
			bookInsert.getLblNewLabel().setBackground(new Color(253, 245, 230));
			bookInsert.getLblNewLabel().setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 30));
			bookInsert.setPreferredSize(new Dimension(600, 500));
			bookInsert.getBtnNewButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bookInsert.getBtnNewButton().setLocation(232, 414);
			Insertbook.add(bookInsert);
			Insertbook.updateUI();
			Insertbook.setVisible(true);
		}
		return Insertbook;
	}
	public JPanel getModifybook() {
		if (modifybook == null) {
			modifybook = new JPanel();
			j_BookManagement bookManagement = new j_BookManagement();
			modifybook.updateUI();
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
		
			modifybook.add(bookManagement);
			modifybook.updateUI();
			modifybook.setVisible(true);
			
		}
		return modifybook;
	}
	public JPanel getGroupbook() {
		if (groupbook == null) {
			groupbook = new JPanel();
			groupbook.setLayout(null);
			j_BookCategoryInsert ci = new j_BookCategoryInsert();
			ci.getBtnNewButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					groupbook.add(ci);
					groupbook.updateUI();
					groupbook.setVisible(true);
					
				}
			});
			ci.getBtnNewButton().setLocation(151, 234);
			ci.getTCode().setLocation(177, 183);
			ci.getTName().setLocation(177, 143);
			ci.getLabel().setLocation(101, 186);
			ci.getLblNewLabel_1().setLocation(101, 146);
			ci.getLblNewLabel().setBounds(0, 31, 399, 90);
			ci.setBounds(14, 45, 843, 348);
			groupbook.add(ci);
			
			groupbook.updateUI();
			groupbook.setVisible(true);
		}
		return groupbook;
	}
	public JPanel getHopebook() {
		if (hopebook == null) {
			hopebook = new JPanel();
			hopebook.setLayout(new BorderLayout(0, 0));
			j_HopeBookList j_HopeBookList_ = new j_HopeBookList();
			j_HopeBookList_.getScrollPane().setSize(750, 442);
			j_HopeBookList_.getScrollPane().setLocation(107, 45);
			hopebook.add(j_HopeBookList_);
			hopebook.updateUI();
			hopebook.setVisible(true);
		}
		return hopebook;
	}
}
