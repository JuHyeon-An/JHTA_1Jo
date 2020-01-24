package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class BookCategoryInsert extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public BookCategoryInsert() {
		setPreferredSize(new Dimension(512, 340));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLabel());
		add(getTextField());
		add(getTextField_1());
		add(getBtnNewButton());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uBD84\uB958\uCF54\uB4DC \uB4F1\uB85D");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 30));
			lblNewLabel.setBounds(0, 31, 498, 90);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC7A5\uB974");
			lblNewLabel_1.setBounds(136, 146, 62, 18);
		}
		return lblNewLabel_1;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uCF54\uB4DC");
			label.setBounds(136, 186, 62, 18);
		}
		return label;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(212, 143, 116, 24);
			textField.setColumns(10);
		}
		return textField;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(212, 183, 116, 24);
		}
		return textField_1;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.setBounds(186, 234, 105, 27);
		}
		return btnNewButton;
	}
}
