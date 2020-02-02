package books;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class MemberJoin extends JFrame {

	static String idPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$"; 
	static String pwdPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
//	static String namePattern = "{2,20}";
	static String phonePattern = "\\d{2,3}-\\d{3,4}-\\d{4}";
	static String emailPattern = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
	private String msg = "";

	private DialogMessage dm;
	private JTextField mId;
	private JButton btnNewButton;
	private JTextField phone;
	private JTextField email;
	private JButton btnNewButton_1;
	private JButton button;
	private JPanel panel;
	private JTextField name;
	private JTextField mName;
	private JLabel status;
	private int checkId;
	private int checkPwd;
	private JLabel pwdS;
	private JPasswordField pwd;
	private JPasswordField pwdCheck;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JLabel idS;
	private JLabel nameS;
	private JLabel phoneS;
	private JLabel emailS;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberJoin frame = new MemberJoin();
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
	public MemberJoin() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("JOIN");
		setVisible(true);
		setBounds(100, 100, 643, 854);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
	}

	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			mId.setBorder(null);
			mId.setBackground(new Color(224, 255, 255));
			mId.setBounds(199, 136, 254, 35);
			mId.setColumns(10);
		}
		return mId;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(MemberJoin.class.getResource("/iconBox/08.png")));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(new Color(0, 153, 255));
			btnNewButton.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					d_MemberDao dao = new d_MemberDao();
					String msg = "";

					if (Pattern.matches(idPattern, mId.getText())) { 
						int r = dao.idCheck(mId.getText());
						if (r > 0) {
							checkId = 1;
							msg = "사용할 수 있는 ID 입니다.";
							dm = new DialogMessage(msg);
							dm.setLocationRelativeTo(MemberJoin.this);
						} else {
							checkId = 0;
							msg = "아이디가 중복됩니다.";
							dm = new DialogMessage(msg);
							dm.setLocationRelativeTo(MemberJoin.this);
						}
					} else {
						msg = "아이디 양식에 맞게 작성하세요.";
						dm = new DialogMessage(msg);
						dm.setLocationRelativeTo(MemberJoin.this);
					}
				
				}
			});
			btnNewButton.setBounds(476, 136, 108, 35);
		}
		return btnNewButton;
	}

	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			phone.setBorder(null);
			phone.setBackground(new Color(224, 255, 255));
			phone.setBounds(199, 469, 274, 35);
			phone.setColumns(10);
		}
		return phone;
	}

	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			email.setBorder(null);
			email.setBackground(new Color(224, 255, 255));
			email.setBounds(199, 524, 274, 35);
			email.setColumns(10);
		}
		return email;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon(MemberJoin.class.getResource("/iconBox/09.png")));
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(0, 153, 255));
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			btnNewButton_1.setBounds(201, 611, 108, 35);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						d_MemberVo vo = new d_MemberVo();
						d_MemberDao dao = new d_MemberDao();					

						String birth = comboBox.getSelectedItem() + "-" + comboBox_1.getSelectedItem() + "-"
								+ comboBox_2.getSelectedItem(); 
						if (!mId.getText().equals("") && !pwd.getText().equals("") && !pwdCheck.getText().equals("")
								&& !mName.getText().equals("") && !phone.getText().equals("")
								&& !email.getText().equals("")) { 
							
							if (Pattern.matches(idPattern, mId.getText())) { 
								vo.setmId(mId.getText());
							} else {
								idS.setText("아이디는 영어+숫자 5~12 자리입니다.");
							}
							if (Pattern.matches(pwdPattern, pwd.getText())) { 
								vo.setmPwd(pwd.getText());
								if (!(pwd.getText().equals(pwdCheck.getText()))) {
									status.setText("비밀번호가 일치하지 않습니다.");
									checkPwd = 0;
								} else {
									vo.setmPwdCheck(pwdPattern);
									checkPwd = 1;
								}
							} else {
								pwdS.setText("비밀번호는 영어+숫자 5~12자리로 작성해주세요.");
							}
							if (Pattern.matches(phonePattern, phone.getText())) {
								vo.setmPhone(phone.getText());
							} else {
								phoneS.setText("(-)를 포함하여 입력해주세요.");
							}
							if (Pattern.matches(emailPattern, email.getText())) {
								vo.setmEmail(email.getText());
							} else {
								emailS.setText("올바르지 않은 이메일 형식입니다.");
							}
							vo.setmBirth(birth);
							vo.setmName(mName.getText());

							if (checkId > 0 && checkPwd > 0) { 
								int r = dao.cJoin(vo);
								if (r > 0) {
									msg = "가입을 축하합니다.";
									dm = new DialogMessage(msg);
									dm.setLocationRelativeTo(MemberJoin.this);
									dispose();
								} else {
									msg = "양식에 맞게 입력하세요.";
									if (dao.emailCheck(email.getText())) { 
										msg = "중복된 이메일입니다.";
										
									}
									if (dao.phoneCheck(phone.getText())) {
										msg = "중복된 번호입니다.";
										
									}
									dm = new DialogMessage(msg);
									dm.setLocationRelativeTo(MemberJoin.this);
								}
							} else {
								if (checkId == 0) {
									msg = "아이디 중복체크를 먼저 해주세요.";
									dm = new DialogMessage(msg);
									dm.setLocationRelativeTo(MemberJoin.this);
									
								} else if (checkPwd == 0) {
									msg = "비밀번호를 확인하세요.";
									dm = new DialogMessage(msg);
									dm.setLocationRelativeTo(MemberJoin.this);
								}
							}

						} else {
							msg = "공백없이 입력하세요.";
							dm = new DialogMessage(msg);
							dm.setLocationRelativeTo(MemberJoin.this);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}
		return btnNewButton_1;

	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.setIcon(new ImageIcon(MemberJoin.class.getResource("/iconBox/10.png")));
			button.setBorder(null);
			button.setBackground(new Color(0, 153, 255));
			button.setForeground(Color.WHITE);
			button.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			button.setBounds(352, 611, 108, 35);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return button;
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setOpaque(false);
			panel.setBackground(Color.WHITE);
			panel.setBounds(12, 0, 615, 806);
			panel.setLayout(null);
			panel.add(getMId());
			panel.add(getBtnNewButton());
			panel.add(getPhone());
			panel.add(getEmail());
			panel.add(getBtnNewButton_1());
			panel.add(getButton());
			panel.add(getMName());
			panel.add(getStatus());
			panel.add(getPwdS());
			panel.add(getPwd());
			panel.add(getPwdCheck());
			panel.add(getComboBox());
			panel.add(getComboBox_1());
			panel.add(getComboBox_2());
			panel.add(getIdS());
			panel.add(getNameS());
			panel.add(getPhoneS());
			panel.add(getEmailS());
			panel.add(getLblNewLabel());
		}
		return panel;
	}

	public JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			mName.setBorder(null);
			mName.setBackground(new Color(224, 255, 255));
			mName.setBounds(199, 336, 257, 35);
			mName.setColumns(10);
		}
		return mName;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			status.setBounds(455, 271, 137, 35);
		}
		return status;
	}

	public JLabel getPwdS() {
		if (pwdS == null) {
			pwdS = new JLabel("");
			pwdS.setForeground(Color.RED);
			pwdS.setBackground(Color.WHITE);
			pwdS.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			pwdS.setBounds(199, 187, 385, 20);
		}
		return pwdS;
	}

	public JPasswordField getPwd() {
		if (pwd == null) {
			pwd = new JPasswordField();
			pwd.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			pwd.setBorder(null);
			pwd.setBackground(new Color(224, 255, 255));
			pwd.setBounds(201, 205, 254, 35);
		}
		return pwd;
	}

	public JPasswordField getPwdCheck() {
		if (pwdCheck == null) {
			pwdCheck = new JPasswordField();
			pwdCheck.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			pwdCheck.setBorder(null);
			pwdCheck.setBackground(new Color(224, 255, 255));
			pwdCheck.setBounds(201, 271, 257, 35);
		}
		return pwdCheck;
	}

	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			comboBox.setBackground(Color.WHITE);
			comboBox.setBounds(189, 402, 95, 35);
			for (int i = 1950; i < 2020; i++) {
				comboBox.addItem(i);
			}
		}
		return comboBox;
	}

	public JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			comboBox_1.setBackground(Color.WHITE);
			comboBox_1.setBounds(301, 402, 75, 35);
			for (int i = 1; i <= 12; i++) {
				comboBox_1.addItem(i);
			}
		}
		return comboBox_1;
	}

	public JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
			comboBox_2.setBackground(Color.WHITE);
			comboBox_2.setBounds(393, 402, 80, 35);
			for (int i = 1; i <= 31; i++) {
				comboBox_2.addItem(i);
			}
		}
		return comboBox_2;
	}

	private JLabel getIdS() {
		if (idS == null) {
			idS = new JLabel("");
			idS.setBackground(Color.WHITE);
			idS.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			idS.setBounds(199, 110, 404, 22);
		}
		return idS;
	}

	private JLabel getNameS() {
		if (nameS == null) {
			nameS = new JLabel("");
			nameS.setBackground(Color.WHITE);
			nameS.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			nameS.setBounds(199, 372, 254, 20);
		}
		return nameS;
	}

	private JLabel getPhoneS() {
		if (phoneS == null) {
			phoneS = new JLabel("");
			phoneS.setBackground(Color.WHITE);
			phoneS.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			phoneS.setBounds(199, 448, 385, 20);
		}
		return phoneS;
	}

	private JLabel getEmailS() {
		if (emailS == null) {
			emailS = new JLabel("");
			emailS.setBackground(Color.WHITE);
			emailS.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			emailS.setBounds(199, 505, 386, 20);
		}
		return emailS;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(MemberJoin.class.getResource("/iconBox/aa20014.jpg")));
			lblNewLabel.setBounds(0, 10, 603, 796);
		}
		return lblNewLabel;
	}
}
