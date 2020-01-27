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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class p_MemberUpdate extends JPanel {
	private JComboBox comboBox;
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

	/**
	 * Create the panel.
	 */ 
	public p_MemberUpdate() {
		setPreferredSize(new Dimension(900, 567));
		setLayout(null);
		add(getComboBox());
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

	}
	private ComboBoxModel ComboBoxModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(124, 28, 92, 29);
			comboBox.addItem("아이디");
			comboBox.addItem("성명");
		}
		return comboBox;
	}

	public JTextField getTfind() {
		if (tfind == null) {
			tfind = new JTextField();
			tfind.setBounds(228, 28, 419, 29);
			tfind.setColumns(10);
		}
		return tfind;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//find 에서 불러온 값을 텍스트필드에 뿌려주는 작업
					String find = tfind.getText();
					p_MemberDao dao = new p_MemberDao();
					p_MemberVo vo = dao.search(find);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					tmId.setText(vo.getmId());
					tPwd.setText((vo.getPwd()) + "");
					tmName.setText(vo.getmName());
					tBirth.setText(sdf.format(vo.getBirth()));
					trDate.setText(sdf.format(vo.getrDate()));
					tEmail.setText(vo.getEmail());
					tPhone.setText(vo.getPhone());
					tState.setText(vo.getState());

				} 
			});
			btnNewButton.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			btnNewButton.setBounds(659, 28, 80, 29);
		}
		return btnNewButton;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			lblNewLabel.setBounds(238, 72, 92, 29);
		}
		return lblNewLabel;
	}

	public JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setEnabled(false);
			tmId.setBounds(332, 73, 264, 29);
			tmId.setColumns(10);
		}
		return tmId;
	}

	public JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setColumns(10);
			tmName.setBounds(332, 184, 264, 29);
		}
		return tmName;
	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			label.setBounds(238, 183, 92, 29);
		}
		return label;
	}

	public JTextField getTBirth() {
		if (tBirth == null) {
			tBirth = new JTextField();
			tBirth.setColumns(10);
			tBirth.setBounds(332, 237, 264, 29);
		}
		return tBirth;
	}

	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_1.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			label_1.setBounds(238, 236, 92, 29);
		}
		return label_1;
	}

	public JTextField getTrDate() {
		if (trDate == null) {
			trDate = new JTextField();
			trDate.setColumns(10);
			trDate.setBounds(332, 290, 264, 29);
		}
		return trDate;
	}

	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uB4F1\uB85D\uC77C");
			label_2.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			label_2.setBounds(238, 290, 92, 29);
		}
		return label_2;
	}

	public JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setColumns(10);
			tEmail.setBounds(332, 346, 264, 29);
		}
		return tEmail;
	}

	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC774\uBA54\uC77C");
			label_3.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			label_3.setBounds(238, 345, 92, 29);
		}
		return label_3;
	}

	public JTextField getTPhone() {
		if (tPhone == null) {
			tPhone = new JTextField();
			tPhone.setColumns(10);
			tPhone.setBounds(332, 399, 264, 29);
		}
		return tPhone;
	}

	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_4.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			label_4.setBounds(238, 398, 92, 29);
		}
		return label_4;
	}

	public JTextField getTState() {
		if (tState == null) {
			tState = new JTextField();
			tState.setColumns(10);
			tState.setBounds(332, 454, 264, 29);
		}
		return tState;
	}

	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uB300\uCD9C\uC5EC\uBD80");
			label_5.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			label_5.setBounds(238, 453, 92, 29);
		}
		return label_5;
	}

	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//검색해서 불러온 값을 수정하는곳
					String p = tPwd.getText();
					String m = tmName.getText();
					String b = tBirth.getText();
					String d = trDate.getText();
					String em = tEmail.getText();
					String ph = tPhone.getText();
					String st = tState.getText();
					p_MemberDao dao = new p_MemberDao();
					p_MemberVo vo = new p_MemberVo();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(!p.equals("")&&!m.equals("")&&!b.equals("")&&!d.equals("")&&!em.equals("")&&!ph.equals("")&&!st.equals("")) {
						
					try {
						Date date; 
						vo.setPwd(Integer.parseInt(tPwd.getText()));
						vo.setmName(tmName.getText());
						vo.setBirth(sdf.parse(tBirth.getText()));
						vo.setrDate(sdf.parse(trDate.getText()));
						vo.setEmail(tEmail.getText());
						vo.setPhone(tPhone.getText());
						vo.setState(tState.getText());
						vo.setmId(tmId.getText());
						int r = dao.update(vo);
						if (r > 0) {
							JOptionPane.showMessageDialog(null, "정보수정이 완료되었습니다");
						} else {
							JOptionPane.showMessageDialog(null, "정보수정중 오류발생");
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				  }else {
					  JOptionPane.showMessageDialog(null, "빈공백이 있습니다 모든항목을 입력해주세요!");
				  }
				}
			});
			btnNewButton_1.setBounds(295, 498, 130, 43);
		}
		return btnNewButton_1;
	}

	public JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uD0C8\uD1F4");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//삭제하는곳
					p_MemberDao dao = new p_MemberDao();
					String mId = tmId.getText();   
                    try { 
					int r = dao.delete(mId);
					if (r > 0) { 
						JOptionPane.showMessageDialog(null, "탈퇴완료");
					} else {
						JOptionPane.showMessageDialog(null, "탈퇴 오류발생");
					
					}
					//삭제하고나서 깨끗하게 비워주는곳
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
			btnNewButton_2.setBounds(479, 498, 130, 43);
		}
		return btnNewButton_2;
	}

	public JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uBE44\uBC00\uBC88\uD638");
			label_6.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			label_6.setBounds(238, 128, 92, 29);
		}
		return label_6;
	}

	public JTextField getTPwd() {
		if (tPwd == null) {
			tPwd = new JTextField();
			tPwd.setColumns(10);
			tPwd.setBounds(332, 129, 264, 29);
		}
		return tPwd;
	}
}
