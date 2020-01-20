package books;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class MemberUpdate extends JPanel {
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JTextField textField_3;
	private JLabel label_1;
	private JTextField textField_4;
	private JLabel label_2;
	private JTextField textField_5;
	private JLabel label_3;
	private JTextField textField_6;
	private JLabel label_4;
	private JTextField textField_7;
	private JLabel label_5;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public MemberUpdate() {
		setLayout(null);
		add(getComboBox());
		add(getTextField());
		add(getBtnNewButton());
		add(getLblNewLabel());
		add(getTextField_1());
		add(getTextField_2());
		add(getLabel());
		add(getTextField_3());
		add(getLabel_1());
		add(getTextField_4());
		add(getLabel_2());
		add(getTextField_5());
		add(getLabel_3());
		add(getTextField_6());
		add(getLabel_4());
		add(getTextField_7());
		add(getLabel_5());
		add(getBtnNewButton_1());
		add(getBtnNewButton_2());
		add(getLblNewLabel_1());

	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(12, 10, 92, 43);
		}
		return comboBox;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(116, 10, 419, 43);
			textField.setColumns(10);
		}
		return textField;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 18));
			btnNewButton.setBounds(547, 10, 80, 43);
		}
		return btnNewButton;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 16));
			lblNewLabel.setBounds(27, 85, 92, 29);
		}
		return lblNewLabel;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(110, 86, 264, 29);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(110, 125, 264, 29);
		}
		return textField_2;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 16));
			label.setBounds(27, 124, 92, 29);
		}
		return label;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(110, 165, 264, 29);
		}
		return textField_3;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_1.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 16));
			label_1.setBounds(27, 164, 92, 29);
		}
		return label_1;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(110, 204, 264, 29);
		}
		return textField_4;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uB4F1\uB85D\uC77C");
			label_2.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 16));
			label_2.setBounds(27, 204, 92, 29);
		}
		return label_2;
	}
	public JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(110, 245, 264, 29);
		}
		return textField_5;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC774\uBA54\uC77C");
			label_3.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 16));
			label_3.setBounds(27, 244, 92, 29);
		}
		return label_3;
	}
	public JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(110, 284, 264, 29);
		}
		return textField_6;
	}
	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_4.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 16));
			label_4.setBounds(27, 284, 92, 29);
		}
		return label_4;
	}
	public JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(110, 323, 264, 29);
		}
		return textField_7;
	}
	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uB300\uCD9C\uC5EC\uBD80");
			label_5.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 16));
			label_5.setBounds(27, 324, 92, 29);
		}
		return label_5;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.setBounds(135, 397, 156, 53);
		}
		return btnNewButton_1;
	}
	public JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.setBounds(319, 397, 156, 53);
		}
		return btnNewButton_2;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC0AC\uC9C4?");
			lblNewLabel_1.setBounds(437, 204, 149, 29);
		}
		return lblNewLabel_1;
	}
}
