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
			table.getTableHeader().setBackground(Color.decode("#54B5BF")); // ���̺����
			table.setFont(new Font("�����ٸ����", Font.PLAIN, 15));
			table.getTableHeader().setFont(new Font("�����ٸ����", Font.PLAIN, 15));
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
			btnNewButton.setFont(new Font("�����ٸ����", Font.PLAIN, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// �����ư�� ������					
					j_BookDao dao = new j_BookDao();
					
					String bCode = (String) table.getValueAt(table.getSelectedRow(), 3);  // ���õ� ���� å�ڵ带 ������ ���
					int r = dao.addDate(bCode);	// addDate�޼ҵ带 �����ϸ鼭 å�ڵ�� �����ID�� ���ڷ� ���� 			
														// ��ȯ��¥�� ���������� ����Ǹ� 1�̻��� ��ȯ
														// ��ȯ��¥�� �����Ҽ� ������ 0 ��ȯ
					if(r>0)	{
						model=dao.rentBookSearch(keyId);  
						table.setModel(model);
						msg = "��û �Ǿ����ϴ�.";
					}else
						msg = "��û �Ұ�";
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(m_UserBookSearch.this);
				}
			});
			btnNewButton.setBounds(379, 541, 160, 33);
		}
		return btnNewButton;
	}
}
