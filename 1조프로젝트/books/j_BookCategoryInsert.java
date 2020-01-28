package books;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class j_BookCategoryInsert extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JTextField tName;
	private JTextField tCode;
	private JButton btnNewButton;
	private JSeparator separator;
	private JLabel label_1;
	private JScrollPane scrollPane;
	JTable table;
	DefaultTableModel model;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public j_BookCategoryInsert() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(250, 240, 230));
		setPreferredSize(new Dimension(800, 340));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLabel());
		add(getTName());
		add(getTCode());
		add(getBtnNewButton());
		add(getSeparator_1());
		add(getPanel());

	}
	
	public void tableSetting() {
		table = new JTable();
		j_BookDao dao = new j_BookDao();
		model = dao.TableSetting(table, 2);
		table.setVisible(true);
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
			btnNewButton.setBackground(new Color(255, 215, 0));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					j_BookDao dao = new j_BookDao();
					j_GroupVo vo = new j_GroupVo();
					
					vo.setgCode(Integer.parseInt(tCode.getText()));
					
					vo.setgName(tName.getText());
					
					int r = dao.CategoryInsert(vo);
					String msg = "";
					if(r>0) {
					
						msg = "분류코드 등록이 완료되었습니다.";
						
						remove(panel);
						model = dao.TableSetting(table, 2);
						add(panel);
						updateUI();
						
					}else {
						msg = "해당 분류코드가 이미 존재합니다.";
					}
					DialogMessage dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(j_BookCategoryInsert.this);
				}
				
				
			});
			btnNewButton.setBounds(126, 223, 105, 27);
		}
		return btnNewButton;
	}
	public JSeparator getSeparator_1() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(362, 31, 2, 271);
		}
		return separator;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uBD84\uB958\uCF54\uB4DC  \uB9AC\uC2A4\uD2B8");
			label_1.setBounds(0, 0, 375, 56);
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		}
		return label_1;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(14, 106, 330, 140);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			tableSetting();
		}
		return table;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(396, 44, 375, 271);
			panel.setLayout(null);
			panel.add(getLabel_1());
			panel.add(getScrollPane());
		}
		return panel;
	}
}
