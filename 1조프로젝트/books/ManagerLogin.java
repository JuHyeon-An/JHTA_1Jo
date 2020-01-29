package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ManagerLogin extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton button;
	private JTextField status;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	JFrame frame = new BookMain();
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLogin frame = new ManagerLogin();
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
	
	public ManagerLogin(JFrame frame) {
		this.frame = frame;
	}
	
	public ManagerLogin() {
		super("login", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 745, 720);
		getContentPane().setLayout(null);
		getContentPane().add(getTextField());
		getContentPane().add(getTextField_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getButton());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getLabel_1());

	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(269, 191, 343, 37);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(269, 289, 343, 37);
		}
		return textField_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					h_Manager_Main frame = new h_Manager_Main();
					frame.setVisible(true);
					
					
				}
			});
			btnNewButton.setBounds(116, 466, 226, 50);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("New button");
			button.setBounds(386, 466, 226, 50);
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
			status.setBounds(116, 584, 496, 50);
		}
		return status;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uACE0\uAC1D\uB2D8 \uC911\uC559HTA \uB3C4\uC11C\uAD00 \uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694?");
			lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(116, 380, 373, 28);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberJoin a = new MemberJoin();
					getContentPane().add(a);
					a.toFront();
					updateUI();
				}
			});
			btnNewButton_1.setBounds(464, 385, 148, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JHTA\\Desktop\\userLogin.gif"));
			lblNewLabel.setBounds(0, 0, 729, 681);
		}
		return lblNewLabel;
	}
}
