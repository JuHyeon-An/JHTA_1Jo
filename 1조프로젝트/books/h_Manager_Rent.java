package books;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTabbedPane;

public class h_Manager_Rent extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	
	public h_Manager_Rent() {
		setPreferredSize(new Dimension(737, 520));
		setLayout(null);
		add(getTabbedPane());
		setVisible(true);

	}

	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(12, 10, 725, 483);
			tabbedPane.addTab("연체도서관리", null, getPanel(), null);
			tabbedPane.addTab("연체회원관리", null, getPanel_3(), null);
			tabbedPane.addTab("대출관리", null, getPanel_1(), null);
			tabbedPane.addTab("반납관리", null, getPanel_2(), null);
		}
		return tabbedPane;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(new h_RentOverdueB());
			panel.updateUI();
			panel.setVisible(true);
		}
		return panel;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(new h_RentRent());
			panel_1.updateUI();
			panel_1.setVisible(true);
		}
		return panel_1;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(new h_RentReturn());
			panel_2.updateUI();
			panel_2.setVisible(true);
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(new h_RentOverdueM());
			panel_3.setVisible(true);
		}
		return panel_3;
	}
}
