package books;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class p_MemberSelect extends JPanel {
	DefaultTableModel model = new DefaultTableModel();
	
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	JComboBox box = new JComboBox();
	/**
	 * Create the panel.
	 */


	public p_MemberSelect() {
		setPreferredSize(new Dimension(677, 410));
		setLayout(null);
		add(getComboBox());
		add(getTextField());
		add(getBtnNewButton());
		add(getScrollPane());

	}
	private ComboBoxModel ComboBoxModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(12, 10, 83, 38);
			comboBox.addItem("아이디");
			comboBox.addItem("성명");
			
		}
		return comboBox;
	}

	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(105, 10, 442, 38);
			textField.setColumns(10);
		}
		return textField;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addKeyListener(new KeyAdapter() {
			});
			btnNewButton.addActionListener(new ActionListener() {
				//find 의 값을 가져와서 테이블에 뿌려준다
				public void actionPerformed(ActionEvent arg0) {
					String find = textField.getText();
					p_MemberDao dao = new p_MemberDao();
					model = (DefaultTableModel) dao.select(find);

					table.setModel(model);
				}
			});
			btnNewButton.setBounds(553, 10, 111, 38);
		}
		return btnNewButton;
	} 
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 58, 653, 342);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	public JTable getTable_1() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
}
