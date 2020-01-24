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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class j_BookCategorySelect extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public j_BookCategorySelect() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(250, 240, 230));
		setPreferredSize(new Dimension(361, 345));
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uBD84\uB958\uCF54\uB4DC  \uB9AC\uC2A4\uD2B8");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 23));
			lblNewLabel.setBounds(0, 0, 375, 56);
		}
		return lblNewLabel;
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
			table = new JTable();
			
			j_BookDao dao = new j_BookDao();
			model = dao.TableSetting(table, 2);
		}
		return table;
	}
}
