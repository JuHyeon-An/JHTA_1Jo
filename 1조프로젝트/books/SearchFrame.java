package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class SearchFrame extends JInternalFrame {
	j_BookManagement bm = new j_BookManagement();
	j_BookDao dao = new j_BookDao();
	private JPanel panel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame frame = new SearchFrame();
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
	public SearchFrame(String find, int selectedValue) {
		this();
		bm.getTextField().setText(find); // 검색창에서 입력한 검색어 가져오기
		bm.getComboBox().setSelectedIndex(selectedValue); // 검색창 콤보박스 값 가져오기
		bm.search();
	}
	
	public SearchFrame() {
		super("검색", true, true, true, true);
		setPreferredSize(new Dimension(850, 560));
		setVisible(true);
		setBounds(100, 100, 850, 565);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
	}
	

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 834, 517);
			panel.setLayout(null);
			bm.getBtnNewButton_1().setVisible(false);
			bm.getButton().setBackground(new Color(176, 224, 230));
			bm.getComboBox().setBackground(new Color(176, 224, 230));
			bm.getTextField().setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			bm.getComboBox().setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			bm.getButton().setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			bm.getTable().setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
			bm.getTable().setBackground(Color.decode("#F7FAFC"));
			bm.getTable().getTableHeader().setBackground(Color.decode("#54B5BF"));
			bm.setBackground(new Color(240, 248, 255));
			panel.add(bm);
			bm.getTextField().setLocation(413, 54);
			bm.getButton().setLocation(723, 53);
			bm.getComboBox().setLocation(304, 54);
			bm.getScrollPane().setBounds(15, 97, 805, 382);
			bm.setBounds(0, 0, 834, 517);
			bm.setVisible(true);
			bm.updateUI();
			
		}
		return panel;
	}
}
