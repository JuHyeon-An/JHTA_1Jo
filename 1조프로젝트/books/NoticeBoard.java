package books;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.Color;

public class NoticeBoard extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JTextField tTitle;
	private JTextField tWriter;
	private JTextField tDate;
	private JScrollPane scrollPane;
	private JEditorPane editorPane;
	j_BookDao dao;
	j_noticeVo vo;
	int serial;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NoticeBoard frame = new NoticeBoard(serial);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public NoticeBoard(int serial) {
		super("°øÁö»çÇ×", true, true, true, true);
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
		this.serial = serial;
		setVisible(true);
		setTitle("\uACF5\uC9C0\uC0AC\uD56D");
		setBounds(100, 100, 566, 466);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLabel());
		getContentPane().add(getLabel_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getTTitle());
		getContentPane().add(getTWriter());
		getContentPane().add(getTDate());
		
		dao = new j_BookDao();
		vo = dao.notice(serial);
		tTitle.setText(vo.getTitle());
		tWriter.setText(vo.getWriter());
		tDate.setText(vo.getRegDate());
		editorPane.setText(vo.getContents());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC81C\uBAA9");
			lblNewLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(14, 12, 62, 18);
		}
		return lblNewLabel;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uAE00\uC4F4\uC774");
			label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(14, 42, 62, 18);
		}
		return label;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uB0A0\uC9DC");
			label_1.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(14, 72, 62, 18);
		}
		return label_1;
	}
	public JTextField getTTitle() {
		if (tTitle == null) {
			tTitle = new JTextField();
			tTitle.setEditable(false);
			tTitle.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			tTitle.setBounds(90, 9, 443, 24);
			tTitle.setColumns(10);
		}
		return tTitle;
	}
	public JTextField getTWriter() {
		if (tWriter == null) {
			tWriter = new JTextField();
			tWriter.setEditable(false);
			tWriter.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			tWriter.setColumns(10);
			tWriter.setBounds(90, 39, 443, 24);
		}
		return tWriter;
	}
	public JTextField getTDate() {
		if (tDate == null) {
			tDate = new JTextField();
			tDate.setEditable(false);
			tDate.setFont(new Font("³ª´®¹Ù¸¥°íµñ Light", Font.PLAIN, 15));
			tDate.setColumns(10);
			tDate.setBounds(90, 72, 443, 24);
		}
		return tDate;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(14, 102, 522, 316);
			JViewport jv = scrollPane.getViewport();
			jv.setViewPosition(new Point(0,0));
			scrollPane.setViewportView(getEditorPane());
		}
		return scrollPane;
	}
	public JEditorPane getEditorPane() {
		if (editorPane == null) {
			editorPane = new JEditorPane();
			editorPane.setBackground(new Color(248, 248, 255));
			editorPane.setEditable(false);
			editorPane.setAutoscrolls(false);
			editorPane.setContentType("HTML");
			editorPane.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 15));
			editorPane.setEditorKit(new HTMLEditorKit());
			editorPane.setCaretPosition(0);
			
		}
		return editorPane;
	}
}
