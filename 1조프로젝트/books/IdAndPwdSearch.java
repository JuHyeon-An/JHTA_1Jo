package books;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class IdAndPwdSearch extends JFrame {
	private DialogMessage dm;
	private String msg = "";

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tName;
	private JTextField tEmail;
	private JTextField tId;
	private JTextField tEmail2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdAndPwdSearch frame = new IdAndPwdSearch();
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
	public IdAndPwdSearch() {
		setTitle("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getTName());
		contentPane.add(getTEmail());
		contentPane.add(getTId());
		contentPane.add(getTEmail2());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
			lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.BOLD, 24));
			lblNewLabel.setBounds(17, 15, 140, 35);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
			lblNewLabel_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 24));
			lblNewLabel_1.setBounds(17, 161, 150, 35);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_2.setBounds(37, 64, 70, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("e-Mail");
			lblNewLabel_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_3.setBounds(37, 100, 70, 25);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("ID");
			lblNewLabel_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_4.setBounds(37, 211, 70, 25);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("e_Mail");
			lblNewLabel_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_5.setBounds(37, 251, 70, 25);
		}
		return lblNewLabel_5;
	}
	private JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setBorder(null);
			tName.setBackground(new Color(224, 255, 255));
			tName.setForeground(new Color(0, 0, 0));
			tName.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
			tName.setBounds(124, 64, 200, 30);
			tName.setColumns(10);
		}
		return tName;
	}
	private JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setBorder(null);
			tEmail.setBackground(new Color(224, 255, 255));
			tEmail.setForeground(new Color(0, 0, 0));
			tEmail.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
			tEmail.setBounds(124, 100, 200, 30);
			tEmail.setColumns(10);
		}
		return tEmail;
	}
	private JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setBorder(null);
			tId.setBackground(new Color(224, 255, 255));
			tId.setForeground(new Color(0, 0, 0));
			tId.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
			tId.setBounds(124, 211, 200, 30);
			tId.setColumns(10);
		}
		return tId;
	}
	private JTextField getTEmail2() {
		if (tEmail2 == null) {
			tEmail2 = new JTextField();
			tEmail2.setBorder(null);
			tEmail2.setBackground(new Color(224, 255, 255));
			tEmail2.setForeground(new Color(0, 0, 0));
			tEmail2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
			tEmail2.setBounds(124, 250, 200, 30);
			tEmail2.setColumns(10);
		}
		return tEmail2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
			btnNewButton.setBorder(null);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(0, 153, 255));
			btnNewButton.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ¾ÆÀÌµð Ã£±â ¹öÆ° ´©¸£¸é
					m_UserDao dao = new m_UserDao();
					if(! tName.getText().isEmpty() && !tEmail.getText().isEmpty()) {
						String findId = dao.idSearch(tName.getText(), tEmail.getText());
						if(findId == null) {
							msg = "¾ÆÀÌµð¸¦ Ã£À» ¼ö ¾ø½À´Ï´Ù.";
						}
						else {
							msg = "ID : " + findId;
						}
					}else {
						msg = "°ø¹é¾øÀÌ ÀÔ·ÂÇÏ¼¼¿ä";
					}
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(IdAndPwdSearch.this);
					
				}
			});
			btnNewButton.setBounds(357, 63, 157, 62);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBackground(new Color(0, 153, 255));
			btnNewButton_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ºñ¹Ð¹øÈ£ Ã£±â ´©¸£¸é
					m_UserDao dao = new m_UserDao();
					if(! tId.getText().isEmpty() && !tEmail2.getText().isEmpty()) {
						boolean b = dao.pwdSearch(tId.getText(), tEmail2.getText());
						
						if(b==false) {
							msg = "ºñ¹Ð¹øÈ£¸¦ Ã£À» ¼ö ¾ø½À´Ï´Ù.";
						}
						else {
							msg = "ÀÌ¸ÞÀÏ·Î ºñ¹Ð¹øÈ£¸¦ Àü¼ÛÇß½À´Ï´Ù.";
						}
					}else {
						msg =  "°ø¹é¾øÀÌ ÀÔ·ÂÇÏ¼¼¿ä";
					}
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(IdAndPwdSearch.this);
				}
			});
			btnNewButton_1.setBounds(357, 211, 157, 66);
		}
		return btnNewButton_1;
	}
}
