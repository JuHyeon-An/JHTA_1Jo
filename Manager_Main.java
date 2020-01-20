package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class Manager_Main extends JInternalFrame {
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTabbedPane tabbedPane_1;
	private JTabbedPane tabbedPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_Main frame = new Manager_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manager_Main() {
		setTitle("\uAD00\uB9AC\uC790\uBA54\uC778");
		setBounds(100, 100, 914, 601);
		setJMenuBar(getMenuBar_1());
		getContentPane().setLayout(null);
		getContentPane().add(getTabbedPane());

	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setPreferredSize(new Dimension(0, 30));
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_3());
		}
		return menuBar;
	}
	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uB3C4\uC11C");
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	public JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu_1.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu_1;
	}
	public JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uB300\uCD9C\uBC18\uB0A9 \uAD00\uB9AC");
			mnNewMenu_2.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu_2;
	}
	public JMenu getMnNewMenu_3() {
		if (mnNewMenu_3 == null) {
			mnNewMenu_3 = new JMenu("\uD1B5\uACC4");
			mnNewMenu_3.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu_3;
	}
	public JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uB3C4\uC11C \uAD00\uB9AC");
		}
		return mntmNewMenuItem;
	}
	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uD68C\uC6D0\uC815\uBCF4");
		}
		return mntmNewMenuItem_1;
	}
	public JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uAD00\uB9AC");
		}
		return mntmNewMenuItem_2;
	}
	public JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uD1B5\uACC4\uD45C");
		}
		return mntmNewMenuItem_3;
	}
	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 898, 535);
			tabbedPane.addTab("New tab", null, getPanel_2(), null);
			tabbedPane.addTab("New tab", null, getTabbedPane_1(), null);
			tabbedPane.addTab("New tab", null, getTabbedPane_2(), null);
		}
		return tabbedPane;
	}
	public JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}
	public JTabbedPane getTabbedPane_1() {
		if (tabbedPane_1 == null) {
			tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		}
		return tabbedPane_1;
	}
	public JTabbedPane getTabbedPane_2() {
		if (tabbedPane_2 == null) {
			tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		}
		return tabbedPane_2;
	}
}
