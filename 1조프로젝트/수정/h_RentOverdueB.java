package books;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;

public class h_RentOverdueB extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	Connection conn;
	h_RentDao dao = new h_RentDao();
	
	public h_RentOverdueB() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(810, 535));
		setLayout(null);
		add(getScrollPane());
		
		h_RentDao dao = new h_RentDao(this);
		dao.overdueSelect();
		overdueBookUpdate();

	}
	public void overdueBookUpdate() {
		for(int i=0;i<table.getRowCount();i++) {
			String find= (String)table.getValueAt(i,1);
			dao.updateOverdueBook(find);		
		}
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 15, 776, 505);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
	
		}
		return table;
	}
}

