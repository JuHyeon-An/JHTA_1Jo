package books;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.AttributeSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

public class j_BookInsert extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tBook;
	private JTextField tWriter;
	private JTextField tPublisher;
	private JTextField tDate;
	private JTextField tPrice;
	private JTextField tCode;
	private JComboBox tGroup;
	private JTextField tPage;
	private JButton btnNewButton;
	private JSeparator separator;
	private JButton btnNewButton_1;
	
	j_BookDao dao = new j_BookDao();
	j_BookVo vo = new j_BookVo();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	List<j_GroupVo> list = new ArrayList<j_GroupVo>();
	

	public j_BookInsert() {
		list = dao.getGroupList();
		setBackground(new Color(253, 245, 230));
		setPreferredSize(new Dimension(555, 500));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLabel());
		add(getLabel_1());
		add(getLabel_2());
		add(getLabel_3());
		add(getLabel_4());
		add(getLabel_5());
		add(getLabel_6());
		add(getTBook());
		add(getTWriter());
		add(getTPublisher());
		add(getTDate());
		add(getTPrice());
		add(getTCode());
		add(getTGroup());
		add(getTPage());
		add(getBtnNewButton());
		add(getSeparator());
		add(getBtnNewButton_1());

	}
	
	public void setEditableAll(boolean b) {
		tBook.setEditable(b);
		tWriter.setEditable(b);
		tPublisher.setEditable(b);
		tDate.setEditable(b);
		tPrice.setEditable(b);
		tPage.setEditable(b);
		tGroup.setEnabled(b);
		btnNewButton.setEnabled(b);
	}
	
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB3C4\uC11C\uB4F1\uB85D");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel.setBounds(14, 36, 520, 35);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uB3C4\uC11C\uBA85");
			lblNewLabel_1.setBounds(56, 192, 62, 18);
		}
		return lblNewLabel_1;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC800\uC790");
			label.setBounds(56, 237, 62, 18);
		}
		return label;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uCD9C\uD310\uC0AC");
			label_1.setBounds(56, 277, 62, 18);
		}
		return label_1;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uCD9C\uD310\uB144\uC6D4");
			label_2.setBounds(56, 317, 62, 18);
		}
		return label_2;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uAC00\uACA9");
			label_3.setBounds(293, 199, 62, 18);
		}
		return label_3;
	}
	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uCCAD\uAD6C\uAE30\uD638");
			label_4.setBounds(52, 100, 62, 18);
		}
		return label_4;
	}
	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uBD84\uB958\uAE30\uD638");
			label_5.setBounds(293, 233, 62, 18);
		}
		return label_5;
	}
	

	public JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uD398\uC774\uC9C0\uC218");
			label_6.setBounds(293, 273, 62, 18);
		}
		return label_6;
	}
	public JTextField getTBook() {
		if (tBook == null) {
			tBook = new JTextField();
			tBook.setEditable(false);
			tBook.setBounds(132, 186, 126, 24);
			tBook.setColumns(10);
			
			
		}
		return tBook;
	}
	public JTextField getTWriter() {
		if (tWriter == null) {
			tWriter = new JTextField();
			tWriter.setEditable(false);
			tWriter.setColumns(10);
			tWriter.setBounds(132, 228, 126, 24);
		}
		return tWriter;
	}
	public JTextField getTPublisher() {
		if (tPublisher == null) {
			tPublisher = new JTextField();
			tPublisher.setEditable(false);
			tPublisher.setColumns(10);
			tPublisher.setBounds(132, 269, 126, 24);
		}
		return tPublisher;
	}
	public JTextField getTDate() {
		if (tDate == null) {
			tDate = new JTextField();
			tDate.setEditable(false);
			tDate.setColumns(10);
			tDate.setBounds(132, 310, 126, 24);
		}
		return tDate;
	}
	public JTextField getTPrice() {
		if (tPrice == null) {
			tPrice = new JTextField();
			tPrice.setEditable(false);
			tPrice.setColumns(10);
			tPrice.setBounds(369, 193, 139, 24);
		}
		return tPrice;
	}
	public JTextField getTCode() {
		if (tCode == null) {
			tCode = new JTextField();
			tCode.setColumns(10);
			tCode.setBounds(128, 99, 130, 24);
		}
		return tCode;
	}

	public JComboBox getTGroup() {
		if (tGroup == null) {
			tGroup = new JComboBox();
			j_GroupVo vo = new j_GroupVo();
			list = dao.getGroupList();
			tGroup.addItem("선택");
			
			for (int i = 0; i < list.size(); i++) {
				vo = list.get(i);
				tGroup.addItem(vo.getgCode()+" | "+vo.getgName());
			}
			tGroup.setEnabled(false);
			tGroup.setBounds(369, 229, 140, 24);
			
		}
		return tGroup;
	}

	
	public JTextField getTPage() {
		if (tPage == null) {
			tPage = new JTextField();
			tPage.setEditable(false);
			tPage.setColumns(10);
			tPage.setBounds(369, 270, 139, 24);
		}
		return tPage;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("입력");
			btnNewButton.setEnabled(false);
			btnNewButton.setBackground(new Color(255, 218, 185));
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					if(!tCode.getText().equals("")&&!tDate.getText().equals("")&&!tBook.getText().equals("")&&
						!tPage.getText().equals("")&&!tPrice.getText().equals("")&&!tPublisher.getText().equals("")&&
						!tWriter.getText().equals("")){
						
					String value = tGroup.getSelectedItem()+"";
					vo.setbGroup(Integer.parseInt(value.substring(0,3)));
					vo.setbCode(tCode.getText());
					vo.setbDate(Integer.parseInt(tDate.getText()));
					
					vo.setbName(tBook.getText());
					vo.setPages(Integer.parseInt(tPage.getText()));
					vo.setPrice(Integer.parseInt(tPrice.getText()));
					vo.setPublisher(tPublisher.getText());
					vo.setWriter(tWriter.getText());
					vo.setStatus("1"); // 처음 도서 등록하면 대출 가능하도록 초기설정
					
					int r = dao.insert(vo);
					
					if(r>0) {
						JOptionPane.showMessageDialog(null, "입력이 완료되었습니다.");
						tCode.setText("");
						tDate.setText("");
						tGroup.setSelectedIndex(0);
						tBook.setText("");
						tPage.setText("");
						tPrice.setText("");
						tPublisher.setText("");
						tWriter.setText("");
						setEditableAll(false);
					}else {
						JOptionPane.showMessageDialog(null, "오류발생");
					}
			}else {
				JOptionPane.showMessageDialog(null, "모든 데이터를 입력해주세요");
			}
					
				}
			});
			btnNewButton.setBounds(232, 422, 105, 27);
		}
		return btnNewButton;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(46, 147, 459, 16);
		}
		return separator;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC911\uBCF5\uD655\uC778");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!tCode.getText().equals("")) {
						boolean r = dao.bookCodeCheck(tCode.getText());

						if (r) {
							JOptionPane.showMessageDialog(j_BookInsert.this, "이미 해당 청구기호가 존재합니다.");
							setEditableAll(false);
						} else {
							JOptionPane.showMessageDialog(j_BookInsert.this, "입력 가능");
							setEditableAll(true);
						}
					} else {
						JOptionPane.showMessageDialog(j_BookInsert.this, "청구기호를 입력해주세요");
					}
				}
			});
			btnNewButton_1.setBounds(260, 97, 91, 27);
		}
		return btnNewButton_1;
	}
}
