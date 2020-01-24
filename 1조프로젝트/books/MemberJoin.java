package books;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MemberJoin extends JFrame {
	
	static String idCheck1 = "\\w{4,10}";
	static String pwdCheck1 = "[\\w!$]{4,10}";
	static String nameCheck1 = "[가-힇]{2,20}";
	static String birthCheck1 = "\\d{4}-\\d{2}-\\d{2}";
	static String phoneCheck1 = "\\d{2,3}-\\d{3,4}-\\d{4}";
	static String emailCheck1 = "/^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$/i";
	
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
	int checkId;
	int checkPwd;
	private JLabel statusId;
	private JPasswordField pwd;
	private JPasswordField pwdCheck;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

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
		// super("회원가입", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 900, 800);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
			lblNewLabel.setBounds(0, 0, 759, 65);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 45));
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(78, 117, 147, 33);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		}
		return lblNewLabel_1;
	}

	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setBounds(251, 123, 274, 33);
			mId.setColumns(10);
		}
		return mId;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC911\uBCF5\uCCB4\uD06C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 중복 체크 누르면

					String idCheck = mId.getText();
					d_MemberDao dao = new d_MemberDao();

					int r = dao.idCheck(idCheck);

					if (r > 0) {
						checkId = 1;
						JOptionPane.showMessageDialog(null, "가능");
					} else {
						checkId = 0;
						JOptionPane.showMessageDialog(null, "아이디가 중복됩니다.");
					}
				}
			});
			btnNewButton.setBounds(552, 123, 110, 33);
		}
		return btnNewButton;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label.setBounds(78, 201, 147, 33);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
			label_1.setBounds(48, 273, 176, 33);
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC0DD\uC77C");
			label_2.setBounds(78, 426, 147, 33);
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		}
		return label_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
			label_3.setBounds(78, 501, 147, 33);
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		}
		return label_3;
	}

	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(251, 507, 274, 33);
			phone.setColumns(10);
		}
		return phone;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC774\uBA54\uC77C");
			label_4.setBounds(78, 564, 147, 33);
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		}
		return label_4;
	}

	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setBounds(251, 570, 274, 33);
			email.setColumns(10);
		}
		return email;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD655\uC778");
			btnNewButton_1.setBounds(251, 626, 127, 40);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						d_MemberVo vo = new d_MemberVo();
						d_MemberDao dao = new d_MemberDao();						
						
						
						String id = mId.getText();						
						String pwd1 = pwd.getText();
						String pwdCheck1 = pwdCheck.getText();
						String name = mName.getText();
						String birth1 = comboBox.getSelectedItem()+"-"+comboBox_1.getSelectedItem()+"-"+comboBox_2.getSelectedItem();							//birth.getText();
						String phone1 = phone.getText();
						String email1 = email.getText();
						if (!mId.getText().equals("") && !pwd.getText().equals("") && !pwdCheck.getText().equals("")
								&& !mName.getText().equals("")
								&& !phone.getText().equals("") && !email.getText().equals("")) {

							vo.setmId(id);
							vo.setmPwd(pwd1);
							vo.setmPwdCheck(pwdCheck1);
							vo.setmName(name);
							vo.setmBirth(birth1);
							vo.setmPhone(phone1);
							vo.setmEmail(email1);

							if (!(pwd.getText().equals(pwdCheck.getText()))) {
								status.setText("비밀번호를 확인하세요");
								checkPwd = 0;
							} else {
								status.setText("확인");
								checkPwd = 1;
							}

							if (checkId > 0 && checkPwd > 0) {
								int r = dao.cJoin(vo);
								if (r > 0) {
									JOptionPane.showMessageDialog(null, "가입성공");
									dispose();
								} else {
									if(dao.emailCheck(email1)) { // 이메일이 중복되면
										
										JOptionPane.showMessageDialog(null, "중복된 이메일 입니다.");
									}
									if(dao.phoneCheck(phone1)) {
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

						}else {
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
			button.setBounds(398, 626, 127, 40);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return button;
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(51, 38, 759, 666);
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
			panel.add(getStatusId());
			panel.add(getPwd());
			panel.add(getPwdCheck());
			panel.add(getComboBox());
			panel.add(getComboBox_1());
			panel.add(getComboBox_2());
		}
		return panel;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC131\uBA85");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(147, 359, 110, 33);
		}
		return lblNewLabel_2;
	}

	public JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(251, 359, 274, 33);
			mName.setColumns(10);
		}
		return mName;
	}

	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setBounds(552, 273, 167, 30);
		}
		return status;
	}

	public JLabel getStatusId() {
		if (statusId == null) {
			statusId = new JLabel("");
			statusId.setBounds(251, 166, 274, 25);
		}
		return statusId;
	}
	public JPasswordField getPwd() {
		if (pwd == null) {
			pwd = new JPasswordField();
			pwd.setBounds(251, 201, 274, 33);
		}
		return pwd;
	}
	public JPasswordField getPwdCheck() {
		if (pwdCheck == null) {
			pwdCheck = new JPasswordField();
			pwdCheck.setBounds(251, 273, 274, 33);
		}
		return pwdCheck;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(259, 438, 87, 21);	
			for(int i=1950 ; i<2020; i++) {
				comboBox.addItem(i);				
			}
		}			
		return comboBox;
	}
	public JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(358, 438, 75, 21);
			for(int i = 1; i<=12; i++) {
				comboBox_1.addItem(i);
			}
		}
		return comboBox_1;
	}
	public JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setBounds(445, 438, 80, 21);
			for(int i = 1; i<=31; i++) {
				comboBox_2.addItem(i);
			}
		}
		return comboBox_2;
	}
}
