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
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	h_Manager_Rent rent;
	private JLabel lblNewLabel_7;
	private JTextField countRent;
	private JLabel lblNewLabel_13;
	private DialogMessage dm;
	private String msg = "";

	/**
	 * Create the panel.
	 */
	public h_RentRent() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(810, 534));
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
		add(getLblNewLabel_13());
		

	}
	public h_RentRent(h_Manager_Rent rent) {
		this();
		this.rent = rent;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel.setBounds(334, 32, 82, 21);
		}
		return lblNewLabel;
	}
	private JTextField getFindId() {
		if (findId == null) {
			findId = new JTextField();
			findId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					//아이디검색(엔터키)
					if(e.getKeyCode()==e.VK_ENTER) {
						rent();
					}
				}
			});
			findId.setBounds(415, 29, 219, 27);
			findId.setColumns(10);
		}
		return findId;
	}
	public void rent() {
		//아이디검색
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
				tmState.setText("대출가능");
			}else if(dao.memberStatus(find)==0){
				tmState.setText("대출불가");
			}
		}else {
			msg = "아이디가 존재하지 않습니다";
			dm = new DialogMessage(msg);
			dm.setLocationRelativeTo(h_RentRent.this);
			//JOptionPane.showMessageDialog(h_RentRent.this, "아이디가 존재하지 않습니다");
		}
		
	}
	public void searchBook() {
		//책검색
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
				tBookState.setText("대출가능");
			}else if(vo.getbState().equals("0")) {
				tBookState.setText("대출불가");
			}
		}else {
			msg = "존재하지 않는 책입니다";
			dm = new DialogMessage(msg);
			dm.setLocationRelativeTo(h_RentRent.this);
			//JOptionPane.showMessageDialog(h_RentRent.this,"존재하지 않는 책입니다");
		}
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//아이디검색(검색버튼)
				rent();
						
				}
			});
			btnNewButton.setBounds(646, 28, 98, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
			lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 34));
			lblNewLabel_1.setBounds(32, 23, 155, 34);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_2.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(48, 77, 82, 21);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC774\uB984");
			lblNewLabel_3.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(48, 129, 82, 21);
		}
		return lblNewLabel_3;
	}
	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setEditable(false);
			mId.setBounds(162, 74, 176, 27);
			mId.setColumns(10);
		}
		return mId;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setEditable(false);
			mName.setBounds(162, 126, 176, 27);
			mName.setColumns(10);
		}
		return mName;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uB300\uCD9C\uAC00\uB2A5\uC5EC\uBD80");
			lblNewLabel_4.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(400, 74, 134, 21);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_5.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_5.setBounds(400, 126, 82, 21);
		}
		return lblNewLabel_5;
	}
	private JTextField getTmState() {
		if (tmState == null) {
			tmState = new JTextField();
			tmState.setEditable(false);
			tmState.setBounds(534, 71, 210, 27);
			tmState.setColumns(10);
		}
		return tmState;
	}
	private JTextField getMPhone() {
		if (mPhone == null) {
			mPhone = new JTextField();
			mPhone.setEditable(false);
			mPhone.setBounds(534, 123, 210, 27);
			mPhone.setColumns(10);
		}
		return mPhone;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(24, 228, 736, 2);
		}
		return separator;
	}
	private JTextField getFindBookCode() {
		if (findBookCode == null) {
			findBookCode = new JTextField();
			findBookCode.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == e.VK_ENTER) {
						//책검색(엔터키)
						searchBook();
					}
				}
			});
			findBookCode.setBounds(415, 256, 219, 27);
			findBookCode.setColumns(10);
		}
		return findBookCode;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uAC80\uC0C9");
			btnNewButton_1.setBackground(new Color(176, 224, 230));
			btnNewButton_1.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//책검색(검색버튼)
					searchBook();
					
				}
			});
			btnNewButton_1.setBounds(646, 256, 97, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uB3C4\uC11C\uBA85");
			lblNewLabel_6.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_6.setBounds(47, 315, 82, 21);
		}
		return lblNewLabel_6;
	}
	private JLabel getTt() {
		if (tt == null) {
			tt = new JLabel("\uBD84\uB958\uAE30\uD638");
			tt.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			tt.setBounds(47, 370, 82, 21);
		}
		return tt;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("\uC800\uC790");
			lblNewLabel_8.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_8.setBounds(47, 424, 82, 21);
		}
		return lblNewLabel_8;
	}
	private JTextField getTbName() {
		if (tbName == null) {
			tbName = new JTextField();
			tbName.setEditable(false);
			tbName.setBounds(161, 312, 176, 27);
			tbName.setColumns(10);
		}
		return tbName;
	}
	private JTextField getTGenre() {
		if (tGenre == null) {
			tGenre = new JTextField();
			tGenre.setEditable(false);
			tGenre.setBounds(161, 364, 176, 27);
			tGenre.setColumns(10);
		}
		return tGenre;
	}
	private JTextField getTWriter() {
		if (tWriter == null) {
			tWriter = new JTextField();
			tWriter.setEditable(false);
			tWriter.setBounds(161, 421, 176, 27);
			tWriter.setColumns(10);
		}
		return tWriter;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("\uCD9C\uD310\uC0AC");
			lblNewLabel_9.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_9.setBounds(396, 315, 82, 21);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("\uBC18\uB0A9\uAE30\uD55C");
			lblNewLabel_10.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_10.setBounds(396, 370, 82, 21);
		}
		return lblNewLabel_10;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("\uB300\uCD9C\uAC00\uB2A5\uC5EC\uBD80");
			lblNewLabel_11.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_11.setBounds(396, 424, 123, 21);
		}
		return lblNewLabel_11;
	}
	private JTextField getTPublisher() {
		if (tPublisher == null) {
			tPublisher = new JTextField();
			tPublisher.setEditable(false);
			tPublisher.setBounds(530, 315, 210, 27);
			tPublisher.setColumns(10);
		}
		return tPublisher;
	}
	private JTextField getTDueDate() {
		if (tDueDate == null) {
			tDueDate = new JTextField();
			tDueDate.setEditable(false);
			tDueDate.setBounds(530, 367, 210, 27);
			tDueDate.setColumns(10);
		}
		return tDueDate;
	}
	private JTextField getTBookState() {
		if (tBookState == null) {
			tBookState = new JTextField();
			tBookState.setEditable(false);
			tBookState.setBounds(530, 421, 209, 27);
			tBookState.setColumns(10);
		}
		return tBookState;
	}
	
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uB300\uC5EC");
			btnNewButton_2.setBackground(new Color(176, 224, 230));
			btnNewButton_2.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//대여 --> 대여시 대출상태 0으로 
					if(findId.getText().equals("")||findBookCode.getText().equals("")) {
						msg = "먼저 아이디나 청구기호를 검색해주세요";
						dm = new DialogMessage(msg);
						dm.setLocationRelativeTo(h_RentRent.this);
						
						//JOptionPane.showMessageDialog(h_RentRent.this,"먼저 아이디나 청구기호를 검색해주세요");
					}else {
				
						String find = findId.getText();
						int r = dao.rent(find);
						
						
						if(r>0) {
							
							msg = "대여되었습니다";
							dm = new DialogMessage(msg);
							dm.setLocationRelativeTo(h_RentRent.this);
							//JOptionPane.showMessageDialog(h_RentRent.this, "대여되었습니다");
							
							dao.bStatus();
							bookCount = dao.bookCount(find);
							
							countRent.setText((6-bookCount)+"");
							
							if(bookCount>=6) {	
								dao.mStatus(find);
								
							}
							
							if(dao.memberStatus(find)==1 ) {
								tmState.setText("대출가능");
							}else if(dao.memberStatus(find)==0){
								tmState.setText("대출불가");
							}
							
							if(vo.getbState().equals("1")) {
								tBookState.setText("대출가능");
							}else if(vo.getbState().equals("0")) {
								tBookState.setText("대출불가");
							}
							
							
							findId.requestFocus();
							findId.selectAll();
							
						}else {
							msg = "대여가 불가능합니다";
							dm = new DialogMessage(msg);
							dm.setLocationRelativeTo(h_RentRent.this);
							//JOptionPane.showMessageDialog(h_RentRent.this, "대여가 불가능합니다");
						}
						
						mId.setText("");
						mName.setText("");
						mPhone.setText("");
						tmState.setText("");
						countRent.setText("");
						
						findBookCode.setText("");
						tbName.setText("");
						tBookState.setText("");
						tDueDate.setText("");
						tGenre.setText("");
						tPublisher.setText("");
						tWriter.setText("");
						
						findId.requestFocus();
						findId.selectAll();
						
						
					}
				}
			});
			btnNewButton_2.setBounds(325, 478, 129, 29);
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
			lblNewLabel_12.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_12.setBounds(316, 259, 82, 21);
		}
		return lblNewLabel_12;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("\uB300\uC5EC\uAC00\uB2A5\uCC45\uC218");
			lblNewLabel_7.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			lblNewLabel_7.setBounds(48, 182, 139, 21);
		}
		return lblNewLabel_7;
	}
	private JTextField getCountRent() {
		if (countRent == null) {
			countRent = new JTextField();
			countRent.setEditable(false);
			countRent.setBounds(162, 179, 176, 27);
			countRent.setColumns(10);
		}
		return countRent;
	}
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("\uB3C4\uC11C\uC815\uBCF4");
			lblNewLabel_13.setFont(new Font("나눔바른고딕", Font.PLAIN, 34));
			lblNewLabel_13.setBounds(32, 240, 182, 39);
		}
		return lblNewLabel_13;
	}
}
