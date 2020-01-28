/*
 * 2020/01/21
 * bookPanel »ý¼ºÀÚ·Î Àü´Þ
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
			tabbedPane.addTab("µµ¼­µî·Ï", null, getInsertbook(), null);
			tabbedPane.addTab("µµ¼­¼öÁ¤¡¤»èÁ¦", null, getModifybook(), null);
			tabbedPane.addTab("ºÐ·ùÄÚµå¼³Á¤", null, getGroupbook(), null);
			tabbedPane.addTab("Èñ¸Áµµ¼­¸ñ·Ï", null, getHopebook(), null);
			tabbedPane.setSelectedIndex(index);
			
			
			// @ÁÖÇö tabbedPane ÆùÆ®, ¹è°æ ¼³Á¤
			tabbedPane.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.setOpaque(true);
			tabbedPane.setBackgroundAt(0, Color.decode("#B0E0E6"));
			tabbedPane.setBackgroundAt(1, Color.decode("#B0E0E6"));
			tabbedPane.setBackgroundAt(2, Color.decode("#B0E0E6"));
			tabbedPane.setBackgroundAt(3, Color.decode("#B0E0E6"));
		}
		return tabbedPane;
	}
	public JPanel getInsertbook() {
		if (Insertbook == null) {
			Insertbook = new JPanel();
			Insertbook.setBackground(new Color(240, 248, 255));
			Insertbook.setPreferredSize(new Dimension(680, 540));
			j_BookInsert bookInsert = new j_BookInsert(this,main);
			bookInsert.getBtnNewButton_1().setBackground(new Color(176, 224, 230));
			bookInsert.getBtnNewButton().setBackground(new Color(176, 224, 230));
			bookInsert.getLabel_6().setHorizontalAlignment(SwingConstants.RIGHT);
			bookInsert.getLabel_5().setHorizontalAlignment(SwingConstants.RIGHT);
			bookInsert.getLabel_3().setHorizontalAlignment(SwingConstants.RIGHT);
			bookInsert.getLabel_2().setHorizontalAlignment(SwingConstants.RIGHT);
			bookInsert.getLabel_1().setHorizontalAlignment(SwingConstants.RIGHT);
			bookInsert.getLabel().setHorizontalAlignment(SwingConstants.RIGHT);
			bookInsert.getLblNewLabel_1().setHorizontalAlignment(SwingConstants.RIGHT);
			bookInsert.getLblNewLabel().setLocation(15, 36);
			bookInsert.getBtnNewButton_1().setSize(91, 30);
			bookInsert.getTGroup().setSize(140, 31);
			bookInsert.getTPage().setSize(139, 31);
			bookInsert.getTPrice().setSize(139, 31);
			bookInsert.getTDate().setSize(126, 31);
			bookInsert.getTPublisher().setSize(126, 31);
			bookInsert.getTWriter().setSize(126, 31);
			bookInsert.getTBook().setSize(126, 31);
			bookInsert.getTCode().setSize(130, 31);
			bookInsert.getTPage().setLocation(368, 311);
			bookInsert.getLabel_6().setLocation(292, 318);
			bookInsert.getTGroup().setLocation(368, 270);
			bookInsert.getLabel_5().setLocation(292, 278);
			bookInsert.getTPrice().setLocation(368, 234);
			bookInsert.getLabel_3().setLocation(292, 240);
			bookInsert.getTBook().setLocation(131, 227);
			bookInsert.getTWriter().setLocation(131, 269);
			bookInsert.getTPublisher().setLocation(131, 310);
			bookInsert.getTDate().setLocation(131, 351);
			bookInsert.getLabel_2().setLocation(55, 357);
			bookInsert.getLabel_1().setLocation(55, 318);
			bookInsert.getLabel().setLocation(55, 278);
			bookInsert.getLblNewLabel_1().setLocation(55, 233);
			bookInsert.getSeparator().setLocation(45, 188);
			bookInsert.getBtnNewButton_1().setLocation(259, 135);
			bookInsert.getTCode().setLocation(127, 135);
			bookInsert.getLabel_4().setLocation(55, 141);
			bookInsert.getBtnNewButton().setSize(105, 42);
			bookInsert.setBackground(new Color(240, 248, 255));
			bookInsert.getBtnNewButton().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTPage().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTGroup().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTCode().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTPrice().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTDate().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTPublisher().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTWriter().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getTBook().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLabel_6().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLabel_5().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLabel_3().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLabel_2().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLabel_1().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLabel().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLblNewLabel_1().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getBtnNewButton_1().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLabel_4().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookInsert.getLblNewLabel().setOpaque(true);
			bookInsert.getLblNewLabel().setBackground(new Color(240, 248, 255));
			bookInsert.getLblNewLabel().setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 35));
			bookInsert.setPreferredSize(new Dimension(550, 550));
			bookInsert.getBtnNewButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bookInsert.getBtnNewButton().setLocation(222, 458);
			Insertbook.add(bookInsert);
			Insertbook.updateUI();
			Insertbook.setVisible(true);
		}
		return Insertbook;
	}
	public JPanel getModifybook() {
		if (modifybook == null) {
			modifybook = new JPanel();
			modifybook.setBackground(new Color(240, 248, 255));
			j_BookManagement bookManagement = new j_BookManagement();
			bookManagement.getBtnNewButton_1().setSize(119, 47);
			bookManagement.getTable().setSize(794, 1791);
			bookManagement.getTable().setLocation(16, 83);
			bookManagement.getTable().setBackground(Color.decode("#F7FAFC"));
			bookManagement.getTable().getTableHeader().setBackground(Color.decode("#54B5BF"));
			bookManagement.getComboBox().setBackground(new Color(176, 224, 230));
			bookManagement.getBtnNewButton_1().setBackground(new Color(176, 224, 230));
			bookManagement.getButton().setBackground(new Color(176, 224, 230));
			bookManagement.getBtnNewButton_1().setLocation(395, 460);
			bookManagement.setBackground(new Color(240, 248, 255));
			bookManagement.getTable().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			bookManagement.getTable().getTableHeader().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			bookManagement.getButton().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookManagement.getTextField().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookManagement.getComboBox().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			bookManagement.getBtnNewButton_1().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			modifybook.updateUI();
			bookManagement.getBtnNewButton_1().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//»ó¼¼º¸±â ¹öÆ° ´­·¶À»¶§
					j_BookDetail detail = new j_BookDetail(bookManagement);
					main.getContentPane().add(detail);
					detail.toFront();
				}
			});
			bookManagement.getScrollPane().setBounds(6, 59, 817, 353);
			bookManagement.setPreferredSize(new Dimension(830, 550));
		
			modifybook.add(bookManagement);
			modifybook.updateUI();
			modifybook.setVisible(true);
			
		}
		return modifybook;
	}
	public JPanel getGroupbook() {
		if (groupbook == null) {
			groupbook = new JPanel();
			groupbook.setBackground(new Color(240, 248, 255));
			groupbook.setLayout(null);
			j_BookCategoryInsert ci = new j_BookCategoryInsert();
			ci.getTable().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			ci.getTable().setBackground(Color.decode("#F7FAFC"));
			ci.getTable().getTableHeader().setBackground(Color.decode("#54B5BF"));
			ci.getTable().getTableHeader().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			ci.getBtnNewButton().setBackground(new Color(176, 224, 230));
			ci.getPanel().setLocation(454, 31);
			ci.getSeparator_1().setLocation(397, 31);
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
			ci.setBounds(68, 91, 850, 348);
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
			j_HopeBookList_.setBackground(new Color(240, 248, 255));
			j_HopeBookList_.getScrollPane().setSize(750, 442);
			j_HopeBookList_.getScrollPane().setLocation(107, 45);
			j_HopeBookList_.getScrollPane().setBackground(Color.decode("#54B5BF"));
			hopebook.add(j_HopeBookList_);
			hopebook.updateUI();
			hopebook.setVisible(true);
		}
		return hopebook;
	}
}
