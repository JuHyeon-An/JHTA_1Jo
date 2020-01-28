package books;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

	private Object gettable;
	/**
	 * Create the panel.
	 */


	public p_MemberSelect() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(900, 600));
		setLayout(null);
		add(getComboBox());
		add(getTextField());
		add(getBtnNewButton());
		add(getScrollPane());

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
			scrollPane.setBounds(12, 92, 871, 444);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	public JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setBackground(new Color(240, 248, 255)); 
			table.getTableHeader().setBackground(Color.decode("#54B5BF"));
			table.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			table.getTableHeader().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			table.setRowHeight(25);
		}
		return table;
	}
}
