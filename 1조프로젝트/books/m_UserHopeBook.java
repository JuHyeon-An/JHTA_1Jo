package books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(144, 40, 310, 15);
		}
		return label_1;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCC45\uC774\uB984");
			lblNewLabel.setBounds(64, 115, 57, 15);
		}
		return lblNewLabel;
	}

	public JTextField getBName() {
		if (bName == null) {
			bName = new JTextField();
			bName.setBounds(163, 112, 282, 21);
			bName.setColumns(10);
		}
		return bName;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC800\uC790");
			lblNewLabel_1.setBounds(64, 191, 57, 15);
		}
		return lblNewLabel_1;
	}

	public JTextField getWriter() {
		if (writer == null) {
			writer = new JTextField();
			writer.setBounds(163, 188, 282, 21);
			writer.setColumns(10);
		}
		return writer;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
			lblNewLabel_2.setBounds(64, 263, 57, 15);
		}
		return lblNewLabel_2;
	}

	public JTextField getPub() {
		if (pub == null) {
			pub = new JTextField();
			pub.setBounds(165, 260, 282, 21);
			pub.setColumns(10);
		}
		return pub;
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E0\uCCAD");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 희망도서 신청 버튼 누르면

					m_HopeBookVo vo = new m_HopeBookVo();
					vo.setbName(bName.getText());
					vo.setbWriter(writer.getText());
					vo.setPubl(pub.getText());
					j_BookDao dao = new j_BookDao();
					int r = dao.hopeBookInsert(vo,keyId);
					
					if(r>0) msg = "신청완료";
					else msg = "신청 오류";
					dm = new DialogMessage(msg);
					dm.setLocationRelativeTo(m_UserHopeBook.this);

				}
			});
			btnNewButton.setBounds(177, 366, 214, 107);
		}
		return btnNewButton;
	}
}
