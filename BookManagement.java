package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class BookManagement extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BookManagement() {
		setLayout(null);
		add(getTable());

	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(14, 12, 702, 412);
		}
		return table;
	}
}
