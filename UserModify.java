package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserModify extends JPanel {
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

	
	public UserModify() {
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

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setBounds(29, 33, 57, 15);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC774\uB984");
			lblNewLabel_1.setBounds(29, 68, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC0DD\uB144\uC6D0\uC77C");
			lblNewLabel_2.setBounds(29, 103, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			lblNewLabel_3.setBounds(29, 140, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_4.setBounds(29, 180, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uD578\uB4DC\uD3F0");
			lblNewLabel_5.setBounds(29, 223, 57, 15);
		}
		return lblNewLabel_5;
	}
	public JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setEnabled(false);
			tId.setBounds(98, 30, 116, 21);
			tId.setColumns(10);
		}
		return tId;
	}
	public JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setEnabled(false);
			tName.setBounds(98, 65, 116, 21);
			tName.setColumns(10);
		}
		return tName;
	}
	public JTextField getTBirth() {
		if (tBirth == null) {
			tBirth = new JTextField();
			tBirth.setEnabled(false);
			tBirth.setBounds(98, 103, 116, 21);
			tBirth.setColumns(10);
		}
		return tBirth;
	}
	public JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setBounds(98, 140, 116, 21);
			tPwd.setColumns(10);
		}
		return tPwd;
	}
	public JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setBounds(98, 177, 116, 21);
			tEmail.setColumns(10);
		}
		return tEmail;
	}
	public JTextField getTPhone() {
		if (tPhone == null) {
			tPhone = new JTextField();
			tPhone.setBounds(98, 220, 116, 21);
			tPhone.setColumns(10);
		}
		return tPhone;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("수정");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// 수정 버튼 눌리면
					JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
				}
			});
			btnNewButton.setBounds(159, 297, 97, 23);
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("탈퇴");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// 탈퇴 버튼 눌리면
					JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
				}
			});
			btnNewButton_1.setBounds(336, 297, 97, 23);
		}
		return btnNewButton_1;
	}
}
