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

public class h_RentOverdueB extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	Connection conn;
	h_RentDao dao = new h_RentDao();
	
	public h_RentOverdueB() {
		setPreferredSize(new Dimension(640, 440));
		setLayout(null);
		add(getLblNewLabel());
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
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC5F0\uCCB4\uB3C4\uC11C \uBAA9\uB85D");
			lblNewLabel.setBounds(17, 10, 124, 28);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 48, 603, 343);
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

