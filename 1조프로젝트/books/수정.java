package books;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ¼öÁ¤ extends JFrame {

	private JDesktopPane contentPane;
	private JLabel label;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel;
	public h_RentDao dao = new h_RentDao();
	private JLabel book1;
	private JLabel book2;
	private JLabel book3;
	private JLabel book4;
	private JLabel book5;

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

	public ¼öÁ¤() {
		setPreferredSize(new Dimension(900, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 900);
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
	
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC911\uC559HTA \uB3C4\uC11C\uAD00");
			label.setBounds(55, 63, 814, 84);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 45));
		}
		return label;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(66, 231, 93, 36);
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
			textField.setBounds(171, 232, 581, 36);
			textField.setColumns(10);
		}
		return textField;
	}
	
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uAC80\uC0C9");
			button.setBounds(764, 231, 97, 36);
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
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				UserLogin ul = new UserLogin();
				contentPane.add(ul);
				ul.toFront();
					
				}
			});
			button_1.setBounds(66, 328, 388, 46);
			button_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		}
		return button_1;
	}
	public JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					j_ManagerLogin ul = new j_ManagerLogin();
					contentPane.add(ul);
					ul.toFront();
				
				}
			});
			button_2.setBounds(473, 328, 388, 46);
			button_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		}
		return button_2;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uACF5\uC9C0\uC0AC\uD56D");
			label_1.setBounds(66, 436, 388, 36);
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		}
		return label_1;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uBCA0\uC2A4\uD2B8\uC140\uB7EC");
			label_2.setBounds(481, 436, 388, 36);
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 26));
		}
		return label_2;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(950, 800));
			panel.setBounds(0, 0, 934, 852);
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getComboBox());
			panel.add(getTextField());
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getButton_2());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getBook1());
			panel.add(getBook2());
			panel.add(getBook3());
			panel.add(getBook4());
			panel.add(getBook5());
		}
		return panel;
	}
	public JLabel getBook1() {
		if (book1 == null) {
			book1 = new JLabel("book1");
			book1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 24));
			book1.setBounds(489, 506, 338, 54);
		}
		return book1;
	}
	public JLabel getBook2() {
		if (book2 == null) {
			book2 = new JLabel("book2");
			book2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 24));
			book2.setBounds(489, 568, 338, 54);
		}
		return book2;
	}
	public JLabel getBook3() {
		if (book3 == null) {
			book3 = new JLabel("book3");
			book3.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 24));
			book3.setBounds(489, 632, 338, 54);
		}
		return book3;
	}
	public JLabel getBook4() {
		if (book4 == null) {
			book4 = new JLabel("book4");
			book4.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 24));
			book4.setBounds(489, 696, 338, 54);
		}
		return book4;
	}
	public JLabel getBook5() {
		if (book5 == null) {
			book5 = new JLabel("book5");
			book5.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 24));
			book5.setBounds(489, 752, 338, 54);
		}
		return book5;
	}
}
