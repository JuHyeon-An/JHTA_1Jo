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
import javax.swing.ImageIcon;

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
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(m_UserBookSearch.class.getResource("/iconBox/16.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 연장버튼을 누르면					
					j_BookDao dao = new j_BookDao();
					
					String bCode = (String) table.getValueAt(table.getSelectedRow(), 3);  // 선택된 행의 책코드를 변수에 담고
					int r = dao.addDate(bCode);	// addDate메소드를 실행하면서 책코드와 사용자ID를 인자로 전달 			
														// 반환날짜가 정상적으로 연장되면 1이상을 반환
														// 반환날짜를 연장할수 없으면 0 반환
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
			btnNewButton.setBounds(379, 541, 160, 33);
		}
		return btnNewButton;
	}
}
