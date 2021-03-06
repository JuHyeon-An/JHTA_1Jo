
//사용자 메인 프레임

package books;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.naming.ContextNotEmptyException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class UserMain extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private String keyId;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMain frame = new UserMain();
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
	public UserMain() {
		setTitle("\uC911\uC559 HTA \uB3C4\uC11C\uAD00");
		setPreferredSize(new Dimension(950, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
	}
	public UserMain(String keyId) {
		this();
		this.keyId = keyId;
		
		contentPane.add(getTabbedPane());
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(14, 12, 907, 652);
			tabbedPane.addTab("개인정보 관리", null, getPanel(), null);
			tabbedPane.addTab("도서관리", null, getPanel1(), null);
			tabbedPane.addTab("도서검색", null, getPanel2(), null);
			tabbedPane.addTab("희망도서신청", null, getPanel3(), null);
		}
		return tabbedPane;
	}
	
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(900, 850));
			panel.setBackground(new Color(240, 248, 255));
			panel.add(new m_UserModify(keyId));
			panel.updateUI();
			panel.setVisible(true);
		}
		return panel;
	}
	public JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setBackground(new Color(240, 248, 255));
			panel1.add(new m_UserBookSearch(keyId));
			panel1.updateUI();
		}
		return panel1;
	}
	public JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setBackground(new Color(240, 248, 255));
			panel2.add(new m_UserBookRent(keyId));
			panel2.updateUI();
			
		}
		return panel2;
	}
	public JPanel getPanel3() {
		if (panel3 == null) {
			panel3 = new JPanel();
			panel3.setBackground(new Color(240, 248, 255));
			m_UserHopeBook hope = new m_UserHopeBook(keyId);
			panel3.add(hope);
			hope.getBtnNewButton_1().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedIndex(2);
					
				}
			});
			panel3.updateUI();
		}
		return panel3;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(UserMain.class.getResource("/iconBox/bookopen(2).gif")));
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblNewLabel.hide();
				}
			});
			lblNewLabel.setBounds(0, 0, 937, 685);
		}
		return lblNewLabel;
	}
}
