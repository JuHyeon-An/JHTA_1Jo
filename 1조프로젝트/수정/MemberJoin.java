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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class MemberJoin extends JFrame {

	static String idPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$"; // 영어,숫자 5~12자리
	static String pwdPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$"; // 영어,숫자 5~12자리
	static String namePattern = "[가-힇]{2,20}"; // 한글만 2~20자리
	static String phonePattern = "\\d{2,3}-\\d{3,4}-\\d{4}";
	static String emailPattern = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
			

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField mId;
	private JButton btnNewButton;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField phone;
	private JLabel label_4;
	private JTextField email;
	private JButton btnNewButton_1;
	private JButton button;
	private JPanel panel;
	private JLabel lblNewLabel_2;
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
		setTitle("회원가입");
		setVisible(true);
		setBounds(100, 100, 811, 800);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(0, 0, 709, 65);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 50));
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(73, 110, 110, 35);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		}
		return lblNewLabel_1;
	}

	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			mId.setBorder(null);
			mId.setBackground(new Color(224, 255, 255));
			mId.setBounds(251, 110, 274, 35);
			mId.setColumns(10);
		}
		return mId;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC911\uBCF5\uCCB4\uD06C");
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBackground(new Color(0, 153, 255));
			btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 중복 체크 누르면
					d_MemberDao dao = new d_MemberDao();

					if (Pattern.matches(idPattern, mId.getText())) { // 아이디가 패턴에 일치하면
						int r = dao.idCheck(mId.getText());
						if (r > 0) {
							checkId = 1;
							JOptionPane.showMessageDialog(null, "사용가능");
						} else {
							checkId = 0;
							JOptionPane.showMessageDialog(null, "아이디가 중복됩니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "아이디 양식에 맞게 작성하세요");
					}
				}
			});
			btnNewButton.setBounds(552, 110, 110, 33);
		}
		return btnNewButton;
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label.setBounds(36, 180, 147, 35);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
			label_1.setBounds(7, 250, 176, 35);
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC0DD\uC77C");
			label_2.setBounds(36, 390, 147, 35);
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		}
		return label_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
			label_3.setBounds(36, 460, 147, 35);
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		}
		return label_3;
	}

	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			phone.setBorder(null);
			phone.setBackground(new Color(224, 255, 255));
			phone.setBounds(251, 460, 274, 35);
			phone.setColumns(10);
		}
		return phone;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC774\uBA54\uC77C");
			label_4.setBounds(36, 530, 147, 35);
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		}
		return label_4;
	}

	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			email.setBorder(null);
			email.setBackground(new Color(224, 255, 255));
			email.setBounds(251, 530, 274, 35);
			email.setColumns(10);
		}
		return email;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD655\uC778");
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(0, 153, 255));
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 22));
			btnNewButton_1.setBounds(251, 611, 127, 40);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						d_MemberVo vo = new d_MemberVo();
						d_MemberDao dao = new d_MemberDao();					

						String birth = comboBox.getSelectedItem() + "-" + comboBox_1.getSelectedItem() + "-"
								+ comboBox_2.getSelectedItem(); 
						if (!mId.getText().equals("") && !pwd.getText().equals("") && !pwdCheck.getText().equals("")
								&& !mName.getText().equals("") && !phone.getText().equals("")
								&& !email.getText().equals("")) { // 입력란에 공백이 없을떄 경우
							
							if (Pattern.matches(idPattern, mId.getText())) { // 아이디 패턴이 일치하면
								vo.setmId(mId.getText());
							} else {
								idS.setText("아이디는 영어+숫자 5~12자리입니다.");
							}
							if (Pattern.matches(pwdPattern, pwd.getText())) { // 패스워드 패턴이 일치하면
								vo.setmPwd(pwd.getText());
								if (!(pwd.getText().equals(pwdCheck.getText()))) {
									status.setText("비밀번호가 일치하지 않습니다.");
									checkPwd = 0;
								} else {
									status.setText("비밀번호가 일치합니다.");
									vo.setmPwdCheck(pwdPattern);
									checkPwd = 1;
								}
							} else {
								pwdS.setText("비밀번호는 영어+숫자 5~12자리입니다.");
							}
							if (Pattern.matches(namePattern, mName.getText())) {
								vo.setmName(mName.getText());
							} else {
								nameS.setText("한글로 작성해 주세요.");
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
							

							if (checkId > 0 && checkPwd > 0) { // 아이디가 중복이 아니고 비밀번호가 일치하면
								int r = dao.cJoin(vo);
								if (r > 0) {
									JOptionPane.showMessageDialog(null, "가입성공");
									dispose();
								} else {
									if (dao.emailCheck(email.getText())) { // 이메일이 중복되면
										JOptionPane.showMessageDialog(null, "중복된 이메일 입니다.");
									}
									if (dao.phoneCheck(phone.getText())) { // 핸드폰 번호가 중복되면
										JOptionPane.showMessageDialog(null, "중복된 번호 입니다.");
									}
								}
							} else {
								if (checkId == 0) {
									JOptionPane.showMessageDialog(null, "아이디 중복체크 하세요");
								} else if (checkPwd == 0) {
									JOptionPane.showMessageDialog(null, "비밀번호를 확인하세요");
								}
							}

						} else {
							JOptionPane.showMessageDialog(null, "공백없이 입력하세요");
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
			button = new JButton("\uCDE8\uC18C");
			button.setBorder(null);
			button.setBackground(new Color(0, 153, 255));
			button.setForeground(Color.WHITE);
			button.setFont(new Font("나눔고딕", Font.BOLD, 22));
			button.setBounds(398, 611, 127, 40);
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
			panel.setBackground(Color.WHITE);
			panel.setBounds(31, 38, 729, 666);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getMId());
			panel.add(getBtnNewButton());
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getPhone());
			panel.add(getLabel_4());
			panel.add(getEmail());
			panel.add(getBtnNewButton_1());
			panel.add(getButton());
			panel.add(getLblNewLabel_2());
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
		}
		return panel;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 25));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(73, 320, 110, 35);
		}
		return lblNewLabel_2;
	}

	public JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			mName.setBorder(null);
			mName.setBackground(new Color(224, 255, 255));
			mName.setBounds(251, 320, 274, 35);
			mName.setColumns(10);
		}
		return mName;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setFont(new Font("나눔고딕", Font.PLAIN, 18));
			status.setBounds(542, 250, 187, 35);
		}
		return status;
	}

	public JLabel getPwdS() {
		if (pwdS == null) {
			pwdS = new JLabel("");
			pwdS.setBackground(Color.WHITE);
			pwdS.setFont(new Font("나눔고딕", Font.PLAIN, 18));
			pwdS.setOpaque(true);
			pwdS.setBounds(251, 146, 478, 34);
		}
		return pwdS;
	}

	public JPasswordField getPwd() {
		if (pwd == null) {
			pwd = new JPasswordField();
			pwd.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			pwd.setBorder(null);
			pwd.setBackground(new Color(224, 255, 255));
			pwd.setBounds(251, 180, 274, 35);
		}
		return pwd;
	}

	public JPasswordField getPwdCheck() {
		if (pwdCheck == null) {
			pwdCheck = new JPasswordField();
			pwdCheck.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			pwdCheck.setBorder(null);
			pwdCheck.setBackground(new Color(224, 255, 255));
			pwdCheck.setBounds(251, 250, 274, 35);
		}
		return pwdCheck;
	}

	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			comboBox.setBackground(Color.WHITE);
			comboBox.setBounds(251, 390, 95, 35);
			for (int i = 1950; i < 2020; i++) {
				comboBox.addItem(i);
			}
		}
		return comboBox;
	}

	public JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			comboBox_1.setBackground(Color.WHITE);
			comboBox_1.setBounds(358, 390, 75, 35);
			for (int i = 1; i <= 12; i++) {
				comboBox_1.addItem(i);
			}
		}
		return comboBox_1;
	}

	public JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			comboBox_2.setBackground(Color.WHITE);
			comboBox_2.setBounds(445, 390, 80, 35);
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
			idS.setFont(new Font("나눔고딕", Font.PLAIN, 18));
			idS.setOpaque(true);
			idS.setBounds(251, 75, 478, 34);
		}
		return idS;
	}

	private JLabel getNameS() {
		if (nameS == null) {
			nameS = new JLabel("");
			nameS.setBackground(Color.WHITE);
			nameS.setFont(new Font("나눔고딕", Font.PLAIN, 18));
			nameS.setOpaque(true);
			nameS.setBounds(251, 285, 478, 34);
		}
		return nameS;
	}

	private JLabel getPhoneS() {
		if (phoneS == null) {
			phoneS = new JLabel("");
			phoneS.setBackground(Color.WHITE);
			phoneS.setFont(new Font("나눔고딕", Font.PLAIN, 18));
			phoneS.setBounds(251, 425, 478, 34);
		}
		return phoneS;
	}

	private JLabel getEmailS() {
		if (emailS == null) {
			emailS = new JLabel("");
			emailS.setBackground(Color.WHITE);
			emailS.setFont(new Font("나눔고딕", Font.PLAIN, 18));
			emailS.setBounds(251, 495, 478, 34);
		}
		return emailS;
	}
}
