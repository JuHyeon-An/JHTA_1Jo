package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cMain extends JFrame {
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton button;
	private JLabel lblNewLabel_1;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cMain frame = new cMain();
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
	public cMain() {
		setBounds(100, 100, 900, 800);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getComboBox());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getButton());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLabel());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC911\uC559HTA \uB3C4\uC11C\uAD00");
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 45));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(35, 63, 814, 84);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"       \uC804\uCCB4", "       \uC11C\uBA85", "       \uC800\uC790", "       \uCD9C\uD310\uC0AC"}));
			comboBox.setBounds(46, 231, 93, 36);
		}
		return comboBox;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(151, 232, 581, 36);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				SearchFrame sf = new SearchFrame();
				getContentPane().add(sf);
				sf.setVisible(true);
				}
			});
			btnNewButton.setBounds(744, 231, 97, 36);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AC\uC6A9\uC790 \uB85C\uADF8\uC778");
			btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
			btnNewButton_1.setBounds(46, 328, 388, 46);
		}
		return btnNewButton_1;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
			button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
			button.setBounds(453, 328, 388, 46);
		}
		return button;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACF5\uC9C0\uC0AC\uD56D");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
			lblNewLabel_1.setBounds(46, 436, 388, 36);
		}
		return lblNewLabel_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBCA0\uC2A4\uD2B8\uC140\uB7EC");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
			label.setBounds(461, 436, 388, 36);
		}
		return label;
	}
}
