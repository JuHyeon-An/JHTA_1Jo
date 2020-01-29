package books;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import m_jdbc.MemberVo;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Font;

public class p_MemberSelect extends JPanel {
	DefaultTableModel model = new DefaultTableModel();
	
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	JComboBox box = new JComboBox();
	JTabbedPane tab;
	p_MemberUpdate update;

	private Object gettable;
	private JButton btnNewButton_1;
	/**
	 * Create the panel.
	 */


	public p_MemberSelect(JTabbedPane tab,p_MemberUpdate update) {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(900, 600));
		setLayout(null);
		add(getComboBox());
		add(getTextField());
		add(getBtnNewButton());
		add(getScrollPane());
		String find = textField.getText();
		p_MemberDao dao = new p_MemberDao();
		model = (DefaultTableModel) dao.select(find);

		table.setModel(model);
		add(getBtnNewButton_1());
		this.tab = tab;
		this.update= update;

	}
	private ComboBoxModel ComboBoxModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBorder(null);
			comboBox.setBackground(new Color(176, 224, 230));
			comboBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			comboBox.setBounds(97, 38, 123, 38);
			comboBox.addItem("¾ÆÀÌµð");
			comboBox.addItem("¼º¸í");
			
		}
		return comboBox;
	}

	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			textField.setBounds(255, 39, 487, 38);
			textField.setColumns(10);
		}
		return textField;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.addKeyListener(new KeyAdapter() {
			});
			btnNewButton.addActionListener(new ActionListener() {
				//find ÀÇ °ªÀ» °¡Á®¿Í¼­ Å×ÀÌºí¿¡ »Ñ·ÁÁØ´Ù
				public void actionPerformed(ActionEvent arg0) {
					String find = textField.getText();
					p_MemberDao dao = new p_MemberDao();
					model = (DefaultTableModel) dao.select(find);

					table.setModel(model);
				}
			});
			btnNewButton.setBounds(772, 38, 111, 38);
		}
		return btnNewButton;
	} 
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 86, 871, 444);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	public JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setBackground(new Color(240, 248, 255)); 
			table.getTableHeader().setBackground(Color.decode("#54B5BF"));
			table.setBackground(Color.decode("#F7FAFC"));
			table.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			table.getTableHeader().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			table.setRowHeight(25);
		}
		return table;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0C1\uC138\uBCF4\uAE30");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//»ó¼¼º¸±â
					tab.setSelectedIndex(1);
					String mid= (String)table.getValueAt(table.getSelectedRow(),0);
					p_MemberDao dao =new p_MemberDao();
					p_MemberVo vo = new p_MemberVo();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					vo=dao.search(mid);
					update.getTmId().setText(vo.getmId());
					update.getTPwd().setText(vo.getPwd());
					update.getTmName().setText(vo.getmName());
					try {
						update.getTBirth().setText(sdf.format(sdf.parse(vo.getBirth())));
						update.getTrDate().setText(sdf.format(sdf.parse(vo.getrDate())));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					update.getTEmail().setText(vo.getEmail());
					update.getTPhone().setText(vo.getPhone());
					if(vo.getState().equals("1")) {
						update.getTState().setText("´ëÃâ°¡´É");
					}else {
						update.getTState().setText("´ëÃâºÒ°¡");
					}
			
					
					
				}
			});
			btnNewButton_1.setBackground(new Color(176, 224, 230));
			btnNewButton_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			btnNewButton_1.setBounds(375, 551, 97, 29);
		}
		return btnNewButton_1;
	}
}
