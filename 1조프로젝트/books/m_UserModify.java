
// 개인정보관리 JPanel
// 민호 작성

package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;
import java.awt.Color;

public class m_UserModify extends JPanel {

	protected static final int YES_NO_CANCEL_OPTION = 0;
	private DialogMessage dm;
	private String msg = "";
	private String keyId;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tId;
	private JTextField tName;
	private JTextField tBirth;
	private JTextField tPwd;
	private JTextField tEmail;
	private JTextField tPhone;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel pwdS;
	private JLabel emailS;
	private JLabel phoneS;

	public m_UserModify() {
		setBorder(null);
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(836, 627));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getTId());
		add(getTName());
		add(getTBirth());
		add(getTPwd());
		add(getTEmail());
		add(getTPhone());
		add(getBtnNewButton());
		add(getBtnNewButton_1());
		add(getPwdS());
		add(getEmailS());
		add(getPhoneS());
	}

	public m_UserModify(String keyId) {
		this();
		this.keyId = keyId;
		m_UserDao dao = new m_UserDao();
		m_UserInfoVo vo = dao.search(keyId);

		tId.setText(vo.getmId());
		tName.setText(vo.getmName());
		tBirth.setText(vo.getmBirth());
		tPwd.setText(vo.getmPwd());
		tEmail.setText(vo.getmEmail());
		tPhone.setText(vo.getmPhone());
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			lblNewLabel.setBounds(30, 35, 100, 45);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC774\uB984");
			lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(30, 95, 100, 45);
		}
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC0DD\uB144\uC6D0\uC77C");
			lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(30, 155, 100, 45);
		}
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			lblNewLabel_3.setBounds(30, 215, 100, 45);
		}
		return lblNewLabel_3;
	}

	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			lblNewLabel_4.setBounds(30, 275, 100, 45);
		}
		return lblNewLabel_4;
	}

	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uD578\uB4DC\uD3F0");
			lblNewLabel_5.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			lblNewLabel_5.setBounds(30, 335, 100, 45);
		}
		return lblNewLabel_5;
	}

	public JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setAlignmentX(Component.LEFT_ALIGNMENT);
			tId.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			tId.setEnabled(false);
			tId.setBounds(145, 35, 250, 45);
			tId.setColumns(10);
		}
		return tId;
	}

	public JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setAlignmentX(Component.LEFT_ALIGNMENT);
			tName.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			tName.setEnabled(false);
			tName.setBounds(145, 95, 250, 45);
			tName.setColumns(10);
		}
		return tName;
	}

	public JTextField getTBirth() {
		if (tBirth == null) {
			tBirth = new JTextField();
			tBirth.setAlignmentX(Component.LEFT_ALIGNMENT);
			tBirth.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			tBirth.setEnabled(false);
			tBirth.setBounds(145, 155, 250, 45);
			tBirth.setColumns(10);
		}
		return tBirth;
	}

	public JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setAlignmentX(Component.LEFT_ALIGNMENT);
			tPwd.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			tPwd.setBounds(145, 215, 250, 45);
			tPwd.setColumns(10);
		}
		return tPwd;
	}

	public JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
			tEmail.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			tEmail.setBounds(145, 275, 250, 45);
			tEmail.setColumns(10);
		}
		return tEmail;
	}

	public JTextField getTPhone() {
		if (tPhone == null) {
			tPhone = new JTextField();
			tPhone.setAlignmentX(Component.LEFT_ALIGNMENT);
			tPhone.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			tPhone.setBounds(145, 335, 250, 45);
			tPhone.setColumns(10);
		}
		return tPhone;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("수정");
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 수정버튼 누르면

					m_UserDao dao = new m_UserDao();
					m_UserInfoVo vo = new m_UserInfoVo();

					// vo.setmId(tId.getText());
					// vo.setmPwd(tPwd.getText());
					//vo.setmEmail(tEmail.getText());
					//vo.setmPhone(tPhone.getText());

					if (tPwd.getText().isEmpty() || tEmail.getText().isEmpty() || tPhone.getText().isEmpty()) {
						msg = "공백없이 입력하세요.";
					} else {

						vo.setmId(tId.getText()); // 아이디 받아오고
						if (Pattern.matches(MemberJoin.pwdPattern, tPwd.getText())) { // 패스워드 패턴이 일치하면
							vo.setmPwd(tPwd.getText()); // vo에 pwd입력
						} else { // 패턴이 다르면
							pwdS.setText("비밀번호는 영어+숫자 5~12자리입니다.");
						}
						if (Pattern.matches(MemberJoin.emailPattern, tEmail.getText())) {
							vo.setmEmail(tEmail.getText());
						} else {
							emailS.setText("올바르지 않은 이메일 형식입니다.");
						}
						if (Pattern.matches(MemberJoin.phonePattern, tPhone.getText())) {
							vo.setmPhone(tPhone.getText());
						} else {
							phoneS.setText("(-)를 포함하여 입력해주세요.");
						}
						
						int r = dao.update(vo);
						if (r > 0)
							msg = "수정이 완료되었습니다.";
						else {
							msg = "양식에 맞게 입력하세요.";
						}

					}
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(m_UserModify.this);

					
				}

			});
			btnNewButton.setBounds(530, 560, 130, 45);
		}
		return btnNewButton;

	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("탈퇴");
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(176, 224, 230));
			btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m_UserModify umf = new m_UserModify();
					m_UserDao dao = new m_UserDao();
					
					
					int result = JOptionPane.showConfirmDialog(null, "탈퇴하시겠습니까?", null, JOptionPane.YES_NO_OPTION);
					int r = 0;
					if (result == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "탈퇴 취소");
					} else if (result == JOptionPane.YES_OPTION) {
						r = dao.delect(keyId);
						JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
						System.exit(0);
					}
					
				}
			});
			btnNewButton_1.setBounds(689, 560, 130, 45);
		}
		return btnNewButton_1;
	}

	private JLabel getPwdS() {
		if (pwdS == null) {
			pwdS = new JLabel("");
			pwdS.setBackground(new Color(240, 248, 255));
			pwdS.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			pwdS.setOpaque(true);
			pwdS.setBounds(425, 215, 394, 45);
		}
		return pwdS;
	}
	private JLabel getEmailS() {
		if (emailS == null) {
			emailS = new JLabel("");
			emailS.setBackground(new Color(240, 248, 255));
			emailS.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			emailS.setOpaque(true);
			emailS.setBounds(425, 275, 394, 45);
		}
		return emailS;
	}
	private JLabel getPhoneS() {
		if (phoneS == null) {
			phoneS = new JLabel("");
			phoneS.setBackground(new Color(240, 248, 255));
			phoneS.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
			phoneS.setOpaque(true);
			phoneS.setBounds(425, 335, 394, 45);
		}
		return phoneS;
	}
}
