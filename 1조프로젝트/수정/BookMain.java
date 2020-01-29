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
import javax.swing.ImageIcon;

public class BookMain extends JFrame {

	private JDesktopPane contentPane;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton button;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
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
		setTitle("\uCC45\uC77D\uB294\uC11C\uC6B8 \uC911\uC559HTA\uB3C4\uC11C\uAD00");
		setPreferredSize(new Dimension(927, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 695);
		contentPane = new JDesktopPane();
		contentPane.setPreferredSize(new Dimension(950, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(79, 210, 93, 36);
			comboBox.addItem("전체");
			comboBox.addItem("서명");
			comboBox.addItem("저자");
			comboBox.addItem("출판사");
		}
		return comboBox;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(184, 211, 562, 36);
			textField.setColumns(10);
		}
		return textField;
	}
	
	public JButton getButton() {
		if (button == null) {
			button = new JButton("\uAC80\uC0C9");
			button.setBounds(756, 210, 80, 36);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					String find = textField.getText();
					SearchFrame sf = new SearchFrame(find, comboBox.getSelectedIndex());
					contentPane.add(sf);
					sf.toFront();
				
				
				}
			});
		}
		return button;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(950, 800));
			panel.setBounds(0, 0, 927, 662);
			panel.setLayout(null);
			panel.add(getComboBox());
			panel.add(getTextField());
			panel.add(getButton());
			panel.add(getBtnNewButton());
			panel.add(getButton_2());
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setFocusCycleRoot(true);
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setAlignmentY(0.0f);
			lblNewLabel.setIcon(new ImageIcon(BookMain.class.getResource("/iconBox/Main.gif")));
			lblNewLabel.setBounds(0, 0, 927, 662);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UserLogin ul = new UserLogin();
					contentPane.add(ul);
					ul.toFront();
					
				}
			});
			btnNewButton.setIcon(new ImageIcon(BookMain.class.getResource("/iconBox/01.png")));
			btnNewButton.setBounds(61, 301, 368, 48);
		}
		return btnNewButton;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					j_ManagerLogin ul = new j_ManagerLogin();
					contentPane.add(ul);
					ul.toFront();
					
				}
			});
			button_2.setIcon(new ImageIcon(BookMain.class.getResource("/iconBox/02.png")));
			button_2.setBounds(482, 301, 368, 48);
		}
		return button_2;
	}
}
