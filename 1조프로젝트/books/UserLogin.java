package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import books.DialogMessage;
import books.UserDao;
import books.UserLogin;
import books.UserMain;
import books.UserVo;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserLogin extends JInternalFrame {
	private JTextField tmId;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JFrame frame;
	private JPasswordField tpwd;
	private JButton btnNewButton_2;
	private DialogMessage dm;
	private JLabel label;
	private JButton btnNewButton_3;

	
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

	public UserLogin() {
		super("로그인", true, true, true, true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
		setBounds(100, 50, 376, 556);
		getContentPane().setLayout(null);
		getContentPane().add(getTmId());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getTpwd());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getBtnNewButton_3());
		getContentPane().add(getLabel());
	}
	
	
	public void login() {
		String msg = "";
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
					
				} else {
					msg = "아이디 또는 비밀번호가 틀렸습니다.";
					showMessage(msg);
				}
			} else {
				msg = "아이디 또는 비밀번호에 공백이 있습니다.";
				showMessage(msg);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showMessage(String msg) {
		dm = new DialogMessage(msg);
		dm.setLocationRelativeTo(UserLogin.this);
	}
	
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setBorder(null);
			tmId.setSelectionColor(new Color(255, 250, 240));
			tmId.setBackground(SystemColor.textHighlightText);
			tmId.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			tmId.setBounds(149, 72, 182, 27);
			tmId.setColumns(10);
		}
		return tmId;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setOpaque(false);
			btnNewButton.setMargin(new Insets(0, 0, 0, 0));
			btnNewButton.setSize(new Dimension(85, 34));
			btnNewButton.setIcon(new ImageIcon(UserLogin.class.getResource("/iconBox/03.png")));
			btnNewButton.setActionCommand("");
			btnNewButton.setBorderPainted(false);
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 40));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				
					
				}


				
			});
			btnNewButton.setBounds(149, 210, 79, 35);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setOpaque(false);
			btnNewButton_1.setIcon(new ImageIcon(UserLogin.class.getResource("/iconBox/05.png")));
			btnNewButton_1.setSize(new Dimension(72, 24));
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setIconTextGap(1);
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 24));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 회원가입 버튼 누르면
					MemberJoin a = new MemberJoin();
					a.toFront();
				}
			});
			btnNewButton_1.setBounds(258, 171, 73, 27);
		}
		return btnNewButton_1;
	}
	public JPasswordField getTpwd() {
		if (tpwd == null) {
			tpwd = new JPasswordField();
			tpwd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					if(e.getKeyCode() == e.VK_ENTER) {
						login();
					}
					
				}
			});
			tpwd.setBorder(null);
			tpwd.setBackground(SystemColor.textHighlightText);
			tpwd.setFont(new Font("나눔고딕", Font.PLAIN, 22));
			tpwd.setBounds(149, 134, 182, 27);
		}
		return tpwd;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("");
			btnNewButton_2.setOpaque(false);
			btnNewButton_2.setIcon(new ImageIcon(UserLogin.class.getResource("/iconBox/11.png")));
			btnNewButton_2.setBackground(Color.WHITE);
			btnNewButton_2.setFont(new Font("나눔고딕", Font.BOLD, 20));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 아이디 / 패스워드 찾기
					IdAndPwdSearch frame = new IdAndPwdSearch();
					updateUI();
					frame.toFront();
					
				}
			});
			btnNewButton_2.setBorder(null);
			btnNewButton_2.setBounds(149, 254, 183, 34);
		}
		return btnNewButton_2;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(UserLogin.class.getResource("/iconBox/UserLogin.gif")));
			label.setBounds(0, 0, 370, 523);
		}
		return label;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("");
			btnNewButton_3.setBorder(null);
			btnNewButton_3.setOpaque(false);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					tmId.setText("");
					tpwd.setText("");
					
				}
			});
			btnNewButton_3.setIcon(new ImageIcon(UserLogin.class.getResource("/iconBox/04.png")));
			btnNewButton_3.setBounds(252, 210,  79, 35);
		}
		return btnNewButton_3;
	}
}
