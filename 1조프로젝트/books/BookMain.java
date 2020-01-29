package books;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class BookMain extends JFrame {

	private JDesktopPane contentPane;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel notice1;
	j_BookDao bookdao;
	private JLabel lblHta;
	private JLabel label_4;
	public h_RentDao dao = new h_RentDao();
	private JLabel book1;
	private JLabel book2;
	private JLabel book3;
	private JLabel book4;
	private JLabel book5;
	private JLabel label_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMain frame = new BookMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookMain() {
		setTitle("\uC911\uC559 HTA\uB3C4\uC11C\uAD00");
		setPreferredSize(new Dimension(900, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 699);
		contentPane = new JDesktopPane();
		contentPane.setPreferredSize(new Dimension(950, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		String[] book = new String[300]; 
		book=dao.getUpToDateBook();
		book1.setText("1."+book[0]);
		book2.setText("2."+book[1]);
		book3.setText("3."+book[2]);
		book4.setText("4."+book[3]);
		book5.setText("5."+book[4]);
	}

	public void search() {
		String find = textField.getText();
		SearchFrame sf = new SearchFrame(find, comboBox.getSelectedIndex());
		contentPane.add(sf);
		sf.toFront();
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBackground(SystemColor.control);
			comboBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			comboBox.setBounds(78, 208, 90, 36);
			comboBox.addItem("ÀüÃ¼");
			comboBox.addItem("Ã»±¸±âÈ£");
			comboBox.addItem("¼­¸í");
			comboBox.addItem("ÀúÀÚ");
			comboBox.addItem("ÃâÆÇ»ç");
		}
		return comboBox;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					textField.setText("");
					textField.setForeground(Color.black);
				}
			});
			textField.setForeground(Color.GRAY);
			textField.setText("\uAC80\uC0C9\uC5B4\uB97C \uC785\uB825\uD558\uC138\uC694.");
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == e.VK_ENTER) {
						search();
					} 
					
				}
			});
			textField.setBounds(171, 209, 593, 36);
			textField.setColumns(10);
		}
		return textField;
	}
	
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uAC80\uC0C9");
			button.setBackground(SystemColor.control);
			button.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			button.setBounds(771, 208, 90, 36);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				search();
				
				}
			});
		}
		return button;
	}
	public JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC0AC\uC6A9\uC790 \uB85C\uADF8\uC778");
			button_1.setIcon(new ImageIcon(BookMain.class.getResource("/iconBox/01.png")));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				UserLogin ul = new UserLogin();
				contentPane.add(ul);
				ul.toFront();
					
				}
			});
			button_1.setBounds(66, 300, 364, 46);
			button_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		}
		return button_1;
	}
	public JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			button_2.setIcon(new ImageIcon(BookMain.class.getResource("/iconBox/02.png")));
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					j_ManagerLogin ul = new j_ManagerLogin();
					contentPane.add(ul);
					ul.toFront();
				
				}
			});
			button_2.setBounds(473, 300, 364, 46);
			button_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		}
		return button_2;
	}
	public JPanel getPanel() {
		if (panel == null) {
			try {
				panel = new AddPanelImage("img/aa2.gif");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.setPreferredSize(new Dimension(950, 800));
			panel.setBounds(0, 0, 934, 873);
			panel.setLayout(null);
			panel.add(getComboBox());
			panel.add(getTextField());
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getButton_2());
			panel.add(getPanel_2());
			panel.add(getBook1());
			panel.add(getBook2());
			panel.add(getBook3());
			panel.add(getBook4());
			panel.add(getBook5());
			panel.add(getLabel_3());
		}
		return panel;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setOpaque(false);
			panel_2.setBorder(null);
			panel_2.setBackground(new Color(210, 180, 140));
			panel_2.setBounds(30, 436, 457, 190);
			panel_2.setLayout(null);
			panel_2.add(getNotice1());
			panel_2.add(getLblHta());
			panel_2.add(getLabel_4());
//			panel_2.setBackground(new Color(Color.OPAQUE));
		}
		return panel_2;
	}
	public JLabel getNotice1() {
		if (notice1 == null) {
			notice1 = new JLabel("");
			notice1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 22));
			notice1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					NoticeBoard nb = new NoticeBoard(1);
					contentPane.add(nb);
					nb.toFront();
					nb.updateUI();
					
				}
			});
			notice1.setBounds(14, 24, 429, 26);
			bookdao = new j_BookDao();
			notice1.setText("[\uD734\uAD00\uC548\uB0B4] \uC911\uC559 HTA \uB3C4\uC11C\uAD00 \uC784\uC2DC\uD734\uAD00 \uC548\uB0B4");
		}
		return notice1;
	}
	public JLabel getLblHta() {
		if (lblHta == null) {
			lblHta = new JLabel("[\uACF5\uC9C0] 2019\uB144 \uC911\uC559 HTA \uB3C4\uC11C\uAD00 \uB2E4\uB3C5\uC655 \uBC1C\uD45C");
			lblHta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					NoticeBoard nb = new NoticeBoard(2);
					contentPane.add(nb);
					nb.toFront();
					nb.updateUI();
					
				}
			});
			lblHta.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 22));
			lblHta.setBounds(14, 82, 429, 26);
		}
		return lblHta;
	}
	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("[\uB300\uD68C\uACF5\uC9C0] \uC81C 36\uD68C \uCF54\uB529\uB300\uD68C \uAC1C\uCD5C");
			label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					
					NoticeBoard nb = new NoticeBoard(3);
					contentPane.add(nb);
					nb.toFront();
					nb.updateUI();
					
				}
			});
			label_4.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 22));
			label_4.setBounds(14, 138, 429, 26);
		}
		return label_4;
	}
	
	public JLabel getBook1() {
		if (book1 == null) {
			book1 = new JLabel("book1");
			book1.setPreferredSize(new Dimension(41, 10));
			book1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
			book1.setBounds(505, 429, 338, 33);
		}
		return book1;
	}
	public JLabel getBook2() {
		if (book2 == null) {
			book2 = new JLabel("book2");
			book2.setPreferredSize(new Dimension(41, 10));
			book2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
			book2.setBounds(505, 469, 338, 35);
		}
		return book2;
	}
	public JLabel getBook3() {
		if (book3 == null) {
			book3 = new JLabel("book3");
			book3.setPreferredSize(new Dimension(41, 10));
			book3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
			book3.setBounds(506, 510, 338, 33);
		}
		return book3;
	}
	public JLabel getBook4() {
		if (book4 == null) {
			book4 = new JLabel("book4");
			book4.setPreferredSize(new Dimension(41, 10));
			book4.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
			book4.setBounds(505, 553, 338, 34);
		}
		return book4;
	}
	public JLabel getBook5() {
		if (book5 == null) {
			book5 = new JLabel("book5");
			book5.setPreferredSize(new Dimension(41, 10));
			book5.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20));
			book5.setBounds(504, 595, 338, 32);
		}
		return book5;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(BookMain.class.getResource("/iconBox/Main.gif")));
			label_3.setHorizontalAlignment(SwingConstants.LEFT);
			label_3.setFocusCycleRoot(true);
			label_3.setAlignmentY(0.0f);
			label_3.setBounds(9, 1, 927, 662);
		}
		return label_3;
	}
}
