package books;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class j_BookDetail extends JInternalFrame {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField tBook;
	private JTextField tWriter;
	private JTextField tPublisher;
	private JTextField tDate;
	private JTextField tPrice;
	private JTextField tCode;
	private JTextField tGroup;
	private JTextField tPages;
	private JButton button;
	private JButton button_1;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField tStatus;
	private JTextField tCnt;
	private JTextField tRent;
	private JLabel label_12;
	private JTextField tUntil;
	private JButton button_2;
	private JLabel lblNewLabel;
	j_BookManagement panel;
	j_BookDao dao = new j_BookDao();
	j_BookVo vo = new j_BookVo();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String msg;
	private JLabel label_13;
	h_Manager_Main main;
	private JLabel label_14;
	private JTextField eDate;
	int index;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					j_BookDetail frame = new j_BookDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/*
	 * 작성 : 주현
	 * JTable에 있는 내용 선택 후 상세보기 눌렀을 때,
	 * 테이블에 있는 값 텍스트필드에 뿌려주기
	 */
	public j_BookDetail(j_BookManagement panel) {
		this();
		
		this.panel = panel;
		
		tWriter.setText(panel.table.getValueAt(panel.table.getSelectedRow(), 3)+"");
		
		
		getDetail(tCode, 0);
		getDetail(tBook, 1);
		getDetail(tPublisher, 2);
		getDetail(tWriter, 3);
		getDetail(tDate, 4);
		getDetail(tPrice, 5);
		getDetail(tPages, 6);
		getDetail(tGroup, 7);
		getDetail(eDate, 8);
		getDetail(tStatus, 9);
		
		
		// 예약자수 불러오기
		tCnt.setText(dao.getReserveCnt(tCode.getText()));
		
		// 대출한 사람 아이디 불러오기
		tRent.setText(dao.getRentMember(tCode.getText(), '0'));
		
		// 반납기한 불러오기
		tUntil.setText(dao.getRentMember(tCode.getText(), '1'));
	}
	
	public void getDetail(JTextField text, int column) {
		text.setText(panel.table.getValueAt(panel.table.getSelectedRow(), column)+"");
	}
	
	
	public j_BookDetail() {
		super("상세보기",false,true,true,true);
		
		setBounds(100, 100, 741, 552);
		getContentPane().setLayout(null);
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getLabel_2());
		getContentPane().add(getLabel_3());
		getContentPane().add(getLabel_4());
		getContentPane().add(getLabel_5());
		getContentPane().add(getLabel_6());
		getContentPane().add(getLabel_7());
		getContentPane().add(getLabel_8());
		getContentPane().add(getTBook());
		getContentPane().add(getTWriter());
		getContentPane().add(getTPublisher());
		getContentPane().add(getTDate());
		getContentPane().add(getTPrice());
		getContentPane().add(getTCode());
		getContentPane().add(getTGroup());
		getContentPane().add(getTPages());
		getContentPane().add(getButton());
		getContentPane().add(getButton_1());
		getContentPane().add(getLabel_9());
		getContentPane().add(getLabel_10());
		getContentPane().add(getLabel_11());
		getContentPane().add(getTStatus());
		getContentPane().add(getTCnt());
		getContentPane().add(getTRent());
		getContentPane().add(getLabel_12());
		getContentPane().add(getTUntil());
		getContentPane().add(getButton_2());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLabel_13());
		getContentPane().add(getLabel_14());
		getContentPane().add(getEDate());
		setVisible(true);

	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC0C1\uC138\uBCF4\uAE30");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("굴림", Font.PLAIN, 30));
			label.setBounds(14, 18, 697, 65);
		}
		return label;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uB3C4\uC11C\uBA85");
			label_1.setBounds(136, 170, 62, 18);
		}
		return label_1;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC800\uC790");
			label_2.setBounds(136, 210, 62, 18);
		}
		return label_2;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uCD9C\uD310\uC0AC");
			label_3.setBounds(136, 250, 62, 18);
		}
		return label_3;
	}
	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uCD9C\uD310\uB144\uB3C4");
			label_4.setBounds(136, 290, 62, 18);
		}
		return label_4;
	}
	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uAC00\uACA9");
			label_5.setBounds(136, 330, 62, 18);
		}
		return label_5;
	}
	public JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
			label_6.setBounds(136, 129, 62, 18);
		}
		return label_6;
	}
	public JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uBD84\uB958\uAE30\uD638");
			label_7.setBounds(136, 364, 62, 18);
		}
		return label_7;
	}
	public JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("\uD398\uC774\uC9C0\uC218");
			label_8.setBounds(136, 404, 62, 18);
		}
		return label_8;
	}
	public JTextField getTBook() {
		if (tBook == null) {
			tBook = new JTextField();
			tBook.setColumns(10);
			tBook.setBounds(212, 160, 170, 24);
		}
		return tBook;
	}
	public JTextField getTWriter() {
		if (tWriter == null) {
			tWriter = new JTextField();
			tWriter.setColumns(10);
			tWriter.setBounds(212, 201, 170, 24);
		}
		return tWriter;
	}
	public JTextField getTPublisher() {
		if (tPublisher == null) {
			tPublisher = new JTextField();
			tPublisher.setColumns(10);
			tPublisher.setBounds(212, 242, 170, 24);
		}
		return tPublisher;
	}
	public JTextField getTDate() {
		if (tDate == null) {
			tDate = new JTextField();
			tDate.setColumns(10);
			tDate.setBounds(212, 283, 116, 24);
		}
		return tDate;
	}
	public JTextField getTPrice() {
		if (tPrice == null) {
			tPrice = new JTextField();
			tPrice.setColumns(10);
			tPrice.setBounds(212, 324, 116, 24);
		}
		return tPrice;
	}
	public JTextField getTCode() {
		if (tCode == null) {
			tCode = new JTextField();
			tCode.setColumns(10);
			tCode.setBounds(212, 124, 116, 24);
		}
		return tCode;
	}
	public JTextField getTGroup() {
		if (tGroup == null) {
			tGroup = new JTextField();
			tGroup.setColumns(10);
			tGroup.setBounds(212, 360, 116, 24);
		}
		return tGroup;
	}
	public JTextField getTPages() {
		if (tPages == null) {
			tPages = new JTextField();
			tPages.setColumns(10);
			tPages.setBounds(212, 401, 116, 24);
		}
		return tPages;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("수정");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					
					try {
						
					vo.setbCode(tCode.getText());
					vo.setbDate(Integer.parseInt(tDate.getText()));
					vo.setbGroup(Integer.parseInt(tGroup.getText()));
					vo.setbName(tBook.getText());
					vo.setPages(Integer.parseInt(tPages.getText()));
					vo.setPrice(Integer.parseInt(tPrice.getText()));
					vo.setPublisher(tPublisher.getText());
					vo.setStatus(tStatus.getText());
					vo.setWriter(tWriter.getText());
					
					int r = dao.bookModify(vo);

					msg = r > 0? "수정이 완료되었습니다." : "오류발생";
					JOptionPane.showMessageDialog(null, msg);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				// 텍스트필드 값 vo에 담아서 수정
				
				}
			});
			button.setBounds(136, 453, 105, 27);
		}
		return button;
	}
	public JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("삭제");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				

					try {
						
					
					int r = dao.bookDelete(tCode.getText());

					msg = r > 0? "삭제가 완료되었습니다." : "오류발생";
					JOptionPane.showMessageDialog(null, msg);
					j_BookDetail.this.dispose();
					
					
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				// 텍스트필드 값 vo에 담아서 수정
				
				}
			});
			button_1.setBounds(255, 453, 105, 27);
		}
		return button_1;
	}
	public JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("\uB300\uCD9C\uC0C1\uD0DC");
			label_9.setBounds(439, 149, 62, 18);
		}
		return label_9;
	}
	public JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("\uC608\uC57D\uC790\uC218");
			label_10.setBounds(439, 190, 62, 18);
		}
		return label_10;
	}
	public JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("\uB300\uCD9C\uC790");
			label_11.setBounds(439, 234, 62, 18);
		}
		return label_11;
	}
	public JTextField getTStatus() {
		if (tStatus == null) {
			tStatus = new JTextField();
			tStatus.setEditable(false);
			tStatus.setColumns(10);
			tStatus.setBounds(503, 146, 116, 24);
		}
		return tStatus;
	}
	public JTextField getTCnt() {
		if (tCnt == null) {
			tCnt = new JTextField();
			tCnt.setEditable(false);
			tCnt.setColumns(10);
			tCnt.setBounds(503, 187, 116, 24);
		}
		return tCnt;
	}
	public JTextField getTRent() {
		if (tRent == null) {
			tRent = new JTextField();
			tRent.setEditable(false);
			tRent.setColumns(10);
			tRent.setBounds(503, 231, 116, 24);
		}
		return tRent;
	}
	public JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("\uBC18\uB0A9\uAE30\uD55C");
			label_12.setBounds(439, 275, 62, 18);
		}
		return label_12;
	}
	public JTextField getTUntil() {
		if (tUntil == null) {
			tUntil = new JTextField();
			tUntil.setEditable(false);
			tUntil.setColumns(10);
			tUntil.setBounds(503, 276, 116, 24);
		}
		return tUntil;
	}
	public JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("\uC5F0\uC7A5");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
				int r = dao.addDate(tCode.getText(), tRent.getText());
				
				if(r>0) {
					JOptionPane.showMessageDialog(null, "성공적으로 연장되었습니다.");
					tUntil.setText(dao.getRentMember(tCode.getText(), '1')); // 바로 업데이트
				}else {
					if(tUntil.getText().equals("정보없음")) {
						JOptionPane.showMessageDialog(null, "대출중인 도서가 아닙니다.");
					}else {
						JOptionPane.showMessageDialog(null, "연장은 한번만 가능합니다.");
					}
				}
				
				}
			});
			button_2.setBounds(620, 275, 62, 27);
		}
		return button_2;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC5EC\uAE30\uB294 \uC544\uB9C8.. \uC0AC\uC9C4?\u314E;");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(386, 284, 324, 239);
		}
		return lblNewLabel;
	}
	public JLabel getLabel_13() {
		if (label_13 == null) {
			label_13 = new JLabel("\uC8FC\uD604 ;\uC67C\uCABD\uC5D0 \uC788\uB294 \uAC12\uB4E4\uB9CC \uC218\uC815 \uAC00\uB2A5");
			label_13.setBounds(14, 95, 227, 18);
		}
		return label_13;
	}
	public JLabel getLabel_14() {
		if (label_14 == null) {
			label_14 = new JLabel("\uB4F1\uB85D\uC77C\uC790");
			label_14.setBounds(439, 117, 62, 18);
		}
		return label_14;
	}
	public JTextField getEDate() {
		if (eDate == null) {
			eDate = new JTextField();
			eDate.setEditable(false);
			eDate.setColumns(10);
			eDate.setBounds(503, 114, 116, 24);
		}
		return eDate;
	}
}
