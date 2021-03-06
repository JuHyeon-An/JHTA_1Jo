
// ������������ JPanel
// ��ȣ �ۼ�

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
import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel_6;

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
		add(getLblNewLabel_6());
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
			lblNewLabel.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			lblNewLabel.setBounds(30, 35, 51, 45);
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC774\uB984");
			lblNewLabel_1.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(30, 106, 51, 45);
		}
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC0DD\uB144\uC6D0\uC77C");
			lblNewLabel_2.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(12, 178, 69, 45);
		}
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_3.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			lblNewLabel_3.setBounds(12, 260, 69, 45);
		}
		return lblNewLabel_3;
	}

	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_4.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			lblNewLabel_4.setBounds(12, 343, 100, 23);
		}
		return lblNewLabel_4;
	}

	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uD578\uB4DC\uD3F0");
			lblNewLabel_5.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			lblNewLabel_5.setBounds(12, 413, 61, 45);
		}
		return lblNewLabel_5;
	}

	public JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setAlignmentX(Component.LEFT_ALIGNMENT);
			tId.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			tId.setEnabled(false);
			tId.setBounds(148, 43, 250, 29);
			tId.setColumns(10);
		}
		return tId;
	}

	public JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setAlignmentX(Component.LEFT_ALIGNMENT);
			tName.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			tName.setEnabled(false);
			tName.setBounds(148, 114, 250, 29);
			tName.setColumns(10);
		}
		return tName;
	}

	public JTextField getTBirth() {
		if (tBirth == null) {
			tBirth = new JTextField();
			tBirth.setAlignmentX(Component.LEFT_ALIGNMENT);
			tBirth.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			tBirth.setEnabled(false);
			tBirth.setBounds(148, 186, 250, 29);
			tBirth.setColumns(10);
		}
		return tBirth;
	}

	public JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setAlignmentX(Component.LEFT_ALIGNMENT);
			tPwd.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			tPwd.setBounds(148, 268, 250, 29);
			tPwd.setColumns(10);
		}
		return tPwd;
	}

	public JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
			tEmail.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			tEmail.setBounds(148, 340, 250, 29);
			tEmail.setColumns(10);
		}
		return tEmail;
	}

	public JTextField getTPhone() {
		if (tPhone == null) {
			tPhone = new JTextField();
			tPhone.setAlignmentX(Component.LEFT_ALIGNMENT);
			tPhone.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			tPhone.setBounds(148, 421, 250, 29);
			tPhone.setColumns(10);
		}
		return tPhone;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(m_UserModify.class.getResource("/iconBox/14.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ������ư ������

					m_UserDao dao = new m_UserDao();
					m_UserInfoVo vo = new m_UserInfoVo();

					// vo.setmId(tId.getText());
					// vo.setmPwd(tPwd.getText());
					//vo.setmEmail(tEmail.getText());
					//vo.setmPhone(tPhone.getText());

					if (tPwd.getText().isEmpty() || tEmail.getText().isEmpty() || tPhone.getText().isEmpty()) {
						msg = "������� �Է��ϼ���.";
					} else {

						vo.setmId(tId.getText()); // ���̵� �޾ƿ���
						if (Pattern.matches(MemberJoin.pwdPattern, tPwd.getText())) { // �н����� ������ ��ġ�ϸ�
							vo.setmPwd(tPwd.getText()); // vo�� pwd�Է�
						} else { // ������ �ٸ���
							pwdS.setText("��й�ȣ�� ����+���� 5~12�ڸ��Դϴ�.");
						}
						if (Pattern.matches(MemberJoin.emailPattern, tEmail.getText())) {
							vo.setmEmail(tEmail.getText());
						} else {
							emailS.setText("�ùٸ��� ���� �̸��� �����Դϴ�.");
						}
						if (Pattern.matches(MemberJoin.phonePattern, tPhone.getText())) {
							vo.setmPhone(tPhone.getText());
						} else {
							phoneS.setText("(-)�� �����Ͽ� �Է����ּ���.");
						}
						
						int r = dao.update(vo);
						if (r > 0)
							msg = "������ �Ϸ�Ǿ����ϴ�.";
						else {
							msg = "��Ŀ� �°� �Է��ϼ���.";
						}

					}
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(m_UserModify.this);

					
				}

			});
			btnNewButton.setBounds(155, 508, 85, 34);
		}
		return btnNewButton;

	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon(m_UserModify.class.getResource("/iconBox/15.png")));
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(176, 224, 230));
			btnNewButton_1.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m_UserModify umf = new m_UserModify();
					m_UserDao dao = new m_UserDao();
					
					
					int result = JOptionPane.showConfirmDialog(null, "Ż���Ͻðڽ��ϱ�?", null, JOptionPane.YES_NO_OPTION);
					int r = 0;
					if (result == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Ż�� ���");
					} else if (result == JOptionPane.YES_OPTION) {
						r = dao.delect(keyId);
						JOptionPane.showMessageDialog(null, "Ż�� �Ϸ�Ǿ����ϴ�.");
						System.exit(0);
					}
					
				}
			});
			btnNewButton_1.setBounds(274, 508, 85, 34);
		}
		return btnNewButton_1;
	}

	private JLabel getPwdS() {
		if (pwdS == null) {
			pwdS = new JLabel("");
			pwdS.setBackground(new Color(240, 248, 255));
			pwdS.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			pwdS.setOpaque(true);
			pwdS.setBounds(148, 301, 369, 16);
		}
		return pwdS;
	}
	private JLabel getEmailS() {
		if (emailS == null) {
			emailS = new JLabel("");
			emailS.setBackground(new Color(240, 248, 255));
			emailS.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			emailS.setOpaque(true);
			emailS.setBounds(148, 372, 394, 16);
		}
		return emailS;
	}
	private JLabel getPhoneS() {
		if (phoneS == null) {
			phoneS = new JLabel("");
			phoneS.setBackground(new Color(240, 248, 255));
			phoneS.setFont(new Font("�����ٸ�����", Font.PLAIN, 16));
			phoneS.setOpaque(true);
			phoneS.setBounds(143, 452, 387, 16);
		}
		return phoneS;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon(m_UserModify.class.getResource("/iconBox/004.jpg")));
			lblNewLabel_6.setBounds(0, 0, 836, 645);
		}
		return lblNewLabel_6;
	}
}
