package books;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;


public class j_BookManagement extends JPanel {
	public JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton button;
	
	String find;
	h_Manager_Main main;
	j_BookDao dao = new j_BookDao();
	DefaultTableModel model = new DefaultTableModel();
	
	public j_BookManagement(h_Manager_Main main) {
		this();
		this.main = main;
	}
	
	public j_BookManagement() {
		setPreferredSize(new Dimension(730, 462));
		setLayout(null);
		add(getScrollPane());
		add(getBtnNewButton_1());
		add(getComboBox());
		add(getTextField());
		add(getButton());
		
	}
	
	
	public void search() {
		// 관리할 책 검색하기 (전체)
		find = textField.getText();
//		int index = table.convertRowIndexToModel(1);
//		System.out.println(index);
		model = dao.bookSearch(find, comboBox.getSelectedIndex());
		table.setModel(model);
		table.setRowSorter(new TableRowSorter(model));
	}
	
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
		}

		//테이블 전체 데이터 나오게 하는 메소드
		dao.TableSetting(table, 0);
		
		return table;
		
	
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 97, 702, 353);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC0C1\uC138\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnNewButton.setBounds(309, 422, 105, 27);
		}
		return btnNewButton;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCC45 \uAC80\uC0C9/\uC218\uC815/\uC0AD\uC81C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(14, 12, 702, 35);
		}
		return lblNewLabel;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0C1\uC138\uBCF4\uAE30");
			};
			btnNewButton_1.setBounds(309, 423, 105, 27);
		
		return btnNewButton_1;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(201, 13, 97, 31);
			comboBox.addItem("전체");
			comboBox.addItem("청구기호");
			comboBox.addItem("서명");
			comboBox.addItem("저자");
			comboBox.addItem("출판사");
		}
		return comboBox;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					if(e.getKeyCode() == e.VK_ENTER) {
					search();
					}
				}
			});
			textField.setColumns(10);
			textField.setBounds(310, 13, 296, 31);
		}
		return textField;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("검색");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					search();
					
				}
			});
			button.setBounds(620, 12, 97, 32);
		}
		return button;
	}
}
