package books;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class m_UserBookSearch extends JPanel {
	private DialogMessage dm;
	private String msg = "";
	String keyId;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public m_UserBookSearch() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(936, 656));
		setLayout(null);
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
			scrollPane.setBounds(40, 10, 854, 504);
			scrollPane.setViewportView(getTable());
			
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			j_BookDao dao = new j_BookDao();
			model=dao.rentBookSearch(keyId);
			table = new JTable(model);
			table.setBackground(Color.decode("#F7FAFC"));
			table.getTableHeader().setBackground(Color.decode("#54B5BF")); // 테이블헤더
			table.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
			table.getTableHeader().setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
			table.setRowHeight(25);
			
			
		}
		return table;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uBC18\uB0A9\uAE30\uD55C \uC5F0\uC7A5 \uC2E0\uCCAD");
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 연장 신청 버튼 누리면
					
					String bCode = (String) table.getValueAt(table.getSelectedRow(), 3);
					j_BookDao dao = new j_BookDao();
					int r = dao.addDate(bCode,keyId);				
					
					
					if(r>0)	{
						model=dao.rentBookSearch(keyId);
						table.setModel(model);
						msg = "신청 되었습니다.";
					}else
						msg = "신청 불가";
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(m_UserBookSearch.this);
				}
			});
			btnNewButton.setBounds(379, 541, 177, 41);
		}
		return btnNewButton;
	}
}
