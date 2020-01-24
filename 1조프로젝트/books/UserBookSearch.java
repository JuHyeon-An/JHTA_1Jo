package books;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Dimension;

public class UserBookSearch extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public UserBookSearch() {
		setPreferredSize(new Dimension(660, 580));
		setLayout(null);
		add(getScrollPane());
		add(getBtnNewButton());

	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 62, 573, 432);
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
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uBC18\uB0A9\uAE30\uD55C \uC5F0\uC7A5");
			btnNewButton.setBounds(228, 517, 153, 23);
		}
		return btnNewButton;
	}
}
