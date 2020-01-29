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
import java.awt.Font;
import java.awt.Color;

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
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	h_Manager_Rent mb = new h_Manager_Rent();
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;

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
		setForeground(new Color(135, 206, 250));
		setBackground(new Color(173, 216, 230));
		setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 17));
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
	}
	

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(173, 216, 230));
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
			mnNewMenu.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_4());
			mnNewMenu.add(getMntmNewMenuItem_5());
			mnNewMenu.add(getMntmNewMenuItem_6());
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
			mnNewMenu_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			mnNewMenu_1.add(getMntmNewMenuItem_1());
			mnNewMenu_1.add(getMntmNewMenuItem_7());
			mnNewMenu_1.add(getMntmNewMenuItem_8());
			mnNewMenu_1.add(getMntmNewMenuItem_9());
			mnNewMenu_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//È¸¿ø
					
				
				}
			});
		}
		return mnNewMenu_1;
	}
	public JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			mnNewMenu_2.add(getMntmNewMenuItem_2());
			mnNewMenu_2.add(getMntmNewMenuItem_10());
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
			mnNewMenu_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			mnNewMenu_3.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu_3;
	}


	public JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("µµ¼­ µî·Ï");
			mntmNewMenuItem.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//µµ¼­

					panel_8.removeAll();
					panel_8.add(new j_Manager_Book(h_Manager_Main.this, 0));
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
			panel_8.setPreferredSize(new Dimension(813, 540));
			panel_8.setBounds(12, 10, 991, 641);
			panel_8.setLayout(new BorderLayout(0, 0));
		}
		return panel_8;
	}
	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("¿¬Ã¼µµ¼­°ü¸®");
			mntmNewMenuItem_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					panel_8.removeAll();
					panel_8.add(new h_Manager_Rent(0));
					panel_8.updateUI();
					panel_8.setVisible(true);
				
				}
			});
			mntmNewMenuItem_1.setPreferredSize(new Dimension(92, 22));
		}
		return mntmNewMenuItem_1;
	}
	public JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uD68C\uC6D0\uC218\uC815\uC0AD\uC81C");
			mntmNewMenuItem_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_8.removeAll();
					panel_8.add(new h_Manager_Member(0));
					panel_8.updateUI();
					panel_8.setVisible(true);

					
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	public JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uD1B5\uACC4");
			mntmNewMenuItem_3.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Åë°è
					panel_8.removeAll();
					panel_8.add(new h_Manager_Statistic());
					panel_8.setVisible(true);
					panel_8.updateUI();
					
					
				}
			});
			
		}
		return mntmNewMenuItem_3;
	}
	public JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("\uB3C4\uC11C \uC870\uD68C \uBC0F \uD3B8\uC9D1");
			mntmNewMenuItem_4.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					
					panel_8.removeAll();
					panel_8.add(new j_Manager_Book(h_Manager_Main.this, 1));
					panel_8.updateUI();
					panel_8.setVisible(true);
					
				}
			});
		}
		return mntmNewMenuItem_4;
	}
	public JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("ºÐ·ùÄÚµå Á¶È¸ | ÆíÁý");
			mntmNewMenuItem_5.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					panel_8.removeAll();
					panel_8.add(new j_Manager_Book(h_Manager_Main.this, 2));
					panel_8.updateUI();
					panel_8.setVisible(true);
					
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	public JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("Èñ¸Áµµ¼­ ¸ñ·Ï Á¶È¸");
			mntmNewMenuItem_6.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					panel_8.removeAll();
					panel_8.add(new j_Manager_Book(h_Manager_Main.this, 3));
					panel_8.updateUI();
					panel_8.setVisible(true);
				}
			});
		}
		return mntmNewMenuItem_6;
	}
	public JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("¿¬Ã¼È¸¿ø°ü¸®");
			mntmNewMenuItem_7.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					panel_8.removeAll();
					panel_8.add(new h_Manager_Rent(1));
					panel_8.updateUI();
					panel_8.setVisible(true);
				
				}
			});
		}
		return mntmNewMenuItem_7;
	}
	public JMenuItem getMntmNewMenuItem_8() {
		if (mntmNewMenuItem_8 == null) {
			mntmNewMenuItem_8 = new JMenuItem("´ëÃâ°ü¸®");
			mntmNewMenuItem_8.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					panel_8.removeAll();
					panel_8.add(new h_Manager_Rent(2));
					panel_8.updateUI();
					panel_8.setVisible(true);
				}
			});
		}
		return mntmNewMenuItem_8;
	}
	public JMenuItem getMntmNewMenuItem_9() {
		if (mntmNewMenuItem_9 == null) {
			mntmNewMenuItem_9 = new JMenuItem("¹Ý³³°ü¸®");
			mntmNewMenuItem_9.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					panel_8.removeAll();
					panel_8.add(new h_Manager_Rent(3));
					panel_8.updateUI();
					panel_8.setVisible(true);
					
				}
			});
		}
		return mntmNewMenuItem_9;
	}
	public JMenuItem getMntmNewMenuItem_10() {
		if (mntmNewMenuItem_10 == null) {
			mntmNewMenuItem_10 = new JMenuItem("È¸¿øÁ¶È¸");
			mntmNewMenuItem_10.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			mntmNewMenuItem_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					panel_8.removeAll();
					panel_8.add(new h_Manager_Member(1));
					panel_8.updateUI();
					panel_8.setVisible(true);
				}
			});
		}
		return mntmNewMenuItem_10;
	}
}
