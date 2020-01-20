package books;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class RentOverdue extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;

	
	public RentOverdue() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		add(getBtnNewButton());
		add(getBtnNewButton_1());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC5F0\uCCB4\uD68C\uC6D0 \uBAA9\uB85D");
			lblNewLabel.setBounds(17, 15, 124, 28);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 46, 781, 383);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC804\uCCB4\uBA54\uC138\uC9C0");
			btnNewButton.setBounds(523, 461, 129, 29);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC120\uD0DD\uBA54\uC138\uC9C0");
			btnNewButton_1.setBounds(669, 461, 129, 29);
		}
		return btnNewButton_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
}
