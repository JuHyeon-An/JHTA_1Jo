package books;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

public class m_UserBookRent extends JPanel {

	private DialogMessage dm;
	private String msg = "";

	String keyId;
	DefaultTableModel model = new DefaultTableModel();
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JTable table;
	private JRadioButton ableBtn;
	private JRadioButton disableBtn;

	/**
	 * Create the panel.
	 */
	public m_UserBookRent() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(878, 631));
		setLayout(null);
		add(getComboBox());
		add(getTextField());
		add(getBtnNewButton());
		add(getScrollPane());
		add(getBtnNewButton_1());

	}

	public m_UserBookRent(String keyId) {
		this();
		this.keyId = keyId;
	}

	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBorder(null);
			comboBox.setBackground(new Color(230, 230, 250));
			comboBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			comboBox.setBounds(12, 22, 103, 21);

			comboBox.addItem("도서명");
			comboBox.addItem("저자");
			comboBox.addItem("출판사");
		}
		return comboBox;
	}

	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent ke) {
					if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
						String rent = textField.getText(); // 검색어
						j_BookDao dao = new j_BookDao();

						model = (DefaultTableModel) dao.rent(comboBox.getSelectedIndex(), rent, keyId);

						table.setModel(model);
					}
				}
			});
			textField.setBounds(127, 22, 608, 21);
			textField.setColumns(10);
		}
		return textField;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(173, 216, 230));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 검색 버튼

					String rent = textField.getText(); // 검색어
					j_BookDao dao = new j_BookDao();

					model = (DefaultTableModel) dao.rent(comboBox.getSelectedIndex(), rent, keyId);

					table.setModel(model);

				}
			});
			btnNewButton.setBounds(747, 21, 119, 23);
		}
		return btnNewButton;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(230, 230, 250));
			scrollPane.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			scrollPane.setBounds(12, 53, 854, 504);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC608\uC57D \uC2E0\uCCAD");
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(173, 216, 230));
			btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// 책 선택하고 예약 신청 버튼 누르면
					String bCode = (String) table.getValueAt(table.getSelectedRow(), 0); // 선택한 책 코드 받아오고
					j_BookDao dao = new j_BookDao();

					if (((String) table.getValueAt(table.getSelectedRow(), 4)) == "예약 가능") {

						int r = dao.rentRequest(bCode, keyId); // 예약요청
						if (r > 0) {
							int a = dao.bookStatusRent(bCode);  // 실행되면 예약중으로 변경됨 
							msg = "신청 되었습니다.";
							String rent = textField.getText();
							model = (DefaultTableModel) dao.rent(comboBox.getSelectedIndex(), rent, keyId);
							table.setModel(model);
						} else {
							msg = "예약불가입니다.";
						}
						dm = new DialogMessage(msg);
						dm.setLocationRelativeTo(m_UserBookRent.this);

					} else if (((String) table.getValueAt(table.getSelectedRow(), 4)) == "예약중") {
						msg = "이미 예약중 입니다.";
						dm = new DialogMessage(msg);
						dm.setLocationRelativeTo(m_UserBookRent.this);
					}
				}
			});
			btnNewButton_1.setBounds(769, 572, 97, 35);
		}
		return btnNewButton_1;
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBackground(Color.decode("#F7FAFC"));
			table.getTableHeader().setBackground(Color.decode("#54B5BF"));
			table.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
			table.getTableHeader().setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
			table.setRowHeight(25);
		}
		return table;
	}

}
