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
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class j_ManagerLogin extends JInternalFrame {
	private JTextField tId;
	private JTextField tPwd;
	private JButton btnNewButton;
	JFrame frame;
	String msg;
	private JButton button;
	private JLabel lblNewLabel;
	
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
	
	public void login() {
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
	
	public void showMessage(String msg) {
		DialogMessage dm = new DialogMessage(msg);
		dm.setLocationRelativeTo(j_ManagerLogin.this);
	}	
	
	public j_ManagerLogin() {
		super("login", true, true, true, true);
		setVisible(true);
		setBounds(400, 50, 375, 530);
		getContentPane().setLayout(null);
		getContentPane().add(getTId());
		getContentPane().add(getTPwd());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getButton());
		getContentPane().add(getLblNewLabel());

	}
	private JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setBounds(141, 56, 189, 29);
			tId.setColumns(10);
		}
		return tId;
	}
	private JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JPasswordField();
			tPwd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					if(e.getKeyCode() == e.VK_ENTER) {
						login();
					}
				}
			});
			tPwd.setColumns(10);
			tPwd.setBounds(141, 119, 189, 29);
		}
		return tPwd;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setBorderPainted(false);
			btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
			btnNewButton.setIcon(new ImageIcon(j_ManagerLogin.class.getResource("/iconBox/06.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}

				
			});
			btnNewButton.setBounds(141, 172, 85, 34);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tId.setText("");
					tPwd.setText("");
					
				}
			});
			button.setBorder(new EmptyBorder(0, 0, 0, 0));
			button.setBorderPainted(false);
			button.setIcon(new ImageIcon(j_ManagerLogin.class.getResource("/iconBox/07.png")));
			button.setBounds(245, 172, 85, 34);
		}
		return button;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(j_ManagerLogin.class.getResource("/iconBox/adminLogin.gif")));
			lblNewLabel.setBounds(0, 0, 359, 501);
		}
		return lblNewLabel;
	}
}
