package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class caLogin extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton button;
	private JTextField status;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cLogin frame = new cLogin();
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
	public caLogin() {
		setBounds(100, 100, 900, 797);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTextField());
		getContentPane().add(getLabel());
		getContentPane().add(getTextField_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getBtnNewButton_1());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB85C\uADF8\uC778 LOGIN");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 45));
			lblNewLabel.setBounds(12, 62, 860, 73);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
			lblNewLabel_1.setBounds(204, 223, 109, 36);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(346, 223, 343, 37);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
			label.setBounds(156, 312, 157, 36);
		}
		return label;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(346, 321, 343, 37);
		}
		return textField_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD655\uC778");
			btnNewButton.setBounds(193, 498, 226, 50);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uCDE8\uC18C");
			button.setBounds(463, 498, 226, 50);
		}
		return button;
	}
	private JTextField getStatus() {
		if (status == null) {
			status = new JTextField();
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setText("status");
			status.setBackground(Color.WHITE);
			status.setColumns(10);
			status.setBounds(193, 616, 496, 50);
		}
		return status;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uACE0\uAC1D\uB2D8 \uC911\uC559HTA \uB3C4\uC11C\uAD00 \uAD00\uB9AC\uC790\uAC00 \uC544\uB2C8\uC2E0\uAC00\uC694?");
			lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(176, 412, 373, 28);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnNewButton_1.setBounds(556, 417, 148, 23);
		}
		return btnNewButton_1;
	}
}
