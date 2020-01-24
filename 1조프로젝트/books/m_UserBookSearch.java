package books;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class m_UserBookSearch extends JPanel {
	String keyId;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public m_UserBookSearch() {
		setPreferredSize(new Dimension(660, 580));
		setLayout(null);
		//add(getScrollPane());
		add(getBtnNewButton());
	} 
	public m_UserBookSearch(String keyId) {
		this();
		this.keyId=keyId;
		add(getScrollPane());
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 62, 573, 432);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			j_BookDao dao = new j_BookDao();
			model=dao.rentBookSearch(keyId);
			table = new JTable(model);
			
		}
		return table;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uBC18\uB0A9\uAE30\uD55C \uC5F0\uC7A5 \uC2E0\uCCAD");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 연장 신청 버튼 누리면
					
					String bCode = (String) table.getValueAt(table.getSelectedRow(), 3);
					j_BookDao dao = new j_BookDao();
					int r = dao.addDate(bCode,keyId);				
					
					
					if(r>0)	{
						model=dao.rentBookSearch(keyId);
						table.setModel(model);
						JOptionPane.showMessageDialog(null, "신청 되었습니다.");
					}else
						JOptionPane.showMessageDialog(null, "신청 불가");
				}
			});
			btnNewButton.setBounds(228, 517, 153, 23);
		}
		return btnNewButton;
	}
}
