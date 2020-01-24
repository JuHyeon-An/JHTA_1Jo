package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class h_RentReturn extends JPanel {
	private JLabel lblNewLabel;
	private JTextField tFind;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tmId;
	private JTextField tmName;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tbookCount;
	private JTextField tPhone;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton_1;

	h_RentDao dao = new h_RentDao();
	h_RentRentVo vo = new h_RentRentVo();
	int bookCount;
	
	
	public h_RentReturn() {
		setPreferredSize(new Dimension(760, 459));
		setLayout(null);
		add(getLblNewLabel());
		add(getTFind());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getTmId());
		add(getTmName());
		add(getLblNewLabel_4());
		add(getLblNewLabel_5());
		add(getTbookCount());
		add(getTPhone());
		add(getSeparator());
		add(getScrollPane());
		add(getBtnNewButton_1());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setBounds(294, 28, 82, 21);
		}
		return lblNewLabel;
	}
	private JTextField getTFind() {
		if (tFind == null) {
			tFind = new JTextField();
			tFind.setBounds(357, 25, 279, 27);
			tFind.setColumns(10);
		}
		return tFind;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//아이디검색
					 
					String find = tFind.getText();
					if(dao.idCheck(find)==1) {		
						vo = dao.selectId(find);
						
						tmId.setText(vo.getmId());
						tmName.setText(vo.getmName());
						tPhone.setText(vo.getPhone());
						bookCount = dao.bookCount(find);
						tbookCount.setText(bookCount+"");
						
						dao.selectRent(find,h_RentReturn.this);
					}else {
						JOptionPane.showMessageDialog(h_RentReturn.this,"아이디가 존재하지 않습니다");
					}
				}
			});
			btnNewButton.setBounds(653, 24, 95, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_1.setBounds(34, 28, 114, 35);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_2.setBounds(34, 78, 82, 21);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC774\uB984");
			lblNewLabel_3.setBounds(34, 131, 82, 21);
		}
		return lblNewLabel_3;
	}
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setEditable(false);
			tmId.setBounds(116, 78, 166, 27);
			tmId.setColumns(10);
		}
		return tmId;
	}
	private JTextField getTmName() {
		if (tmName == null) {
			tmName = new JTextField();
			tmName.setEditable(false);
			tmName.setBounds(116, 128, 166, 27);
			tmName.setColumns(10);
		}
		return tmName;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uB300\uCD9C\uC911\uC778\uCC45\uC218");
			lblNewLabel_4.setBounds(357, 78, 114, 21);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_5.setBounds(357, 131, 95, 21);
		}
		return lblNewLabel_5;
	}
	private JTextField getTbookCount() {
		if (tbookCount == null) {
			tbookCount = new JTextField();
			tbookCount.setEditable(false);
			tbookCount.setBounds(488, 78, 211, 27);
			tbookCount.setColumns(10);
		}
		return tbookCount;
	}
	private JTextField getTPhone() {
		if (tPhone == null) {
			tPhone = new JTextField();
			tPhone.setEditable(false);
			tPhone.setBounds(488, 128, 211, 27);
			tPhone.setColumns(10);
		}
		return tPhone;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(17, 165, 737, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 175, 731, 225);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uBC18\uB0A9");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//반납버튼
					if(tFind.getText().equals("")) {
						JOptionPane.showMessageDialog(h_RentReturn.this,"먼저 아이디를 입력해주세요");
					}else {
						String find =(String)table.getValueAt(table.getSelectedRow(), 0);
					    int r = dao.deleteRent(find);
					    if(r>0) {
					    	JOptionPane.showMessageDialog(h_RentReturn.this,"반납이 완료되었습니다");
					    	vo = dao.selectId(find);
					    	bookCount = dao.bookCount(tFind.getText());
					    	tbookCount.setText(bookCount+"");
					    }
					    String bookCode = (String)table.getValueAt(table.getSelectedRow(), 2);
					    dao.bStatusBack(bookCode);
					    String mId = tmId.getText();
					    int cnt = dao.overdueMember(mId);
					    if(dao.bookCountAtReturn(mId)<=5 && cnt == 0) {
					    	dao.mStatusBack(mId);
					    };
					    dao.updateOverdueBook(mId);
					    
					    dao.selectRent(tmId.getText(),h_RentReturn.this);
					    tFind.requestFocus();
					    tFind.selectAll();
				    
					}
				
				}
			});
			btnNewButton_1.setBounds(308, 410, 129, 29);
		}
		return btnNewButton_1;
	}
}
