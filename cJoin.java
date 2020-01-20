package books;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class cJoin extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel label;
	private JTextField textField_1;
	private JLabel label_1;
	private JTextField textField_2;
	private JLabel label_2;
	private JTextField textField_3;
	private JLabel label_3;
	private JTextField textField_4;
	private JLabel label_4;
	private JTextField textField_5;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cJoin frame = new cJoin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cJoin() {
		setBounds(100, 100, 900, 800);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLabel());
		getContentPane().add(getTextField_1());
		getContentPane().add(getLabel_1());
		getContentPane().add(getTextField_2());
		getContentPane().add(getLabel_2());
		getContentPane().add(getTextField_3());
		getContentPane().add(getLabel_3());
		getContentPane().add(getTextField_4());
		getContentPane().add(getLabel_4());
		getContentPane().add(getTextField_5());
		getContentPane().add(getBtnNewButton_1());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 45));
			lblNewLabel.setBounds(51, 38, 759, 65);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
			lblNewLabel_1.setBounds(129, 155, 147, 33);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(302, 161, 274, 33);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC911\uBCF5\uCCB4\uD06C");
			btnNewButton.setBounds(603, 161, 110, 33);
		}
		return btnNewButton;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
			label.setBounds(129, 239, 147, 33);
		}
		return label;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(302, 239, 274, 33);
		}
		return textField_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
			label_1.setBounds(102, 325, 176, 33);
		}
		return label_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(302, 325, 274, 33);
		}
		return textField_2;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC0DD\uC77C");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
			label_2.setBounds(129, 407, 147, 33);
		}
		return label_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(302, 413, 274, 33);
		}
		return textField_3;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uBC88\uD638");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
			label_3.setBounds(129, 486, 147, 33);
		}
		return label_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(302, 492, 274, 33);
		}
		return textField_4;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC774\uBA54\uC77C");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
			label_4.setBounds(129, 572, 147, 33);
		}
		return label_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(302, 572, 274, 33);
		}
		return textField_5;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD655\uC778");
			btnNewButton_1.setBounds(302, 664, 274, 40);
		}
		return btnNewButton_1;
	}
}
