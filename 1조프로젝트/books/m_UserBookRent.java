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
		setPreferredSize(new Dimension(533, 444));
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
			comboBox.setBounds(31, 36, 68, 21);

			comboBox.addItem("������");
			comboBox.addItem("����");
			comboBox.addItem("���ǻ�");
		}
		return comboBox;
	}

	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent ke) {
					if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
						String rent = textField.getText(); // �˻���
						j_BookDao dao = new j_BookDao();

						model = (DefaultTableModel) dao.rent(comboBox.getSelectedIndex(), rent);

						table.setModel(model);
					}
				}
			});
			textField.setBounds(111, 36, 296, 21);
			textField.setColumns(10);
		}
		return textField;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// �˻� ��ư

					String rent = textField.getText(); // �˻���
					j_BookDao dao = new j_BookDao();

					model = (DefaultTableModel) dao.rent(comboBox.getSelectedIndex(), rent);

					table.setModel(model);

				}
			});
			btnNewButton.setBounds(419, 35, 97, 23);
		}
		return btnNewButton;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 103, 462, 282);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC608\uC57D \uC2E0\uCCAD");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// å �����ϰ� ���� ��û ��ư ������
					String bCode = (String) table.getValueAt(table.getSelectedRow(), 0);
					j_BookDao dao = new j_BookDao();

					int r = dao.rentRequest(bCode, keyId);
					if (r > 0) {
						if(       !((String)table.getValueAt(table.getSelectedRow(), 4)).equals("���� ����")                   ) {
							int a = dao.bookStatusRent(bCode);
							msg = "��û �Ǿ����ϴ�.";
							String rent = textField.getText();
							model = (DefaultTableModel) dao.rent(comboBox.getSelectedIndex(), rent);
							
							table.setModel(model);							
						}else {
							msg = "��û�Ұ��Դϴ�.";
						}
						dm = new DialogMessage(msg);
						dm.setLocationRelativeTo(m_UserBookRent.this);

					}
				}

			});
			btnNewButton_1.setBounds(203, 395, 97, 23);
		}
		return btnNewButton_1;

	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}

}
