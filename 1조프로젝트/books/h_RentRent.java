package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class h_RentRent extends JPanel {
	private JLabel lblNewLabel;
	private JTextField findId;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField mId;
	private JTextField mName;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tmState;
	private JTextField mPhone;
	private JSeparator separator;
	private JTextField findBookCode;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_6;
	private JLabel tt;
	private JLabel lblNewLabel_8;
	private JTextField tbName;
	private JTextField tGenre;
	private JTextField tWriter;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField tPublisher;
	private JTextField tDueDate;
	private JTextField tBookState;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_12;
	h_RentDao dao = new h_RentDao();
	int bookCount;
	h_RentRentVo vo = new h_RentRentVo();
	private JLabel lblNewLabel_7;
	private JTextField countRent;

	/**
	 * Create the panel.
	 */
	public h_RentRent() {
		setPreferredSize(new Dimension(781, 481));
		setLayout(null);
		add(getLblNewLabel());
		add(getFindId());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getMId());
		add(getMName());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getTmState());
		add(getMPhone());
		add(getSeparator());
		add(getFindBookCode());
		add(getBtnNewButton_1());
		add(getLblNewLabel_6());
		add(getTt());
		add(getLblNewLabel_8());
		add(getTbName());
		add(getTGenre());
		add(getTWriter());
		add(getLblNewLabel_9());
		add(getLblNewLabel_10());
		add(getLblNewLabel_11());
		add(getTPublisher());
		add(getTDueDate());
		add(getTBookState());
		add(getBtnNewButton_2());
		add(getLblNewLabel_12());
		add(getLblNewLabel_7());
		add(getCountRent());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setBounds(326, 28, 82, 21);
		}
		return lblNewLabel;
	}
	private JTextField getFindId() {
		if (findId == null) {
			findId = new JTextField();
			findId.setBounds(404, 25, 209, 27);
			findId.setColumns(10);
		}
		return findId;
	}
	public void rent() {
			String find = findId.getText();
		
			vo = dao.selectId(find);
			bookCount = dao.bookCount(find);

			
			countRent.setText((5-bookCount)+"");
			mId.setText(vo.getmId());
			mName.setText(vo.getmName());
			mPhone.setText(vo.getPhone());
			
			dao.updateOverdueBook(find);
			int cnt = dao.overdueMember(mId.getText());
			if(cnt>0) {
				dao.mStatus(mId.getText());
			}
			if(Integer.parseInt(countRent.getText())==0) {
				dao.mStatus(findId.getText());
			}
			
			
			if(vo.getmState() .equals("1") ) {
				tmState.setText("���Ⱑ��");
			}else if(vo.getmState() .equals("0")){
				tmState.setText("����Ұ�");
			}
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//���̵�˻�
					String find = findId.getText();
					
					
					if(dao.idCheck(find)==1) {
						vo = dao.selectId(find);
						bookCount = dao.bookCount(find);
	
						
						countRent.setText((6-bookCount)+"");
						mId.setText(vo.getmId());
						mName.setText(vo.getmName());
						mPhone.setText(vo.getPhone());
						
						dao.updateOverdueBook(find);
						if(bookCount>=6) {
							dao.mStatus(find);
						}else {
							dao.mStatusBack(find);
						}
						int cnt = dao.overdueMember(mId.getText());
						if(cnt>0) {
							dao.mStatus(mId.getText());
						}
						
						if(dao.memberStatus(find)==1 ) {
							tmState.setText("���Ⱑ��");
						}else if(dao.memberStatus(find)==0){
							tmState.setText("����Ұ�");
						}
					}else {
						JOptionPane.showMessageDialog(h_RentRent.this, "���̵� �������� �ʽ��ϴ�");
					}
					
				}
			});
			btnNewButton.setBounds(625, 24, 98, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
			lblNewLabel_1.setFont(new Font("����", Font.BOLD, 20));
			lblNewLabel_1.setBounds(24, 28, 98, 34);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_2.setBounds(24, 77, 82, 21);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC774\uB984");
			lblNewLabel_3.setBounds(24, 123, 82, 21);
		}
		return lblNewLabel_3;
	}
	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setEditable(false);
			mId.setBounds(138, 74, 176, 27);
			mId.setColumns(10);
		}
		return mId;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setBounds(138, 120, 176, 27);
			mName.setColumns(10);
		}
		return mName;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uB300\uCD9C\uAC00\uB2A5\uC5EC\uBD80");
			lblNewLabel_4.setBounds(373, 77, 134, 21);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_5.setBounds(373, 123, 82, 21);
		}
		return lblNewLabel_5;
	}
	private JTextField getTmState() {
		if (tmState == null) {
			tmState = new JTextField();
			tmState.setEditable(false);
			tmState.setBounds(507, 74, 210, 27);
			tmState.setColumns(10);
		}
		return tmState;
	}
	private JTextField getMPhone() {
		if (mPhone == null) {
			mPhone = new JTextField();
			mPhone.setEditable(false);
			mPhone.setBounds(507, 120, 210, 27);
			mPhone.setColumns(10);
		}
		return mPhone;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(17, 206, 736, 2);
		}
		return separator;
	}
	private JTextField getFindBookCode() {
		if (findBookCode == null) {
			findBookCode = new JTextField();
			findBookCode.setBounds(198, 232, 419, 27);
			findBookCode.setColumns(10);
		}
		return findBookCode;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uAC80\uC0C9");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//å�˻�
					String find = findBookCode.getText();
					
					if(dao.bookCheck(find)==1) {
								
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 14);
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						
						vo = dao.selectBook(find);
						tbName.setText(vo.getBookName());
						tPublisher.setText(vo.getPublisher());
						tGenre.setText(vo.getGenre()+"");
						tWriter.setText(vo.getWriter());
						tDueDate.setText(sdf.format(cal.getTime()));
						if(vo.getbState().equals("1")) {
							tBookState.setText("���Ⱑ��");
						}else if(vo.getbState().equals("0")) {
							tBookState.setText("����Ұ�");
						}
					}else {
						JOptionPane.showMessageDialog(h_RentRent.this,"�������� �ʴ� å�Դϴ�");
					}
					
				}
			});
			btnNewButton_1.setBounds(634, 232, 89, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uB3C4\uC11C\uBA85");
			lblNewLabel_6.setBounds(21, 274, 82, 21);
		}
		return lblNewLabel_6;
	}
	private JLabel getTt() {
		if (tt == null) {
			tt = new JLabel("\uBD84\uB958\uAE30\uD638");
			tt.setBounds(21, 329, 82, 21);
		}
		return tt;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("\uC800\uC790");
			lblNewLabel_8.setBounds(21, 383, 82, 21);
		}
		return lblNewLabel_8;
	}
	private JTextField getTbName() {
		if (tbName == null) {
			tbName = new JTextField();
			tbName.setEditable(false);
			tbName.setBounds(135, 271, 176, 27);
			tbName.setColumns(10);
		}
		return tbName;
	}
	private JTextField getTGenre() {
		if (tGenre == null) {
			tGenre = new JTextField();
			tGenre.setEditable(false);
			tGenre.setBounds(135, 323, 176, 27);
			tGenre.setColumns(10);
		}
		return tGenre;
	}
	private JTextField getTWriter() {
		if (tWriter == null) {
			tWriter = new JTextField();
			tWriter.setEditable(false);
			tWriter.setBounds(135, 380, 176, 27);
			tWriter.setColumns(10);
		}
		return tWriter;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("\uCD9C\uD310\uC0AC");
			lblNewLabel_9.setBounds(370, 274, 82, 21);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("\uBC18\uB0A9\uAE30\uD55C");
			lblNewLabel_10.setBounds(370, 329, 82, 21);
		}
		return lblNewLabel_10;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("\uB300\uCD9C\uAC00\uB2A5\uC5EC\uBD80");
			lblNewLabel_11.setBounds(370, 383, 123, 21);
		}
		return lblNewLabel_11;
	}
	private JTextField getTPublisher() {
		if (tPublisher == null) {
			tPublisher = new JTextField();
			tPublisher.setEditable(false);
			tPublisher.setBounds(504, 274, 210, 27);
			tPublisher.setColumns(10);
		}
		return tPublisher;
	}
	private JTextField getTDueDate() {
		if (tDueDate == null) {
			tDueDate = new JTextField();
			tDueDate.setEditable(false);
			tDueDate.setBounds(504, 326, 210, 27);
			tDueDate.setColumns(10);
		}
		return tDueDate;
	}
	private JTextField getTBookState() {
		if (tBookState == null) {
			tBookState = new JTextField();
			tBookState.setEditable(false);
			tBookState.setBounds(504, 380, 209, 27);
			tBookState.setColumns(10);
		}
		return tBookState;
	}
	
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uB300\uC5EC");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//�뿩 --> �뿩�� ������� 0���� 
					if(findId.getText().equals("")||findBookCode.getText().equals("")) {
						JOptionPane.showMessageDialog(h_RentRent.this,"���� ���̵� û����ȣ�� �˻����ּ���");
					}else {
				
						String find = findId.getText();
						int r = dao.rent(find);
						
						
						if(r>0) {
							JOptionPane.showMessageDialog(h_RentRent.this, "�뿩�Ǿ����ϴ�");
							
							dao.bStatus();
							bookCount = dao.bookCount(find);
							
							countRent.setText((6-bookCount)+"");
							
							if(bookCount>=6) {	
								dao.mStatus(find);
								
							}
							
							if(dao.memberStatus(find)==1 ) {
								tmState.setText("���Ⱑ��");
							}else if(dao.memberStatus(find)==0){
								tmState.setText("����Ұ�");
							}
							
							if(vo.getbState().equals("1")) {
								tBookState.setText("���Ⱑ��");
							}else if(vo.getbState().equals("0")) {
								tBookState.setText("����Ұ�");
							}
							
							
							findId.requestFocus();
							findId.selectAll();
							
						}else {
							JOptionPane.showMessageDialog(h_RentRent.this, "�뿩�� �Ұ����մϴ�");
						}
					}
				}
			});
			btnNewButton_2.setBounds(323, 437, 129, 29);
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
			lblNewLabel_12.setBounds(111, 235, 82, 21);
		}
		return lblNewLabel_12;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("\uB300\uC5EC\uAC00\uB2A5\uCC45\uC218");
			lblNewLabel_7.setBounds(24, 160, 139, 21);
		}
		return lblNewLabel_7;
	}
	private JTextField getCountRent() {
		if (countRent == null) {
			countRent = new JTextField();
			countRent.setEditable(false);
			countRent.setBounds(138, 162, 176, 27);
			countRent.setColumns(10);
		}
		return countRent;
	}
}
