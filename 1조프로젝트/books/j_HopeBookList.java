package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class j_HopeBookList extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Create the panel.
	 */
	public j_HopeBookList() {
		setPreferredSize(new Dimension(650, 420));
		setLayout(null);
		add(getScrollPane());
		add(getBtnNewButton());
		add(getButton());
		setVisible(true);

	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			table.getTableHeader().setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			
			table.setBackground(Color.decode("#F7FAFC"));
			table.getTableHeader().setBackground(Color.decode("#54B5BF"));
		}
		
		j_BookDao dao = new j_BookDao();
		dao.TableSetting(table, 1);
		
		return table;
	}
	
	
	
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(14, 12, 624, 350);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uD1A0\uC644\uB8CC");
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			btnNewButton.setBounds(209, 374, 105, 27);
		}
		return btnNewButton;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uC0AD\uC81C");
			button.setBackground(new Color(176, 224, 230));
			button.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			button.setBounds(317, 374, 105, 27);
		}
		return button;
	}
}
