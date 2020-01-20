package books;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class MemberSelete extends JPanel {
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public MemberSelete() {
		setLayout(null);
		add(getComboBox());
		add(getTextField());
		add(getBtnNewButton());
		add(getTable());

	}

	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(12, 10, 83, 38);
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
			btnNewButton.setBounds(553, 10, 111, 38);
		}
		return btnNewButton;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(12, 58, 652, 500);
		}
		return table;
	}
}
