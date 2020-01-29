package books;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class p_MemberUpdate extends JPanel {
	private JTextField tfind;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTextField tmId;
	private JTextField tmName;
	private JLabel label;
	private JTextField tBirth;
	private JLabel label_1;
	private JTextField trDate;
	private JLabel label_2;
	private JTextField tEmail;
	private JLabel label_3;
	private JTextField tPhone;
	private JLabel label_4;
	private JTextField tState;
	private JLabel label_5;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel label_6;
	private JTextField tPwd;
	private JSeparator separator;
	DialogMessage dm;

	/**
	 * Create the panel.
	 */ 
	public p_MemberUpdate() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(900, 567));
		setLayout(null);
		add(getTfind());
		add(getBtnNewButton()); 
		add(getLblNewLabel());
		add(getTmId());
		add(getTmName());
		add(getLabel());
		add(getTBirth());
		add(getLabel_1());
		add(getTrDate());
		add(getLabel_2());
		add(getTEmail());
		add(getLabel_3());
		add(getTPhone());
		add(getLabel_4());
		add(getTState());
		add(getLabel_5());
		add(getBtnNewButton_1());
		add(getBtnNewButton_2());
		add(getLabel_6());
		add(getTPwd());
		add(getSeparator());

	}

	public void search() {
		String find = tfind.getText();
		p_MemberDao dao = new p_MemberDao();
		p_MemberVo vo = dao.search(find);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if(dao.idCheck(find)==1) {
			
		
		tmId.setText(vo.getmId());			
		tPwd.setText(vo.getPwd());
		tmName.setText(vo.getmName());
		try {
			tBirth.setText(sdf.format(sdf.parse(vo.getBirth())));
			trDate.setText(sdf.format(sdf.parse(vo.getrDate())));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		tEmail.setText(vo.getEmail());
		tPhone.setText(vo.getPhone());
		if(vo.getState().equals("1")) {
		tState.setText("대출가능");
		}else {
		tState.setText("대출불가");
		}
		}else {
			String msg = "해당 아이디가 존재하지 않습니다.";
			dm = new DialogMessage(msg);
			dm.setLocationRelativeTo(p_MemberUpdate.this);
			
		}
	} 
	
	public JTextField getTfind() {
		if (tfind == null) {
			tfind = new JTextField();
			tfind.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					if(arg0.getKeyCode() == arg0.VK_ENTER) {
						search();
					}
					
				}
			});
			tfind.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					
					tfind.setText("");
					
				}
			});
			tfind.setForeground(Color.GRAY);
			tfind.setBackground(Color.WHITE);
			tfind.setText("\uC218\uC815\uD558\uAC70\uB098 \uC0AD\uC81C\uD560 \uD68C\uC6D0\uC758 \uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694.");
			tfind.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tfind.setBounds(274, 28, 349, 29);
			tfind.setColumns(10);
		}
		return tfind;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					search();
				}

				
			});
			btnNewButton.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			btnNewButton.setBounds(659, 28, 80, 29);
		}
		return btnNewButton;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel.setBounds(224, 101, 92, 29);
		}
		return lblNewLabel;
	}

	public JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setForeground(new Color(34, 139, 34));
			tmId.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tmId.setEnabled(false);
			tmId.setBounds(328, 101, 264, 29);
			tmId.setColumns(10);
		}
		return tmId;
	}

	public JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setForeground(new Color(34, 139, 34));
			tmName.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tmName.setColumns(10);
			tmName.setBounds(328, 183, 264, 29);
		}
		return tmName;
	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setForeground(new Color(0, 0, 0));
			label.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			label.setBounds(224, 183, 92, 29);
		}
		return label;
	}

	public JTextField getTBirth() {
		if (tBirth == null) {
			tBirth = new JTextField();
			tBirth.setForeground(new Color(34, 139, 34));
			tBirth.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tBirth.setColumns(10);
			tBirth.setBounds(328, 224, 264, 29);
		}
		return tBirth;
	}

	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setForeground(new Color(0, 0, 0));
			label_1.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			label_1.setBounds(224, 224, 92, 29);
		}
		return label_1;
	}

	public JTextField getTrDate() {
		if (trDate == null) {
			trDate = new JTextField();
			trDate.setForeground(new Color(34, 139, 34));
			trDate.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			trDate.setColumns(10);
			trDate.setBounds(328, 265, 264, 29);
		}
		return trDate;
	}

	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uB4F1\uB85D\uC77C");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setForeground(new Color(0, 0, 0));
			label_2.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			label_2.setBounds(224, 266, 92, 29);
		}
		return label_2;
	}

	public JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setForeground(new Color(34, 139, 34));
			tEmail.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tEmail.setColumns(10);
			tEmail.setBounds(328, 306, 264, 29);
		}
		return tEmail;
	}

	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC774\uBA54\uC77C");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setForeground(new Color(0, 0, 0));
			label_3.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			label_3.setBounds(224, 306, 92, 29);
		}
		return label_3;
	}

	public JTextField getTPhone() {
		if (tPhone == null) {
			tPhone = new JTextField();
			tPhone.setForeground(new Color(34, 139, 34));
			tPhone.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tPhone.setColumns(10);
			tPhone.setBounds(328, 347, 264, 29);
		}
		return tPhone;
	}

	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setForeground(new Color(0, 0, 0));
			label_4.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			label_4.setBounds(224, 347, 92, 29);
		}
		return label_4;
	}

	public JTextField getTState() {
		if (tState == null) {
			tState = new JTextField();
			tState.setForeground(new Color(34, 139, 34));
			tState.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tState.setColumns(10);
			tState.setBounds(328, 388, 264, 29);
		}
		return tState;
	}

	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uB300\uCD9C\uC5EC\uBD80");
			label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			label_5.setForeground(new Color(0, 0, 0));
			label_5.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			label_5.setBounds(224, 388, 92, 29);
		}
		return label_5;
	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBackground(new Color(176, 224, 230));
			btnNewButton_1.setForeground(new Color(0, 0, 0));
			btnNewButton_1.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String p = tPwd.getText();
					String m = tmName.getText();
					String b = tBirth.getText();
					String d = trDate.getText();
					String em = tEmail.getText();
					String ph = tPhone.getText();
					String st = tState.getText();
					String msg = "";
					p_MemberDao dao = new p_MemberDao();
					p_MemberVo vo = new p_MemberVo();

					if(!p.equals("")&&!m.equals("")&&!b.equals("")&&!d.equals("")&&!em.equals("")&&!ph.equals("")&&!st.equals("")) {
						
					try {
						Date date; 
						vo.setPwd(tPwd.getText());
						vo.setmName(tmName.getText());
						vo.setBirth(tBirth.getText());
						vo.setrDate(trDate.getText());
						vo.setEmail(tEmail.getText());
						vo.setPhone(tPhone.getText());
						if(tState.getText().equals("대출가능")) {
							vo.setState("1");							
						}else {
							vo.setState("0");
						}
						vo.setmId(tmId.getText());
						
						int r = dao.update(vo);
						
						
						msg = r>0? "수정이 완료되었습니다." : "수정 중 오류발생";
						

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				  }else {
					  msg = "모든 항목을 입력해주세요";
				  }
					
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(p_MemberUpdate.this);
				}
			});
			btnNewButton_1.setBounds(328, 452, 121, 42);
		}
		return btnNewButton_1;
	}

	public JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uD0C8\uD1F4");
			btnNewButton_2.setBorder(null);
			btnNewButton_2.setBackground(new Color(176, 224, 230));
			btnNewButton_2.setForeground(new Color(0, 0, 0));
			btnNewButton_2.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					p_MemberDao dao = new p_MemberDao();
					String mId = tmId.getText();   
                    try { 
					int r = dao.delete(mId);
					String msg = r>0 ? "탈퇴가 완료되었습니다." : "탈퇴 중 오류발생";
	
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(p_MemberUpdate.this);
					
					tmId.setText("");
					tPwd.setText("");
					tmName.setText("");
					tBirth.setText("");
					trDate.setText("");
					tEmail.setText("");
					tPhone.setText("");
					tState.setText("");
                    }catch(Exception ex) {
                     ex.printStackTrace();
                    }


				}
			});
			btnNewButton_2.setBounds(471, 452, 121, 42);
		}
		return btnNewButton_2;
	}

	public JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label_6.setHorizontalAlignment(SwingConstants.RIGHT);
			label_6.setForeground(new Color(0, 0, 0));
			label_6.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			label_6.setBounds(224, 142, 92, 29);
		}
		return label_6;
	}

	public JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setForeground(new Color(34, 139, 34));
			tPwd.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tPwd.setColumns(10);
			tPwd.setBounds(328, 142, 264, 29);
		}
		return tPwd;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(141, 74, 633, 2);
		}
		return separator;
	}
}
