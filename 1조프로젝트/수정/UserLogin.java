package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import books.DialogMessage;
import books.UserDao;
import books.UserLogin;
import books.UserMain;
import books.UserVo;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class UserLogin extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tmId;
	private JLabel lblPassword;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JFrame frame;
	private JPasswordField tpwd;
	private JButton btnNewButton_2;
	private DialogMessage dm;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserLogin() {
		super("·Î±×ÀÎ", true, true, true, true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
		setBounds(100, 100, 663, 614);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTmId());
		getContentPane().add(getLblPassword());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getTpwd());
		getContentPane().add(getBtnNewButton_2());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
			lblNewLabel.setBounds(31, 33, 255, 94);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
			lblNewLabel_1.setBounds(60, 190, 109, 40);
		}
		return lblNewLabel_1;
	}

	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setBorder(null);
			tmId.setSelectionColor(new Color(255, 250, 240));
			tmId.setBackground(new Color(224, 255, 255));
			tmId.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			tmId.setBounds(196, 190, 416, 50);
			tmId.setColumns(10);
		}
		return tmId;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPassword.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
			lblPassword.setBounds(12, 280, 157, 40);
		}
		return lblPassword;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uB85C\uADF8\uC778");
			btnNewButton.setBorderPainted(false);
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(30, 144, 255));
			btnNewButton.setFont(new Font("³ª´®°íµñ", Font.BOLD, 40));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String msg = "";
					try {
						UserDao dao = new UserDao();
						UserVo vo = new UserVo();
						vo.setTmId(tmId.getText());
						vo.setTpwd(tpwd.getText());

						if (!tmId.getText().equals("") && !tpwd.getText().equals("")) {
							int cnt = dao.insert(vo);
							if (cnt > 0) {
								UserMain frame = new UserMain(vo.getTmId());
								frame.setVisible(true);
							} else {
								msg = "¾ÆÀÌµð ¶Ç´Â ºñ¹Ð¹øÈ£°¡ Æ²·È½À´Ï´Ù.";
							}
						} else {
							msg = "¾ÆÀÌµð ¶Ç´Â ºñ¹Ð¹øÈ£¿¡ °ø¹éÀÌ ÀÖ½À´Ï´Ù.";
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(UserLogin.this);
				}
			});
			btnNewButton.setBounds(31, 359, 581, 94);
		}
		return btnNewButton;
	}



	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel(
					"\uC911\uC559HTA \uB3C4\uC11C\uAD00 \uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694?");
			lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
			lblNewLabel_2.setBounds(150, 468, 360, 45);
		}
		return lblNewLabel_2;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setIconTextGap(1);
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 24));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// È¸¿ø°¡ÀÔ ¹öÆ° ´©¸£¸é
					MemberJoin a = new MemberJoin();
					//getContentPane().add(a);
					a.toFront();
					// a.updateUI();
				}
			});
			btnNewButton_1.setBounds(488, 468, 117, 45);
		}
		return btnNewButton_1;
	}
	public JPasswordField getTpwd() {
		if (tpwd == null) {
			tpwd = new JPasswordField();
			tpwd.setBorder(null);
			tpwd.setBackground(new Color(224, 255, 255));
			tpwd.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			tpwd.setBounds(196, 280, 416, 50);
		}
		return tpwd;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
			btnNewButton_2.setBackground(Color.WHITE);
			btnNewButton_2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ¾ÆÀÌµð / ÆÐ½º¿öµå Ã£±â
					IdAndPwdSearch frame = new IdAndPwdSearch();
					
					frame.toFront();
					
				}
			});
			btnNewButton_2.setBorder(null);
			btnNewButton_2.setBounds(196, 518, 255, 40);
		}
		return btnNewButton_2;
	}
}
