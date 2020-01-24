package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

public class UserHopeBook extends JPanel {
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public UserHopeBook() {
		setPreferredSize(new Dimension(630, 490));
		setLayout(null);
		add(getLabel());
		add(getLabel_1());
		add(getLblNewLabel());
		add(getTextField());
		add(getLblNewLabel_1());
		add(getTextField_1());
		add(getLblNewLabel_2());
		add(getTextField_2());
		add(getBtnNewButton());

	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(318, 5, 0, 0);
		}
		return label;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD76C\uB9DD \uB3C4\uC11C \uC2E0\uCCAD");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(144, 40, 310, 15);
		}
		return label_1;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC11C\uBA85");
			lblNewLabel.setBounds(64, 115, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(163, 112, 282, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC800\uC790");
			lblNewLabel_1.setBounds(64, 191, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(163, 188, 282, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
			lblNewLabel_2.setBounds(64, 263, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(165, 260, 282, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E0\uCCAD");
			btnNewButton.setBounds(177, 366, 214, 107);
		}
		return btnNewButton;
	}
}
