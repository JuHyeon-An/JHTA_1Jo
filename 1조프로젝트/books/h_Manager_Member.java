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
	p_MemberUpdate update=new p_MemberUpdate();

	public h_Manager_Member(int index) {
		this();
		this.index = index;
		add(getTabbedPane());
	}
	
	public h_Manager_Member() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(876, 750));
		setLayout(null);
		setVisible(true);
		
	}

	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(12, 10, 961, 620);
			tabbedPane.addTab("회원조회", null, getPanel_1(), null);
			tabbedPane.addTab("회원수정·삭제", null, getPanel(), null);
			tabbedPane.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
			tabbedPane.setPreferredSize(new Dimension(700, 670));
			tabbedPane.setBackgroundAt(0, Color.decode("#B0E0E6"));
			tabbedPane.setBackgroundAt(1, Color.decode("#B0E0E6"));
			tabbedPane.setSelectedIndex(index);
			
		}
		return tabbedPane;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(update);
			panel.setBackground(new Color(240,248,255));
			panel.updateUI();
			panel.setVisible(true);
		}
		return panel;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(new p_MemberSelect(tabbedPane,update));
			panel_1.setBackground(new Color(240,248,255));
			panel_1.updateUI();
			panel_1.setVisible(true);
		}
		return panel_1;
	}
}
