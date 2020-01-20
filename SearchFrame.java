package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class SearchFrame extends JInternalFrame {
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
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
	public SearchFrame() {
		setBounds(100, 100, 955, 643);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getPanel());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAC80\uC0C9");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(14, 12, 911, 50);
		}
		return lblNewLabel;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(14, 74, 911, 521);
			BookManagement bm = new BookManagement();
			panel.add(bm);
			panel.setVisible(true);
		}
		return panel;
	}
}
