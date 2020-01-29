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
import javax.swing.JSeparator;

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
	private JSeparator separator;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	public m_UserHopeBook() {
		setBackground(new Color(240, 248, 255));
		setPreferredSize(new Dimension(841, 556));
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
		add(getSeparator());
		add(getLabel_2());
		add(getLabel_3());
		add(getLabel_4());
		add(getLabel_5());
		add(getLabel_6());
		add(getLabel_7());
		add(getLabel_8());
		add(getBtnNewButton_1());
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
			label_1.setBounds(51, 102, 310, 58);
		}
		return label_1;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCC45\uC774\uB984");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			lblNewLabel.setBounds(23, 221, 52, 15);
		}
		return lblNewLabel;
	}

	public JTextField getBName() {
		if (bName == null) {
			bName = new JTextField();
			bName.setFont(new Font("³ª´®°íµñ Light", Font.PLAIN, 16));
			bName.setBounds(84, 210, 282, 37);
			bName.setColumns(10);
		}
		return bName;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC800\uC790");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(4, 262, 71, 30);
		}
		return lblNewLabel_1;
	}

	public JTextField getWriter() {
		if (writer == null) {
			writer = new JTextField();
			writer.setFont(new Font("³ª´®°íµñ Light", Font.PLAIN, 16));
			writer.setBounds(84, 259, 282, 37);
			writer.setColumns(10);
		}
		return writer;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(-12, 311, 87, 30);
		}
		return lblNewLabel_2;
	}

	public JTextField getPub() {
		if (pub == null) {
			pub = new JTextField();
			pub.setFont(new Font("³ª´®°íµñ Light", Font.PLAIN, 16));
			pub.setBounds(84, 308, 282, 37);
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
					
					if(r>0) {
						msg = "½ÅÃ»ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.";
						bName.setText("");
						writer.setText("");
						pub.setText("");
					}
					else msg = "½ÅÃ» Áß ¿À·ù°¡ ¹ß»ýÇß½À´Ï´Ù.";
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(m_UserHopeBook.this);

				}
			});
			btnNewButton.setBounds(159, 405, 139, 44);
		}
		return btnNewButton;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(415, 80, 8, 425);
		}
		return separator;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC2E0\uCCAD\uBC29\uBC95");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 34));
			label_2.setBounds(467, 102, 310, 58);
		}
		return label_2;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(m_UserHopeBook.class.getResource("/iconBox/loupe.png")));
			label_3.setBounds(437, 172, 97, 92);
		}
		return label_3;
	}
	public JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon(m_UserHopeBook.class.getResource("/iconBox/clipboard.png")));
			label_4.setBounds(437, 306, 97, 92);
		}
		return label_4;
	}
	public JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(m_UserHopeBook.class.getResource("/iconBox/book (3).png")));
			label_5.setBounds(405, 398, 119, 92);
		}
		return label_5;
	}
	public JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uC790\uB8CC\uAC80\uC0C9 \uBC0F \uC18C\uC7A5\uC5EC\uBD80 \uD655\uC778");
			label_6.setHorizontalAlignment(SwingConstants.LEFT);
			label_6.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
			label_6.setBounds(517, 185, 310, 58);
		}
		return label_6;
	}
	public JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uAC80\uC0C9\uC790\uB8CC\uAC00 \uC5C6\uC744 \uACBD\uC6B0, \r\n\uBE44\uCE58\uD76C\uB9DD\uB3C4\uC11C \uC2E0\uCCAD");
			label_7.setHorizontalAlignment(SwingConstants.LEFT);
			label_7.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
			label_7.setBounds(517, 328, 310, 58);
		}
		return label_7;
	}
	public JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("\uC2E0\uCCAD\uC644\uB8CC!");
			label_8.setHorizontalAlignment(SwingConstants.LEFT);
			label_8.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
			label_8.setBounds(517, 429, 310, 58);
		}
		return label_8;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uAC80\uC0C9 \uBC14\uB85C\uAC00\uAE30");
			
			btnNewButton_1.setBackground(new Color(176, 224, 230));
			btnNewButton_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 18));
			btnNewButton_1.setBounds(517, 249, 139, 27);
		}
		return btnNewButton_1;
	}
}
