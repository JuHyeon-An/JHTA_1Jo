package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RentReturn extends JPanel {
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JTextField textField_4;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	public RentReturn() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTextField());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getTextField_1());
		add(getTextField_2());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getTextField_3());
		add(getTextField_4());
		add(getSeparator());
		add(getScrollPane());
		add(getBtnNewButton_1());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setBounds(311, 36, 82, 21);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(374, 33, 279, 27);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBounds(670, 32, 95, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
			lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
			lblNewLabel_1.setBounds(33, 60, 114, 35);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_2.setBounds(33, 110, 82, 21);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC774\uB984");
			lblNewLabel_3.setBounds(33, 163, 82, 21);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(115, 110, 166, 27);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(115, 160, 166, 27);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uB300\uCD9C\uAC00\uB2A5\uC5EC\uBD80");
			lblNewLabel_4.setBounds(356, 110, 114, 21);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_5.setBounds(356, 163, 95, 21);
		}
		return lblNewLabel_5;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(487, 110, 211, 27);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(487, 160, 211, 27);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(33, 202, 737, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 220, 767, 236);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uBC18\uB0A9");
			btnNewButton_1.setBounds(332, 475, 129, 29);
		}
		return btnNewButton_1;
	}
}
