package books;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JButton;

import javax.swing.JDesktopPane;

public class h_Manager_Main extends JFrame {

	static JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTabbedPane tabbedPane_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JMenuItem mntmNewMenuItem;
	private JPanel panel_8;
	private JMenuItem mntmNewMenuItem_1;
	private JPanel panel_9;
	private JPanel panel_10;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JPanel panel_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					h_Manager_Main frame = new h_Manager_Main();
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
	public h_Manager_Main() {
		setPreferredSize(new Dimension(850, 550));
		setTitle("\uAD00\uB9AC\uC790\uBA54\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 720);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setPreferredSize(new Dimension(800, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel_8());
		contentPane.add(getPanel_9());
		contentPane.add(getPanel_10());
		contentPane.add(getPanel_11());
	}
	

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_3());
		}
		return menuBar;
	}
	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uB3C4\uC11C\uAD00\uB9AC");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
				}
			});
		}
		return mnNewMenu;
	}
	public JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uB300\uCD9C\uBC18\uB0A9\uAD00\uB9AC");
			mnNewMenu_1.add(getMntmNewMenuItem_1());
			mnNewMenu_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//회원
					
				
				}
			});
		}
		return mnNewMenu_1;
	}
	public JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu_2.add(getMntmNewMenuItem_2());
			mnNewMenu_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				}
			});
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
			mntmNewMenuItem = new JMenuItem("\uB3C4\uC11C\uAD00\uB9AC");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//도서
					panel_9.setVisible(false);
					panel_10.setVisible(false);
					panel_11.setVisible(false);

					panel_8.add(new j_Manager_Book(h_Manager_Main.this));
					panel_8.updateUI();
					panel_8.setVisible(true);
				}
			});
		}
		return mntmNewMenuItem;
	}
	public JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setPreferredSize(new Dimension(991, 608));
			panel_8.setBounds(12, 10, 991, 608);
			panel_8.setLayout(new BorderLayout(0, 0));
		}
		return panel_8;
	}
	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uB300\uCD9C\uBC18\uB0A9\uAD00\uB9AC");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_8.setVisible(false);
					panel_10.setVisible(false);
				    panel_11.setVisible(false);
					panel_9.add(new h_Manager_Rent());
					panel_9.updateUI();
					panel_9.setVisible(true);
				
				}
			});
			mntmNewMenuItem_1.setPreferredSize(new Dimension(92, 22));
		}
		return mntmNewMenuItem_1;
	}
	public JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setPreferredSize(new Dimension(991, 608));
			panel_9.setBounds(12, 10, 991, 608);
			panel_9.setLayout(new BorderLayout(0, 0));
		}
		return panel_9;
	}
	public JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setPreferredSize(new Dimension(991, 608));
			panel_10.setBounds(12, 10, 991, 606);
		}
		return panel_10;
	}
	public JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uD68C\uC6D0\uAD00\uB9AC");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_8.setVisible(false);
					panel_9.setVisible(false);
					panel_11.setVisible(false);
					panel_10.add(new h_Manager_Member());
					panel_10.setVisible(true);
					panel_10.setVisible(true);
					
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	public JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uD1B5\uACC4");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//통계
					panel_9.setVisible(false);
					panel_10.setVisible(false);
					panel_8.setVisible(false);
					panel_11.add(new h_Manager_Statistic());
					panel_11.updateUI();
					panel_11.setVisible(true);
					
				}
			});
			
		}
		return mntmNewMenuItem_3;
	}
	public JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setPreferredSize(new Dimension(991, 608));
			panel_11.setBounds(12, 10, 991, 608);
			
		}
		return panel_11;
	}
}
