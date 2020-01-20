package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BookDetail extends JInternalFrame {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton button;
	private JButton button_1;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel label_12;
	private JTextField textField_11;
	private JButton button_2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDetail frame = new BookDetail();
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
	public BookDetail() {
		setBounds(100, 100, 753, 597);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getLabel_3());
		getContentPane().add(getLabel_4());
		getContentPane().add(getLabel_5());
		getContentPane().add(getLabel_6());
		getContentPane().add(getLabel_7());
		getContentPane().add(getLabel_8());
		getContentPane().add(getTextField());
		getContentPane().add(getTextField_1());
		getContentPane().add(getTextField_2());
		getContentPane().add(getTextField_3());
		getContentPane().add(getTextField_4());
		getContentPane().add(getTextField_5());
		getContentPane().add(getTextField_6());
		getContentPane().add(getTextField_7());
		getContentPane().add(getButton());
		getContentPane().add(getButton_1());
		getContentPane().add(getLabel_9());
		getContentPane().add(getLabel_10());
		getContentPane().add(getLabel_11());
		getContentPane().add(getTextField_8());
		getContentPane().add(getTextField_9());
		getContentPane().add(getTextField_10());
		getContentPane().add(getLabel_12());
		getContentPane().add(getTextField_11());
		getContentPane().add(getButton_2());
		getContentPane().add(getLblNewLabel());

	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC0C1\uC138\uBCF4\uAE30");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("±¼¸²", Font.PLAIN, 30));
			label.setBounds(14, 12, 697, 90);
		}
		return label;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uB3C4\uC11C\uBA85");
			label_1.setBounds(136, 124, 62, 18);
		}
		return label_1;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC800\uC790");
			label_2.setBounds(136, 164, 62, 18);
		}
		return label_2;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uCD9C\uD310\uC0AC");
			label_3.setBounds(136, 204, 62, 18);
		}
		return label_3;
	}
	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uCD9C\uD310\uB144\uC6D4");
			label_4.setBounds(136, 244, 62, 18);
		}
		return label_4;
	}
	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uAC00\uACA9");
			label_5.setBounds(136, 284, 62, 18);
		}
		return label_5;
	}
	public JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
			label_6.setBounds(136, 324, 62, 18);
		}
		return label_6;
	}
	public JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uBD84\uB958\uAE30\uD638");
			label_7.setBounds(136, 364, 62, 18);
		}
		return label_7;
	}
	public JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("\uD398\uC774\uC9C0\uC218");
			label_8.setBounds(136, 404, 62, 18);
		}
		return label_8;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(212, 114, 116, 24);
		}
		return textField;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(212, 155, 116, 24);
		}
		return textField_1;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(212, 196, 116, 24);
		}
		return textField_2;
	}
	public JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(212, 237, 116, 24);
		}
		return textField_3;
	}
	public JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(212, 278, 116, 24);
		}
		return textField_4;
	}
	public JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(212, 319, 116, 24);
		}
		return textField_5;
	}
	public JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(212, 360, 116, 24);
		}
		return textField_6;
	}
	public JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(212, 401, 116, 24);
		}
		return textField_7;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uC218\uC815");
			button.setBounds(136, 453, 105, 27);
		}
		return button;
	}
	public JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC0AD\uC81C");
			button_1.setBounds(255, 453, 105, 27);
		}
		return button_1;
	}
	public JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("\uB300\uCD9C\uC0C1\uD0DC");
			label_9.setBounds(439, 114, 62, 18);
		}
		return label_9;
	}
	public JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("\uC608\uC57D\uC790\uC218");
			label_10.setBounds(439, 155, 62, 18);
		}
		return label_10;
	}
	public JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("\uB300\uCD9C\uC790");
			label_11.setBounds(439, 199, 62, 18);
		}
		return label_11;
	}
	public JTextField getTextField_8() {
		if (textField_8 == null) {
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(503, 111, 116, 24);
		}
		return textField_8;
	}
	public JTextField getTextField_9() {
		if (textField_9 == null) {
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(503, 152, 116, 24);
		}
		return textField_9;
	}
	public JTextField getTextField_10() {
		if (textField_10 == null) {
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			textField_10.setBounds(503, 196, 116, 24);
		}
		return textField_10;
	}
	public JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("\uBC18\uB0A9\uAE30\uD55C");
			label_12.setBounds(439, 240, 62, 18);
		}
		return label_12;
	}
	public JTextField getTextField_11() {
		if (textField_11 == null) {
			textField_11 = new JTextField();
			textField_11.setColumns(10);
			textField_11.setBounds(503, 241, 116, 24);
		}
		return textField_11;
	}
	public JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("\uC5F0\uC7A5");
			button_2.setBounds(620, 240, 91, 27);
		}
		return button_2;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC5EC\uAE30\uB294 \uC544\uB9C8.. \uC0AC\uC9C4?\u314E;");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(386, 284, 324, 239);
		}
		return lblNewLabel;
	}
}
