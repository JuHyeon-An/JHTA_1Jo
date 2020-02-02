package books;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class IdAndPwdSearch extends JFrame {
	private DialogMessage dm;
	private String msg = "";

	private JPanel contentPane;
	private JTextField tName;
	private JTextField tEmail;
	private JTextField tId;
	private JTextField tEmail2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_6;
	private JButton btn02;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdAndPwdSearch frame = new IdAndPwdSearch();
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
	public IdAndPwdSearch() {
		setTitle("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 612);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTName());
		contentPane.add(getTEmail());
		contentPane.add(getTId());
		contentPane.add(getTEmail2());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getBtn02());
		contentPane.add(getLblNewLabel_6());
	}
	private JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setBorder(null);
			tName.setBackground(new Color(224, 255, 255));
			tName.setForeground(new Color(0, 0, 0));
			tName.setFont(new Font("나눔고딕", Font.PLAIN, 20));
			tName.setBounds(116, 75, 200, 30);
			tName.setColumns(10);
		}
		return tName;
	}
	private JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setBorder(null);
			tEmail.setBackground(new Color(224, 255, 255));
			tEmail.setForeground(new Color(0, 0, 0));
			tEmail.setFont(new Font("나눔고딕", Font.PLAIN, 20));
			tEmail.setBounds(116, 123, 200, 30);
			tEmail.setColumns(10);
		}
		return tEmail;
	}
	private JTextField getTId() {
		if (tId == null) {
			tId = new JTextField();
			tId.setBorder(null);
			tId.setBackground(new Color(224, 255, 255));
			tId.setForeground(new Color(0, 0, 0));
			tId.setFont(new Font("나눔고딕", Font.PLAIN, 20));
			tId.setBounds(116, 270, 200, 30);
			tId.setColumns(10);
		}
		return tId;
	}
	private JTextField getTEmail2() {
		if (tEmail2 == null) {
			tEmail2 = new JTextField();
			tEmail2.setBorder(null);
			tEmail2.setBackground(new Color(224, 255, 255));
			tEmail2.setForeground(new Color(0, 0, 0));
			tEmail2.setFont(new Font("나눔고딕", Font.PLAIN, 20));
			tEmail2.setBounds(116, 321, 200, 30);
			tEmail2.setColumns(10);
		}
		return tEmail2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(IdAndPwdSearch.class.getResource("/iconBox/12.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(0, 153, 255));
			btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 아이디 찾기 버튼 누르면
					m_UserDao dao = new m_UserDao();
					if(! tName.getText().isEmpty() && !tEmail.getText().isEmpty()) {
						String findId = dao.idSearch(tName.getText(), tEmail.getText());
						if(findId == null) {
							msg = "아이디를 찾을 수 없습니다.";
						}
						else {
							msg = "ID : " + findId;
						}
					}else {
						msg = "공백없이 입력하세요";
					}
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(IdAndPwdSearch.this);
					
				}
			});
			btnNewButton.setBounds(116, 163, 85, 34);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon(IdAndPwdSearch.class.getResource("/iconBox/12.png")));
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBackground(new Color(0, 153, 255));
			btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 20));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 비밀번호 찾기 누르면
					m_UserDao dao = new m_UserDao();
					if(! tId.getText().isEmpty() && !tEmail2.getText().isEmpty()) {
						boolean b = dao.pwdSearch(tId.getText(), tEmail2.getText());
						
						if(b) {
							msg = "이메일로 비밀번호를 전송했습니다.";
						}
						else {
							msg = "비밀번호를 찾을 수 없습니다.";
						}
					}else {
						msg =  "공백없이 입력하세요";
					}
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(IdAndPwdSearch.this);
				}
			});
			btnNewButton_1.setBounds(116, 371, 85, 34);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon(IdAndPwdSearch.class.getResource("/iconBox/search.jpg")));
			lblNewLabel_6.setBounds(0, 0, 370, 574);
		}
		return lblNewLabel_6;
	}
	private JButton getBtn02() {
		if (btn02 == null) {
			btn02 = new JButton("");
			btn02.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {				
					tName.setText(" ");					
					tEmail.setText(" ");					
				}
			});
			btn02.setIcon(new ImageIcon(IdAndPwdSearch.class.getResource("/iconBox/13.png")));
			btn02.setBounds(231, 163, 85, 34);
		}
		return btn02;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					tId.setText(" ");				
					tEmail2.setText(" ");
				}
			});
			btnNewButton_3.setIcon(new ImageIcon(IdAndPwdSearch.class.getResource("/iconBox/13.png")));
			btnNewButton_3.setBounds(231, 371, 85, 34);
		}
		return btnNewButton_3;
	}
}
