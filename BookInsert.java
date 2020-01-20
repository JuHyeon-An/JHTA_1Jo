package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BookInsert extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public BookInsert() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLabel());
		add(getLabel_1());
		add(getLabel_2());
		add(getLabel_3());
		add(getLabel_4());
		add(getLabel_5());
		add(getLabel_6());
		add(getTextField());
		add(getTextField_1());
		add(getTextField_2());
		add(getTextField_3());
		add(getTextField_4());
		add(getTextField_5());
		add(getTextField_6());
		add(getTextField_7());
		add(getBtnNewButton());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB3C4\uC11C\uB4F1\uB85D");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 30));
			lblNewLabel.setBounds(14, 34, 520, 90);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uB3C4\uC11C\uBA85");
			lblNewLabel_1.setBounds(136, 146, 62, 18);
		}
		return lblNewLabel_1;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC800\uC790");
			label.setBounds(136, 186, 62, 18);
		}
		return label;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uCD9C\uD310\uC0AC");
			label_1.setBounds(136, 226, 62, 18);
		}
		return label_1;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uCD9C\uD310\uB144\uC6D4");
			label_2.setBounds(136, 266, 62, 18);
		}
		return label_2;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uAC00\uACA9");
			label_3.setBounds(136, 306, 62, 18);
		}
		return label_3;
	}
	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
			label_4.setBounds(136, 346, 62, 18);
		}
		return label_4;
	}
	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uBD84\uB958\uAE30\uD638");
			label_5.setBounds(136, 386, 62, 18);
		}
		return label_5;
	}
	public JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uD398\uC774\uC9C0\uC218");
			label_6.setBounds(136, 426, 62, 18);
		}
		return label_6;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(212, 136, 116, 24);
			textField.setColumns(10);
		}
		return textField;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(212, 177, 116, 24);
		}
		return textField_1;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(212, 218, 116, 24);
		}
		return textField_2;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(212, 259, 116, 24);
		}
		return textField_3;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(212, 300, 116, 24);
		}
		return textField_4;
	}
	public JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(212, 341, 116, 24);
		}
		return textField_5;
	}
	public JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(212, 382, 116, 24);
		}
		return textField_6;
	}
	public JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(212, 423, 116, 24);
		}
		return textField_7;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.setBounds(185, 464, 105, 27);
		}
		return btnNewButton;
	}
}
