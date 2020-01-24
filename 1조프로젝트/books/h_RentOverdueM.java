package books;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class h_RentOverdueM extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public h_RentOverdueM() {
		setPreferredSize(new Dimension(700, 480));
		setLayout(null);
		add(getScrollPane());
		add(getBtnNewButton());
		setVisible(true);
		
		h_RentDao dao = new h_RentDao();
		dao.selectOverMember(this);

	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 15, 666, 407);
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
					// 메시지 전송 누르면 슝~
					j_BookDao dao = new j_BookDao();
					try {
						dao.sendEmail(email);
						JOptionPane.showMessageDialog(h_RentOverdueM.this,mName+"님에게 메일을 보냈습니다");
						
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton.setBounds(536, 437, 147, 29);
		}
		return btnNewButton;
	}
}
