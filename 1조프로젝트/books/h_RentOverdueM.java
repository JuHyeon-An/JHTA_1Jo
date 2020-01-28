package books;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class h_RentOverdueM extends JPanel {
	private DialogMessage dm;
	private String msg = "";
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public h_RentOverdueM() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(810, 535));
		setLayout(null);
		add(getScrollPane());
		add(getBtnNewButton());
		setVisible(true);
		try {
			h_RentDao dao = new h_RentDao();
			dao.selectOverMember(this);
		}catch(IndexOutOfBoundsException ex) {
			msg = "�޼����� ���� ȸ���� ������ �ּ���";
			dm = new DialogMessage(msg);
			dm.setLocationRelativeTo(h_RentOverdueM.this);
		}

	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 15, 776, 461);
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uBA54\uC138\uC9C0 \uBCF4\uB0B4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					String email = (String) table.getValueAt(table.getSelectedRow(), 3);
					String mName = (String) table.getValueAt(table.getSelectedRow(),1);
					System.out.println(email);
					// �޽��� ���� ������ ��~
					j_BookDao dao = new j_BookDao();
					try {
						dao.sendEmail(email);
						msg = mName+"�Կ��� ������ ���½��ϴ�";
						dm = new DialogMessage(msg);
						dm.setLocationRelativeTo(h_RentOverdueM.this);
						//JOptionPane.showMessageDialog(h_RentOverdueM.this,mName+"�Կ��� ������ ���½��ϴ�");
						
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton.setBounds(646, 491, 147, 29);
		}
		return btnNewButton;
	}
}
