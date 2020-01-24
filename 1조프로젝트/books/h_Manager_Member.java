package books;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTabbedPane;

public class h_Manager_Member extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;


	public h_Manager_Member() {
		setPreferredSize(new Dimension(767, 524));
		setLayout(null);
		add(getTabbedPane());
		setVisible(true);
		

		
	}

	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(12, 10, 712, 472);
			tabbedPane.addTab("회원수정·삭제", null, getPanel(), null);
			tabbedPane.addTab("회원조회", null, getPanel_1(), null);
		}
		return tabbedPane;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(new p_MemberUpdate());
			panel.updateUI();
			panel.setVisible(true);
		}
		return panel;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(new p_MemberSelect());
			panel_1.updateUI();
			panel_1.setVisible(true);
		}
		return panel_1;
	}
}
