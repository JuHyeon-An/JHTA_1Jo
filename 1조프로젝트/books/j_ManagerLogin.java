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

public class j_ManagerLogin extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tId;
	private JLabel label;
	private JTextField tPwd;
	private JButton btnNewButton;
	JFrame frame;
	String msg;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					j_ManagerLogin frame = new j_ManagerLogin();
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
	
	public j_ManagerLogin(JFrame frame) {
		this.frame = frame;
	}
	
	public void showMessage(String msg) {
		DialogMessage dm = new DialogMessage(msg);
		dm.setLocationRelativeTo(j_ManagerLogin.this);
	}	
	
	public j_ManagerLogin() {
		super("login", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 745, 513);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTId());
		getContentPane().add(getLabel());
		getContentPane().add(getTPwd());
		getContentPane().add(getBtnNewButton());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778 LOGIN");
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
	private JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setBounds(269, 191, 343, 37);
			tId.setColumns(10);
		}
		return tId;
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
	private JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JPasswordField();
			tPwd.setColumns(10);
			tPwd.setBounds(269, 289, 343, 37);
		}
		return tPwd;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uB85C\uADF8\uC778");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//로그인 버튼 누르면
					m_ManagerVo vo = new m_ManagerVo();
					vo.setmId(tId.getText());
					vo.setmPwd(tPwd.getText());
					
					m_ManagerDao dao = new m_ManagerDao();
					int r =dao.login(vo);
					if(r>0) {
						
						h_Manager_Main frame = new h_Manager_Main();
						frame.setVisible(true);
						
					}
					else {
						msg = "아이디 또는 패스워드를 확인해주세요.";
						showMessage(msg);
					}
					
				}
			});
			btnNewButton.setBounds(299, 374, 226, 50);
		}
		return btnNewButton;
	}
}
