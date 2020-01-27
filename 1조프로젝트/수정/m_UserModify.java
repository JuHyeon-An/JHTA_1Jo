
// °³ÀÎÁ¤º¸°ü¸® JPanel
// ¹ÎÈ£ ÀÛ¼º

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

public class m_UserModify extends JPanel {

	protected static final int YES_NO_CANCEL_OPTION = 0;
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
			lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel.setBounds(30, 35, 100, 45);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC774\uB984");
			lblNewLabel_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_1.setBounds(30, 95, 100, 45);
		}
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC0DD\uB144\uC6D0\uC77C");
			lblNewLabel_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_2.setBounds(30, 155, 100, 45);
		}
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_3.setBounds(30, 215, 100, 45);
		}
		return lblNewLabel_3;
	}

	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_4.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_4.setBounds(30, 275, 100, 45);
		}
		return lblNewLabel_4;
	}

	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uD578\uB4DC\uD3F0");
			lblNewLabel_5.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			lblNewLabel_5.setBounds(30, 335, 100, 45);
		}
		return lblNewLabel_5;
	}

	public JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setAlignmentX(Component.LEFT_ALIGNMENT);
			tId.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
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
			tName.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
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
			tBirth.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
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
			tPwd.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			tPwd.setBounds(145, 215, 250, 45);
			tPwd.setColumns(10);
		}
		return tPwd;
	}

	public JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
			tEmail.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			tEmail.setBounds(145, 275, 250, 45);
			tEmail.setColumns(10);
		}
		return tEmail;
	}

	public JTextField getTPhone() {
		if (tPhone == null) {
			tPhone = new JTextField();
			tPhone.setAlignmentX(Component.LEFT_ALIGNMENT);
			tPhone.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			tPhone.setBounds(145, 335, 250, 45);
			tPhone.setColumns(10);
		}
		return tPhone;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("¼öÁ¤");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ¼öÁ¤¹öÆ° ´©¸£¸é

					m_UserDao dao = new m_UserDao();
					m_UserInfoVo vo = new m_UserInfoVo();

					// vo.setmId(tId.getText());
					// vo.setmPwd(tPwd.getText());
					//vo.setmEmail(tEmail.getText());
					//vo.setmPhone(tPhone.getText());

					if (tPwd.getText().isEmpty() || tEmail.getText().isEmpty() || tPhone.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "°ø¹é¾øÀÌ ÀÔ·ÂÇÏ¼¼¿ä.");
					} else {

						vo.setmId(tId.getText()); // ¾ÆÀÌµð ¹Þ¾Æ¿À°í
						if (Pattern.matches(MemberJoin.pwdPattern, tPwd.getText())) { // ÆÐ½º¿öµå ÆÐÅÏÀÌ ÀÏÄ¡ÇÏ¸é
							vo.setmPwd(tPwd.getText()); // vo¿¡ pwdÀÔ·Â
						} else { // ÆÐÅÏÀÌ ´Ù¸£¸é
							pwdS.setText("ºñ¹Ð¹øÈ£´Â ¿µ¾î+¼ýÀÚ 5~12ÀÚ¸®ÀÔ´Ï´Ù.");
						}
						if (Pattern.matches(MemberJoin.emailPattern, tEmail.getText())) {
							vo.setmEmail(tEmail.getText());
						} else {
							emailS.setText("¿Ã¹Ù¸£Áö ¾ÊÀº ÀÌ¸ÞÀÏ Çü½ÄÀÔ´Ï´Ù.");
						}
						if (Pattern.matches(MemberJoin.phonePattern, tPhone.getText())) {
							vo.setmPhone(tPhone.getText());
						} else {
							phoneS.setText("(-)¸¦ Æ÷ÇÔÇÏ¿© ÀÔ·ÂÇØÁÖ¼¼¿ä.");
						}

					}

					//////////////////////////////////
					int r = dao.update(vo);
					if (r > 0)
						JOptionPane.showMessageDialog(null, "¼öÁ¤ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
					else {
						JOptionPane.showMessageDialog(null, "¾ç½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇÏ¼¼¿ä.");
					}
				}

			});
			btnNewButton.setBounds(530, 560, 130, 45);
		}
		return btnNewButton;

	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Å»Åð");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m_UserModify umf = new m_UserModify();
					m_UserDao dao = new m_UserDao();
					int result = JOptionPane.showConfirmDialog(null, "Å»ÅðÇÏ½Ã°Ú½À´Ï±î?", null, JOptionPane.YES_NO_OPTION);
					int r = 0;
					if (result == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Å»Åð Ãë¼Ò");
					} else if (result == JOptionPane.YES_OPTION) {
						r = dao.delect(keyId);
						JOptionPane.showMessageDialog(null, "Å»Åð°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
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
			pwdS.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			pwdS.setOpaque(true);
			pwdS.setBounds(425, 215, 394, 45);
		}
		return pwdS;
	}
	private JLabel getEmailS() {
		if (emailS == null) {
			emailS = new JLabel("");
			emailS.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			emailS.setOpaque(true);
			emailS.setBounds(425, 275, 394, 45);
		}
		return emailS;
	}
	private JLabel getPhoneS() {
		if (phoneS == null) {
			phoneS = new JLabel("");
			phoneS.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 22));
			phoneS.setOpaque(true);
			phoneS.setBounds(425, 335, 394, 45);
		}
		return phoneS;
	}
}
