package books;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserLogin extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tmId;
	private JLabel label;
	private JButton btnNewButton;
	
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	//JFrame frame = new BookMain();
	JFrame frame;
	private JPasswordField tpwd;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
/*
	public UserLogin(JFrame frame) {
		this.frame = frame;
	}
*/
	public UserLogin() {
		super("login", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 745, 720);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTmId());
		getContentPane().add(getLabel());
		getContentPane().add(getBtnNewButton());
		
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getTpwd());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB85C\uADF8\uC778 LOGIN");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 45));
			lblNewLabel.setBounds(12, 62, 726, 73);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 32));
			lblNewLabel_1.setBounds(127, 191, 109, 36);
		}
		return lblNewLabel_1;
	}

	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setBounds(269, 191, 343, 37);
			tmId.setColumns(10);
		}
		return tmId;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("맑은 고딕", Font.BOLD, 32));
			label.setBounds(79, 280, 157, 36);
		}
		return label;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uB85C\uADF8\uC778");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
							} else
								JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 잘못되었습니다.");							
						}else {
							JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호에 공백이 있습니다.");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(263, 460, 226, 50);
		}
		return btnNewButton;
	}



	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel(
					"\uACE0\uAC1D\uB2D8 \uC911\uC559HTA \uB3C4\uC11C\uAD00 \uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694?");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(116, 380, 373, 28);
		}
		return lblNewLabel_2;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 회원가입 버튼 누르면
					MemberJoin a = new MemberJoin();
					//getContentPane().add(a);
					a.toFront();
					// a.updateUI();
				}
			});
			btnNewButton_1.setBounds(464, 385, 148, 23);
		}
		return btnNewButton_1;
	}
	public JPasswordField getTpwd() {
		if (tpwd == null) {
			tpwd = new JPasswordField();
			tpwd.setBounds(269, 280, 343, 38);
		}
		return tpwd;
	}
}
