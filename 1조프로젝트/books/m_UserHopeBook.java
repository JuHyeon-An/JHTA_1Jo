package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class m_UserHopeBook extends JPanel {
	private DialogMessage dm;
	private String msg = "";
	String keyId;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JTextField bName;
	private JLabel lblNewLabel_1;
	private JTextField writer;
	private JLabel lblNewLabel_2;
	private JTextField pub;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public m_UserHopeBook() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(630, 490));
		setLayout(null);
		add(getLabel());
		add(getLabel_1());
		add(getLblNewLabel());
		add(getBName());
		add(getLblNewLabel_1());
		add(getWriter());
		add(getLblNewLabel_2());
		add(getPub());
		add(getBtnNewButton());
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(m_UserHopeBook.class.getResource("/iconBox/seo-and-web.png")));
		lblNewLabel_3.setBounds(477, 322, 139, 131);
		add(lblNewLabel_3);
	}

	public m_UserHopeBook(String keyId) {
		this();
		this.keyId = keyId;
	}

	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(318, 5, 0, 0);
		}
		return label;
	}

	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uD76C\uB9DD \uB3C4\uC11C \uC2E0\uCCAD");
			label_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 34));
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(144, 27, 310, 58);
		}
		return label_1;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCC45\uC774\uB984");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			lblNewLabel.setBounds(97, 131, 52, 15);
		}
		return lblNewLabel;
	}

	public JTextField getBName() {
		if (bName == null) {
			bName = new JTextField();
			bName.setFont(new Font("³ª´®°íµñ Light", Font.PLAIN, 16));
			bName.setBounds(163, 120, 302, 37);
			bName.setColumns(10);
		}
		return bName;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC800\uC790");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(78, 199, 71, 30);
		}
		return lblNewLabel_1;
	}

	public JTextField getWriter() {
		if (writer == null) {
			writer = new JTextField();
			writer.setFont(new Font("³ª´®°íµñ Light", Font.PLAIN, 16));
			writer.setBounds(163, 196, 302, 37);
			writer.setColumns(10);
		}
		return writer;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(67, 280, 87, 30);
		}
		return lblNewLabel_2;
	}

	public JTextField getPub() {
		if (pub == null) {
			pub = new JTextField();
			pub.setFont(new Font("³ª´®°íµñ Light", Font.PLAIN, 16));
			pub.setBounds(163, 277, 302, 37);
			pub.setColumns(10);
		}
		return pub;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E0\uCCAD");
			btnNewButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
			btnNewButton.setBackground(new Color(176, 224, 230));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Èñ¸Áµµ¼­ ½ÅÃ» ¹öÆ° ´©¸£¸é

					m_HopeBookVo vo = new m_HopeBookVo();
					vo.setbName(bName.getText());
					vo.setbWriter(writer.getText());
					vo.setPubl(pub.getText());
					j_BookDao dao = new j_BookDao();
					int r = dao.hopeBookInsert(vo,keyId);
					
					if(r>0) msg = "½ÅÃ»¿Ï·á";
					else msg = "½ÅÃ» ¿À·ù";
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(m_UserHopeBook.this);

				}
			});
			btnNewButton.setBounds(214, 368, 179, 58);
		}
		return btnNewButton;
	}
}
