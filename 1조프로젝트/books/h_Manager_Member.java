package books;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTabbedPane;

public class h_Manager_Member extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	int index;

	public h_Manager_Member(int index) {
		this();
		this.index = index;
		add(getTabbedPane());
	}
	
	public h_Manager_Member() {
		setPreferredSize(new Dimension(990, 610));
		setLayout(null);
		setVisible(true);
		
	}

	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(12, 10, 961, 585);
			tabbedPane.addTab("회원수정·삭제", null, getPanel(), null);
			tabbedPane.addTab("회원조회", null, getPanel_1(), null);
			tabbedPane.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
			tabbedPane.setSelectedIndex(index);
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
