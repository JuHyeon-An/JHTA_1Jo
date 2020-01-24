package books;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class j_BookCategoryInsert extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JTextField tName;
	private JTextField tCode;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public j_BookCategoryInsert() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(250, 240, 230));
		setPreferredSize(new Dimension(348, 340));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLabel());
		add(getTName());
		add(getTCode());
		add(getBtnNewButton());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uBD84\uB958\uCF54\uB4DC \uB4F1\uB85D");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel.setBounds(0, 31, 348, 90);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC7A5\uB974");
			lblNewLabel_1.setBounds(76, 135, 62, 18);
		}
		return lblNewLabel_1;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uCF54\uB4DC");
			label.setBounds(76, 175, 62, 18);
		}
		return label;
	}
	public JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setBounds(152, 132, 116, 24);
			tName.setColumns(10);
		}
		return tName;
	}
	public JTextField getTCode() {
		if (tCode == null) {
			tCode = new JTextField();
			tCode.setColumns(10);
			tCode.setBounds(152, 172, 116, 24);
		}
		return tCode;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("저장");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					j_BookDao dao = new j_BookDao();
					j_GroupVo vo = new j_GroupVo();
					
					vo.setgCode(Integer.parseInt(tCode.getText()));
					vo.setgName(tName.getText());
					
					int r = dao.CategoryInsert(vo);
					
					if(r>0) {
						JOptionPane.showMessageDialog(null, "분류코드 등록이 완료되었습니다.");
						j_BookCategorySelect cs = new j_BookCategorySelect();
						cs.getTable();
						cs.updateUI();
						cs.model.fireTableDataChanged();
						
					}else {
						JOptionPane.showMessageDialog(null, "오류발생");
					}
				
					
					
				}
				
				
			});
			btnNewButton.setBounds(126, 223, 105, 27);
		}
		return btnNewButton;
	}
}
